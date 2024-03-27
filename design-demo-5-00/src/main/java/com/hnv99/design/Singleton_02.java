package com.hnv99.design;

/**
 * Kiểu Lazy (An toàn đa luồng) + synchronized
 */

public class Singleton_02 {

    private static Singleton_02 instance;

    private Singleton_02() {
    }

    public static synchronized Singleton_02 getInstance(){
        if (null != instance) return instance;
        instance = new Singleton_02();
        return instance;
    }

}