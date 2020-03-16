package vt41.bookstore.dto;

public class BookInfo {
    Double purchasePrice;
    Double rentPrice;

    public BookInfo(Double purchasePrice, Double rentPrice) {
        this.purchasePrice = purchasePrice;
        this.rentPrice = rentPrice;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Double rentPrice) {
        this.rentPrice = rentPrice;
    }
}
