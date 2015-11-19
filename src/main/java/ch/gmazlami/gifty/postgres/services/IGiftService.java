package ch.gmazlami.gifty.postgres.services;

import java.util.List;

import ch.gmazlami.gifty.exceptions.GiftNotFoundException;
import ch.gmazlami.gifty.exceptions.NoSuchUserException;
import ch.gmazlami.gifty.models.gift.Gift;
import ch.gmazlami.gifty.models.gift.GiftStatus;

public interface IGiftService {

	void postGift(Gift gift, Long userId) throws NoSuchUserException;
	
	void updateGiftStatus(Long giftId, GiftStatus status) throws GiftNotFoundException;
	
	void deleteGift(Long giftId);
	
	Gift getGiftById(Long id) throws GiftNotFoundException;
	
	List<Gift> getGiftsByUserId(Long userId) throws NoSuchUserException;
	
	
	
}
