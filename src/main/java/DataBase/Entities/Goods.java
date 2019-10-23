package DataBase.Entities;

import javax.persistence.*;

@Entity
public class Goods
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double price;

    protected Goods()
    {

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
}
