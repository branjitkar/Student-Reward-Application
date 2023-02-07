package com.sa.studentreward.feign;

import com.sa.studentreward.dto.ElementDto;
import com.sa.studentreward.dto.Reward;
import com.sa.studentreward.dto.RewardDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("RewardService")
public interface RewardClient {

    @RequestMapping("/rewards/{id}")
    public Reward getById(@PathVariable String id);

    @RequestMapping(value = "/rewards",method = RequestMethod.POST)
    public void saveReward(@RequestBody Reward reward);

}
