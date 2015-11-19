package ch.gmazlami.gifty.postgres.services;

import java.util.List;

import ch.gmazlami.gifty.exceptions.GiftNotFoundException;
import ch.gmazlami.gifty.exceptions.NoSuchUserException;
import ch.gmazlami.gifty.models.gift.Gift;

public interface IGiftService {

	void postGift(Gift gift, Long userId) throws NoSuchUserException;
	
	Gift getGiftById(Long id) throws GiftNotFoundException;
	
	List<Gift> getGiftsByUserId(Long userId) throws NoSuchUserException;
	
	
	
}
