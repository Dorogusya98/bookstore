package vt41.bookstore.domain.entity;
import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String bookTitle;
    @Column(nullable = false)
    private String bookAuthor;
    @Column(nullable = false)
    private String bookPDate;
    @Column(nullable = false)
    private Long bookCount;
    @Column(nullable = false)
    private Double bookCost;
    @Column(nullable = false)
    private Double bookRentPrice;
    private String bookPublisher;
    private String bookAnnotation;
    private Integer bookNmPages;

    public Book(String bookTitle, Long bookCount, Double bookCost,
                Double bookRentPrice, String bookPDate, String bookAuthor) {
        this.bookTitle = bookTitle;
        this.bookCount = bookCount;
        this.bookCost = bookCost;
        this.bookRentPrice = bookRentPrice;
        this.bookPDate = bookPDate;
        this.bookAuthor = bookAuthor;
    }

    public Book() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Long getBookCount() {
        return bookCount;
    }

    public void setBookCount(Long bookCount) {
        this.bookCount = bookCount;
    }

    public Double getBookCost() {
        return bookCost;
    }

    public void setBookCost(Double bookCost) {
        this.bookCost = bookCost;
    }

    public Double getBookRentPrice() {
        return bookRentPrice;
    }

    public void setBookRentPrice(Double bookRentPrice) {
        this.bookRentPrice = bookRentPrice;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookPDate() {
        return bookPDate;
    }

    public void setBookPDate(String bookPDate) {
        this.bookPDate = bookPDate;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookAnnotation() {
        return bookAnnotation;
    }

    public void setBookAnnotation(String bookAnnotation) {
        this.bookAnnotation = bookAnnotation;
    }

    public Integer getBookNmPages() {
        return bookNmPages;
    }

    public void setBookNmPages(Integer bookNmPages) {
        this.bookNmPages = bookNmPages;
    }
}
