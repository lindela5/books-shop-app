package com.innowise.darya.service;

import com.innowise.darya.dto.OrderDTO;


public interface OrderService {


    OrderDTO getOrderById(long id);

    OrderDTO saveOrder(OrderDTO orderDto);

    void deleteOrder(long oderId);


}
