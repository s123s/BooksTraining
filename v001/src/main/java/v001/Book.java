package v001;

/**
 * Created by yasha on 18.11.2016.
 */
public class Book  {
    private int idBook;
    private String bookName;
    private String isdn;
    private int idAutor;
    public Book(int idBook, String bookName,String isdn, int idAutor){
        this.idBook = idBook;
        this.bookName = bookName;
        this.isdn = isdn;
        this.idAutor = idAutor;

    }
    public Book(){}

    public int getIdBook(){
        return this.idBook;
    }
    public String getBookName(){
        return this.bookName;
    }
    public String getIsdn(){
        return this.isdn;
    }
    public int getIdAutor(){
        return this.idAutor;
    }
}
