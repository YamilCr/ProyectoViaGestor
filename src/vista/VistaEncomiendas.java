package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorEncomiendas;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class VistaEncomiendas extends JFrame {

	private JPanel contentPane;
	private JLabel lblImageCaja;
	private JTextField textPeso;
	private JTextField textNombreRemitente;
	private JTextField textApellidoRemitente;
	private JTextField textDniRemitente;
	private JTextField textCalle;
	private JTextField textNumero;
	private JTextField textDepto;
	private JTextField textPiso;
	private JTextField textNombreDestinatario;
	private JTextField textApellidoDestinatario;
	private JTextField textDniDestinatario;
	private JButton btnConfirmar;
	private ControladorEncomiendas c;
	private JLabel lblErrorDimenciones;
	private JCheckBox chckbxEnvioADomicilio;
	private JPanel panelDomicilio;
	private JTextField textTelefonoRemitente;
	private JTextField textTelefonoDestinatario;
	private JComboBox comboBoxDni;
	private JComboBox comboBoxOrigen;
	private JComboBox comboBoxDestino;
	private JComboBox comboBoxProvD;
	private JComboBox comboBoxProvO;
	private JComboBox comboBoxDescuentoE;
	private JComboBox comboBoxDni_1;
	private JLabel calculoPrecio;
	private JLabel lbltipoServicio;
	private JLabel titulo;
	private JButton btnModificar;
	private JButton btnCancelar;
	private JLabel id;
	private JButton btnCancelarTEncomienda;
	public VistaEncomiendas(ControladorEncomiendas c) {
		this.setC(c);
		setBackground(Color.WHITE);
		setTitle("Encomiendas");
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 358, 617);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		lblImageCaja = new JLabel("0");
		lblImageCaja.setBackground(Color.BLACK);
		//ImageIcon caja= new ImageIcon(new ImageIcon("img/caja.jpg").getImage().getScaledInstance( 142, 101, Image.SCALE_DEFAULT));
		lblImageCaja.setIcon(new ImageIcon("C:\\Users\\mari1\\Documents\\proyecto_viagestor\\Viagestor\\src\\imagenes\\Caja (2).png"));
		lblImageCaja.setBounds(79, 38, 154, 182);
		panel.add(lblImageCaja);
		
		textPeso = new JTextField();
		textPeso.setBackground(Color.WHITE);
		textPeso.addFocusListener(this.getC());
		textPeso.setBounds(79, 244, 154, 20);
		panel.add(textPeso);
		textPeso.setColumns(10);
		textPeso.addKeyListener(getC());
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(33, 275, 282, 8);
		panel.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("REMITENTE");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(110, 294, 136, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nombre*");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(33, 322, 71, 14);
		panel.add(lblNewLabel);
		
		textNombreRemitente = new JTextField();
		textNombreRemitente.setBounds(139, 319, 170, 20);
		textNombreRemitente.addFocusListener(this.getC());
		panel.add(textNombreRemitente);
		textNombreRemitente.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido*");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellido.setBounds(33, 365, 71, 14);
		panel.add(lblApellido);
		
		textApellidoRemitente = new JTextField();
		textApellidoRemitente.setColumns(10);
		textApellidoRemitente.addFocusListener(getC());
		textApellidoRemitente.setBounds(139, 362, 170, 20);
		panel.add(textApellidoRemitente);
		
		JLabel lblNewLabel_2_1 = new JLabel("nro ");
		lblNewLabel_2_1.setBounds(114, 395, 94, 14);
		panel.add(lblNewLabel_2_1);
		
		textDniRemitente = new JTextField();
		textDniRemitente.setColumns(10);
		textDniRemitente.addFocusListener(getC());
		textDniRemitente.setBounds(139, 393, 170, 20);
		panel.add(textDniRemitente);
		
		JLabel lblPesoEnKg = new JLabel("Peso en kg.");
		lblPesoEnKg.setForeground(SystemColor.textInactiveText);
		lblPesoEnKg.setBounds(124, 231, 71, 14);
		panel.add(lblPesoEnKg);
		
		lblErrorDimenciones = new JLabel("**Ingresar numeros enteros");
		lblErrorDimenciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorDimenciones.setVisible(false);
		lblErrorDimenciones.setForeground(Color.RED);
		lblErrorDimenciones.setBounds(124, 38, 207, 14);
		panel.add(lblErrorDimenciones);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 204, 102));
		panel_2.setBounds(0, 0, 358, 31);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		titulo = new JLabel("ENCOMIENDA");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(0, 5, 358, 26);
		panel_2.add(titulo);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Telefono*");
		lblNewLabel_2_1_2.setBounds(33, 439, 71, 14);
		panel.add(lblNewLabel_2_1_2);
		
		textTelefonoRemitente = new JTextField();
		textTelefonoRemitente.setColumns(10);
		textTelefonoRemitente.setBounds(139, 436, 170, 20);
		textTelefonoRemitente.addFocusListener(getC());	
		panel.add(textTelefonoRemitente);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(10, 478, 125, 23);
		panel.add(btnCancelar);
		btnCancelar.addActionListener(this.getC());
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(255, 0, 0));
		
		
		comboBoxDni = new JComboBox();
		comboBoxDni.setModel(new DefaultComboBoxModel(new String[] {"DNI", "LC"}));
		comboBoxDni.setBackground(Color.WHITE);
		comboBoxDni.setBounds(33, 390, 71, 22);
		panel.add(comboBoxDni);
		
		id = new JLabel("");
		id.setBounds(10, 38, 46, 14);
		id.setVisible(false);
		panel.add(id);
		
		btnCancelarTEncomienda = new JButton("CANCELAR");
		btnCancelarTEncomienda.setForeground(Color.WHITE);
		btnCancelarTEncomienda.setBackground(Color.RED);
		btnCancelarTEncomienda.setBounds(10, 478, 125, 23);
		panel.add(btnCancelarTEncomienda);
		btnCancelarTEncomienda.addActionListener(getC());
		btnCancelarTEncomienda.setVisible(false);
		
		comboBoxProvD = new JComboBox();
		comboBoxProvD.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opci\u00F3n"}));
		comboBoxProvD.setBounds(443, 76, 125, 22);
		contentPane.add(comboBoxProvD);
		comboBoxProvD.addActionListener(getC());
		
		comboBoxProvO = new JComboBox();
		comboBoxProvO.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opci\u00F3n"}));
		comboBoxProvO.setBounds(443, 43, 125, 22);
		contentPane.add(comboBoxProvO);
		comboBoxProvO.addActionListener(getC());
		
		JLabel lblProvincia = new JLabel("Provincia*");
		lblProvincia.setBounds(379, 47, 90, 14);
		contentPane.add(lblProvincia);
		
		JLabel lblProvincia_1 = new JLabel("Provincia*");
		lblProvincia_1.setBounds(379, 80, 71, 14);
		contentPane.add(lblProvincia_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(153, 204, 102));
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(357, 109, 425, 22);
		contentPane.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(new Color(153, 204, 102));
		separator_1_1.setBackground(Color.WHITE);
		separator_1_1.setBounds(357, 226, 425, 8);
		contentPane.add(separator_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("DESTINATARIO");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(357, 285, 425, 22);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre*");
		lblNewLabel_2.setBounds(421, 321, 71, 14);
		contentPane.add(lblNewLabel_2);
		
		textNombreDestinatario = new JTextField();
		textNombreDestinatario.setColumns(10);
		textNombreDestinatario.addFocusListener(getC());
		textNombreDestinatario.setBounds(539, 318, 195, 20);
		contentPane.add(textNombreDestinatario);
		
		JLabel lblApellido_1 = new JLabel("Apellido*");
		lblApellido_1.setBounds(421, 357, 71, 14);
		contentPane.add(lblApellido_1);
		
		textApellidoDestinatario = new JTextField();
		textApellidoDestinatario.setColumns(10);
		textApellidoDestinatario.addFocusListener(getC());
		textApellidoDestinatario.setBounds(539, 354, 195, 20);
		contentPane.add(textApellidoDestinatario);
		
		textDniDestinatario = new JTextField();
		textDniDestinatario.setColumns(10);
		textDniDestinatario.addFocusListener(getC());
		textDniDestinatario.setBounds(539, 385, 195, 20);
		contentPane.add(textDniDestinatario);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("nro:");
		lblNewLabel_2_1_1.setBounds(509, 388, 71, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		panelDomicilio = new JPanel();
		panelDomicilio.setVisible(false);
		panelDomicilio.setBackground(new Color(153, 204, 102));
		panelDomicilio.setBounds(368, 142, 406, 84);
		contentPane.add(panelDomicilio);
		panelDomicilio.setLayout(null);
		
		JLabel lblCalle = new JLabel("Calle*:");
		lblCalle.setBounds(10, 14, 71, 14);
		panelDomicilio.add(lblCalle);
		
		textCalle = new JTextField();
		textCalle.setBounds(64, 11, 129, 20);
		textCalle.addFocusListener(getC());
		panelDomicilio.add(textCalle);
		textCalle.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero*:");
		lblNumero.setBounds(236, 11, 71, 14);
		panelDomicilio.add(lblNumero);
		
		textNumero = new JTextField();
		textNumero.setBounds(306, 11, 90, 20);
		textNumero.addFocusListener(getC());
		panelDomicilio.add(textNumero);
		textNumero.setColumns(10);
		
		JLabel lblDepto = new JLabel("Depto :");
		lblDepto.setBounds(10, 52, 71, 14);
		panelDomicilio.add(lblDepto);
		
		textDepto = new JTextField();
		textDepto.setBounds(64, 49, 129, 20);
		textDepto.addFocusListener(getC());
		panelDomicilio.add(textDepto);
		textDepto.setColumns(10);
		
		JLabel lblPiso = new JLabel("Piso :");
		lblPiso.setBounds(240, 49, 71, 14);
		panelDomicilio.add(lblPiso);
		
		textPiso = new JTextField();
		textPiso.setBounds(306, 49, 90, 20);
		textPiso.addFocusListener(getC());
		panelDomicilio.add(textPiso);
		textPiso.setColumns(10);
		
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setBounds(379, 242, 95, 14);
		contentPane.add(lblDescuento);
		
		comboBoxDescuentoE = new JComboBox();
		comboBoxDescuentoE.setModel(new DefaultComboBoxModel(new String[] {"Sin descuento"}));
		comboBoxDescuentoE.setBounds(451, 238, 104, 22);
		comboBoxDescuentoE.addActionListener(getC());
		contentPane.add(comboBoxDescuentoE);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(new Color(153, 204, 102));
		separator_1_1_1.setBackground(Color.WHITE);
		separator_1_1_1.setBounds(357, 271, 425, 14);
		contentPane.add(separator_1_1_1);
		
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setForeground(SystemColor.text);
		btnConfirmar.addActionListener(this.getC());
		btnConfirmar.addFocusListener(getC());
		btnConfirmar.setBackground(new Color(0, 255, 0));
		btnConfirmar.setBounds(649, 477, 125, 23);
		contentPane.add(btnConfirmar);
		
		chckbxEnvioADomicilio = new JCheckBox("Envio a domicilio");
		chckbxEnvioADomicilio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxEnvioADomicilio.setBackground(new Color(153, 204, 102));
		chckbxEnvioADomicilio.addItemListener(getC());
		chckbxEnvioADomicilio.setBounds(410, 120, 145, 23);
		contentPane.add(chckbxEnvioADomicilio);
		
		textTelefonoDestinatario = new JTextField();
		textTelefonoDestinatario.setColumns(10);
		textTelefonoDestinatario.setBounds(539, 432, 195, 20);
		textTelefonoDestinatario.addFocusListener(getC());
		contentPane.add(textTelefonoDestinatario);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Telefono*");
		lblNewLabel_2_1_1_1.setBounds(421, 435, 71, 14);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblDestino = new JLabel("Destino*");
		lblDestino.setBounds(578, 80, 71, 14);
		contentPane.add(lblDestino);
		
		JLabel lblOrigen = new JLabel("Origen*");
		lblOrigen.setBounds(578, 47, 78, 14);
		contentPane.add(lblOrigen);
		
		comboBoxOrigen = new JComboBox();
		comboBoxOrigen.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una provincia"}));
		comboBoxOrigen.setBounds(639, 43, 125, 22);
		contentPane.add(comboBoxOrigen);
		comboBoxOrigen.addActionListener(getC());
		
		comboBoxDestino = new JComboBox();
		comboBoxDestino.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una provincia"}));
		comboBoxDestino.setBounds(639, 76, 125, 22);
		contentPane.add(comboBoxDestino);
		comboBoxDestino.addActionListener(getC());
		
		comboBoxDni_1 = new JComboBox();
		comboBoxDni_1.setModel(new DefaultComboBoxModel(new String[] {"DNI", "LC"}));
		comboBoxDni_1.setBackground(Color.WHITE);
		comboBoxDni_1.setBounds(421, 384, 71, 22);
		contentPane.add(comboBoxDni_1);
		
		JLabel lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setBounds(578, 245, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		calculoPrecio = new JLabel("0.0");
		calculoPrecio.setFont(new Font("Arial", Font.BOLD, 15));
		calculoPrecio.setBounds(663, 245, 101, 14);
		contentPane.add(calculoPrecio);
		
		JLabel lblNewLabel_4 = new JLabel("Servicio:");
		lblNewLabel_4.setBounds(578, 125, 71, 14);
		contentPane.add(lblNewLabel_4);
		
		lbltipoServicio = new JLabel("ENVIO A SUCURSAL");
		lbltipoServicio.setForeground(Color.WHITE);
		lbltipoServicio.setFont(new Font("Arial", Font.BOLD, 12));
		lbltipoServicio.setHorizontalAlignment(SwingConstants.CENTER);
		lbltipoServicio.setBounds(639, 125, 125, 14);
		contentPane.add(lbltipoServicio);
		
		btnModificar = new JButton("CONFIRMAR");
		btnModificar.setEnabled(true);
		btnModificar.setVisible(false);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(Color.GREEN);
		btnModificar.setBounds(649, 477, 125, 23);
		btnModificar.addActionListener(getC());
		contentPane.add(btnModificar);
		
		
		setLocationRelativeTo(null);
	}

	public JLabel getLblImageCaja() {
		return lblImageCaja;
	}

	public void setLblImageCaja(JLabel lblImageCaja) {
		this.lblImageCaja = lblImageCaja;
	}


	public JTextField getTextPeso() {
		return textPeso;
	}

	public void setTextPeso(JTextField textPeso) {
		this.textPeso = textPeso;
	}


	public JTextField getTextNombreRemitente() {
		return textNombreRemitente;
	}

	public void setTextNombreRemitente(JTextField textNombreRemitente) {
		this.textNombreRemitente = textNombreRemitente;
	}

	public JTextField getTextApellidoRemitente() {
		return textApellidoRemitente;
	}

	public void setTextApellidoRemitente(JTextField textApellidoRemitente) {
		this.textApellidoRemitente = textApellidoRemitente;
	}

	public JTextField getTextDniRemitente() {
		return textDniRemitente;
	}

	public void setTextDniRemitente(JTextField textDniRemitente) {
		this.textDniRemitente = textDniRemitente;
	}

	public JTextField getTextCalle() {
		return textCalle;
	}

	public void setTextCalle(JTextField textCalle) {
		this.textCalle = textCalle;
	}

	public JTextField getTextNumero() {
		return textNumero;
	}

	public void setTextNumero(JTextField textNumero) {
		this.textNumero = textNumero;
	}

	public JTextField getTextDepto() {
		return textDepto;
	}

	public void setTextDepto(JTextField textDepto) {
		this.textDepto = textDepto;
	}

	public JTextField getTextPiso() {
		return textPiso;
	}

	public void setTextPiso(JTextField textPiso) {
		this.textPiso = textPiso;
	}

	public JTextField getTextNombreDestinatario() {
		return textNombreDestinatario;
	}

	public void setTextNombreDestinatario(JTextField textNombreDestinatario) {
		this.textNombreDestinatario = textNombreDestinatario;
	}

	public JTextField getTextApellidoDestinatario() {
		return textApellidoDestinatario;
	}

	public void setTextApellidoDestinatario(JTextField textApellidoDestinatario) {
		this.textApellidoDestinatario = textApellidoDestinatario;
	}

	public JTextField getTextDniDestinatario() {
		return textDniDestinatario;
	}

	public void setTextDniDestinatario(JTextField textDniDestinatario) {
		this.textDniDestinatario = textDniDestinatario;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	public ControladorEncomiendas getC() {
		return c;
	}

	public void setC(ControladorEncomiendas c) {
		this.c = c;
	}

	public JLabel getLblErrorDimenciones() {
		return lblErrorDimenciones;
	}

	public void setLblErrorDimenciones(JLabel lblErrorDimenciones) {
		this.lblErrorDimenciones = lblErrorDimenciones;
	}

	public JCheckBox getChckbxEnvioADomicilio() {
		return chckbxEnvioADomicilio;
	}

	public void setChckbxEnvioADomicilio(JCheckBox chckbxEnvioADomicilio) {
		this.chckbxEnvioADomicilio = chckbxEnvioADomicilio;
	}

	public JPanel getPanelDomicilio() {
		return panelDomicilio;
	}

	public void setPanelDomicilio(JPanel panelDomicilio) {
		this.panelDomicilio = panelDomicilio;
	}

	public JTextField getTextTelefonoRemitente() {
		return textTelefonoRemitente;
	}

	public void setTextTelefonoRemitente(JTextField textTelefonoRemitente) {
		this.textTelefonoRemitente = textTelefonoRemitente;
	}

	public JTextField getTextTelefonoDestinatario() {
		return textTelefonoDestinatario;
	}

	public void setTextTelefonoDestinatario(JTextField textTelefonoDestinatario) {
		this.textTelefonoDestinatario = textTelefonoDestinatario;
	}

	public JComboBox getComboBoxDni() {
		return comboBoxDni;
	}

	public void setComboBoxDni(JComboBox comboBoxDni) {
		this.comboBoxDni = comboBoxDni;
	}

	public JComboBox getComboBoxOrigen() {
		return comboBoxOrigen;
	}

	public void setComboBoxOrigen(JComboBox comboBoxOrigen) {
		this.comboBoxOrigen = comboBoxOrigen;
	}

	public JComboBox getComboBoxDestino() {
		return comboBoxDestino;
	}

	public void setComboBoxDestino(JComboBox comboBoxDestino) {
		this.comboBoxDestino = comboBoxDestino;
	}

	public JComboBox getComboBoxProvD() {
		return comboBoxProvD;
	}

	public void setComboBoxProvD(JComboBox comboBoxProvD) {
		this.comboBoxProvD = comboBoxProvD;
	}

	public JComboBox getComboBoxProvO() {
		return comboBoxProvO;
	}

	public void setComboBoxProvO(JComboBox comboBoxProvO) {
		this.comboBoxProvO = comboBoxProvO;
	}


	public JComboBox getComboBoxDescuentoE() {
		return comboBoxDescuentoE;
	}

	public void setComboBoxDescuentoE(JComboBox comboBoxDescuentoE) {
		this.comboBoxDescuentoE = comboBoxDescuentoE;
	}

	public JComboBox getComboBoxDni_1() {
		return comboBoxDni_1;
	}

	public void setComboBoxDni_1(JComboBox comboBoxDni_1) {
		this.comboBoxDni_1 = comboBoxDni_1;
	}

	public JLabel getCalculoPrecio() {
		return calculoPrecio;
	}

	public void setCalculoPrecio(JLabel calculoPrecio) {
		this.calculoPrecio = calculoPrecio;
	}

	public JLabel getLbltipoServicio() {
		return lbltipoServicio;
	}

	public void setLbltipoServicio(JLabel lbltipoServicio) {
		this.lbltipoServicio = lbltipoServicio;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JLabel getId() {
		return id;
	}

	public void setId(JLabel id) {
		this.id = id;
	}

	public JButton getBtnCancelarTEncomienda() {
		return btnCancelarTEncomienda;
	}

	public void setBtnCancelarTEncomienda(JButton btnCancelarTEncomienda) {
		this.btnCancelarTEncomienda = btnCancelarTEncomienda;
	}
}
