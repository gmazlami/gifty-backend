package ch.gmazlami.gifty.postgres.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.gmazlami.gifty.postgres.repositories.FriendsRepository;
import ch.gmazlami.gifty.postgres.repositories.UserRepository;

@Service
public class FriendServiceImpl implements IFriendService {

	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	FriendsRepository friendRepository;
	
	@Override
	public boolean addFriend(Long userId, String friendPhoneNumber) {
//		User user = userRepository.findById(userId);
//		User friend = userRepository.findByPhoneNumber(friendPhoneNumber);
//		
//		if(friend == null){
//			return false;
//		}
//		
//		Friends friends = new Friends(user.getId(), friend.getId());
//		friendRepository.save(friends);

		return true;
	}

}
