package com.hnv99.design.door;


import com.alibaba.fastjson.JSON;
import com.hnv99.design.door.annotation.DoDoor;
import com.hnv99.design.door.config.StarterService;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DoJoinPoint {

    private Logger logger = LoggerFactory.getLogger(DoJoinPoint.class);

    @Autowired
    private StarterService starterService;

    @Pointcut("@annotation(com.hnv99.design.door.annotation.DoDoor)")
    public void aopPoint() {
    }

    @Around("aopPoint()")
    public Object doRouter(ProceedingJoinPoint jp) throws Throwable {
        //Lấy phương thức
        Method method = getMethod(jp);
        DoDoor door = method.getAnnotation(DoDoor.class);
        //Lấy giá trị trường
        String keyValue = getFiledValue(door.key(), jp.getArgs());
        logger.info("practical door handler method：{} value：{}", method.getName(), keyValue);
        if (null == keyValue || keyValue.isEmpty()) return jp.proceed();
        // Lấy nội dung cấu hình
        String[] split = starterService.split(",");
        //Lọc theo whitelist
        for (String str : split) {
            if (keyValue.equals(str)) {
                return jp.proceed();
            }
        }
        // Chặn
        return returnObject(door, method);
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature sig = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) sig;
        return getClass(jp).getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }

    private Class<? extends Object> getClass(JoinPoint jp) throws NoSuchMethodException {
        return jp.getTarget().getClass();
    }

    //Trả về đối tượng
    private Object returnObject(DoDoor doGate, Method method) throws IllegalAccessException, InstantiationException {
        Class<?> returnType = method.getReturnType();
        String returnJson = doGate.returnJson();
        if (returnJson.isEmpty()) {
            return returnType.newInstance();
        }
        return JSON.parseObject(returnJson, returnType);
    }

    //Lấy giá trị thuộc tính
    private String getFiledValue(String filed, Object[] args) {
        String filedValue = null;
        for (Object arg : args) {
            try {
                if (null == filedValue || filedValue.isEmpty()) {
                    filedValue = BeanUtils.getProperty(arg, filed);
                } else {
                    break;
                }
            } catch (Exception e) {
                if (args.length == 1) {
                    return args[0].toString();
                }
            }
        }
        return filedValue;
    }

}
