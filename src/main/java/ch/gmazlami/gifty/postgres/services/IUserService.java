package ch.gmazlami.gifty.postgres.services;

import ch.gmazlami.gifty.models.user.User;

public interface IUserService {

	User getUserById(Long id);
	
	User getUserByPhoneNumber(String phoneNumber);
	
	void deleteUser(Long userId);
	
	void postUser(User user);
}
