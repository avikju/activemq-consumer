package com.avik.activemq.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.avik.activemq.consumer.model.Product;

@Component
public class ConsumerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

	@Scheduled
	@JmsListener(destination = "${activemq.queue.name}")
	public void consumeMessages(Product product) {
		LOGGER.info("Consumed : "+product);
	}
}
