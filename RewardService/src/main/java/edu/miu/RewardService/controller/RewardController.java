package edu.miu.RewardService.controller;

import edu.miu.RewardService.dto.RewardDto;
import edu.miu.RewardService.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rewards")
@RequiredArgsConstructor
public class RewardController {
    public final RewardService rewardService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<RewardDto> rewards = rewardService.getAll();
        return new ResponseEntity<>(rewards, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        RewardDto reward = rewardService.getById(id);
        return new ResponseEntity<>(reward, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody RewardDto rewardDto){
        RewardDto reward = rewardService.add(rewardDto);
        return new ResponseEntity<>(reward, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody RewardDto rewardDto){
        RewardDto reward = rewardService.update(id, rewardDto);
        return new ResponseEntity<>(reward, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable String id){
        rewardService.remove(id);
        return new ResponseEntity<>("reward deleted successfully", HttpStatus.OK);
    }

}
