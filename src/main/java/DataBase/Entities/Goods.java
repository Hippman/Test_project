package DataBase.Entities;

public class Goods
{
    private Integer id;
    private String name;
    private Double price;

    public Goods()
    {
        id=0;
        name="";
        price=0.0;
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
