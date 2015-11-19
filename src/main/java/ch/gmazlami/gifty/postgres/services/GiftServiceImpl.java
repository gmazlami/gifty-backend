package ch.gmazlami.gifty.postgres.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.gmazlami.gifty.exceptions.GiftNotFoundException;
import ch.gmazlami.gifty.exceptions.NoSuchUserException;
import ch.gmazlami.gifty.models.gift.Gift;
import ch.gmazlami.gifty.models.gift.GiftStatus;
import ch.gmazlami.gifty.postgres.repositories.GiftRepository;
import ch.gmazlami.gifty.postgres.repositories.UserRepository;

@Service
public class GiftServiceImpl implements IGiftService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	GiftRepository giftRepository;
	
	
	@Override
	public void postGift(Gift gift, Long userId) throws NoSuchUserException{
		//check if the user with said userId exists
		if(userRepository.findById(userId) == null){
			throw new NoSuchUserException(userId);
		}else{
			gift.setUserId(userId);
			giftRepository.save(gift);
		}
	}

	@Override
	public Gift getGiftById(Long id) throws GiftNotFoundException {
		Gift gift = giftRepository.findById(id);
		if(gift == null){
			throw new GiftNotFoundException(id);
		}else{
			return gift;
		}
	}

	@Override
	public List<Gift> getGiftsByUserId(Long userId) throws NoSuchUserException {
		//check if the user with said userId exists
		if(userRepository.findById(userId) == null){
			throw new NoSuchUserException(userId);
		}else{
			return giftRepository.findByUserId(userId);
		}
	}

	@Override
	public void updateGiftStatus(Long giftId, GiftStatus status, Long userId) throws GiftNotFoundException, NoSuchUserException {
		//check if the user with said userId exists
		if(userRepository.findById(userId) == null){
			throw new NoSuchUserException(userId);
		}
		
		Gift gift = giftRepository.findById(giftId);
		
		if(gift == null){
			throw new GiftNotFoundException(giftId);
		}
		
		gift.setStatus(status);
		
		giftRepository.save(gift);
			
	}

}
