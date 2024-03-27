package com.hnv99.design.mq;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.Date;

@Data
public class CreateAccount {
    private String number;      // Số tài khoản
    private String address;     // Địa chỉ mở tài khoản
    private Date accountDate;   // Ngày mở tài khoản
    private String desc;        // Mô tả về tài khoản

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
