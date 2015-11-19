package ch.gmazlami.gifty.postgres.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import ch.gmazlami.gifty.models.user.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long>{
}
