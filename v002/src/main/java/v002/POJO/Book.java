package v002.POJO;

public class Book {
	public Book() {
	};

	public Book(Integer id, String name, String isdn, Integer autor_id) {
		this.id = id;
		this.name = name;
		this.isdn = isdn;
		this.autor_id = autor_id;
	}

	public String toString() {
		return "" + id + ", " + name + ", " + isdn + ", " + autor_id;
	};

	public Integer id;
	public String name;
	public String isdn;

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

	public Integer getAutor_id() {
		return autor_id;
	}

	public void setAutor_id(Integer autor_id) {
		this.autor_id = autor_id;
	}

	public Integer autor_id;

}
