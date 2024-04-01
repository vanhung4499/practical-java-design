package com.hnv99.design;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuthController {

    private SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// Định dạng thời gian

    public AuthInfo doAuth(String uId, String orderId, Date authDate) throws ParseException {

        // Phê duyệt cấp ba
        Date date = AuthService.queryAuthInfo("1000013", orderId);
        if (null == date) return new AuthInfo("0001", "ID đơn: ", orderId, " Trạng thái: Đợi người phê duyệt cấp ba ", "An");

        // Phê duyệt cấp hai
        if (authDate.after(f.parse("2020-06-01 00:00:00")) && authDate.before(f.parse("2020-06-25 23:59:59"))) {
            date = AuthService.queryAuthInfo("1000012", orderId);
            if (null == date) return new AuthInfo("0001", "ID đơn: ", orderId, " Trạng thái: Đợi người phê duyệt cấp hai ", "Binh");
        }

        // Phê duyệt cấp một
        if (authDate.after(f.parse("2020-06-11 00:00:00")) && authDate.before(f.parse("2020-06-20 23:59:59"))) {
            date = AuthService.queryAuthInfo("1000011", orderId);
            if (null == date) return new AuthInfo("0001", "ID đơn: ", orderId, " Trạng thái: Đợi người phê duyệt cấp một ", "Thinh");
        }

        return new AuthInfo("0001", "ID đơn: ", orderId, " Trạng thái: Phê duyệt hoàn tất");
    }

}
