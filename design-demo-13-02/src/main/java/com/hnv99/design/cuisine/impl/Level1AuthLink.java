package com.hnv99.design.cuisine.impl;

import com.hnv99.design.AuthInfo;
import com.hnv99.design.AuthLink;
import com.hnv99.design.AuthService;

import java.util.Date;

/**
 * Người phụ trách cấp một
 */
public class Level1AuthLink extends AuthLink {

    public Level1AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "Mã đơn hàng:", orderId, " Trạng thái: Chờ người phê duyệt cấp một", levelUserName);
        }
        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "Mã đơn hàng:", orderId, " Trạng thái: Hoàn thành phê duyệt cấp một", " Thời gian:", f.format(date), " Người phê duyệt:", levelUserName);
        }

        return next.doAuth(uId, orderId, authDate);
    }

}
