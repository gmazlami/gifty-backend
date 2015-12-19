package ch.gmazlami.gifty.postgres.services;

import java.util.List;

import ch.gmazlami.gifty.exceptions.NoSuchUserException;
import ch.gmazlami.gifty.models.friends.Friends;

public interface IFriendService {

	Friends addFriend(Long userId, String friendPhoneNumber) throws NoSuchUserException;
	
	void removeFriend(Long userId, String friendPhoneNumber) throws NoSuchUserException;
	
	List<Friends> getFriendList(Long userId) throws NoSuchUserException;
}
