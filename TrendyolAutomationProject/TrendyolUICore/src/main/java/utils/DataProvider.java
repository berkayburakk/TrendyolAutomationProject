package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DataProvider {


    public static Object[][] getData() {
        Map<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> a1 = new ArrayList<>();
        ArrayList<String> a2 = new ArrayList<>();
        ArrayList<String> a3 = new ArrayList<>();
        ArrayList<String> a4 = new ArrayList<>();

        a1.add("monster"); a1.add("xioami"); a1.add("ikea"); a1.add("samsung"); a1.add("lg");
        a2.add("monster"); a2.add("kitap");a2.add("mağaza");a2.add("omega"); a2.add("palme");a2.add("olcay");
        a3.add("elektronik"); a3.add("ev"); a3.add("Mağaza"); a3.add("mouse"); a3.add("klavye");
        a4.add("çanta");

        map.put("Marka", a1);
        map.put("Mağaza", a2);
        map.put("Kategori", a3);
        map.put("Ürün", a4);

        return new Object[][]{{map}};

    }
}
