package com.microservice.payroll.controller;

import java.util.List;

import com.microservice.payroll.model.PaymentModel;
import com.microservice.payroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(path = "/payments")
public class PaymentController {

    private static final String OPS = "OPS... parece que o tempo acabou!";

    @Autowired
    private PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "getPaymentFail")
    @RequestMapping(path = "{id}/days/{days}")
    public ResponseEntity<PaymentModel> getPayment(@PathVariable Long id, @PathVariable Integer days) {
        return ResponseEntity.ok(paymentService.getPayment(id, days));
    }

    public ResponseEntity<PaymentModel> getPaymentFail() {
        PaymentModel payment = new PaymentModel();
        return ResponseEntity.ok(payment);
    }
    
}
