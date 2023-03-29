package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.security.PublicKey;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import org.apache.commons.digester.annotations.rules.SetRoot;

import modelo.Asignacion;
import modelo.AsignacionDao;
import modelo.Cliente;
import modelo.Descuento;
import modelo.DescuentoDao;
import modelo.Pasaje;
import modelo.PasajeDao;
import modelo.Recorrido;
import modelo.RecorridoDao;
import vista.VistaPasajes;

public class ControladorPasajes implements ActionListener, FocusListener, ItemListener{
	
	private VistaPasajes view;
	private PasajeDao pasaje= new PasajeDao();
	private RecorridoDao recorridos= new RecorridoDao();
	private AsignacionDao asignacion = new AsignacionDao();
	private DescuentoDao descuento = new DescuentoDao();
	private ArrayList<Recorrido> listaA = new ArrayList<Recorrido>();
	private DecimalFormat df = new DecimalFormat("#.00");
	private Double precio=0.0;
	
	public ControladorPasajes() {
		super();
		this.setView(new VistaPasajes(this));
		this.getView().setVisible(true);
		this.getView().setLocationRelativeTo(null);		
		
		cargaDescuentos();
		cargaComboBoxRecorridos();
	}


	
	private void cargaComboBoxRecorridos() {
		for (String e : getRecorridos().obtenerRecorridos()) {
			getView().getComboBoxOrigenDestino().addItem(e);
			
		}
	}
	
	private void cargaDescuentos() {
		for (Descuento de : getDescuento().getAll()) {
			getView().getComboBoxDescuentoE().addItem(de.getNombre_descuento());
		}
	}
	
	private void asientosReservados(Integer id_recorrido) {
		for (Pasaje pasaje : getPasaje().asientosOcupados(id_recorrido)) {
			
			switch (pasaje.getNroButaca()) {
			case 1:
				getView().getBtn1().setEnabled(false);
				getView().getBtn1().setBackground(Color.red);
				break;
				
			case 2:
				getView().getBtn2().setEnabled(false);
				getView().getBtn2().setBackground(Color.red);
				break;
			case 3:
				getView().getBtn3().setEnabled(false);
				getView().getBtn3().setBackground(Color.red);
				break;	
			case 4:
				getView().getBtn4().setEnabled(false);
				getView().getBtn4().setBackground(Color.red);
				break;
			case 5:
				getView().getBtn5().setEnabled(false);
				getView().getBtn5().setBackground(Color.red);
				break;
			case 6:
				getView().getBtn6().setEnabled(false);
				getView().getBtn6().setBackground(Color.red);
				break;
			case 7:
				getView().getBtn7().setEnabled(false);
				getView().getBtn7().setBackground(Color.red);
				break;
			case 8:
				getView().getBtn8().setEnabled(false);
				getView().getBtn8().setBackground(Color.red);
				break;
			case 9:
				getView().getBtn9().setEnabled(false);
				getView().getBtn9().setBackground(Color.red);
				break;
			case 10:
				getView().getBtn10().setEnabled(false);
				getView().getBtn10().setBackground(Color.red);
				break;	
				
			default:
				break;
			}	
		}
		
	}
	
	private void restauraAsientos() {
				getView().getBtn1().setEnabled(true);
				getView().getBtn1().setBackground(new Color(104, 232, 100));
				
				getView().getBtn2().setEnabled(true);
				getView().getBtn2().setBackground(new Color(104, 232, 100));
				
				getView().getBtn3().setEnabled(true);
				getView().getBtn3().setBackground(new Color(104, 232, 100));
				
				getView().getBtn4().setEnabled(true);
				getView().getBtn4().setBackground(new Color(104, 232, 100));
				
				getView().getBtn5().setEnabled(true);
				getView().getBtn5().setBackground(new Color(104, 232, 100));
				
				getView().getBtn6().setEnabled(true);
				getView().getBtn6().setBackground(new Color(104, 232, 100));
				
				getView().getBtn7().setEnabled(true);
				getView().getBtn7().setBackground(new Color(104, 232, 100));
				
				getView().getBtn8().setEnabled(true);
				getView().getBtn8().setBackground(new Color(104, 232, 100));
				
				getView().getBtn9().setEnabled(true);
				getView().getBtn9().setBackground(new Color(104, 232, 100));
				
				getView().getBtn10().setEnabled(true);
				getView().getBtn10().setBackground(new Color(104, 232, 100));
		}

	
	public double getValor(String texto){
	    if(texto.contains(",")){
	        return Double.parseDouble(texto.replace(",", ".").trim());
	    }
	    return Double.parseDouble(texto.trim());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(getView().getBtnCancelar())) {
			getView().dispose();
		}
		
