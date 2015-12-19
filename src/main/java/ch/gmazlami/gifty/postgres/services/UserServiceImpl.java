package ch.gmazlami.gifty.postgres.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.gmazlami.gifty.exceptions.NoSuchPhoneNumberException;
import ch.gmazlami.gifty.exceptions.NoSuchUserException;
import ch.gmazlami.gifty.models.user.User;
import ch.gmazlami.gifty.postgres.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUserById(Long id) throws NoSuchUserException{
		User user = userRepository.findById(id);
		
		if(user == null){
			throw new NoSuchUserException(id);
		}
		
		return userRepository.findById(id);
	}

	@Override
	public User getUserByPhoneNumber(String phoneNumber) throws NoSuchPhoneNumberException{
		User user = userRepository.findByPhoneNumber(phoneNumber);
		
		if(user == null){
			throw new NoSuchPhoneNumberException(phoneNumber);
		}
		
		return userRepository.findByPhoneNumber(phoneNumber);
	}

	@Override
	public User postUser(User user) {
		User existing = userRepository.findByPhoneNumber(user.getPhoneNumber());
		
		if(existing == null){
			return userRepository.save(user);
		}else{
			return existing;
		}
		
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

}
