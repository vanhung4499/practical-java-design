package com.hnv99.design.cuisine.impl;

import com.hnv99.design.cook.ICook;
import com.hnv99.design.cuisine.ICuisine;

public class ShanDongCuisine implements ICuisine {

    private ICook cook;

    public ShanDongCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}
