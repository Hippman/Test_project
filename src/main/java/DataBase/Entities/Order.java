package DataBase.Entities;

import java.util.Calendar;

public class Order
{
    private Integer id;
    private String client;
    private Calendar date;
    private String address;

    public Order() {
        id=0;
        client="";
        date=Calendar.getInstance();
        address="";
    }

    public Order(Integer id, String client, Calendar date, String address) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.address = address;
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

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}