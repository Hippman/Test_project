package DataBase.DAO.Controller;

import DataBase.DAO.AbstractDao;
import DataBase.DAO.DaoGoods;
import DataBase.DAO.DaoOrder;
import DataBase.DAO.DaoOrder_line;

import java.sql.*;

public class H2Controller extends AbstractController
{
    private Connection connection;

    public H2Controller() {
        connection=null;
    }

    @Override
    public DaoGoods getDaoGoods() {
        return new DaoGoods(connection);
    }

    @Override
    public DaoOrder getDaoOrder() {
        return null;
    }

    @Override
    public DaoOrder_line getDaoOrder_line() {
        return null;
    }

    /**
     * Этотметод создает подключение
     */
    public void initDB()
    {
        try {

            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:h2:" + System.getProperty("user.dir") + "\\orders");

                check_tables();
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getLocalizedMessage());
        }

    }

    /**
     * Этот метод проверяет есть ли нужные таблицы в бд и создает их при необходимости.
     */
    private void check_tables()
    {
        String sql,str;
        int cntr=0;
        try {
            DatabaseMetaData data=connection.getMetaData();
            ResultSet res=data.getTables(null,null,null,null);
            while(res.next()) cntr++;

            if(cntr==33)//в пустой базе 33 стандартные таблицы
            {
                //создадим внутренние таблицы
                Statement stat=connection.createStatement();
                sql="create table orders (id int auto_increment primary key, client varchar(100) not null, dat DATE not null, address varchar(256));";
                stat.execute(sql);
                sql="create table goods (id int auto_increment primary key, name varchar(100) not null, price float not null);";
                stat.execute(sql);
                sql="create table order_id (id int auto_increment primary key, order_id int not null, goods_id int not null, count int not null);";
                stat.execute(sql);
            }
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getLocalizedMessage());
        }
    }
}
