package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryFlag;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import modelo.Descuento;
import modelo.DescuentoDao;
import vista.VistaDescuentos;

public class ControladorDescuentos implements ActionListener,ListSelectionListener, KeyListener{
	private VistaDescuentos vista;
	private DescuentoDao descuentoDao;
	private DefaultTableModel modeloTabla = new DefaultTableModel();

	public ControladorDescuentos() {
		super();
		this.descuentoDao = new DescuentoDao();
		
		this.vista = new VistaDescuentos(this);
		this.vista.setVisible(true);
		this.vista.setLocationRelativeTo(null);
		
		modelo();
		mostrarDatos();
	}
	
	private void modelo() {
		modeloTabla.addColumn("ID_Descuento");
		modeloTabla.addColumn("Nombre Descuento");
		modeloTabla.addColumn("Porcentaje descuento");
	}
	
	private void mostrarDatos() {

		for (Descuento descuento : getDescuentoDao().getAll()) {
			Vector<String> vector = new Vector<String>();
			vector.add(String.valueOf(descuento.getId_descuento()));
			vector.add(descuento.getNombre_descuento().toUpperCase());
			vector.add(String.valueOf(descuento.getPorcentaje_descuento()));
			modeloTabla.addRow(vector);
			
		} 
	getVista().getTable().setModel(modeloTabla);
	getVista().getTable().getColumnModel().getColumn(0).setMaxWidth(0);
	getVista().getTable().getColumnModel().getColumn(0).setMinWidth(0);
	getVista().getTable().getColumnModel().getColumn(0).setPreferredWidth(0);
	getVista().getTable().setDefaultEditor(Object.class, null);
	getVista().getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	}
	

	public VistaDescuentos getVista() {
		return vista;
	}

	public void setVista(VistaDescuentos vista) {
		this.vista = vista;
	}
	

	public DescuentoDao getDescuentoDao() {
		return descuentoDao;
	}

	public void setDescuentoDao(DescuentoDao descuentoDao) {
		this.descuentoDao = descuentoDao;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//BOTON CANCELAR
		if (e.getSource().equals(getVista().getBtnCancelar())) {
			getVista().dispose();
		}
		
		//BOTON ACEPTAR
		if (e.getSource().equals(getVista().getBtnAceptar())) {
			getVista().dispose();
		}
		
		//BOTON AGREGAR
		if (e.getSource().equals(getVista().getBtnAgregar())) {   
			
			try {
			String nombre_descuento = getVista().getTextFieldNombreDescuento().getText();
			Double porcentaje = Double.parseDouble(getVista().getTextFieldPorcentaje().getText()); 
			getDescuentoDao().insert(new Descuento(null,nombre_descuento, porcentaje));
			
			getVista().dispose();
			new ControladorDescuentos();
			JOptionPane.showMessageDialog(null, "¡Descuento agregado!");
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "Datos incorrectos");
			}
			
		}
		
		//BOTON ACTUALIZAR
		if (e.getSource().equals(getVista().getBtnActualizar())) {
			
		
			getVista().getSubtitulo().setText("MODIFICAR DESCUENTO");
			String id = String.valueOf(getVista().getTable().getValueAt(getVista().getTable().getSelectedRow(), 0));
			Descuento descuentoModificar = getDescuentoDao().get(Integer.valueOf(id));
			
			getVista().getTextFieldNombreDescuento().setText(descuentoModificar.getNombre_descuento());
			getVista().getTextFieldPorcentaje().setText(String.valueOf(descuentoModificar.getPorcentaje_descuento()));
			
			getVista().getPanelAgregar().setVisible(false);
			getVista().getPanelBotonesModificar().setVisible(true);
			getVista().getBtnAceptar().setEnabled(false);
			getVista().getBtnCancelar().setEnabled(false);
			getVista().getBtnEliminar().setEnabled(false);
			getVista().getBtnActualizar().setEnabled(false);

		}
			
				
		//BOTON ELIMINAR
		if (e.getSource().equals(getVista().getBtnEliminar())) {
			
			String id = String.valueOf(getVista().getTable().getValueAt(getVista().getTable().getSelectedRow(), 0));
			
			
			Descuento descuentoEliminado = getDescuentoDao().get(Integer.valueOf(id));
			
			
			 if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿desea continuar?")==JOptionPane.YES_OPTION) {
				 
			getDescuentoDao().remove(descuentoEliminado);
			
			getVista().dispose();
			new ControladorDescuentos();
			 }
		}
		
		
		//BOTON MODIFICAR
		if (e.getSource().equals(getVista().getBtnModificarDescuento())) {
			
			String id = String.valueOf(getVista().getTable().getValueAt(getVista().getTable().getSelectedRow(), 0));
			Descuento descuentoModificar = getDescuentoDao().get(Integer.valueOf(id));
		
			if (JOptionPane.showConfirmDialog(null, "Se modificará el registro, ¿desea continuar?")==JOptionPane.YES_OPTION) {

				try { 
					String nombre_descuento = getVista().getTextFieldNombreDescuento().getText();
					Double porcentaje = Double.valueOf(getVista().getTextFieldPorcentaje().getText()); 
					descuentoModificar.setNombre_descuento(nombre_descuento);
					descuentoModificar.setPorcentaje_descuento(porcentaje);
					getDescuentoDao().update(descuentoModificar);
					getVista().dispose();
					new ControladorDescuentos();
					JOptionPane.showMessageDialog(null, "Descuento modificado");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Datos Erroneos");
				}
				 
			
			
			
		}
		
		}
		
		//BOTON CANCELAR MODIFICACION
		if (e.getSource().equals(getVista().getBtnCancelarModificacion())) {
			
			getVista().getSubtitulo().setText("AGREGAR DESCUENTO");
			getVista().getPanelAgregar().setVisible(true);
			getVista().getPanelBotonesModificar().setVisible(false);
			getVista().getBtnAceptar().setEnabled(true);
			getVista().getBtnCancelar().setEnabled(true);
			getVista().getBtnEliminar().setEnabled(true);
			getVista().getBtnActualizar().setEnabled(true); 
			
			getVista().getTextFieldNombreDescuento().setText(" ");
			getVista().getTextFieldPorcentaje().setText(" ");
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
	
		getVista().getBtnEliminar().setEnabled(true);
		getVista().getBtnActualizar().setEnabled(true);
		
	}
	public void search() {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modeloTabla);
		this.getVista().getTable().setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(this.getVista().getTextbuscador().getText().toUpperCase()));
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
