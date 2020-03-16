package vt41.bookstore.controller;

import com.sun.istack.Nullable;
import org.hibernate.mapping.Collection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vt41.bookstore.domain.entity.Book;
import vt41.bookstore.dto.BookInfo;
import vt41.bookstore.dto.BookOperation;
import vt41.bookstore.repo.BookRepo;
import vt41.bookstore.service.BookService;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> list() {
        return bookService.findAll();
    }

    @GetMapping("/books/create")
    public String bookCreate() {
        if (bookService.bookCreate())
            return "Book are created";
        else return "Oppps";
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @PutMapping("/books/sub")
    public ResponseEntity<BookInfo> bookSub(@RequestBody BookOperation data) {
        Optional<Book> b = bookService.subBook(data.getBookTypeId(), data.getAmountBooks());
        return b.map(book -> ResponseEntity.ok().body(new BookInfo(book.getBookCost(), book.getBookRentPrice()))).orElseGet(() -> ResponseEntity.badRequest().body(null));
    }

    @PutMapping("/books/ref")
    public ResponseEntity<BookInfo> bookRef(@RequestBody BookOperation data) {
        if (bookService.addBook(data.getBookTypeId(), data.getAmountBooks()))
            return ResponseEntity.ok().body(null);
        else
            return ResponseEntity.badRequest().body(null);
    }
}
