package com.gfa.chat.models;

public class CustomError {
    private String customError;

    public CustomError() {
        this.customError = "Please provide an input!";
    }

    public CustomError(String errorMsg) {
        this.customError = errorMsg;
    }
    public String getError() {
        return customError;
    }
}