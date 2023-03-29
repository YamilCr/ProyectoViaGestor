package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controlador.ControladorUsuarios;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class VistaUsuarios extends JFrame {

	private JPanel contentPane;
	private ControladorUsuarios controlador;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JButton btnEliminarUsuario;
	private JButton btnRegistrarUsuario;
	private JButton btnModificarUsuario;
	private JTable table;
	private JTextField textBuscador;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VistaUsuarios(ControladorUsuarios controlador) {
		this.setControlador(controlador);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		
		btnModificarUsuario = new JButton("Modificar Usuario\r\n");
		btnModificarUsuario.setEnabled(false);
		btnModificarUsuario.addActionListener(getControlador());
		btnModificarUsuario.setBounds(265, 352, 147, 23);
		contentPane.add(btnModificarUsuario);
		btnModificarUsuario.setForeground(Color.BLACK);
		btnModificarUsuario.setFont(new Font("Arial", Font.BOLD, 13));
		btnModificarUsuario.setBackground(new Color(153, 204, 102));
		btnModificarUsuario.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		btnRegistrarUsuario = new JButton("Registrar usuario\r\n");
		btnRegistrarUsuario.addActionListener(getControlador());
		btnRegistrarUsuario.setBounds(435, 352, 141, 23);
		contentPane.add(btnRegistrarUsuario);
		btnRegistrarUsuario.setForeground(Color.BLACK);
		btnRegistrarUsuario.setFont(new Font("Arial", Font.BOLD, 13));
		btnRegistrarUsuario.setBackground(new Color(153, 204, 102));
		btnRegistrarUsuario.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 117, 614, 224);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 614, 224);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(getControlador());
		
		btnEliminarUsuario = new JButton("Eliminar usuario");
		btnEliminarUsuario.setEnabled(false);
		btnEliminarUsuario.addActionListener(getControlador());
		btnEliminarUsuario.setBounds(90, 352, 141, 23);
		contentPane.add(btnEliminarUsuario);
		btnEliminarUsuario.setForeground(Color.BLACK);
		btnEliminarUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		btnEliminarUsuario.setBackground(new Color(153, 204, 102));
		btnEliminarUsuario.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(getControlador());
		btnCancelar.setBounds(10, 427, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelar.setBackground(new Color(153, 204, 102));
		btnCancelar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		btnAceptar = new JButton("Aceptar\r\n");
		btnAceptar.addActionListener(getControlador());
		btnAceptar.setBounds(535, 427, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Arial", Font.BOLD, 13));
		btnAceptar.setBackground(new Color(153, 204, 102));
		btnAceptar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 70, 614, 46);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.white);
		
		textBuscador = new JTextField();
		textBuscador.setBounds(137, 12, 432, 20);
		textBuscador.addKeyListener(getControlador());
		panel_1.add(textBuscador);
		textBuscador.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("BUSCADOR");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(22, 12, 116, 18);
		panel_1.add(lblNewLabel);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(153, 204, 102));
		panel_2.setBounds(0, 0, 634, 41);
		contentPane.add(panel_2);
		
		JLabel titulo = new JLabel("USUARIOS");
		titulo.setBounds(0, 0, 634, 41);
		panel_2.add(titulo);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
	}

	public ControladorUsuarios getControlador() {
		return controlador;
	}

	public void setControlador(ControladorUsuarios controlador) {
		this.controlador = controlador;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnEliminarUsuario() {
		return btnEliminarUsuario;
	}

	public JButton getBtnRegistrarUsuario() {
		return btnRegistrarUsuario;
	}

	public JButton getBtnModificarUsuario() {
		return btnModificarUsuario;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTextBuscador() {
		return textBuscador;
	}

	public void setTextBuscador(JTextField textBuscador) {
		this.textBuscador = textBuscador;
	}
}
