package Main;
import DataBase.DAO.Controller.H2Controller;
import DataBase.DAO.DaoGoods;
import DataBase.Entities.Goods;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String [] args)
    {

        System.out.println("hello2");
        H2Controller controller=new H2Controller();
        controller.initDB();
        Goods goods=new Goods("cucumber",3.1);
        DaoGoods dg=controller.getDaoGoods();
        dg.create(goods);
        List<Goods> allgoods=dg.getAll();
        int a=1;
        //controller.InsertObject(new DaoGoods(),goods);


    }
}
