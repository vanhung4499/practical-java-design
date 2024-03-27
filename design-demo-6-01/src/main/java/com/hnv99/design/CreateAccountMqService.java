package com.hnv99.design;

import com.alibaba.fastjson.JSON;
import com.hnv99.design.mq.CreateAccount;

public class CreateAccountMqService {
    public void onMessage(String message) {

        CreateAccount mq = JSON.parseObject(message, CreateAccount.class);

        mq.getNumber();
        mq.getAccountDate();

        // ... Xử lý nghiệp vụ của riêng bạn
    }
}
