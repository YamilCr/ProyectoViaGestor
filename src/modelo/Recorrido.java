package modelo;


public class Recorrido {
	private Integer id_recorrido;
	private Integer id_asignacion;
	private String ciudad_destino;
	private String provincia_destino;
	private String ciudad_origen;
	private String provincia_origen;
	private Double precio_final;
	private Boolean estado_recorrido;
	private Double km;
	private Integer cant_pasajes_vendidos;
	
	
	
	
	public Recorrido(String ciudad_destino,  String ciudad_origen) {
		super();
		this.ciudad_destino = ciudad_destino;
		this.ciudad_origen = ciudad_origen;
	}
	
	
	public Recorrido(Integer id_recorrido, Integer id_asignacion, String ciudad_destino, String provincia_destino,
			String ciudad_origen, String provincia_origen, Double precio_final, Boolean estado_recorrido, Double km,
			Integer cant_pasajes_vendidos) {
		super();
		this.id_recorrido = id_recorrido;
		this.id_asignacion = id_asignacion;
		this.ciudad_destino = ciudad_destino;
		this.provincia_destino = provincia_destino;
		this.ciudad_origen = ciudad_origen;
		this.provincia_origen = provincia_origen;
		this.precio_final = precio_final;
		this.estado_recorrido = estado_recorrido;
		this.km = km;
		this.cant_pasajes_vendidos = cant_pasajes_vendidos;
	}
	public Integer getId_recorrido() {
		return id_recorrido;
	}
	public void setId_recorrido(Integer id_recorrido) {
		this.id_recorrido = id_recorrido;
	}
	public Integer getId_asignacion() {
		return id_asignacion;
	}
	public void setId_asignacion(Integer id_asignacion) {
		this.id_asignacion = id_asignacion;
	}
	public String getCiudad_destino() {
		return ciudad_destino;
	}
	public void setCiudad_destino(String ciudad_destino) {
		this.ciudad_destino = ciudad_destino;
	}
	public String getProvincia_destino() {
		return provincia_destino;
	}
	public void setProvincia_destino(String provincia_destino) {
		this.provincia_destino = provincia_destino;
	}
	public String getCiudad_origen() {
		return ciudad_origen;
	}
	public void setCiudad_origen(String ciudad_origen) {
		this.ciudad_origen = ciudad_origen;
	}
	public String getProvincia_origen() {
		return provincia_origen;
	}
	public void setProvincia_origen(String provincia_origen) {
		this.provincia_origen = provincia_origen;
	}
	public Double getPrecio_final() {
		return precio_final;
	}
	public void setPrecio_final(Double precio_final) {
		this.precio_final = precio_final;
	}
	public Boolean getEstado_recorrido() {
		return estado_recorrido;
	}
	public void setEstado_recorrido(Boolean estado_recorrido) {
		this.estado_recorrido = estado_recorrido;
	}
	public Double getKm() {
		return km;
	}
	public void setKm(Double km) {
		this.km = km;
	}
	public Integer getCant_pasajes_vendidos() {
		return cant_pasajes_vendidos;
	}
	public void setCant_pasajes_vendidos(Integer cant_pasajes_vendidos) {
		this.cant_pasajes_vendidos = cant_pasajes_vendidos;
	}
	
	
	
}
