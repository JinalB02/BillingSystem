package model;

public class BillItem extends Item{

    private final long quantity;
    private final double total;

    public BillItem(long barCode, double price, String productName, long quantity, double total) {
        super(barCode, price, productName);
        this.quantity = quantity;
        this.total = total;
    }

    public long getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "BillItem {" +
                "quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
