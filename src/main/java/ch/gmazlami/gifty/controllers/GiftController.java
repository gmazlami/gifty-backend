package ch.gmazlami.gifty.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	
	/**
	 * GET a list of gifts for the user with phoneNumber
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/gift", method=RequestMethod.GET)
	public ResponseEntity<List<Gift>> getGiftsForUser(@RequestParam("phoneNumber") String phoneNumber){
		try{
			return new ResponseEntity<List<Gift>>(giftService.getGiftsByPhoneNumber(phoneNumber), HttpStatus.OK);
		}catch(NoSuchUserException e){
			return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
		}

	}
	
	
	/**
	 * POST a new gift for user with myPhoneNumber
	 * @param gift
	 * @param myPhoneNumber
	 * @return
	 */
	@RequestMapping(value="/gift", method=RequestMethod.POST)
	public ResponseEntity<Gift> postGift(@RequestBody Gift gift, @RequestParam(value="myPhoneNumber") String myPhoneNumber){
		try{
			Gift savedGift = giftService.postGift(gift, myPhoneNumber);
			return new ResponseEntity<Gift>(savedGift,HttpStatus.OK);
		}catch(NoSuchUserException e){
			return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
		}
	}
	

	/**
	 * Updates the status of a gift 
	 * @param giftStatus : the new status
	 * @param giftId : the gift to be updated
	 * @return
	 */
	@RequestMapping(value="/gift", method=RequestMethod.PUT)
	public ResponseEntity<Gift> alterGiftStatus(@RequestParam GiftStatus giftStatus,@RequestParam Long giftId){
		try{
			Gift gift = giftService.updateGiftStatus(giftId, giftStatus);
			return new ResponseEntity<Gift>(gift,HttpStatus.OK);
		}catch(GiftNotFoundException e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	/**
	 * DELETE the gift with the specified id
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/gift/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Gift> deleteGift(@PathVariable Long id){
		giftService.deleteGift(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}


	
	
}
