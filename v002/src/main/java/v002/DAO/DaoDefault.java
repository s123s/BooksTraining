package v002.DAO;

import java.util.List;


/**<T> - POJO object
 * <K> - key*/
public interface DaoDefault<T, K> {

	default int create(T o) {
		throw new RuntimeException("NO "+ this.getClass().getName() +" create() realization");
	}

	/** Read by K */
	default T read(K o){
		throw new RuntimeException("NO "+ this.getClass().getName() +" read() realization");
	}

	default void update(T o){
		throw new RuntimeException("NO "+ this.getClass().getName() +" update() realization");
	}

	default void delete(T o){
		throw new RuntimeException("NO "+ this.getClass().getName() +" delete() realization");
	}
	
	default List<T> readAll () {
		throw new RuntimeException("NO "+ this.getClass().getName() +" readAll() realization");
	}
}