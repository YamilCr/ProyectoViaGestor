package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrecioDao implements Dao<Precio> {

	public ArrayList<Precio> getAll(){
		ArrayList<Precio> precios = new ArrayList<Precio>();
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.precio");
		try {
			while (rs.next()) {
				Integer id = rs.getInt("id_precio");
				String nombre_descuento = rs.getString("tipo_medida");
				Double porcentaje_descuento = rs.getDouble("precio");
				precios.add(new Precio(id,nombre_descuento,porcentaje_descuento));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return precios;
	}
		
		public Precio get(Integer id) {
			Precio precio = null;
			ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.precio where id_precio="+ id);
			try {
				while (rs.next()) {
					Integer idrs = rs.getInt("id_precio");
					String nombre_descuento = rs.getString("tipo_medida");
					Double porcentaje_descuento = rs.getDouble("precio");
					precio = new Precio(idrs,nombre_descuento,porcentaje_descuento);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return precio;
			
		}
		
	
	
	@Override
	public Integer insert(Precio u) {
		// TODO Auto-generated method stub
		return BasedeDatos.getInstance().add("precio","tipo_medida, precio" ,"'"+ u.getTipo_medida()+"','"+u.getPrecio()+"'","id_precio");
	}

	@Override
	public Boolean update(Precio u) {
		System.out.println("esta en el update");
		return BasedeDatos.getInstance().update("precio", u.getId_precio(), "tipo_medida = '"+u.getTipo_medida()+"', precio= '"+u.getPrecio()+"'", "id_precio");
	}

	@Override
	public Boolean remove(Precio u) {
		
		return BasedeDatos.getInstance().remove("precio", u.getId_precio(), "id_precio");
	}

}
