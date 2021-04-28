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

    public OrderServiceImpl(OrderRepository orderRepository) { this.orderRepository = orderRepository;
    }



    @Override
    public OrderDTO getOrderById(long id) {
        Optional<Order> order = Optional.ofNullable(orderRepository.findByOrderId(id));
        if (!order.isPresent()) {
            throw new ThereIsNoSuchException("customer");
        }

        OrderDTO orderDTO = OrderDTOTransformer.ORDER_DTO_TRANSFORMER.orderToOrderDTO(order.get());
        return orderDTO;
    }

    @Override
    public OrderDTO saveOrder(OrderDTO orderDto) {
        Order savedOrder = orderRepository.save(OrderDTOTransformer.ORDER_DTO_TRANSFORMER.orderDTOToOrder(orderDto));
        return OrderDTOTransformer.ORDER_DTO_TRANSFORMER.orderToOrderDTO(savedOrder);
    }

    @Override
    public void deleteOrder(long orderId) {
        orderRepository.deleteById(String.valueOf(orderId));
    }
}
