package com.pranav.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.pranav.entities.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JsonKafkaProducer {

	
	private KafkaTemplate<String,User> kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User data)
	{
		log.info("Message Sent ::"+data);
		Message<User> msessage= MessageBuilder
								.withPayload(data)
								.setHeader(KafkaHeaders.TOPIC, "userMessage")
								.build();
		kafkaTemplate.send(msessage);
	}
	
	
	
}
