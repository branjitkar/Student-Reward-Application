package edu.miu.RewardService.exception;


public class RewardNotfoundException extends RuntimeException {
    private String message;
    public RewardNotfoundException(String message) {
        super(message);
        this.message = message;
    }
    public RewardNotfoundException() {
    }
}