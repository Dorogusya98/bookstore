package vt41.bookstore.service;

import vt41.bookstore.domain.entity.Book;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BookService {

    boolean bookCreate();

    boolean save(Book book);

    boolean update(Book book);

    boolean delete(Long id);

    boolean addBook(Long bookTypeId, Long bookCount);

    Optional<Book> subBook(Long bookTypeId, Long bookCount);

    List<Book> findAll();

    Optional<Book> findBookById(Long id);
}
