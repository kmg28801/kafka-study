package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.io.IOException;

@Configuration
public class KafkaConsumer {

	@KafkaListener(topics = "tj-topic", groupId = "tj-topic")
	public void consume(String message) throws IOException {
		System.out.println(String.format("Consumed message : %s", message));
	}
}
