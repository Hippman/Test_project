package DataBase.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order_line
{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer order_id;
    private Integer goods_id;
    private Integer count;

    public Order_line() {
        id=order_id=goods_id=count=0;
    }

    public Order_line(Integer id, Integer order_id, Integer goods_id, Integer count) {
        this.id = id;
        this.order_id = order_id;
        this.goods_id = goods_id;
        this.count = count;
    }
    @Override
    public String toString() {
        return String.format(
                "Goods[id=%d, order_id='%d', goods_id='%d', count='%d']",
                id, order_id, goods_id,count);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
