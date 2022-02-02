package service;

import repository.ItemsRepository;
import model.BillItem;
import model.Item;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ProcessBill {
    private ItemsRepository itemsRepository = new ItemsRepository();

    public void printBill(ArrayList<Long> products) {
        List<Item> billProductList = getBillProducts(products);
        List<BillItem> billItems = generateBillItems(billProductList, products);
        String bill = createBill(billItems);
        System.out.println("**************************BILL*********************************");
        System.out.println(bill);
        System.out.println("***************************************************************");
    }

    protected String createBill(List<BillItem> billItems) {
        String bill = "";
        if (null != billItems && !billItems.isEmpty()) {
            for (BillItem billItem : billItems) {
                bill = bill + billItem.getQuantity() + " x " + billItem.getProductName() + " @" + billItem.getPrice() + " = " + billItem.getTotal() + "\n";
            }
            bill = bill + "          TOTAL = " + billItems.stream().mapToDouble(b -> b.getPrice() * b.getQuantity()).sum();
        }
        return bill;
    }

    public List<BillItem> generateBillItems(List<Item> billProductList, ArrayList<Long> products) {
        List<BillItem> billItems = new ArrayList<>();

        Map<Long, Long> productQuantity = products.stream().collect(
                Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                )
        );

        for (Map.Entry<Long, Long> quantityPerProduct : productQuantity.entrySet()) {
            Optional<Item> billProductItem = billProductList.stream().filter(p -> p.getBarCode() == quantityPerProduct.getKey()).findFirst();
            if (!billProductItem.isEmpty()) {
                Item billProduct = billProductItem.get();
                billItems.add(new BillItem(billProduct.getBarCode(), billProduct.getPrice(), billProduct.getProductName(), quantityPerProduct.getValue(), quantityPerProduct.getValue() * billProduct.getPrice()));
            }
        }

        return billItems;
    }

    public List<Item> getBillProducts(ArrayList<Long> products) {
        return itemsRepository.getProducts().stream().filter(
                product -> products.contains(
                        product.getBarCode()
                )
        ).collect(toList());
    }
}
