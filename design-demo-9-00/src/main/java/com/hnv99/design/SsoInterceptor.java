package com.hnv99.design;

public class SsoInterceptor implements HandlerInterceptor {

    public boolean preHandle(String request, String response, Object handler) {
        // Giả lập lấy cookie
        String ticket = request.substring(1, 8);
        // Giả lập kiểm tra
        return ticket.equals("success");
    }

}
