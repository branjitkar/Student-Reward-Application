package com.sa.studentreward.dto;

import lombok.Data;


@Data
public class Reward {

    private String id;
    private String name;
    private int quantity;
    private RewardType type;
    private int price;
}
