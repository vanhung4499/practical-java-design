package com.hnv99.design;

import com.hnv99.design.ceiling.LevelOneCeiling;
import com.hnv99.design.ceiling.LevelTwoCeiling;
import com.hnv99.design.coat.DuluxCoat;
import com.hnv99.design.coat.NipponCoat;
import com.hnv99.design.floor.InovarFloor;
import com.hnv99.design.tile.MarcoPoloTile;
import com.hnv99.design.tile.PrimeTile;

public class Builder {

    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "Cao cấp Châu Âu")
                .appendCeiling(new LevelTwoCeiling())    // Trần nhà, trần cấp 2
                .appendCoat(new DuluxCoat())             // Sơn, Dulux
                .appendFloor(new InovarFloor());         // Sàn nhà, Sàn Inovar
    }

    public IMenu levelTwo(Double area){
        return new DecorationPackageMenu(area, "Nông thôn nhẹ nhàng")
                .appendCeiling(new LevelTwoCeiling())   // Trần nhà, trần cấp 2
                .appendCoat(new NipponCoat())           // Sơn, Nippon
                .appendTile(new MarcoPoloTile());       // Gạch lát, Marco Polo
    }

    public IMenu levelThree(Double area){
        return new DecorationPackageMenu(area, "Hiện đại đơn giản")
                .appendCeiling(new LevelOneCeiling())   // Trần nhà, trần cấp 1
                .appendCoat(new NipponCoat())           // Sơn, Nippon
                .appendTile(new PrimeTile());           // Gạch lát, Prime
    }

}

