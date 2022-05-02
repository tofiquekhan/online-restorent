 package com.webkorps.onlinerestorent.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.webkorps.onlinerestorent.entity.Client;
import com.webkorps.onlinerestorent.entity.Membership;
import com.webkorps.onlinerestorent.entity.MembershipPlan;
import com.webkorps.onlinerestorent.entity.Payment;
import com.webkorps.onlinerestorent.entity.RestroUserDetail;
import com.webkorps.onlinerestorent.entity.User;
import com.webkorps.onlinerestorent.repository.PaymentRepository;
import com.webkorps.onlinerestorent.service.ClientService;
import com.webkorps.onlinerestorent.service.MembershipPlanService;
import com.webkorps.onlinerestorent.service.PaymentService;
import com.webkorps.onlinerestorent.service.UserService;

//@Controller
@RestController
@RequestMapping("/public")
public class UserController {

//	@GetMapping
//	public String view() {
//		return "clientSignUp";
//	}
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private MembershipPlanService membershipPlanService;
		
	@GetMapping("/client/signup")
	public ModelAndView clientSignUpPage(ModelMap model) {
		List<MembershipPlan> membershipPlans = membershipPlanService.getMembershipPlans();
		model.addAttribute("membershipPlans", membershipPlans);
		return new ModelAndView("clientSignUp");
	}

	@GetMapping("/signin")
	public ModelAndView signInPage() {
		return new ModelAndView("clientSignIn");
	}
	
	@GetMapping("/user/signup")
	public ModelAndView userSignUpPage(Model model) {
//		User user = new User();
//		model.addAttribute("user", user);
		return new ModelAndView("userSignUp","user",new User());
	}
	
	@GetMapping("/admin/signup")
	public ModelAndView adminSignUpPage() {
		return new ModelAndView("adminSignUp");
	}
	
	@GetMapping("/forward")
	public ModelAndView forward(HttpSession session) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email = null;
		if (principal instanceof RestroUserDetail) {
		  email = ((RestroUserDetail)principal).getUsername();
		  System.out.println(email);
		} else {
		  email= principal.toString();
		  System.out.println("username : "+email);
		}
		User user = userService.getUserByEmail(email);
		if(user.getRole().equalsIgnoreCase("ROLE_CLIENT")) {
		Client client = clientService.getClientByUser(user);
		session.setAttribute("client", client);
		return new ModelAndView("addRestro");
		}else if(user.getRole().equalsIgnoreCase("ROLE_ADMIN")) {
			 return new ModelAndView("allClients");
		}else {
			session.setAttribute("user", user);
			return new ModelAndView("userHome");
		}
	}
	
	@PostMapping("/membership")
	public String createOrder(@RequestBody Map<String, Object> data) {
		System.out.println(data);
		 Long plan =Long.parseLong(data.get("plan").toString());
		 int amount = membershipPlanService.getMembershipPlanById(plan).getPrice();
		 
		 Order order = null;
		 try {
			RazorpayClient client =  new RazorpayClient("rzp_test_UhnY60lqwEEiCk", "VhSDCvot430e68jSjbr6pa0L");
			
			JSONObject ob  = new JSONObject();
			ob.put("amount", amount*100);
			ob.put("currency", "INR");
			ob.put("receipt", "tx_1234");
			
			order =  client.Orders.create(ob);
			System.out.println(order);
			
			Payment payment = new Payment();
			payment.setAmount(order.get("amount")+"");
			payment.setTransactionId(order.get("id"));
			payment.setPaymentStatus("created");
			payment.setTxTime(LocalDateTime.now());
			
			paymentRepository.save(payment);
		 
		 } catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return order.toString();
	}
	
	
	

	
	@PostMapping("/client/signup")
	public ModelAndView clientSignUp(@RequestParam(name = "name")String name,@RequestParam(name = "email")String email,@RequestParam(name = "password")String password,@RequestParam(name = "phoneNumber")String phoneNumber,@RequestParam(name = "orderId")String orderId,@RequestParam(name = "membershipPlan") String planId) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(bCryptPasswordEncoder.encode(password));
		user.setPhoneNumber(Long.parseLong(phoneNumber));
		user.setRole("ROLE_CLIENT");
		MembershipPlan membershipPlan = membershipPlanService.getMembershipPlanById(Long.parseLong(planId));
		Payment payment = paymentService.getPaymentByTransactionId(orderId);
		Membership membership = new Membership();
		membership.setPayment(payment);
		membership.setPurchaseDate(payment.getTxTime().toLocalDate());
		membership.setPrice(Integer.parseInt(payment.getAmount())/100);
		membership.setExpireDate(payment.getTxTime().toLocalDate().plusMonths(membershipPlan.getDays()/30));
		Client client = new Client();
		client.setUser(user);
		client.setMembership(membership);
		Client savedClientDto = clientService.addClient(client);
		
		return new ModelAndView("clientSignIn")  ;
	}

//	@PostMapping("/user/signup")
//	public ModelAndView userSignUp(@RequestParam(name = "name") String name,@RequestParam(name = "email")String email,@RequestParam(name = "password")String password) {
//		User user = new User();
//		user.setName(name);
//		user.setEmail(email);
//		user.setPassword(bCryptPasswordEncoder.encode(password));
//		user.setRole("ROLE_USER");
//		userService.addUser(user);
//		return new ModelAndView("clientSignIn")  ;
//	}

	
	@PostMapping("/user/signup")
	public ModelAndView userSignUp( @ModelAttribute("user") @Valid User user,BindingResult bindingResult) {
		System.out.println(bindingResult);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		userService.addUser(user);
		return new ModelAndView("clientSignIn")  ;
	}

	

	
	@PostMapping("/admin/signup")
	public ModelAndView adminSignUp(@RequestParam(name = "name")String name,@RequestParam(name = "email")String email,@RequestParam(name = "password")String password,@RequestParam(name = "phoneNumber") String phoneNumber) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(bCryptPasswordEncoder.encode(password));
		user.setPhoneNumber(Long.parseLong(phoneNumber));
		user.setRole("ROLE_ADMIN");
		userService.addUser(user);
		return new ModelAndView("clientSignIn")  ;
	}











}
