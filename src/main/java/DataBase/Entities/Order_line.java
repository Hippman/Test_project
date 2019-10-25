package DataBase.Entities;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "Order_line")
public class Order_line implements Serializable {
    @Column(name = "goodscount")
    private Integer count;

    @EmbeddedId
    EmbaddableOrderLine ID=new EmbaddableOrderLine();

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "id", updatable = false, insertable = false)
    private Order order_id;


    @ManyToOne
    @MapsId("goods_id")
    @JoinColumn(name = "GOODS_ID", referencedColumnName = "id", updatable = false, insertable = false)
    private Goods goods_id;

    protected Order_line(){}
    public Order_line(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }



    public Goods getGoods_id() {
        Goods tmpord=new Goods(goods_id);
        return tmpord;
    }

    public void setGoods_id(Goods goods_id) {
        this.ID.setGoods_id(goods_id.getId());
        this.goods_id = goods_id;
    }

    public Order_line(Integer count, Goods goods_id) {
        this.count = count;
        this.goods_id = goods_id;
    }



    public EmbaddableOrderLine getID() {
        return ID;
    }

    public void setID(EmbaddableOrderLine ID) {
        this.ID = ID;
    }
}
