package ch.gmazlami.gifty.postgres.repositories;

import org.springframework.data.repository.CrudRepository;

import ch.gmazlami.gifty.models.gift.Gift;

public interface GiftRepository extends CrudRepository<Gift, Long> {

}
