package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PasajeDao implements Dao<Pasaje> {
//id_pasaje, nro_documento, tipo_documento, nombre_pasajero, apellido_pasajero, 
	//telefono, nro_butaca, descuento, precio_final, estado_pasaje
	public ArrayList<Pasaje> getAll(){
		ArrayList<Pasaje> pasajes = new ArrayList<Pasaje>();
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.pasaje");
		try {
			while (rs.next()) {
				Integer id = rs.getInt("id_pasaje");
				Integer dni = rs.getInt("nro_documento");
				String tipoDocumento = rs.getString("tipo_documento");
				String nombre = rs.getString("nombre_pasajero");
				String apellido = rs.getString("apellido_pasajero");
				Integer telefono = rs.getInt("telefono");
				Integer asiento = rs.getInt("nro_butaca");
				Double descuento= rs.getDouble("descuento");
				Double precio= rs.getDouble("precio_final");
				Boolean estado= rs.getBoolean("estado_pasaje");
				Integer idRecorrido = rs.getInt("id_recorrido");
				pasajes.add(new Pasaje(id, new Cliente(dni, tipoDocumento, nombre, apellido, telefono), asiento, descuento, precio, estado, idRecorrido));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pasajes;
	}
	public Pasaje get(Integer id) {
		Pasaje pasaje = null;
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.pasaje where id_pasaje = "+ id);
		try {
			while (rs.next()) {
				Integer ids = rs.getInt("id_pasaje");
				Integer dni = rs.getInt("nro_documento");
				String tipoDocumento = rs.getString("tipo_documento");
				String nombre = rs.getString("nombre_pasajero");
				String apellido = rs.getString("apellido_pasajero");
				Integer telefono = rs.getInt("telefono");
				Integer asiento = rs.getInt("nro_butaca");
				Double descuento= rs.getDouble("descuento");
				Double precio= rs.getDouble("precio_final");
				Boolean estado= rs.getBoolean("estado_pasaje");
				Integer idRecorrido = rs.getInt("id_recorrido");
				pasaje = new Pasaje(ids, new Cliente(dni, tipoDocumento, nombre, apellido, telefono), asiento, descuento, precio, estado, idRecorrido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pasaje;	
	}
	
	
	
	public ArrayList<Pasaje> asientosOcupados(Integer id_recorrido){
		ArrayList<Pasaje> pasajes = new ArrayList<Pasaje>();
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM pasaje where id_recorrido ="+ id_recorrido+ " and pasaje.estado_pasaje ='true' ");
		try {	
			while (rs.next()) {
				Integer id = rs.getInt("id_pasaje");
				Integer dni = rs.getInt("nro_documento");
				String tipoDocumento = rs.getString("tipo_documento");
				String nombre = rs.getString("nombre_pasajero");
				String apellido = rs.getString("apellido_pasajero");
				Integer telefono = rs.getInt("telefono");
				Integer asiento = rs.getInt("nro_butaca");
				Double descuento= rs.getDouble("descuento");
				Double precio= rs.getDouble("precio_final");
				Boolean estado= rs.getBoolean("estado_pasaje");
				Integer idRecorrido = rs.getInt("id_recorrido");
				pasajes.add(new Pasaje(id, new Cliente(dni, tipoDocumento, nombre, apellido, telefono), asiento, descuento, precio, estado, idRecorrido));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pasajes;
	}
	
	
 
	public ArrayList<Pasaje> cancelaPasaje(Integer id_recorrido) {
		ArrayList<Pasaje> pasajes = new ArrayList<Pasaje>();
		ResultSet rs = BasedeDatos.getInstance().getAll("select * from pasaje where id_recorrido =" + id_recorrido);
		try {
			while (rs.next()) {
				Integer id = rs.getInt("id_pasaje");
				Integer dni = rs.getInt("nro_documento");
				String tipoDocumento = rs.getString("tipo_documento");
				String nombre = rs.getString("nombre_pasajero");
				String apellido = rs.getString("apellido_pasajero");
				Integer telefono = rs.getInt("telefono");
				Integer asiento = rs.getInt("nro_butaca");
				Double descuento= rs.getDouble("descuento");
				Double precio= rs.getDouble("precio_final");
				Boolean estado= rs.getBoolean("estado_pasaje");
				Integer idRecorrido = rs.getInt("id_recorrido");
				pasajes.add(new Pasaje(id, new Cliente(dni, tipoDocumento, nombre, apellido, telefono), asiento, descuento, precio, estado, idRecorrido));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pasajes;
	}
	
	@Override
	public Integer insert(Pasaje u) {
		// TODO Auto-generated method stub
		return BasedeDatos.getInstance().add("pasaje", " nro_documento, tipo_documento, nombre_pasajero, apellido_pasajero, telefono, "
				+ "nro_butaca, descuento, precio_final, estado_pasaje, id_recorrido", u.getPasajero().getDni() + ", '"+ u.getPasajero().getTipoDocumento()+ "', '"
				+ u.getPasajero().getNombre() + "', '"+ u.getPasajero().getApellido()+ "', "+ u.getPasajero().getTelefono()+ ", " + u.getNroButaca()+ ", '"+ u.getDescuento() 
				+ "', "+ u.getPrecioFinal() + ", " + u.getEstadoPasaje()+", " + u.getIdRecorrido(),"id_pasaje");
	}

	@Override
	public Boolean update(Pasaje u) {
		// TODO Auto-generated method stub
		return BasedeDatos.getInstance().update("pasaje", u.getIdPasaje(), " nro_documento= '"+ u.getPasajero().getDni() 
				+"', tipo_documento= '"+ u.getPasajero()+"', nombre_pasajero= '"+ u.getPasajero().getNombre()
				+"', apellido_pasajero= '"+ u.getPasajero().getApellido()+"', telefono= '" +u.getPasajero().getTelefono()
				+"', nro_butaca= '"+ u.getNroButaca()+"', descuento= '"+ u.getDescuento() +"', precio_final= '"+ u.getPrecioFinal()
				+"', estado_pasaje= '"+ u.getEstadoPasaje()+"'"+", id_recorrido= '"+ u.getIdRecorrido()+"'", "id_pasaje");
	}

	@Override
	public Boolean remove(Pasaje u) {
		return BasedeDatos.getInstance().remove("pasaje",u.getIdPasaje(),"id_pasaje");
	}

}
