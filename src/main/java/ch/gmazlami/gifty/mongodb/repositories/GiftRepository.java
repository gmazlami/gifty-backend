package ch.gmazlami.gifty.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import ch.gmazlami.gifty.models.gift.Gift;

public interface GiftRepository extends MongoRepository<Gift, String> {

}
