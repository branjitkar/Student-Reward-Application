package com.sa.studentreward.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RewardDto {
    private String id;
    private String name;
    private int quantity;
    private RewardType type;
    private int price;
}
