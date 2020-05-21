package com.kafka.poc.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.poc.dto.request.EmployeeRequest;
import com.kafka.poc.sender.Sender;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1.0/employee")
@Slf4j
public class EmployeeController {
	
	@Autowired
	private Sender sender;
	@PostMapping
	public ResponseEntity<String> create(@RequestBody EmployeeRequest employee) throws InterruptedException, ExecutionException {
		log.info("request for create employee : {}", employee.getName());
		long offset = sender.send(employee);
		return ResponseEntity.ok().body("Message sent to queue with offset : " + offset);
	}

}
