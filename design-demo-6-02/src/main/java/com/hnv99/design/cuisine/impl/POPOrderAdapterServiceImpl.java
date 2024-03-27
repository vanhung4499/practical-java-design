package com.hnv99.design.cuisine.impl;

import com.hnv99.design.OrderAdapterService;
import com.hnv99.design.service.POPOrderService;

public class POPOrderAdapterServiceImpl implements OrderAdapterService {

    private POPOrderService popOrderService = new POPOrderService();

    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }

}
