package v002;

import javax.persistence.*;

/**
 * Created by yasha on 21.11.2016.
 */
@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String name;
   private String isdn;
   private int autor_id;

    public Book(){}

    public Book(String name, String isdn, int autor_id){
        this.name = name;
        this.isdn = isdn;
        this.autor_id = autor_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIsdn(String isdn) {
        this.isdn = isdn;
    }

    public void setAutor_id(int autor_id) {
        this.autor_id = autor_id;
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getIsdn() {
        return isdn;
    }

    public int getAutor_id() {
        return autor_id;
    }
}
