package ch.gmazlami.gifty.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ch.gmazlami.gifty.models.user.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	public User findByPhoneNumber(String phoneNumber);
	
}
