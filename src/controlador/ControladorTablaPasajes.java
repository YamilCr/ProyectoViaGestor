package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.SecureRandom;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import modelo.Asignacion;
import modelo.AsignacionDao;
import modelo.Pasaje;
import modelo.PasajeDao;
import modelo.Recorrido;
import modelo.RecorridoDao;
import vista.VistaTablaPasajes;

public class ControladorTablaPasajes implements ActionListener, KeyListener, ListSelectionListener{
	
	private VistaTablaPasajes view;
	private PasajeDao pasajes = new PasajeDao();
	private RecorridoDao recorrido = new RecorridoDao();
	private AsignacionDao asignacion = new AsignacionDao();
	

	public ControladorTablaPasajes() {
		this.setView(new VistaTablaPasajes(this));
		this.getView().setVisible(true);
		this.getView().setLocationRelativeTo(null);
		
		
		 for (Pasaje pas : getPasajes().getAll()) {
			 //if (pas.getEstadoPasaje()) {
				Recorrido re = getRecorrido().get(pas.getIdRecorrido());
				Asignacion as = getAsignacion().get(re.getId_asignacion());
				
				String estado = "CANCELADO";
				if (pas.getEstadoPasaje()) {
					estado= "ACEPTADO";
				}
				
				 Object [] row = {pas.getIdPasaje() ,pas.getPasajero().getNombre().toUpperCase()+" "+pas.getPasajero().getApellido().toUpperCase(), 
						 pas.getNroButaca(), 
						 pas.getPasajero().getDni(), 
						 re.getCiudad_origen()+"-"+re.getCiudad_destino(),
						 as.getFecha_partida()+" "+as.getHora_salida(),
						 estado};
				 
					this.getView().getModeloTabla().addRow(row);
			//}
			}
		 
	}
	
	/*public modelo() {
		getView().getModeloTabla().addColumn("");
	}*/
	
	
	public void search() {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(this.getView().getModeloTabla());
		this.getView().getTable().setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(this.getView().getTextBuscador().getText().toUpperCase()));
	}


	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		search();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		search();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(this.getView().getBtnCancelarPasaje())) {
			try {
				int id = Integer.parseInt(String.valueOf(getView().getModeloTabla().getValueAt(getView().getTable().getSelectedRow(), 0)));
			
				//System.out.println(this.getView().getModeloTabla().getValueAt(this.getView().getTable().getSelectedRow(),1));
				Pasaje pas = getPasajes().get(id);		
					if (pas.getEstadoPasaje()) {
						if (JOptionPane.showConfirmDialog(null, "Se cancelará el pasaje, ¿desea continuar?")==JOptionPane.YES_OPTION) {
					
							//Resta la cantidad de pasajes vendidos
							Recorrido recorrido= getRecorrido().get(pas.getIdRecorrido());
							Integer i = recorrido.getCant_pasajes_vendidos();
							recorrido.setCant_pasajes_vendidos(i--);
							getRecorrido().update(recorrido);
					
							pas.setEstadoPasaje(false);//se cambia el estado del pasaje en falso
							getPasajes().update(pas);
							getView().dispose();
							new ControladorTablaPasajes();
							JOptionPane.showMessageDialog(null, "¡Pasaje cancelado!");
						}
			}
					} catch (Exception e2) {
				JOptionPane.showMessageDialog(view,"ERROR, NO SELECCIONÓ NINGÚN ELEMENTO","ERROR", JOptionPane.ERROR_MESSAGE);	
			}
		}
		
		if (e.getSource().equals(getView().getBtnDetallesP())) {
			int id = Integer.parseInt(String.valueOf(getView().getModeloTabla().getValueAt(getView().getTable().getSelectedRow(), 0)));
			Pasaje pas = getPasajes().get(id);
			Recorrido re= getRecorrido().get(pas.getIdRecorrido());
			Asignacion as = getAsignacion().get(re.getId_asignacion());
			JOptionPane.showMessageDialog(view,pas.toString()+" "+"\nCiudad Origen: "+re.getCiudad_origen() +"\nCiudad Destino: "+re.getCiudad_destino()
			+"\nFecha de salida: "+as.getFecha_partida()+ "\nHora: "+ as.getHora_salida()+"\nNº de Colectivo: "+ as.getNro_colectivo(),"Detalle", JOptionPane.YES_NO_OPTION);
		}
	
		if (e.getSource().equals(this.getView().getBtnModificar())) {
			String id = String.valueOf(getView().getTable().getValueAt(getView().getTable().getSelectedRow(), 0));
			ControladorPasajes cPasaje = new ControladorPasajes();
			
			Pasaje pasMod= getPasajes().get(Integer.valueOf(id));
			//CLIENTE
			cPasaje.getView().getTextApellido().setText(pasMod.getPasajero().getApellido());
			cPasaje.getView().getTextNombrePasajero().setText(pasMod.getPasajero().getNombre());
			cPasaje.getView().getTextNumeroDoc().setText(pasMod.getPasajero().getDni()+"");
			cPasaje.getView().getTextTelefono().setText(pasMod.getPasajero().getTelefono()+"");
			cPasaje.getView().getComboBoxDni().setSelectedItem(pasMod.getPasajero().getTipoDocumento());
			cPasaje.getView().getLblIDBoleto().setText(pasMod.getIdPasaje()+"");
			cPasaje.getView().setTitle("MODIFICAR PASAJE");
			cPasaje.getView().getBtnCancelar().setVisible(false);
			cPasaje.getView().getBtnConfirmar().setVisible(false);
			cPasaje.getView().getBtnConfirmar().setEnabled(false);
			cPasaje.getView().getBtnModificar().setVisible(true);
			cPasaje.getView().getBtnModificar().setEnabled(true);
			
			
			//Datos
			getView().dispose();
		}
	
	if (e.getSource().equals(this.getView().getBtnAceptar())) {
		getView().dispose();
	}
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		getView().getBtnCancelarPasaje().setEnabled(true);
		getView().getBtnDetallesP().setEnabled(true);
		getView().getBtnModificar().setEnabled(true);
	}


	public VistaTablaPasajes getView() {
		return view;
	}

	public void setView(VistaTablaPasajes view) {
		this.view = view;
	}

	public PasajeDao getPasajes() {
		return pasajes;
	}

	public void setPasajes(PasajeDao pasajes) {
		this.pasajes = pasajes;
	}

	public AsignacionDao getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(AsignacionDao asignacion) {
		this.asignacion = asignacion;
	}

	public RecorridoDao getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(RecorridoDao recorrido) {
		this.recorrido = recorrido;
	}


	
}
