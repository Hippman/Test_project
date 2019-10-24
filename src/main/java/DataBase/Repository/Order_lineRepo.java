package DataBase.Repository;


import DataBase.Entities.Order_line;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface Order_lineRepo extends CrudRepository<Order_line, Long> {
    Order_line findById(int Id);
    @Transactional
    void deleteById(int Id);

    //private Integer id;    private Integer order_id;    private Integer goods_id;    private Integer count;
    @Transactional
    @Modifying
    @Query(value="UPDATE Order_line c SET c.goods_id = :goods_id, c.count = :count WHERE c.Id = :Id",nativeQuery = true)
    int updateById(@Param("Id") int Id, @Param("goods_id") int goods_id,
                   @Param("count") int count);
}
