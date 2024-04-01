package com.hnv99.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Quy định kiểm duyệt:
 * 1. 601-610 Kiểm duyệt cấp ba + Kiểm duyệt cấp hai
 * 2. 611-620 Kiểm duyệt cấp ba + Kiểm duyệt cấp hai + Kiểm duyệt cấp một
 * 3. Thời gian khác Kiểm duyệt cấp ba
 */
public abstract class AuthLink {

    protected Logger logger = LoggerFactory.getLogger(AuthLink.class);

    protected SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// Định dạng thời gian
    protected String levelUserId;                           // ID người cấp
    protected String levelUserName;                         // Tên người cấp
    private AuthLink next;                                  // Chuỗi trách nhiệm

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    public AuthLink next() {
        return next;
    }

    public AuthLink appendNext(AuthLink next) {
        this.next = next;
        return this;
    }

    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);

}
