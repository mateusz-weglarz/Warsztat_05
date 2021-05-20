package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.app.Book;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT b from Book b WHERE id=:id")
    Book readBookById(@Param("id")long id);

}
