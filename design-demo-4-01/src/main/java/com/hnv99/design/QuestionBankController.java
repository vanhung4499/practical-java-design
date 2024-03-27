package com.hnv99.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionBankController {

    public String createPaper(String candidate, String number) {

        List<ChoiceQuestion> choiceQuestionList = new ArrayList<ChoiceQuestion>();
        List<AnswerQuestion> answerQuestionList = new ArrayList<AnswerQuestion>();

        Map<String, String> map01 = new HashMap<String, String>();
        map01.put("A", "JAVA2 EE");
        map01.put("B", "JAVA2 Card");
        map01.put("C", "JAVA2 ME");
        map01.put("D", "JAVA2 HE");
        map01.put("E", "JAVA2 SE");

        Map<String, String> map02 = new HashMap<String, String>();
        map02.put("A", "Phương thức main của JAVA phải được viết trong một lớp");
        map02.put("B", "Trong JAVA có thể có nhiều phương thức main");
        map02.put("C", "Tên lớp trong JAVA phải giống với tên tệp");
        map02.put("D", "Trong phương thức main của JAVA, nếu chỉ có một câu lệnh, có thể không cần {} (ngoặc nhọn) bao quanh");

        Map<String, String> map03 = new HashMap<String, String>();
        map03.put("A", "Biến có thể được tạo thành từ chữ cái, dấu gạch dưới, số, và ký tự $");
        map03.put("B", "Biến không thể bắt đầu bằng số");
        map03.put("C", "A và a là cùng một biến trong JAVA");
        map03.put("D", "Các biến khác nhau có thể có cùng tên");

        Map<String, String> map04 = new HashMap<String, String>();
        map04.put("A", "STRING");
        map04.put("B", "x3x;");
        map04.put("C", "void");
        map04.put("D", "de$f");

        Map<String, String> map05 = new HashMap<String, String>();
        map05.put("A", "31");
        map05.put("B", "0");
        map05.put("C", "1");
        map05.put("D", "2");

        choiceQuestionList.add(new ChoiceQuestion("Các phiên bản JAVA sau đây không bao gồm", map01, "D"));
        choiceQuestionList.add(new ChoiceQuestion("Câu nào dưới đây đúng", map02, "A"));
        choiceQuestionList.add(new ChoiceQuestion("Quy tắc đặt tên biến đúng là", map03, "B"));
        choiceQuestionList.add(new ChoiceQuestion("() sau đây không phải là một biến hợp lệ", map04, "C"));
        choiceQuestionList.add(new ChoiceQuestion("Giá trị của biểu thức (11+3*8)/4%3 là", map05, "D"));
        answerQuestionList.add(new AnswerQuestion("Ngựa con của ngựa đỏ và ngựa đen có bao nhiêu chân", "4 chân"));
        answerQuestionList.add(new AnswerQuestion("Đánh đầu bằng gậy sắt hay gậy gỗ đau hơn", "Đầu đau nhất"));
        answerQuestionList.add(new AnswerQuestion("Cái gì không phải là chiếc giường có thể ngủ", "Chiếc giường răng"));
        answerQuestionList.add(new AnswerQuestion("Tại sao ngựa tốt không ăn cỏ cũ", "Cỏ phía sau đã không còn"));

        // Xuất kết quả
        StringBuilder detail = new StringBuilder("Thí sinh: " + candidate + "\r\n" +
                "Số báo danh: " + number + "\r\n" +
                "--------------------------------------------\r\n" +
                "I. Câu hỏi lựa chọn" + "\r\n\n");

        for (int idx = 0; idx < choiceQuestionList.size(); idx++) {
            detail.append("Câu ").append(idx + 1).append(": ").append(choiceQuestionList.get(idx).getName()).append("\r\n");
            Map<String, String> option = choiceQuestionList.get(idx).getOption();
            for (String key : option.keySet()) {
                detail.append(key).append(": ").append(option.get(key)).append("\r\n");
            }
            detail.append("Đáp án: ").append(choiceQuestionList.get(idx).getKey()).append("\r\n\n");
        }

        detail.append("II. Câu hỏi trả lời" + "\r\n\n");

        for (int idx = 0; idx < answerQuestionList.size(); idx++) {
            detail.append("Câu ").append(idx + 1).append(": ").append(answerQuestionList.get(idx).getName()).append("\r\n");
            detail.append("Đáp án: ").append(answerQuestionList.get(idx).getKey()).append("\r\n\n");
        }

        return detail.toString();
    }

}
