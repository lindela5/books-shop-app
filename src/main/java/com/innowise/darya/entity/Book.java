package com.innowise.darya.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Data
@EqualsAndHashCode(exclude = "author")
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "aBook")
public class Book {

    @Id
    private Long bookId;

    private String title;

    @NotBlank
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "bookId"),
            inverseJoinColumns = @JoinColumn(name = "authorId"))
    private Set<Author> author = new HashSet<>();

    private String isbn;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id")
    private Section section;

    private Integer yearOfIssue;

    @NotBlank
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publishing_house_id")
    private PublishingHouse publishingHouse;

    private BigDecimal price;
    private Integer stockBalances;
    private String picture;

//    @Override
//    public int hashCode() {
//        return Objects.hash(bookId, title, isbn, section, yearOfIssue, publishingHouse, price, stockBalances, picture);
//    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", section=" + section +
                ", yearOfIssue=" + yearOfIssue +
                ", publishingHouse=" + publishingHouse +
                ", price=" + price +
                ", stockBalances=" + stockBalances +
                ", picture='" + picture + '\'' +
                '}';
    }


}
