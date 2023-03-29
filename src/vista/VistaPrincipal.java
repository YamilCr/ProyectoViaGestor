package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorPrincipal;

import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class VistaPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelLogin;
	private JTextField textUsuario;
	
	private JPanel panelMenu;
	private JLabel lblImagenUsuario;
	private JButton btnCerrarSesion;
	private JPanel panelBotonesPrincipal;
	private JButton btnVentaPasajes;
	private JButton btnCancelarPasajes;
	private JButton btnEncomienda;
	private JButton btnInformes;
	private JButton btnConfiguracion;
	private JPanel panelBotonesConfiguracion;
	private JButton btnPrecios;
	private JButton btnDescuento;
	private JButton btnUsuarios;
	private JButton btnRecorridos;
	private ControladorPrincipal controlador;
	private JPasswordField passwordFieldContrasenia;
	private JButton btnIngresar;
	private JTextField textMostrarPass;
	private JCheckBox chckbxMostrarContrasenia;
	private DefaultTableModel modeloTabla;
	private JButton btnTablaEncomienda;
	private JButton btnAtras;
	
	public VistaPrincipal(ControladorPrincipal controlador) {
		this.setControlador(controlador);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.highlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//PANEL DEL LOGIN
		
		panelLogin = new JPanel();
		panelLogin.setBackground(new Color(153, 204, 102));
		panelLogin.setBounds(0, 0, 233, 461);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		textUsuario.setBounds(33, 168, 149, 20);
		textUsuario.addKeyListener(getControlador());
		panelLogin.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("USUARIO");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(33, 143, 149, 14);
		panelLogin.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CONTRASE\u00D1A");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(33, 214, 149, 14);
		panelLogin.add(lblNewLabel_3);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(getControlador());
		btnIngresar.setForeground(Color.WHITE);
		btnIngresar.setBorder(null);
		btnIngresar.setBackground(Color.BLACK);
		btnIngresar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnIngresar.setBounds(33, 297, 149, 23);
		panelLogin.add(btnIngresar);
		
		JLabel lblNewLabel_4 = new JLabel("LOGIN");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 27));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 51, 233, 44);
		panelLogin.add(lblNewLabel_4);
		
		passwordFieldContrasenia = new JPasswordField();
		passwordFieldContrasenia.setFont(new Font("Arial", Font.PLAIN, 12));
		passwordFieldContrasenia.addKeyListener(getControlador());
		passwordFieldContrasenia.setBounds(33, 241, 149, 20);
		panelLogin.add(passwordFieldContrasenia);
		
		chckbxMostrarContrasenia = new JCheckBox("");
		chckbxMostrarContrasenia.setBounds(188, 238, 21, 23);
		chckbxMostrarContrasenia.addItemListener(getControlador());
		chckbxMostrarContrasenia.addActionListener(getControlador());
		panelLogin.add(chckbxMostrarContrasenia);
		chckbxMostrarContrasenia.setBackground(new Color(153, 204, 102));
		
		textMostrarPass = new JTextField();
		textMostrarPass.setBounds(33, 241, 149, 20);
		panelLogin.add(textMostrarPass);
		textMostrarPass.setColumns(10);
		

		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/colectivo2.png")));
		lblNewLabel_1.setBounds(245, 38, 389, 398);
		contentPane.add(lblNewLabel_1);
		
		
		//PANEL DEL MENU
		
		panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(new Color(192, 192, 192)));
		panelMenu.setBackground(new Color(153, 204, 102));
		panelMenu.setBounds(0, 0, 233, 461);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		panelMenu.setVisible(false);
		
		//IMAGEN DEL TIPO_USUARIO
		
		JPanel panelImagenUsuario = new JPanel();
		panelImagenUsuario.setBorder(new LineBorder(new Color(192, 192, 192)));
		panelImagenUsuario.setBackground(new Color(255, 255, 255));
		panelImagenUsuario.setBounds(35, 21, 153, 132);
		panelMenu.add(panelImagenUsuario);
		panelImagenUsuario.setLayout(null);
		
		lblImagenUsuario = new JLabel("");
		lblImagenUsuario.setBounds(30, 11, 100, 100);
		panelImagenUsuario.add(lblImagenUsuario);
		lblImagenUsuario.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/imagenes/usuario1.png")));
		
		//BOTONES DEL MENU PRINCIPAL
		
		panelBotonesPrincipal = new JPanel();
		panelBotonesPrincipal.setBackground(new Color(255, 255, 255));
		panelBotonesPrincipal.setBounds(25, 164, 177, 251);
		panelMenu.add(panelBotonesPrincipal);
		panelBotonesPrincipal.setLayout(null);
		panelBotonesPrincipal.setVisible(true);
		
		btnVentaPasajes = new JButton("VENTA PASAJES");
		btnVentaPasajes.addActionListener(getControlador());
		btnVentaPasajes.setBounds(0, 0, 180, 41);
		panelBotonesPrincipal.add(btnVentaPasajes);
		btnVentaPasajes.setBorder(null);
		btnVentaPasajes.setForeground(Color.WHITE);
		btnVentaPasajes.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
		btnVentaPasajes.setBackground(new Color(153, 204, 102));
		btnVentaPasajes.setEnabled(false);
		
		btnCancelarPasajes = new JButton("TABLA PASAJES");
		btnCancelarPasajes.addActionListener(getControlador());
		btnCancelarPasajes.setBounds(0, 42, 180, 41);
		panelBotonesPrincipal.add(btnCancelarPasajes);
		btnCancelarPasajes.setBorder(null);
		btnCancelarPasajes.setForeground(Color.WHITE);
		btnCancelarPasajes.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
		btnCancelarPasajes.setBackground(new Color(153, 204, 102));
		btnCancelarPasajes.setEnabled(false);
		
		btnEncomienda = new JButton("ENCOMIENDA");
		btnEncomienda.addActionListener(getControlador());
		btnEncomienda.setBounds(0, 84, 180, 41);
		panelBotonesPrincipal.add(btnEncomienda);
		btnEncomienda.setBorder(null);
		btnEncomienda.setForeground(Color.WHITE);
		btnEncomienda.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
		btnEncomienda.setBackground(new Color(153, 204, 102));
		btnEncomienda.setEnabled(false);
		
		btnTablaEncomienda = new JButton("TABLA ENCOMIENDA");
		btnTablaEncomienda.setBounds(0, 126, 180, 41);
		panelBotonesPrincipal.add(btnTablaEncomienda);
		btnTablaEncomienda.setForeground(Color.WHITE);
		btnTablaEncomienda.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 19));
		btnTablaEncomienda.setEnabled(false);
		btnTablaEncomienda.setBorder(null);
		btnTablaEncomienda.setBackground(new Color(153, 204, 102));
		btnTablaEncomienda.addActionListener(getControlador());
		
		btnInformes = new JButton("INFORMES");
		btnInformes.setBounds(0, 168, 180, 41);
		panelBotonesPrincipal.add(btnInformes);
		btnInformes.addActionListener(getControlador());
		btnInformes.setBorder(null);
		btnInformes.setForeground(Color.WHITE);
		btnInformes.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
		btnInformes.setBackground(new Color(153, 204, 102));
		btnInformes.setEnabled(false);
		
		btnConfiguracion = new JButton("CONFIGURACION");
		btnConfiguracion.setBounds(0, 210, 180, 41);
		panelBotonesPrincipal.add(btnConfiguracion);
		btnConfiguracion.addActionListener(getControlador());
		btnConfiguracion.setBorder(null);
		btnConfiguracion.setForeground(Color.WHITE);
		btnConfiguracion.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
		btnConfiguracion.setBackground(new Color(153, 204, 102));
		btnConfiguracion.setEnabled(false);
		
		btnCerrarSesion = new JButton("Cerrar sesion");
		btnCerrarSesion.addActionListener(getControlador());
		btnCerrarSesion.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setBackground(Color.BLACK);
		btnCerrarSesion.setBorder(null);
		btnCerrarSesion.setBounds(0, 438, 233, 23);
		panelMenu.add(btnCerrarSesion);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(232, 0, 28, 461);
		contentPane.add(separator);
		
		
		//BOTONES DEL MENU CONFIGURACION
		
		panelBotonesConfiguracion = new JPanel();
		panelBotonesConfiguracion.setBounds(232, 0, 402, 66);
		contentPane.add(panelBotonesConfiguracion);
		panelBotonesConfiguracion.setBackground(Color.WHITE);
		panelBotonesConfiguracion.setVisible(false);
		
		btnPrecios = new JButton("PRECIOS");
		btnPrecios.addActionListener(getControlador());
		btnPrecios.setForeground(Color.WHITE);
		btnPrecios.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
		btnPrecios.setBorder(null);
		btnPrecios.setBackground(new Color(153, 204, 102));
		
		btnDescuento = new JButton("DESCUENTOS");
		btnDescuento.addActionListener(getControlador());
		btnDescuento.setForeground(Color.WHITE);
		btnDescuento.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
		btnDescuento.setBorder(null);
		btnDescuento.setBackground(new Color(153, 204, 102));
		
		btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.addActionListener(getControlador());
		btnUsuarios.setForeground(Color.WHITE);
		btnUsuarios.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
		btnUsuarios.setBorder(null);
		btnUsuarios.setBackground(new Color(153, 204, 102));
		
		btnRecorridos = new JButton("RECORRIDOS");
		btnRecorridos.addActionListener(getControlador());
		btnRecorridos.setForeground(Color.WHITE);
		btnRecorridos.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
		btnRecorridos.setBorder(null);
		btnRecorridos.setBackground(new Color(153, 204, 102));
		
		btnAtras = new JButton("MEN\u00DA PRINCIPAL");
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 20));
		btnAtras.setBorder(null);
		btnAtras.setBackground(new Color(153, 204, 102));
		panelBotonesConfiguracion.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelBotonesConfiguracion.add(btnPrecios);
		panelBotonesConfiguracion.add(btnDescuento);
		panelBotonesConfiguracion.add(btnUsuarios);
		panelBotonesConfiguracion.add(btnRecorridos);
		panelBotonesConfiguracion.add(btnAtras);
		btnAtras.addActionListener(getControlador());
		
		String header[]= {"id_empleado", "nro_dni", "nombre_empleado", "apellido_empleado", "telefono", "email", "contrasenia", "tipo_usuario", "estado_cuenta"};
		modeloTabla = new DefaultTableModel(null, header);
	}

	public JPanel getPanelLogin() {
		return panelLogin;
	}

	public void setPanelLogin(JPanel panelLogin) {
		this.panelLogin = panelLogin;
	}

	public JPanel getPanelMenu() {
		return panelMenu;
	}

	public void setPanelMenu(JPanel panelMenu) {
		this.panelMenu = panelMenu;
	}

	public JLabel getLblImagenUsuario() {
		return lblImagenUsuario;
	}

	public void setLblImagenUsuario(JLabel lblImagenUsuario) {
		this.lblImagenUsuario = lblImagenUsuario;
	}

	public JPanel getPanelBotonesPrincipal() {
		return panelBotonesPrincipal;
	}

	public void setPanelBotonesPrincipal(JPanel panelBotonesPrincipal) {
		this.panelBotonesPrincipal = panelBotonesPrincipal;
	}

	public JButton getBtnVentaPasajes() {
		return btnVentaPasajes;
	}

	public void setBtnVentaPasajes(JButton btnVentaPasajes) {
		this.btnVentaPasajes = btnVentaPasajes;
	}

	public JButton getBtnCancelarPasajes() {
		return btnCancelarPasajes;
	}

	public void setBtnCancelarPasajes(JButton btnCancelarPasajes) {
		this.btnCancelarPasajes = btnCancelarPasajes;
	}

	public JButton getBtnEncomienda() {
		return btnEncomienda;
	}

	public void setBtnEncomienda(JButton btnEncomienda) {
		this.btnEncomienda = btnEncomienda;
	}

	public JButton getBtnInformes() {
		return btnInformes;
	}

	public void setBtnInformes(JButton btnInformes) {
		this.btnInformes = btnInformes;
	}

	public JButton getBtnConfiguracion() {
		return btnConfiguracion;
	}

	public void setBtnConfiguracion(JButton btnConfiguracion) {
		this.btnConfiguracion = btnConfiguracion;
	}

	public JPanel getPanelBotonesConfiguracion() {
		return panelBotonesConfiguracion;
	}

	public void setPanelBotonesConfiguracion(JPanel panelBotonesConfiguracion) {
		this.panelBotonesConfiguracion = panelBotonesConfiguracion;
	}

	public JButton getBtnPrecios() {
		return btnPrecios;
	}

	public void setBtnPrecios(JButton btnPrecios) {
		this.btnPrecios = btnPrecios;
	}

	public JButton getBtnDescuento() {
		return btnDescuento;
	}

	public void setBtnDescuento(JButton btnDescuento) {
		this.btnDescuento = btnDescuento;
	}

	public JButton getBtnUsuarios() {
		return btnUsuarios;
	}

	public void setBtnUsuarios(JButton btnUsuarios) {
		this.btnUsuarios = btnUsuarios;
	}

	public JButton getBtnRecorridos() {
		return btnRecorridos;
	}

	public void setBtnRecorridos(JButton btnRecorridos) {
		this.btnRecorridos = btnRecorridos;
	}

	public JTextField getTextUsuario() {
		return textUsuario;
	}


	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	public ControladorPrincipal getControlador() {
		return controlador;
	}

	public void setControlador(ControladorPrincipal controlador) {
		this.controlador = controlador;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public JPasswordField getPasswordFieldContrasenia() {
		return passwordFieldContrasenia;
	}

	public JTextField getTextMostrarPass() {
		return textMostrarPass;
	}

	public void setTextMostrarPass(JTextField textMostrarPass) {
		this.textMostrarPass = textMostrarPass;
	}

	public void setTextUsuario(JTextField textUsuario) {
		this.textUsuario = textUsuario;
	}

	public void setBtnCerrarSesion(JButton btnCerrarSesion) {
		this.btnCerrarSesion = btnCerrarSesion;
	}

	public void setPasswordFieldContrasenia(JPasswordField passwordFieldContrasenia) {
		this.passwordFieldContrasenia = passwordFieldContrasenia;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	public JCheckBox getChckbxMostrarContrasenia() {
		return chckbxMostrarContrasenia;
	}

	public void setChckbxMostrarContrasenia(JCheckBox chckbxMostrarContrasenia) {
		this.chckbxMostrarContrasenia = chckbxMostrarContrasenia;
	}

	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}

	public JButton getBtnTablaEncomienda() {
		return btnTablaEncomienda;
	}

	public void setBtnTablaEncomienda(JButton btnTablaEncomienda) {
		this.btnTablaEncomienda = btnTablaEncomienda;
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}

	public void setBtnAtras(JButton btnAtras) {
		this.btnAtras = btnAtras;
	}
}
