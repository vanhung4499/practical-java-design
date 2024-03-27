package com.hnv99.design.mq;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.Date;

@Data
public class OrderMq {

    private String uid;           // ID Người dùng
    private String sku;           // Mặt hàng
    private String orderId;       // ID Đơn hàng
    private Date createOrderTime; // Thời gian đặt hàng

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

