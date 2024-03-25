package com.hnv99.design.card;

/**
 * Mô phỏng dịch vụ thẻ game Garena
 */
public class GarenaCardService {
    /**
     * Phát thẻ game Garena
     * @param bindMobileNumber số điện thoại được liên kết
     * @param cardId ID thẻ
     */
    public void grantToken(String bindMobileNumber, String cardId) {
        System.out.println("Mô phỏng việc phát thẻ game Garena: " + bindMobileNumber + ", " + cardId);
    }
}
