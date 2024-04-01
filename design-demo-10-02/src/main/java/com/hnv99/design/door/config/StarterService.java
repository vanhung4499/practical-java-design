package com.hnv99.design.door.config;

public class StarterService {

    private final String userStr;

    public StarterService(String userStr) {
        this.userStr = userStr;
    }

    public String[] split(String separatorChar) {
        return this.userStr.split(separatorChar);
    }

}

