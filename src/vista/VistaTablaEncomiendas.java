package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controlador.ControladorTablaEncomienda;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class VistaTablaEncomiendas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnEntregado;
	private JButton btnEliminar;
	private JButton btnAceptar;
	private ControladorTablaEncomienda c;
	private JButton btnModificar;
	private JTextField textBuscador;
	private JButton btnDetalles;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ControladorTablaEncomienda(); }
					 catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VistaTablaEncomiendas(ControladorTablaEncomienda c) {
		setC(c);
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		
		btnEntregado = new JButton("Entregado");
		btnEntregado.setEnabled(false);
		btnEntregado.setBounds(718, 111, 106, 23);
		contentPane.add(btnEntregado);
		btnEntregado.setForeground(Color.BLACK);
		btnEntregado.setFont(new Font("Arial", Font.BOLD, 13));
		btnEntregado.setBackground(new Color(153, 204, 102));
		btnEntregado.addActionListener(getC());
		btnEntregado.setBorder((Border) new BevelBorder(BevelBorder.RAISED));;
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(718, 145, 106, 23);
		btnEliminar.addActionListener(getC());
		contentPane.add(btnEliminar);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 13));
		btnEliminar.setBackground(new Color(153, 204, 102));
		btnEliminar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));;
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBounds(28, 90, 667, 346);
		contentPane.add(panelTabla);
		panelTabla.setLayout(null);
		
		
		table = new JTable();
		table.setBounds(0, 0, 327, 136);
		table.setVisible(true);
		table.getSelectionModel().addListSelectionListener(getC());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 667, 346);
		scrollPane.setViewportView(table);
		panelTabla.add(scrollPane);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(735, 427, 89, 23);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(getC());
		btnAceptar.setForeground(Color.BLACK);
		btnAceptar.setFont(new Font("Arial", Font.BOLD, 13));
		btnAceptar.setBackground(new Color(153, 204, 102));
		btnAceptar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));;
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 834, 30);
		contentPane.add(panel);
		panel.setBackground(new Color(153, 204, 102));
		
		JLabel lblNewLabel_2 = new JLabel("ENCOMIENDA");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblNewLabel_2);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setFont(new Font("Arial", Font.BOLD, 13));
		btnModificar.setEnabled(false);
		btnModificar.setBackground(new Color(153, 204, 102));
		btnModificar.setBounds(718, 179, 106, 23);
		btnModificar.addActionListener(getC());
		contentPane.add(btnModificar);
		btnModificar.setBorder((Border) new BevelBorder(BevelBorder.RAISED));;
		
		textBuscador = new JTextField();
		textBuscador.setBounds(216, 59, 384, 20);
		contentPane.add(textBuscador);
		textBuscador.setColumns(10);
		textBuscador.addKeyListener(getC());
		
		JLabel lblNewLabel = new JLabel("BUSCADOR");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(112, 62, 94, 14);
		contentPane.add(lblNewLabel);
		
		btnDetalles = new JButton("Detalles");
		btnDetalles.setForeground(Color.BLACK);
		btnDetalles.setFont(new Font("Arial", Font.BOLD, 13));
		btnDetalles.setEnabled(false);
		btnDetalles.setBackground(new Color(153, 204, 102));
		btnDetalles.setBounds(718, 213, 106, 23);
		contentPane.add(btnDetalles);
		btnDetalles.addActionListener(getC());
		btnDetalles.setBorder((Border) new BevelBorder(BevelBorder.RAISED));;
		
	}


	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnEntregado() {
		return btnEntregado;
	}

	public void setBtnEntregado(JButton btnEntregado) {
		this.btnEntregado = btnEntregado;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}



	public ControladorTablaEncomienda getC() {
		return c;
	}


	public void setC(ControladorTablaEncomienda c) {
		this.c = c;
	}


	public JButton getBtnModificar() {
		return btnModificar;
	}


	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}


	public JTextField getTextBuscador() {
		return textBuscador;
	}


	public void setTextBuscador(JTextField textBuscador) {
		this.textBuscador = textBuscador; }


	public JButton getBtnDetalles() {
		return btnDetalles;
	}


	public void setBtnDetalles(JButton btnDetalles) {
		this.btnDetalles = btnDetalles;
	}


}
