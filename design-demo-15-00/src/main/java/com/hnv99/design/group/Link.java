package com.hnv99.design.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Liên kết giữa các nút của cây
 */
@Getter
@Setter
@AllArgsConstructor
public class Link {

    private String fromId; // ID nhân viên gốc
    private String toId;   // ID nhân viên đích

}