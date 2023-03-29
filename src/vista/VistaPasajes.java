package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controlador.ControladorPasajes;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.Component;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

public class VistaPasajes extends JFrame {

	private JPanel contentPane;
	private JTextField textNombrePasajero;
	private JTextField textApellido;
	private JTextField textNumeroDoc;
	private JComboBox comboBoxDni;
	private JComboBox comboBoxOrigenDestino;
	private JComboBox comboBoxFechaDisponibles;
	private JComboBox comboBoxDescuentoE;
	private JButton btnConfirmar;
	private ControladorPasajes c;
	private JLabel lblErrorNombre;
	private JLabel lblErrorApellido;
	private JSeparator separator_2;
	private JLabel lblErrorNumero;
	private JButton btnCancelar;
	private JTextField textTelefono;
	private JLabel lblErrorTelefono;
	private JToggleButton btn2;
	private JToggleButton btn1;
	private JToggleButton btn3;
	private JToggleButton btn4;
	private JToggleButton btn5;
	private JToggleButton btn6;
	private JToggleButton btn7;
	private JToggleButton btn8;
	private JToggleButton btn9;
	private JToggleButton btn10;
	private JPanel panel_botones;
	private JLabel lblNroButaca;
	private JLabel lblPrecioFinal;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnModificar;
	private JLabel lblIDBoleto;

