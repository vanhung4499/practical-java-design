package com.hnv99.design;

import com.hnv99.design.ceiling.LevelOneCeiling;
import com.hnv99.design.ceiling.LevelTwoCeiling;
import com.hnv99.design.coat.DuluxCoat;
import com.hnv99.design.coat.NipponCoat;
import com.hnv99.design.floor.InovarFloor;
import com.hnv99.design.tile.MarcoPoloTile;
import com.hnv99.design.tile.PrimeTile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DecorationPackageController {

    public String getMatterList(BigDecimal area, Integer level) {
        List<Matter> list = new ArrayList<Matter>(); // Danh sách vật liệu trang trí
        BigDecimal price = BigDecimal.ZERO;          // Giá trang trí

        // Sang trọng Châu Âu
        if (1 == level) {

            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling(); // Trần nhà, trần nhà cấp hai
            DuluxCoat duluxCoat = new DuluxCoat();                   // Sơn, sơn Dulux
            InovarFloor inovarFloor = new InovarFloor();             // Sàn, sàn Inovar

            list.add(levelTwoCeiling);
            list.add(duluxCoat);
            list.add(inovarFloor);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(duluxCoat.price()));
            price = price.add(area.multiply(inovarFloor.price()));

        }

        // Nông thôn nhẹ nhàng
        if (2 == level) {

            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling(); // Trần nhà, trần nhà cấp hai
            NipponCoat nipponCoat = new NipponCoat();                // Sơn, sơn nippon
            MarcoPoloTile marcoPoloTile = new MarcoPoloTile();       // Gạch, gạch Marco Polo

            list.add(levelTwoCeiling);
            list.add(nipponCoat);
            list.add(marcoPoloTile);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(nipponCoat.price()));
            price = price.add(area.multiply(marcoPoloTile.price()));

        }

        // Hiện đại đơn giản
        if (3 == level) {

            LevelOneCeiling levelOneCeiling = new LevelOneCeiling();  // Trần nhà, trần nhà cấp một
            NipponCoat nipponCoat = new NipponCoat();                 // Sơn, sơn Li Bang
            PrimeTile primeTile = new PrimeTile();           // Gạch, gạch Đông Bằng

            list.add(levelOneCeiling);
            list.add(nipponCoat);
            list.add(primeTile);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelOneCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(nipponCoat.price()));
            price = price.add(area.multiply(primeTile.price()));
        }

        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "Danh sách vật liệu trang trí" + "\r\n" +
                "Cấp độ gói：" + level + "\r\n" +
                "Giá gói：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " đồng\r\n" +
                "Diện tích nhà：" + area.doubleValue() + " mét vuông\r\n" +
                "Danh sách vật liệu：\r\n");

        for (Matter matter: list) {
            detail.append(matter.scene()).append("：").append(matter.brand()).append("、").append(matter.model()).append("、Giá/m²：").append(matter.price()).append(" đồng。\n");
        }

        return detail.toString();
    }

}
