package ch.gmazlami.gifty.postgres.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import ch.gmazlami.gifty.models.gift.Gift;

public interface GiftRepository extends CrudRepository<Gift, Long> {

	List<Gift> findByUserId(Long userId);
	
	Gift findById(Long id);
	
	@Transactional
	Long deleteById(Long id);
}
