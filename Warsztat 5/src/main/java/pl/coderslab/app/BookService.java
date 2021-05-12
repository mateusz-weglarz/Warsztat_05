package pl.coderslab.app;

import java.util.List;


public interface BookService {

    Book getBookById(Long id);

    Book addBook(Book bookToAdd);

    void updateBook(Book bookToUpdate);

    void deleteBook(Long id);

    List<Book> getAllBooks();
}
