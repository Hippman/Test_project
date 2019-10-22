package DataBase.DAO;

import DataBase.Entities.Order_line;

import java.sql.Connection;
import java.util.List;

public class DaoOrder_line extends AbstractDao <Order_line,Integer>
{
    private Connection connection;
    @Override
    public List<Order_line> getAll() {
        return null;
    }

    @Override
    public Order_line getEntityById(Integer id) {
        return null;
    }

    @Override
    public Order_line update(Order_line entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Order_line entity) {
        return false;
    }
}
