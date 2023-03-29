package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import modelo.Medidas;
import controlador.ControladorPrecios;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class VistaPrecios extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textPrecio;
	 
	private ControladorPrecios controlador;
	//private DefaultTableModel modeloTabla;
	private JButton btnAceptar;
	private JButton btnModificarPrecio;
	private JButton btnCancelar;
	private JComboBox<Medidas> comboBoxTipoMedida;
	private JLabel lblPrecioKM;
	private JLabel lblPrecioKG;
	private JLabel lblPrecioDomicilio;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ControladorPrecios();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VistaPrecios(ControladorPrecios controlador) {
		this.setControlador(controlador);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(76, 29, 272, 138);
		getContentPane().add(panel);
		
		
		
		textField = new JTextField();
		textField.setBounds(173, 216, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipoMedida = new JLabel("Tipo de \r\nmedida:");
		lblTipoMedida.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTipoMedida.setBounds(357, 173, 105, 14);
		contentPane.add(lblTipoMedida);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(472, 217, 104, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPrecio.setBounds(357, 220, 46, 14);
		contentPane.add(lblPrecio);
		
		comboBoxTipoMedida = new JComboBox();
		comboBoxTipoMedida.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBoxTipoMedida.setModel(new DefaultComboBoxModel(Medidas.values()));
		comboBoxTipoMedida.setToolTipText("");
		comboBoxTipoMedida.setBounds(472, 169, 104, 22);
		contentPane.add(comboBoxTipoMedida);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.addActionListener(getControlador());
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(10, 427, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));;
		
		btnModificarPrecio = new JButton("Modificar \r\nprecio\r\n");
		btnModificarPrecio.setForeground(Color.BLACK);
		btnModificarPrecio.addActionListener(getControlador());
		btnModificarPrecio.setFont(new Font("Arial", Font.BOLD, 13));
		btnModificarPrecio.setBackground(new Color(153, 204, 102));
		btnModificarPrecio.setBounds(419, 292, 128, 27);
		contentPane.add(btnModificarPrecio);
		btnModificarPrecio.setBorder((Border) new BevelBorder(BevelBorder.RAISED));;
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.addActionListener(getControlador());
		btnAceptar.setFont(new Font("Arial", Font.BOLD, 13));
		btnAceptar.setBackground(new Color(153, 204, 102));
		btnAceptar.setBounds(535, 426, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		JPanel panelMuestraPrecios = new JPanel();
		panelMuestraPrecios.setBorder(new LineBorder(new Color(192, 192, 192)));
		panelMuestraPrecios.setBackground(new Color(153, 204, 102));
		panelMuestraPrecios.setBounds(0, 0, 328, 461);
		contentPane.add(panelMuestraPrecios);
		panelMuestraPrecios.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Precio por KM:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(46, 150, 162, 29);
		panelMuestraPrecios.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 17));
		
		 lblPrecioKM = new JLabel("00.0");
		 lblPrecioKM.setForeground(Color.WHITE);
		lblPrecioKM.setBounds(198, 154, 73, 20);
		panelMuestraPrecios.add(lblPrecioKM);
		lblPrecioKM.setFont(new Font("Arial", Font.BOLD, 17));
		
		lblPrecioKG = new JLabel("00.0");
		lblPrecioKG.setForeground(Color.WHITE);
		lblPrecioKG.setBounds(199, 228, 73, 21);
		panelMuestraPrecios.add(lblPrecioKG);
		lblPrecioKG.setFont(new Font("Arial", Font.BOLD, 17));
		
		JLabel lblNewLabel_3 = new JLabel("Precio por KG:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(46, 224, 125, 29);
		panelMuestraPrecios.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 17));
		
		JLabel titulo = new JLabel("PRECIOS POR DISTANCIA Y PESO");
		titulo.setBounds(0, 64, 328, 22);
		panelMuestraPrecios.add(titulo);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 17));
		
		JLabel lblEnvio_domicilio = new JLabel("Envio a domicilio");
		lblEnvio_domicilio.setForeground(Color.WHITE);
		lblEnvio_domicilio.setFont(new Font("Arial", Font.BOLD, 17));
		lblEnvio_domicilio.setBounds(46, 295, 142, 29);
		panelMuestraPrecios.add(lblEnvio_domicilio);
		
		lblPrecioDomicilio = new JLabel("00.0");
		lblPrecioDomicilio.setForeground(Color.WHITE);
		lblPrecioDomicilio.setFont(new Font("Arial", Font.BOLD, 17));
		lblPrecioDomicilio.setBounds(197, 299, 73, 20);
		panelMuestraPrecios.add(lblPrecioDomicilio);
		
		separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(30, 190, 256, 13);
		panelMuestraPrecios.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(30, 260, 256, 13);
		panelMuestraPrecios.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setBounds(30, 330, 256, 13);
		panelMuestraPrecios.add(separator_2);;
		
		//String header[]= {"ID","Medidas(KM/KG)", "Tipo medida", "Precio"};
		//this.setModeloTabla(new DefaultTableModel(null, header));
		
		
		
		
		
		
	}
	public ControladorPrecios getControlador() {
		return controlador;
	}

	public void setControlador(ControladorPrecios controlador) {
		this.controlador = controlador;
	}
	public JButton getBtnAceptar() {
		return btnAceptar;
	}
	public JButton getBtnModificarPrecio() {
		return btnModificarPrecio;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JLabel getLblPrecioKM() {
		return lblPrecioKM;
	}

	public void setLblPrecioKM(JLabel lblPrecioKM) {
		this.lblPrecioKM = lblPrecioKM;
	}

	public JLabel getLblPrecioKG() {
		return lblPrecioKG;
	}

	public void setLblPrecioKG(JLabel lblPrecioKG) {
		this.lblPrecioKG = lblPrecioKG;
	}

	public JComboBox<Medidas> getComboBoxTipoMedida() {
		return comboBoxTipoMedida;
	}

	/*public JTextField getTextPrecio() {
		
	}*/

	public JTextField getTextPrecio() {
		// TODO Auto-generated method stub
		return textPrecio;
	}

	public JLabel getLblPrecioDomicilio() {
		return lblPrecioDomicilio;
	}

	public void setLblPrecioDomicilio(JLabel lblPrecioDomicilio) {
		this.lblPrecioDomicilio = lblPrecioDomicilio;
	}
}
