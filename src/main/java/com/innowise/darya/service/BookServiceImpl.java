package com.innowise.darya.service;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.entity.Author;
import com.innowise.darya.entity.Book;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.BookRepository;
import com.innowise.darya.transformer.AuthorDTOTransformer;
import com.innowise.darya.transformer.BookDTOTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
@Transactional
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookDTO> bookDTOList = new ArrayList<>();
        List<Book> bookList = bookRepository.findAll();
        for (Book book : bookList) {
            bookDTOList.add(BookDTOTransformer.BOOK_DTO_TRANSFORMER.bookToBookDTO(book));
        }
        return bookDTOList;
    }


    @Override
    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(BookDTOTransformer.BOOK_DTO_TRANSFORMER::bookToBookDTO)
                .orElseThrow(() -> new ThereIsNoSuchException("book"));
    }

    @Override
    public List<AuthorDTO> getAuthorByYear(String year) {
        return Optional.ofNullable(bookRepository.findAuthorsByYear(year))
                .map(Collection::stream)
                .orElseThrow(() -> new ThereIsNoSuchException("author"))
                .map(AuthorDTOTransformer.AUTHOR_DTO_TRANSFORMER::authorToAuthorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO saveBook(BookDTO bookDto) {
        Book savedBook = bookRepository.saveAndFlush(BookDTOTransformer
                .BOOK_DTO_TRANSFORMER.bookDTOToBook(bookDto));
        return BookDTOTransformer.BOOK_DTO_TRANSFORMER.bookToBookDTO(savedBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }


    @Override
    @Transactional(readOnly = true)
    public List<BookDTO> getBooksBySection(Long id) {
        return bookRepository.findBySectionId(id).stream()
                .map(BookDTOTransformer.BOOK_DTO_TRANSFORMER::bookToBookDTO)
                .collect(Collectors.toList());
    }

}
