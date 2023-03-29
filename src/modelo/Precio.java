package modelo;

public class Precio {
	private int id_precio;
	private String tipo_medida;
	private Double precio;

	public Precio(int id_precios, String tipoMedidas, Double precio) {
		super();
		this.id_precio = id_precios;
		this.tipo_medida = tipoMedidas;
		this.precio = precio;
	}

	public int getId_precio() {
		return id_precio;
	}

	public void setId_precio(int id_precio) {
		this.id_precio = id_precio;
	}

	public String getTipo_medida() {
		return tipo_medida;
	}

	public void setTipo_medida(String tipo_medida) {
		this.tipo_medida = tipo_medida;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}


}
