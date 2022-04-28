package com.webkorps.onlinerestorent.service;

import com.webkorps.onlinerestorent.entity.Payment;

public interface PaymentService {

	Payment getPaymentByTransactionId(String txId);
}
