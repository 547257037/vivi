package com.tiantian.api.order.orderService;

import com.tiantian.api.order.orderEntity.OrderDTO;

public interface IOrderService {
    String create(OrderDTO orderDTO);
}
