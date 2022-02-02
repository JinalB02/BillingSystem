package service;

import java.util.ArrayList;
import java.util.Scanner;

public class BillInput {
    public ArrayList<Long> addItems() {
        ArrayList<Long> productList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the barcode:");
        while (true) {
            String s = in.nextLine();
            if (s.equals("") | s.equals("EXIT")) {
                break;
            } else {
                productList.add(Long.parseLong(s));
            }
        }
        return productList;
    }
}
