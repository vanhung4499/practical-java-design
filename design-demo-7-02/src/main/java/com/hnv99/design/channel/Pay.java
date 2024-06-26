package com.hnv99.design.channel;

import com.hnv99.design.mode.IPayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public abstract class Pay {

    protected Logger logger = LoggerFactory.getLogger(Pay.class);

    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);

}
