package com.innowise.darya.service;

import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.dto.SupplyDTO;
import com.innowise.darya.entity.Book;
import com.innowise.darya.entity.Supplier;
import com.innowise.darya.entity.Supply;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.SupplyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static java.math.BigDecimal.TEN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;

@ExtendWith(MockitoExtension.class)
class SupplyServiceTest {

    @Mock
    SupplyRepository supplyRepository;

  //  @InjectMocks
    SupplyService supplyService;

    private static final Long WRONG_ID = 18L;
    static final Long ID = 1L;
    static final Long BOOK1_ID = 2L;
    static final Long BOOK2_ID = 3L;
    static final Book BOOK1 =
            Book.aBook()
                    .bookId(BOOK1_ID)
                    .price(TEN)
                    .build();
    static final Book BOOK2 =
            Book.aBook()
                    .bookId(BOOK2_ID)
                    .price(TEN)
                    .build();

    static final BookDTO BOOK1_DTO =
            BookDTO.builder()
                    .bookId(BOOK1_ID)
                    .price(TEN)
                    .build();

    static final BookDTO BOOK2_DTO =
            BookDTO.builder()
                    .bookId(BOOK2_ID)
                    .price(TEN)
                    .build();

    static final Set<Book> BOOK_SUPPLY = Set.of(
            BOOK1,
            BOOK2);
    static final Set<BookDTO> BOOK_SUPPLY_DTO = Set.of(
            BOOK1_DTO,
            BOOK2_DTO);

    static final String SUPPLIER_NAME = "Perfect books";
    static final String ADDRESS = "14 Pinskaya Street, Gomel, Belarus";
    static final String PHONE = "+375291251256";

    static final Supplier SUPPLIER = Supplier.builder()
            .id(ID)
            .supplierName(SUPPLIER_NAME)
            .address(ADDRESS)
            .phone(PHONE)
            .build();

    static final LocalDate SUPPLY_DATE = LocalDate.parse("2020-01-14");
    static final BigDecimal SUPPLIER_PRICE = new BigDecimal(213);


    //@formatter=off
    static final SupplyDTO SUPPLY_DTO =
            SupplyDTO.builder()
                    .supplyId(ID)
                    .bookSupply(BOOK_SUPPLY_DTO)
                    .supplier(SUPPLIER)
                    .supplyDate(SUPPLY_DATE)
                    .supplierPrice(SUPPLIER_PRICE)
                    .build();

    static final Supply SUPPLY =
            Supply.builder()
                    .supplyId(ID)
                    .bookSupply(BOOK_SUPPLY)
                    .supplier(SUPPLIER)
                    .supplyDate(SUPPLY_DATE)
                    .supplierPrice(SUPPLIER_PRICE)
                    .build();
    //@formatter=on


    @BeforeEach
    public void initMock() {
        supplyService = new SupplyServiceImpl(supplyRepository);
    }

    @Test
    public void shouldThrowSupplyThereIsNoSuchException() {
        given(supplyRepository.findBySupplyId(WRONG_ID)).willReturn(null);
        assertThrows(ThereIsNoSuchException.class, () -> supplyService.getSupplyById(WRONG_ID));
        then(supplyRepository).should(only()).findBySupplyId(WRONG_ID);

    }

    @Test
    public void shouldReturnSupplyById() {
        given(supplyRepository.findBySupplyId(ID)).willReturn(SUPPLY);
        SupplyDTO actual = supplyService.getSupplyById(ID);
        assertEquals(SUPPLY_DTO, actual);
        then(supplyRepository).should(only()).findBySupplyId(ID);

    }

}