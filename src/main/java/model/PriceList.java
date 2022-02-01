package model;

public class PriceList {
    private int barCode;
    private int price;
    private String productName;

    public PriceList(int barCode, int price, String productName) {
        this.barCode = barCode;
        this.price = price;
        this.productName = productName;
    }

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "model.PriceList {" +
                "barCode=" + barCode +
                ", price=" + price +
                ", productName='" + productName + '\'' +
                '}';
    }
}
