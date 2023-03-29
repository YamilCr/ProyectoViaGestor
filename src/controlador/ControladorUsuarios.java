package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import modelo.Descuento;
import modelo.Empleado;
import modelo.EmpleadoDao;
import vista.VistaRegistrarUsuario;
import vista.VistaUsuarios;

public class ControladorUsuarios implements ActionListener, ItemListener, KeyListener, ListSelectionListener {
private VistaUsuarios vista;
private EmpleadoDao empleadoDao;
private DefaultTableModel modeloTabla = new DefaultTableModel();
private VistaRegistrarUsuario vistaABMUsuarios;
private Integer id_usuario;

public ControladorUsuarios() {
	super();
	this.empleadoDao = new EmpleadoDao();
	
	this.vistaABMUsuarios = new VistaRegistrarUsuario(this);
	this.vista = new VistaUsuarios(this);
	this.vista.setVisible(true);
	this.vista.setLocationRelativeTo(null);
	this.vistaABMUsuarios.setLocationRelativeTo(null);
	modelo();
	mostrarDatos();
}

private void modelo() {
	modeloTabla.addColumn("ID");
	modeloTabla.addColumn("DNI");
	modeloTabla.addColumn("Nombre");
	modeloTabla.addColumn("Apellido");
	modeloTabla.addColumn("Telefono");
	modeloTabla.addColumn("Email");
	//modeloTabla.addColumn("Contraseña");
	modeloTabla.addColumn("Cargo");
}


private void mostrarDatos() {
	
for (Empleado empleado : getEmpleadoDao().getAll()) {
	
	if (empleado.getEstado_cuenta()==true) {
	Vector<String> vector = new Vector<String>();
	vector.add(String.valueOf(empleado.getId_empleado()));
	vector.add(String.valueOf(empleado.getNro_dni()));
	vector.add(empleado.getNombre().toUpperCase());
	vector.add(empleado.getApellido().toUpperCase());
	vector.add(String.valueOf(empleado.getTelefono()));
	vector.add(empleado.getEmail());
	//vector.add(empleado.getContrasenia());
	vector.add(empleado.getTipo_usuario()); 
    modeloTabla.addRow(vector);
	}

}
	getVista().getTable().setModel(modeloTabla);
	getVista().getTable().getColumnModel().getColumn(0).setMaxWidth(0);
	getVista().getTable().getColumnModel().getColumn(0).setMinWidth(0);
	getVista().getTable().getColumnModel().getColumn(0).setPreferredWidth(0);
	getVista().getTable().setDefaultEditor(Object.class, null);
	getVista().getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

}

public void search() {
	TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modeloTabla);
	this.getVista().getTable().setRowSorter(tr);
	tr.setRowFilter(RowFilter.regexFilter(this.getVista().getTextBuscador().getText().toUpperCase()));
}

