package v001.model;

public class Book {
	public Book(Integer id, String name, String isdn, Integer autor_id) {
		this.id = id;
		this.name = name;
		this.isdn = isdn;
		this.autor_id = autor_id;
	}
	
	public String toString() {return ""+id+", "+ name +", " +isdn +", " + autor_id;};

	public Integer id;
	public String name;
	public String isdn;
	public Integer autor_id;

}
