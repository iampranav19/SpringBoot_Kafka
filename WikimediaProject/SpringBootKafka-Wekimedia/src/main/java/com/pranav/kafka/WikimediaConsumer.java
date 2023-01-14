package com.pranav.kafka;

import org.springframework.kafka.annotation.KafkaListener;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WikimediaConsumer {

	@KafkaListener(topics = "wikimedia",groupId = "myGroup")
	public void consume(String message)
	{
		log.info("Reading Messages =======>>"+message);
	}
	 
}
