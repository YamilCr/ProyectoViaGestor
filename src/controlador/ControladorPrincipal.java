 package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import modelo.Empleado;
import modelo.EmpleadoDao;
import vista.VistaPrincipal;

public class ControladorPrincipal implements ActionListener, ItemListener, KeyListener {
	
	private VistaPrincipal vista;
	private EmpleadoDao empleadosDao;
    private ArrayList<Empleado> lista = new ArrayList<Empleado>();
    private Integer indice = -1;
	public ControladorPrincipal() {
		super();
		this.empleadosDao= new EmpleadoDao();
		this.vista = new VistaPrincipal(this);
		this.vista.setVisible(true);
		this.vista.setLocationRelativeTo(null);
		  for (Empleado user : getEmpleadosDao().getAll()) {
			  getLista().add(user);
			  Object [] row = {user.getId_empleado(), user.getNro_dni(), user.getNombre(), user.getApellido(), user.getTelefono(), user.getEmail(), user.getContrasenia(), user.getTipo_usuario(), user.getEstado_cuenta()};
			  
				this.getVista().getModeloTabla().addRow(row);
				
		  getVista().getTextUsuario().setBorder(new LineBorder(Color.GREEN)); 
		  } 
		  
	}
		 
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Boolean coincidencia=false;
		Empleado usuarioIngresa=null;
		
		
		
		//LOGIN
		if (e.getSource().equals(getVista().getBtnIngresar())) {
			 
			Integer usuario=null;
			String contrasenia="";
			try {
				usuario = Integer.parseInt(getVista().getTextUsuario().getText());
				contrasenia=getVista().getPasswordFieldContrasenia().getText();	
			}catch (Exception a) {
				JOptionPane.showMessageDialog(null, "datos Erroneos");
				
			}
			
			
			 for (Empleado empleado : getLista()) {
					if (empleado.getNro_dni().equals(usuario) && empleado.getContrasenia().equals(contrasenia)) {//
						coincidencia=true;
						usuarioIngresa=empleado;
						getVista().getTextUsuario().setBorder(new LineBorder(Color.GREEN));
					}
				}

			 if (!(coincidencia)) {
						JOptionPane.showMessageDialog(null, "El usuario o la contraseña es incorrecto");
						getVista().getTextUsuario().setBorder(new LineBorder(Color.RED));
			}
			 
			 if (coincidencia) {
				 getVista().getPanelLogin().setVisible(false);
				 getVista().getPanelMenu().setVisible(true);
				 
				 if (usuarioIngresa.getTipo_usuario().equals("ADMINISTRADOR")) {
					 getVista().getBtnConfiguracion().setEnabled(true);
					 getVista().getBtnVentaPasajes().setEnabled(true);
					 getVista().getBtnCancelarPasajes().setEnabled(true);
					 getVista().getBtnEncomienda().setEnabled(true);
					 getVista().getBtnInformes().setEnabled(true);
					 getVista().getBtnTablaEncomienda().setEnabled(true);
				 }
				 
				 if (usuarioIngresa.getTipo_usuario().equals("ENCOMIENDA")) {
					 getVista().getBtnEncomienda().setEnabled(true);
					 getVista().getBtnTablaEncomienda().setEnabled(true);
				 }
				 
				 if (usuarioIngresa.getTipo_usuario().equals("VENDEDOR")) {
					 getVista().getBtnVentaPasajes().setEnabled(true);
					 getVista().getBtnCancelarPasajes().setEnabled(true);
				 }
				 
				 if (usuarioIngresa.getTipo_usuario().equals("SUPERVISOR")) {
					 getVista().getBtnVentaPasajes().setEnabled(true);
					 getVista().getBtnCancelarPasajes().setEnabled(true);
					 getVista().getBtnEncomienda().setEnabled(true);
					 getVista().getBtnInformes().setEnabled(true);
					 getVista().getBtnTablaEncomienda().setEnabled(true);
				 }
			 }
		}
		
		
		//CANCELAR PASAJES
		if (e.getSource().equals(getVista().getBtnCancelarPasajes())) {
			new ControladorTablaPasajes();
		}
		
		if (e.getSource().equals(getVista().getBtnTablaEncomienda())) {
			new ControladorTablaEncomienda();
		}
		
		//VENTA PASAJES
		if (e.getSource().equals(getVista().getBtnVentaPasajes())) {
			new ControladorPasajes();
		}
		
		//ENCOMIENDA
		if (e.getSource().equals(getVista().getBtnEncomienda())) {
			new ControladorEncomiendas();
		}
		
