package com.pranav.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.pranav.entities.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JsonKafkaConsumer {

	/*
	 * Group Id we pass in the application.properties
	 * topic name we passed in the KafkaTopicConfig class 
	 */
	@KafkaListener(topics = "userMessage", groupId = "myGroup")
	public void consume(User message)
	{
		log.info("---------Message Received -->"+ message);
	}
}
