package DataBase.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Goods
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String name;
    private Double price;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
    private Set<Order_line> lines;

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

    public Set<Order_line> getLines() {
        return lines;
    }

    public void setLines(Set<Order_line> lines) {
        this.lines = lines;
    }
}
