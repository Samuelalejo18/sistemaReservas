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

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import co.edu.konradlorenz.controller.ControllerAutenticacion;
import co.edu.konradlorenz.model.cliente.Cliente;

public class ViewReserva extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel jpnInfo;
	private RoundedPanel jpnBackGround;
	private RoundButton btnCerrarSesion;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private RoundedTextField txtNombreHospedajeAReservar;
	private RoundedPanel jpnHospedajeAReservar;
	private RoundedPanel jpnHospedajes;
	private RoundButtonCircle btnBuscarNombre;
	private JScrollPane scrollPaneHospedajes;
	private RoundedPanel jpnFiltrosCiudades_1;
	private JPanel jpnUsuario;
	private JLabel lblNameUsuario;
	private JLabel lblHabitacionesDisponibles;
	private JLabel lblNumeroDeLa;

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

		JPanel jpnSuperiorCentro = new JPanel();
		jpnSuperiorCentro.setBackground(new Color(16, 6, 38));
		jpnSuperiorCentro.setBounds(419, 0, 584, 120);
		jpnInfo.add(jpnSuperiorCentro);
		jpnSuperiorCentro.setLayout(null);

		jpnFiltrosCiudades_1 = new RoundedPanel(20);
		jpnFiltrosCiudades_1.setBounds(123, 72, 340, 7);
		jpnSuperiorCentro.add(jpnFiltrosCiudades_1);
		jpnFiltrosCiudades_1.setLayout(null);
		jpnFiltrosCiudades_1.setBackground(Color.WHITE);

		JLabel lblNewLabel_8 = new JLabel("Gracias por reservar con nosotros");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBackground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(0, 0, 584, 120);
		jpnSuperiorCentro.add(lblNewLabel_8);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(
				new ImageIcon(ViewHospedaje.class.getResource("/imagenes/Captura de pantalla 2024-05-21 003128.png")));
		lblNewLabel_4.setBounds(58, 0, 719, 120);
		jpnInfo.add(lblNewLabel_4);

		jpnUsuario = new JPanel();
		jpnUsuario.setBackground(new Color(16, 6, 38));
		jpnUsuario.setBounds(1003, 1, 505, 120);
		jpnInfo.add(jpnUsuario);
		jpnUsuario.setLayout(null);

		btnCerrarSesion = new RoundButton("Registrarse");
		btnCerrarSesion.setBounds(128, 37, 207, 48);
		jpnUsuario.add(btnCerrarSesion);
		btnCerrarSesion.setText("Cerrar Sesión");
		btnCerrarSesion.setBorderPainted(false);
		btnCerrarSesion.setBackground(new Color(255, 255, 255));
		btnCerrarSesion.setForeground(new Color(16, 6, 38));
		btnCerrarSesion.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(372, 0, 101, 120);
		jpnUsuario.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(ViewAutenticacion.class.getResource("/imagenes/flechas-a-la-derecha.png")));

		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

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
		jpnHospedajeAReservar = new RoundedPanel(50);
		jpnHospedajeAReservar.setBackground(new Color(179, 170, 255));
		jpnHospedajeAReservar.setBounds(40, 34, 307, 819);
		jpnBackGround.add(jpnHospedajeAReservar);
		jpnHospedajeAReservar.setLayout(null);
				
						btnBuscarNombre = new RoundButtonCircle("");
						btnBuscarNombre.setBounds(245, 63, 36, 36);
						jpnHospedajeAReservar.add(btnBuscarNombre);
						btnBuscarNombre.setIcon(new ImageIcon(ViewHospedaje.class.getResource("/imagenes/lupa.png")));
						btnBuscarNombre.setBackground(new Color(16, 6, 38));
						
								txtNombreHospedajeAReservar = new RoundedTextField(50, 50);
								txtNombreHospedajeAReservar.setBounds(10, 57, 287, 47);
								jpnHospedajeAReservar.add(txtNombreHospedajeAReservar);
								txtNombreHospedajeAReservar.setHorizontalAlignment(SwingConstants.CENTER);
								txtNombreHospedajeAReservar.setFont(new Font("Open Sans", Font.PLAIN, 16));
								txtNombreHospedajeAReservar.setColumns(10);
								
								JLabel lblBuscaElNombre = new JLabel("Nombre del hospedaje a reservar");
								lblBuscaElNombre.setBounds(0, 11, 307, 48);
								jpnHospedajeAReservar.add(lblBuscaElNombre);
								lblBuscaElNombre.setHorizontalAlignment(SwingConstants.CENTER);
								lblBuscaElNombre.setForeground(new Color(0, 0, 0));
								lblBuscaElNombre.setFont(new Font("Open Sans SemiBold", Font.BOLD, 18));
								
								lblNumeroDeLa = new JLabel("Número de la habitacion ");
								lblNumeroDeLa.setHorizontalAlignment(SwingConstants.CENTER);
								lblNumeroDeLa.setForeground(new Color(0, 0, 0));
								lblNumeroDeLa.setFont(new Font("Open Sans SemiBold", Font.BOLD, 20));
								lblNumeroDeLa.setBounds(10, 110, 307, 48);
								jpnHospedajeAReservar.add(lblNumeroDeLa);
								
								JComboBox cboEstrellas = new JComboBox();
								cboEstrellas.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "28", "29", "30"}));
								cboEstrellas.setOpaque(false);
								cboEstrellas.setForeground(Color.WHITE);
								cboEstrellas.setFont(new Font("Open Sans", Font.BOLD, 20));
								cboEstrellas.setFocusable(false);
								cboEstrellas.setFocusTraversalKeysEnabled(false);
								cboEstrellas.setBackground(new Color(51, 26, 108));
								cboEstrellas.setBounds(46, 166, 217, 47);
								jpnHospedajeAReservar.add(cboEstrellas);
								
								JLabel lblNumeroDePersonas = new JLabel("Número de personas");
								lblNumeroDePersonas.setHorizontalAlignment(SwingConstants.CENTER);
								lblNumeroDePersonas.setForeground(Color.BLACK);
								lblNumeroDePersonas.setFont(new Font("Open Sans SemiBold", Font.BOLD, 20));
								lblNumeroDePersonas.setBounds(0, 224, 307, 48);
								jpnHospedajeAReservar.add(lblNumeroDePersonas);
								
								JComboBox cboEstrellas_1 = new JComboBox();
								cboEstrellas_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
								cboEstrellas_1.setOpaque(false);
								cboEstrellas_1.setForeground(Color.WHITE);
								cboEstrellas_1.setFont(new Font("Open Sans", Font.BOLD, 20));
								cboEstrellas_1.setFocusable(false);
								cboEstrellas_1.setFocusTraversalKeysEnabled(false);
								cboEstrellas_1.setBackground(new Color(51, 26, 108));
								cboEstrellas_1.setBounds(46, 284, 217, 47);
								jpnHospedajeAReservar.add(cboEstrellas_1);
								
								JLabel lblNumeroDeNoches = new JLabel("Número de noches");
								lblNumeroDeNoches.setHorizontalAlignment(SwingConstants.CENTER);
								lblNumeroDeNoches.setForeground(Color.BLACK);
								lblNumeroDeNoches.setFont(new Font("Open Sans SemiBold", Font.BOLD, 20));
								lblNumeroDeNoches.setBounds(0, 347, 307, 48);
								jpnHospedajeAReservar.add(lblNumeroDeNoches);
								
								JComboBox cboEstrellas_1_1 = new JComboBox();
								cboEstrellas_1_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
								cboEstrellas_1_1.setOpaque(false);
								cboEstrellas_1_1.setForeground(Color.WHITE);
								cboEstrellas_1_1.setFont(new Font("Open Sans", Font.BOLD, 20));
								cboEstrellas_1_1.setFocusable(false);
								cboEstrellas_1_1.setFocusTraversalKeysEnabled(false);
								cboEstrellas_1_1.setBackground(new Color(51, 26, 108));
								cboEstrellas_1_1.setBounds(46, 395, 217, 47);
								jpnHospedajeAReservar.add(cboEstrellas_1_1);
		// Main panel with rounded corners inside the scroll pane
		jpnHospedajes = new RoundedPanel(50);
		jpnHospedajes.setBackground(new Color(255, 255, 255));
		jpnHospedajes.setLayout(null);

		// Scroll pane containing the main panel
		scrollPaneHospedajes = new CustomScrollPane(jpnHospedajes, 50);
		;
		scrollPaneHospedajes.setBorder(null);
		scrollPaneHospedajes.setBounds(368, 34, 1368, 400); // Set bounds for the scroll pane
		scrollPaneHospedajes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPaneHospedajes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jpnBackGround.add(scrollPaneHospedajes);
		
		RoundedPanel jpnHospedajeAReservar_1 = new RoundedPanel(50);
		jpnHospedajeAReservar_1.setLayout(null);
		jpnHospedajeAReservar_1.setBackground(new Color(179, 170, 255));
		jpnHospedajeAReservar_1.setBounds(368, 453, 327, 400);
		jpnBackGround.add(jpnHospedajeAReservar_1);
		
		JLabel lblHospedajeAReservar_1_1_1 = new JLabel("Hospedaje a reservar");
		lblHospedajeAReservar_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospedajeAReservar_1_1_1.setForeground(Color.WHITE);
		lblHospedajeAReservar_1_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 24));
		lblHospedajeAReservar_1_1_1.setBounds(0, 0, 327, 48);
		jpnHospedajeAReservar_1.add(lblHospedajeAReservar_1_1_1);
		
		RoundedPanel jpnHospedajeAReservar_1_1 = new RoundedPanel(50);
		jpnHospedajeAReservar_1_1.setLayout(null);
		jpnHospedajeAReservar_1_1.setBackground(new Color(179, 170, 255));
		jpnHospedajeAReservar_1_1.setBounds(723, 453, 327, 400);
		jpnBackGround.add(jpnHospedajeAReservar_1_1);
		
		JLabel lblHospedajeAReservar_1_1 = new JLabel("Habitacion a reservar");
		lblHospedajeAReservar_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospedajeAReservar_1_1.setForeground(Color.WHITE);
		lblHospedajeAReservar_1_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 24));
		lblHospedajeAReservar_1_1.setBounds(0, 0, 327, 48);
		jpnHospedajeAReservar_1_1.add(lblHospedajeAReservar_1_1);

		// Example card panel with rounded corners inside the main panel

		// Set preferred size for jpnHospedajes to enable scrolling
		jpnHospedajes.setPreferredSize(new Dimension(1432, 4000));
		
		lblHabitacionesDisponibles = new JLabel("Habitaciones disponibles");
		lblHabitacionesDisponibles.setHorizontalAlignment(SwingConstants.CENTER);
		lblHabitacionesDisponibles.setForeground(new Color(0, 0, 0));
		lblHabitacionesDisponibles.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 24));
		lblHabitacionesDisponibles.setBounds(0, 0, 1366, 48);
		jpnHospedajes.add(lblHabitacionesDisponibles);
		
		RoundedPanel jpnHospedajeAReservar_2 = new RoundedPanel(50);
		jpnHospedajeAReservar_2.setLayout(null);
		jpnHospedajeAReservar_2.setBackground(new Color(179, 170, 255));
		jpnHospedajeAReservar_2.setBounds(28, 47, 307, 328);
		jpnHospedajes.add(jpnHospedajeAReservar_2);
		
		JLabel lblHospedajeAReservar_1 = new JLabel("Hospedaje a reservar");
		lblHospedajeAReservar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospedajeAReservar_1.setForeground(Color.WHITE);
		lblHospedajeAReservar_1.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 24));
		lblHospedajeAReservar_1.setBounds(0, 0, 307, 48);
		jpnHospedajeAReservar_2.add(lblHospedajeAReservar_1);

		// Cargar y redimensionar la imagen
		try {
			BufferedImage originalImage = ImageIO.read(ViewAutenticacion.class.getResource("/imagenes/show.png"));

		} catch (IOException e2) {
			e2.printStackTrace();
		}

	}
}
