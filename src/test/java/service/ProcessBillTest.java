package service;

import model.BillItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.ItemsRepository;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ProcessBillTest {

    private static ProcessBill processBill;
    private static ItemsRepository itemsRepository;

    @Before
    public void setUp() {
        processBill = new ProcessBill();
        itemsRepository = new ItemsRepository();
    }

    @Test
    public void createBill_NoInput() {
        List<BillItem> billItems = new ArrayList<>();
        Assert.assertTrue(processBill.createBill(billItems).isEmpty());
    }

    @Test
    public void createBill_BillItemsList_MatchOutput() {
        List<BillItem> billItems = new ArrayList<>();
        billItems.add(new BillItem(01001, 1.1, "Apple", 2, 2.2));
        Assert.assertFalse(processBill.createBill(billItems).isEmpty());
        Assert.assertTrue(processBill.createBill(billItems).contains("2 x Apple @1.1 = 2.2"));
    }

    @Test
    public void generateBillItems_NoInput() {
        ArrayList<Long> list = new ArrayList();
        Assert.assertTrue(processBill.generateBillItems(itemsRepository.getProducts(), list).isEmpty());
    }

    @Test
    public void generateBillItems_MatchOutput() {
        ArrayList<Long> list = new ArrayList();
        list.add(Long.parseLong("01001"));
        list.add(Long.parseLong("01001"));
        Assert.assertFalse(processBill.generateBillItems(itemsRepository.getProducts(), list).isEmpty());
        Assert.assertTrue((processBill.generateBillItems(itemsRepository.getProducts(), list)).stream().filter(p->p.getProductName().equals("Apple")).findFirst().isPresent());
    }

    @Test
    public void getBillProducts_NoInput() {
        ArrayList<Long> list = new ArrayList();
        Assert.assertTrue(processBill.getBillProducts(list).isEmpty());
    }

    @Test
    public void getBillProducts_MatchOutput() {
        ArrayList<Long> list = new ArrayList();
        list.add(Long.parseLong("01001"));
        list.add(Long.parseLong("01001"));
        Assert.assertFalse(processBill.getBillProducts(list).isEmpty());
        Assert.assertTrue((processBill.getBillProducts(list)).stream().filter(p->p.getProductName().equals("Apple")).findFirst().isPresent());
    }

    @Test
    public void printBill_MatchOutput() {
        ArrayList list = new ArrayList();
        list.add(Long.parseLong("01001"));
        list.add(Long.parseLong("01001"));

        PrintStream oldOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        processBill.printBill(list);

        System.setOut(oldOut);
        String output = new String(baos.toByteArray());
        Assert.assertTrue(output.contains("2.2"));
    }

}