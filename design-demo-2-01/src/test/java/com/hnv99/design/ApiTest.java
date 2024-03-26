package com.hnv99.design;

import com.hnv99.design.cuisine.impl.CacheServiceImpl;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_CacheService() {

        CacheService cacheService = new CacheServiceImpl();

        cacheService.set("user_name_01", "Hung", 1);
        String val01 = cacheService.get("user_name_01", 1);
        System.out.println("Kết quả kiểm tra: " + val01);

    }

}

