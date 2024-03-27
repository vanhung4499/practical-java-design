package com.hnv99.design.cuisine.impl;

import com.hnv99.design.OrderAdapterService;
import com.hnv99.design.service.OrderService;

public class InsideOrderService implements OrderAdapterService {

    private OrderService orderService = new OrderService();

    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }

}

