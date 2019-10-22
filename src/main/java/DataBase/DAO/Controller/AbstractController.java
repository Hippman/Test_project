package DataBase.DAO.Controller;

import DataBase.DAO.*;
import java.sql.Connection;

public abstract class AbstractController
{

    public abstract void initDB();
    public abstract DaoGoods getDaoGoods();
    public abstract DaoOrder getDaoOrder();
    public abstract DaoOrder_line getDaoOrder_line();

    }