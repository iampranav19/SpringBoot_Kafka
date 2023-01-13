package com.pranav.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

	/*
	 * Group Id we pass in the application.properties
	 * topic name we passed in the KafkaTopicConfig class 
	 */
	@KafkaListener(topics = "kafka-example", groupId = "myGroup")
	public void consume(String message)
	{
		log.info("---------Message Received -->"+ message);
	}
}
