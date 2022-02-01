package model;

public class BillItem {
    private int quantity;
    private String productName;
    private int total;
    private int price;

    public BillItem(int quantity, String productName, int total, int price) {
        this.quantity = quantity;
        this.productName = productName;
        this.total = total;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BillItem{" +
                "quantity=" + quantity +
                ", productName='" + productName + '\'' +
                ", total=" + total +
                ", price=" + price +
                '}';
    }
}
