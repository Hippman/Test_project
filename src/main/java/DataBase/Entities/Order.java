package DataBase.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name="Orders")
public class Order implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    private String client;
    @Temporal(TemporalType.DATE)
    private Calendar dat;
    private String address;


    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Order_line2> goods_id = new ArrayList<Order_line2>();

    public Order()
    {

    }

    public Order(String client, Calendar dat, String address) {

        this.client = client;
        this.dat = dat;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Calendar getDat() {
        return dat;
    }

    public void setDat(Calendar dat) {
        this.dat = dat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order_line2> getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(List<Order_line2> goods_id) {
        this.goods_id = goods_id;
    }
}