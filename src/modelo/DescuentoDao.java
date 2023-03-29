package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DescuentoDao implements Dao<Descuento> {
	
	public ArrayList<Descuento> getAll(){
		ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.descuento");
		try {
			while (rs.next()) {
				Integer id = rs.getInt("id_descuento");
				String nombre_descuento = rs.getString("nombre_descuento");
				Double porcentaje_descuento = rs.getDouble("porcentaje_descuento");
				descuentos.add(new Descuento(id,nombre_descuento,porcentaje_descuento));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return descuentos;
	}
	public Descuento get(Integer id) {
		Descuento descuento = null;
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.descuento where id_descuento="+ id);
		try {
			while (rs.next()) {
				Integer idrs = rs.getInt("id_descuento");
				String nombre_descuento = rs.getString("nombre_descuento");
				Double porcentaje_descuento = rs.getDouble("porcentaje_descuento");
				descuento = new Descuento(idrs,nombre_descuento,porcentaje_descuento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return descuento;
		
	}
	public Descuento getPorcentaje(String id) {
		Descuento descuento = null;
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM descuento where nombre_descuento = '"+ id+"'");
		try {
			while (rs.next()) {
				Integer idrs = rs.getInt("id_descuento");
				String nombre_descuento = rs.getString("nombre_descuento");
				Double porcentaje_descuento = rs.getDouble("porcentaje_descuento");
				descuento = new Descuento(idrs,nombre_descuento,porcentaje_descuento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return descuento;
		
	}

	
		
	

	@Override
	public Integer insert(Descuento u) {
		return BasedeDatos.getInstance().add("descuento","nombre_descuento,porcentaje_descuento" ,"'"+ u.getNombre_descuento()+"','"+u.getPorcentaje_descuento()+"'","id_descuento");		
	}

	@Override
	public Boolean update(Descuento u) {
		return BasedeDatos.getInstance().update("descuento", u.getId_descuento(), "nombre_descuento = '"+u.getNombre_descuento()+"', porcentaje_descuento = '"+u.getPorcentaje_descuento()+"'","id_descuento");
	}

	@Override
	public Boolean remove(Descuento u) {
		return BasedeDatos.getInstance().remove("descuento",u.getId_descuento(),"id_descuento");
		
	}


}
