package com.hnv99.design.door.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("practical.door")
public class StarterServiceProperties {

    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }

}

