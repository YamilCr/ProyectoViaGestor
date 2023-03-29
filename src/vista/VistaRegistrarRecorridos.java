package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controlador.ControladorRecorridos;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class VistaRegistrarRecorridos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldProvinciaOrigen;
	private JTextField textFieldCiudadOrigen;
	private JButton btnConfirmarRegistro;
	private JButton btnCancelarRegistro;
	private JTextField textFieldProvinciaDestino;
	private JLabel lblNewLabel_4;
	private JTextField textFieldCiudadDestino;
	private JLabel lblNewLabel_6;
	private JSeparator separator;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JComboBox comboBoxAsignacion;
	private ControladorRecorridos controlador;
	private JLabel precioCalculado;
	private JTextField textFieldDistanciaKM;
	private JTextField textCPOrigen;
	private JTextField textCPDestino;
	private JLabel titulo;
	private JButton btnConfirmarModificacion;
	private JComboBox comboBoxRecorridosOrigen;
	private JComboBox comboBoxRecorridosDestino;
	private JPanel panel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ControladorRecorridos();
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaRegistrarRecorridos(ControladorRecorridos controlador) {
		this.setControlador(controlador);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("Provincia:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(47, 116, 72, 14);
		contentPane.add(lblNewLabel);
		
		textFieldProvinciaOrigen = new JTextField();
		textFieldProvinciaOrigen.setBounds(132, 113, 157, 20);
		contentPane.add(textFieldProvinciaOrigen);
		textFieldProvinciaOrigen.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ciudad\r\n:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(47, 154, 67, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldCiudadOrigen = new JTextField();
		textFieldCiudadOrigen.setBounds(132, 151, 157, 20);
		contentPane.add(textFieldCiudadOrigen);
		textFieldCiudadOrigen.setColumns(10);
		
		btnConfirmarRegistro = new JButton("Confirmar\r\n");
		btnConfirmarRegistro.setFont(new Font("Arial", Font.BOLD, 13));
		btnConfirmarRegistro.setForeground(Color.BLACK);
		btnConfirmarRegistro.addActionListener(getControlador());
		btnConfirmarRegistro.setBounds(526, 427, 98, 23);
		contentPane.add(btnConfirmarRegistro);
		btnConfirmarRegistro.setVisible(false);
		btnConfirmarRegistro.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnConfirmarRegistro.setBackground(new Color(153, 204, 102));
		
		btnCancelarRegistro = new JButton("Cancelar");
		btnCancelarRegistro.setForeground(Color.BLACK);
		btnCancelarRegistro.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelarRegistro.addActionListener(getControlador());
		btnCancelarRegistro.setBounds(10, 427, 89, 23);
		contentPane.add(btnCancelarRegistro);
		btnCancelarRegistro.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnCancelarRegistro.setBackground(new Color(153, 204, 102));
		
		textFieldProvinciaDestino = new JTextField();
		textFieldProvinciaDestino.setColumns(10);
		textFieldProvinciaDestino.setBounds(428, 113, 157, 20);
		contentPane.add(textFieldProvinciaDestino);
		
		lblNewLabel_4 = new JLabel("Provincia:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(343, 116, 72, 14);
		contentPane.add(lblNewLabel_4);
		
		textFieldCiudadDestino = new JTextField();
		textFieldCiudadDestino.setColumns(10);
		textFieldCiudadDestino.setBounds(428, 151, 157, 20);
		contentPane.add(textFieldCiudadDestino);
		
		lblNewLabel_6 = new JLabel("Ciudad\r\n:");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(343, 154, 67, 14);
		contentPane.add(lblNewLabel_6);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(317, 71, 12, 153);
		contentPane.add(separator);
		
		lblNewLabel_8 = new JLabel("ORIGEN\r\n");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(0, 49, 318, 14);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("DESTINO\r\n");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(307, 49, 317, 14);
		contentPane.add(lblNewLabel_9);
		
		JPanel panel = new JPanel();
		panel.setBounds(174, 322, 255, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Distancia (KM):");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(29, 14, 86, 14);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Precio:");
		lblNewLabel_11.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(29, 50, 46, 14);
		panel.add(lblNewLabel_11);
		
		precioCalculado = new JLabel("0");
		precioCalculado.setHorizontalAlignment(SwingConstants.CENTER);
		precioCalculado.setBounds(125, 50, 86, 14);
		panel.add(precioCalculado);
		
		textFieldDistanciaKM = new JTextField();
		textFieldDistanciaKM.setBounds(125, 11, 86, 20);
		panel.add(textFieldDistanciaKM);
		textFieldDistanciaKM.setColumns(10);
		textFieldDistanciaKM.addKeyListener(getControlador());
		
		JLabel lblNewLabel_13 = new JLabel("CALCULO DEL PRECIO");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(174, 307, 255, 14);
		contentPane.add(lblNewLabel_13);
		
		comboBoxAsignacion = new JComboBox();
		comboBoxAsignacion.setBounds(132, 274, 346, 22);
		contentPane.add(comboBoxAsignacion);
		
		JLabel lblNewLabel_12 = new JLabel("ASIGNACI\u00D3N");
		lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(132, 249, 346, 14);
		contentPane.add(lblNewLabel_12);
		
		textCPOrigen = new JTextField();
		textCPOrigen.setBounds(132, 193, 157, 20);
		contentPane.add(textCPOrigen);
		textCPOrigen.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo postal:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(47, 196, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		textCPDestino = new JTextField();
		textCPDestino.setBounds(428, 193, 157, 20);
		contentPane.add(textCPDestino);
		textCPDestino.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("C\u00F3digo postal:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(343, 196, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		titulo = new JLabel("TITULO");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(0, 0, 634, 38);
		contentPane.add(titulo);
		
		btnConfirmarModificacion = new JButton("Confirmar\r\n");
		btnConfirmarModificacion.setForeground(Color.BLACK);
		btnConfirmarModificacion.setFont(new Font("Arial", Font.BOLD, 13));
		btnConfirmarModificacion.setBounds(526, 427, 98, 23);
		contentPane.add(btnConfirmarModificacion);
		btnConfirmarModificacion.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnConfirmarModificacion.setBackground(new Color(153, 204, 102));
		
		comboBoxRecorridosOrigen = new JComboBox();
		comboBoxRecorridosOrigen.addActionListener(getControlador());
		comboBoxRecorridosOrigen.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar una opci\u00F3n"}));
		comboBoxRecorridosOrigen.setBounds(47, 74, 242, 22);
		contentPane.add(comboBoxRecorridosOrigen);
		
		comboBoxRecorridosDestino = new JComboBox();
		comboBoxRecorridosDestino.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar una opci\u00F3n"}));
		comboBoxRecorridosDestino.setBounds(343, 74, 242, 22);
		comboBoxRecorridosDestino.addActionListener(getControlador());
		
		contentPane.add(comboBoxRecorridosDestino);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(153, 204, 102));
		panel_1.setBounds(0, 0, 634, 41);
		contentPane.add(panel_1);
		btnConfirmarModificacion.setVisible(false);
		btnConfirmarModificacion.addActionListener(getControlador());
	}

	public ControladorRecorridos getControlador() {
		return controlador;
	}

	public void setControlador(ControladorRecorridos controlador) {
		this.controlador = controlador;
	}

	public JTextField getTextFieldProvinciaOrigen() {
		return textFieldProvinciaOrigen;
	}

	public JTextField getTextFieldCiudadOrigen() {
		return textFieldCiudadOrigen;
	}

	public JTextField getTextFieldProvinciaDestino() {
		return textFieldProvinciaDestino;
	}


	public JTextField getTextFieldCiudadDestino() {
		return textFieldCiudadDestino;
	}


	public JTextField getTextFieldDistanciaKM() {
		return textFieldDistanciaKM;
	}

	public JComboBox getComboBoxAsignacion() {
		return comboBoxAsignacion;
	}

	public void setComboBoxAsignacion(JComboBox comboBoxAsignacion) {
		this.comboBoxAsignacion = comboBoxAsignacion;
	}

	public void setTextFieldDistanciaKM(JTextField textFieldDistanciaKM) {
		this.textFieldDistanciaKM = textFieldDistanciaKM;
	}

	public JLabel getPrecioCalculado() {
		return precioCalculado;
	}

	public void setPrecioCalculado(JLabel precioCalculado) {
		this.precioCalculado = precioCalculado;
	}

	public JTextField getTextCPOrigen() {
		return textCPOrigen;
	}

	public JTextField getTextCPDestino() {
		return textCPDestino;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public JButton getBtnCancelarRegistro() {
		return btnCancelarRegistro;
	}

	public void setBtnCancelarRegistro(JButton btnCancelarRegistro) {
		this.btnCancelarRegistro = btnCancelarRegistro;
	}

	public JButton getBtnConfirmarRegistro() {
		return btnConfirmarRegistro;
	}


	public JButton getBtnConfirmarModificacion() {
		return btnConfirmarModificacion;
	}

	public JComboBox getComboBoxRecorridosOrigen() {
		return comboBoxRecorridosOrigen;
	}

	public void setComboBoxRecorridosOrigen(JComboBox comboBoxRecorridosOrigen) {
		this.comboBoxRecorridosOrigen = comboBoxRecorridosOrigen;
	}

	public JComboBox getComboBoxRecorridosDestino() {
		return comboBoxRecorridosDestino;
	}

	public void setComboBoxRecorridosDestino(JComboBox comboBoxRecorridosDestino) {
		this.comboBoxRecorridosDestino = comboBoxRecorridosDestino;
	}
}
