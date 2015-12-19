package ch.gmazlami.gifty.postgres.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.gmazlami.gifty.exceptions.GiftNotFoundException;
import ch.gmazlami.gifty.exceptions.NoSuchUserException;
import ch.gmazlami.gifty.models.gift.Gift;
import ch.gmazlami.gifty.models.gift.GiftStatus;
import ch.gmazlami.gifty.models.user.User;
import ch.gmazlami.gifty.postgres.repositories.GiftRepository;
import ch.gmazlami.gifty.postgres.repositories.UserRepository;

@Service
public class GiftServiceImpl implements IGiftService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	GiftRepository giftRepository;
	
	
	@Override
	public Gift postGift(Gift gift, String phoneNumber) throws NoSuchUserException{
		//check if the user with said phoneNumber exists
		
		User user = userRepository.findByPhoneNumber(phoneNumber);
		if(user == null){
			throw new NoSuchUserException(phoneNumber);
		}else{
			gift.setUser(user);
			return giftRepository.save(gift);
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
	public Gift updateGiftStatus(Long giftId, GiftStatus status) throws GiftNotFoundException {

		Gift gift = giftRepository.findById(giftId);
		
		if(gift == null){
			throw new GiftNotFoundException(giftId);
		}
		
		gift.setStatus(status);
		
		return giftRepository.save(gift);
			
	}

	@Override
	public void deleteGift(Long giftId){
		giftRepository.deleteById(giftId);
	}

	@Override
	public List<Gift> getGiftsByPhoneNumber(String phoneNumber) throws NoSuchUserException {
		
		//check if the user with said phoneNumber exists
		User user = userRepository.findByPhoneNumber(phoneNumber);
		
		if(user == null){
			throw new NoSuchUserException(phoneNumber);
		}else{
			return giftRepository.findByUser_Id(user.getId());
		}
	}

}
