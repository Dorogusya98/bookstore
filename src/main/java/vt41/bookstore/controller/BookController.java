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
import javax.validation.Valid;
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
    public String booksCreate() {
        if (bookService.bookCreate())
            return "Book are created";
        else return "Oppps";
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.findBookById(id);
    }

    @DeleteMapping("/books/delete/{id}")
    public String deleteBookById(@PathVariable Long id) {
        if(bookService.delete(id))
            return "Book are deleted";
        else
            return "Oppps";
    }

    @PostMapping("/books/save")
    public String bookCreate(@Valid @RequestBody Book book) {
        if(bookService.save(book))
            return "Book are save";
        else
            return "Oppps";
    }

    @PutMapping("/books/sub")
    public ResponseEntity<?> bookSub(@Valid @RequestBody BookOperation data) {
        Optional<Book> b = bookService.subBook(data.getBookTypeId(), data.getAmountBooks());
        if(b.isPresent())
            return ResponseEntity.ok().body(new BookInfo(b.get().getBookCost(), b.get().getBookRentPrice()));
        else
            return ResponseEntity.badRequest().body("Ошибка: книга не найдена или недостаточно экземпляров данной книги.");
    }

    @PutMapping("/books/ref")
    public ResponseEntity<?> bookRef(@Valid @RequestBody BookOperation data) {
        if (bookService.addBook(data.getBookTypeId(), data.getAmountBooks()))
            return ResponseEntity.ok().body("Успех: книга успешно возвращена!");
        else
            return ResponseEntity.badRequest().body("Ошибка: не удалось вернуть книгу.");
    }
}