@Override
public void actionPerformed(ActionEvent e) {
	
	
	//-------------BOTONES DE LA VISTA USUARIOS--------------//
	
	//BOTON CANCELAR
	if (e.getSource().equals(getVista().getBtnCancelar())) {
		getVista().dispose();
	}
	
	//BOTON ACEPTAR
	if (e.getSource().equals(getVista().getBtnAceptar())) {
		getVista().dispose();
	}
	
	//BOTON REGISTRAR USUARIO
	if (e.getSource().equals(getVista().getBtnRegistrarUsuario())) {
		getVistaABMUsuarios().getBtnCancelarModificacion().setVisible(false);
		getVistaABMUsuarios().getBtnConfirmarModificacion().setVisible(false);
		getVistaABMUsuarios().getBtnCancelar().setVisible(true);
		getVistaABMUsuarios().getBtnConfirmar().setVisible(true);
		getVistaABMUsuarios().getTitulo().setText("REGISTRAR USUARIO");
		getVistaABMUsuarios().setVisible(true);
	}
	
	//BOTON ELIMINAR USUARIO
	if (e.getSource().equals(getVista().getBtnEliminarUsuario())) {
		String id = String.valueOf(getVista().getTable().getValueAt(getVista().getTable().getSelectedRow(), 0));
		Empleado bajaEmpleado = getEmpleadoDao().get(Integer.valueOf(id));
		
		
		if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿desea continuar?")==JOptionPane.YES_OPTION) {
			 
			 bajaEmpleado.setEstado_cuenta(false);
			 getEmpleadoDao().update(bajaEmpleado);
		
		getVista().dispose();
		new ControladorUsuarios();
		 }
	
	}

	//BOTON MODIFICAR USUARIO
	if (e.getSource().equals(getVista().getBtnModificarUsuario())) {
		getVistaABMUsuarios().getBtnCancelar().setVisible(false);
		getVistaABMUsuarios().getBtnConfirmar().setVisible(false);
		getVistaABMUsuarios().getBtnCancelarModificacion().setVisible(true);
		getVistaABMUsuarios().getBtnConfirmarModificacion().setVisible(true);
		getVistaABMUsuarios().setVisible(true);
		getVistaABMUsuarios().getTitulo().setText("MODIFICAR USUARIO");
		
		String id = String.valueOf(getVista().getTable().getValueAt(getVista().getTable().getSelectedRow(), 0));
		Empleado empleadoModificar = getEmpleadoDao().get(Integer.valueOf(id));
		this.setId_usuario(Integer.valueOf(id));
		
		getVistaABMUsuarios().getTextFieldApellido().setText(empleadoModificar.getApellido());
		getVistaABMUsuarios().getTextFieldNombre().setText(empleadoModificar.getNombre());
		getVistaABMUsuarios().getTextFieldEmail().setText(empleadoModificar.getEmail());
		getVistaABMUsuarios().getTextFieldNroDocumento().setText(String.valueOf(empleadoModificar.getNro_dni()));
		getVistaABMUsuarios().getTextFieldTelefono().setText(String.valueOf(empleadoModificar.getTelefono()));
		getVistaABMUsuarios().getTextFieldContrasenia().setText(empleadoModificar.getContrasenia());
	}
	
	
	//-------------BOTONES DE LA VISTA ABM USUARIOS--------------//
	
	//BOTON CONFIRMAR REGISTRO
	if (e.getSource().equals(getVistaABMUsuarios().getBtnConfirmar())) {
		
		
	try {
		Integer nro_dni = Integer.parseInt(getVistaABMUsuarios().getTextFieldNroDocumento().getText());   
		String nombre= getVistaABMUsuarios().getTextFieldNombre().getText();
		String apellido= getVistaABMUsuarios().getTextFieldApellido().getText();
		Integer telefono = Integer.parseInt(getVistaABMUsuarios().getTextFieldTelefono().getText());
		String email= getVistaABMUsuarios().getTextFieldEmail().getText();
		String contrasenia=getVistaABMUsuarios().getTextFieldContrasenia().getText();
		String tipo_usuario= String.valueOf(getVistaABMUsuarios().getComboBoxTipoUsuario().getSelectedItem());
		Boolean estado_cuenta = true;
				
		getEmpleadoDao().insert(new Empleado(null, nro_dni, nombre, apellido, telefono, email, contrasenia, tipo_usuario, estado_cuenta));
				
		JOptionPane.showMessageDialog(null, "Usuario: "+ nombre +" " + apellido + " registrado");
		getVistaABMUsuarios().getTextFieldApellido().setText(" ");
		getVistaABMUsuarios().getTextFieldContrasenia().setText(" ");
		getVistaABMUsuarios().getTextFieldEmail().setText(" ");
		getVistaABMUsuarios().getTextFieldNombre().setText(" ");
		getVistaABMUsuarios().getTextFieldNroDocumento().setText(" ");
		getVistaABMUsuarios().getTextFieldTelefono().setText(" ");
		
		getVistaABMUsuarios().dispose();
		getVista().dispose();
		new ControladorUsuarios();
				
		}
	catch (Exception e1) {
		JOptionPane.showMessageDialog(null, "Datos incorrectos");
	}
	
	
	
	}
	
	//BOTON CANCELAR REGISTRO
	if (e.getSource().equals(getVistaABMUsuarios().getBtnCancelar())) {		 
		getVistaABMUsuarios().dispose();
		
	}
	if (e.getSource().equals(getVistaABMUsuarios().getBtnCancelarModificacion())) {
		getVistaABMUsuarios().dispose();
		getVistaABMUsuarios().getTextFieldApellido().setText(" ");
		getVistaABMUsuarios().getTextFieldNombre().setText(" ");
		getVistaABMUsuarios().getTextFieldEmail().setText(" ");
		getVistaABMUsuarios().getTextFieldNroDocumento().setText(" ");
		getVistaABMUsuarios().getTextFieldTelefono().setText(" ");
		getVistaABMUsuarios().getTextFieldContrasenia().setText(" "); 
	}
	
	//BOTON CONFIRMAR MODIFICACION
	if (e.getSource().equals(getVistaABMUsuarios().getBtnConfirmarModificacion())) {
		//String id = String.valueOf(getVista().getTable().getValueAt(getVista().getTable().getSelectedRow(), 0));
		Empleado empleadoModificar = getEmpleadoDao().get(Integer.valueOf(getId_usuario()));
		
		if (JOptionPane.showConfirmDialog(null, "Se modificará el registro, ¿desea continuar?")==JOptionPane.YES_OPTION) {
		
			try {
				Integer nro_dni = Integer.parseInt(getVistaABMUsuarios().getTextFieldNroDocumento().getText());   
				String nombre= getVistaABMUsuarios().getTextFieldNombre().getText();
				String apellido= getVistaABMUsuarios().getTextFieldApellido().getText();
				Integer telefono = Integer.parseInt(getVistaABMUsuarios().getTextFieldTelefono().getText());
				String email= getVistaABMUsuarios().getTextFieldEmail().getText();
				String contrasenia=getVistaABMUsuarios().getTextFieldContrasenia().getText();
				String tipo_usuario= String.valueOf(getVistaABMUsuarios().getComboBoxTipoUsuario().getSelectedItem());
				Boolean estado_cuenta = true; 
		
				empleadoModificar.setApellido(apellido);
				empleadoModificar.setContrasenia(contrasenia);
				empleadoModificar.setEmail(email);
				empleadoModificar.setEstado_cuenta(estado_cuenta);
				empleadoModificar.setNombre(nombre);
				empleadoModificar.setNro_dni(nro_dni);
				empleadoModificar.setTelefono(telefono);
				empleadoModificar.setTipo_usuario(tipo_usuario);
		
				getEmpleadoDao().update(empleadoModificar);
				getVistaABMUsuarios().dispose();
				JOptionPane.showMessageDialog(null, "¡Los cambios se han guardado correctamente!");
				getVista().dispose();
				new ControladorUsuarios();
		
			}
			catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Datos Erroneos");
			}
		}
		
	}
}

