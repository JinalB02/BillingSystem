package repository;

import model.PriceList;

import java.util.ArrayList;

public class Items {
    public static ArrayList<PriceList> getProducts() {
        ArrayList<PriceList> list = new ArrayList();
        list.add(new PriceList(1, 10, "Apple"));
        list.add(new PriceList(2, 5, "Banana"));
        list.add(new PriceList(3, 7, "Cherries"));
        list.add(new PriceList(4, 20, "Avocado"));
        list.add(new PriceList(5, 70, "Milk"));
        list.add(new PriceList(6, 40, "Eggs"));
        return list;
    }
}
