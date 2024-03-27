package com.hnv99.design;

import com.alibaba.fastjson.JSON;
import com.hnv99.design.cuisine.impl.InsideOrderService;
import com.hnv99.design.cuisine.impl.POPOrderAdapterServiceImpl;
import com.hnv99.design.mq.CreateAccount;
import com.hnv99.design.mq.OrderMq;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ApiTest {

    @Test
    public void testMQAdapter() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ParseException {

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = s.parse("2020-06-01 23:20:16");

        CreateAccount createAccount = new CreateAccount();
        createAccount.setNumber("100001");
        createAccount.setAddress("Thu Duc, HCMC, Vietnam");
        createAccount.setAccountDate(parse);
        createAccount.setDesc("Mo tai khoan phong gym");

        HashMap<String, String> link01 = new HashMap<>();
        link01.put("userId", "number");
        link01.put("bizId", "number");
        link01.put("bizTime", "accountDate");
        link01.put("desc", "desc");
        RebateInfo rebateInfo01 = MQAdapter.filter(createAccount.toString(), link01);
        System.out.println("mq.CreateAccount(Trước khi điều chỉnh): " + createAccount.toString());
        System.out.println("mq.CreateAccount(Sau khi điều chỉnh): " + JSON.toJSONString(rebateInfo01));

        System.out.println("");

        OrderMq orderMq = new OrderMq();
        orderMq.setUid("100001");
        orderMq.setSku("10928092093111123");
        orderMq.setOrderId("100000890193847111");
        orderMq.setCreateOrderTime(parse);

        HashMap<String, String> link02 = new HashMap<String, String>();
        link02.put("userId", "uid");
        link02.put("bizId", "orderId");
        link02.put("bizTime", "createOrderTime");
        RebateInfo rebateInfo02 = MQAdapter.filter(orderMq.toString(), link02);
        System.out.println("mq.orderMq(Trước khi điều chỉnh): " + orderMq.toString());
        System.out.println("mq.orderMq(Sau khi điều chỉnh): " + JSON.toJSONString(rebateInfo02));
    }

    @Test
    public void testItfAdapter() {
        OrderAdapterService popOrderAdapterService = new POPOrderAdapterServiceImpl();
        System.out.println("Kiểm tra đơn hàng đầu tiên, giao diện điều chỉnh(POP): " + popOrderAdapterService.isFirst("100001"));

        OrderAdapterService insideOrderService = new InsideOrderService();
        System.out.println("Kiểm tra đơn hàng đầu tiên, giao diện điều chỉnh(Doanh nghiệp tự vận hành): " + insideOrderService.isFirst("100001"));
    }

}

