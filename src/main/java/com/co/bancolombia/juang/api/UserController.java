package com.co.bancolombia.juang.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.bancolombia.juang.model.User;

@RestController
@RequestMapping("kafka")
public class UserController {

	@GetMapping("/publish/{name}")
	public String post(@PathVariable("name") final String name) {
		User user = new User(name, "Technology", 12000L);
		return "Published successfully: " + name;
	}

}
