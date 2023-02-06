package edu.miu.RewardService.repository;

import edu.miu.RewardService.domain.Reward;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends MongoRepository<Reward, String> {
}
