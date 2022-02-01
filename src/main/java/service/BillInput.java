package service;

import java.util.ArrayList;
import java.util.Scanner;

public class BillInput {
    public static ArrayList<Integer> addItems() {
        ArrayList<Integer> productList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the items:");
        while (true) {
            String s = in.nextLine();
            if (s.equals("") | s.equals("EXIT")) {
                break;
            } else {
                productList.add(Integer.parseInt(s));
            }
        }
        return productList;
    }
}
