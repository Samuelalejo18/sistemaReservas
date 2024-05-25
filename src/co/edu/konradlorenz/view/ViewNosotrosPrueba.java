package co.edu.konradlorenz.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ViewNosotrosPrueba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	private JPanel topPanel;
	private JLabel labelNombre;
	private JLabel logo;
	private RoundButton btnReservar;
	private RoundButton btnContacto;
	private RoundButton btnNosotros;
	private RoundButton btnRegistrarse;
	private JLabel lblHash;
	private JLabel lblFirstxt;
	private JLabel lblTextInfo;
	private JLabel lblLogo;
	private JLabel lblImg;
	private ImageIcon imgBig;

	/**
	 * Create the frame.
	 */
	// Constructor
	public ViewNosotrosPrueba() {

		// Configuración contentPane
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(16, 6, 38));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		// Configuración Panel superior
		topPanel = new JPanel();
		topPanel.setBackground(new Color(16, 6, 38));
		topPanel.setLayout((LayoutManager) new BoxLayout(topPanel, BoxLayout.X_AXIS));
		topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(topPanel, BorderLayout.NORTH);

		// Configuración logo
		String logoPath = "/imagenes/logoCompleto.png";
		if (new java.io.File(logoPath).exists()) {
			ImageIcon originalLogo = new ImageIcon(logoPath);
			Image scaledImage = originalLogo.getImage().getScaledInstance(200, 25, Image.SCALE_SMOOTH);
			lblLogo = new JLabel(new ImageIcon(scaledImage));
			lblLogo.setBorder(new EmptyBorder(0, 50, 0, 0));
			topPanel.add(lblLogo);
		} else {
			System.out.println("La imagen del logo no se encuentra en la ruta especificada");
		}

		// Espaciado horizontal
		topPanel.add(Box.createHorizontalGlue());

		// Configuración de botones
		btnReservar = new RoundButton("Hospedajes");
		btnContacto = new RoundButton("Contactanos");
		btnNosotros = new RoundButton("Nosotros");
		btnRegistrarse = new RoundButton("Registrarse");

		// Se pasan los botones a un metodo que define un estilo en comun
		commonStyleBtn(btnReservar);
		commonStyleBtn(btnContacto);
		commonStyleBtn(btnNosotros);
		styleRegisterBtn(btnRegistrarse);

		topPanel.add(btnReservar);
		topPanel.add(Box.createHorizontalStrut(20));
		topPanel.add(btnContacto);
		topPanel.add(Box.createHorizontalStrut(20));
		topPanel.add(btnNosotros);
		topPanel.add(Box.createHorizontalStrut(20));
		topPanel.add(Box.createHorizontalGlue());
		topPanel.add(btnRegistrarse);
		topPanel.add(Box.createHorizontalStrut(40));

		// Panel principal de contenido
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(16, 6, 38));
		mainPanel.setLayout(null);
		mainPanel.setBorder(new EmptyBorder(100, 0, 0, 0));
		contentPane.add(mainPanel, BorderLayout.CENTER);

		// Texto viaja ligero vive la aventura

		lblFirstxt = new JLabel(
				"<html>Viaja Ligero--------------------<br>--------------------Vive la aventura</html>");
		lblFirstxt.setForeground(Color.WHITE);
		lblFirstxt.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstxt.setFont(new Font("Open Sans Bold", Font.BOLD, 30));
		lblFirstxt.setBounds(70, 130, 500, 90);
		mainPanel.add(lblFirstxt);

		// Texto largo info
		lblTextInfo = new JLabel(
				"<html>Buscamos ofrecer una solución integral para las reservas de alojamiento y servicios de viaje.<br>Buscar, comparar y reservar, asi de fácil, con una amplia gama de opciones, desde hoteles hasta vuelos y cruceros. Simplificamos la planificación de viajes, ahorrando tiempo y reduciendo errores en las reservas. Es una herramienta completa para viajeros, ofreciendo una experiencia completamente satisfactoria</html>");
		lblTextInfo.setForeground(Color.WHITE);
		lblTextInfo.setBackground(new Color(16, 6, 38));
		lblTextInfo.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 20));
		lblTextInfo.setBounds(100, 160, 500, 400);
		mainPanel.add(lblTextInfo);

		// Etiqueta con HashTag
		lblHash = new JLabel("#BuscaCompraReserva");
		lblHash.setBounds(100, 78, 244, 25);
		lblHash.setHorizontalAlignment(SwingConstants.CENTER);
		lblHash.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		lblHash.setBackground(new Color(179, 170, 249));
		lblHash.setOpaque(true);
		mainPanel.add(lblHash);

		// Imagen grande edificios
		String imagePath = "/imagenes/principal.png";

		if (new java.io.File(imagePath).exists()) {
			lblImg = new JLabel(new ImageIcon(imagePath));
			lblImg.setBounds(780, 50, 500, 500);
			mainPanel.add(lblImg);
		} else {
			System.out.println("La imagen principal no se encuentra en la ruta especificada");
		}

		// Boton iniciar
		RoundButton btnInicio = new RoundButton("Inicia hoy mismo ->");
		btnInicio.setBounds(100, 520, 200, 40);
		btnInicio.setBorder(BorderFactory.createEmptyBorder(100, 40, 10, 40));
		btnInicio.setFont(new Font("SansSerif", Font.ROMAN_BASELINE, 15));
		btnInicio.setBorderPainted(false);
		mainPanel.add(btnInicio);
	}

	// Metodos para estilos identicos en botones
	private void commonStyleBtn(RoundButton roundButton) {
		roundButton.setForeground(Color.WHITE);
		roundButton.setBackground(new Color(16, 6, 38));
		roundButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		roundButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		roundButton.setBorderPainted(false);
	}

	private void styleRegisterBtn(RoundButton roundButton) {
		roundButton.setForeground(new Color(29, 0, 51));
		roundButton.setBackground(new Color(255, 255, 255));
		roundButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		roundButton
				.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(29, 0, 51), 2),
						BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		roundButton.setPreferredSize(new Dimension(120, 10));
	}

	
}
