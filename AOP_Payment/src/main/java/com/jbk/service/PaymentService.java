package com.jbk.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	
	
	public String doPayment(String frmAcc, String toAcc, double amount) {
		if(amount>0) {
			return "Payment Done";
		} else {
			throw new RuntimeException("Invalid Amount");
		}
	}
}
