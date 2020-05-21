package com.kafka.poc.sender;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.kafka.poc.dto.request.EmployeeRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Sender {

	private static final String TOPIC = "EMP_TOPIC";

	@Autowired
	private KafkaTemplate<String, EmployeeRequest> kafkaTemplate;

	public long send(EmployeeRequest request) throws InterruptedException, ExecutionException {
		log.info("pushing event to create employee : {}", request.getName());
		ListenableFuture<SendResult<String, EmployeeRequest>> future = kafkaTemplate.send(TOPIC, request);
		long offset = future.get().getRecordMetadata().offset();
		future.addCallback(new ListenableFutureCallback<SendResult<String, EmployeeRequest>>() {

			@Override
			public void onSuccess(SendResult<String, EmployeeRequest> result) {
				log.info("published event : {} with offset : {}", request.getName(), offset);	
			}

			@Override
			public void onFailure(Throwable ex) {
				log.error("pushing event to create employee : {}  failed due to : {}", request.getName(), ex.getMessage());
			}
		});
		return offset;
	}

}
