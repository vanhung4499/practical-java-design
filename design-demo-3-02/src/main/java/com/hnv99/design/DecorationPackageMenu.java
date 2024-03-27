package com.hnv99.design;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Gói trang trí
 */
public class DecorationPackageMenu implements IMenu {

    private List<Matter> list = new ArrayList<Matter>();  // Danh sách vật liệu trang trí
    private BigDecimal price = BigDecimal.ZERO;      // Giá trị trang trí

    private BigDecimal area;  // Diện tích
    private String grade;     // Cấp độ trang trí; sang trọng kiểu Âu, nông thôn xa hoa, hiện đại tiết kiệm

    private DecorationPackageMenu() {
    }

    public DecorationPackageMenu(Double area, String grade) {
        this.area = new BigDecimal(area);
        this.grade = grade;
    }

    public IMenu appendCeiling(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(new BigDecimal("0.2")).multiply(matter.price()));
        return this;
    }

    public IMenu appendCoat(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(new BigDecimal("1.4")).multiply(matter.price()));
        return this;
    }

    public IMenu appendFloor(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    public IMenu appendTile(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    public String getDetail() {

        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "Danh sách trang trí" + "\r\n" +
                "Cấp độ gói：" + grade + "\r\n" +
                "Giá gói：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " Đồng\r\n" +
                "Diện tích căn nhà：" + area.doubleValue() + " mét vuông\r\n" +
                "Danh sách vật liệu：\r\n");

        for (Matter matter: list) {
            detail.append(matter.scene()).append("：").append(matter.brand()).append("、").append(matter.model()).append("、Giá mỗi mét vuông：").append(matter.price()).append(" Đồng。\n");
        }

        return detail.toString();
    }

}