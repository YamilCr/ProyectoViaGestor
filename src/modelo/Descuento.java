package modelo;

public class Descuento {
	private Integer id_descuento;
	private String nombre_descuento;
	private Double porcentaje_descuento;
	
	public Descuento(Integer id_descuento, String nombre_descuento, Double porcentaje_descuento) {
		super();
		this.id_descuento = id_descuento;
		this.nombre_descuento = nombre_descuento;
		this.porcentaje_descuento = porcentaje_descuento;
	}
	
	

	public Descuento(String nombre_descuento, Double porcentaje_descuento) {
		super();
		this.nombre_descuento = nombre_descuento;
		this.porcentaje_descuento = porcentaje_descuento;
	}



	public Integer getId_descuento() {
		return id_descuento;
	}

	public void setId_descuento(Integer id_descuento) {
		this.id_descuento = id_descuento;
	}

	public String getNombre_descuento() {
		return nombre_descuento;
	}

	public void setNombre_descuento(String nombre_descuento) {
		this.nombre_descuento = nombre_descuento;
	}

	public Double getPorcentaje_descuento() {
		return porcentaje_descuento;
	}

	public void setPorcentaje_descuento(Double porcentaje_descuento) {
		this.porcentaje_descuento = porcentaje_descuento;
	}
	
	

}
