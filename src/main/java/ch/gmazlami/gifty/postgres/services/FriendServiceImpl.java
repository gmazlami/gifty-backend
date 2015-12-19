package ch.gmazlami.gifty.postgres.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.gmazlami.gifty.exceptions.NoSuchUserException;
import ch.gmazlami.gifty.models.friends.Friends;
import ch.gmazlami.gifty.models.user.User;
import ch.gmazlami.gifty.postgres.repositories.FriendsRepository;
import ch.gmazlami.gifty.postgres.repositories.UserRepository;

@Service
public class FriendServiceImpl implements IFriendService {

	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	FriendsRepository friendRepository;
	
	@Override
	public Friends addFriend(Long userId, String friendPhoneNumber) throws NoSuchUserException {
		User user = userRepository.findById(userId);
		User friend = userRepository.findByPhoneNumber(friendPhoneNumber);
		
		if(friend == null || user == null){
			throw new NoSuchUserException(friendPhoneNumber);
		}
		
		Friends friends = new Friends();
		friends.setUserA(user);
		friends.setUserB(friend);
		return friendRepository.save(friends);
	}

	
	@Override
	public void removeFriend(Long userId, String friendPhoneNumber) throws NoSuchUserException {
		User user = userRepository.findById(userId);
		User friend = userRepository.findByPhoneNumber(friendPhoneNumber);
		
		if(friend == null || user == null){
			throw new NoSuchUserException(friendPhoneNumber);
		}
		
		Friends friends = friendRepository.findByUserA_IdAndUserB_Id(user.getId(), friend.getId());
		friendRepository.delete(friends);
	}


	@Override
	public List<Friends> getFriendList(Long userId) throws NoSuchUserException {
		
		User user = userRepository.findById(userId);
		
		if(user == null){
			throw new NoSuchUserException(userId);
		}
		
		return friendRepository.findByUserA_Id(userId);
	}

}
