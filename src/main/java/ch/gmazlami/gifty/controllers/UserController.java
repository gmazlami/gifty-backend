package ch.gmazlami.gifty.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.gmazlami.gifty.models.user.Birthday;
import ch.gmazlami.gifty.models.user.User;

@RestController
public class UserController {

	@RequestMapping(value="/user", method=RequestMethod.GET)
	public User getUser(){
		User user = new User();
		user.setFirstName("Genc");
		user.setLastName("Mazlami");
		user.setPhoneNumber("+41764222719");
		user.setId("someblablaid");
		user.setBirthday(new Birthday(27, 8, 1990));
		user.setCountry("CH");
		return user;
	}
	
}
