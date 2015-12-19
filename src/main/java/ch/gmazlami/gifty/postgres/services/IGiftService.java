package ch.gmazlami.gifty.postgres.services;

import java.util.List;

import ch.gmazlami.gifty.exceptions.GiftNotFoundException;
import ch.gmazlami.gifty.exceptions.NoSuchUserException;
import ch.gmazlami.gifty.models.gift.Gift;
import ch.gmazlami.gifty.models.gift.GiftStatus;

public interface IGiftService {

	Gift postGift(Gift gift, String phoneNumber) throws NoSuchUserException;
	
	Gift updateGiftStatus(Long giftId, GiftStatus status) throws GiftNotFoundException;
	
	void deleteGift(Long giftId);
	
	Gift getGiftById(Long id) throws GiftNotFoundException;
	
	
	List<Gift> getGiftsByPhoneNumber(String phoneNumber) throws NoSuchUserException;

	
	
	
}
