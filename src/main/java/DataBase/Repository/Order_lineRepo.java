package DataBase.Repository;


import DataBase.Entities.Order_line;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface Order_lineRepo extends CrudRepository<Order_line, Long> {
    Order_line findById(int Id);
    @Transactional
    void deleteById(int Id);
}
