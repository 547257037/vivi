package com.tiantian.api.order.orderEntity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BuyerItem implements Serializable {
    //SKu对象
      private Sku sku;
    //是否有货
      private Boolean isHave = true;
             //购买的数量
    private Integer amount = 1;

}
