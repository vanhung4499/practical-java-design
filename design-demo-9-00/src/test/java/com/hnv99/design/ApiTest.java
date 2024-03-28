package com.hnv99.design;

import org.junit.Test;

public class ApiTest {

    @Test
    public void testSso() {
        SsoInterceptor ssoInterceptor = new SsoInterceptor();
        String request = "1successhuahua";
        boolean success = ssoInterceptor.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("Kiểm tra đăng nhập: " + request + (success ? " Được phép đi qua" : " Bị chặn"));
    }

}
