package edu.miu.RewardService.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Reward {
    @Id
    private String name;
    private int quantity;
    private RewardType type;
    private int price;
}
