package com.pranav.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaProducer {

	private KafkaTemplate<String, String> kafkaTemplate;

	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(String message)
	{
		log.info("Message Sent :::::"+message); 
		// Here Topic name must be same as we created in the KafkaTopicConfig class 
		kafkaTemplate.send("kafka-example", message);
	}
	
	
}
