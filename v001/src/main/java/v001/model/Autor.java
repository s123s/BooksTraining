package v001.model;

public class Autor {
	public Autor(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String toString() {return ""+id+", "+ name;};

	public Integer id;
	public String name;

}
