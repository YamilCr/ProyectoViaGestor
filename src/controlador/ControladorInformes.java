package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import modelo.BasedeDatos;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.VistaInformes;

public class ControladorInformes implements ActionListener{

	private VistaInformes vista;
	
	

	public ControladorInformes() {
		super();
		this.vista = new VistaInformes(this);
		this.vista.setVisible(true);
		this.vista.setLocationRelativeTo(null);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVista().getBtnPasajesVendidos())) {
			try {
			Connection con =BasedeDatos.getInstance().getConexion();
			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile("src/reportes/report_pasajes.jasper");
			JasperPrint jp =JasperFillManager.fillReport(report,null,con);
			JasperViewer.viewReport(jp,false); 
			}
			catch(JRException e1) {
				e1.printStackTrace();
			}
		}
		
		if (e.getSource().equals(getVista().getBtnDestinosConcurridos())) {
			try {
			Connection con =BasedeDatos.getInstance().getConexion();
			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile("src/reportes/report2_destinos.jasper");
			JasperPrint jp =JasperFillManager.fillReport(report,null,con);
			JasperViewer.viewReport(jp,false); 
			}
			catch(JRException e1) {
				e1.printStackTrace();
			}
		}
		
		if (e.getSource().equals(getVista().getBtnCancelar())) {
			getVista().dispose();
		}
		
	}



	public VistaInformes getVista() {
		return vista;
	}



	public void setVista(VistaInformes vista) {
		this.vista = vista;
	}
	
	
}
