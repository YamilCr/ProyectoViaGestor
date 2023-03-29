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

import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import modelo.Cargo;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;


public class VistaRegistrarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNroDocumento;
	private JTextField textFieldTelefono;
	private JTextField textFieldEmail;
	private JLabel lblUsuarioDni;
	private JComboBox<Cargo> comboBoxTipoUsuario;
	private JButton btnCancelar;
	private JButton btnConfirmar;
	private ControladorUsuarios controlador;
	private JLabel titulo;
	private JPasswordField textFieldContrasenia;
	private JTextField textMostrarContrasenia;
	private JCheckBox mostrarContrasenia;
	private JButton btnCancelarModificacion;
	private JButton btnConfirmarModificacion;
	private JPanel panelBotonesVista;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ControladorUsuarios();
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaRegistrarUsuario (ControladorUsuarios controlador) {
		this.setControlador(controlador);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		
		JLabel lblNombre = new JLabel("Nombre:\r\n*");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(37, 115, 88, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:*");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellido.setBounds(37, 158, 88, 14);
		contentPane.add(lblApellido);
		
		JLabel lblDocumento = new JLabel("Nro de documento:*\r\n");
		lblDocumento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblDocumento.setBounds(37, 199, 131, 14);
		contentPane.add(lblDocumento);
		
		JLabel lblNewLabel = new JLabel("Telefono:*");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(37, 246, 88, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(37, 292, 78, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUsuario = new JLabel("USUARIO:\r\n");
		lblUsuario.setBounds(372, 170, 64, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("CONTRASE\u00D1A:*");
		lblContrasenia.setBounds(372, 199, 103, 14);
		contentPane.add(lblContrasenia);
		
		lblUsuarioDni = new JLabel("");
		lblUsuarioDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarioDni.setFont(new Font("Arial", Font.BOLD, 12));
		lblUsuarioDni.setBounds(445, 170, 88, 14);
		contentPane.add(lblUsuarioDni);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(178, 108, 130, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(178, 151, 130, 20);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldNroDocumento = new JTextField();
		textFieldNroDocumento.addKeyListener(getControlador());
		textFieldNroDocumento.setBounds(178, 193, 130, 20);
		contentPane.add(textFieldNroDocumento);
		textFieldNroDocumento.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(178, 243, 130, 20);
		//textFieldTelefono.addFocusListener(getControlador());
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(178, 289, 130, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(336, 80, 64, 275);
		contentPane.add(separator);
		
		comboBoxTipoUsuario = new JComboBox();
		comboBoxTipoUsuario.setModel(new DefaultComboBoxModel(Cargo.values()));
		comboBoxTipoUsuario.setBounds(410, 271, 130, 22);
		contentPane.add(comboBoxTipoUsuario);
		
		JLabel lblNewLabel_3 = new JLabel("TIPO DE USUARIO*");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(429, 246, 115, 14);
		contentPane.add(lblNewLabel_3);
		
		textFieldContrasenia = new JPasswordField();
		textFieldContrasenia.setBounds(471, 196, 88, 20);
		contentPane.add(textFieldContrasenia);
		
		mostrarContrasenia = new JCheckBox("");
		mostrarContrasenia.setBounds(571, 193, 29, 23);
		mostrarContrasenia.addItemListener(getControlador());
		contentPane.add(mostrarContrasenia);
		
		
		textMostrarContrasenia = new JTextField();
		textMostrarContrasenia.setBounds(445, 196, 88, 20);
		contentPane.add(textMostrarContrasenia);
		textMostrarContrasenia.setColumns(10);
		textMostrarContrasenia.setVisible(false);
		
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(521, 427, 103, 23);
		contentPane.add(btnConfirmar);
		btnConfirmar.setVisible(false);
		btnConfirmar.addActionListener(getControlador());
		btnConfirmar.setForeground(Color.BLACK);
		btnConfirmar.setFont(new Font("Arial", Font.BOLD, 13));
		btnConfirmar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnConfirmar.setBackground(new Color(153, 204, 102));
		
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 427, 103, 23);
		contentPane.add(btnCancelar);
		btnCancelar.setVisible(false);
		btnCancelar.addActionListener(getControlador());
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnCancelar.setBackground(new Color(153, 204, 102));
		
		btnCancelarModificacion = new JButton("Cancelar");
		btnCancelarModificacion.setBounds(10, 427, 105, 23);
		contentPane.add(btnCancelarModificacion);
		btnCancelarModificacion.setVisible(false);
		btnCancelarModificacion.addActionListener(getControlador());
		btnCancelarModificacion.setForeground(Color.BLACK);
		btnCancelarModificacion.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelarModificacion.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnCancelarModificacion.setBackground(new Color(153, 204, 102));
		
		btnConfirmarModificacion = new JButton("Confirmar");
		btnConfirmarModificacion.setBounds(521, 427, 103, 23);
		contentPane.add(btnConfirmarModificacion);
		btnConfirmarModificacion.setVisible(false);
		btnConfirmarModificacion.addActionListener(getControlador());
		btnConfirmarModificacion.setForeground(Color.BLACK);
		btnConfirmarModificacion.setFont(new Font("Arial", Font.BOLD, 13));
		btnConfirmarModificacion.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnConfirmarModificacion.setBackground(new Color(153, 204, 102));		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 634, 41);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(153, 204, 102));
		
		titulo = new JLabel("REGISTRAR EMPLEADO\r\n");
		titulo.setForeground(UIManager.getColor("Button.highlight"));
		titulo.setBounds(0, 0, 634, 41);
		panel.add(titulo);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
	}

	public JLabel getLblUsuarioDni() {
		return lblUsuarioDni;
	}

	public void setLblUsuarioDni(JLabel lblUsuarioDni) {
		this.lblUsuarioDni = lblUsuarioDni;
	}

	public ControladorUsuarios getControlador() {
		return controlador;
	}

	public void setControlador(ControladorUsuarios controlador) {
		this.controlador = controlador;
	}

	public JTextField getTextFieldApellido() {
		return textFieldApellido;
	}


	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}

	public JPasswordField getTextFieldContrasenia() {
		return textFieldContrasenia;
	}


	public JComboBox<Cargo> getComboBoxTipoUsuario() {
		return comboBoxTipoUsuario;
	}


	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public JTextField getTextFieldNroDocumento() {
		return textFieldNroDocumento;
	}

	public JTextField getTextFieldTelefono() {
		return textFieldTelefono;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public JTextField getTextMostrarContrasenia() {
		return textMostrarContrasenia;
	}

	public JCheckBox getMostrarContrasenia() {
		return mostrarContrasenia;
	}

	public void setComboBoxTipoUsuario(JComboBox<Cargo> comboBoxTipoUsuario) {
		this.comboBoxTipoUsuario = comboBoxTipoUsuario;
	}

	public JButton getBtnCancelarModificacion() {
		return btnCancelarModificacion;
	}

	public JButton getBtnConfirmarModificacion() {
		return btnConfirmarModificacion;
	}
}
