package modelo;

public class Ciudad {
	private Integer id_ciudad;
 	private Integer id_provincia;
	private String nombre_ciudad;
	private Boolean estado_ciudad;
	private Integer codigo_postal;
	public Ciudad(Integer id_ciudad, Integer id_provincia, String nombre_ciudad, Boolean estado_ciudad,
			Integer codigo_postal) {
		super();
		this.id_ciudad = id_ciudad;
		this.id_provincia = id_provincia;
		this.nombre_ciudad = nombre_ciudad;
		this.estado_ciudad = estado_ciudad;
		this.codigo_postal = codigo_postal;
	}
	public Integer getId_ciudad() {
		return id_ciudad;
	}
	public void setId_ciudad(Integer id_ciudad) {
		this.id_ciudad = id_ciudad;
	}
	public Integer getId_provincia() {
		return id_provincia;
	}
	public void setId_provincia(Integer id_provincia) {
		this.id_provincia = id_provincia;
	}
	public String getNombre_ciudad() {
		return nombre_ciudad;
	}
	public void setNombre_ciudad(String nombre_ciudad) {
		this.nombre_ciudad = nombre_ciudad;
	}
	public Boolean getEstado_ciudad() {
		return estado_ciudad;
	}
	public void setEstado_ciudad(Boolean estado_ciudad) {
		this.estado_ciudad = estado_ciudad;
	}
	public Integer getCodigo_postal() {
		return codigo_postal;
	}
	public void setCodigo_postal(Integer codigo_postal) {
		this.codigo_postal = codigo_postal;
	}
	@Override
	public String toString() {
		return  nombre_ciudad ;
	}
	

	
	
}
