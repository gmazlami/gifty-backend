package ch.gmazlami.gifty.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.gmazlami.gifty.models.gift.Gift;
import ch.gmazlami.gifty.models.gift.GiftStatus;

@RestController
public class GiftController {

	
	@RequestMapping(value="/gift", method=RequestMethod.GET)
	public Gift getGift(){
		Gift gift = new Gift(null, "+414222719", "Some demo description", "www.google.ch", GiftStatus.OPEN);
		return gift;
	}
	
	
	@RequestMapping(value="/gift", method=RequestMethod.POST)
	public Gift postGift(@RequestBody Gift gift){
		return gift;
	}
}
