package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;



public class EncomiendaDao implements Dao<Encomienda> {
	//private Cliente destinatario=null;
	private Cliente remitente =null;

	public ArrayList<Encomienda> getAll(){
		ArrayList<Encomienda> encomiendas = new ArrayList<Encomienda>();
		//Encomienda encomienda = new Encomienda();
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.encomienda");
		try {
			System.out.println("Aca llego");
			while (rs.next()) {
				Integer id = rs.getInt("id_encomienda");
				Double peso = rs.getDouble("peso");
				Cliente destinatario = new Cliente(rs.getInt("nro_documento_destinatario"),
						rs.getString("tipo_documento_destinatario"),
						rs.getString("nombre_destinatario"),
						rs.getString("apellido_destinatario"), 
						rs.getInt("telefono_destinatario"));
				Cliente remitente = new Cliente(rs.getInt("nro_documento_remitente"),
						rs.getString("tipo_documento_remitente"),
						rs.getString("nombre_remitente"),
						rs.getString("apellido_remitente"),
						rs.getInt("telefono_remitente"));
				String ciudadOrigen = rs.getString("ciudad_origen");
				String ciudadDestino = rs.getString("ciudad_destino");
				String nombreCalle = rs.getString("nombre_calle");
				String depto = rs.getString("depto");
				Integer nroCalle = rs.getInt("nro_calle");
				Integer piso = rs.getInt("piso");
				String servicio = rs.getString("tipo_servicio");
				Double descuento= rs.getDouble("descuento");
				Double precio = rs.getDouble("precio_final");
				Boolean estado = rs.getBoolean("estado_encomienda");
			
				
				encomiendas.add(new Encomienda(id, peso, destinatario, remitente, ciudadOrigen, ciudadDestino, nombreCalle, depto, nroCalle, piso, servicio, descuento, precio, estado));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encomiendas;
	}
	
	public Encomienda get(Integer id) {
		Encomienda encomienda = null;
		Cliente remitente1 = null,destinatario1 = null;
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.encomienda where id_encomienda="+ id);
		try {
			while (rs.next()) {				
				Integer id11 = rs.getInt("id_encomienda");
				Double peso = rs.getDouble("peso");
				Cliente destinatario11 = new Cliente(rs.getInt("nro_documento_destinatario"),
						rs.getString("tipo_documento_destinatario"),
						rs.getString("nombre_destinatario"),
						rs.getString("apellido_destinatario"), 
						rs.getInt("telefono_destinatario"));
				Cliente remitente11 = new Cliente(rs.getInt("nro_documento_remitente"),
						rs.getString("tipo_documento_remitente"),
						rs.getString("nombre_remitente"),
						rs.getString("apellido_remitente"),
						rs.getInt("telefono_remitente"));
				String ciudadOrigen = rs.getString("ciudad_origen");
				String ciudadDestino = rs.getString("ciudad_destino");
				String nombreCalle = rs.getString("nombre_calle");
				String depto = rs.getString("depto");
				Integer nroCalle = rs.getInt("nro_calle");
				Integer piso = rs.getInt("piso");
				String servicio = rs.getString("tipo_servicio");
				Double descuento= rs.getDouble("descuento");
				Double precio = rs.getDouble("precio_final");
				Boolean estado = rs.getBoolean("estado_encomienda");
				encomienda = new Encomienda(id11, peso, destinatario11, remitente11, ciudadOrigen, ciudadDestino, nombreCalle, depto, nroCalle, piso, servicio, descuento, precio, estado);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encomienda;
		
	}
	
	/*public void buscador (String texto) {
		Encomienda encomienda = null;
		Cliente remitente1 = null,destinatario1 = null;
		String[] titulos = {"DNI DESTINATARIO", "DESTINATARIO", "REMITENTE", "ORIGEN", "DESTINO", "ESTADO", "ENVIO", "DIRECCION"};
		String filtro=""+texto+"_%";
		DefaultTableModel model = new DefaultTableModel(null, titulos);
		ResultSet rs = BasedeDatos.getInstance().getAll("SELECT * FROM public.encomienda where dni like '"+ filtro+"'");
		String [] fila = new String[9];
		try {
			while (rs.next()) {				
			fila[0] = rs.getInt("");
			fila[1]= rs.getString("");
			fila[2]= rs.getString("");
			fila[4]= rs.getString("");
			fila[5]= rs.getString("");
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return encomienda;
		
	}*/
	

	@Override
	public Integer insert(Encomienda u) {
		// TODO Auto-generated method stub
		return BasedeDatos.getInstance().add("encomienda"," peso, "
				+ "nro_documento_destinatario,tipo_documento_destinatario, nombre_destinatario, apellido_destinatario, telefono_destinatario, "
				+ "tipo_documento_remitente, nro_documento_remitente, nombre_remitente, apellido_remitente, telefono_remitente, "
				+ "ciudad_origen, ciudad_destino, nombre_calle, nro_calle, depto, piso, tipo_servicio, descuento, precio_final, estado_encomienda" ,
				"'"+u.getPeso()+"', '" + u.getDestinatario().getDni()+"', '"+ u.getDestinatario().getTipoDocumento()+"', '"
				+u.getDestinatario().getNombre()+"', '"+ u.getDestinatario().getApellido() +"', '"+u.getDestinatario().getTelefono()
				+"', '"+ u.getRemitente().getTipoDocumento()+"', '" +u.getRemitente().getDni()+"', '"+u.getRemitente().getNombre()+"', '"
				+ u.getRemitente().getApellido() +"', '"+u.getRemitente().getTelefono()+"', '"+u.getCiudadOrigen()+"', '"
				+u.getCiudadDestino()+"', '" + u.getNombreCalle()+ "', '"+ u.getNroCalle()+ "', '" + u.getDepto()+ "', '" 
				+ u.getPiso()+ "', '" + u.getTipoServicio()+ "', '"+ u.getDescuento() + "', '"+ u.getPrecioFinal()
				+ "', '"+u.getEstado_encomienda()+"'","id_encomienda");
	}

	@Override
	public Boolean update(Encomienda u) {
		// TODO Auto-generated method stub
		return BasedeDatos.getInstance().update("encomienda", u.getIdEncomienda(),"peso= '"+u.getPeso()+"' ,"
		+ "nro_documento_destinatario= '" + u.getDestinatario().getDni() + "', tipo_documento_destinatario= '" + u.getDestinatario().getTipoDocumento() 
		+ "', nombre_destinatario= '" + u.getDestinatario().getNombre() + "', apellido_destinatario= '" + u.getDestinatario().getApellido()
		+ "', telefono_destinatario= '" + u.getDestinatario().getTelefono() + "', tipo_documento_remitente= '" + u.getRemitente().getTipoDocumento()
		+ "', nro_documento_remitente= '" + u.getRemitente().getDni() + "', nombre_remitente= '" + u.getRemitente().getNombre() 
		+ "', apellido_remitente= '" + u.getRemitente().getApellido() + "', telefono_remitente= '" + u.getRemitente().getTelefono()
		+ "', ciudad_origen= '" + u.getCiudadOrigen() + "', ciudad_destino= '" + u.getCiudadDestino() + "', nombre_calle= '" + u.getNombreCalle()
		+ "', depto= '" + u.getDepto() + "', piso= '" + u.getPiso() + "', tipo_servicio= '" + u.getTipoServicio() + "', descuento = '" + u.getDescuento()
		+ "', precio_final= '" + u.getPrecioFinal() + "', estado_encomienda= '"+ u.getEstado_encomienda()+"'", "id_encomienda");
	}

	@Override
	public Boolean remove(Encomienda u) {
		// TODO Auto-generated method stub
		return BasedeDatos.getInstance().remove("encomienda",u.getIdEncomienda(), "id_encomienda");
	}

}
