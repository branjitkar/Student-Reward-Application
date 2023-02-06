package edu.miu.RewardService.service;

import edu.miu.RewardService.domain.Reward;
import edu.miu.RewardService.dto.RewardDto;
import edu.miu.RewardService.repository.RewardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RewardServiceImpl implements RewardService{
    private final RewardRepository rewardRepository;
    private final ModelMapper modelMapper;

    @Override
    public RewardDto add(RewardDto rewardDto) {
        rewardDto.setId(UUID.randomUUID().toString());
        Reward reward = modelMapper.map(rewardDto, Reward.class);
        rewardRepository.save(reward);
        return rewardDto;
    }

    @Override
    public void remove(String id) {
        rewardRepository.deleteById(id);
    }

    @Override
    public RewardDto update(String id, RewardDto rewardDto) {
        rewardDto.setId(id);
        Reward reward = modelMapper.map(rewardDto, Reward.class);
        rewardRepository.save(reward);
        return rewardDto;
    }

    @Override
    public RewardDto getById(String id) {
        Optional<Reward> reward = rewardRepository.findById(id);
        return reward.map(value -> modelMapper.map(value, RewardDto.class)).orElse(null);
    }

    @Override
    public List<RewardDto> getAll() {
        return rewardRepository.findAll().stream().map(reward -> modelMapper.map(reward, RewardDto.class)).collect(Collectors.toList());
    }
}
