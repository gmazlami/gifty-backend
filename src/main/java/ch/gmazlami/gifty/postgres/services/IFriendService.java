package ch.gmazlami.gifty.postgres.services;

public interface IFriendService {

	boolean addFriend(Long userId, String friendPhoneNumber);
}
