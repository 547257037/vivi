package com.tiantian.api.order.orderController;



import com.tiantian.api.order.orderEntity.OrderDTO;

import com.tiantian.api.order.orderService.IOrderService;
import com.tiantian.common.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Scope(value = "prototype")
@RequestMapping("BuyerOrderController")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private IOrderService orderService;

    //创建订单
    @PostMapping("/create")
    public ResponseResult create(@Valid OrderDTO orderDTO,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
         return  ResponseResult.putError( bindingResult.getFieldError().getDefaultMessage());
        }
        return ResponseResult.putSuccessData( orderService.create(orderDTO));
    }
}
