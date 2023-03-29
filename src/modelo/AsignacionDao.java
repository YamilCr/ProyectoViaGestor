package modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AsignacionDao implements Dao<Asignacion> {
	
	
	public ArrayList<Asignacion> getAll(){
	ArrayList<Asignacion> asignaciones = new ArrayList<Asignacion>();
	ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.asignacion order by id_asignacion ASC");
	
	try {
		while (rs.next()) {
			Integer id = rs.getInt("id_asignacion");
			java.sql.Date fecha = rs.getDate("fecha_partida");
			String hora_salida = rs.getString("hora_salida");
			Integer nro_colectivo = rs.getInt("nro_colectivo");
			Integer nro_butacas = rs.getInt("nro_butacas");
			Integer disponibilidad_pasajes = rs.getInt("disponibilidad_pasajes");
			
			asignaciones.add(new Asignacion(id, fecha, hora_salida, nro_colectivo, nro_butacas, disponibilidad_pasajes));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return asignaciones;
}
	
public Asignacion get(Integer id) {
	Asignacion asignacion = null;
	ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.asignacion where id_asignacion="+ id);
	try {
		while (rs.next()) {
			Integer idrs = rs.getInt("id_asignacion");
			java.sql.Date fecha = rs.getDate("fecha_partida");
			String hora_salida = rs.getString("hora_salida");
			Integer nro_colectivo = rs.getInt("nro_colectivo");
			Integer nro_butacas = rs.getInt("nro_butacas");		
			Integer disponibilidad_pasajes = rs.getInt("disponibilidad_pasajes");
			
			asignacion = new Asignacion(idrs, fecha, hora_salida, nro_colectivo, nro_butacas, disponibilidad_pasajes);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return asignacion;
	
}
	
public Asignacion getAsignacion(String fecha, String hora) {
	Asignacion asignacion = null;
	ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.asignacion where fecha_partida='"+fecha+"' and hora_salida= '"+hora+"'");
	try {
		while (rs.next()) {
			Integer idrs = rs.getInt("id_asignacion");
			java.sql.Date fecha_partida = rs.getDate("fecha_partida");
			String hora_salida = rs.getString("hora_salida");
			Integer nro_colectivo = rs.getInt("nro_colectivo");
			Integer nro_butacas = rs.getInt("nro_butacas");		
			Integer disponibilidad_pasajes = rs.getInt("disponibilidad_pasajes");
			
			asignacion = new Asignacion(idrs, fecha_partida, hora_salida, nro_colectivo, nro_butacas, disponibilidad_pasajes);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return asignacion;
	
}



	@Override
	public Integer insert(Asignacion u) {
		return BasedeDatos.getInstance().add("asignacion","fecha_partida,hora_salida ,nro_colectivo, nro_butacas,disponibilidad_pasajes" ,
				"'"+ u.getFecha_partida()+"','"+u.getHora_salida()+"','"+u.getNro_colectivo()+"','"+u.getNro_butacas()+
				"','"+u.getDisponibilidad_pasajes()+ "'","id_asignacion");
	}




	@Override
	public Boolean update(Asignacion u) {
		return BasedeDatos.getInstance().update("asignacion", u.getId_asignacion(), "fecha_partida = '"
	+u.getFecha_partida()+"', hora_salida = '"+u.getHora_salida()+"', nro_butacas = '"+u.getNro_butacas()+ 
	"', nro_colectivo = '"+u.getNro_colectivo()+"', disponibilidad_pasajes = '"+u.getDisponibilidad_pasajes()+"'","id_asignacion");
	}




	@Override
	public Boolean remove(Asignacion u) {
		return BasedeDatos.getInstance().remove("asignacion",u.getId_asignacion(), "id_asignacion");
	}

}
