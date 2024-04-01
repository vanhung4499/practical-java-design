package com.hnv99.design;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ConfigFile {

    private String versionNo; // Số phiên bản
    private String content;   // Nội dung
    private Date dateTime;    // Thời gian
    private String operator;  // Người vận hành
}