	public VistaPasajes(ControladorPasajes c) {
		this.setC(c);
		
		UIManager.put("ToggleButton.select", Color.RED);
		UIManager.put("ToggleButton.disable(false)", Color.RED);
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 710);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 102));
		panel.setBounds(0, 27, 392, 369);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASAJERO");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		textNombrePasajero = new JTextField();
		
		
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(10, 637, 125, 23);
		contentPane.add(btnCancelar);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.addActionListener(getC());
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(0, 21, 392, 26);
		panel.add(lblNewLabel_1_1);
		
		textNombrePasajero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textNombrePasajero.setBorder(null);
		textNombrePasajero.setForeground(new Color(0, 0, 0));
		textNombrePasajero.setBackground(new Color(153, 204, 102));
		textNombrePasajero.addFocusListener(getC());
		textNombrePasajero.setColumns(10);
		textNombrePasajero.setBounds(25, 94, 308, 20);
		panel.add(textNombrePasajero);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre*");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(25, 69, 71, 14);
		panel.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 119, 297, 8);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(25, 182, 297, 8);
		panel.add(separator_1);
		
		textApellido = new JTextField();
		textApellido.setForeground(Color.BLACK);
		textApellido.addFocusListener(getC());
		textApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textApellido.setColumns(10);
		textApellido.setBorder(null);
		textApellido.setBackground(new Color(153, 204, 102));
		textApellido.setBounds(23, 163, 282, 20);
		panel.add(textApellido);
		
		JLabel lblNewLabel_2_1 = new JLabel("Apellido*");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(23, 138, 71, 14);
		panel.add(lblNewLabel_2_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(197, 230, 116, 20);
		panel.add(separator_2);
		
		textNumeroDoc = new JTextField();
		textNumeroDoc.setForeground(Color.BLACK);
		textNumeroDoc.addFocusListener(getC());
		textNumeroDoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textNumeroDoc.setColumns(10);
		textNumeroDoc.setBorder(null);
		textNumeroDoc.setBackground(new Color(153, 204, 102));
		textNumeroDoc.setBounds(206, 205, 99, 20);
		panel.add(textNumeroDoc);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tipo Documento*");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(27, 203, 131, 14);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Nro*:");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(158, 201, 46, 20);
		panel.add(lblNewLabel_2_2_1);
		
		comboBoxDni = new JComboBox();
		comboBoxDni.setBackground(Color.WHITE);
		comboBoxDni.setModel(new DefaultComboBoxModel(new String[] {"DNI", "Licencia", "Carnet Ext.", "Pasaporte"}));
		
		comboBoxDni.setBounds(25, 224, 106, 22);
		panel.add(comboBoxDni);
		
		JLabel lblNewLabel_2_3 = new JLabel("Telefono*");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(25, 272, 96, 14);
		panel.add(lblNewLabel_2_3);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(25, 316, 308, 8);
		panel.add(separator_3);
		
		lblErrorNombre = new JLabel("***Ingrese su nombre***");
		lblErrorNombre.setVisible(false);
		lblErrorNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorNombre.setForeground(new Color(255, 0, 0));
		lblErrorNombre.setBounds(87, 71, 174, 14);
		panel.add(lblErrorNombre);
		
		lblErrorApellido = new JLabel("***Ingrese su apellido***");
		lblErrorApellido.setVisible(false);
		lblErrorApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorApellido.setForeground(Color.RED);
		lblErrorApellido.setBounds(85, 138, 174, 14);
		panel.add(lblErrorApellido);
		
		lblErrorNumero = new JLabel("***Ingrese sin punto ni coma(. ,)**");
		lblErrorNumero.setVisible(false);
		lblErrorNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorNumero.setForeground(Color.RED);
		lblErrorNumero.addFocusListener(getC());
		lblErrorNumero.setBounds(158, 236, 214, 14);
		panel.add(lblErrorNumero);
		
		textTelefono = new JTextField();
		textTelefono.setForeground(Color.BLACK);
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textTelefono.setColumns(10);
		textTelefono.setBorder(null);
		textTelefono.setBackground(new Color(153, 204, 102));
		textTelefono.addFocusListener(getC());
		textTelefono.setBounds(25, 295, 362, 20);
		panel.add(textTelefono);
		
		lblErrorTelefono = new JLabel("**Ingresar numeros**");
		lblErrorTelefono.setVisible(false);
		lblErrorTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblErrorTelefono.setForeground(new Color(255, 0, 0));
		lblErrorTelefono.setBounds(25, 330, 140, 14);
		lblErrorTelefono.addFocusListener(getC());
		panel.add(lblErrorTelefono);
		
		lblIDBoleto = new JLabel("");
		lblIDBoleto.setBounds(255, 21, 46, 20);
		panel.add(lblIDBoleto);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(153, 204, 102));
		panel_1.setBounds(0, 0, 906, 28);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("PASAJES");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(318, 1, 207, 26);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 21));
		
		comboBoxOrigenDestino = new JComboBox();
		comboBoxOrigenDestino.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opci\u00F3n"}));
		comboBoxOrigenDestino.addItemListener(getC());
		comboBoxOrigenDestino.setBounds(473, 109, 244, 22);
		comboBoxOrigenDestino.addActionListener(getC());
		contentPane.add(comboBoxOrigenDestino);
		
		JLabel lblOrigen = new JLabel("DESTINO - ORIGEN");
		lblOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrigen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrigen.setBounds(500, 84, 187, 14);
		contentPane.add(lblOrigen);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("COMPRA DE PASAJE");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(390, 47, 394, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Partida*:");
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_2_1.setBounds(439, 172, 170, 14);
		contentPane.add(lblNewLabel_2_2_2_1);
		
		comboBoxFechaDisponibles = new JComboBox();
		comboBoxFechaDisponibles.setMaximumRowCount(12);
		comboBoxFechaDisponibles.setBounds(547, 170, 170, 22);
		comboBoxFechaDisponibles.addItemListener(getC());
		contentPane.add(comboBoxFechaDisponibles);
		
		JLabel lblNewLabel_2_2_2_1_1 = new JLabel("Nro de butaca*:");
		lblNewLabel_2_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_2_1_1.setBounds(439, 227, 135, 14);
		contentPane.add(lblNewLabel_2_2_2_1_1);
		
		JLabel lblPrecio = new JLabel("Precio final:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(473, 351, 71, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescuento.setBounds(439, 277, 95, 14);
		contentPane.add(lblDescuento);
		
		comboBoxDescuentoE = new JComboBox();
		comboBoxDescuentoE.setModel(new DefaultComboBoxModel(new String[] {"Sin descuento"}));
		comboBoxDescuentoE.setBounds(568, 275, 149, 22);
		comboBoxDescuentoE.addItemListener(getC());
		contentPane.add(comboBoxDescuentoE);
		
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setBackground(Color.GREEN);
		btnConfirmar.setBounds(649, 637, 125, 23);
		btnConfirmar.addActionListener(getC());
		contentPane.add(btnConfirmar);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(837, 541, -96, 5);
		contentPane.add(separator_4);
		
		JSeparator separator_3_1_1 = new JSeparator();
		separator_3_1_1.setBounds(554, 366, 168, 14);
		contentPane.add(separator_3_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(390, 382, 394, 14);
		panel_2.setBackground(new Color(153, 204, 102));
		contentPane.add(panel_2);
		
		panel_botones = new JPanel();
		panel_botones.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_botones.setBounds(66, 440, 640, 174);
		contentPane.add(panel_botones);
		panel_botones.setLayout(null);
		panel_botones.setVisible(false);
		panel_botones.setBackground(UIManager.getColor("Button.disabledShadow"));
		
		btn2 = new JToggleButton("2");
		btn2.setBorder(null);
		btn2.setFont(new Font("Arial", Font.BOLD, 14));
		btn2.setBounds(58, 21, 58, 44);
		panel_botones.add(btn2);
		btn2.setBackground(new Color(104, 232, 100));
		btn2.addActionListener(getC());
		
		btn1 = new JToggleButton("1");
		btn1.setBorder(null);
		btn1.setIcon(null);
		btn1.setBounds(58, 107, 58, 44);
		panel_botones.add(btn1);
		btn1.setBackground(new Color(104, 232, 100));
		btn1.addActionListener(getC());
		
		btn3 = new JToggleButton("3");
		btn3.setBorder(null);
		btn3.setBounds(168, 107, 58, 44);
		panel_botones.add(btn3);
		btn3.setBackground(new Color(104, 232, 100));
		btn3.addActionListener(getC());
		
		btn4 = new JToggleButton("4");
		btn4.setBorder(null);
		btn4.setBounds(168, 21, 58, 44);
		panel_botones.add(btn4);
		btn4.setBackground(new Color(104, 232, 100));
		btn4.addActionListener(getC());
		
		btn5 = new JToggleButton("5");
		btn5.setBorder(null);
		btn5.setBounds(284, 107, 58, 44);
		panel_botones.add(btn5);
		btn5.setBackground(new Color(104, 232, 100));
		btn5.addActionListener(getC());
		
		btn6 = new JToggleButton("6");
		btn6.setBorder(null);
		btn6.setBounds(284, 21, 58, 44);
		panel_botones.add(btn6);
		btn6.setBackground(new Color(104, 232, 100));
		btn6.addActionListener(getC());
		
		btn7 = new JToggleButton("7");
		btn7.setBorder(null);
		btn7.setBounds(401, 107, 58, 44);
		panel_botones.add(btn7);
		btn7.setBackground(new Color(104, 232, 100));
		btn7.addActionListener(getC());
		
		btn8 = new JToggleButton("8");
		btn8.setBorder(null);
		btn8.setBounds(401, 21, 58, 44);
		panel_botones.add(btn8);
		btn8.setBackground(new Color(104, 232, 100));
		btn8.addActionListener(getC());
		
		btn9 = new JToggleButton("9");
		btn9.setBorder(null);
		btn9.setBounds(524, 107, 58, 44);
		panel_botones.add(btn9);
		btn9.setBackground(new Color(104, 232, 100));
		btn9.addActionListener(getC());
		
		btn10 = new JToggleButton("10");
		btn10.setBorder(null);
		btn10.setFont(new Font("Arial", Font.BOLD, 14));
		btn10.setBounds(524, 21, 58, 44);
		panel_botones.add(btn10);
		btn10.setBackground(new Color(104, 232, 100));
		
		lblNroButaca = new JLabel("0");
		lblNroButaca.setHorizontalAlignment(SwingConstants.CENTER);
		lblNroButaca.setFont(new Font("Arial", Font.BOLD, 14));
		lblNroButaca.setBounds(568, 228, 149, 14);
		contentPane.add(lblNroButaca);
		
		lblPrecioFinal = new JLabel("0.0");
		lblPrecioFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioFinal.setFont(new Font("Arial", Font.BOLD, 15));
		lblPrecioFinal.setBounds(566, 352, 151, 14);
		contentPane.add(lblPrecioFinal);
		
		JSeparator separator_3_1_2 = new JSeparator();
		separator_3_1_2.setBounds(568, 248, 140, 5);
		contentPane.add(separator_3_1_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VistaPasajes.class.getResource("/imagenes/rojo3.jpg")));
		lblNewLabel.setBounds(151, 404, 25, 28);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(VistaPasajes.class.getResource("/imagenes/verde.jpg")));
		lblNewLabel_3.setBounds(400, 407, 25, 28);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("OCUPADO");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(200, 415, 88, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("LIBRE");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(488, 415, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		btnModificar = new JButton("CONFIRMAR CAMBIO");
		btnModificar.setVisible(false);
		btnModificar.setEnabled(false);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setBackground(Color.GREEN);
		btnModificar.setBounds(604, 637, 170, 23);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(getC());
		btn10.addActionListener(getC());
	}

	

	public void setTextNombrePasajero(JTextField textNombrePasajero) {
		this.textNombrePasajero = textNombrePasajero;
	}



	public JTextField getTextApellido() {
		return textApellido;
	}

	public void setTextApellido(JTextField textApellido) {
		this.textApellido = textApellido;
	}

	public JTextField getTextNumeroDoc() {
		return textNumeroDoc;
	}

	public void setTextNumeroDoc(JTextField textNumeroDoc) {
		this.textNumeroDoc = textNumeroDoc;
	}

	public JComboBox getComboBox() {
		return comboBoxDni;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBoxDni = comboBox;
	}


	public JButton getBtnModificar() {
		return btnModificar;
	}



	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}



	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	public ControladorPasajes getC() {
		return c;
	}

	public void setC(ControladorPasajes c) {
		this.c = c;
	}

	public JComboBox getComboBoxDni() {
		return comboBoxDni;
	}

	public void setComboBoxDni(JComboBox comboBoxDni) {
		this.comboBoxDni = comboBoxDni;
	}

	public JLabel getLblErrorNombre() {
		return lblErrorNombre;
	}

	public void setLblErrorNombre(JLabel lblErrorNombre) {
		this.lblErrorNombre = lblErrorNombre;
	}

	public JLabel getLblErrorApellido() {
		return lblErrorApellido;
	}

	public void setLblErrorApellido(JLabel lblErrorApellido) {
		this.lblErrorApellido = lblErrorApellido;
	}


	public JLabel getLblErrorTelefono() {
		return lblErrorTelefono;
	}

	public void setLblErrorTelefono(JLabel lblErrorTelefono) {
		this.lblErrorTelefono = lblErrorTelefono;
	}

	public JLabel getLblErrorNumero() {
		return lblErrorNumero;
	}

	public void setLblErrorNumero(JLabel lblErrorNumero) {
		this.lblErrorNumero = lblErrorNumero;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JComboBox getComboBoxOrigenDestino() {
		return comboBoxOrigenDestino;
	}

	public void setComboBoxOrigenDestino(JComboBox comboBoxOrigenDestino) {
		this.comboBoxOrigenDestino = comboBoxOrigenDestino;
	}

	public JComboBox getComboBoxFechaDisponibles() {
		return comboBoxFechaDisponibles;
	}

	public void setComboBoxFechaDisponibles(JComboBox comboBoxFechaDisponibles) {
		this.comboBoxFechaDisponibles = comboBoxFechaDisponibles;
	}


	public JComboBox getComboBoxDescuentoE() {
		return comboBoxDescuentoE;
	}

	public void setComboBoxDescuentoE(JComboBox comboBoxDescuentoE) {
		this.comboBoxDescuentoE = comboBoxDescuentoE;
	}

	public JTextField getTextTelefono() {
		return textTelefono;
	}

	public void setTextTelefono(JTextField textTelefono) {
		this.textTelefono = textTelefono;
	}



	public JTextField getTextNombrePasajero() {
		return textNombrePasajero;
	}



	public JToggleButton getBtn2() {
		return btn2;
	}



	public void setBtn2(JToggleButton btn2) {
		this.btn2 = btn2;
	}



	public JToggleButton getBtn1() {
		return btn1;
	}



	public void setBtn1(JToggleButton btn1) {
		this.btn1 = btn1;
	}



	public JToggleButton getBtn3() {
		return btn3;
	}



	public void setBtn3(JToggleButton btn3) {
		this.btn3 = btn3;
	}



	public JToggleButton getBtn4() {
		return btn4;
	}



	public void setBtn4(JToggleButton btn4) {
		this.btn4 = btn4;
	}



	public JToggleButton getBtn5() {
		return btn5;
	}



	public void setBtn5(JToggleButton btn5) {
		this.btn5 = btn5;
	}



	public JToggleButton getBtn6() {
		return btn6;
	}



	public void setBtn6(JToggleButton btn6) {
		this.btn6 = btn6;
	}



	public JToggleButton getBtn7() {
		return btn7;
	}



	public void setBtn7(JToggleButton btn7) {
		this.btn7 = btn7;
	}



	public JToggleButton getBtn8() {
		return btn8;
	}



	public void setBtn8(JToggleButton btn8) {
		this.btn8 = btn8;
	}



	public JToggleButton getBtn9() {
		return btn9;
	}



	public void setBtn9(JToggleButton btn9) {
		this.btn9 = btn9;
	}



	public JToggleButton getBtn10() {
		return btn10;
	}



	public void setBtn10(JToggleButton btn10) {
		this.btn10 = btn10;
	}



	public JPanel getPanel_botones() {
		return panel_botones;
	}



	public void setPanel_botones(JPanel panel_botones) {
		this.panel_botones = panel_botones;
	}



	public JLabel getLblNroButaca() {
		return lblNroButaca;
	}



	public void setLblNroButaca(JLabel lblNroButaca) {
		this.lblNroButaca = lblNroButaca;
	}



	public JLabel getLblPrecioFinal() {
		return lblPrecioFinal;
	}



	public void setLblPrecioFinal(JLabel lblPrecioFinal) {
		this.lblPrecioFinal = lblPrecioFinal;
	}



	public JLabel getLblIDBoleto() {
		return lblIDBoleto;
	}



	public void setLblIDBoleto(JLabel lblIDBoleto) {
		this.lblIDBoleto = lblIDBoleto;
	}
	
}

