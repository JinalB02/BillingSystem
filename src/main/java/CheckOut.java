import repository.ItemsRepository;
import service.Bill;
import service.ProcessBill;

import java.util.ArrayList;

public class CheckOut {
    public static void main(String[] args) {
        ItemsRepository itemsRepository = new ItemsRepository();
        ProcessBill processBill = new ProcessBill(itemsRepository);
        Bill bill = new Bill();
        bill.addItem(Long.parseLong("01001"));
        bill.addItem(Long.parseLong("02002"));
        bill.addItem(Long.parseLong("03003"));
        bill.addItem(Long.parseLong("03003"));
        bill.addItem(Long.parseLong("01001"));
        bill.addItem(Long.parseLong("01001"));
        processBill.printBill(bill.items);
    }
}
