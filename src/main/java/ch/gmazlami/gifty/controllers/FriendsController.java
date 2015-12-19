package ch.gmazlami.gifty.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.gmazlami.gifty.exceptions.NoSuchUserException;
import ch.gmazlami.gifty.models.friends.Friends;
import ch.gmazlami.gifty.postgres.services.IFriendService;

@RestController
public class FriendsController {
	
	@Autowired
	IFriendService friendService;
	

	/**
	 * Add a user determined by friendPhoneNumber as my friend
	 * @param myId
	 * @param friendPhoneNumber
	 * @return
	 */
	@RequestMapping(value="/friends/{myId}", method=RequestMethod.POST)
	public ResponseEntity<Friends> postFriend(@PathVariable("myId") Long myId, @RequestParam("friendPhoneNumber") String friendPhoneNumber){
		try{
			Friends friends = friendService.addFriend(myId, friendPhoneNumber);
			return new ResponseEntity<Friends>(friends, HttpStatus.OK);
		}catch(NoSuchUserException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Remove my friend with the number friendPhoneNumber
	 * @param myId
	 * @param friendPhoneNumber
	 * @return
	 */
	@RequestMapping(value="/friends/{myId}", method=RequestMethod.DELETE)
	public ResponseEntity<Friends> removeFriend(@PathVariable("myId") Long myId, @RequestParam("friendPhoneNumber") String friendPhoneNumber){
		try{
			friendService.removeFriend(myId, friendPhoneNumber);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchUserException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Returns a list of all the friends of the user with id myId
	 * @param myId
	 * @return
	 */
	@RequestMapping(value="/friends-all/{myId}", method=RequestMethod.GET)
	public ResponseEntity<List<Friends>> getAllFriends(@PathVariable("myId") Long myId){
		try{
			return new ResponseEntity<List<Friends>>(friendService.getFriendList(myId),HttpStatus.OK);
		}catch(NoSuchUserException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
