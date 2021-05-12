package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.Book;
import pl.coderslab.app.BookService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/admin/books")
public class Workshop6BookController {

    private final BookService bookService;

    public Workshop6BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showBookList(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "bookList";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "addBookForm";
    }

    @PostMapping("/add")
    public String addBookPerform(@Valid Book book, BindingResult result, @RequestParam String button) {
        if (button.equals("save")) {
            if(result.hasErrors()){
                return "addBookForm";
            }
            bookService.addBook(book);
        }
        return "redirect:/admin/books/all";
    }

    @GetMapping("/edit/{id}")
    public String editBook(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookService.getBookById(id));
        return "editBookForm";
    }

    @PostMapping("/edit/{id}")
    public String editBookPerform(@Valid Book book,BindingResult result, @RequestParam String button) {
        if (button.equals("save")) {
            if(result.hasErrors()){
                return "editBookForm";
            }
            bookService.updateBook(book);
        }
        return "redirect:/admin/books/all";
    }

    @GetMapping("/confirm-delete/{id}")
    public String deleteBookById(Model model, @PathVariable Long id) {
        model.addAttribute("book", bookService.getBookById(id));
        return "deleteBook";
    }

    @PostMapping("/delete/{id}")
    public String deleteBookByIdPerform(@PathVariable Long id, @RequestParam String confirm) {
        if (confirm.equals("delete")) {
            bookService.deleteBook(id);
        }
        return "redirect:/admin/books/all";
    }

    @GetMapping("/find/{id}")
    public String findBookById(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book",book);
        return "showOneBook";
    }

}
