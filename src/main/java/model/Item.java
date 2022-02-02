package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Item implements Serializable {
    @JsonProperty("barCode")
    private final long barCode;

    @JsonProperty("price")
    private final double price;

    @JsonProperty("productName")
    private final String productName;

    public Item(long barCode, double price, String productName) {
        this.barCode = barCode;
        this.price = price;
        this.productName = productName;
    }

    Item(){
        this.barCode = 0;
        this.price = 0;
        this.productName = null;
    }

    public long getBarCode() {
        return barCode;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "PriceList {" +
                "barCode=" + barCode +
                ", price=" + price +
                ", productName='" + productName + '\'' +
                '}';
    }
}
