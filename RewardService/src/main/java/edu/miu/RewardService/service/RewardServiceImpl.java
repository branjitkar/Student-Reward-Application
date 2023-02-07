package edu.miu.RewardService.service;

import edu.miu.RewardService.domain.Reward;
import edu.miu.RewardService.dto.RewardDto;
import edu.miu.RewardService.exception.RewardNotfoundException;
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
        Reward reward = modelMapper.map(rewardDto, Reward.class);
        rewardRepository.save(reward);
        return rewardDto;
    }

    @Override
    public void remove(String name) {
        Optional<Reward> reward = rewardRepository.findById(name);
        if(reward.isEmpty())
            throw new RewardNotfoundException("Reward not found");
        rewardRepository.deleteById(name);
    }

    @Override
    public RewardDto update(String name, RewardDto rewardDto) {
        Optional<Reward> reward = rewardRepository.findById(name);
        if(reward.isEmpty())
            throw new RewardNotfoundException("Reward not found");

        rewardDto.setName(name);
        Reward newReward = modelMapper.map(rewardDto, Reward.class);
        rewardRepository.save(newReward);
        return rewardDto;
    }

    @Override
    public RewardDto getById(String name) {
        Optional<Reward> reward = rewardRepository.findById(name);
        if(reward.isEmpty())
            throw new RewardNotfoundException("Reward not found");
        return modelMapper.map(reward.get(), RewardDto.class);
    }

    @Override
    public List<RewardDto> getAll() {
        return rewardRepository.findAll().stream().map(reward -> modelMapper.map(reward, RewardDto.class)).collect(Collectors.toList());
    }
}
