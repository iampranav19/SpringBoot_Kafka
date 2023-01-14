package com.pranav.kafka;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;


@Service
public class WikimediaProducer {

	private KafkaTemplate<String, String> kafkaTemplate;

	public WikimediaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage() throws InterruptedException
	{
		String topicName="wikimedia";
		
		// To read real time stream data from wikimedia, we use event source
		EventHandler eventHandler=new WikimediaChangesHandler(kafkaTemplate, topicName);
		String url="https://stream.wikimedia.org/v2/stream/recentchange";
		EventSource.Builder builder=new EventSource.Builder(eventHandler, URI.create(url));
		EventSource eventSource=builder.build();
		eventSource.start();
		
		TimeUnit.SECONDS.sleep(10);
		
	}
	
}
