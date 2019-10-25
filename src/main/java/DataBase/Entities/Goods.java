package DataBase.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "relationClass"})
public class Goods implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String name;
    private Double price;


    @OneToMany(mappedBy = "goods_id", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Order_line2> order_id = new ArrayList<Order_line2>();

    protected Goods()
    {

    }
    public Goods (Goods goods)
    {
        this.id = goods.getId();
        this.name = goods.getName();
        this.price = goods.getPrice();
    }

    public Goods(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Goods(String name, Double price) {
        id=0;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "Goods[id=%d, name='%s', price='%f']",
                id, name, price);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Order_line2> getOrder_id() {
        return order_id;
    }

    public void setOrder_id(List<Order_line2> order_id) {
        this.order_id = order_id;
    }
}
