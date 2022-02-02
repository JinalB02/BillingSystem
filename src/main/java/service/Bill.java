package service;
import java.util.ArrayList;

public class Bill {
    public ArrayList<Long> items = new ArrayList();
    public void addItem(Long barCode) {
        items.add(barCode);
    }
}
