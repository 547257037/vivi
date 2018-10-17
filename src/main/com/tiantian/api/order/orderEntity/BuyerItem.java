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
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sku == null) ? 0 : sku.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) //比较地址
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BuyerItem other = (BuyerItem) obj;
        if (sku == null) {

        } else if (!sku.getSkuId().equals(other.sku.getSkuId()))
            return false;
        return true;
    }

}
