package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.ControladorTablaPasajes;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class VistaTablaPasajes extends JFrame {
	private JButton btnConfirmar;
	private JTable table;
	private DefaultTableModel modeloTabla;
	private JButton btnCancelarPasaje;
	private JTextField textBuscador;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private ControladorTablaPasajes c;
	private JButton btnAceptar;
	private JButton btnDetallesP;
	private JButton btnModificar;
	
	
	public VistaTablaPasajes(ControladorTablaPasajes c) {
		setC(c);
		setBackground(Color.WHITE);
		setTitle("Pasajes");
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 102));
		panel.setBounds(0, 0, 906, 30);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_2 = new JLabel("PASAJES");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 784, 30);
		panel.add(lblNewLabel_2);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setForeground(UIManager.getColor("Button.focus"));
		btnConfirmar.setBackground(Color.GREEN);
		btnConfirmar.setBounds(755, 611, 115, 23);
		btnConfirmar.addActionListener(getC());
		contentPane.add(btnConfirmar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(31, 113, 761, 264);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 761, 264);
		panel_1.add(scrollPane);
		
		String header[]= {"ID","NyA","Nº BUTACA","DNI","ORIGEN-DESTINO", "FECHA DE SALIDA", "ESTADO"};
		modeloTabla = new DefaultTableModel(null, header);
		
		table = new JTable(modeloTabla);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.getSelectionModel().addListSelectionListener(this.getC());;
		scrollPane.setViewportView(table);
		
		btnCancelarPasaje = new JButton("Cancelar pasaje");
		btnCancelarPasaje.setEnabled(false);
		btnCancelarPasaje.setForeground(Color.BLACK);
		btnCancelarPasaje.setFont(new Font("Arial", Font.BOLD, 11));
		btnCancelarPasaje.setBackground(new Color(153, 204, 102));
		btnCancelarPasaje.addActionListener(getC());
		btnCancelarPasaje.setBounds(271, 388, 121, 23);
		contentPane.add(btnCancelarPasaje);
		btnCancelarPasaje.setBorder((Border) new BevelBorder(BevelBorder.RAISED));;
		
		textBuscador = new JTextField();
		textBuscador.setBounds(147, 74, 570, 23);
		textBuscador.setColumns(10);
		textBuscador.addKeyListener(getC());
		contentPane.add(textBuscador);
		
		
		lblNewLabel_1 = new JLabel("BUSCADOR");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(40, 73, 115, 23);
		contentPane.add(lblNewLabel_1);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(734, 426, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Arial", Font.BOLD, 13));
		btnAceptar.setBackground(new Color(153, 204, 102));
		btnAceptar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));;
		btnAceptar.addActionListener(getC());
		
		btnDetallesP = new JButton("Detalles");
		btnDetallesP.setForeground(Color.BLACK);
		btnDetallesP.setFont(new Font("Arial", Font.BOLD, 13));
		btnDetallesP.setEnabled(false);
		btnDetallesP.setBackground(new Color(153, 204, 102));
		btnDetallesP.setBounds(442, 388, 121, 23);
		btnDetallesP.addActionListener(getC());
		btnDetallesP.setBorder((Border) new BevelBorder(BevelBorder.RAISED));;
		contentPane.add(btnDetallesP);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setFont(new Font("Arial", Font.BOLD, 13));
		btnModificar.setEnabled(false);
		btnModificar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnModificar.setBackground(new Color(153, 204, 102));
		btnModificar.setBounds(98, 388, 121, 23);
		btnModificar.addActionListener(getC());
		contentPane.add(btnModificar);
		
		
	}


	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}


	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
		
	}

	

	public JButton getBtnModificar() {
		return btnModificar;
	}


	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public DefaultTableModel getModeloTabla() {
		return modeloTabla;
	}


	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
	}


	public JButton getBtnCancelarPasaje() {
		return btnCancelarPasaje;
	}


	public void setBtnCancelarPasaje(JButton btnCancelarPasaje) {
		this.btnCancelarPasaje = btnCancelarPasaje;
	}


	public JTextField getTextBuscador() {
		return textBuscador;
	}


	public void setTextBuscador(JTextField textBuscador) {
		this.textBuscador = textBuscador;
	}


	public ControladorTablaPasajes getC() {
		return c;
	}


	public void setC(ControladorTablaPasajes c) {
		this.c = c;
	}


	public JButton getBtnAceptar() {
		return btnAceptar;
	}


	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}


	public JButton getBtnDetallesP() {
		return btnDetallesP;
	}


	public void setBtnDetallesP(JButton btnDetallesP) {
		this.btnDetallesP = btnDetallesP;
	}
}
