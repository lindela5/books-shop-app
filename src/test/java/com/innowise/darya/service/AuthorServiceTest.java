package com.innowise.darya.service;

import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.entity.Author;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    @Mock //создаем заглушку (или макет)
    AuthorRepository authorRepository;

    //   @InjectMocks //создает экземпляр класса и внедряет @Mock созданные с @Mock (или @Spy) в этот экземпляр
    AuthorService authorService;

    private static final Long WRONG_ID = 8L;
    static final Long ID = 6L;
    static final String FIRST_NAME = "Agatha";
    static final String LAST_NAME = "Christie";
    static final String COUNTRY = "United Kingdom";


    //@formatter=off
    static final AuthorDTO AUTHOR_DTO =
            AuthorDTO.builder()
                    .authorId(ID)
                    .authorFirstName(FIRST_NAME)
                    .authorLastName(LAST_NAME)
                    .authorCountry(COUNTRY)
                    .build();

    static final Author AUTHOR =
            Author.builder()
                    .authorId(ID)
                    .firstName(FIRST_NAME)
                    .lastName(LAST_NAME)
                    .country(COUNTRY)
                    .build();
    //@formatter=on

    @BeforeEach
    public void initMock() {
        authorService = new AuthorServiceImpl(authorRepository);
    }

    @Test
    public void shouldThrowAuthorThereIsNoSuchException() {
        given(authorRepository.findById(WRONG_ID)).willReturn(null);
        assertThrows(ThereIsNoSuchException.class, () -> authorService.getAuthorById(WRONG_ID));
        then(authorRepository).should(only()).findById(WRONG_ID);

    }


    @Test
    public void shouldReturnAuthorById() {
        given(authorRepository.findById(ID)).willReturn(Optional.ofNullable(AUTHOR));
        AuthorDTO actual = authorService.getAuthorById(ID);
        assertEquals(AUTHOR_DTO, actual);
        then(authorRepository).should(only()).findById(ID);

    }

}