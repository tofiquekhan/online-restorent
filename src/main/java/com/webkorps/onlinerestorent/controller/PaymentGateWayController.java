package com.webkorps.onlinerestorent.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.webkorps.onlinerestorent.entity.Payment;
import com.webkorps.onlinerestorent.repository.PaymentRepository;

@RestController
public class PaymentGateWayController {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@PostMapping("/public/payment")
	public String payment(@RequestBody Map<String, Object> data) {
		System.out.println(data);
		 float totalAmount =Float.parseFloat(data.get("totalAmount").toString());
		 
		 Order order = null;
		 try {
			RazorpayClient client =  new RazorpayClient("rzp_test_UhnY60lqwEEiCk", "VhSDCvot430e68jSjbr6pa0L");
			
			JSONObject ob  = new JSONObject();
			ob.put("amount", totalAmount*100);
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
	
	
	
	@PostMapping("/public/updatePayment")
	public ResponseEntity<?> updatePayment(@RequestBody Map<String, Object> data){
		System.out.println("============Update Payment================");
		System.out.println(data);
		Payment myPayment =  paymentRepository.findByTransactionId(data.get("order_id").toString());
		myPayment.setPaymentStatus(data.get("ostatus").toString());
		paymentRepository.save(myPayment);
		Map map = new HashMap<String, String>();
		map.put("paymentId", myPayment.getId());
		map.put("status","success");
		return ResponseEntity.ok(map);
	}
	
	
	
	
}
