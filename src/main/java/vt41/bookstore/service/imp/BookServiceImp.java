package vt41.bookstore.service.imp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vt41.bookstore.domain.entity.Book;
import vt41.bookstore.repo.BookRepo;
import vt41.bookstore.service.BookService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    BookRepo bookRepo;

    @Override
    public boolean bookCreate() {
        try {
            bookRepo.save(new Book("Книга джунглей", 12L, 160., 100.));
            bookRepo.saveAll(Arrays.asList(new Book("Книга леса", 18L, 220., 160.)
                    , new Book("Книга пустыни", 15L, 200., 150.)
                    , new Book("Книга океана", 20L, 250., 200.)
                    , new Book("Книга степи", 25L, 260., 210.)));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean save(Book book) {
        Optional<Book> bookFromDb = bookRepo.findBookByBookTitleAndBookAuthorAndBookPDate(book.getBookTitle(), book.getBookAuthor(), book.getBookPDate());
        if(!bookFromDb.isPresent()) {
            try {
                bookRepo.save(book);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        else {
            try {
                Book b = bookFromDb.get();
                b.setBookCount(book.getBookCount() + b.getBookCount());
                return update(b, book);
            } catch (Exception e) {
                return false;
            }
        }
    }

    @Override
    public boolean update(Book bookFromDb, Book book) {
        try{
            BeanUtils.copyProperties(book, bookFromDb, "id");
            bookRepo.save(bookFromDb);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Book book) {
        try{
            bookRepo.delete(book);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addBook(Long bookTypeId, Long bookCount) {
        Optional<Book> bookFromDb = bookRepo.findById(bookTypeId);
        if (bookFromDb.isPresent()) {
            bookFromDb.get().setBookCount(bookFromDb.get().getBookCount() + bookCount);
            bookRepo.save(bookFromDb.get());
            return true;
        }
        else
            return false;
    }

    @Override
    public Optional<Book> subBook(Long bookTypeId, Long bookCount) {
        Optional<Book> bookFromDb = bookRepo.findById(bookTypeId);
        if(bookFromDb.isPresent() && bookFromDb.get().getBookCount() >= bookCount) {
            bookFromDb.get().setBookCount(bookFromDb.get().getBookCount() - bookCount);
            bookRepo.save(bookFromDb.get());
            return bookFromDb;
        }
        else
            return Optional.empty();
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return bookRepo.findById(id);
    }
}
