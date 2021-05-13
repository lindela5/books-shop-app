package com.innowise.darya.service;

import com.innowise.darya.dto.AuthorDTO;


public interface AuthorService {

    AuthorDTO getAuthorById(Long id);

    AuthorDTO saveAuthor(AuthorDTO authorDto);

    void deleteAuthor(Long authorId);

}

