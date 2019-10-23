package DataBase.Repository;


import DataBase.Entities.Goods;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface GoodsRepo extends CrudRepository<Goods, Long> {
    Goods findById(int Id);
    @Transactional
    void deleteById(int Id);

    @Transactional
    @Modifying
    @Query(value="UPDATE Goods c SET c.Name = :Name, c.Price = :Price WHERE c.Id = :Id",nativeQuery = true)
    int updateById(@Param("Id") int Id,@Param("Name") String Name,@Param("Price") Double Price);
}
