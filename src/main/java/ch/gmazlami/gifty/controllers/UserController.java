package ch.gmazlami.gifty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.gmazlami.gifty.models.user.User;
import ch.gmazlami.gifty.postgres.repositories.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repository;
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public User getUser(){
		User user = new User();
		user.setFirstName("Genc");
		user.setLastName("Mazlami");
		user.setPhoneNumber("+41764222719");
		user.setBirthday(new java.sql.Date(System.currentTimeMillis()));
		user.setCountry("CH");
		return repository.save(user);
	}
	
}
