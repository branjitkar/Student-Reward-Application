package com.swa.sra.studentservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reward {
    private String id;
    private String name;
    private int quantity;
    private RewardType type;
    private int price;
}
