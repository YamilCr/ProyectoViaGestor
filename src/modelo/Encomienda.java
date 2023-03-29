package modelo;

public class Encomienda {
	private Integer idEncomienda;
	private Double peso;
	private Cliente destinatario;
	private Cliente remitente;
	private String ciudadOrigen, ciudadDestino,nombreCalle,depto;
	private Integer nroCalle, piso;
	private String tipoServicio;
    private Double descuento, precioFinal;
    public Encomienda() {
		super();
	}
	private Boolean estado_encomienda;
    
    
	public Encomienda(Integer idEncomienda, Double peso, Cliente destinatario, Cliente remitente, String ciudadOrigen,
			String ciudadDestino, String nombreCalle, String depto, Integer nroCalle, Integer piso, String tipoServicio,
			Double descuento, Double precioFinal, Boolean estado_encomienda) {
		super();
		this.idEncomienda = idEncomienda;
		this.peso = peso;
		this.destinatario = destinatario;
		this.remitente = remitente;
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.nombreCalle = nombreCalle;
		this.depto = depto;
		this.nroCalle = nroCalle;
		this.piso = piso;
		this.tipoServicio = tipoServicio;
		this.descuento = descuento;
		this.precioFinal = precioFinal;
		this.estado_encomienda = estado_encomienda;
	}
	public Integer getIdEncomienda() {
		return idEncomienda;
	}
	public void setIdEncomienda(Integer idEncomienda) {
		this.idEncomienda = idEncomienda;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Cliente getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Cliente destinatario) {
		this.destinatario = destinatario;
	}
	public Cliente getRemitente() {
		return remitente;
	}
	public void setRemitente(Cliente remitente) {
		this.remitente = remitente;
	}
	public String getCiudadOrigen() {
		return ciudadOrigen;
	}
	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}
	public String getCiudadDestino() {
		return ciudadDestino;
	}
	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}
	public String getNombreCalle() {
		return nombreCalle;
	}
	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}
	public String getDepto() {
		return depto;
	}
	public void setDepto(String depto) {
		this.depto = depto;
	}
	public Integer getNroCalle() {
		return nroCalle;
	}
	public void setNroCalle(Integer nroCalle) {
		this.nroCalle = nroCalle;
	}
	public Integer getPiso() {
		return piso;
	}
	public void setPiso(Integer piso) {
		this.piso = piso;
	}
	public String getTipoServicio() {
		return tipoServicio;
	}
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
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
	public Boolean getEstado_encomienda() {
		return estado_encomienda;
	}
	public void setEstado_encomienda(Boolean estado_encomienda) {
		this.estado_encomienda = estado_encomienda;
	}
	@Override
	public String toString() {
		return "DETALLES ENCOMIENDA" + "\nPeso: " + peso 
				+ "\nDESTINATARIO " 
				+ "\nNombre y apellido: "+ destinatario.getNombre() + " " + destinatario.getApellido()
				+"\nNro documento: " + destinatario.getDni() 
				+"\nTelefono: " + destinatario.getTelefono()
				+"\nREMITENTE " 
				+ "\nNombre y apellido: "+ remitente.getNombre() + " " + destinatario.getApellido()
				+"\nNro documento: " + remitente.getDni() 
				+"\nTelefono: " + remitente.getTelefono()
				+ "\nCiudad origen:" + ciudadOrigen + "\nCiudad destino: " + ciudadDestino
				+ "\nDescuento: " + descuento + "\nPrecio final: " + precioFinal;
	}
    
}
