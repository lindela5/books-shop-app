package com.innowise.darya.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "aBook")
public class Book {

    @Id
    private Long bookId;

    private String title;

    @NotBlank
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "bookId"),
            inverseJoinColumns = @JoinColumn(name = "authorId"))
    private List<Author> author = new ArrayList<>();

    private String isbn;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id")
    private Section section;

    private Integer issueYear;

    @NotBlank
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publishing_house_id")
    private PublishingHouse publishingHouse;

    private BigDecimal price;
    private Integer stockBalances;
    private String picture;


}
