package com.hnv99.design;

import com.hnv99.design.utils.Topic;
import com.hnv99.design.utils.TopicRandomUtil;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;

@Setter
public class QuestionBank implements Cloneable {

    private String candidate; // Thí sinh
    private String number;    // Số báo danh

    private ArrayList<ChoiceQuestion> choiceQuestionList = new ArrayList<>();
    private ArrayList<AnswerQuestion> answerQuestionList = new ArrayList<>();

    public QuestionBank append(ChoiceQuestion choiceQuestion) {
        choiceQuestionList.add(choiceQuestion);
        return this;
    }

    public QuestionBank append(AnswerQuestion answerQuestion) {
        answerQuestionList.add(answerQuestion);
        return this;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        QuestionBank questionBank = (QuestionBank) super.clone();
        questionBank.choiceQuestionList = (ArrayList<ChoiceQuestion>) choiceQuestionList.clone();
        questionBank.answerQuestionList = (ArrayList<AnswerQuestion>) answerQuestionList.clone();

        // Xáo trộn câu hỏi
        Collections.shuffle(questionBank.choiceQuestionList);
        Collections.shuffle(questionBank.answerQuestionList);
        // Xáo trộn đáp án
        ArrayList<ChoiceQuestion> choiceQuestionList = questionBank.choiceQuestionList;
        for (ChoiceQuestion question : choiceQuestionList) {
            Topic random = TopicRandomUtil.random(question.getOption(), question.getKey());
            question.setOption(random.getOption());
            question.setKey(random.getKey());
        }
        return questionBank;
    }

    @Override
    public String toString() {

        StringBuilder detail = new StringBuilder("Thí sinh: " + candidate + "\r\n" +
                "Số báo danh: " + number + "\r\n" +
                "--------------------------------------------\r\n" +
                "I. Câu hỏi lựa chọn" + "\r\n\n");

        for (int idx = 0; idx < choiceQuestionList.size(); idx++) {
            detail.append("Câu ").append(idx + 1).append(": ").append(choiceQuestionList.get(idx).getName()).append("\r\n");
            for (String key : choiceQuestionList.get(idx).getOption().keySet()) {
                detail.append(key).append(": ").append(choiceQuestionList.get(idx).getOption().get(key)).append("\r\n");
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

