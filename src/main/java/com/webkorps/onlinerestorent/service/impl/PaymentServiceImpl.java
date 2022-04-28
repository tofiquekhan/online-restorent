package com.webkorps.onlinerestorent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webkorps.onlinerestorent.entity.Payment;
import com.webkorps.onlinerestorent.repository.PaymentRepository;
import com.webkorps.onlinerestorent.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	
	public Payment getPaymentByTransactionId(String txId) {
		Payment payment = paymentRepository.findByTransactionId(txId);
		return payment;
	}
	
}
