package com.webkorps.onlinerestorent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webkorps.onlinerestorent.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

	Payment findByTransactionId(String transactionId);
}
