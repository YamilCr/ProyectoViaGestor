package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import modelo.AsignacionDao;
import modelo.Ciudad;
import modelo.CiudadDao;
import modelo.Cliente;
import modelo.Descuento;
import modelo.DescuentoDao;
import modelo.Empleado;
import modelo.Encomienda;
import modelo.EncomiendaDao;
import modelo.Precio;
import modelo.PrecioDao;
import modelo.Provincia;
import modelo.ProvinciaDao;
import modelo.Recorrido;
import modelo.RecorridoDao;
import vista.VistaEncomiendas;

public class ControladorEncomiendas implements ActionListener, FocusListener, ItemListener, KeyListener{
	private VistaEncomiendas view;
	private EncomiendaDao encomiendas = new EncomiendaDao();
	private RecorridoDao recorridos = new RecorridoDao();
	private ProvinciaDao provinciaDao = new ProvinciaDao();
	private CiudadDao ciudadDao = new CiudadDao();
	private DescuentoDao descuentoDao;
	private PrecioDao precioDao;
	//private ControladorTablaEncomienda c;
	private DecimalFormat df = new DecimalFormat("#.00");
	private Double precio=0.0;
	Double precio_con_envio=0.0;
	public ControladorEncomiendas() {
		super();
		//this.cTablaEncomienda = new ControladorTablaEncomienda();
		this.descuentoDao = new DescuentoDao();
		this.provinciaDao = new ProvinciaDao();
		this.precioDao= new PrecioDao();
		this.ciudadDao = new CiudadDao();
		this.setView(new VistaEncomiendas(this));
		this.getView().setVisible(true);
		this.getView().setLocationRelativeTo(null);
		mostrarProvincias();
		mostrarDescuentos();
	}
	

	private void mostrarProvincias() {
	for (Provincia provincia : getProvinciaDao().getAll()) {
		 
		getView().getComboBoxProvD().addItem(provincia.getNombre_provincia());
		getView().getComboBoxProvO().addItem(provincia.getNombre_provincia());
		
	}
	}
	
	private void mostrarDescuentos() {
		for (Descuento descuentos : getDescuentoDao().getAll()) {
			 
			getView().getComboBoxDescuentoE().addItem(descuentos.getNombre_descuento()+"-"+String.valueOf(descuentos.getPorcentaje_descuento()*100)+"%");
			
		}
	}
	

	public VistaEncomiendas getView() {
		return view;
	}


	public void setView(VistaEncomiendas view) {
		this.view = view;
	}
	
