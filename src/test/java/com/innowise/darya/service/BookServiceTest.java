package com.innowise.darya.service;


import com.innowise.darya.dto.AuthorDTO;
import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.entity.Author;
import com.innowise.darya.entity.Book;
import com.innowise.darya.entity.PublishingHouse;
import com.innowise.darya.entity.Section;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.innowise.darya.entity.Book.aBook;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
        // добавим к тестовому классу расширение Mockito.
class BookServiceTest {

    @Mock //создаем заглушку (или макет)
    BookRepository bookRepository;


    //@InjectMocks //создает экземпляр класса и внедряет @Mock созданные с @Mock (или @Spy) в этот экземпляр
    BookService bookService;


    private static final Long WRONG_ID = 16L;
    static final Long ID = 2L;
    static final String BOOK_TITLE = "Good Omens";

    static final Long AUTHOR1_ID = 8L;
    static final Long AUTHOR2_ID = 9L;

    static final Author AUTHOR1 =
            Author.builder()
                    .authorId(AUTHOR1_ID)
                    .build();
    static final Author AUTHOR2 =
            Author.builder()
                    .authorId(AUTHOR2_ID)
                    .build();

    static final AuthorDTO AUTHOR1_DTO =
            AuthorDTO.builder()
                    .authorId(AUTHOR1_ID)
                    .build();
    static final AuthorDTO AUTHOR2_DTO =
            AuthorDTO.builder()
                    .authorId(AUTHOR2_ID)
                    .build();

    static final List<Author> AUTHOR_BOOK = List.of(
            AUTHOR1,
            AUTHOR2);

    static final List<AuthorDTO> AUTHOR_BOOK_DTO = List.of(
            AUTHOR1_DTO,
            AUTHOR2_DTO);

    static final String ISBN = "9781910281918";

    static final Long SECTION_ID = 8L;
    static final String NAME_SECTION = "Mystery";
    static final Section SECTION = Section.builder()
            .id(SECTION_ID)
            .nameSection(NAME_SECTION)
            .build();

    static final Integer ISSUE_YEAR = Integer.valueOf("2015");

    static final Long PUBLISHER_ID = 8L;
    static final String NAME_PUBLISHER = "Mystery";
    static final PublishingHouse PUBLISHING_HOUSE = PublishingHouse.builder()
            .publishingHouseId(PUBLISHER_ID)
            .namePublisher(NAME_PUBLISHER)
            .build();

    static final BigDecimal PRICE = new BigDecimal(23.16);
    static final Integer STOCK_BALANCES = Integer.valueOf("1");


    //@formatter=off

    static final BookDTO BOOKDTO =
            BookDTO.builder()
                    .bookId(ID)
                    .bookTitle(BOOK_TITLE)
                    .bookAuthor(AUTHOR_BOOK_DTO)
                    .isbn(ISBN)
                    .section(SECTION)
                    .issueYear(ISSUE_YEAR)
                    .publishingHouse(PUBLISHING_HOUSE)
                    .price(PRICE)
                    .stockBalances(STOCK_BALANCES)
                    .build();

    static final Book BOOK =
            aBook()
                    .bookId(ID)
                    .title(BOOK_TITLE)
                    .author(AUTHOR_BOOK)
                    .isbn(ISBN)
                    .section(SECTION)
                    .issueYear(ISSUE_YEAR)
                    .publishingHouse(PUBLISHING_HOUSE)
                    .price(PRICE)
                    .stockBalances(STOCK_BALANCES)
                    .build();
    //@formatter=on

    @BeforeEach
    public void initMock() {
        bookService = new BookServiceImpl(bookRepository);
    }

    @Test
    public void shouldThrowBookThereIsNoSuchException() {
        given(bookRepository.findById(WRONG_ID)).willReturn(null);
        assertThrows(ThereIsNoSuchException.class, () -> bookService.getBookById(WRONG_ID));
        then(bookRepository).should(only()).findById(WRONG_ID);

    }

    @Test
    public void shouldReturnBookById() {
        given(bookRepository.findById(ID)).willReturn(Optional.ofNullable(BOOK));
        BookDTO actual = bookService.getBookById(ID);
        assertEquals(BOOKDTO, actual);
        then(bookRepository).should(only()).findById(ID);
        verifyNoMoreInteractions(bookRepository);
    }

}