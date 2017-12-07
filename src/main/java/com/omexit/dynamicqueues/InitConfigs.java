package com.omexit.dynamicqueues;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public class InitConfigs {
	@Autowired
	@Qualifier("paymentChannelResolver")
	DynamicAMQChannelResolver amqChannelResolver;

	@PostConstruct
	public void init() {
		amqChannelResolver.createPaymentChannel("default.mpesa", "tcp://localhost:32768");
		amqChannelResolver.createPaymentChannel("default.beyonic", "tcp://localhost:32768");
		amqChannelResolver.createPaymentChannel("default.airtel", "tcp://localhost:32768");

//		LinkedHashMap<String, MessageChannel> channels = amqChannelResolver.getChannels();
//
//		for (Map.Entry<String, MessageChannel> entry : channels.entrySet()) {
//			System.err.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
//		}
//
//		try {
//			System.err.println(amqChannelResolver.resolve("default.mpesa"));
//		} catch (ChannelNotFoundException e) {
//			System.err.println(e.getMessage());
//		}
	}
}