	public double getValor(String texto){
	    if(texto.contains(",")){
	        return Double.parseDouble(texto.replace(",", ".").trim());
	    }
	    return Double.parseDouble(texto.trim());
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getView().getComboBoxProvD())) {
			getView().getComboBoxDestino().removeAllItems();
			if (getView().getComboBoxProvD().getSelectedIndex()!=0) {
				Integer id_provincia = getProvinciaDao().obtenerIdProvincia(String.valueOf(getView().getComboBoxProvD().getSelectedItem()));
				for (Ciudad ciudad : getCiudadDao().ciudadDeProvincia(id_provincia)) {
					getView().getComboBoxDestino().addItem(ciudad.getNombre_ciudad());
				}
				
			} 
		}
		
		if (e.getSource().equals(getView().getComboBoxProvO())) {
			getView().getComboBoxOrigen().removeAllItems();
			if (getView().getComboBoxProvO().getSelectedIndex()!=0) {
				Integer id_provincia = getProvinciaDao().obtenerIdProvincia(String.valueOf(getView().getComboBoxProvO().getSelectedItem()));
				for (Ciudad ciudad : getCiudadDao().ciudadDeProvincia(id_provincia)) {
					getView().getComboBoxOrigen().addItem(ciudad.getNombre_ciudad());
				} 
				
			}
		}
		
		
		if (e.getSource().equals(getView().getComboBoxOrigen())) {
			try {
				if (String.valueOf(getView().getComboBoxOrigen().getSelectedItem()).equals("Seleccione una provincia")) {
					
					throw new Exception();
				} 
				} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Seleccione un origen");	
			}
		}
		
		if (e.getSource().equals(getView().getComboBoxDestino())) {
			if (getView().getComboBoxDestino().getSelectedIndex() == 0)
				try {
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Seleccione un destino");
				}
			}
		
		if (e.getSource().equals(getView().getComboBoxDescuentoE())) {
			Precio extra = getPrecioDao().get(3);
			
			if (getView().getComboBoxDescuentoE().getSelectedIndex()==0 && !(getView().getChckbxEnvioADomicilio().isSelected())) {
				getView().getCalculoPrecio().setText(String.valueOf(df.format(getPrecio())));
			}
			
			if (getView().getComboBoxDescuentoE().getSelectedIndex()==0 && (getView().getChckbxEnvioADomicilio().isSelected())) {
				getView().getCalculoPrecio().setText(String.valueOf(df.format(getPrecio()+extra.getPrecio())));
			}
			
			if (getView().getComboBoxDescuentoE().getSelectedIndex()>0 && !(getView().getChckbxEnvioADomicilio().isSelected())) {
				//obtengo el nombre de mi descuento
				String[] vectorD = String.valueOf(getView().getComboBoxDescuentoE().getSelectedItem()).split("-");				
				//obtengo mi descuento
				Descuento descuento = getDescuentoDao().getPorcentaje(vectorD[0]);
				Double calculo = getPrecio()- (getPrecio()*descuento.getPorcentaje_descuento());
				
				getView().getCalculoPrecio().setText(String.valueOf(df.format(calculo)));
				
			}
			
			if (getView().getComboBoxDescuentoE().getSelectedIndex()>0 && (getView().getChckbxEnvioADomicilio().isSelected())) {
				String[] vectorD = String.valueOf(getView().getComboBoxDescuentoE().getSelectedItem()).split("-");				
				//obtengo mi descuento
				Descuento descuento = getDescuentoDao().getPorcentaje(vectorD[0]);
				Double calculo = getPrecio()- (getPrecio()*descuento.getPorcentaje_descuento());
				getView().getCalculoPrecio().setText(String.valueOf(df.format(calculo+extra.getPrecio())));
			}
		}
			
	
		
		//BOTON CONFIRMAR
		if (e.getSource().equals(this.getView().getBtnConfirmar())) {				
			try {		
				Double peso = Double.valueOf(getView().getTextPeso().getText());
		
				//calculo precio
				Double precio_final = getValor(getView().getCalculoPrecio().getText());
		
		
				//remitente
				Cliente remitente= new Cliente(Integer.valueOf(getView().getTextDniRemitente().getText()), 
				new String((String)getView().getComboBoxDni().getSelectedItem()), 
				getView().getTextNombreRemitente().getText(), 
				getView().getTextApellidoRemitente().getText(), 
				Integer.valueOf(getView().getTextTelefonoRemitente().getText()));
		
				//destinatario
				Cliente  destinatario = new Cliente(Integer.valueOf(getView().getTextDniDestinatario().getText()), 
				new String((String)getView().getComboBoxDni_1().getSelectedItem()), 
				getView().getTextNombreDestinatario().getText(), 
				getView().getTextApellidoDestinatario().getText(), 
				Integer.valueOf(getView().getTextTelefonoDestinatario().getText())); 
				


				//ciudades
				String ciudadOrigen = (String)getView().getComboBoxOrigen().getSelectedItem();
				String ciudadDestino =(String)getView().getComboBoxDestino().getSelectedItem();			
					
				if (ciudadOrigen.equals("Seleccione una provincia")) {
					throw new Exception();
				}
				
				if (ciudadDestino.equals("Seleccione una provincia")) {
					throw new Exception();
				}
				
				
				String tipoServicio = getView().getLbltipoServicio().getText(); 
				String calle = null;
				Integer nro = 0;
				Integer piso = 0;
				String depto = null;
				
				if (getView().getChckbxEnvioADomicilio().isSelected()) {
					calle = getView().getTextCalle().getText();
					nro = Integer.valueOf(getView().getTextNumero().getText());
					piso = Integer.valueOf(getView().getTextPiso().getText());
					depto = getView().getTextDepto().getText();
				}
	    
				Double descuento_final = 0.0;
				//Obtiene el precio con el descuento
				if (getView().getComboBoxDescuentoE().getSelectedIndex()!=0) {
					String[] vector =String.valueOf (getView().getComboBoxDescuentoE().getSelectedItem()).split("-");
					Descuento descuento_seleccionado = getDescuentoDao().getPorcentaje(vector[0]); 
					descuento_final = precio_final*descuento_seleccionado.getPorcentaje_descuento(); 
				}
				
				
				getEncomiendas().insert(new Encomienda(null,peso, remitente, 
	    		destinatario, ciudadOrigen, ciudadDestino, calle, depto, nro, piso, tipoServicio, descuento_final,
	    		precio_final,true));
				getView().dispose();
				new ControladorEncomiendas();
				JOptionPane.showMessageDialog(null,"¡PAQUETE REGISTRADO! PRECIO FINAL: " + precio_final);
				
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null,"¡DATOS INCORRECTOS!");
			System.out.println(e1);
		}	
		}
		
		
		//BOTON CANCELAR
		if (e.getSource().equals(getView().getBtnCancelar())) {
			getView().dispose();
		}
		
		//BOTON CANCELAR
		if (e.getSource().equals(getView().getBtnCancelarTEncomienda())) {
			getView().dispose();
			new ControladorTablaEncomienda();
		}
		
		//BOTON MODIFICAR
		if (e.getSource().equals(getView().getBtnModificar())) {
			//Obtengo la encomienda para modificar
			Integer id = Integer.valueOf(getView().getId().getText());
			Encomienda encomiendaModificar = getEncomiendas().get(id);
			
			try {
			
			encomiendaModificar.setPeso(Double.valueOf(getView().getTextPeso().getText())); 
			encomiendaModificar.setPrecioFinal(getValor(getView().getCalculoPrecio().getText())); 
	
			//remitente
			
			Cliente remitente= new Cliente(Integer.valueOf(getView().getTextDniRemitente().getText()), 
			new String((String)getView().getComboBoxDni().getSelectedItem()), 
			getView().getTextNombreRemitente().getText(), 
			getView().getTextApellidoRemitente().getText(), 
			Integer.valueOf(getView().getTextTelefonoRemitente().getText()));
			
			encomiendaModificar.setRemitente(remitente);
			//destinatario
			Cliente  destinatario = new Cliente(Integer.valueOf(getView().getTextDniDestinatario().getText()), 
			new String((String)getView().getComboBoxDni_1().getSelectedItem()), 
			getView().getTextNombreDestinatario().getText(), 
			getView().getTextApellidoDestinatario().getText(), 
			Integer.valueOf(getView().getTextTelefonoDestinatario().getText()));
			encomiendaModificar.setDestinatario(destinatario);


			//ciudades		
			encomiendaModificar.setCiudadOrigen((String)getView().getComboBoxOrigen().getSelectedItem());
			encomiendaModificar.setCiudadDestino((String)getView().getComboBoxDestino().getSelectedItem());
			
			if (encomiendaModificar.getCiudadOrigen().equals("Seleccione una provincia")) {
				throw new Exception();
			}
			
			if (encomiendaModificar.getCiudadDestino().equals("Seleccione una provincia")) {
				throw new Exception();
			}
			
			
			encomiendaModificar.setTipoServicio(getView().getLbltipoServicio().getText());
			
			if (getView().getChckbxEnvioADomicilio().isSelected()) {
				encomiendaModificar.setNombreCalle(getView().getTextCalle().getText());
				encomiendaModificar.setNroCalle(Integer.valueOf(getView().getTextNumero().getText()));
				encomiendaModificar.setPiso(Integer.valueOf(getView().getTextPiso().getText()));
				encomiendaModificar.setDepto(getView().getTextDepto().getText());
			} else {
				encomiendaModificar.setNombreCalle(null);
				encomiendaModificar.setNroCalle(0);
				encomiendaModificar.setPiso(0);
				encomiendaModificar.setDepto(null);
			}
    
			//Obtiene el precio con el descuento
			if (getView().getComboBoxDescuentoE().getSelectedIndex()!=0) {
				String[] vector =String.valueOf (getView().getComboBoxDescuentoE().getSelectedItem()).split("-");
				Descuento descuento_seleccionado = getDescuentoDao().getPorcentaje(vector[0]); 
				encomiendaModificar.setDescuento(encomiendaModificar.getPrecioFinal()*descuento_seleccionado.getPorcentaje_descuento()); 
			} else {
				encomiendaModificar.setDescuento(0.0);
			}
			 
			if (JOptionPane.showConfirmDialog(null, "Se modificará el registro, ¿desea continuar?")==JOptionPane.YES_OPTION) {
			getEncomiendas().update(encomiendaModificar);
			getView().dispose();
			new ControladorTablaEncomienda();
			JOptionPane.showMessageDialog(null, "¡Se ha modificado el registro!");
			 }
			} catch(Exception e1) {
				System.out.println(e1);
				JOptionPane.showMessageDialog(null, "Datos incorrectos");
			}
			
		}
	}


	@Override
	public void focusGained(FocusEvent e) {

	}


	@Override
	public void focusLost(FocusEvent e) {

				
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		Precio extra = getPrecioDao().get(3);
		if(e.getSource().equals(getView().getChckbxEnvioADomicilio())) {
			
			if (getView().getChckbxEnvioADomicilio().isSelected()) {
				this.getView().getPanelDomicilio().setVisible(true);
				getView().getLbltipoServicio().setText("ENVIO A DOMICILIO");

				getView().getCalculoPrecio().setText(String.valueOf(df.format(getPrecio()+extra.getPrecio())));
				
			} else {
				this.getView().getPanelDomicilio().setVisible(false);
				getView().getLbltipoServicio().setText("ENVIO A SUCURSAL");
				getView().getCalculoPrecio().setText(String.valueOf(getPrecio()));
			}
			
		}
		
		/*if (!(getView().getCalculoPrecio().getText().equals("0.0"))) {
			precio_sin_modificacion = getValor(getView().getCalculoPrecio().getText());
					
			
			if (getView().getChckbxEnvioADomicilio().isSelected()) {
				this.getView().getPanelDomicilio().setVisible(true);
				getView().getLbltipoServicio().setText("ENVIO A DOMICILIO");
			} else {
				getView().getLbltipoServicio().setText("ENVIO A SUCURSAL");
			}
		}*/
		
		/*try {
			if (!(this.getView().getCalculoPrecio().getText().equals("0.0"))) {
			if (this.getView().getChckbxEnvioADomicilio().isSelected()) {
				this.getView().getPanelDomicilio().setVisible(true);
				getView().getLbltipoServicio().setText("ENVIO A DOMICILIO");
				
				if (Double.valueOf(getView().getTextPeso().getText())!=0) {
					Precio envio_domicilio = getPrecioDao().get(3); 
					this.getView().getCalculoPrecio().setText(String.valueOf(getPrecio()+envio_domicilio.getPrecio()));
				}			
					 
			} 
			
			else {
				this.getView().getPanelDomicilio().setVisible(false);		
				getView().getLbltipoServicio().setText("ENVIO A SUCURSAL");
				getView().getCalculoPrecio().setText(String.valueOf(this.getPrecio()));
			}
		 
		} } catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Cargue un peso, antes de seleccionar esta opcion");
		}*/	
	}
		



	public EncomiendaDao getEncomiendas() {
		return encomiendas;
	}


	public void setEncomiendas(EncomiendaDao encomiendas) {
		this.encomiendas = encomiendas;
	}


	public RecorridoDao getRecorridos() {
		return recorridos;
	}


	public void setRecorridos(RecorridoDao recorridos) {
		this.recorridos = recorridos;
	}


	public ProvinciaDao getProvinciaDao() {
		return provinciaDao;
	}


	public void setProvinciaDao(ProvinciaDao provinciaDao) {
		this.provinciaDao = provinciaDao;
	}


	public CiudadDao getCiudadDao() {
		return ciudadDao;
	}


	public void setCiudadDao(CiudadDao ciudadDao) {
		this.ciudadDao = ciudadDao;
	}

	public DescuentoDao getDescuentoDao() {
		return descuentoDao;
	}

	public void setDescuentoDao(DescuentoDao descuentoDao) {
		this.descuentoDao = descuentoDao;
	}

	public PrecioDao getPrecioDao() {
		return precioDao;
	}

	public void setPrecioDao(PrecioDao precioDao) {
		this.precioDao = precioDao;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		try {
			
			Precio precio= getPrecioDao().get(2);
			Double calculo= getValor(getView().getTextPeso().getText())*precio.getPrecio();
			getView().getCalculoPrecio().setText(String.valueOf(df.format(calculo)));
			this.setPrecio(calculo); 
			
			} catch (Exception e1) {	
				getView().getCalculoPrecio().setText("0.0");
			}

	
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public Double getPrecio_con_envio() {
		return precio_con_envio;
	}


	public void setPrecio_con_envio(Double precio_con_envio) {
		this.precio_con_envio = precio_con_envio;
	}




	
	
		}


