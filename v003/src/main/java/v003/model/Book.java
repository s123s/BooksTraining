package v003.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer id;
	
	
	@Column(name = "name")
    public String name;
	
	@Column(name = "isdn")
	public String isdn;
	
	@Column(name = "autor_id")
    private Integer autorId;
	
	public Book() {
	};

	public Book(Integer id, String name, String isdn, Integer autor_id) {
		this.id = id;
		this.name = name;
		this.isdn = isdn;
		this.autorId = autor_id;
	}

	public String toString() {
		return "" + id + ", " + name + ", " + isdn + ", " + autorId;
	};
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsdn() {
		return isdn;
	}

	public void setIsdn(String isdn) {
		this.isdn = isdn;
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

}
