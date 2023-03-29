package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controlador.ControladorInformes;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class VistaInformes extends JFrame {

	private JPanel contentPane;
	private JButton btnPasajesVendidos;
	private JButton btnDestinosConcurridos;
	private JButton btnCancelar;
	
	private ControladorInformes controlador;
	private JPanel panel;
	private JLabel lblInformes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ControladorInformes();
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaInformes(ControladorInformes controlador) {
		this.setControlador(controlador);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		
		btnPasajesVendidos = new JButton("INFORME DE PASAJES");
		btnPasajesVendidos.setForeground(Color.BLACK);
		btnPasajesVendidos.setBounds(162, 97, 260, 33);
		contentPane.add(btnPasajesVendidos);
		btnPasajesVendidos.addActionListener(getControlador());
		btnPasajesVendidos.setFont(new Font("Arial", Font.BOLD, 14));
		btnPasajesVendidos.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnPasajesVendidos.setBackground(new Color(153, 204, 102));
		
		btnDestinosConcurridos = new JButton("DESTINOS M\u00C1S CONCURRIDOS");
		btnDestinosConcurridos.setForeground(Color.BLACK);
		btnDestinosConcurridos.setBounds(162, 191, 260, 33);
		contentPane.add(btnDestinosConcurridos);
		btnDestinosConcurridos.addActionListener(getControlador());
		btnDestinosConcurridos.setFont(new Font("Arial", Font.BOLD, 14));
		btnDestinosConcurridos.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnDestinosConcurridos.setBackground(new Color(153, 204, 102));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setBounds(10, 427, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(getControlador());
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnCancelar.setBackground(new Color(153, 204, 102));
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(153, 204, 102));
		panel.setBounds(0, 0, 634, 41);
		contentPane.add(panel);
		
		lblInformes = new JLabel("INFORMES");
		lblInformes.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformes.setForeground(Color.WHITE);
		lblInformes.setFont(new Font("Arial", Font.BOLD, 20));
		lblInformes.setBounds(0, 0, 634, 41);
		panel.add(lblInformes);
	}

	public JButton getBtnPasajesVendidos() {
		return btnPasajesVendidos;
	}



	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public ControladorInformes getControlador() {
		return controlador;
	}

	public void setControlador(ControladorInformes controlador) {
		this.controlador = controlador;
	}

	public JButton getBtnDestinosConcurridos() {
		return btnDestinosConcurridos;
	}
}
