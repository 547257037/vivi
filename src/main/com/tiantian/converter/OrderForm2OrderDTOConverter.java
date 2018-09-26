package com.tiantian.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tiantian.api.order.orderEntity.OrderDTO;
import com.tiantian.api.order.orderEntity.OrderDetail;
import com.tiantian.api.order.orderEntity.OrderEntity;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderEntity.OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setHeroId(orderForm.getHeroId());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}", orderForm.getItems());
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
