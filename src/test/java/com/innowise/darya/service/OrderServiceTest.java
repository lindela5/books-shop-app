package com.innowise.darya.service;

import com.innowise.darya.dto.BookDTO;
import com.innowise.darya.dto.OrderDTO;
import com.innowise.darya.entity.Book;
import com.innowise.darya.entity.Customer;
import com.innowise.darya.entity.Order;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.math.BigDecimal.TEN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

//    @InjectMocks
    OrderService orderService;

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

    static final List<Book> BOOK_ORDER = List.of(
            BOOK1,
            BOOK2);
    static final List<BookDTO> BOOK_ORDER_DTO = List.of(
            BOOK1_DTO,
            BOOK2_DTO);


    static final Long CUSTOMER_ID = 2L;
    static final String FIRST_NAME = "Volga";
    static final String LAST_NAME = "Semencova";
    static final String ADDRESS = "246000, Gomel, Lienin Ave 6/14";
    static final String PHONE = "+375336541212";
    static final String EMAIL = "volga_semencova@mail.ru";

    static final Customer CUSTOMER = Customer.builder()
            .customerId(CUSTOMER_ID)
            .firstName(FIRST_NAME)
            .lastName(LAST_NAME)
            .address(ADDRESS)
            .phone(PHONE)
            .email(EMAIL)
            .build();

    static final LocalDate ORDER_DATE = LocalDate.parse("2020-01-14");
    static final BigDecimal AMOUNT = new BigDecimal(213);

    //@formatter=off
    static final OrderDTO ORDER_DTO =
            OrderDTO.builder()
                    .orderId(ID)
                    .bookOrder(BOOK_ORDER_DTO)
                    .customer(CUSTOMER)
                    .orderDate(ORDER_DATE)
                    .amount(AMOUNT)
                    .build();

    static final Order ORDER =
            Order.builder()
                    .orderId(ID)
                    .bookOrder(BOOK_ORDER)
                    .customer(CUSTOMER)
                    .orderDate(ORDER_DATE)
                    .amount(AMOUNT)
                    .build();
    //@formatter=on

    @BeforeEach
    public void initMock() {
        orderService = new OrderServiceImpl(orderRepository);
    }

    @Test
    public void shouldThrowOrderThereIsNoSuchException() {
        given(orderRepository.findById(WRONG_ID)).willReturn(null);
        assertThrows(ThereIsNoSuchException.class, () -> orderService.getOrderById(WRONG_ID));
        then(orderRepository).should(only()).findById(WRONG_ID);

    }

    @Test
    public void shouldReturnOrderById() {
        given(orderRepository.findById(ID)).willReturn(Optional.ofNullable(ORDER));
        OrderDTO actual = orderService.getOrderById(ID);
        assertEquals(ORDER_DTO, actual);
        then(orderRepository).should(only()).findById(ID);

    }

}