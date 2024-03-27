package com.hnv99.design;

/**
 * Kiểu Eager (An toàn đa luồng) - Được tải trước
 */

public class Singleton_03 {

    private static Singleton_03 instance = new Singleton_03();

    private Singleton_03() {
    }

    public static Singleton_03 getInstance() {
        return instance;
    }

}