		if (e.getSource().equals(getView().getComboBoxOrigenDestino())) {
			
			getView().getComboBoxFechaDisponibles().removeAllItems();

			if(getView().getComboBoxOrigenDestino().getSelectedIndex()>0) {
				String[] ciudades = String.valueOf(getView().getComboBoxOrigenDestino().getSelectedItem()).split("-");
				String destino = ciudades[0];
				String origen = ciudades[1];
				
				for (Integer id : getRecorridos().obtenerAsignaciones(destino, origen)) {
					Asignacion asignacion = getAsignacion().get(id);
					
					getView().getComboBoxFechaDisponibles().addItem(asignacion.getFecha_partida() + "/" + asignacion.getHora_salida());
				}
			
				
				//obtengo la id de la asignacion
				String[] asignacion = String.valueOf(getView().getComboBoxFechaDisponibles().getSelectedItem()).split("/"); //FECHA - HORA
				Asignacion a= getAsignacion().getAsignacion(asignacion[0], asignacion[1]);
				
				
				//obtengo el id del recorrido con su asignacion
				String[] recorrido = String.valueOf(getView().getComboBoxOrigenDestino().getSelectedItem()).split("-"); //DESTINO - ORIGEN
				Recorrido r = getRecorridos().recorridoAsignacion(recorrido[0], recorrido[1], a.getId_asignacion());	
				
				Double precio = r.getPrecio_final();
				
				getView().getLblPrecioFinal().setText(String.valueOf(df.format(precio)));
				this.setPrecio(getValor(df.format(precio)));
				
			
			}
			
			
		}		if (e.getSource().equals(this.getView().getBtnModificar())) {
			try {
				
				
				//obtengo la id de la asignacion
				String[] asignacion = String.valueOf(getView().getComboBoxFechaDisponibles().getSelectedItem()).split("/"); //FECHA - HORA
				Asignacion a= getAsignacion().getAsignacion(asignacion[0], asignacion[1]);
			
			
				//obtengo el id del recorrido con su asignacion
				String[] recorrido = String.valueOf(getView().getComboBoxOrigenDestino().getSelectedItem()).split("-"); //DESTINO - ORIGEN
				Recorrido r = getRecorridos().recorridoAsignacion(recorrido[0], recorrido[1], a.getId_asignacion());
			
				//Cliente
				Cliente pasajero = new Cliente(Integer.valueOf(getView().getTextNumeroDoc().getText()), 
					new String((String)getView().getComboBoxDni().getSelectedItem()),
					getView().getTextNombrePasajero().getText(), 
					getView().getTextApellido().getText(), 
					Integer.valueOf(getView().getTextTelefono().getText()));
			
				
				Integer nro_butaca = Integer.valueOf(getView().getLblNroButaca().getText());
				
				if (nro_butaca==0) {
					throw new Exception();
				}
				
				Double precio_final = getValor(getView().getLblPrecioFinal().getText());
			
				Descuento d = getDescuento().getPorcentaje(String.valueOf(getView().getComboBoxDescuentoE().getSelectedItem()));
				Double descuento = precio_final*d.getPorcentaje_descuento();
			
			
				//Aumento la cantidad de pasajes venidos de x recorrido
				Integer i = r.getCant_pasajes_vendidos();
				Integer idP = Integer.valueOf(getView().getLblIDBoleto().getText());
				r.setCant_pasajes_vendidos(i++);
				getRecorridos().update(r);
			
				getPasaje().update(new Pasaje(idP, pasajero, nro_butaca, descuento, precio_final, true, r.getId_recorrido()));
			
				getView().dispose();
				JOptionPane.showMessageDialog(null, "¡Cambio Confirmado!");
				new ControladorTablaPasajes();
				}
				catch(Exception e1) {
				JOptionPane.showMessageDialog(null, "Datos incorrectos");
				//System.out.println(e1);
			}
		
		}
	
		
		
		
			if (e.getSource().equals(this.getView().getBtnConfirmar())) {
				try {
				
					
					//obtengo la id de la asignacion
					String[] asignacion = String.valueOf(getView().getComboBoxFechaDisponibles().getSelectedItem()).split("/"); //FECHA - HORA
					Asignacion a= getAsignacion().getAsignacion(asignacion[0], asignacion[1]);
				
				
					//obtengo el id del recorrido con su asignacion
					String[] recorrido = String.valueOf(getView().getComboBoxOrigenDestino().getSelectedItem()).split("-"); //DESTINO - ORIGEN
					Recorrido r = getRecorridos().recorridoAsignacion(recorrido[0], recorrido[1], a.getId_asignacion());
				
					//Cliente
					Cliente pasajero = new Cliente(Integer.valueOf(getView().getTextNumeroDoc().getText()), 
						new String((String)getView().getComboBoxDni().getSelectedItem()),
						getView().getTextNombrePasajero().getText(), 
						getView().getTextApellido().getText(), 
						Integer.valueOf(getView().getTextTelefono().getText()));
				
					
					Integer nro_butaca = Integer.valueOf(getView().getLblNroButaca().getText());
					
					if (nro_butaca==0) {
						throw new Exception();
					}
					
					Double precio_final = getValor(getView().getLblPrecioFinal().getText());
				
					Descuento d = getDescuento().getPorcentaje(String.valueOf(getView().getComboBoxDescuentoE().getSelectedItem()));
					Double descuento = precio_final*d.getPorcentaje_descuento();
				
				
					//Aumento la cantidad de pasajes venidos de x recorrido
					Integer i = r.getCant_pasajes_vendidos();
					r.setCant_pasajes_vendidos(i++);
					getRecorridos().update(r);
				
					getPasaje().insert(new Pasaje(null, pasajero, nro_butaca, descuento, precio_final, true, r.getId_recorrido()));
				
					getView().dispose();
					JOptionPane.showMessageDialog(null, "¡Pasaje registrado!");
					new ControladorPasajes();
					}
					catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Datos incorrectos");
					//System.out.println(e1);
				}
					
			}
			
			
			if (e.getSource().equals(getView().getBtn1())) {
				if (getView().getBtn1().isSelected()) {
					getView().getLblNroButaca().setText("1");
				}
			}
			
			if (e.getSource().equals(getView().getBtn2())) {
				if (getView().getBtn2().isSelected()) {
					getView().getLblNroButaca().setText("2");
				} else {
					getView().getBtn2().setBackground(new Color(104, 232, 100));
				}
			}
			
			
			if (e.getSource().equals(getView().getBtn3())) {
				if (getView().getBtn3().isSelected()) {
					getView().getLblNroButaca().setText("3");
				} else {
					getView().getBtn3().setBackground(new Color(104, 232, 100));
				}
			}
			
			if (e.getSource().equals(getView().getBtn4())) {
				if (getView().getBtn4().isSelected()) {
					getView().getLblNroButaca().setText("4");
				} else {
					getView().getBtn4().setBackground(new Color(104, 232, 100));
				}
			}
			
			if (e.getSource().equals(getView().getBtn5())) {
				if (getView().getBtn5().isSelected()) {
					getView().getLblNroButaca().setText("5");
				} else {
					getView().getBtn5().setBackground(new Color(104, 232, 100));
				}
			}
			
			if (e.getSource().equals(getView().getBtn6())) {
				if (getView().getBtn6().isSelected()) {
					getView().getLblNroButaca().setText("6");
				} else {
					getView().getBtn6().setBackground(new Color(104, 232, 100));
				}
			}
			
			if (e.getSource().equals(getView().getBtn7())) {
				if (getView().getBtn7().isSelected()) {
					getView().getLblNroButaca().setText("7");
				} else {
					getView().getBtn7().setBackground(new Color(104, 232, 100));
				}
			}
			
			if (e.getSource().equals(getView().getBtn8())) {
				if (getView().getBtn8().isSelected()) {
					getView().getLblNroButaca().setText("8");
				} else {
					getView().getBtn8().setBackground(new Color(104, 232, 100));
				}
			}
			
			if (e.getSource().equals(getView().getBtn9())) {
				if (getView().getBtn9().isSelected()) {
					getView().getLblNroButaca().setText("9");
				} else {
					getView().getBtn9().setBackground(new Color(104, 232, 100));
				}
			}
			
			if (e.getSource().equals(getView().getBtn10())) {
				if (getView().getBtn10().isSelected()) {
					getView().getLblNroButaca().setText("10");
				} else {
					getView().getBtn10().setBackground(new Color(104, 232, 100));
				}
			}
	}

	public VistaPasajes getView() {
		return view;
	}

	public void setView(VistaPasajes view) {
		this.view = view;
	}
	
	
	

	@Override
	public void focusGained(FocusEvent e) {	
	}

	@Override
	public void focusLost(FocusEvent e) {
		/*int num;
		if (e.getSource().equals(this.getView().getTextNumeroDoc())) {
			if (this.getView().getTextNumeroDoc().getText().equalsIgnoreCase("")) {
				this.getView().getLblErrorNumero().setVisible(true);
				this.getView().getTextNumeroDoc().setForeground(Color.RED);
			}else { try {
				num = Integer.parseInt(this.getView().getTextNumeroDoc().getText());
				this.getView().getLblErrorNumero().setVisible(false);
				this.getView().getTextNumeroDoc().setForeground(Color.GREEN);
			} catch (NumberFormatException e2) {
					this.getView().getTextNumeroDoc().setForeground(Color.RED);
					this.getView().getLblErrorNumero().setVisible(true);
			}}
	}	
		if (e.getSource().equals(this.getView().getTextNombrePasajero())) {
		if (this.getView().getTextNombrePasajero().getText().equalsIgnoreCase("")) {
			this.getView().getLblErrorNombre().setVisible(true);
			this.getView().getTextNombrePasajero().setForeground(Color.RED);
		}else {
			this.getView().getLblErrorNombre().setVisible(false);
			this.getView().getTextNombrePasajero().setForeground(Color.GREEN);
		} 
		
	}if (e.getSource().equals(this.getView().getTextApellido())) {
			if (this.getView().getTextApellido().getText().isEmpty()) {
				this.getView().getLblErrorApellido().setVisible(true);
				this.getView().getTextApellido().setForeground(Color.RED);
			}else {
				this.getView().getLblErrorApellido().setVisible(false);
				this.getView().getTextApellido().setForeground(Color.GREEN);
			}
			
	}if (e.getSource().equals(this.getView().getTextTelefono())) {
		if (this.getView().getTextTelefono().getText().isEmpty()) {
			this.getView().getLblErrorTelefono().setVisible(true);
			this.getView().getTextTelefono().setForeground(Color.RED);
		}
		else { try {
			num = Integer.parseInt(this.getView().getTextTelefono().getText());
			this.getView().getLblErrorTelefono().setVisible(false);
			this.getView().getTextTelefono().setForeground(Color.GREEN);
		} catch (NumberFormatException e2) {
			this.getView().getLblErrorTelefono().setVisible(true);
			this.getView().getTextTelefono().setForeground(Color.RED);
		}
		
	}
	
}*/
}
	
	public Recorrido seleccionado(ArrayList<Recorrido> a) {
		Iterator<Recorrido> it = this.getListaA().iterator();
		while (it.hasNext()) {
			Recorrido com = it.next();
			if ((com.getCiudad_origen()+"-"+ com.getCiudad_destino()).equalsIgnoreCase((String)getView().getComboBoxOrigenDestino().getSelectedItem())) {
				return com;
			}
		}
		return null;
		
	}
	

	@Override
	public void itemStateChanged(ItemEvent e) {
	
		if (e.getSource().equals(getView().getComboBoxDescuentoE())) {
			try {
			
				Double calculo = 0.0;
				Double precio =getPrecio();
				
				if (getView().getComboBoxDescuentoE().getSelectedIndex()>0) {
					Descuento descuento = getDescuento().getPorcentaje(String.valueOf(getView().getComboBoxDescuentoE().getSelectedItem()));
							
					calculo= precio - (precio*descuento.getPorcentaje_descuento()); 
					getView().getLblPrecioFinal().setText(String.valueOf(df.format(calculo)));
					
				} else {
					getView().getLblPrecioFinal().setText(String.valueOf(df.format(getPrecio())));
				}				
			
			} catch(Exception e1) {
				System.out.println(e1);
				JOptionPane.showMessageDialog(null, "Seleccione un recorrido");
			}
		}
		
		if (e.getSource().equals(getView().getComboBoxFechaDisponibles())) {
			restauraAsientos();
			if (getView().getComboBoxFechaDisponibles().getSelectedIndex()>-1) {
			String[] asignacion = String.valueOf(getView().getComboBoxFechaDisponibles().getSelectedItem()).split("/"); //FECHA - HORA
			Asignacion a= getAsignacion().getAsignacion(asignacion[0], asignacion[1]);
			
			
			//obtengo el id del recorrido con su asignacion
			String[] recorrido = String.valueOf(getView().getComboBoxOrigenDestino().getSelectedItem()).split("-"); //DESTINO - ORIGEN
			Recorrido r = getRecorridos().recorridoAsignacion(recorrido[0], recorrido[1], a.getId_asignacion());
			
			asientosReservados(r.getId_recorrido());
			getView().getPanel_botones().setVisible(true); 
			
			
		}
		}
	
	}
		public PasajeDao getPasaje() {
		return pasaje;
	}

	public void setPasaje(PasajeDao pasaje) {
		this.pasaje = pasaje;
	}

	public RecorridoDao getRecorridos() {
		return recorridos;
	}

	public void setRecorridos(RecorridoDao recorridos) {
		this.recorridos = recorridos;
	}

	public AsignacionDao getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(AsignacionDao asignacion) {
		this.asignacion = asignacion;
	}

	public ArrayList<Recorrido> getListaA() {
		return listaA;
	}

	public void setListaA(ArrayList<Recorrido> listaA) {
		this.listaA = listaA;
	}

	public DescuentoDao getDescuento() {
		return descuento;
	}

	public void setDescuento(DescuentoDao descuento) {
		this.descuento = descuento;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}
