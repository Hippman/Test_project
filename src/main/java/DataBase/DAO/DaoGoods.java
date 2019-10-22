package DataBase.DAO;

import DataBase.Entities.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoGoods extends AbstractDao <Goods,Integer>
{
    private Connection connection;

    public DaoGoods(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Goods> getAll() {
        ResultSet res;

        List<Goods> goods=new ArrayList<Goods>();
        try(Statement stat=connection.createStatement())
        {

            res=stat.executeQuery("select * from goods;");
            while (res.next())
            {
                goods.add(new Goods(res.getInt("id"),res.getString("name"),res.getDouble("price")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goods;
    }

    @Override
    public Goods getEntityById(Integer id) {
        return null;
    }

    @Override
    public Goods update(Goods entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Goods entity) {
        //create table goods (id int auto_increment primary key, name varchar(100) not null, price float not null)
        String sql;
        if(entity.getId().equals(0)) sql="insert into goods (name,price) values (?,?)";
        else sql="insert into goods (id,name,price) values (?,?,?)";
        try (PreparedStatement stm = connection.prepareStatement(sql))
        {
            if(entity.getId().equals(0)) {
                stm.setString(1, entity.getName());
                stm.setDouble(2, entity.getPrice());
            }else{
                stm.setInt(1, entity.getId());
                stm.setString(2, entity.getName());
                stm.setDouble(3, entity.getPrice());
            }
            stm.execute();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {

        }
        return false;
    }
}
