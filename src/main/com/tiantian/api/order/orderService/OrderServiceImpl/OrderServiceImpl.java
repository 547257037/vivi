package com.tiantian.api.order.orderService.OrderServiceImpl;

import com.tiantian.api.order.orderEntity.OrderDTO;
import com.tiantian.api.order.orderService.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {
    @Override
    public String create(OrderDTO orderDTO) {
        //生产订单ID
        //补全信息合并购物车
        //订单详情redis
        //入库
        //返回订单id
        return null;
    }
}
