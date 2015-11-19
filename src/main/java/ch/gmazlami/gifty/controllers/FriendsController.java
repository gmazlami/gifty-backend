package ch.gmazlami.gifty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.gmazlami.gifty.models.friends.Friends;
import ch.gmazlami.gifty.postgres.services.IFriendService;

@RestController
public class FriendsController {
	
	@Autowired
	IFriendService friendService;
	

	@RequestMapping(value="/friends", method=RequestMethod.POST)
	public ResponseEntity<Friends> postFriend(@RequestParam("userId") Long userId, @RequestParam("friendPhoneNumber") String friendPhoneNumber){

		boolean success = friendService.addFriend(userId, friendPhoneNumber);
		
		if(success){
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
