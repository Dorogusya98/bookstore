package vt41.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vt41.bookstore.domain.entity.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    Optional<Book> findBookByBookTitleAndBookAuthorAndBookPDate(String title, String name, String date);
}
