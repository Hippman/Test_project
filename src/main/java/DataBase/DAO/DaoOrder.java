package DataBase.DAO;

import DataBase.Entities.Order;

import java.sql.Connection;
import java.util.List;

public class DaoOrder extends AbstractDao <Order,Integer>
{
    private Connection connection;
    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public Order getEntityById(Integer id) {
        return null;
    }

    @Override
    public Order update(Order entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Order entity) {
        return false;
    }
}
