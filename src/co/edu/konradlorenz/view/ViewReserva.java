package co.edu.konradlorenz.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import co.edu.konradlorenz.controller.ControllerAutenticacion;
import co.edu.konradlorenz.model.cliente.Cliente;

public class ViewReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel jpnInfo;
	private RoundedPanel jpnBackGround;
	private JLabel lblNewLabel_4;
	private RoundedTextField txtNombreHospedajeAReservar;
	private RoundedPanel jpnSeccionReserva;
	private RoundedPanel jpnHabitaciones;
	private RoundButtonCircle btnBuscarNombre;
	private JScrollPane scrollPaneHospedajes;
	private JPanel jpnUsuario;

	private JLabel lblHabitacionesDisponibles;
	private JLabel lblNumeroDeLa;
	private RoundedPanel jpnHospedajeAReservar;
	private RoundedPanel jpnHabitacionAreservar;
	private JComboBox<String> cboNumeroHabitacion;
	private JComboBox<String> cboNumeroPersonas;
	private JComboBox<String> cboNumeroNoches;
	private JLabel lblHospedajeAReservar;
	private JDateChooser dataChooserIngreso;
	private RoundedPanel jpnHabitacionAreservar_1;
	private RoundButton btnFecha;

	private JLabel lblHospedajeAReservar_1_1_2;

	private RoundButton btnPagar;

	private RoundButton btnCrearReserva;

	private RoundedPanel jpnReservaDeFondo;
	private RoundButton rndbtnHospedajes;

	public ViewReserva() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(16, 6, 38));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setResizable(false);
		this.setSize(1920, 1080);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jpnInfo = new JPanel();
		jpnInfo.setBackground(new Color(16, 6, 38));
		jpnInfo.setBounds(0, 0, 1904, 120);
		contentPane.add(jpnInfo);
		jpnInfo.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ViewAutenticacion.class.getResource("/imagenes/flechas-a-la-derecha.png")));
		lblNewLabel_3.setBounds(440, 461, 244, 96);
		jpnInfo.add(lblNewLabel_3);

		jpnUsuario = new JPanel();
		jpnUsuario.setBackground(new Color(16, 6, 38));
		jpnUsuario.setBounds(1330, 11, 505, 120);
		jpnInfo.add(jpnUsuario);
		jpnUsuario.setLayout(null);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(
				new ImageIcon(ViewHospedaje.class.getResource("/imagenes/Captura de pantalla 2024-05-21 003128.png")));
		lblNewLabel_4.setBounds(0, 0, 393, 120);
		jpnInfo.add(lblNewLabel_4);

		JLabel lblGraciasPorReservar = new JLabel("Gracias por reservar con Nosotros");
		lblGraciasPorReservar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGraciasPorReservar.setForeground(new Color(255, 255, 255));
		lblGraciasPorReservar.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 30));
		lblGraciasPorReservar.setBounds(150, 28, 801, 48);
		jpnInfo.add(lblGraciasPorReservar);

		rndbtnHospedajes = new RoundButton("Registrarse");
		rndbtnHospedajes.setText("Hospedajes");
		rndbtnHospedajes.setForeground(new Color(16, 6, 38));
		rndbtnHospedajes.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
		rndbtnHospedajes.setBorderPainted(false);
		rndbtnHospedajes.setBackground(Color.WHITE);
		rndbtnHospedajes.setBounds(999, 28, 207, 48);
		jpnInfo.add(rndbtnHospedajes);

		jpnBackGround = new RoundedPanel(50);
		jpnBackGround.setBackground(new Color(51, 26, 108));
		jpnBackGround.setBounds(55, 130, 1779, 884);

		contentPane.add(jpnBackGround);
		jpnBackGround.setLayout(null);
		Color colorBorde = new Color(255, 255, 255);

		try {
			BufferedImage originalImage = ImageIO.read(ViewAutenticacion.class.getResource("/imagenes/lupa.png"));

		} catch (IOException e2) {
			e2.printStackTrace();
		}
		jpnSeccionReserva = new RoundedPanel(50);
		jpnSeccionReserva.setBackground(new Color(179, 170, 255));
		jpnSeccionReserva.setBounds(40, 34, 307, 819);
		jpnBackGround.add(jpnSeccionReserva);
		jpnSeccionReserva.setLayout(null);

		btnBuscarNombre = new RoundButtonCircle("");
		btnBuscarNombre.setBounds(245, 63, 36, 36);
		jpnSeccionReserva.add(btnBuscarNombre);
		btnBuscarNombre.setIcon(new ImageIcon(ViewHospedaje.class.getResource("/imagenes/lupa.png")));
		btnBuscarNombre.setBackground(new Color(16, 6, 38));

		txtNombreHospedajeAReservar = new RoundedTextField(50, 50);
		txtNombreHospedajeAReservar.setBounds(10, 57, 287, 47);
		jpnSeccionReserva.add(txtNombreHospedajeAReservar);
		txtNombreHospedajeAReservar.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreHospedajeAReservar.setFont(new Font("Open Sans", Font.PLAIN, 16));
		txtNombreHospedajeAReservar.setColumns(10);

		JLabel lblBuscaElNombre = new JLabel("Nombre del hospedaje a reservar");
		lblBuscaElNombre.setBounds(0, 11, 307, 48);
		jpnSeccionReserva.add(lblBuscaElNombre);
		lblBuscaElNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscaElNombre.setForeground(new Color(0, 0, 0));
		lblBuscaElNombre.setFont(new Font("Open Sans SemiBold", Font.BOLD, 18));

		lblNumeroDeLa = new JLabel("Número de la habitacion ");
		lblNumeroDeLa.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroDeLa.setForeground(new Color(0, 0, 0));
		lblNumeroDeLa.setFont(new Font("Open Sans SemiBold", Font.BOLD, 20));
		lblNumeroDeLa.setBounds(10, 110, 307, 48);
		jpnSeccionReserva.add(lblNumeroDeLa);

		cboNumeroHabitacion = new JComboBox();
		cboNumeroHabitacion.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "28", "29", "30" }));
		cboNumeroHabitacion.setOpaque(false);
		cboNumeroHabitacion.setForeground(Color.WHITE);
		cboNumeroHabitacion.setFont(new Font("Open Sans", Font.BOLD, 20));
		cboNumeroHabitacion.setFocusable(false);
		cboNumeroHabitacion.setFocusTraversalKeysEnabled(false);
		cboNumeroHabitacion.setBackground(new Color(51, 26, 108));
		cboNumeroHabitacion.setBounds(46, 166, 217, 47);
		jpnSeccionReserva.add(cboNumeroHabitacion);

		JLabel lblNumeroDePersonas = new JLabel("Número de personas");
		lblNumeroDePersonas.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroDePersonas.setForeground(Color.BLACK);
		lblNumeroDePersonas.setFont(new Font("Open Sans SemiBold", Font.BOLD, 20));
		lblNumeroDePersonas.setBounds(0, 224, 307, 48);
		jpnSeccionReserva.add(lblNumeroDePersonas);

		cboNumeroPersonas = new JComboBox();
		cboNumeroPersonas
				.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "10" }));
		cboNumeroPersonas.setOpaque(false);
		cboNumeroPersonas.setForeground(Color.WHITE);
		cboNumeroPersonas.setFont(new Font("Open Sans", Font.BOLD, 20));
		cboNumeroPersonas.setFocusable(false);
		cboNumeroPersonas.setFocusTraversalKeysEnabled(false);
		cboNumeroPersonas.setBackground(new Color(51, 26, 108));
		cboNumeroPersonas.setBounds(46, 284, 217, 47);
		jpnSeccionReserva.add(cboNumeroPersonas);

		JLabel lblNumeroDeNoches = new JLabel("Número de noches");
		lblNumeroDeNoches.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroDeNoches.setForeground(Color.BLACK);
		lblNumeroDeNoches.setFont(new Font("Open Sans SemiBold", Font.BOLD, 20));
		lblNumeroDeNoches.setBounds(0, 347, 307, 48);
		jpnSeccionReserva.add(lblNumeroDeNoches);

		cboNumeroNoches = new JComboBox();
		cboNumeroNoches.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
		cboNumeroNoches.setOpaque(false);
		cboNumeroNoches.setForeground(Color.WHITE);
		cboNumeroNoches.setFont(new Font("Open Sans", Font.BOLD, 20));
		cboNumeroNoches.setFocusable(false);
		cboNumeroNoches.setFocusTraversalKeysEnabled(false);
		cboNumeroNoches.setBackground(new Color(51, 26, 108));
		cboNumeroNoches.setBounds(46, 395, 217, 47);
		jpnSeccionReserva.add(cboNumeroNoches);

		dataChooserIngreso = new JDateChooser();

		dataChooserIngreso.setBounds(46, 512, 217, 83);
		jpnSeccionReserva.add(dataChooserIngreso);

		JLabel lblFechaDeIngreso = new JLabel("Fecha de  ingreso");
		lblFechaDeIngreso.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaDeIngreso.setForeground(Color.BLACK);
		lblFechaDeIngreso.setFont(new Font("Open Sans SemiBold", Font.BOLD, 20));
		lblFechaDeIngreso.setBounds(0, 453, 307, 48);
		jpnSeccionReserva.add(lblFechaDeIngreso);

		btnFecha = new RoundButton("Registrarse");
		btnFecha.setText("fecha de ingreso");
		btnFecha.setForeground(new Color(16, 6, 38));
		btnFecha.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
		btnFecha.setBorderPainted(false);
		btnFecha.setBackground(Color.WHITE);
		btnFecha.setBounds(56, 622, 207, 48);
		jpnSeccionReserva.add(btnFecha);

		// Main panel with rounded corners inside the scroll pane
		jpnHabitaciones = new RoundedPanel(50);
		jpnHabitaciones.setBackground(new Color(255, 255, 255));
		jpnHabitaciones.setLayout(null);

		// Scroll pane containing the main panel
		scrollPaneHospedajes = new CustomScrollPane(jpnHabitaciones, 50);
		;
		scrollPaneHospedajes.setBorder(null);
		scrollPaneHospedajes.setBounds(368, 34, 800, 400); // Set bounds for the scroll pane
		scrollPaneHospedajes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPaneHospedajes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jpnBackGround.add(scrollPaneHospedajes);

		jpnHabitacionAreservar = new RoundedPanel(50);
		jpnHabitacionAreservar.setLayout(null);
		jpnHabitacionAreservar.setBackground(new Color(179, 170, 255));
		jpnHabitacionAreservar.setBounds(786, 453, 327, 400);
		jpnBackGround.add(jpnHabitacionAreservar);

		JLabel lblHospedajeAReservar_1_1 = new JLabel("Habitación a reservar");
		lblHospedajeAReservar_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospedajeAReservar_1_1.setForeground(Color.WHITE);
		lblHospedajeAReservar_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 24));
		lblHospedajeAReservar_1_1.setBounds(0, 0, 327, 48);
		jpnHabitacionAreservar.add(lblHospedajeAReservar_1_1);

		jpnHospedajeAReservar = new RoundedPanel(50);
		jpnHospedajeAReservar.setLayout(null);
		jpnHospedajeAReservar.setBackground(new Color(179, 170, 255));
		jpnHospedajeAReservar.setBounds(411, 453, 327, 400);
		jpnBackGround.add(jpnHospedajeAReservar);

		lblHospedajeAReservar = new JLabel("Hospedaje  a reservar");
		lblHospedajeAReservar.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospedajeAReservar.setForeground(Color.WHITE);
		lblHospedajeAReservar.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 24));
		lblHospedajeAReservar.setBounds(0, 0, 327, 48);
		jpnHospedajeAReservar.add(lblHospedajeAReservar);

		jpnReservaDeFondo = new RoundedPanel(50);
		jpnReservaDeFondo.setLayout(null);
		jpnReservaDeFondo.setBackground(new Color(16, 6, 38));
		jpnReservaDeFondo.setBounds(1197, 34, 553, 819);
		jpnBackGround.add(jpnReservaDeFondo);

		JLabel lblReservarDeFondo = new JLabel("Reserva");
		lblReservarDeFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblReservarDeFondo.setForeground(Color.WHITE);
		lblReservarDeFondo.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 24));
		lblReservarDeFondo.setBounds(0, 0, 553, 48);
		jpnReservaDeFondo.add(lblReservarDeFondo);

		btnCrearReserva = new RoundButton("Registrarse");
		btnCrearReserva.setText("Crear reserva");
		btnCrearReserva.setForeground(new Color(16, 6, 38));
		btnCrearReserva.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
		btnCrearReserva.setBorderPainted(false);
		btnCrearReserva.setBackground(Color.WHITE);
		btnCrearReserva.setBounds(172, 104, 207, 48);
		jpnReservaDeFondo.add(btnCrearReserva);

		lblHospedajeAReservar_1_1_2 = new JLabel("Para crear la reserva, debes llenar todos los datos");
		lblHospedajeAReservar_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospedajeAReservar_1_1_2.setForeground(Color.WHITE);
		lblHospedajeAReservar_1_1_2.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 20));
		lblHospedajeAReservar_1_1_2.setBounds(0, 45, 553, 48);
		jpnReservaDeFondo.add(lblHospedajeAReservar_1_1_2);

		// Example card panel with rounded corners inside the main panel

		// Set preferred size for jpnHospedajes to enable scrolling
		jpnHabitaciones.setPreferredSize(new Dimension(1432, 4000));

		lblHabitacionesDisponibles = new JLabel("Habitaciones disponibles");
		lblHabitacionesDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabitacionesDisponibles.setForeground(new Color(0, 0, 0));
		lblHabitacionesDisponibles.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 24));
		lblHabitacionesDisponibles.setBounds(0, 0, 801, 48);
		jpnHabitaciones.add(lblHabitacionesDisponibles);

		// Cargar y redimensionar la imagen
		try {
			BufferedImage originalImage = ImageIO.read(ViewAutenticacion.class.getResource("/imagenes/show.png"));

		} catch (IOException e2) {
			e2.printStackTrace();
		}

	}

	public RoundedPanel getJpnHabitaciones() {
		return jpnHabitaciones;
	}

	public void setJpnHabitaciones(RoundedPanel jpnHabitaciones) {
		this.jpnHabitaciones = jpnHabitaciones;
	}

	

	public RoundedTextField getTxtNombreHospedajeAReservar() {
		return txtNombreHospedajeAReservar;
	}

	public void setTxtNombreHospedajeAReservar(RoundedTextField txtNombreHospedajeAReservar) {
		this.txtNombreHospedajeAReservar = txtNombreHospedajeAReservar;
	}

	public RoundButtonCircle getBtnBuscarNombre() {
		return btnBuscarNombre;
	}

	public void setBtnBuscarNombre(RoundButtonCircle btnBuscarNombre) {
		this.btnBuscarNombre = btnBuscarNombre;
	}

	public JScrollPane getScrollPaneHospedajes() {
		return scrollPaneHospedajes;
	}

	public void setScrollPaneHospedajes(JScrollPane scrollPaneHospedajes) {
		this.scrollPaneHospedajes = scrollPaneHospedajes;
	}

	public RoundedPanel getJpnHospedajeAReservar() {
		return jpnHospedajeAReservar;
	}

	public void setJpnHospedajeAReservar(RoundedPanel jpnHospedajeAReservar) {
		this.jpnHospedajeAReservar = jpnHospedajeAReservar;
	}

	public RoundedPanel getJpnHabitacionAreservar() {
		return jpnHabitacionAreservar;
	}

	public void setJpnHabitacionAreservar(RoundedPanel jpnHabitacionAreservar) {
		this.jpnHabitacionAreservar = jpnHabitacionAreservar;
	}

	public JComboBox<String> getCboNumeroHabitacion() {
		return cboNumeroHabitacion;
	}

	public void setCboNumeroHabitacion(JComboBox<String> cboNumeroHabitacion) {
		this.cboNumeroHabitacion = cboNumeroHabitacion;
	}

	public JComboBox<String> getCboNumeroPersonas() {
		return cboNumeroPersonas;
	}

	public void setCboNumeroPersonas(JComboBox<String> cboNumeroPersonas) {
		this.cboNumeroPersonas = cboNumeroPersonas;
	}

	public JComboBox<String> getCboNumeroNoches() {
		return cboNumeroNoches;
	}

	public void setCboNumeroNoches(JComboBox<String> cboNumeroNoches) {
		this.cboNumeroNoches = cboNumeroNoches;
	}

	public RoundButton getBtnFecha() {
		return btnFecha;
	}

	public void setBtnFecha(RoundButton btnFecha) {
		this.btnFecha = btnFecha;
	}

	public JDateChooser getDataChooserIngreso() {
		return dataChooserIngreso;
	}

	public void setDataChooserIngreso(JDateChooser dataChooserIngreso) {
		this.dataChooserIngreso = dataChooserIngreso;
	}

	public RoundButton getBtnPagar() {
		return btnPagar;
	}

	public void setBtnPagar(RoundButton btnPagar) {
		this.btnPagar = btnPagar;
	}

	public RoundButton getBtnCrearReserva() {
		return btnCrearReserva;
	}

	public void setBtnCrearReserva(RoundButton btnCrearReserva) {
		this.btnCrearReserva = btnCrearReserva;
	}

	public RoundedPanel getJpnReservaDeFondo() {
		return jpnReservaDeFondo;
	}

	public void setJpnReservaDeFondo(RoundedPanel jpnReservaDeFondo) {
		this.jpnReservaDeFondo = jpnReservaDeFondo;
	}
	
	


	public RoundButton getRndbtnHospedajes() {
		return rndbtnHospedajes;
	}

	public void setRndbtnHospedajes(RoundButton rndbtnHospedajes) {
		this.rndbtnHospedajes = rndbtnHospedajes;
	}

	public RoundedPanel mostrarPanelHabitacionesDisponibles(String tH, int capacidad, boolean disponibilidad,
			int numeroHabitacion, double precioAdicionalPorTipoHabitacion, String imagen) {
		JLabel lblHabitacionesDisponibles = new JLabel("Habitaciones disponibles");
		lblHabitacionesDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabitacionesDisponibles.setForeground(new Color(0, 0, 0));
		lblHabitacionesDisponibles.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 24));
		lblHabitacionesDisponibles.setBounds(0, 0, 801, 48);
		jpnHabitaciones.add(lblHabitacionesDisponibles);

		RoundedPanel jpnCardHabitacionesDisponibles = new RoundedPanel(50);
		jpnCardHabitacionesDisponibles.setLayout(null);
		jpnCardHabitacionesDisponibles.setBackground(new Color(51, 26, 108));

		JPanel jpnImagen = new JPanel();
		jpnImagen.setLayout(null);
		jpnImagen.setBounds(10, 46, 249, 96);
		jpnCardHabitacionesDisponibles.add(jpnImagen);

		JLabel lblImagenHabitacion_1 = new JLabel("");
		lblImagenHabitacion_1.setIcon(new ImageIcon(ViewReserva.class.getResource(imagen)));
		lblImagenHabitacion_1.setBounds(0, 0, 249, 96);
		jpnImagen.add(lblImagenHabitacion_1);

		JLabel lblTipoHabitacion_1 = new JLabel("Tipo: " + tH);
		lblTipoHabitacion_1.setForeground(new Color(255, 255, 255));
		lblTipoHabitacion_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoHabitacion_1.setFont(new Font("Open Sans SemiBold", Font.BOLD, 16));
		lblTipoHabitacion_1.setBounds(0, 0, 269, 47);
		jpnCardHabitacionesDisponibles.add(lblTipoHabitacion_1);

		JLabel lblCapacidad_1 = new JLabel("Capacidad: " + capacidad);
		lblCapacidad_1.setForeground(new Color(255, 255, 255));
		lblCapacidad_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCapacidad_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 14));
		lblCapacidad_1.setBounds(10, 140, 249, 47);
		jpnCardHabitacionesDisponibles.add(lblCapacidad_1);
		String disponibilidad1 = "";
		if (disponibilidad) {
			disponibilidad1 = "Si";
		} else {
			disponibilidad1 = "No";
		}
		JLabel lblDisponible_1 = new JLabel("Disponible: " + disponibilidad1);
		lblDisponible_1.setForeground(new Color(255, 255, 255));
		lblDisponible_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisponible_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 14));
		lblDisponible_1.setBounds(10, 183, 249, 47);
		jpnCardHabitacionesDisponibles.add(lblDisponible_1);

		JLabel lblNumeroDeHabitacion_1 = new JLabel("Numero de habitación: " + numeroHabitacion);
		lblNumeroDeHabitacion_1.setForeground(new Color(255, 255, 255));
		lblNumeroDeHabitacion_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroDeHabitacion_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 14));
		lblNumeroDeHabitacion_1.setBounds(10, 231, 249, 47);
		jpnCardHabitacionesDisponibles.add(lblNumeroDeHabitacion_1);

		JLabel lblPrecioAdicional_1 = new JLabel("Precio adicional: $" + precioAdicionalPorTipoHabitacion);
		lblPrecioAdicional_1.setForeground(new Color(255, 255, 255));
		lblPrecioAdicional_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioAdicional_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 14));
		lblPrecioAdicional_1.setBounds(10, 278, 259, 47);
		jpnCardHabitacionesDisponibles.add(lblPrecioAdicional_1);

		return jpnCardHabitacionesDisponibles;
	}

	public RoundedPanel mostrarPanelHabitacionAreservar(String tH, int capacidad, boolean disponibilidad,
			int numeroHabitacion, double precioAdicionalPorTipoHabitacion, String imagen) {
		RoundedPanel jpnCardHabitacionAreservar = new RoundedPanel(50);
		jpnCardHabitacionAreservar.setLayout(null);
		jpnCardHabitacionAreservar.setBackground(new Color(255, 255, 255));
		jpnCardHabitacionAreservar.setBounds(30, 41, 269, 336);

		JLabel lblHospedajeAReservar_1_1 = new JLabel("Habitación a reservar");
		lblHospedajeAReservar_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospedajeAReservar_1_1.setForeground(Color.WHITE);
		lblHospedajeAReservar_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 24));
		lblHospedajeAReservar_1_1.setBounds(0, 0, 327, 48);
		jpnHabitacionAreservar.add(lblHospedajeAReservar_1_1);

		JPanel jpnImagenHabitacion = new JPanel();
		jpnImagenHabitacion.setBounds(10, 46, 249, 96);
		jpnCardHabitacionAreservar.add(jpnImagenHabitacion);
		jpnImagenHabitacion.setLayout(null);

		JLabel lblImagenHabitacion = new JLabel("");
		lblImagenHabitacion.setBounds(39, 0, 249, 96);
		jpnImagenHabitacion.add(lblImagenHabitacion);

		lblImagenHabitacion.setIcon(new ImageIcon(ViewReserva.class.getResource(imagen)));

		JLabel lblTipoHabitacion = new JLabel("Tipo: " + tH);
		lblTipoHabitacion.setFont(new Font("Open Sans SemiBold", Font.BOLD, 16));
		lblTipoHabitacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoHabitacion.setBounds(0, 0, 269, 47);
		jpnCardHabitacionAreservar.add(lblTipoHabitacion);

		JLabel lblCapacidad = new JLabel("Capacidad: " + capacidad);
		lblCapacidad.setHorizontalAlignment(SwingConstants.LEFT);
		lblCapacidad.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 14));
		lblCapacidad.setBounds(10, 140, 249, 47);
		jpnCardHabitacionAreservar.add(lblCapacidad);
		String disponibilidad1 = "";
		if (disponibilidad) {
			disponibilidad1 = "Si";
		} else {
			disponibilidad1 = "No";
		}

		JLabel lblDisponible = new JLabel("Disponible:" + disponibilidad1);
		lblDisponible.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisponible.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 14));
		lblDisponible.setBounds(10, 183, 249, 47);
		jpnCardHabitacionAreservar.add(lblDisponible);

		JLabel lblNumeroDeHabitacion = new JLabel("Numero de habitación:" + numeroHabitacion);
		lblNumeroDeHabitacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroDeHabitacion.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 14));
		lblNumeroDeHabitacion.setBounds(10, 231, 249, 47);
		jpnCardHabitacionAreservar.add(lblNumeroDeHabitacion);

		JLabel lblPrecioAdicional = new JLabel("Precio adicional: $" + precioAdicionalPorTipoHabitacion);
		lblPrecioAdicional.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioAdicional.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 14));
		lblPrecioAdicional.setBounds(10, 278, 259, 47);
		jpnCardHabitacionAreservar.add(lblPrecioAdicional);

		return jpnCardHabitacionAreservar;
	}

	public RoundedPanel mostrarPanelHospedaje(String tH, String nombre, String ubicacionCiudad, String ubicacionPais,
			int numeroEstrellas, String descripcion, String tipo, double precioPorPersona, String imagen) {
		RoundedPanel jpnCardHospedaje = new RoundedPanel(50);

		jpnCardHospedaje.setBackground(new Color(230, 230, 230));
		jpnCardHospedaje.setLayout(null);

		lblHospedajeAReservar = new JLabel("Hospedaje  a reservar");
		lblHospedajeAReservar.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospedajeAReservar.setForeground(Color.WHITE);
		lblHospedajeAReservar.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 24));
		lblHospedajeAReservar.setBounds(0, 0, 327, 48);
		jpnHospedajeAReservar.add(lblHospedajeAReservar);

		JPanel jpnImagen = new JPanel();
		jpnImagen.setBounds(20, 28, 238, 130);
		jpnCardHospedaje.add(jpnImagen);
		jpnImagen.setLayout(null);

		JLabel lblImagenHospedaje = new JLabel("");
		lblImagenHospedaje.setIcon(new ImageIcon(ViewHospedaje.class.getResource(imagen)));
		lblImagenHospedaje.setBounds(0, 0, 238, 130);
		jpnImagen.add(lblImagenHospedaje);

		JLabel lblTipoHospedaje = new JLabel(tH);
		lblTipoHospedaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoHospedaje.setForeground(Color.BLACK);
		lblTipoHospedaje.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblTipoHospedaje.setBounds(0, 0, 127, 31);
		jpnCardHospedaje.add(lblTipoHospedaje);

		JLabel lblNombreHospedaje = new JLabel(nombre);
		lblNombreHospedaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreHospedaje.setForeground(Color.BLACK);
		lblNombreHospedaje.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNombreHospedaje.setBounds(0, 153, 258, 31);
		jpnCardHospedaje.add(lblNombreHospedaje);

		JLabel lblPais = new JLabel(ubicacionPais);
		lblPais.setHorizontalAlignment(SwingConstants.LEFT);
		lblPais.setForeground(Color.BLACK);
		lblPais.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 12));
		lblPais.setBounds(2, 181, 100, 31);
		jpnCardHospedaje.add(lblPais);

		JLabel lblCiudad = new JLabel(ubicacionCiudad);
		lblCiudad.setHorizontalAlignment(SwingConstants.LEFT);
		lblCiudad.setForeground(Color.BLACK);
		lblCiudad.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 12));
		lblCiudad.setBounds(96, 181, 105, 31);
		jpnCardHospedaje.add(lblCiudad);

		JLabel lblCantidadDeEstrellas = new JLabel(" Cantidad de estrellas: " + numeroEstrellas);
		lblCantidadDeEstrellas.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadDeEstrellas.setForeground(Color.BLACK);
		lblCantidadDeEstrellas.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 12));
		lblCantidadDeEstrellas.setBounds(2, 211, 155, 31);
		jpnCardHospedaje.add(lblCantidadDeEstrellas);

		JLabel lblDescripcion = new JLabel(descripcion);
		lblDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescripcion.setForeground(Color.BLACK);
		lblDescripcion.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 10));
		lblDescripcion.setBounds(0, 235, 260, 45);
		jpnCardHospedaje.add(lblDescripcion);

		JLabel lblTipo1 = new JLabel("tipo: " + tipo);
		lblTipo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo1.setForeground(Color.BLACK);
		lblTipo1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblTipo1.setBounds(160, 0, 100, 31);
		jpnCardHospedaje.add(lblTipo1);

		JLabel lblPrecioPorPersonaTexto_1 = new JLabel("Precio por persona: $" + precioPorPersona);
		lblPrecioPorPersonaTexto_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioPorPersonaTexto_1.setForeground(Color.BLACK);
		lblPrecioPorPersonaTexto_1.setFont(new Font("Open Sans SemiBold", Font.BOLD, 14));
		lblPrecioPorPersonaTexto_1.setBounds(2, 277, 238, 45);
		jpnCardHospedaje.add(lblPrecioPorPersonaTexto_1);
		return jpnCardHospedaje;
	}

	public RoundedPanel crearReserva(String nombre, String apellido, int id, String email, long numeroTelefono,
			Date fechaEntrada, Date fechaSalida, String tipoHospedaje, String nombreHospedaje, String ciudad,
			String pais, String tipoHabitacion, int numeroHabitacion, int cantidadPersonas, int numeroNoches,
			double precioPorPersona, double precioAdicionalPorTipoHabitacion, double subTotal, double precioTotal) {
		RoundedPanel jpnReserva = new RoundedPanel(50);
		jpnReserva.setLayout(null);
		jpnReserva.setBackground(new Color(16, 6, 38));
		jpnReserva.setBounds(10, 167, 543, 652);

		JLabel lblApellido = new JLabel("Apellido: " + apellido);
		lblApellido.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblApellido.setBounds(0, 30, 505, 48);
		jpnReserva.add(lblApellido);

		JLabel lblEmail = new JLabel("Email: " + email);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblEmail.setBounds(0, 59, 505, 48);
		jpnReserva.add(lblEmail);

		JLabel lblNumeroTelefono = new JLabel("Numero Telefono: " + numeroTelefono);
		lblNumeroTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroTelefono.setForeground(Color.WHITE);
		lblNumeroTelefono.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNumeroTelefono.setBounds(0, 89, 505, 48);
		jpnReserva.add(lblNumeroTelefono);

		JLabel lblFechaDeEntrada = new JLabel("Fecha de entrada: " + fechaEntrada);
		lblFechaDeEntrada.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaDeEntrada.setForeground(Color.WHITE);
		lblFechaDeEntrada.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblFechaDeEntrada.setBounds(0, 118, 533, 48);
		jpnReserva.add(lblFechaDeEntrada);

		JLabel lblFechaSalida = new JLabel("Fecha salida: " + fechaSalida);
		lblFechaSalida.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaSalida.setForeground(Color.WHITE);
		lblFechaSalida.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblFechaSalida.setBounds(0, 148, 505, 48);
		jpnReserva.add(lblFechaSalida);

		JLabel lblTipoHospedaje = new JLabel("Tipo hospedaje: " + tipoHospedaje);
		lblTipoHospedaje.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoHospedaje.setForeground(Color.WHITE);
		lblTipoHospedaje.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblTipoHospedaje.setBounds(0, 178, 505, 48);
		jpnReserva.add(lblTipoHospedaje);

		JLabel lblNombre = new JLabel("Nombre: " + nombre);
		lblNombre.setBounds(0, 0, 505, 48);
		jpnReserva.add(lblNombre);
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));

		JLabel lblNombreHospedaje = new JLabel("Nombre Hospedaje: " + nombreHospedaje);
		lblNombreHospedaje.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreHospedaje.setForeground(Color.WHITE);
		lblNombreHospedaje.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNombreHospedaje.setBounds(0, 207, 505, 48);
		jpnReserva.add(lblNombreHospedaje);

		JLabel lblCiudad = new JLabel("Ciudad: " + ciudad);
		lblCiudad.setHorizontalAlignment(SwingConstants.LEFT);
		lblCiudad.setForeground(Color.WHITE);
		lblCiudad.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblCiudad.setBounds(0, 238, 505, 48);
		jpnReserva.add(lblCiudad);

		JLabel lblPais = new JLabel("Pais: " + pais);
		lblPais.setHorizontalAlignment(SwingConstants.LEFT);
		lblPais.setForeground(Color.WHITE);
		lblPais.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblPais.setBounds(0, 266, 505, 48);
		jpnReserva.add(lblPais);

		JLabel lblTipoHabitacion = new JLabel("Tipo Habitacion: " + tipoHabitacion);
		lblTipoHabitacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoHabitacion.setForeground(Color.WHITE);
		lblTipoHabitacion.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblTipoHabitacion.setBounds(0, 297, 505, 48);
		jpnReserva.add(lblTipoHabitacion);

		JLabel lblNumeroHabitacion = new JLabel("Numero Habitacion: " + numeroHabitacion);
		lblNumeroHabitacion.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroHabitacion.setForeground(Color.WHITE);
		lblNumeroHabitacion.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNumeroHabitacion.setBounds(0, 325, 505, 48);
		jpnReserva.add(lblNumeroHabitacion);

		JLabel lblCantidadPersonas = new JLabel("Cantidad Personas: " + cantidadPersonas);
		lblCantidadPersonas.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantidadPersonas.setForeground(Color.WHITE);
		lblCantidadPersonas.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblCantidadPersonas.setBounds(0, 356, 505, 48);
		jpnReserva.add(lblCantidadPersonas);

		JLabel lblNumeroNoches = new JLabel("Numero Noches: " + numeroNoches);
		lblNumeroNoches.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroNoches.setForeground(Color.WHITE);
		lblNumeroNoches.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNumeroNoches.setBounds(0, 384, 505, 48);
		jpnReserva.add(lblNumeroNoches);

		JLabel lblPrecioPorPersona = new JLabel("Precio por Persona: " + precioPorPersona);
		lblPrecioPorPersona.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecioPorPersona.setForeground(Color.WHITE);
		lblPrecioPorPersona.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblPrecioPorPersona.setBounds(0, 415, 505, 48);
		jpnReserva.add(lblPrecioPorPersona);

		JLabel lblNumeroNoches_1 = new JLabel(
				"precio adicional por tipo de habitacion: " + precioAdicionalPorTipoHabitacion);
		lblNumeroNoches_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroNoches_1.setForeground(Color.WHITE);
		lblNumeroNoches_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNumeroNoches_1.setBounds(0, 443, 505, 48);
		jpnReserva.add(lblNumeroNoches_1);

		JLabel lblNumeroNoches_3 = new JLabel("Subtotal: " + subTotal);
		lblNumeroNoches_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroNoches_3.setForeground(Color.WHITE);
		lblNumeroNoches_3.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 16));
		lblNumeroNoches_3.setBounds(0, 474, 505, 48);
		jpnReserva.add(lblNumeroNoches_3);

		JLabel lblNumeroNoches_4 = new JLabel("Precio Total: " + precioTotal);
		lblNumeroNoches_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroNoches_4.setForeground(Color.WHITE);
		lblNumeroNoches_4.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 22));
		lblNumeroNoches_4.setBounds(0, 502, 505, 48);
		jpnReserva.add(lblNumeroNoches_4);
		btnPagar = new RoundButton("Registrarse");
		btnPagar.setText("Pagar");
		btnPagar.setForeground(new Color(16, 6, 38));
		btnPagar.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
		btnPagar.setBorderPainted(false);
		btnPagar.setBackground(Color.WHITE);
		btnPagar.setBounds(172, 561, 207, 48);
		jpnReserva.add(btnPagar);
		return jpnReserva;
	}

	public String pedirNombreHospedaje() {

		String nombre = "";
		boolean nombreValido = false;

		try {

			nombre = txtNombreHospedajeAReservar.getText();

			if (nombre.isEmpty()) {
				throw new Exception("El campo de nombre  no puede estar vacío.");

			}

			if (nombre.matches("[a-zA-ZñÑ ]+")) {
				nombreValido = true;

			} else {
				throw new Exception("Ingrese un  nombre válido (solo letras).");

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}

		return nombre;
	}
}
