package com.hnv99.design.cuisine.impl;

import com.hnv99.design.AuthInfo;
import com.hnv99.design.AuthLink;
import com.hnv99.design.AuthService;

import java.text.ParseException;
import java.util.Date;

/**
 * Người phụ trách cấp ba
 */
public class Level3AuthLink extends AuthLink {

    private Date beginDate = f.parse("2020-06-01 00:00:00");
    private Date endDate = f.parse("2020-06-25 23:59:59");

    public Level3AuthLink(String levelUserId, String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "Mã đơn hàng:", orderId, " Trạng thái: Chờ người phê duyệt cấp ba ", levelUserName);
        }
        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "Mã đơn hàng:", orderId, " Trạng thái: Hoàn thành phê duyệt cấp ba", " Thời gian:", f.format(date), " Người phê duyệt:", levelUserName);
        }

        if (authDate.before(beginDate) || authDate.after(endDate)) {
            return new AuthInfo("0000", "Mã đơn hàng:", orderId, " Trạng thái: Hoàn thành phê duyệt cấp ba", " Thời gian:", f.format(date), " Người phê duyệt:", levelUserName);
        }

        return next.doAuth(uId, orderId, authDate);
    }

}

