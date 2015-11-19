package ch.gmazlami.gifty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.gmazlami.gifty.models.gift.Gift;
import ch.gmazlami.gifty.models.gift.GiftStatus;
import ch.gmazlami.gifty.postgres.repositories.GiftRepository;
import ch.gmazlami.gifty.postgres.repositories.UserRepository;

@RestController
public class GiftController {

	@Autowired
	GiftRepository repository;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/gift", method=RequestMethod.GET)
	public Gift getGift(){
//		Gift gift = new Gift(null, "+414222719", "Some demo description", "www.google.ch", GiftStatus.OPEN);
//		return gift;
		
		return null;
	}
	
	
	@RequestMapping(value="/gift", method=RequestMethod.POST)
	public Gift postGift(@RequestBody Gift gift, @RequestHeader(value="User") Long userId){
		gift.setUser(userRepository.findById(userId));
		repository.save(gift); //TODO: add error handling if user doesnt exist
		return gift;
	}
}
