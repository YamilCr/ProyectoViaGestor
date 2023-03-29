package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controlador.ControladorRecorridos;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class VistaRecorridos extends JFrame {

	private JPanel contentPane;
	private JButton btnModificarAsignacion;
	private JButton btnAgregarRuta;
	private JButton btnEliminarRuta;
	private JButton btnModificarRuta;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JButton btnAgregarAsignacion;
	private JTable table;
	private ControladorRecorridos controladorRecorridos;
	private JPanel panel_1;
	private JTextField textBuscador;
	private JPanel panel_2;
	
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
	public VistaRecorridos(ControladorRecorridos controladorRecorridos) {
		this.setControladorRecorridos(controladorRecorridos);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("RECORRIDOS");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-3, 0, 837, 41);
		contentPane.add(lblNewLabel);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 90, 663, 322);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 663, 322);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(getControladorRecorridos());
		
		btnAgregarRuta = new JButton("Agregar ruta");
		btnAgregarRuta.addActionListener(getControladorRecorridos());
		btnAgregarRuta.setBounds(710, 139, 114, 23);
		contentPane.add(btnAgregarRuta);
		btnAgregarRuta.setForeground(Color.BLACK);
		btnAgregarRuta.setFont(new Font("Arial", Font.BOLD, 12));
		btnAgregarRuta.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		getBtnAgregarRuta().setBackground(new Color(153, 204, 102));
		
		btnEliminarRuta = new JButton("Eliminar ruta");
		btnEliminarRuta.setEnabled(false);
		btnEliminarRuta.addActionListener(getControladorRecorridos());
		btnEliminarRuta.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminarRuta.setBounds(710, 105, 114, 23);
		contentPane.add(btnEliminarRuta);
		btnEliminarRuta.setForeground(Color.BLACK);
		btnEliminarRuta.setFont(new Font("Arial", Font.BOLD, 12));
		btnEliminarRuta.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnEliminarRuta.setBackground(new Color(153, 204, 102));
		
		btnModificarRuta = new JButton("Modificar ruta");
		btnModificarRuta.setEnabled(false);
		btnModificarRuta.addActionListener(getControladorRecorridos());
		btnModificarRuta.setBounds(710, 173, 114, 23);
		contentPane.add(btnModificarRuta);
		btnModificarRuta.setForeground(Color.BLACK);
		btnModificarRuta.setFont(new Font("Arial", Font.BOLD, 12));
		btnModificarRuta.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnModificarRuta.setBackground(new Color(153, 204, 102));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(getControladorRecorridos());
		btnCancelar.setBounds(10, 427, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnCancelar.setBackground(new Color(153, 204, 102));
		
		btnAceptar = new JButton("Aceptar\r\n");
		btnAceptar.addActionListener(getControladorRecorridos());
		btnAceptar.setBounds(735, 427, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Arial", Font.BOLD, 13));
		btnAceptar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnAceptar.setBackground(new Color(153, 204, 102));
		
		btnAgregarAsignacion = new JButton("Agregar asignacion");
		btnAgregarAsignacion.addActionListener(getControladorRecorridos());
		btnAgregarAsignacion.setBounds(691, 322, 133, 23);
		contentPane.add(btnAgregarAsignacion);
		btnAgregarAsignacion.setForeground(Color.BLACK);
		btnAgregarAsignacion.setFont(new Font("Arial", Font.BOLD, 12));
		btnAgregarAsignacion.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnAgregarAsignacion.setBackground(new Color(153, 204, 102));
		
		btnModificarAsignacion = new JButton("Modificar asignacion");
		btnModificarAsignacion.setEnabled(false);
		btnModificarAsignacion.addActionListener(getControladorRecorridos());
		btnModificarAsignacion.setBounds(691, 356, 133, 23);
		contentPane.add(btnModificarAsignacion);
		btnModificarAsignacion.setForeground(Color.BLACK);
		btnModificarAsignacion.setFont(new Font("Arial", Font.BOLD, 12));
		btnModificarAsignacion.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnModificarAsignacion.setBackground(new Color(153, 204, 102));
		
		panel_1 = new JPanel();
		panel_1.setBounds(7, 52, 663, 39);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.white);
		
		textBuscador = new JTextField();
		textBuscador.setBounds(173, 11, 437, 20);
		textBuscador.addKeyListener(getControladorRecorridos());
		panel_1.add(textBuscador);
		textBuscador.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("BUSCADOR:");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(58, 14, 105, 14);
		panel_1.add(lblNewLabel_1);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(153, 204, 102));
		panel_2.setBounds(-3, 0, 837, 41);
		contentPane.add(panel_2);
	}

	public ControladorRecorridos getControladorRecorridos() {
		return controladorRecorridos;
	}

	public void setControladorRecorridos(ControladorRecorridos controladorRecorridos) {
		this.controladorRecorridos = controladorRecorridos;
	}

	public JButton getBtnModificarAsignacion() {
		return btnModificarAsignacion;
	}

	public JButton getBtnAgregarRuta() {
		return btnAgregarRuta;
	}

	public JButton getBtnEliminarRuta() {
		return btnEliminarRuta;
	}

	public JButton getBtnModificarRuta() {
		return btnModificarRuta;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnAgregarAsignacion() {
		return btnAgregarAsignacion;
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
