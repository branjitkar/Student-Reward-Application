package edu.miu.RewardService.dto;

import edu.miu.RewardService.domain.RewardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RewardDto {
    private String name;
    private int quantity;
    private RewardType type;
}
