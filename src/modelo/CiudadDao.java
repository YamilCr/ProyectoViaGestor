package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CiudadDao implements Dao<Ciudad>{

	public ArrayList<Ciudad> getAll(){
		ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.ciudad");
		try {
			while (rs.next()) {
				Integer id = rs.getInt("id_ciudad");
				Integer id_provincia = rs.getInt("id_provincia");
				String nombre_ciudad = rs.getString("nombre_ciudad");
				Boolean estado_ciudad = rs.getBoolean("estado_ciudad");
				Integer codigo_postal = rs.getInt("codigo_postal");
				ciudades.add(new Ciudad(id, id_provincia, nombre_ciudad, estado_ciudad, codigo_postal));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ciudades;
	}
	public Ciudad get(Integer id) {
		Ciudad ciudad = null;
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.ciudad where id_ciudad="+ id);
		try {
			while (rs.next()) {
				Integer id2 = rs.getInt("id_ciudad");
				Integer id_provincia = rs.getInt("id_provincia");
				String nombre_ciudad = rs.getString("nombre_ciudad");
				Boolean estado_ciudad = rs.getBoolean("estado_ciudad");
				Integer codigo_postal = rs.getInt("codigo_postal");
				
				ciudad= new Ciudad(id2, id_provincia, nombre_ciudad, estado_ciudad, codigo_postal);
							}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ciudad;	
	}
	
	public Boolean ciudadNueva(String nombre_ciudad) {
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.ciudad where nombre_ciudad = '"+nombre_ciudad +"'");
		try {
			while (rs.next()) {		
				return false;
							}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;	
	}
	
	public Integer obtenerIdCiudad(String nombre_ciudad) {
		Integer id_ciudad=null;
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.ciudad where nombre_ciudad = '"+nombre_ciudad +"'");
		try {
			while (rs.next()) {
				id_ciudad =rs.getInt("id_ciudad");
			 }
		}
		catch(Exception e) {
			return null;
		}
		return id_ciudad;
	}
	
	public ArrayList<Ciudad> ciudadDeProvincia(Integer id_provincia){
		ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.ciudad where id_provincia = '"+ id_provincia+"'");
		try {
			while (rs.next()) {
				Integer id = rs.getInt("id_ciudad");
				Integer id_provincia1 = rs.getInt("id_provincia");
				String nombre_ciudad = rs.getString("nombre_ciudad");
				Boolean estado_ciudad = rs.getBoolean("estado_ciudad");
				Integer codigo_postal = rs.getInt("codigo_postal");
				ciudades.add(new Ciudad(id, id_provincia1, nombre_ciudad, estado_ciudad, codigo_postal));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ciudades;
	}
	
	@Override
	public Integer insert(Ciudad u) {
		System.out.println("pasa por CiudadDao");
		return BasedeDatos.getInstance().add("ciudad","id_provincia,nombre_ciudad,"
				+ "estado_ciudad,codigo_postal","'"+u.getId_provincia()+"','"+u.getNombre_ciudad()+"','"
				+ u.getEstado_ciudad()+"','"+u.getCodigo_postal()+"'","id_ciudad");
	}

	@Override
	public Boolean update(Ciudad u) {
		return BasedeDatos.getInstance().update("ciudad", u.getId_ciudad(), "id_provincia = '"+u.getId_provincia()+"', "
				+ "nombre_ciudad = '"+u.getNombre_ciudad()+"', estado_ciudad = '"+u.getEstado_ciudad()+"'," +
				" codigo_postal = '" + u.getCodigo_postal() +"'","id_ciudad");
	}

	@Override
	public Boolean remove(Ciudad u) {
		return BasedeDatos.getInstance().remove("ciudad",u.getId_ciudad(),"id_ciudad");
	}

}
