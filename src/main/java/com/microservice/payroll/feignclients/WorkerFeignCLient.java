package com.microservice.payroll.feignclients;

import com.microservice.payroll.model.Worker;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "ms-worker", path = "/api/workers")
public interface WorkerFeignCLient {
    
    @GetMapping(path = "/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
}
