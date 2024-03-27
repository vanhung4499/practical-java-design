package com.hnv99.design;

public interface IMenu {

    /**
     * Trần nhà
     */
    IMenu appendCeiling(Matter matter);

    /**
     * Sơn phủ
     */
    IMenu appendCoat(Matter matter);

    /**
     * Sàn nhà
     */
    IMenu appendFloor(Matter matter);

    /**
     * Gạch lát
     */
    IMenu appendTile(Matter matter);

    /**
     * Chi tiết
     */
    String getDetail();

}
