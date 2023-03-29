package modelo;

public class Provincia {
	private Integer id_provincia;
	private String nombre_provincia;
	
	
	public Provincia(Integer id_provincia, String nombre_provincia) {
		super();
		this.id_provincia = id_provincia;
		this.nombre_provincia = nombre_provincia;
	}
	public Integer getId_provincia() {
		return id_provincia;
	}
	public void setId_provincia(Integer id_provincia) {
		this.id_provincia = id_provincia;
	}
	public String getNombre_provincia() {
		return nombre_provincia;
	}
	public void setNombre_provincia(String nombre_provincia) {
		this.nombre_provincia = nombre_provincia;
	}
	
	
	
}
