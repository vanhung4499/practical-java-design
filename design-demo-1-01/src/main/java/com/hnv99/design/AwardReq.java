package com.hnv99.design;

import lombok.Data;

import java.util.Map;

@Data
public class AwardReq {
    private String uId;                 // ID duy nhất của người dùng
    private Integer awardType;          // Loại giải thưởng (có thể được định nghĩa bằng enum); 1 là phiếu giảm giá, 2 là hàng hóa thực tế, 3 là thẻ đổi thưởng của bên thứ ba (ví dụ như thẻ Garena)
    private String awardNumber;         // Số hiệu giải thưởng; sku, số phiếu giảm giá, số thẻ
    private String bizId;               // ID kinh doanh, tránh trùng lặp
    private Map<String, String> extMap; // Thông tin mở rộng
}
