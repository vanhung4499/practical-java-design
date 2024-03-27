package com.hnv99.design;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Lớp Tĩnh
 */
public class Singleton_00 {

    public static Map<String,String> cache = new ConcurrentHashMap<String, String>();

}
