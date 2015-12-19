package ch.gmazlami.gifty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.gmazlami.gifty.exceptions.NoSuchPhoneNumberException;
import ch.gmazlami.gifty.exceptions.NoSuchUserException;
import ch.gmazlami.gifty.models.user.User;
import ch.gmazlami.gifty.postgres.services.IUserService;

@RestController
public class UserController {

	@Autowired
	IUserService userService;

	/**
	 * GET a user by id
	 * @param {@link Long} id
	 * @return
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable Long id){
		try{
			return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
		}catch(NoSuchUserException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * GET a user by phoneNumber
	 * @param {@link String} phoneNumber
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<User> getByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber){
		try {
			return new ResponseEntity<User>(userService.getUserByPhoneNumber(phoneNumber),HttpStatus.OK);
		}catch(NoSuchPhoneNumberException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	/**
	 * Creates a new user according to the json object in the payload
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public ResponseEntity<User> postUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.postUser(user), HttpStatus.OK); 
	}

	/**
	 * DELETE the user with id id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
