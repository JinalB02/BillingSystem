package service;

import repository.Items;
import model.BillItem;
import model.PriceList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProcessBill {
    public static void printBill(ArrayList<Integer> products) {
        List<PriceList> billProductList = getBillProducts(products);
        List<BillItem> billItems = generateBill(billProductList, products);
        System.out.println("**************************BILL*********************************");
        for (BillItem billItem : billItems) {
            System.out.println(billItem.getQuantity() + " x " + billItem.getProductName() + " @" + billItem.getPrice() + " = " + billItem.getTotal());
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("           TOTAL = " + billItems.stream().mapToInt(b -> b.getPrice() * b.getQuantity()).sum());
        System.out.println("***************************************************************");
    }

    public static List<BillItem> generateBill(List<PriceList> billProductList, ArrayList<Integer> products) {
        int quantity;
        List<BillItem> billItems = new ArrayList<>();
        try {
            List<Integer> distinctProducts = products.stream()
                    .distinct()
                    .collect(Collectors.toList());
            for (Integer product : distinctProducts) {
                quantity = Collections.frequency(products, product);
                Optional<PriceList> billProductItem = billProductList.stream().filter(p -> p.getBarCode() == product).findFirst();
                if(!billProductItem.isEmpty()) {
                    PriceList billProduct = billProductItem.get();
                    billItems.add(new BillItem(quantity, billProduct.getProductName(), quantity * billProduct.getPrice(), billProduct.getPrice()));
                }
            }
        }
        catch (RuntimeException e) {
            e.printStackTrace();
        }
        return billItems;
    }

    public static List<PriceList> getBillProducts(ArrayList<Integer> products) {
        return Items.getProducts().stream().filter(
                product -> products.contains(
                        product.getBarCode()
                )
        ).collect(Collectors.toList());
    }
}
