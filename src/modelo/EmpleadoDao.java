package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDao implements Dao<Empleado> {
	
	
	public ArrayList<Empleado> getAll(){
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.empleado");
		try {
			while (rs.next()) {
				Integer id = rs.getInt("id_empleado");
				Integer nro_dni = rs.getInt("nro_dni");
				String nombre = rs.getString("nombre_empleado");
				String apellido = rs.getString("apellido_empleado");
				Integer telefono = rs.getInt("telefono");
				String email = rs.getString("email");
				String contrasenia = rs.getString("contrasenia");
				String tipo_usuario = rs.getString("tipo_usuario");
				Boolean estado_cuenta = rs.getBoolean("estado_cuenta");   
				
				empleados.add(new Empleado(id, nro_dni, nombre, apellido, telefono, email, contrasenia, tipo_usuario, estado_cuenta));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleados;
	}
	public Empleado get(Integer id) {
		Empleado empleado = null;
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.empleado where id_empleado="+ id);
		try {
			while (rs.next()) {
				Integer idrs = rs.getInt("id_empleado");
				Integer nro_dni = rs.getInt("nro_dni");
				String nombre = rs.getString("nombre_empleado");
				String apellido = rs.getString("apellido_empleado");
				Integer telefono = rs.getInt("telefono");
				String email = rs.getString("email");
				String contrasenia = rs.getString("contrasenia");
				String tipo_usuario = rs.getString("tipo_usuario");
				Boolean estado_cuenta = rs.getBoolean("estado_cuenta"); 
				empleado = new Empleado(idrs, nro_dni, nombre, apellido, telefono, email, contrasenia, tipo_usuario, estado_cuenta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empleado;
		
	}
	
	/*public Empleado actualizarUltimaFila() {
	
	}*/


	@Override
	public Integer insert(Empleado u) {
		return BasedeDatos.getInstance().add("empleado","nro_dni,nombre_empleado,apellido_empleado,telefono,email,contrasenia,tipo_usuario,estado_cuenta" ,
				"'"+ u.getNro_dni()+"','"+ u.getNombre()+ "','" + u.getApellido()+"','"+u.getTelefono()+"','"+u.getEmail()+
				"','"+u.getContrasenia()+"','"+u.getTipo_usuario()+"','"+u.getEstado_cuenta()+"'","id_empleado");		
	}

	@Override
	public Boolean update(Empleado u) {
		return BasedeDatos.getInstance().update("empleado", u.getId_empleado(),"nro_dni = '"+u.getNro_dni()+ "', nombre_empleado = '"+
	u.getNombre()+"', apellido_empleado = '"+u.getApellido()+"', telefono = '"+u.getTelefono()+"', email = '"+
				u.getEmail()+"', contrasenia = '"+u.getContrasenia()+"', tipo_usuario = '"+u.getTipo_usuario()+
				"', estado_cuenta = '"+u.getEstado_cuenta()+"'", "id_empleado");
	}

	@Override
	public Boolean remove(Empleado u) {
		return BasedeDatos.getInstance().remove("empleado",u.getId_empleado(),"id_empleado");
	}

}
