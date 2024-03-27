package com.hnv99.design.mq;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class POPOrderDelivered {
    private String uId;     // ID Người dùng
    private String orderId; // ID Đơn hàng
    private Date orderTime; // Thời gian đặt hàng
    private Date sku;       // Mặt hàng
    private Date skuName;   // Tên mặt hàng
    private BigDecimal decimal; // Số tiền

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
