package DataBase.Entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmbaddableOrderLine implements Serializable {

    @Column(name = "ORDER_ID")
    private int order_id;
    @Column(name = "GOODS_ID")
    private int goods_id;


    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmbaddableOrderLine)) return false;
        EmbaddableOrderLine that = (EmbaddableOrderLine) o;
        return getOrder_id() == that.getOrder_id() &&
                getGoods_id() == that.getGoods_id();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrder_id(), getGoods_id());
    }
}
