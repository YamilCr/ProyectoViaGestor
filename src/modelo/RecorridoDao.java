package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecorridoDao implements Dao<Recorrido> {
	
	public ArrayList<Recorrido> getAll(){
		ArrayList<Recorrido> recorridos = new ArrayList<Recorrido>();
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.recorrido");
		try {
			while (rs.next()) {
				Integer id = rs.getInt("id_recorrido");
				Integer idA = rs.getInt("id_asignacion");
				String ciudadD = rs.getString("ciudad_destino");
				String provinciaD = rs.getString("provincia_destino");
				String ciudadO = rs.getString("ciudad_origen");
				String provinciaO = rs.getString("provincia_origen");
				Double precio = rs.getDouble("precio_final");
				Boolean estado_recorrido =rs.getBoolean("estado_recorrido");
				Double km = rs.getDouble("km");
				Integer cant_pasajes_vendidos = rs.getInt("cant_pasajes_vendidos");
				recorridos.add(new Recorrido(id, idA, ciudadD, provinciaD, ciudadO, provinciaO, precio, estado_recorrido,km,cant_pasajes_vendidos));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recorridos;
	}
	
	public Recorrido get(Integer id) {
		Recorrido recorrido = null;
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.recorrido where id_recorrido="+ id);
		try {
			while (rs.next()) {
				Integer id2 = rs.getInt("id_recorrido");
				Integer idA = rs.getInt("id_asignacion");
				String ciudadD = rs.getString("ciudad_destino");
				String provinciaD = rs.getString("provincia_destino");
				String ciudadO = rs.getString("ciudad_origen");
				String provinciaO = rs.getString("provincia_origen");
				Double precio = rs.getDouble("precio_final");
				Boolean estado_recorrido =rs.getBoolean("estado_recorrido");
				Double km = rs.getDouble("km");
				Integer cant_pasajes_vendidos = rs.getInt("cant_pasajes_vendidos");
				recorrido = new Recorrido(id2, idA, ciudadD, provinciaD, ciudadO, provinciaO, precio, estado_recorrido,km ,  cant_pasajes_vendidos);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recorrido;	
	}
	
	
	public ArrayList<Integer> obtenerAsignaciones(String ciudad_destino, String ciudad_origen) {
		ArrayList<Integer> id_asignaciones = new ArrayList<Integer>();
		ResultSet rs = BasedeDatos.getInstance().getAll("Select id_asignacion from recorrido "
				+ "where ciudad_destino= '"+ciudad_destino+"' and ciudad_origen= '"+ciudad_origen+"'");
		try {
			while (rs.next()) {
				Integer id = rs.getInt("id_asignacion");
				
				id_asignaciones.add(id);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id_asignaciones;
	}
	
	public ArrayList<String> obtenerRecorridos(){
		ArrayList<String> recorridos = new ArrayList<String>();
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT recorrido.ciudad_destino, "
				+ "recorrido.ciudad_origen, recorrido.estado_recorrido FROM public.recorrido");
		try {
			while (rs.next()) {
				if (rs.getBoolean("estado_recorrido")) {
					
					String ciudadD = rs.getString("ciudad_destino");
					String ciudadO = rs.getString("ciudad_origen");
	
					String cadena= ciudadD+"-"+ciudadO;
					if (!(recorridos.contains(cadena))) {
						recorridos.add(cadena);
					}
			}
		} 
			}catch (SQLException e) {
			e.printStackTrace();
		}
	
		return recorridos;
	}
	
	public Recorrido recorridoAsignacion(String ciudad_destino, String ciudad_origen, Integer id_asignacion){
		Recorrido recorrido=null;
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.recorrido where "
				+ "(recorrido.ciudad_destino= '"+ciudad_destino+"') and (recorrido.ciudad_origen= '"+ciudad_origen+"') "
						+ "and (recorrido.id_asignacion= '"+id_asignacion+"')");
		try {
			while (rs.next()) {
					
					Integer id2 = rs.getInt("id_recorrido");
					Integer idA = rs.getInt("id_asignacion");
					String ciudadD = rs.getString("ciudad_destino");
					String provinciaD = rs.getString("provincia_destino");
					String ciudadO = rs.getString("ciudad_origen");
					String provinciaO = rs.getString("provincia_origen");
					Double precio = rs.getDouble("precio_final");
					Boolean estado_recorrido =rs.getBoolean("estado_recorrido");
					Double km = rs.getDouble("km");
					Integer cant_pasajes_vendidos = rs.getInt("cant_pasajes_vendidos");
					recorrido = new Recorrido(id2, idA, ciudadD, provinciaD, ciudadO, provinciaO, precio, estado_recorrido,km ,  cant_pasajes_vendidos);
	
			}
		} 
			catch (SQLException e) {
			e.printStackTrace();
		}
	
		return recorrido;
	}
	
	@Override
	public Integer insert(Recorrido u) {
		
		return BasedeDatos.getInstance().add("recorrido", "id_asignacion, ciudad_destino, provincia_destino, "
				+ "ciudad_origen, provincia_origen, precio_final, estado_recorrido, km, cant_pasajes_vendidos",
				" '"+ u.getId_asignacion() + "', '"+ u.getCiudad_destino() +"', '"+ u.getProvincia_destino() +"', '"
				+ u.getCiudad_origen()+"', '"+ u.getProvincia_origen()+"', '"+ u.getPrecio_final()+"', '"+
						u.getEstado_recorrido()+"', '" + u.getKm()+"', '" + u.getCant_pasajes_vendidos()+"'","id_recorrido");
	}

	@Override
	public Boolean update(Recorrido u) {
		// TODO Auto-generated method stub
		return BasedeDatos.getInstance().update("recorrido",u.getId_recorrido(),"id_asignacion= '"+ u.getId_asignacion()+
				"', ciudad_destino= '"+ u.getCiudad_destino()+"', provincia_destino= '"+ u.getProvincia_destino()+
				"', ciudad_origen= '"+ u.getCiudad_origen()+"', provincia_origen= '"+ u.getProvincia_origen()+
				"', precio_final= '"+ u.getPrecio_final()+"', estado_recorrido= '"+u.getEstado_recorrido()
				+"', km= '" + u.getKm()+"', cant_pasajes_vendidos = '" + u.getCant_pasajes_vendidos()+"'","id_recorrido");
	}

	@Override
	public Boolean remove(Recorrido u) {
		// TODO Auto-generated method stub
		return BasedeDatos.getInstance().remove("recorrido",u.getId_recorrido(),"id_recorrido");
	}

}
