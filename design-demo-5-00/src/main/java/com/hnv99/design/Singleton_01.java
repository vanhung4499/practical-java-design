package com.hnv99.design;

/**
 * Kiểu Lazy (Không an toàn đa luồng) - Tải khi null
 */
public class Singleton_01 {

    private static Singleton_01 instance;

    private Singleton_01() {
    }

    public static Singleton_01 getInstance(){
        if (null != instance) return instance;
        instance = new Singleton_01();
        return instance;
    }

}
