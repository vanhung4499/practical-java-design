package com.hnv99.design;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthInfo {

    private String code;
    private String info = "";

    public AuthInfo(String code, String ...infos) {
        this.code = code;
        for (String str:infos){
            this.info = this.info.concat(str);
        }
    }
}
