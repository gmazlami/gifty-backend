package ch.gmazlami.gifty.postgres.repositories;

import org.springframework.data.repository.CrudRepository;

import ch.gmazlami.gifty.models.friends.Friends;

public interface FriendsRepository extends CrudRepository<Friends, Long> {

}
