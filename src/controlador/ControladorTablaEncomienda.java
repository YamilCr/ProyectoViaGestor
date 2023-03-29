package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import modelo.Descuento;
import modelo.Encomienda;
import modelo.EncomiendaDao;
import modelo.Pasaje;
import modelo.PasajeDao;
import vista.VistaTablaEncomiendas;

import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;

public class ControladorTablaEncomienda implements ActionListener, ListSelectionListener, KeyListener  {

	private VistaTablaEncomiendas vista;
	private DefaultTableModel modeloTabla = new DefaultTableModel();
	private EncomiendaDao encomiendaDao;
	//private ControladorEncomiendas cEncomienda = new ControladorEncomiendas();

	public ControladorTablaEncomienda() {
		super();
		//cEncomienda.getView().setVisible(false);
		//this.cEncomienda = new ControladorEncomiendas();
		this.vista = new VistaTablaEncomiendas(this);
		this.encomiendaDao = new EncomiendaDao();
		this.vista.setVisible(true);
		this.vista.setLocationRelativeTo(null);
		modelo();
		mostrarDatos();
		
		
	}
	

	public VistaTablaEncomiendas getVista() {
		return vista;
	}




	public void setVista(VistaTablaEncomiendas vista) {
		this.vista = vista;
	}




	public EncomiendaDao getEncomiendaDao() {
		return encomiendaDao;
	}


	public void setEncomiendaDao(EncomiendaDao encomiendaDao) {
		this.encomiendaDao = encomiendaDao;
	}
	
	public Encomienda encomiendaModificar() {
		String id = String.valueOf(getVista().getTable().getValueAt(getVista().getTable().getSelectedRow(), 0));
		Encomienda encomienda = getEncomiendaDao().get(Integer.valueOf(id));
		return encomienda;
	}

	
	private void modelo() {
		modeloTabla.addColumn("id_encomienda");
		modeloTabla.addColumn("DNI DESTINATARIO");
		modeloTabla.addColumn("DESTINATARIO");
		modeloTabla.addColumn("REMITENTE");
		modeloTabla.addColumn("ORIGEN");
		modeloTabla.addColumn("DESTINO");
		modeloTabla.addColumn("ESTADO");
		modeloTabla.addColumn("ENVIO");
		modeloTabla.addColumn("DIRECCION");
	}
	
	private void mostrarDatos() {
		ArrayList<Encomienda> array = getEncomiendaDao().getAll();
		for (Encomienda encomienda : array) {
			Vector<String> vector = new Vector<String>();
			Cliente destinatario = encomienda.getDestinatario();
			Cliente remitente = encomienda.getRemitente();
			vector.add(String.valueOf(encomienda.getIdEncomienda()));			
			vector.add(String.valueOf(destinatario.getDni()));
			vector.add(destinatario.getApellido().toUpperCase() +" "+ destinatario.getNombre().toUpperCase());
			vector.add(remitente.getApellido().toUpperCase() + " "+ remitente.getNombre().toUpperCase());
			vector.add(encomienda.getCiudadOrigen());
			vector.add(encomienda.getCiudadDestino());
			if (encomienda.getEstado_encomienda()) {
				vector.add("No entregado");
			} else {
				vector.add("Entregado");
			}
			if (encomienda.getTipoServicio().equals("ENVIO A DOMICILIO")) {
				vector.add(encomienda.getTipoServicio());
				vector.add(encomienda.getNombreCalle() + " "+ encomienda.getNroCalle());
			} else {
				vector.add(encomienda.getTipoServicio());
				vector.add(" ");
			}
				
			modeloTabla.addRow(vector); 
		}
		getVista().getTable().setModel(modeloTabla);
		getVista().getTable().getColumnModel().getColumn(0).setMaxWidth(0);
		getVista().getTable().getColumnModel().getColumn(0).setMinWidth(0);
		getVista().getTable().getColumnModel().getColumn(0).setPreferredWidth(0);
		getVista().getTable().setDefaultEditor(Object.class, null);
		getVista().getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		getVista().getBtnEliminar().setEnabled(true);
		getVista().getBtnEntregado().setEnabled(true);
		getVista().getBtnModificar().setEnabled(true);
		getVista().getBtnDetalles().setEnabled(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVista().getBtnEntregado())) {
			Encomienda encomiendaModificar =encomiendaModificar();
			
			
			if (JOptionPane.showConfirmDialog(null, "Se modificará el registro, ¿desea continuar?")==JOptionPane.YES_OPTION) {
				encomiendaModificar.setEstado_encomienda(false);
				getEncomiendaDao().update(encomiendaModificar);
			JOptionPane.showMessageDialog(null, "¡Paquete entregado!"); 
		
			getVista().dispose();
			new ControladorTablaEncomienda();
			}
		}
	if (e.getSource().equals(getVista().getBtnAceptar())) {
		getVista().dispose();
	}
	
