package com.tiantian.api.order.orderEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.tiantian.enums.OrderStatusEnum;
import com.tiantian.enums.PayStatusEnum;
import com.tiantian.utils.EnumUtils;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;
@Data
public class OrderDTO {


    /** 订单id. */
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家id. */
    private String heroId;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    /** 创建时间. */

    private String createTime;

    /** 更新时间. */

    private String updateTime;
    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtils.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return EnumUtils.getByCode(payStatus, PayStatusEnum.class);
    }
}
