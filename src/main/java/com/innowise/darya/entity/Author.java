package com.innowise.darya.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Data
@EqualsAndHashCode(exclude = "books")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {

    @Id
    private Long authorId;

    private String firstName;
    private String lastName;
    private String country;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();



}
