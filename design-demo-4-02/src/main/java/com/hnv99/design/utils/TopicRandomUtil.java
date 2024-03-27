package com.hnv99.design.utils;


import java.util.*;

public class TopicRandomUtil {

    /**
     * Pha trộn các phần tử trong Map, ghi lại key đáp án tương ứng
     * @param option Câu hỏi
     * @param key    Đáp án
     * @return Topic Sau khi pha trộn {A=c., B=d., C=a., D=b.}
     */
    static public Topic random(Map<String, String> option, String key) {
        Set<String> keySet = option.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        Collections.shuffle(keyList);
        HashMap<String, String> optionNew = new HashMap<>();
        int idx = 0;
        String keyNew = "";
        for (String next : keySet) {
            String randomKey = keyList.get(idx++);
            if (key.equals(next)) {
                keyNew = randomKey;
            }
            optionNew.put(randomKey, option.get(next));
        }
        return new Topic(optionNew, keyNew);
    }

}