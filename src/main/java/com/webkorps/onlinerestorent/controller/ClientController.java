 package com.webkorps.onlinerestorent.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.webkorps.onlinerestorent.dto.UserDto;
import com.webkorps.onlinerestorent.entity.Payment;
import com.webkorps.onlinerestorent.entity.User;
import com.webkorps.onlinerestorent.repository.PaymentRepository;
import com.webkorps.onlinerestorent.service.UserService;

//@Controller
@RestController
@RequestMapping("/user")
public class ClientController {

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
	
	final static int plan1 = 150;
	final static int plan2 = 290;
	final static int plan3 = 400;
	
	@GetMapping
	public ModelAndView clientSignUpPage() {
		return new ModelAndView("clientSignUp");
	}

	@GetMapping("/signin")
	public ModelAndView clientSignInPage() {
		return new ModelAndView("clientSignIn");
	}
	
	
	
	@PostMapping("/membership")
	public String createOrder(@RequestBody Map<String, Object> data) {
//		System.out.println("Hey order fucntion");
		System.out.println(data);
		 String plan = data.get("plan").toString();
		 int amount = 0;
		 if(plan.equalsIgnoreCase("plan1")) {
			 amount = plan1;
		 }
		 else if(plan.equalsIgnoreCase("plan2")) {
			 amount = plan2;
		 }
		 else if(plan.equalsIgnoreCase("plan3")) {
			 amount = plan3;
		 }
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
	
	@PostMapping("/updatePayment")
	public ResponseEntity<?> updatePayment(@RequestBody Map<String, Object> data){
		System.out.println("============Update Payment================");
		System.out.println(data);
		Payment myPayment =  paymentRepository.findByTransactionId(data.get("order_id").toString());
		myPayment.setPaymentStatus(data.get("ostatus").toString());
		paymentRepository.save(myPayment);
	
		return ResponseEntity.ok(Map.of("status","success"));
	}
	
	@PostMapping("/signup")
	public ModelAndView signUp(@RequestParam(name = "name")String name,@RequestParam(name = "email")String email,@RequestParam(name = "password")String password,@RequestParam(name = "phoneNumber")String phoneNumber) {
		System.out.println(email);
//		,@RequestParam(name = "role")String role
		UserDto userDto = new UserDto();
		userDto.setName(name);
		userDto.setEmail(email);
		userDto.setPassword(bCryptPasswordEncoder.encode(password));
		userDto.setPhoneNumber(Long.parseLong(phoneNumber));
		userDto.setRole("ROLE_CLIENT");
		UserDto savedUserDto = userService.addUser(userDto);
		return new ModelAndView("/addRestro");
	}


	











}
