package com.tiantian.api.order.orderController;



import com.tiantian.api.order.orderEntity.OrderDTO;
import com.tiantian.api.order.orderEntity.OrderEntity;
import com.tiantian.common.ResponseResult;
import com.tiantian.enums.ResultEnum;
import org.springframework.context.annotation.Scope;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@Scope(value = "prototype")
@RequestMapping("BuyerOrderController")
public class BuyerOrderController {
    //创建订单
    @PostMapping("/create")
    public ResponseResult create(@Valid OrderEntity.OrderForm orderForm,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
         return  ResponseResult.putError( bindingResult.getFieldError().getDefaultMessage());
        }
        //购物车
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }
}
