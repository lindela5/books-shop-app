package com.innowise.darya.service;

import com.innowise.darya.dto.AuthorDTO;


public interface AuthorService {

    AuthorDTO getAuthorById(long id);

    AuthorDTO saveAuthor(AuthorDTO authorDto);

    void deleteAuthor(long authorId);

}

