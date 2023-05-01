package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.KafkaProducer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
	private final KafkaProducer producer;

	@Autowired
	KafkaController(KafkaProducer producer) {
		this.producer = producer;
	}

	@PostMapping
	public String sendMessage(@RequestParam("message") String message) {
		this.producer.sendMessage(message);

		return "success";
	}
}
