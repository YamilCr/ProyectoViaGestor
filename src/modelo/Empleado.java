package modelo;


public class Empleado {
	
	private Integer id_empleado;
	private Integer nro_dni;
	private String nombre;
	private String apellido;
	private Integer telefono;
	private String email;
	private String contrasenia;
	private String tipo_usuario;
	private Boolean estado_cuenta;
	public Empleado(Integer id_empleado, Integer nro_dni, String nombre, String apellido, Integer telefono,
			String email, String contrasenia, String tipo_usuario, Boolean estado_cuenta) {
		super();
		this.id_empleado = id_empleado;
		this.nro_dni = nro_dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.contrasenia = contrasenia;
		this.tipo_usuario = tipo_usuario;
		this.estado_cuenta = estado_cuenta;
	}
	public Integer getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(Integer id_empleado) {
		this.id_empleado = id_empleado;
	}
	public Integer getNro_dni() {
		return nro_dni;
	}
	public void setNro_dni(Integer nro_dni) {
		this.nro_dni = nro_dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	public Boolean getEstado_cuenta() {
		return estado_cuenta;
	}
	public void setEstado_cuenta(Boolean estado_cuenta) {
		this.estado_cuenta = estado_cuenta;
	}
	
	
	
	
}
