package ch.gmazlami.gifty.postgres.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.gmazlami.gifty.models.user.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	User findByPhoneNumber(String phoneNumber);
	
	User findById(Long id);
	
	
}
