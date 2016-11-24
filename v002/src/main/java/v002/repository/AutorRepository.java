package v002.repository;

import org.springframework.stereotype.Repository;
import v002.domain.Autor;

import java.util.List;

/**
 * Created by yasha on 23.11.2016.
 */
@Repository
public interface AutorRepository {

    public void addAutor(Autor autor);
    public void updateAutor(Autor autor);
    public void removeAutor(Long id);
    public Autor getAutorById(Long id);
    public List<Autor> listAutor();
}
