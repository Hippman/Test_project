package DataBase.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;

@Entity
public class Order
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String client;
    private Calendar dat;
    private String address;

    protected Order()
    {

    }
    public Order(Integer id, String client, Calendar dat, String address) {
        this.id = id;
        this.client = client;
        this.dat = dat;
        this.address = address;
    }

    public Order(String client, Calendar dat, String address) {
        id=0;
        this.client = client;
        this.dat = dat;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format(
                "Goods[id=%d, client='%s', date='%s', address='%s']",
                id, client, dat,address);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setDate(Calendar dat) {
        this.dat = dat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}