package com.hnv99.design;

import org.junit.Test;

public class ApiTest {
    @Test
    public void testLoginSsoDecorator() {
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("Kiểm tra đăng nhập：" + request + (success ? " Được phép" : " Bị chặn"));
    }
}
