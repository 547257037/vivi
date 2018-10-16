package com.tiantian.api.order.orderEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BuyerCart implements Serializable {
    //商品结果集
      private List<BuyerItem> items = new ArrayList<BuyerItem>();

    //添加购物项到购物车
     public void addItem(BuyerItem item){
                 //判断是否包含同款
                 if (items.contains(item)) {
                         //追加数量
                         for (BuyerItem buyerItem : items) {
                                 if (buyerItem.equals(item)) {
                                         buyerItem.setAmount(item.getAmount() + buyerItem.getAmount());
                                     }
                             }
                     }else {
                         items.add(item);
                     }

             }
    https://blog.csdn.net/qq_39827935/article/details/81386751
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

                     } else if (!sku.getId().equals(other.sku.getId()))
                         return false;
                 return true;
             }

}
