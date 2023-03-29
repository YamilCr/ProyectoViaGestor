package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import controlador.ControladorDescuentos;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VistaDescuentos extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldNombreDescuento;
	private JTextField textFieldPorcentaje;
	private ControladorDescuentos controlador;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JPanel panel;
	private JLabel subtitulo;
	private JTextField textbuscador;
	private JPanel panelBotonesModificar;
	private JButton btnCancelarModificacion;
	private JButton btnModificarDescuento;
	private JPanel panelAgregar;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				new ControladorDescuentos();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaDescuentos(ControladorDescuentos controlador) {
		this.setControlador(controlador);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBounds(28, 90, 583, 186);
		contentPane.add(panelTabla);
		panelTabla.setLayout(null);
		
		
		table = new JTable();
		table.setBounds(0, 0, 327, 136);
		table.setVisible(true);
		table.getSelectionModel().addListSelectionListener(getControlador());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 583, 185);
		scrollPane.setViewportView(table);
		panelTabla.add(scrollPane);
		
		btnEliminar = new JButton("Eliminar descuento");
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(getControlador());
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 13));
		btnEliminar.setBackground(new Color(153, 204, 102));
		btnEliminar.setBounds(424, 327, 179, 23);
		contentPane.add(btnEliminar);
		btnEliminar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		btnActualizar = new JButton("Actualizar descuento");
		btnActualizar.setEnabled(false);
		btnActualizar.addActionListener(getControlador());
		btnActualizar.setForeground(Color.BLACK);
		btnActualizar.setFont(new Font("Arial", Font.BOLD, 13));
		btnActualizar.setBackground(new Color(153, 204, 102));
		btnActualizar.setBounds(424, 361, 179, 23);
		contentPane.add(btnActualizar);
		btnActualizar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		JLabel titulo = new JLabel("DESCUENTOS");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(0, 0, 634, 41);
		contentPane.add(titulo);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(getControlador());
		
		btnCancelar.addActionListener(getControlador());
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnCancelar.setBackground(new Color(153, 204, 102));
		btnCancelar.setBounds(10, 427, 89, 23);
		contentPane.add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(getControlador());
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Arial", Font.BOLD, 13));
		btnAceptar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnAceptar.setBackground(new Color(153, 204, 102));
		btnAceptar.setBounds(535, 427, 89, 23);
		contentPane.add(btnAceptar);
		
		panel = new JPanel();
		panel.setBounds(51, 307, 333, 77);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textFieldNombreDescuento = new JTextField();
		textFieldNombreDescuento.setBounds(194, 15, 109, 20);
		panel.add(textFieldNombreDescuento);
		textFieldNombreDescuento.setColumns(10);
		
		JLabel lblDescuento = new JLabel("Nombre del descuento:\r\n");
		lblDescuento.setBounds(30, 18, 154, 14);
		panel.add(lblDescuento);
		lblDescuento.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblPorcentaje = new JLabel("Porcentaje:");
		lblPorcentaje.setBounds(30, 49, 86, 14);
		panel.add(lblPorcentaje);
		lblPorcentaje.setFont(new Font("Arial", Font.PLAIN, 12));
		
		textFieldPorcentaje = new JTextField();
		textFieldPorcentaje.setBounds(194, 46, 109, 20);
		panel.add(textFieldPorcentaje);
		textFieldPorcentaje.setColumns(10);
		
		subtitulo = new JLabel("AGREGAR DESCUENTO");
		subtitulo.setFont(new Font("Arial", Font.BOLD, 14));
		subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		subtitulo.setBounds(51, 287, 333, 14);
		subtitulo.setForeground(new Color(153, 204, 102));
		contentPane.add(subtitulo);
		
		textbuscador = new JTextField();
		textbuscador.setBounds(157, 59, 400, 20);
		textbuscador.addKeyListener(getControlador());
		contentPane.add(textbuscador);
		textbuscador.setColumns(10);
		
		panelAgregar = new JPanel();
		panelAgregar.setBounds(51, 384, 333, 32);
		contentPane.add(panelAgregar);
		panelAgregar.setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(115, 0, 89, 23);
		panelAgregar.add(btnAgregar);
		btnAgregar.addActionListener(getControlador());
		btnAgregar.setForeground(Color.BLACK);
		btnAgregar.setFont(new Font("Arial", Font.BOLD, 13));
		btnAgregar.setBackground(new Color(153, 204, 102));
		btnAgregar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		panelBotonesModificar = new JPanel();
		panelBotonesModificar.setBounds(51, 384, 333, 32);
		contentPane.add(panelBotonesModificar);
		panelBotonesModificar.setLayout(null);
		panelBotonesModificar.setVisible(false);
		
		
		
		btnCancelarModificacion = new JButton("Cancelar");
		btnCancelarModificacion.setForeground(Color.BLACK);
		btnCancelarModificacion.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelarModificacion.setBounds(46, 0, 89, 23);
		panelBotonesModificar.add(btnCancelarModificacion);
		btnCancelarModificacion.addActionListener(getControlador());
		btnCancelarModificacion.setBackground(new Color(153, 204, 102));
		btnCancelarModificacion.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		btnModificarDescuento = new JButton("Modificar");
		btnModificarDescuento.setForeground(Color.BLACK);
		btnModificarDescuento.setFont(new Font("Arial", Font.BOLD, 13));
		btnModificarDescuento.setBounds(183, 0, 89, 23);
		panelBotonesModificar.add(btnModificarDescuento);
		btnModificarDescuento.addActionListener(getControlador());
		btnModificarDescuento.setBackground(new Color(153, 204, 102));
		btnModificarDescuento.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		
		lblNewLabel = new JLabel("BUSCADOR");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(42, 59, 117, 20);
		contentPane.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(153, 204, 102));
		panel_1.setBounds(0, 0, 634, 41);
		contentPane.add(panel_1);
	}
	

	public ControladorDescuentos getControlador() {
		return controlador;
	}

	public void setControlador(ControladorDescuentos controlador) {
		this.controlador = controlador;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}


	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}


	public JTextField getTextFieldNombreDescuento() {
		return textFieldNombreDescuento;
	}

	public JTextField getTextFieldPorcentaje() {
		return textFieldPorcentaje;
	}

	public JTextField getTextbuscador() {
		return textbuscador;
	}

	public void setTextbuscador(JTextField textbuscador) {
		this.textbuscador = textbuscador;
	}


	public void setTextFieldNombreDescuento(JTextField textFieldNombreDescuento) {
		this.textFieldNombreDescuento = textFieldNombreDescuento;
	}

	public void setTextFieldPorcentaje(JTextField textFieldPorcentaje) {
		this.textFieldPorcentaje = textFieldPorcentaje;
	}


	public JLabel getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(JLabel subtitulo) {
		this.subtitulo = subtitulo;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public JPanel getPanelBotonesModificar() {
		return panelBotonesModificar;
	}

	public JPanel getPanelAgregar() {
		return panelAgregar;
	}

	public JButton getBtnCancelarModificacion() {
		return btnCancelarModificacion;
	}

	public JButton getBtnModificarDescuento() {
		return btnModificarDescuento;
	}
	
}
