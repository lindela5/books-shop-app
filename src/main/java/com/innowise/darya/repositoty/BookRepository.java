package com.innowise.darya.repositoty;

import com.innowise.darya.entity.Author;
import com.innowise.darya.entity.Book;
import com.innowise.darya.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

import static org.hibernate.loader.Loader.SELECT;

public interface BookRepository extends JpaRepository<Book, Long> {

//    Book findByBookId(Long bookId);

//    Set<Book> findBookByYearOfIssue(Integer yearOfIssue);

    //    @Query("SELECT b FROM Book b where b.section.id = :sectionId")
    List<Book> findBySectionId(@Param("sectionId") Long sectionId);

    @Query("select a from Book b join b.author a " +
            "where b.issueYear = :year")
    List<Author> findAuthorsByYear(@Param("year") String year);

}

