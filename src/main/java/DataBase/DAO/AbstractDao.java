package DataBase.DAO;
import java.sql.Connection;
import java.util.List;

public abstract class AbstractDao <E, K>{
        public abstract List<E> getAll();
        public abstract E getEntityById(K id);
        public abstract E update(E entity);
        public abstract boolean delete(K id);
        public abstract boolean create(E entity);
}