		//CONFIGURACION
		if (e.getSource().equals(getVista().getBtnConfiguracion())) {
			getVista().getPanelBotonesPrincipal().setVisible(false);
			getVista().getPanelBotonesConfiguracion().setVisible(true);	
		}
		
		//RECORRIDOS
		if (e.getSource().equals(getVista().getBtnRecorridos())) {
			new ControladorRecorridos();
		}
		
		//PRECIOS
		if (e.getSource().equals(getVista().getBtnPrecios())) {
			new ControladorPrecios();
		}
		
		//DESCUENTOS
		if (e.getSource().equals(getVista().getBtnDescuento())) {
			new ControladorDescuentos();
		}
		
		//USUARIOS
		if (e.getSource().equals(getVista().getBtnUsuarios())) {
			new ControladorUsuarios();
		}
		
		//INFORMES
		if (e.getSource().equals(getVista().getBtnInformes())) {
			new ControladorInformes();
			
		}
		
		
		//CERRAR SESION
		if (e.getSource().equals(getVista().getBtnCerrarSesion())) {
			getVista().dispose();
			new ControladorPrincipal();
			 
		}
		
		if (e.getSource().equals(getVista().getBtnAtras())) {
			getVista().getPanelBotonesConfiguracion().setVisible(false);
			getVista().getPanelBotonesPrincipal().setVisible(true);
		}
		
		
	}

	public VistaPrincipal getVista() {
		return vista;
	}

	public void setVista(VistaPrincipal vista) {
		this.vista = vista;
	}

	public EmpleadoDao getEmpleadosDao() {
		return empleadosDao;
	}

	public void setEmpleadosDao(EmpleadoDao empleadosDao) {
		this.empleadosDao = empleadosDao;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(getVista().getChckbxMostrarContrasenia().isSelected()){
			getVista().getTextMostrarPass().setVisible(true);
			getVista().getPasswordFieldContrasenia().setVisible(false);
			getVista().getTextMostrarPass().setText(getVista().getPasswordFieldContrasenia().getText());
		}else if (!(getVista().getChckbxMostrarContrasenia().isSelected())){
			getVista().getTextMostrarPass().setVisible(false);
			getVista().getPasswordFieldContrasenia().setVisible(true);
			getVista().getPasswordFieldContrasenia().setText(getVista().getTextMostrarPass().getText());
		}
		
	}
	
	
	public Boolean search() {
		TableRowSorter<DefaultTableModel> user = new TableRowSorter<DefaultTableModel>(this.getVista().getModeloTabla());
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(this.getVista().getModeloTabla());
	    //this.getVista().getModeloTabla(tr);
		tr.setRowFilter(RowFilter.regexFilter(this.getVista().getPasswordFieldContrasenia().getText()));
		user.setRowFilter(RowFilter.regexFilter(this.getVista().getTextUsuario().getText()));
		System.out.println(user.getViewRowCount());
		return user.getViewRowCount()>=1 && tr.getViewRowCount()>=1;
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getSource().equals(this.getVista().getPasswordFieldContrasenia())) {
			
			if (this.search()){
				this.getVista().getPasswordFieldContrasenia().setBorder(new LineBorder(Color.GREEN));	
				}else {this.getVista().getPasswordFieldContrasenia().setBorder(new LineBorder(Color.RED));}
			}
      if (e.getSource().equals(this.getVista().getTextUsuario())) {
			
			if (this.search()){
				this.getVista().getTextUsuario().setBorder(new LineBorder(Color.GREEN));	
				}else {this.getVista().getTextUsuario().setBorder(new LineBorder(Color.RED));}
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
if (e.getSource().equals(this.getVista().getPasswordFieldContrasenia())) {
			
			if (this.search()){
				this.getVista().getPasswordFieldContrasenia().setBorder(new LineBorder(Color.GREEN));
				}else {this.getVista().getPasswordFieldContrasenia().setBorder(new LineBorder(Color.RED));
				}
			}
      if (e.getSource().equals(this.getVista().getTextUsuario())) {
			
			if (this.search()){
				this.getVista().getTextUsuario().setBorder(new LineBorder(Color.GREEN));	
				}else {this.getVista().getTextUsuario().setBorder(new LineBorder(Color.RED));}
			}
	
	}



	public ArrayList<Empleado> getLista() {
		return lista;
	}



	public void setLista(ArrayList<Empleado> lista) {
		this.lista = lista;
	}

	
}


