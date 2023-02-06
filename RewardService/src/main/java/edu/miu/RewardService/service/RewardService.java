package edu.miu.RewardService.service;

import edu.miu.RewardService.dto.RewardDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RewardService {
    RewardDto add(RewardDto rewardDto);
    void remove(String id);
    RewardDto update(String id, RewardDto rewardDto);
    RewardDto getById(String id);
    List<RewardDto> getAll();
}
