package com.hnv99.design;

import com.hnv99.design.factory.JDKProxy;
import com.hnv99.design.factory.impl.EGMCacheAdapter;
import com.hnv99.design.factory.impl.IIRCacheAdapter;
import com.hnv99.design.impl.CacheServiceImpl;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_CacheService() throws Exception {

        // Tạo proxy cho EGM Cache
        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01", "Hung");
        String val01 = proxy_EGM.get("user_name_01");
        System.out.println("Kết quả kiểm tra: " + val01);

        // Tạo proxy cho IIR Cache
        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        proxy_IIR.set("user_name_01", "Hung");
        String val02 = proxy_IIR.get("user_name_01");
        System.out.println("Kết quả kiểm tra: " + val02);

    }

}

