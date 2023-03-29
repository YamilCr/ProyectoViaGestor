package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.apache.commons.collections.functors.ForClosure;

import modelo.Asignacion;
import modelo.AsignacionDao;
import modelo.Ciudad;
import modelo.CiudadDao;
import modelo.Descuento;
import modelo.Empleado;
import modelo.Pasaje;
import modelo.PasajeDao;
import modelo.Precio;
import modelo.PrecioDao;
import modelo.Provincia;
import modelo.ProvinciaDao;
import modelo.Recorrido;
import modelo.RecorridoDao;
import vista.VistaRecorridos;
import vista.VistaRegistrarAsignaciones;
import vista.VistaRegistrarRecorridos;

public class ControladorRecorridos implements ActionListener, KeyListener, ListSelectionListener{

	private VistaRecorridos vistaRecorridos;
	private VistaRegistrarRecorridos vistaRegistrar;
	private DefaultTableModel modeloTabla = new DefaultTableModel();
	private RecorridoDao recorridoDao;
	private AsignacionDao asignacionDao;
	private ProvinciaDao provinciaDao;
	private PrecioDao precioDao;
	private CiudadDao ciudadDao;
	private VistaRegistrarAsignaciones vistaResgistrarAsignaciones;
	private PasajeDao pasajeDao;
	private DecimalFormat df = new DecimalFormat("#.00");
	private Integer id_asignacion;
	private Integer id_recorrido;
	
	public ControladorRecorridos() {
		super();
		this.pasajeDao = new PasajeDao();
		this.recorridoDao = new RecorridoDao();
		this.asignacionDao = new AsignacionDao();
		this.provinciaDao = new ProvinciaDao();
		this.ciudadDao = new CiudadDao();
		this.precioDao = new PrecioDao();
		this.vistaRegistrar= new VistaRegistrarRecorridos(this);
		this.vistaResgistrarAsignaciones = new VistaRegistrarAsignaciones(this);
		this.vistaRecorridos = new VistaRecorridos(this);
		this.vistaRecorridos.setVisible(true);
		this.vistaRecorridos.setLocationRelativeTo(null);
		this.vistaRegistrar.setLocationRelativeTo(null);
		this.vistaResgistrarAsignaciones.setLocationRelativeTo(null);
		
		cargaComboBoxAsignacion();
		cargaComboBoxDestinos();
		modelo();
		mostrarDatos();
		
	}
	
	private void modelo() {
			
		modeloTabla.addColumn("ID recorrido");
		modeloTabla.addColumn("ORIGEN");
		modeloTabla.addColumn("DESTINO");
		modeloTabla.addColumn("Precio");
		modeloTabla.addColumn("Partida");
		modeloTabla.addColumn("Butacas");
		modeloTabla.addColumn("Nro colectivo");
	}
	
