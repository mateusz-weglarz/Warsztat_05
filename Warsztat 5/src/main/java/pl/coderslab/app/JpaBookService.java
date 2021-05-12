package pl.coderslab.app;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.coderslab.repository.BookRepository;

import java.util.List;

@Repository
@Primary
public class JpaBookService implements BookService {

    private final BookRepository bookRepository;

    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.getOne(id);
    }

    @Override
    public Book addBook(Book bookToAdd) {
        return bookRepository.save(bookToAdd);
    }

    @Override
    public void updateBook(Book bookToUpdate) {
        bookRepository.save(bookToUpdate);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
