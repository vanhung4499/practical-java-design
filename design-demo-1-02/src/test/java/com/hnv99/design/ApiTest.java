package com.hnv99.design;

import com.hnv99.design.store.ICommodity;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ApiTest {
    @Test
    public void test_commodity() throws Exception {
        StoreFactory storeFactory = new StoreFactory();
        // 1. Phiếu giảm giá
        ICommodity commodityService_1 = storeFactory.getCommodityService(1);
        commodityService_1.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);
        // 2. Hàng hóa thực
        ICommodity commodityService_2 = storeFactory.getCommodityService(2);

        Map<String,String> extMap = new HashMap<String,String>();
        extMap.put("consigneeUserName", "Hung Nguyen");
        extMap.put("consigneeUserPhone", "012345678");
        extMap.put("consigneeUserAddress", "Thu Duc, HCM");

        commodityService_2.sendCommodity("10001","9820198721311","1023000020112221113", extMap);
        // 3. Thẻ đổi thưởng của bên thứ ba (Garena)
        ICommodity commodityService_3 = storeFactory.getCommodityService(3);
        commodityService_3.sendCommodity("10001","AQY1xjkUodl8LO975GdfrYUio",null,null);
    }
}
