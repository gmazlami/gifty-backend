package ch.gmazlami.gifty.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.gmazlami.gifty.exceptions.GiftNotFoundException;
import ch.gmazlami.gifty.exceptions.NoSuchUserException;
import ch.gmazlami.gifty.models.gift.Gift;
import ch.gmazlami.gifty.models.gift.GiftStatus;
import ch.gmazlami.gifty.postgres.services.IGiftService;

@RestController
public class GiftController {

	@Autowired
	IGiftService giftService;

	
	@RequestMapping(value="/gift", method=RequestMethod.GET)
	public ResponseEntity<List<Gift>> getGiftsForUser(@RequestParam("userId") Long userId){
		try{
			return new ResponseEntity<List<Gift>>(giftService.getGiftsByUserId(userId), HttpStatus.OK);
		}catch(NoSuchUserException e){
			return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
		}

	}
	
	
	@RequestMapping(value="/gift", method=RequestMethod.POST)
	public ResponseEntity<Gift> postGift(@RequestBody Gift gift, @RequestHeader(value="User") Long userId){
		try{
			giftService.postGift(gift, userId);
		}catch(NoSuchUserException e){
			return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

	
	@RequestMapping(value="/gift", method=RequestMethod.PUT)
	public ResponseEntity<Gift> alterGiftStatus(@RequestParam GiftStatus giftStatus,@RequestParam Long giftId, @RequestParam Long userId){
		try{
			giftService.updateGiftStatus(giftId, giftStatus);
		}catch(GiftNotFoundException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/gift/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Gift> deleteGift(@PathVariable Long giftId){
		giftService.deleteGift(giftId);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	
	
}