	private void mostrarDatos() {
	for (Recorrido recorrido : getRecorridoDao().getAll()) {
		Vector<String> vector = new Vector<String>();
		Asignacion asignacion = getAsignacionDao().get(recorrido.getId_asignacion());
		if (recorrido.getEstado_recorrido()) {
		vector.add(String.valueOf(recorrido.getId_recorrido()));
		vector.add(recorrido.getProvincia_origen() + "-" + recorrido.getCiudad_origen());
		vector.add(recorrido.getProvincia_destino() + "-" + recorrido.getCiudad_destino());
		vector.add(String.valueOf(recorrido.getPrecio_final()));
		vector.add(String.valueOf(asignacion.getFecha_partida()) + " - " + String.valueOf(asignacion.getHora_salida()));
		vector.add(String.valueOf(asignacion.getNro_butacas()));
		vector.add(String.valueOf(asignacion.getNro_colectivo()));
		modeloTabla.addRow(vector);
		
	}
	
	}
	getVistaRecorridos().getTable().setModel(modeloTabla);
	getVistaRecorridos().getTable().getColumnModel().getColumn(0).setMaxWidth(0);
	getVistaRecorridos().getTable().getColumnModel().getColumn(0).setMinWidth(0);
	getVistaRecorridos().getTable().getColumnModel().getColumn(0).setPreferredWidth(0);
	getVistaRecorridos().getTable().setDefaultEditor(Object.class, null);
	getVistaRecorridos().getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	public VistaRecorridos getVistaRecorridos() {
		return vistaRecorridos;
	}
	

	private void setVistaRecorridos(VistaRecorridos vistaRecorridos) {
		this.vistaRecorridos = vistaRecorridos;
	}

	
	private void cargaComboBoxAsignacion() {
		//getVistaRegistrar().getComboBoxAsignacion().addItem(asignacion.toString());
		for (Asignacion asignacion : getAsignacionDao().getAll()) {
			getVistaRegistrar().getComboBoxAsignacion().addItem(asignacion.toString());			
		}
	}
	
	
	private void cargaComboBoxDestinos() {

		for (Ciudad ciudad : getCiudadDao().getAll()) {
			Provincia provincia = getProvinciaDao().get(ciudad.getId_provincia());
			getVistaRegistrar().getComboBoxRecorridosDestino().addItem(ciudad.getNombre_ciudad()+"-"+provincia.getNombre_provincia());
			getVistaRegistrar().getComboBoxRecorridosOrigen().addItem(ciudad.getNombre_ciudad()+"-"+provincia.getNombre_provincia());
		}
	}
	
	private void actualizaComboboxAsignacion(Asignacion a) {
		getVistaRegistrar().getComboBoxAsignacion().addItem(a.toString());
	}
	

	
	private Double calcularPrecio(Precio precio, Double km) {
		Double precio_final;
		return (precio_final= km*precio.getPrecio());
	}
	
	private void guardarProvincias(String nombre_provincia) {
		if (getProvinciaDao().provinciaNueva(nombre_provincia)) {
			getProvinciaDao().insert(new Provincia(null, nombre_provincia));
		}
	}
	
	private void modificarProvincia(Integer id_provincia, String nombre_provincia) {
		if (getProvinciaDao().provinciaNueva(nombre_provincia)) {
			guardarProvincias(nombre_provincia);
		} else {
			Provincia provinciaModificada = new Provincia(id_provincia, nombre_provincia);
			getProvinciaDao().update(provinciaModificada);			
		}		
	}
	
	private void guardarCiudad(String nombre_ciudad, String nombre_provincia, Integer cp) {
		if (getCiudadDao().ciudadNueva(nombre_ciudad)) {
			Integer id_provincia = getProvinciaDao().obtenerIdProvincia(nombre_provincia);
			getCiudadDao().insert(new Ciudad(null, id_provincia, nombre_ciudad, true, cp));
		}
	}
	
	private void modificarCiudad(Integer id_ciudad, Integer id_provincia, String nombre_ciudad, Integer cp) {
		if (getCiudadDao().ciudadNueva(nombre_ciudad)) {
			Provincia provincia =getProvinciaDao().get(id_provincia);
			guardarCiudad(nombre_ciudad, provincia.getNombre_provincia(), cp);
		} else {
			Ciudad ciudadModificada = new Ciudad(id_ciudad, id_provincia, nombre_ciudad,true, cp);
			getCiudadDao().update(ciudadModificada);			
		}		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		//---------BOTONES VISTA RECORRIDOS------------//
		
		//BOTON ACEPTAR
		if (e.getSource().equals(getVistaRecorridos().getBtnAceptar())) {
			getVistaRecorridos().dispose();
		}
		
		//BOTON CANCELAR
		if (e.getSource().equals(getVistaRecorridos().getBtnCancelar())) {
			getVistaRecorridos().dispose();
		}
				
		//BOTON AGREGAR ASIGNACION
		if (e.getSource().equals(getVistaRecorridos().getBtnAgregarAsignacion())) {			
			getVistaResgistrarAsignaciones().getBtnConfirmarModificacionAsignacion().setVisible(false);
			getVistaResgistrarAsignaciones().getBtnConfirmarRegistroAsignacion().setVisible(true);
			getVistaResgistrarAsignaciones().getTitulo().setText("AGREGAR ASIGNACION");	
			getVistaResgistrarAsignaciones().setVisible(true);
		}
		
		
		//BOTON MODIFICAR ASIGNACION
		if (e.getSource().equals(getVistaRecorridos().getBtnModificarAsignacion())) {
			getVistaResgistrarAsignaciones().setVisible(true);
			getVistaResgistrarAsignaciones().getBtnConfirmarModificacionAsignacion().setVisible(true);
			getVistaResgistrarAsignaciones().getBtnConfirmarRegistroAsignacion().setVisible(false);
			getVistaResgistrarAsignaciones().getTitulo().setText("MODIFICAR ASIGNACION");
			
			String id = String.valueOf(getVistaRecorridos().getTable().getValueAt(getVistaRecorridos().getTable().getSelectedRow(), 0));
			
			
			Recorrido recorrido= getRecorridoDao().get(Integer.valueOf(id));
			
			Asignacion asignacionModificar = getAsignacionDao().get(recorrido.getId_asignacion());
			
			this.setId_asignacion(asignacionModificar.getId_asignacion());
			
			getVistaResgistrarAsignaciones().getTextFieldNroButacas().setText(String.valueOf(asignacionModificar.getNro_butacas()));			
			getVistaResgistrarAsignaciones().getTextFieldNroColectivo().setText(String.valueOf(asignacionModificar.getNro_colectivo()));
			getVistaResgistrarAsignaciones().getHora_salida().setText(String.valueOf(asignacionModificar.getHora_salida()));
			getVistaResgistrarAsignaciones().getFecha_salida().setText(String.valueOf(asignacionModificar.getFecha_partida()));
			getVistaResgistrarAsignaciones().getLblNewLabelSeteaPasajes().setText(String.valueOf(asignacionModificar.getNro_butacas()));

									
		}
				
		//BOTON AGREGAR RUTA
		if (e.getSource().equals(getVistaRecorridos().getBtnAgregarRuta())) {
			getVistaRegistrar().getBtnConfirmarRegistro().setVisible(true);
			getVistaRegistrar().getBtnCancelarRegistro().setVisible(true);
			getVistaRegistrar().getBtnConfirmarModificacion().setVisible(false);
			getVistaRegistrar().getTitulo().setText("REGISTRAR RECORRIDO");
			getVistaRegistrar().setVisible(true);
			
		}
		
		//BOTON ELIMINAR RUTA
		if (e.getSource().equals(getVistaRecorridos().getBtnEliminarRuta())) {
		
			String id = String.valueOf(getVistaRecorridos().getTable().getValueAt(getVistaRecorridos().getTable().getSelectedRow(), 0));
			Recorrido bajaRecorrido = getRecorridoDao().get(Integer.valueOf(id));
			
			
			if (JOptionPane.showConfirmDialog(null, "Si elimina el recorrido se cancelaran todos los pasajes vendidos al destino: " +
			bajaRecorrido.getCiudad_origen()+"-"+bajaRecorrido.getCiudad_destino() +", ¿desea continuar?")==JOptionPane.YES_OPTION) {
				 
				 bajaRecorrido.setEstado_recorrido(false);
				 getRecorridoDao().update(bajaRecorrido);
				 
			for (Pasaje pasaje : getPasajeDao().cancelaPasaje(bajaRecorrido.getId_recorrido())) {
				pasaje.setEstadoPasaje(false);
				getPasajeDao().update(pasaje);
			}
			
			getVistaRecorridos().dispose();
			new ControladorRecorridos();		
			}					
		}
		
		//BOTON MODIFICAR RUTA
		if (e.getSource().equals(getVistaRecorridos().getBtnModificarRuta())) {
			getVistaRegistrar().getBtnConfirmarRegistro().setVisible(false);
			getVistaRegistrar().getBtnConfirmarModificacion().setVisible(true);
			getVistaRegistrar().getTitulo().setText("MODIFICAR RECORRIDO");
			getVistaRegistrar().setVisible(true);
			
			String id = String.valueOf(getVistaRecorridos().getTable().getValueAt(getVistaRecorridos().getTable().getSelectedRow(), 0));
			Recorrido recorridoModificar= getRecorridoDao().get(Integer.valueOf(id));
			
			this.setId_recorrido(recorridoModificar.getId_recorrido());
			Integer id_ciudad_origen= getCiudadDao().obtenerIdCiudad(recorridoModificar.getCiudad_origen());
			Integer id_ciudad_destino= getCiudadDao().obtenerIdCiudad(recorridoModificar.getCiudad_destino());
			Ciudad ciudadOrigenModificar = getCiudadDao().get(id_ciudad_origen);
			Ciudad ciudadDestinoModificar = getCiudadDao().get(id_ciudad_destino);
			
			getVistaRegistrar().getTextFieldCiudadDestino().setText(recorridoModificar.getCiudad_destino());
			getVistaRegistrar().getTextFieldCiudadOrigen().setText(recorridoModificar.getCiudad_origen());
			getVistaRegistrar().getTextFieldProvinciaDestino().setText(recorridoModificar.getProvincia_destino());
			getVistaRegistrar().getTextFieldProvinciaOrigen().setText(recorridoModificar.getProvincia_origen());
			getVistaRegistrar().getTextCPDestino().setText(String.valueOf(ciudadDestinoModificar.getCodigo_postal()));
			getVistaRegistrar().getTextCPOrigen().setText(String.valueOf(ciudadOrigenModificar.getCodigo_postal()));
			getVistaRegistrar().getTextFieldDistanciaKM().setText(String.valueOf(recorridoModificar.getKm()));
			getVistaRegistrar().getPrecioCalculado().setText(String.valueOf(recorridoModificar.getPrecio_final()));
			
		}
		
		
		
		//---------BOTONES ABM RECORRIDOS VISTA ------------//
		
		//BOTON CONFIRMAR REGISTRO RECORRIDO
		if (e.getSource().equals(getVistaRegistrar().getBtnConfirmarRegistro())) {
					
			try {
				String provincia_destino = getVistaRegistrar().getTextFieldProvinciaDestino().getText().toUpperCase();
				String provincia_origen = getVistaRegistrar().getTextFieldProvinciaOrigen().getText().toUpperCase();
				String ciudad_origen = getVistaRegistrar().getTextFieldCiudadOrigen().getText().toUpperCase();
				String ciudad_destino = getVistaRegistrar().getTextFieldCiudadDestino().getText().toUpperCase();
				
				
				Double km = Double.parseDouble(getVistaRegistrar().getTextFieldDistanciaKM().getText());
				
				if (km==0.0) {
					throw new Exception();
				}
				
				String[] a= String.valueOf(getVistaRegistrar().getComboBoxAsignacion().getSelectedItem()).split("-");
				Integer id_asignacion = Integer.valueOf(a[0]);			
				
				Double precio_final = Double.valueOf(getVistaRegistrar().getPrecioCalculado().getText());
				
				if (precio_final==0.0) {
					throw new Exception();
				}
				Integer cp_destino = Integer.valueOf(getVistaRegistrar().getTextCPDestino().getText());
				Integer cp_origen = Integer.valueOf(getVistaRegistrar().getTextCPOrigen().getText());
				
				if (cp_destino.equals(null) || cp_origen.equals(null)) {
					throw new Exception();
				}
				
				getRecorridoDao().insert(new Recorrido(null, id_asignacion, ciudad_destino, provincia_destino, ciudad_origen, provincia_origen, precio_final,true,km,0));
				guardarProvincias(provincia_origen);
				guardarProvincias(provincia_destino);
				guardarCiudad(ciudad_origen, provincia_origen, cp_origen);
				guardarCiudad(ciudad_destino, provincia_destino, cp_destino);
				
				
				getVistaRegistrar().dispose();
				getVistaRecorridos().dispose();
				new ControladorRecorridos();
				JOptionPane.showMessageDialog(null, "¡Ruta agregada!");
				
				} catch (Exception e1) {
					System.out.println(e1);
					JOptionPane.showMessageDialog(null, "Datos Erroneos");
				}
					
				getVistaRegistrar().getTextCPDestino().setText(" ");
				getVistaRegistrar().getTextCPOrigen().setText(" ");;
				getVistaRegistrar().getTextFieldCiudadDestino().setText(" ");
				getVistaRegistrar().getTextFieldCiudadOrigen().setText(" ");
				getVistaRegistrar().getTextFieldProvinciaOrigen().setText(" ");
				getVistaRegistrar().getTextFieldProvinciaDestino().setText(" ");
		}
		
		//BOTON CANCELAR REGISTRO RECORRIDO
		if (e.getSource().equals(getVistaRegistrar().getBtnCancelarRegistro())) {
				this.vistaRegistrar.dispose();
					
		}
		
		//BOTON CONFIRMAR MODIFICACION RECORRIDO		
		if (e.getSource().equals(getVistaRegistrar().getBtnConfirmarModificacion())) {
			//String id = String.valueOf(getVistaRecorridos().getTable().getValueAt(getVistaRecorridos().getTable().getSelectedRow(), 0));
			
			try {
			Recorrido recorridoModificar = getRecorridoDao().get(this.getId_recorrido());
			
			Integer id_ciudad_origen= getCiudadDao().obtenerIdCiudad(recorridoModificar.getCiudad_origen());
			Integer id_ciudad_destino= getCiudadDao().obtenerIdCiudad(recorridoModificar.getCiudad_destino());
			
			Integer id_provincia_origen = getProvinciaDao().obtenerIdProvincia(recorridoModificar.getProvincia_origen());
			Integer id_provincia_destino = getProvinciaDao().obtenerIdProvincia(recorridoModificar.getProvincia_destino());
			
			Ciudad ciudadOrigenModificar = getCiudadDao().get(id_ciudad_origen);
			Ciudad ciudadDestinoModificar = getCiudadDao().get(id_ciudad_destino);
			
			
				
				
			recorridoModificar.setProvincia_destino(getVistaRegistrar().getTextFieldProvinciaDestino().getText().toUpperCase()); 
			recorridoModificar.setProvincia_origen(getVistaRegistrar().getTextFieldProvinciaOrigen().getText().toUpperCase());
			
			if (recorridoModificar.getProvincia_destino().equals(null) || recorridoModificar.getProvincia_origen().equals(null)) {
				throw new Exception();
			}
			recorridoModificar.setCiudad_origen(getVistaRegistrar().getTextFieldCiudadOrigen().getText().toUpperCase());
			recorridoModificar.setCiudad_destino(getVistaRegistrar().getTextFieldCiudadDestino().getText().toUpperCase());
			
			if (recorridoModificar.getCiudad_destino().equals(null) || recorridoModificar.getCiudad_origen().equals(null)) {
				throw new Exception();
			}
			recorridoModificar.setKm(Double.valueOf(getVistaRegistrar().getTextFieldDistanciaKM().getText()));
			
			if (recorridoModificar.getKm()==0) {
				throw new Exception();
			}
			
			
			String[] a= String.valueOf(getVistaRegistrar().getComboBoxAsignacion().getSelectedItem()).split("-");
			Integer id_asignacion = Integer.valueOf(a[0]);	
			recorridoModificar.setId_asignacion(id_asignacion);
			
			
			recorridoModificar.setPrecio_final(Double.valueOf(getVistaRegistrar().getPrecioCalculado().getText()));
			
			Integer cp_destino = Integer.valueOf(getVistaRegistrar().getTextCPDestino().getText());
			Integer cp_origen = Integer.valueOf(getVistaRegistrar().getTextCPOrigen().getText());
			
			if (JOptionPane.showConfirmDialog(null, "Se modificará el recorrido, ¿desea continuar?")==JOptionPane.YES_OPTION) {
			getRecorridoDao().update(recorridoModificar);
			
			ciudadOrigenModificar.setNombre_ciudad(getVistaRegistrar().getTextFieldCiudadOrigen().getText().toUpperCase());
			ciudadOrigenModificar.setCodigo_postal(cp_origen);
			
			ciudadDestinoModificar.setNombre_ciudad(getVistaRegistrar().getTextFieldCiudadDestino().getText().toUpperCase());
			ciudadDestinoModificar.setCodigo_postal(cp_destino);
			
			modificarProvincia(id_provincia_destino, recorridoModificar.getProvincia_destino());
			modificarProvincia(id_provincia_destino, recorridoModificar.getProvincia_origen());
			modificarCiudad(id_ciudad_destino, id_provincia_destino, recorridoModificar.getCiudad_destino(), cp_destino);
			modificarCiudad(id_ciudad_origen, id_provincia_origen, recorridoModificar.getCiudad_origen(), cp_origen); 
			
			 JOptionPane.showMessageDialog(null, "¡Recorrido modificado!");
			 getVistaRegistrar().dispose();
			 getVistaRecorridos().dispose();
			 new ControladorRecorridos();
			}
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Datos erroneos");
			}
			
		}
		
		
		//---------BOTONES VISTA ASIGNACIONES------------//
		
		
		//BOTON CANCELAR ASIGNACION
		if (e.getSource().equals(getVistaResgistrarAsignaciones().getBtnCancelarAsignacion()) ) {
					getVistaResgistrarAsignaciones().dispose();
			}
				
		//BOTON CONFIRMAR REGISTRO ASIGNACION
		if (e.getSource().equals(getVistaResgistrarAsignaciones().getBtnConfirmarRegistroAsignacion()) ) {
			try {
			Integer dia, mes, anio;
			String[] fechas= getVistaResgistrarAsignaciones().getFecha_salida().getText().split("-");
			anio=Integer.valueOf(fechas[0]);
			mes=Integer.valueOf(fechas[1]);
			dia=Integer.valueOf(fechas[2]);
			LocalDate fecha= LocalDate.of(anio, mes, dia);
					
			Date fecha_partida= Date.valueOf(fecha);
			String hora_salida= getVistaResgistrarAsignaciones().getHora_salida().getText();
			
			String[] horas = getVistaResgistrarAsignaciones().getHora_salida().getText().split(":");
			
			if (Integer.valueOf(horas[0])>23 || Integer.valueOf(horas[1])>59) {
				throw new Exception("Hora incorrecta");
			}
			
			Integer nro_colectivo= Integer.parseInt(getVistaResgistrarAsignaciones().getTextFieldNroColectivo().getText());
			Integer nro_butacas= Integer.parseInt(getVistaResgistrarAsignaciones().getTextFieldNroButacas().getText());
			Integer disponibilidad_pasajes= Integer.parseInt(getVistaResgistrarAsignaciones().getTextFieldNroButacas().getText());
			Asignacion asignacion = new Asignacion(null, fecha_partida, hora_salida, nro_colectivo, nro_butacas, disponibilidad_pasajes);
			getAsignacionDao().insert(asignacion);
			
			JOptionPane.showMessageDialog(null, "¡Asignación registrada!");
			
			getVistaResgistrarAsignaciones().dispose();
			actualizaComboboxAsignacion(asignacion);
			
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Datos incorrectos");
				System.out.println(e1);
			} 
		}
		
		
		//BOTON MODIFICAR ASIGNACION
		if (e.getSource().equals(getVistaResgistrarAsignaciones().getBtnConfirmarModificacionAsignacion())) {
			
			Asignacion asignacionModificar = getAsignacionDao().get(this.getId_asignacion());
			
			try {
			Integer dia, mes, anio;
			String[] fechas= getVistaResgistrarAsignaciones().getFecha_salida().getText().split("-");
			anio=Integer.valueOf(fechas[0]);
			mes=Integer.valueOf(fechas[1]);
			dia=Integer.valueOf(fechas[2]);
			LocalDate fecha= LocalDate.of(anio, mes, dia);
			asignacionModificar.setFecha_partida(Date.valueOf(fecha));
			asignacionModificar.setHora_salida(getVistaResgistrarAsignaciones().getHora_salida().getText()); 
			asignacionModificar.setNro_colectivo(Integer.parseInt(getVistaResgistrarAsignaciones().getTextFieldNroColectivo().getText())); 
			asignacionModificar.setNro_butacas(Integer.parseInt(getVistaResgistrarAsignaciones().getTextFieldNroButacas().getText()));
			asignacionModificar.setDisponibilidad_pasajes(Integer.parseInt(getVistaResgistrarAsignaciones().getTextFieldNroButacas().getText()));
			
			if (JOptionPane.showConfirmDialog(null, "La modificacion se aplicará a "
					+ "todos lo recorridos de esta asignacion, ¿desea continuar?")==JOptionPane.YES_OPTION) {
				getAsignacionDao().update(asignacionModificar);
				
				getVistaResgistrarAsignaciones().dispose();
				
				JOptionPane.showMessageDialog(null, "¡Datos modificados!");
				
				getVistaResgistrarAsignaciones().dispose();
				getVistaRecorridos().dispose();
				new ControladorRecorridos();
			}
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Datos Erroneos");
		}
		}
		
		if(e.getSource().equals(getVistaRegistrar().getComboBoxRecorridosDestino())) {
			if(getVistaRegistrar().getComboBoxRecorridosDestino().getSelectedIndex()!=0) {
				String[] vector = String.valueOf(getVistaRegistrar().getComboBoxRecorridosDestino().getSelectedItem()).split("-");
				String ciudad = vector[0];
				String provincia = vector[1];
				Integer id_provincia = getProvinciaDao().obtenerIdProvincia(provincia);
				Integer id_ciudad = getCiudadDao().obtenerIdCiudad(ciudad);			
				Ciudad ciudad_seleccionada = getCiudadDao().get(id_ciudad);
				Provincia provincia_seleccionada = getProvinciaDao().get(id_provincia);
				
				getVistaRegistrar().getTextFieldCiudadDestino().setText(ciudad_seleccionada.getNombre_ciudad());
				getVistaRegistrar().getTextFieldProvinciaDestino().setText(provincia_seleccionada.getNombre_provincia());;
				getVistaRegistrar().getTextCPDestino().setText(String.valueOf(ciudad_seleccionada.getCodigo_postal()));
		}
		
	}
		
		if (e.getSource().equals(getVistaRegistrar().getComboBoxRecorridosOrigen())) {
			String[] vector = String.valueOf(getVistaRegistrar().getComboBoxRecorridosOrigen().getSelectedItem()).split("-");
			String ciudad = vector[0];
			System.out.println(ciudad);
			String provincia = vector[1];
			System.out.println(provincia);
			Integer id_provincia = getProvinciaDao().obtenerIdProvincia(provincia);
			Integer id_ciudad = getCiudadDao().obtenerIdCiudad(ciudad);			
			Ciudad ciudad_seleccionada = getCiudadDao().get(id_ciudad);
			Provincia provincia_seleccionada = getProvinciaDao().get(id_provincia);
			
			getVistaRegistrar().getTextFieldCiudadOrigen().setText(ciudad_seleccionada.getNombre_ciudad());
			getVistaRegistrar().getTextFieldProvinciaOrigen().setText(provincia_seleccionada.getNombre_provincia());;
			getVistaRegistrar().getTextCPOrigen().setText(String.valueOf(ciudad_seleccionada.getCodigo_postal()));
		}
	}
	
	
	public void search() {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modeloTabla);
		this.getVistaRecorridos().getTable().setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(this.getVistaRecorridos().getTextBuscador().getText().toUpperCase()));
	}
	
	public double getValor(String texto){
	    if(texto.contains(",")){
	        return Double.parseDouble(texto.replace(",", ".").trim());
	    }
	    return Double.parseDouble(texto.trim());
	}


	@Override
	public void keyTyped(KeyEvent e) {
	//search();
	}

	@Override
	public void keyPressed(KeyEvent e) {
	//search();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if (getVistaRegistrar().getTextFieldDistanciaKM().getText()!= " ") {
		try {
			Double valor = getValor(getVistaRegistrar().getTextFieldDistanciaKM().getText());
			getVistaRegistrar().getPrecioCalculado().setText(String.valueOf(getValor(df.format(calcularPrecio(getPrecioDao().get(1), valor))))); }
			
			catch(Exception e1) {
			}
				
		}
		
		if (getVistaResgistrarAsignaciones().getTextFieldNroButacas().getText()!=" ") {
		try {
			Integer valor = Integer.valueOf(getVistaResgistrarAsignaciones().getTextFieldNroButacas().getText());
			getVistaResgistrarAsignaciones().getLblNewLabelSeteaPasajes().setText(String.valueOf(valor)); }
			
			catch(Exception e1) {
				
				
			}
		}
		
		if (getVistaRecorridos().getTextBuscador().getText()!= " ") {
			search();
		}
		
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	public RecorridoDao getRecorridoDao() {
		return recorridoDao;
	}

	public void setRecorridoDao(RecorridoDao recorridoDao) {
		this.recorridoDao = recorridoDao;
	}

	public AsignacionDao getAsignacionDao() {
		return asignacionDao;
	}

	public void setAsignacionDao(AsignacionDao asignacionDao) {
		this.asignacionDao = asignacionDao;
	}

	public ProvinciaDao getProvinciaDao() {
		return provinciaDao;
	}

	public void setProvinciaDao(ProvinciaDao provinciaDao) {
		this.provinciaDao = provinciaDao;
	}

	public PrecioDao getPrecioDao() {
		return precioDao;
	}

	public void setPrecioDao(PrecioDao precioDao) {
		this.precioDao = precioDao;
	}

	public CiudadDao getCiudadDao() {
		return ciudadDao;
	}

	public void setCiudadDao(CiudadDao ciudadDao) {
		this.ciudadDao = ciudadDao;
	}

	public VistaRegistrarRecorridos getVistaRegistrar() {
		return vistaRegistrar;
	}

	public void setVistaRegistrar(VistaRegistrarRecorridos vistaRegistrar) {
		this.vistaRegistrar = vistaRegistrar;
	}

	public VistaRegistrarAsignaciones getVistaResgistrarAsignaciones() {
		return vistaResgistrarAsignaciones;
	}

	public void setVistaResgistrarAsignaciones(VistaRegistrarAsignaciones vistaResgistrarAsignaciones) {
		this.vistaResgistrarAsignaciones = vistaResgistrarAsignaciones;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		getVistaRecorridos().getBtnEliminarRuta().setEnabled(true);
		getVistaRecorridos().getBtnModificarAsignacion().setEnabled(true);
		getVistaRecorridos().getBtnModificarRuta().setEnabled(true);
	}

	public PasajeDao getPasajeDao() {
		return pasajeDao;
	}

	public void setPasajeDao(PasajeDao pasajeDao) {
		this.pasajeDao = pasajeDao;
	}


	public Integer getId_recorrido() {
		return id_recorrido;
	}

	public void setId_recorrido(Integer id_recorrido) {
		this.id_recorrido = id_recorrido;
	}

	public Integer getId_asignacion() {
		return id_asignacion;
	}

	public void setId_asignacion(Integer id_asignacion) {
		this.id_asignacion = id_asignacion;
	}

	
	
}
