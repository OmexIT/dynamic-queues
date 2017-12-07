package com.omexit.dynamicqueues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "amq")
public class ActiveMQController {

	@Autowired
	private AMQHelper amqHelper;

	@RequestMapping(value = "send", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> sendMsg(@RequestParam("channel") String channel) {
		amqHelper.sendMessage("default."+channel, "This is a test message");

		return new ResponseEntity<>("The message has been sent to JMS.", HttpStatus.OK);
	}
}
