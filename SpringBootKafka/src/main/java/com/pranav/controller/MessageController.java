package com.pranav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.kafka.KafkaProducer;

@RestController
public class MessageController {

	
	private KafkaProducer kafkaProducer;

	public MessageController(KafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}
	
	//localhost:8080/publish?message=hello world
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam(name = "message") String message)
	{
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent sucessfully");
	}
	
}
