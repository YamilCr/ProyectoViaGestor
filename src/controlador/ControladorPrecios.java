package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.Descuento;
import modelo.Medidas;
import modelo.Precio;
import modelo.PrecioDao;
import modelo.Recorrido;
import modelo.RecorridoDao;
import vista.VistaPrecios;

public class ControladorPrecios implements ActionListener {
	
	private VistaPrecios vista;
	private Precio precio;
	private PrecioDao precioDao;
	private RecorridoDao recorridoDao;

	public ControladorPrecios() {
		super();
		this.recorridoDao = new RecorridoDao();
		this.precioDao = new PrecioDao();
		this.vista = new VistaPrecios(this);
		this.vista.setVisible(true);
		this.vista.setLocationRelativeTo(null);
		
		muestraPrecios();
	}

	
	
	private void muestraPrecios() {
		try {
			Precio precio_km = getPrecioDao().get(1);
			Precio precio_kg = getPrecioDao().get(2);
			getVista().getLblPrecioKM().setText(String.valueOf(precio_km.getPrecio()));
			getVista().getLblPrecioKG().setText(String.valueOf(precio_kg.getPrecio()));
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		//BOTON MODIFICAR PRECIO
		if (e.getSource().equals(getVista().getBtnModificarPrecio())) {
			
			try {
			String tipo_medida = getVista().getComboBoxTipoMedida().getSelectedItem().toString();
			Double precio = Double.valueOf(getVista().getTextPrecio().getText());
			
				
			if  (tipo_medida.equals("KILOMETROS")) {
				
				if (JOptionPane.showConfirmDialog(null, "Se modificará el precio por KM ¿desea continuar?")==JOptionPane.YES_OPTION) {
					getPrecioDao().update(new Precio(1, tipo_medida, precio));
					getVista().getLblPrecioKM().setText(String.valueOf(precio)); 
					if (JOptionPane.showConfirmDialog(null, "El precio por KM se ha modificado ¿Desea actualizar el precio de los "
							+ "recorridos?")==JOptionPane.YES_OPTION) {
						for (Recorrido recorrido : getRecorridoDao().getAll()) {
							recorrido.setPrecio_final(recorrido.getKm()*precio);
							getRecorridoDao().update(recorrido);
						} 
						
				}
			} }
			
			if (tipo_medida.equals("PESO")) {

				if (JOptionPane.showConfirmDialog(null, "Se modificará el precio por peso ¿desea continuar?")==JOptionPane.YES_OPTION) {
				getPrecioDao().update(new Precio(2, tipo_medida, precio));
				getVista().getLblPrecioKG().setText(String.valueOf(precio)); 
				}
			}  
						
			
			if (tipo_medida.equals("ENVIO_DOMICILIO")) {
				if (JOptionPane.showConfirmDialog(null, "Se modificará el precio de envio a domicilio ¿desea continuar?")==JOptionPane.YES_OPTION) {
				getPrecioDao().update(new Precio(3, tipo_medida, precio));
				getVista().getLblPrecioDomicilio().setText(String.valueOf(precio)); 
				}
			}  
			
			}
			catch(Exception e1) {
				
				JOptionPane.showInternalMessageDialog(null, "Datos erroneos");
			}
		
			
			getVista().getTextPrecio().setText(" "); 
		
		}
		
		
		//BOTON ACEPTAR
		if (e.getSource().equals(getVista().getBtnAceptar())) {
			getVista().dispose();
		}
		
		//BOTON CANCELAR
		if (e.getSource().equals(getVista().getBtnCancelar())) {
			getVista().dispose();
		}
	
	}




	public void setVista(VistaPrecios vista) {
		this.vista = vista;
	}

	private VistaPrecios getVista() {
		return this.vista;
	}
	public Precio getPrecio() {
		return precio;
	}


	public void setPrecio(Precio precio) {
		this.precio = precio;
	}


	public PrecioDao getPrecioDao() {
		return precioDao;
	}


	public void setPrecioDao(PrecioDao precioDao) {
		this.precioDao = precioDao;
	}



	public RecorridoDao getRecorridoDao() {
		return recorridoDao;
	}



	public void setRecorridoDao(RecorridoDao recorridoDao) {
		this.recorridoDao = recorridoDao;
	}
	
	

}