public EmpleadoDao getEmpleadoDao() {
	return empleadoDao;
}

public void setEmpleadoDao(EmpleadoDao empleadoDao) {
	this.empleadoDao = empleadoDao;
}

public VistaUsuarios getVista() {
	return vista;
}

public void setVista(VistaUsuarios vista) {
	this.vista = vista;
}



public VistaRegistrarUsuario getVistaABMUsuarios() {
	return vistaABMUsuarios;
}



public void setVistaABMUsuarios(VistaRegistrarUsuario vistaABMUsuarios) {
	this.vistaABMUsuarios = vistaABMUsuarios;
}



public DefaultTableModel getModeloTabla() {
	return modeloTabla;
}

public void setModeloTabla(DefaultTableModel modeloTabla) {
	this.modeloTabla = modeloTabla;
}

@Override
public void itemStateChanged(ItemEvent e) {
	if(getVistaABMUsuarios().getMostrarContrasenia().isSelected()){
		getVistaABMUsuarios().getTextMostrarContrasenia().setVisible(true);
		getVistaABMUsuarios().getTextFieldContrasenia().setVisible(false);
		getVistaABMUsuarios().getTextMostrarContrasenia().setText(getVistaABMUsuarios().getTextFieldContrasenia().getText());
	}else if (!(getVistaABMUsuarios().getMostrarContrasenia().isSelected())){
		getVistaABMUsuarios().getTextMostrarContrasenia().setVisible(false);
		getVistaABMUsuarios().getTextFieldContrasenia().setVisible(true);
		getVistaABMUsuarios().getTextFieldContrasenia().setText(getVistaABMUsuarios().getTextMostrarContrasenia().getText());
	}
	
}



@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	search();
}



@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
search();
}



@Override
public void keyReleased(KeyEvent e) {
	try {
		String usuario = getVistaABMUsuarios().getTextFieldNroDocumento().getText();
		getVistaABMUsuarios().getLblUsuarioDni().setText(usuario); }
		
		catch(Exception e1) {
			
			
		}
	search();
	
}

@Override
public void valueChanged(ListSelectionEvent e) {
	getVista().getBtnEliminarUsuario().setEnabled(true);
	getVista().getBtnModificarUsuario().setEnabled(true);
	
}

public Integer getId_usuario() {
	return id_usuario;
}

public void setId_usuario(Integer id_usuario) {
	this.id_usuario = id_usuario;
}




}
