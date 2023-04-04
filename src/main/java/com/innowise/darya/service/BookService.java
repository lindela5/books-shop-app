package com.innowise.darya.service;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.entity.Book;
import com.innowise.darya.entity.Section;


import java.util.List;
import java.util.Set;


public interface BookService {

    List<BookDTO> getAllBooks();

    BookDTO getBookById(Long id);

    List<AuthorDTO> getAuthorByYear(String year);

    BookDTO saveBook(BookDTO bookDto);

    void deleteBook(Long bookId);

    List<BookDTO> getBooksBySection(Long id);

}

