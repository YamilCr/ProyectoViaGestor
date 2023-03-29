package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProvinciaDao implements Dao<Provincia> {

	public ArrayList<Provincia> getAll(){
		ArrayList<Provincia> provincias = new ArrayList<Provincia>();
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.provincia");
		try {
			while (rs.next()) {
				Integer id = rs.getInt("id_provincia");
				String nombre = rs.getString("nombre_provincia");
				
				provincias.add(new Provincia(id, nombre));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return provincias;
	}
	public Provincia get(Integer id) {
		Provincia provincia = null;
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.provincia where id_provincia="+ id);
		try {
			while (rs.next()) {
				Integer id2 = rs.getInt("id_provincia");
				String nombre = rs.getString("nombre_provincia");
				
				provincia= new Provincia(id2, nombre);
							}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return provincia;	
	}
	
	public Boolean provinciaNueva(String nombre_provincia) {
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.provincia where nombre_provincia = '"+nombre_provincia +"'");
		try {
			while (rs.next()) {		
				return false;
							}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;	
	}
	
	public Integer obtenerIdProvincia(String nombre_provincia) {
		Integer id_provincia=null;
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.provincia where nombre_provincia = '"+nombre_provincia +"'");
		try {
			while (rs.next()) {
			id_provincia =rs.getInt("id_provincia");
			System.out.println(id_provincia);
			 }
		}
		catch(Exception e) {
			return null;
		}
		return id_provincia;
	}

	@Override
	public Integer insert(Provincia u) {
		// TODO Auto-generated method stub
		return BasedeDatos.getInstance().add("provincia","nombre_provincia","'"+u.getNombre_provincia()+"'","id_provincia");
	}

	@Override
	public Boolean update(Provincia u) {
		// TODO Auto-generated method stub
		return BasedeDatos.getInstance().update("provincia", u.getId_provincia(), "nombre_provincia= '" +u.getNombre_provincia()+"'","id_provincia");
	}

	@Override
	public Boolean remove(Provincia u) {
		// TODO Auto-generated method stub
		return BasedeDatos.getInstance().remove("provincia", u.getId_provincia(),"id_provincia");
	}

}
