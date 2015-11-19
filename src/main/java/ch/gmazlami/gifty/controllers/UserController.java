package ch.gmazlami.gifty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.gmazlami.gifty.models.user.User;
import ch.gmazlami.gifty.postgres.repositories.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repository;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User getByPhoneNumber(@RequestParam String phoneNumber){
		User user = repository.findByPhoneNumber(phoneNumber);
		return user;
	}
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public User postUser(@RequestBody User user){
		return repository.save(user);
	}
	
}
