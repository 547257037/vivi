package com.tiantian.api.order.orderEntity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Sku {
//    skuId（sku ID）、goodId（商品ID）、price（价格）、quantity（库存）
          private Long skuId;
           private Integer price;
}