	if (e.getSource().equals(getVista().getBtnEliminar())) {
		
		String id = String.valueOf(getVista().getTable().getValueAt(getVista().getTable().getSelectedRow(), 0));
		Encomienda encomiendaEliminar = getEncomiendaDao().get(Integer.valueOf(id));
		
		if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿desea continuar?")==JOptionPane.YES_OPTION) {
			 
			modeloTabla.removeRow(getVista().getTable().getSelectedRow());
			getEncomiendaDao().remove(encomiendaEliminar);
			
			getVista().dispose();
			new ControladorDescuentos();
		}
		
	}
	
	
	if (e.getSource().equals(getVista().getBtnModificar())) {
		String id = String.valueOf(getVista().getTable().getValueAt(getVista().getTable().getSelectedRow(), 0));
		ControladorEncomiendas cEncomienda = new ControladorEncomiendas();
		
		Encomienda encomiendaModificar= getEncomiendaDao().get(Integer.valueOf(id));
		//cEncomienda.getView().setVisible(true);
		//DESTINATARIO
		cEncomienda.getView().getTextApellidoDestinatario().setText(encomiendaModificar.getDestinatario().getApellido());
		cEncomienda.getView().getTextNombreDestinatario().setText(encomiendaModificar.getDestinatario().getNombre());
		cEncomienda.getView().getTextDniDestinatario().setText(String.valueOf(encomiendaModificar.getDestinatario().getDni()));
		cEncomienda.getView().getTextTelefonoDestinatario().setText(String.valueOf(encomiendaModificar.getDestinatario().getTelefono()));
		
		//REMITENTE
		cEncomienda.getView().getTextApellidoRemitente().setText(encomiendaModificar.getRemitente().getApellido());
		cEncomienda.getView().getTextNombreRemitente().setText(encomiendaModificar.getRemitente().getNombre());
		cEncomienda.getView().getTextDniRemitente().setText(String.valueOf(encomiendaModificar.getRemitente().getDni()));
		cEncomienda.getView().getTextTelefonoRemitente().setText(String.valueOf(encomiendaModificar.getRemitente().getTelefono()));
		
		//Datos
		cEncomienda.getView().getTextPeso().setText(String.valueOf(encomiendaModificar.getPeso()));
		cEncomienda.getView().getCalculoPrecio().setText(String.valueOf(encomiendaModificar.getPrecioFinal()));
		cEncomienda.getView().getTitulo().setText("MODIFICAR ENCOMIENDA");
		cEncomienda.getView().getBtnConfirmar().setVisible(false);
		cEncomienda.getView().getBtnModificar().setVisible(true);
		cEncomienda.getView().getBtnCancelar().setVisible(false);
		cEncomienda.getView().getBtnCancelarTEncomienda().setVisible(true);
		
		
		cEncomienda.getView().getId().setText(id);
		getVista().dispose();
	}
	
	if (e.getSource().equals(getVista().getBtnDetalles())) {
		String id = String.valueOf(getVista().getTable().getValueAt(getVista().getTable().getSelectedRow(), 0));
		Encomienda encomiendaDetalle= getEncomiendaDao().get(Integer.valueOf(id));
		
		
		if (encomiendaDetalle.getTipoServicio().equals("ENVIO A DOMICILIO")) {
			JOptionPane.showMessageDialog(vista,encomiendaDetalle.toString()+ encomiendaDetalle.getTipoServicio()
			+ "\nCalle: " + encomiendaDetalle.getNombreCalle() + " " + encomiendaDetalle.getNroCalle() +
			"\nDepto: " + encomiendaDetalle.getDepto() + " " + encomiendaDetalle.getPiso(),"Detalle", JOptionPane.YES_NO_OPTION);
		} else {
		JOptionPane.showMessageDialog(vista,encomiendaDetalle.toString()+ "\n" +encomiendaDetalle.getTipoServicio(),"Detalle", JOptionPane.YES_NO_OPTION); 
		}
		
	}
	
	}
	
	public void search() {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modeloTabla);
		this.getVista().getTable().setRowSorter(tr);		
		tr.setRowFilter(RowFilter.regexFilter(this.getVista().getTextBuscador().getText().toUpperCase()));
		
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		search();
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		search();
		
	}
	
	}

