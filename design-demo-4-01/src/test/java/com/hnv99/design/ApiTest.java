package com.hnv99.design;

import org.junit.Test;

public class ApiTest {

    @Test
    public void test_QuestionBankController() {
        QuestionBankController questionBankController = new QuestionBankController();
        System.out.println(questionBankController.createPaper("Hung Nguyen", "1000001921032"));
        System.out.println(questionBankController.createPaper("An Nguyen", "1000001921051"));
        System.out.println(questionBankController.createPaper("Bao Nguyen", "1000001921987"));
    }

}
