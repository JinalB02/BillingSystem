package service;

import model.BillItem;
import model.PriceList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.Items;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ProcessBillTest {

    private static ProcessBill processBill;

    @Before
    public void setUp() {
        processBill = new ProcessBill();
    }

    @Test
    public void generateBill_NotNull() {
        ArrayList list = new ArrayList();
        list.add(2);
        list.add(3);
        Assert.assertNotNull(processBill.generateBill(Items.getProducts(), list));
    }

    @Test
    public void generateBill_ListElementsMatch() {
        ArrayList list = new ArrayList();
        list.add(2);
        list.add(3);
        List<BillItem> billItems = processBill.generateBill(Items.getProducts(), list);
        Assert.assertTrue(billItems.stream().anyMatch(item -> "Banana".equals(item.getProductName())));
    }


    @Test
    public void getBillProducts_NotNull(){
        ArrayList list = new ArrayList();
        list.add(2);
        list.add(3);
        List<BillItem> billProducts = processBill.getBillProducts(list);
        Assert.assertNotNull(billProducts);
    }

    @Test
    public void getBillProducts_ListElementsMatch(){
        ArrayList list = new ArrayList();
        list.add(2);
        list.add(3);
        Assert.assertTrue(((List<PriceList>) processBill.getBillProducts(list)).stream().anyMatch(item -> "Banana".equals(item.getProductName())));
    }

    @Test
    public void printBill_CheckOutputMatch() {
        ArrayList list = new ArrayList();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);

        PrintStream oldOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        processBill.printBill(list);

        System.setOut(oldOut);
        String output = new String(baos.toByteArray());

        Assert.assertTrue(output.contains("15"));
    }

}