package com.hnv99.design;

import com.hnv99.design.store.ICommodity;
import com.hnv99.design.store.impl.CardCommodityService;
import com.hnv99.design.store.impl.CouponCommodityService;
import com.hnv99.design.store.impl.GoodsCommodityService;

public class StoreFactory {
    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        switch (commodityType) {
            case 1:
                return new CouponCommodityService();
            case 2:
                return new GoodsCommodityService();
            case 3:
                return new CardCommodityService();
            default:
                throw new RuntimeException("Product or service type not found.");
        }
    }
}

