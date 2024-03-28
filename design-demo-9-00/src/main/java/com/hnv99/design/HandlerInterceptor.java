package com.hnv99.design;

public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);

}

