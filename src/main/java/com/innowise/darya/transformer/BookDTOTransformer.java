package com.innowise.darya.transformer;

import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.entity.Book;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = AuthorDTOTransformer.class)
public interface BookDTOTransformer {
    BookDTOTransformer BOOK_DTO_TRANSFORMER = Mappers.getMapper(BookDTOTransformer.class);

    @Mappings({
            @Mapping(target = "bookId", source = "entity.bookId"),
            @Mapping(target = "bookTitle", source = "entity.title"),
            @Mapping(target = "bookAuthor", source = "entity.author"),
            @Mapping(target = "isbn", source = "entity.isbn"),
            @Mapping(target = "section", source = "entity.section"),
            @Mapping(target = "yearOfIssue", source = "entity.yearOfIssue"),
            @Mapping(target = "publishingHouse", source = "entity.publishingHouse"),
            @Mapping(target = "price", source = "entity.price"),
            @Mapping(target = "stockBalances", source = "entity.stockBalances"),
            @Mapping(target = "picture", source = "entity.picture")
    })
    BookDTO bookToBookDTO(Book entity);

    @InheritInverseConfiguration
    //Аннотация определяет, что обратное отображение @InheritInverseConfiguration должно быть выполнено.
    Book bookDTOToBook(BookDTO dto);
}