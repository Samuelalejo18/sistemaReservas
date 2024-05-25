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

public class ViewContactanos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel jpnInfo;
	private RoundedPanel jpnLogin;
	private JPanel jpnBuscaComparaReserva;
	private JLabel lblNewLabel;
	private RoundButton btnWhats;
	private JLabel lblNewLabel_2;
	private JButton btnHospedajes;
	private JButton btnNosotros;
	private JButton btnContactanos;
	private RoundButton btnIniciarSesion;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;


	/**
	 * Create the frame.
	 */
	public ViewContactanos() {
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
		
		RoundedPanel jpnFiltrosCiudades_1_1 = new RoundedPanel(20);
		jpnFiltrosCiudades_1_1.setLayout(null);
		jpnFiltrosCiudades_1_1.setBackground(Color.WHITE);
		jpnFiltrosCiudades_1_1.setBounds(203, 87, 140, 7);
		jpnSuperiorCentro.add(jpnFiltrosCiudades_1_1);

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
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(ViewContactanos.class.getResource("/imagenes/imgContactanos.png")));
		lblNewLabel_6.setBounds(573, 0, 492, 613);
		jpnLogin.add(lblNewLabel_6);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(ViewContactanos.class.getResource("/imagenes/FacebookLogo.png")));
		lblNewLabel_5.setBounds(190, 342, 46, 35);
		jpnLogin.add(lblNewLabel_5);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ViewContactanos.class.getResource("/imagenes/IgLogo.png")));
		lblNewLabel_1.setBounds(343, 260, 30, 38);
		jpnLogin.add(lblNewLabel_1);
		jpnBuscaComparaReserva = new RoundedPanel(20);
		jpnBuscaComparaReserva.setBounds(69, 72, 244, 32);
		jpnBuscaComparaReserva.setBackground(new Color(179, 170, 255));
		jpnLogin.add(jpnBuscaComparaReserva);
		jpnBuscaComparaReserva.setLayout(null);
		
				lblNewLabel = new JLabel("#BuscaComparaReserva");
				lblNewLabel.setBounds(0, 0, 244, 32);
				jpnBuscaComparaReserva.add(lblNewLabel);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 14));
		
		JLabel lblFirstxt = new JLabel("<html>Nuestros Canales --------------<br>-------------- De Comunicación</html>");
		lblFirstxt.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstxt.setForeground(Color.WHITE);
		lblFirstxt.setFont(new Font("Open Sans", Font.BOLD, 30));
		lblFirstxt.setBounds(0, 120, 500, 90);
		jpnLogin.add(lblFirstxt);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ViewContactanos.class.getResource("/imagenes/WhatsAppLogo.png")));
		lblNewLabel_4.setBounds(45, 260, 30, 38);
		jpnLogin.add(lblNewLabel_4);
		
		RoundButton btnFace = new RoundButton("Registrarse");
		btnFace.setText("@JCA HOTELS S.A.S");
		btnFace.setForeground(new Color(16, 6, 38));
		btnFace.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
		btnFace.setBorderPainted(false);
		btnFace.setBackground(Color.WHITE);
		btnFace.setBounds(173, 336, 278, 48);
		jpnLogin.add(btnFace);
		
				btnWhats = new RoundButton("Registrarse");
				btnWhats.setText("+57 310 5028796");
				btnWhats.setBounds(24, 255, 252, 48);
				jpnLogin.add(btnWhats);
				btnWhats.setBorderPainted(false);
				btnWhats.setBackground(new Color(255, 255, 255));
				btnWhats.setForeground(new Color(16, 6, 38));
				btnWhats.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
				
				RoundButton btnInsta = new RoundButton("Registrarse");
				btnInsta.setText("@JCAHOTELS_");
				btnInsta.setForeground(new Color(16, 6, 38));
				btnInsta.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
				btnInsta.setBorderPainted(false);
				btnInsta.setBackground(Color.WHITE);
				btnInsta.setBounds(329, 255, 234, 48);
				jpnLogin.add(btnInsta);
	}

	public JButton getBtnHospedajes() {
		return btnHospedajes;
	}

	public void setBtnHospedajes(JButton btnHospedajes) {
		this.btnHospedajes = btnHospedajes;
	}

	public JButton getBtnNosotros() {
		return btnNosotros;
	}

	public void setBtnNosotros(JButton btnNosotros) {
		this.btnNosotros = btnNosotros;
	}

	public RoundButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(RoundButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}
	
	
}
