package com.microservice.payroll.services;

import com.microservice.payroll.feignclients.WorkerFeignCLient;
import com.microservice.payroll.model.PaymentModel;
import com.microservice.payroll.model.Worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignCLient workerFeignClient;

    public PaymentModel getPayment(long workerId, int days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new PaymentModel(worker.getName(), worker.getDailyIncome(), days);
    }
    
}
