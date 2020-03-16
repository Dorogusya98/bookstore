package vt41.bookstore.dto;

import javax.validation.constraints.NotNull;

public class BookOperation {
    @NotNull
    Long bookTypeId;
    @NotNull
    Long amountBooks;

    public Long getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Long bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public Long getAmountBooks() {
        return amountBooks;
    }

    public void setAmountBooks(Long amountBooks) {
        this.amountBooks = amountBooks;
    }

}
