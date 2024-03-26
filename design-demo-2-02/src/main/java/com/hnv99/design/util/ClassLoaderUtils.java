package com.hnv99.design.util;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class ClassLoaderUtils {

    private static Set<Class> primitiveSet = new HashSet<Class>();

    static {
        primitiveSet.add(Integer.class);
        primitiveSet.add(Long.class);
        primitiveSet.add(Float.class);
        primitiveSet.add(Byte.class);
        primitiveSet.add(Short.class);
        primitiveSet.add(Double.class);
        primitiveSet.add(Character.class);
        primitiveSet.add(Boolean.class);
    }

    /**
     * Lấy ClassLoader hiện tại
     *
     * @return ClassLoader
     */
    public static ClassLoader getCurrentClassLoader() {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl == null) {
            cl = ClassLoaderUtils.class.getClassLoader();
        }
        return cl == null ? ClassLoader.getSystemClassLoader() : cl;
    }

    /**
     * Tải lớp dựa trên tên lớp
     *
     * @param clazz Tên lớp
     * @return ClassLoader
     */
    public static ClassLoader getClassLoader(Class<?> clazz) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader != null) {
            return loader;
        }
        if (clazz != null) {
            loader = clazz.getClassLoader();
            if (loader != null) {
                return loader;
            }
            return clazz.getClassLoader();
        }
        return ClassLoader.getSystemClassLoader();
    }

    /**
     * Tải lớp dựa trên tên lớp
     *
     * @param className Tên lớp
     * @return Class
     * @throws ClassNotFoundException  Không tìm thấy lớp
     */
    public static Class forName(String className)
            throws ClassNotFoundException {
        return forName(className, true);
    }

    /**
     * Tải lớp dựa trên tên lớp
     *
     * @param className  Tên lớp
     * @param initialize Có khởi tạo không
     * @return Class
     * @throws ClassNotFoundException  Không tìm thấy lớp
     */
    public static Class forName(String className, boolean initialize)
            throws ClassNotFoundException {
        return Class.forName(className, initialize, getCurrentClassLoader());
    }

    /**
     * Tải lớp dựa trên tên lớp
     *
     * @param className Tên lớp
     * @param cl        Classloader
     * @return Class
     * @throws ClassNotFoundException  Không tìm thấy lớp
     */
    public static Class forName(String className, ClassLoader cl)
            throws ClassNotFoundException {
        return Class.forName(className, true, cl);
    }

    /**
     * Khởi tạo một đối tượng (chỉ kiểm tra constructor mặc định, không quan tâm đến các constructor khác)
     *
     * @param clazz Loại đối tượng
     * @param <T>   Lớp cụ thể của đối tượng
     * @return Thể hiện của đối tượng
     * @throws Exception Không tìm thấy phương thức hoặc không thể xử lý hoặc ngoại lệ khởi tạo khác
     */
    public static <T> T newInstance(Class<T> clazz) throws Exception {
        if (primitiveSet.contains(clazz)) {
            return null;
        }
        if (clazz.isMemberClass() && !Modifier.isStatic(clazz.getModifiers())) {
            Constructor constructorList[] = clazz.getDeclaredConstructors();
            Constructor defaultConstructor = null;
            for (Constructor con : constructorList) {
                if (con.getParameterTypes().length == 1) {
                    defaultConstructor = con;
                    break;
                }
            }
            if (defaultConstructor != null) {
                if (defaultConstructor.isAccessible()) {
                    return (T) defaultConstructor.newInstance(new Object[]{null});
                } else {
                    try {
                        defaultConstructor.setAccessible(true);
                        return (T) defaultConstructor.newInstance(new Object[]{null});
                    } finally {
                        defaultConstructor.setAccessible(false);
                    }
                }
            } else {
                throw new Exception("The " + clazz.getCanonicalName() + " has no default constructor!");
            }
        }
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            if (constructor.isAccessible()) {
                throw new Exception("The " + clazz.getCanonicalName() + " has no default constructor!", e);
            } else {
                try {
                    constructor.setAccessible(true);
                    return constructor.newInstance();
                } finally {
                    constructor.setAccessible(false);
                }
            }
        }
    }

    public static Class<?>[] getClazzByArgs(Object[] args) {
        Class<?>[] parameterTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ArrayList) {
                parameterTypes[i] = List.class;
                continue;
            }
            if (args[i] instanceof LinkedList) {
                parameterTypes[i] = List.class;
                continue;
            }
            if (args[i] instanceof HashMap) {
                parameterTypes[i] = Map.class;
                continue;
            }
            if (args[i] instanceof Long){
                parameterTypes[i] = long.class;
                continue;
            }
            if (args[i] instanceof Double){
                parameterTypes[i] = double.class;
                continue;
            }
            if (args[i] instanceof TimeUnit){
                parameterTypes[i] = TimeUnit.class;
                continue;
            }
            parameterTypes[i] = args[i].getClass();
        }
        return parameterTypes;
    }

    public Method getMethod(Class<?> classType, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
        return classType.getMethod(methodName, parameterTypes);
    }

}

