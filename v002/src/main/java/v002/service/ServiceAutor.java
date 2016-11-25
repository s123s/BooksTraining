package v002.service;

import v002.domain.Autor;

import java.util.List;

/**
 * Created by yasha on 23.11.2016.
 */
public interface ServiceAutor {
    public void addAutor(Autor autor);
    public void updateAutor(Autor autor);
    public void removeAutor(Long id);
    public Autor getAutorById(Long id);
    public List<Autor> listAutors();
}

