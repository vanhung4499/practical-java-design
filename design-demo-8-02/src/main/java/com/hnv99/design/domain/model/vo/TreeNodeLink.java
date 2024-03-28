package com.hnv99.design.domain.model.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * Thông tin liên kết của nút cây quy tắc
 */
@Getter
@Setter
public class TreeNodeLink {
    private Long nodeIdFrom;        // ID nút Bắt đầu
    private Long nodeIdTo;          // ID nút Đến
    private Integer ruleLimitType;  // Loại giới hạn; 1:=; 2:>; 3:<; 4:>=; 5<=; 6:enum[Phạm vi liệt kê]
    private String ruleLimitValue;  // Giá trị giới hạn
}
