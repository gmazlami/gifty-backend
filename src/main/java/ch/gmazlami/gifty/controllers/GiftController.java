package ch.gmazlami.gifty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.gmazlami.gifty.models.gift.Gift;
import ch.gmazlami.gifty.models.gift.GiftStatus;
import ch.gmazlami.gifty.mongodb.repositories.GiftRepository;

@RestController
public class GiftController {

	@Autowired
	private GiftRepository repository;
	
	@RequestMapping(value="/gift", method=RequestMethod.GET)
	public Gift getGift(){
		Gift gift = new Gift(null, "+414222719", "Some demo description", "www.google.ch", GiftStatus.OPEN);
		return gift;
	}
	
	
	@RequestMapping(value="/gift", method=RequestMethod.POST)
	public Gift postGift(@RequestBody Gift gift){
		repository.save(gift);
		return gift;
	}
}
