package pl.coderslab.web;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.Book;
import pl.coderslab.app.BookService;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }


    @GetMapping
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId:\\d+}")
    public Book getBookById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/{bookId:\\d+}")
    public Book updateBook(@RequestBody Book book, @PathVariable long bookId) {
        book.setId(bookId);
        bookService.updateBook(book);
        return book;
    }

    @DeleteMapping("/{bookId:\\d+}")
    public void deleteBook(@PathVariable long bookId) {
        bookService.deleteBook(bookId);
    }

}
