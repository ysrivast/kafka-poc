package com.kafka.poc.dto.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
}
