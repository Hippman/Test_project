package DataBase.Entities;

import javax.persistence.*;

@Entity
public class Order_line
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer goods_id;
    @Column(name = "goodscount")
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
    private Order order;

    protected Order_line() {

    }

    public Order_line(Integer goods_id, Integer count) {

        this.goods_id = goods_id;
        this.count = count;

    }

    @Override
    public String toString() {
        return String.format(
                "Goods[id=%d,order_id='%d', goods_id='%d', count='%d']",
                id,getOrder_id(),  goods_id,count);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*public Order getOrder() {
        return order;
    }*/

    public void setOrder(Order order) {
        this.order = order;
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

    public Integer getOrder_id() {
        return order.getId();
    }

}
