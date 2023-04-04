package com.innowise.darya.service;

import com.innowise.darya.dto.OrderDTO;


public interface OrderService {


    OrderDTO getOrderById(Long id);

    OrderDTO saveOrder(OrderDTO orderDto);

    void deleteOrder(Long oderId);


}
