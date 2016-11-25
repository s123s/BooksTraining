package v002.service;

import v002.domain.Autor;
import v002.repository.AutorReposImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yasha on 23.11.2016.
 */
@Service
public class ServiceAutorImpl implements ServiceAutor {
    private AutorReposImpl autorReposImpl;

    public void setAutorReposImpl(AutorReposImpl autorReposImpl){
        this.autorReposImpl = autorReposImpl;
    }

    @Override
    @Transactional
    public void addAutor(Autor autor){
        this.autorReposImpl.addAutor(autor);
    }

    @Override
    @Transactional
    public void updateAutor(Autor autor){
        this.autorReposImpl.updateAutor(autor);
    }

    @Override
    @Transactional
    public void removeAutor(Long id){
        this.autorReposImpl.removeAutor(id);
    }

    @Override
    @Transactional
    public Autor getAutorById(Long id){
        return this.autorReposImpl.getAutorById(id);
    }

    @Override
    @Transactional
    public List<Autor> listAutors(){
        return this.autorReposImpl.listAutor();
    }

}
