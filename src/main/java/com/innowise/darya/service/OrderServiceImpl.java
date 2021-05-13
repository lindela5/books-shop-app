package com.innowise.darya.service;

import com.innowise.darya.dto.OrderDTO;
import com.innowise.darya.entity.Order;
import com.innowise.darya.exception.ThereIsNoSuchException;
import com.innowise.darya.repositoty.OrderRepository;
import com.innowise.darya.transformer.OrderDTOTransformer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public OrderDTO getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(OrderDTOTransformer.ORDER_DTO_TRANSFORMER::orderToOrderDTO)
                .orElseThrow(() -> new ThereIsNoSuchException("order"));
    }

    @Override
    public OrderDTO saveOrder(OrderDTO orderDto) {
        Order savedOrder = orderRepository.save(OrderDTOTransformer.ORDER_DTO_TRANSFORMER.orderDTOToOrder(orderDto));
        return OrderDTOTransformer.ORDER_DTO_TRANSFORMER.orderToOrderDTO(savedOrder);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
