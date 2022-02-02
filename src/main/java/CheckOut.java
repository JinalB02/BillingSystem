import service.BillInput;
import service.ProcessBill;

import java.util.ArrayList;

public class CheckOut {
    public static void main(String[] args) {
        ProcessBill processBill = new ProcessBill();
        BillInput billInput = new BillInput();
        ArrayList<Long> products = billInput.addItems();
        processBill.printBill(products);
    }
}
