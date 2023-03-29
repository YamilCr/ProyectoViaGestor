package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import controlador.ControladorRecorridos;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;

public class VistaRegistrarAsignaciones extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNroColectivo;
	private JTextField textFieldNroButacas;
	private JLabel lblNewLabelSeteaPasajes;
	private JFormattedTextField hora_salida;
	private JFormattedTextField fecha_salida;
	private JButton btnCancelarAsignacion;
	private JButton btnConfirmarRegistroAsignacion;
	private JLabel titulo;
	
	private ControladorRecorridos controlador;
	private JButton btnConfirmarModificacionAsignacion;
	private JLabel lblNewLabel;
	private JPanel panel_1;


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


	public VistaRegistrarAsignaciones(ControladorRecorridos controlador) {
		this.setControlador(controlador);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBounds(111, 62, 384, 332);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de salida\r\n:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(53, 74, 125, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hora de salida:\r\n");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(53, 112, 111, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("N\u00FAmero de colectivo:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(53, 153, 125, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("N\u00FAmero de butacas:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(53, 192, 125, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Disponibilidad de pasajes:");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(53, 228, 172, 14);
		panel.add(lblNewLabel_6);
		
		textFieldNroColectivo = new JTextField();
		textFieldNroColectivo.setBounds(188, 150, 111, 20);
		panel.add(textFieldNroColectivo);
		textFieldNroColectivo.setColumns(10);
		
		textFieldNroButacas = new JTextField();
		textFieldNroButacas.setBounds(188, 189, 111, 20);
		panel.add(textFieldNroButacas);
		textFieldNroButacas.setColumns(10);
		textFieldNroButacas.addKeyListener(getControlador());
		
		lblNewLabelSeteaPasajes = new JLabel("0");
		lblNewLabelSeteaPasajes.setBounds(235, 228, 64, 14);
		panel.add(lblNewLabelSeteaPasajes);
		
		try {
			MaskFormatter mascaraHora= new MaskFormatter("##:##");
			hora_salida = new JFormattedTextField(mascaraHora);
			hora_salida.setHorizontalAlignment(SwingConstants.CENTER);
			hora_salida.setBounds(190, 109, 109, 20);
			panel.add(hora_salida);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			MaskFormatter mascaraFecha= new MaskFormatter("####-##-##");
			fecha_salida = new JFormattedTextField(mascaraFecha);
			fecha_salida.setHorizontalAlignment(SwingConstants.CENTER);
			fecha_salida.setBounds(188, 71, 111, 20);
			panel.add(fecha_salida);
			
			lblNewLabel = new JLabel("aaa-mm-dd");
			lblNewLabel.setForeground(Color.GRAY);
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 11));
			lblNewLabel.setBounds(309, 74, 66, 14);
			panel.add(lblNewLabel);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		btnCancelarAsignacion = new JButton("Cancelar");
		btnCancelarAsignacion.addActionListener(getControlador());
		btnCancelarAsignacion.setBounds(10, 427, 89, 23);
		contentPane.add(btnCancelarAsignacion);
		btnCancelarAsignacion.setForeground(Color.BLACK);
		btnCancelarAsignacion.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelarAsignacion.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnCancelarAsignacion.setBackground(new Color(153, 204, 102));
		
		btnConfirmarRegistroAsignacion = new JButton("Confirmar");
		btnConfirmarRegistroAsignacion.addActionListener(getControlador());
		btnConfirmarRegistroAsignacion.setBounds(525, 427, 99, 23);
		contentPane.add(btnConfirmarRegistroAsignacion);
		btnConfirmarRegistroAsignacion.setForeground(Color.BLACK);
		btnConfirmarRegistroAsignacion.setFont(new Font("Arial", Font.BOLD, 13));
		btnConfirmarRegistroAsignacion.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnConfirmarRegistroAsignacion.setBackground(new Color(153, 204, 102));
		
		btnConfirmarModificacionAsignacion = new JButton("Confirmar");
		btnConfirmarModificacionAsignacion.setBounds(525, 427, 99, 23);
		contentPane.add(btnConfirmarModificacionAsignacion);
		btnConfirmarModificacionAsignacion.addActionListener(getControlador());
		btnConfirmarModificacionAsignacion.setForeground(Color.BLACK);
		btnConfirmarModificacionAsignacion.setFont(new Font("Arial", Font.BOLD, 13));
		btnConfirmarModificacionAsignacion.setBorder((Border) new BevelBorder(BevelBorder.RAISED));
		btnConfirmarModificacionAsignacion.setBackground(new Color(153, 204, 102));
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(153, 204, 102));
		panel_1.setBounds(0, 0, 634, 41);
		contentPane.add(panel_1);
		
		titulo = new JLabel("FECHA-HORA-COLECTIVO");
		titulo.setForeground(Color.WHITE);
		titulo.setBounds(0, 0, 634, 41);
		panel_1.add(titulo);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));

		
	}

	public JTextField getTextFieldNroButacas() {
		return textFieldNroButacas;
	}

	public void setTextFieldNroButacas(JTextField textFieldNroButacas) {
		this.textFieldNroButacas = textFieldNroButacas;
	}

	public JLabel getLblNewLabelSeteaPasajes() {
		return lblNewLabelSeteaPasajes;
	}

	public void setLblNewLabelSeteaPasajes(JLabel lblNewLabelSeteaPasajes) {
		this.lblNewLabelSeteaPasajes = lblNewLabelSeteaPasajes;
	}

	public ControladorRecorridos getControlador() {
		return controlador;
	}

	public void setControlador(ControladorRecorridos controlador) {
		this.controlador = controlador;
	}

	public JTextField getTextFieldNroColectivo() {
		return textFieldNroColectivo;
	}

	public JFormattedTextField getHora_salida() {
		return hora_salida;
	}

	public JFormattedTextField getFecha_salida() {
		return fecha_salida;
	}


	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}


	public JButton getBtnCancelarAsignacion() {
		return btnCancelarAsignacion;
	}


	public JButton getBtnConfirmarModificacionAsignacion() {
		return btnConfirmarModificacionAsignacion;
	}


	public JButton getBtnConfirmarRegistroAsignacion() {
		return btnConfirmarRegistroAsignacion;
	}


	public void setBtnConfirmarRegistroAsignacion(JButton btnConfirmarRegistroAsignacion) {
		this.btnConfirmarRegistroAsignacion = btnConfirmarRegistroAsignacion;
	}


	public void setBtnCancelarAsignacion(JButton btnCancelarAsignacion) {
		this.btnCancelarAsignacion = btnCancelarAsignacion;
	}


	public void setBtnConfirmarModificacionAsignacion(JButton btnConfirmarModificacionAsignacion) {
		this.btnConfirmarModificacionAsignacion = btnConfirmarModificacionAsignacion;
	}
}
