package edu.miu.RewardService.domain;

public enum RewardType {
    ELEMENT("element"),
    IN_SCHOOL("in_school"),
    GIFT("gift");

    public final String value;

    private RewardType(String value) {
        this.value = value;
    }
}
