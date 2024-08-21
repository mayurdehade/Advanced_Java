package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService service;

	@GetMapping("/payment/{frmAcc}/{toAcc}/{amount}")
	public String doPayment(@PathVariable String frmAcc, @PathVariable String toAcc, @PathVariable double amount) {
		
		String msg = service.doPayment(frmAcc, toAcc, amount);
		return msg;
	}
}
