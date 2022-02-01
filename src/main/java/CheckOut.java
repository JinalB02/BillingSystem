import service.BillInput;

import java.util.ArrayList;

import static service.ProcessBill.*;

public class CheckOut {
    public static void main(String[] args) {
        ArrayList<Integer> products = BillInput.addItems();
        printBill(products);
    }

}
