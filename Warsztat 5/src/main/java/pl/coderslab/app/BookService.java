package pl.coderslab.app;

import java.util.List;

public interface BookService {
    Book getBookById(long id);

    Book addBook(Book bookToAdd);

    void updateBook(Book bookToUpdate);

    void deleteBook(long id);

    List<Book> getAllBooks();
}
