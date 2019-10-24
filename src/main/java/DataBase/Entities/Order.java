package DataBase.Entities;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
@Table(name="Orders")
public class Order
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    private String client;
    @Temporal(TemporalType.DATE)
    private Calendar dat;
    private String address;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id", cascade = CascadeType.ALL)
    private Set<Order_line> lines;


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
                id, client, dat.toString(),address);
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

    public Set<Order_line> getLines() {
        return lines;
    }

    public void setLines(Set<Order_line> lines) {
        this.lines = lines;
    }

    public void setDat(Calendar dat) {
        this.dat = dat;
    }
}