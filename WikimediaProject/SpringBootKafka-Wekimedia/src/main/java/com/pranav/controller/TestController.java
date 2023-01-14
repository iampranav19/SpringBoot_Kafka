package com.pranav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.kafka.WikimediaProducer;

@RestController
public class TestController {

	@Autowired
	private WikimediaProducer wikimediaProducer;
	
	@GetMapping("/test")
	public String test() throws InterruptedException
	{
		wikimediaProducer.sendMessage();
		return "DONE!";
	}
}
