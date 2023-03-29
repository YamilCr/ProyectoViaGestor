package modelo;

public class Pasaje {
	private Integer idPasaje;
	private Cliente pasajero;
	private Integer nroButaca;
	private Double descuento, precioFinal;
	private Boolean estadoPasaje;
	private Integer idRecorrido;
	
	
	public Pasaje(Integer idPasaje, Cliente pasajero, Integer nroButaca, Double descuento, Double precioFinal,
			Boolean estadoPasaje, Integer idRecorrido) {
		super();
		this.idPasaje = idPasaje;
		this.pasajero = pasajero;
		this.nroButaca = nroButaca;
		this.descuento = descuento;
		this.precioFinal = precioFinal;
		this.estadoPasaje = estadoPasaje;
		this.idRecorrido = idRecorrido;
	}
	
	@Override
	public String toString() {
		return " DETALLES DEL PASAJE"+"\nNombre y Apellido: " + pasajero.getNombre()+" "+pasajero.getApellido() 
				+"\nNro de documento: "+": "+ pasajero.getDni() 
				+"\nTelefono: "+pasajero.getTelefono()+ "\nNº Butaca: " + nroButaca 
				+ "\nDescuento: " + descuento + 
				"\nPrecio Final: " + precioFinal;
	}

	public Integer getIdPasaje() {
		return idPasaje;
	}
	public void setIdPasaje(Integer idPasaje) {
		this.idPasaje = idPasaje;
	}
	public Cliente getPasajero() {
		return pasajero;
	}
	public void setPasajero(Cliente pasajero) {
		this.pasajero = pasajero;
	}
	public Integer getNroButaca() {
		return nroButaca;
	}
	public void setNroButaca(Integer nroButaca) {
		this.nroButaca = nroButaca;
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	public Double getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}
	public Boolean getEstadoPasaje() {
		return estadoPasaje;
	}
	public void setEstadoPasaje(Boolean estadoPasaje) {
		this.estadoPasaje = estadoPasaje;
	}
	public Integer getIdRecorrido() {
		return idRecorrido;
	}
	public void setIdRecorrido(Integer idRecorrido) {
		this.idRecorrido = idRecorrido;
	}
	

	
}
