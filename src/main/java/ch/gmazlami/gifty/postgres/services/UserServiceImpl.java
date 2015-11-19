package ch.gmazlami.gifty.postgres.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.gmazlami.gifty.models.user.User;
import ch.gmazlami.gifty.postgres.repositories.GiftRepository;
import ch.gmazlami.gifty.postgres.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	GiftRepository giftRepository;
	
	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User getUserByPhoneNumber(String phoneNumber) {
		return userRepository.findByPhoneNumber(phoneNumber);
	}

	@Override
	public void postUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

}
