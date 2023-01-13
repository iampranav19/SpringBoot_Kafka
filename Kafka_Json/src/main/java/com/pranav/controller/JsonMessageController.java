package com.pranav.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.entities.User;
import com.pranav.kafka.JsonKafkaProducer;

@RestController
public class JsonMessageController {

	private JsonKafkaProducer jsonKafkaProducer;

	public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
		super();
		this.jsonKafkaProducer = jsonKafkaProducer;
	}
	
	@PostMapping("/publish")
	ResponseEntity<String> publish(@RequestBody User user)
	{
		jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json Message Sent to Kafka Topic");
	}
}
