package com.innowise.darya.service;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.entity.Author;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.AuthorRepository;
import com.innowise.darya.transformer.AuthorDTOTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public AuthorDTO getAuthorById(long id) {
        Optional<Author> author = Optional.ofNullable(authorRepository.findByAuthorId(id));
        if (!author.isPresent()) {
            log.error("There is no such author");
            throw new ThereIsNoSuchException("author");
        }
        AuthorDTO authorDTO = AuthorDTOTransformer.AUTHOR_DTO_TRANSFORMER.authorToAuthorDTO(author.get());
        return authorDTO;
    }

    @Override
    public AuthorDTO saveAuthor(AuthorDTO authorDto) {
        Author savedAuthor = authorRepository.save(AuthorDTOTransformer.AUTHOR_DTO_TRANSFORMER.authorDTOToAuthor(authorDto));
        return AuthorDTOTransformer.AUTHOR_DTO_TRANSFORMER.authorToAuthorDTO(savedAuthor);
    }

    @Override
    public void deleteAuthor(long authorId) {
        authorRepository.deleteById(authorId);
    }
}

