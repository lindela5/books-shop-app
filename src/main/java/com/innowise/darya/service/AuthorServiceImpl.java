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
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public AuthorDTO getAuthorById(Long id) {
        return authorRepository.findById(id)
                .map(AuthorDTOTransformer.AUTHOR_DTO_TRANSFORMER::authorToAuthorDTO)
                .orElseThrow(() -> new ThereIsNoSuchException("author"));
    }

    @Override
    public AuthorDTO saveAuthor(AuthorDTO authorDto) {
        Author savedAuthor = authorRepository.saveAndFlush(AuthorDTOTransformer.AUTHOR_DTO_TRANSFORMER.authorDTOToAuthor(authorDto));
        return AuthorDTOTransformer.AUTHOR_DTO_TRANSFORMER.authorToAuthorDTO(savedAuthor);
    }

    @Override
    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}

