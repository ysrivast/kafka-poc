package com.kafka.poc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.poc.dto.request.EmployeeRequest;

@RestController
@RequestMapping("/api/v1.0/employee")
public class EmployeeController {
	
	@PostMapping
	public ResponseEntity<String> send(@RequestBody EmployeeRequest employee) {
		return ResponseEntity.ok().body("Message sent to queue");
	}

}
