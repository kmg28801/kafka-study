package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaProducer {
	private static final String TOPIC = "tj-topic2";
	private final KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	public KafkaProducer(KafkaTemplate kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		System.out.println(String.format("Produce message : %s", message));
		for (int i = 0; i < 10; i++) {
			this.kafkaTemplate.send(TOPIC, Integer.toString(i % 2 == 0 ? 1 : 2), message + Integer.toString(i));
		}
	}
}
