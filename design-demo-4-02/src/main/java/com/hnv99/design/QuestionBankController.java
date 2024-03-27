package com.hnv99.design;

import java.util.HashMap;
import java.util.Map;

public class QuestionBankController {

    private final QuestionBank questionBank = new QuestionBank();

    public QuestionBankController() {

        Map<String, String> map01 = new HashMap<>();
        map01.put("A", "JAVA2 EE");
        map01.put("B", "JAVA2 Card");
        map01.put("C", "JAVA2 ME");
        map01.put("D", "JAVA2 HE");
        map01.put("E", "JAVA2 SE");

        Map<String, String> map02 = new HashMap<>();
        map02.put("A", "Phương thức main của JAVA phải được viết trong lớp");
        map02.put("B", "Trong JAVA, có thể có nhiều phương thức main");
        map02.put("C", "Trong JAVA, tên lớp phải giống với tên tệp");
        map02.put("D", "Trong phương thức main của JAVA, nếu chỉ có một câu lệnh, có thể không cần dùng dấu {} (ngoặc nhọn)");

        Map<String, String> map03 = new HashMap<>();
        map03.put("A", "Biến có thể được tạo ra từ chữ cái, dấu gạch dưới, số, và ký tự $");
        map03.put("B", "Biến không thể bắt đầu bằng số");
        map03.put("C", "A và a được xem như là một biến duy nhất trong JAVA");
        map03.put("D", "Các biến khác nhau có thể được đặt tên giống nhau");

        Map<String, String> map04 = new HashMap<>();
        map04.put("A", "STRING");
        map04.put("B", "x3x;");
        map04.put("C", "void");
        map04.put("D", "de$f");

        Map<String, String> map05 = new HashMap<>();
        map05.put("A", "31");
        map05.put("B", "0");
        map05.put("C", "1");
        map05.put("D", "2");

        questionBank.append(new ChoiceQuestion("JAVA không bao gồm phiên bản nào sau đây", map01, "D"))
                .append(new ChoiceQuestion("Câu nào sau đây là đúng", map02, "A"))
                .append(new ChoiceQuestion("Câu nào sau đây là đúng về quy tắc đặt tên biến", map03, "B"))
                .append(new ChoiceQuestion("Cái nào sau đây không phải là một biến hợp lệ",map04, "C"))
                .append(new ChoiceQuestion("Giá trị của biểu thức (11+3*8)/4%3 là", map05, "D"))
                .append(new AnswerQuestion("Mấy chân của con ngựa con của ngựa đực đỏ và ngựa đực đen", "4 chân"))
                .append(new AnswerQuestion("Nên đánh đầu bằng gậy sắt hay gậy gỗ", "Đầu là chỗ đau nhất"))
                .append(new AnswerQuestion("Chiếc giường nào không thể ngủ", "Giường răng"))
                .append(new AnswerQuestion("Tại sao ngựa tốt không ăn cỏ ở phía sau", "Cỏ ở phía sau không còn nữa"));
    }

    public String createPaper(String candidate, String number) throws CloneNotSupportedException {
        QuestionBank questionBankClone = (QuestionBank) questionBank.clone();
        questionBankClone.setCandidate(candidate);
        questionBankClone.setNumber(number);
        return questionBankClone.toString();
    }

}
