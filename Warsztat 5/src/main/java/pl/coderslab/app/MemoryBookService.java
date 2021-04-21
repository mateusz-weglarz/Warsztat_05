package pl.coderslab.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.exeptions.BadResourceExeption;
import pl.coderslab.exeptions.ResourceNotFoundExeptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Primary
public class MemoryBookService implements BookService {

    private final List<Book> list;
    private static final AtomicLong nextId = new AtomicLong(4L);

    private static final Logger log = LoggerFactory.getLogger(MemoryBookService.class);


    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }


    public List<Book> getAllBooks() {
        log.debug("Zwracanie listy wszystkich książek.");
        return list;
    }

    public Book getBookById(long id) {
        log.debug("Pobieranie książki o id: {}", id);
        Book book = list.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(ResourceNotFoundExeptions::new);
        log.debug("Znaleziono książkę: {}", book);
        return book;
    }

    @Override
    public Book addBook(Book bookToAdd) {
        log.debug("Dodawanie książki.");
        if(bookToAdd.getTitle()==null||bookToAdd.getTitle().isBlank()){
            throw new BadResourceExeption("Książka nie ma tytułu.");
        }
        bookToAdd.setId(nextId.incrementAndGet());
        list.add(bookToAdd);
        return bookToAdd;
    }

    @Override
    public void updateBook(Book bookToUpdate) {
        log.debug("Aktualizacja książki.");
        long id = bookToUpdate.getId();
        list.stream()
                .filter(b -> b.getId().equals(id))
                .map(list::indexOf)
                .findFirst()
                .ifPresentOrElse(index -> list.set(index, bookToUpdate), () -> {
                    throw new ResourceNotFoundExeptions();
                });
        log.debug("Książka zaktualizowana");

    }

    public void deleteBook(long id) {
        log.debug("Usuwam książkę to przekazanym id");
        log.debug("Liczba książek przed usunięciem: {}", list.size());
        list.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .ifPresentOrElse(list::remove, () -> {
                    throw new ResourceNotFoundExeptions();
                });
        log.debug("Liczba książek po usunięciu: {}", list.size());
    }
}
