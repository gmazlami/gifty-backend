package ch.gmazlami.gifty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.gmazlami.gifty.models.user.User;
import ch.gmazlami.gifty.postgres.repositories.UserRepository;
import ch.gmazlami.gifty.postgres.services.IUserService;

@RestController
public class UserController {

	@Autowired
	UserRepository repository;
	
	@Autowired
	IUserService userService;

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id){
		return userService.getUserById(id);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public User getByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber){
		return userService.getUserByPhoneNumber(phoneNumber);
	}
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public User postUser(@RequestBody User user){
		return repository.save(user);
	}
	
}
