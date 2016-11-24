package v002.domain;

import javax.persistence.*;

/**
 * Created by yasha on 23.11.2016.
 */
@Entity
@Table
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Autor(){}

    public Autor(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
