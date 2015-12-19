package ch.gmazlami.gifty.postgres.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.gmazlami.gifty.models.friends.Friends;

public interface FriendsRepository extends CrudRepository<Friends, Long> {

	Friends findByUserA_IdAndUserB_Id(Long userAId, Long userBId);
	
	List<Friends> findByUserA_Id(Long userAId);
	
}
