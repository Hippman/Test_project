package DataBase.Repository;


import DataBase.Entities.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Calendar;

@Repository
public interface OrderRepo extends CrudRepository<Order, Long> {
    Order findById(int Id);
    @Transactional
    void deleteById(int Id);

    @Transactional
    @Modifying
    //Integer id, String client, Calendar date, String address
    @Query(value="UPDATE Order c SET c.Client = :Client, c.Dat = :date, c.Address = :address WHERE c.Id = :Id",nativeQuery = true)
    int updateById(@Param("Id") int Id, @Param("Client") String Name, @Param("date") Calendar date,
                   @Param("address") String Address);
}