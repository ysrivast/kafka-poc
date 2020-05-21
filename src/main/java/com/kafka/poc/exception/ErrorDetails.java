package com.kafka.poc.exception;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor(staticName = "of")
public class ErrorDetails {
	private Date timestamp;
	private String message;
	private List<String> details;
}