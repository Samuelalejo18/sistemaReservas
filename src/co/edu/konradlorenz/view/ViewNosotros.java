package co.edu.konradlorenz.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ViewNosotros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel jpnInfo;
	private RoundedPanel jpnLogin;
	private JPanel jpnBuscaComparaReserva;
	private JLabel lblNewLabel;
	private RoundButton btnRegistrar;
	private JLabel lblNewLabel_2;
	private JButton btnHospedajes;
	private JButton btnNosotros;
	private JButton btnContactanos;
	private JLabel lblFirstxt;
	private JLabel lblTextInfo;
	private JLabel lblNewLabel_1;
	private RoundButton btnIniciarSesion;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ViewNosotros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(16, 6, 38));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setResizable(false);
		this.setSize(1280, 800);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jpnInfo = new JPanel();
		jpnInfo.setBackground(new Color(16, 6, 38));
		jpnInfo.setBounds(0, 0, 1904, 120);
		contentPane.add(jpnInfo);
		jpnInfo.setLayout(null);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(1084, 0, 101, 120);
		jpnInfo.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(ViewAutenticacion.class.getResource("/imagenes/flechas-a-la-derecha.png")));

		JPanel jpnSuperiorCentro = new JPanel();
		jpnSuperiorCentro.setLayout(null);
		jpnSuperiorCentro.setBackground(new Color(16, 6, 38));
		jpnSuperiorCentro.setBounds(238, 0, 547, 120);
		jpnInfo.add(jpnSuperiorCentro);

		btnContactanos = new JButton("Contáctanos");
		btnContactanos.setForeground(Color.WHITE);
		btnContactanos.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 20));
		btnContactanos.setFocusable(false);
		btnContactanos.setBorderPainted(false);
		btnContactanos.setBackground(new Color(16, 6, 38));
		btnContactanos.setBounds(182, 47, 172, 37);
		jpnSuperiorCentro.add(btnContactanos);

		btnNosotros = new JButton("Nosotros");
		btnNosotros.setForeground(Color.WHITE);
		btnNosotros.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 20));
		btnNosotros.setFocusable(false);
		btnNosotros.setBorderPainted(false);
		btnNosotros.setBackground(new Color(16, 6, 38));
		btnNosotros.setBounds(375, 47, 172, 37);
		jpnSuperiorCentro.add(btnNosotros);

		btnHospedajes = new JButton("Hospedajes");
		btnHospedajes.setForeground(Color.WHITE);
		btnHospedajes.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 20));
		btnHospedajes.setFocusable(false);
		btnHospedajes.setBorderPainted(false);
		btnHospedajes.setBackground(new Color(16, 6, 38));
		btnHospedajes.setBounds(0, 47, 172, 37);
		jpnSuperiorCentro.add(btnHospedajes);

		RoundedPanel jpnFiltrosCiudades_1 = new RoundedPanel(20);
		jpnFiltrosCiudades_1.setLayout(null);
		jpnFiltrosCiudades_1.setBackground(Color.WHITE);
		jpnFiltrosCiudades_1.setBounds(390, 87, 140, 7);
		jpnSuperiorCentro.add(jpnFiltrosCiudades_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(
				ViewAutenticacion.class.getResource("/imagenes/Captura de pantalla 2024-05-21 003128.png")));
		lblNewLabel_3.setBounds(26, 0, 312, 120);
		jpnInfo.add(lblNewLabel_3);

		btnIniciarSesion = new RoundButton("Registrarse");
		btnIniciarSesion.setBounds(867, 40, 207, 48);
		jpnInfo.add(btnIniciarSesion);
		btnIniciarSesion.setText("Iniciar Sesión");
		btnIniciarSesion.setForeground(new Color(16, 6, 38));
		btnIniciarSesion.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
		btnIniciarSesion.setBorderPainted(false);
		btnIniciarSesion.setBackground(Color.WHITE);

		jpnLogin = new RoundedPanel(50);
		jpnLogin.setBackground(new Color(51, 26, 108));
		jpnLogin.setBounds(99, 118, 1065, 613);

		contentPane.add(jpnLogin);
		jpnLogin.setLayout(null);

		// Cargar y redimensionar la imagen
		try {
			BufferedImage originalImage = ImageIO.read(ViewAutenticacion.class.getResource("/imagenes/show.png"));

		} catch (IOException e2) {
			e2.printStackTrace();
		}

		lblNewLabel = new JLabel("#BuscaComparaReserva");
		lblNewLabel.setBounds(49, 72, 244, 32);
		jpnLogin.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 14));
		jpnBuscaComparaReserva = new RoundedPanel(20);
		jpnBuscaComparaReserva.setBounds(69, 72, 244, 32);
		jpnBuscaComparaReserva.setBackground(new Color(179, 170, 255));
		jpnLogin.add(jpnBuscaComparaReserva);
		jpnBuscaComparaReserva.setLayout(null);

		lblFirstxt = new JLabel(
				"<html>Viaja Ligero--------------------<br>--------------------Vive la aventura</html>");
		lblFirstxt.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstxt.setForeground(Color.WHITE);
		lblFirstxt.setFont(new Font("Open Sans", Font.BOLD, 30));
		lblFirstxt.setBounds(20, 115, 500, 90);
		jpnLogin.add(lblFirstxt);

		lblTextInfo = new JLabel(
				"<html>Buscamos ofrecer una solución integral para las reservas de alojamiento y servicios de viaje.<br>Buscar, comparar y reservar, asi de fácil, con una amplia gama de opciones, desde hoteles hasta vuelos y cruceros. Simplificamos la planificación de viajes, ahorrando tiempo y reduciendo errores en las reservas. Es una herramienta completa para viajeros, ofreciendo una experiencia completamente satisfactoria</html>");
		lblTextInfo.setForeground(Color.WHITE);
		lblTextInfo.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 20));
		lblTextInfo.setBackground(new Color(16, 6, 38));
		lblTextInfo.setBounds(20, 168, 500, 358);
		jpnLogin.add(lblTextInfo);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ViewNosotros.class.getResource("/imagenes/principal.jpg")));
		lblNewLabel_1.setBounds(472, 0, 537, 613);
		jpnLogin.add(lblNewLabel_1);

		btnRegistrar = new RoundButton("Registrarse");
		btnRegistrar.setText("Inicia hoy mismo");
		btnRegistrar.setBounds(49, 510, 278, 48);
		jpnLogin.add(btnRegistrar);
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setBackground(new Color(255, 255, 255));
		btnRegistrar.setForeground(new Color(16, 6, 38));
		btnRegistrar.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
	}

	public RoundButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(RoundButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	public JButton getBtnHospedajes() {
		return btnHospedajes;
	}

	public void setBtnHospedajes(JButton btnHospedajes) {
		this.btnHospedajes = btnHospedajes;
	}

	public JButton getBtnContactanos() {
		return btnContactanos;
	}

	public void setBtnContactanos(JButton btnContactanos) {
		this.btnContactanos = btnContactanos;
	}

	public RoundButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(RoundButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}
	
	
	
	
}
