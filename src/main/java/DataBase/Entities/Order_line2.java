package DataBase.Entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Order_line2")
public class Order_line2 implements Serializable {
    @Column(name = "goodscount")
    private Integer count;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn
    private Order order_id;

    @ManyToOne
    @JoinColumn
    private Goods goods_id;

    public Order_line2() {
    }

    public Order_line2(Integer count, Order order_id) {
        this.count = count;
        this.order_id = order_id;
    }
    public Order_line2(Integer count, Order order_id, Goods goods_id) {
        this.count = count;
        this.order_id = order_id;
        this.goods_id=goods_id;
    }
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Order getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Order order_id) {
        this.order_id = order_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Goods getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Goods goods_id) {
        this.goods_id = goods_id;
    }
}
