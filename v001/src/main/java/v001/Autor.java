package v001;

/**
 * Created by yasha on 18.11.2016.
 */
public class Autor {
    private int idAutor;
    private String autor;

    public Autor(int idAutor, String autor){
        this.idAutor = idAutor;
        this.autor = autor;
    }
    public Autor(){}

    public int getIdAutor(){
        return this.idAutor;
    }
    public String getAutor(){
        return this.autor;
    }
}
