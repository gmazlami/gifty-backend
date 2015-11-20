package ch.gmazlami.gifty.postgres.services;

import ch.gmazlami.gifty.exceptions.NoSuchPhoneNumberException;
import ch.gmazlami.gifty.exceptions.NoSuchUserException;
import ch.gmazlami.gifty.models.user.User;

public interface IUserService {

	User getUserById(Long id) throws NoSuchUserException;
	
	User getUserByPhoneNumber(String phoneNumber) throws NoSuchPhoneNumberException;
	
	void deleteUser(Long userId);
	
	void postUser(User user);
}
