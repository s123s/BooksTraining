package v002.DAO;

import java.util.List;

public interface DaoDefault<T> {

	default int create(T o) {
		throw new RuntimeException("NO "+ this.getClass().getName() +" create() realization");
	}

	/** Read by o.<id> */
	default T read(T o){
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
