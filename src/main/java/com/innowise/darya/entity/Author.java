package com.innowise.darya.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "author")
    private Set<Book> books = new HashSet<>();



//    @Override
//    public int hashCode() {
//        return Objects.hash(authorId, firstName, lastName, country);
//    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
