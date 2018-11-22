package com.co.bancolombia.juang.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.bancolombia.juang.model.User;
import com.co.bancolombia.juang.sender.Sender;

@RestController
@RequestMapping("kafka")
public class UserController {

	@Autowired
    Sender sender;

	private static final String TOPIC = "test";

	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") final String name) {
		sender.send(new User(name, "Technology", 12000L) );
		return "Published successfully: " + name;
	}

}
