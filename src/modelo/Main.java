package modelo;

import java.awt.EventQueue;

import controlador.ControladorDescuentos;
import controlador.ControladorEncomiendas;
import controlador.ControladorInformes;
import controlador.ControladorPasajes;
import controlador.ControladorPrecios;
import controlador.ControladorPrincipal;
import controlador.ControladorRecorridos;
import controlador.ControladorTablaEncomienda;
import controlador.ControladorTablaPasajes;
import controlador.ControladorUsuarios;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ControladorPrincipal();
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
