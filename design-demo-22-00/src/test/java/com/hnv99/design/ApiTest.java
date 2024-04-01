package com.hnv99.design;

import com.hnv99.design.visitor.impl.Parent;
import com.hnv99.design.visitor.impl.Principal;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test(){
        DataView dataView = new DataView();

        logger.info("\r\nQuan điểm của Phụ huynh:");
        dataView.show(new Parent());     // Phụ huynh

        logger.info("\r\nQuan điểm của Hiệu trưởng:");
        dataView.show(new Principal());  // Hiệu trưởng
    }
}
