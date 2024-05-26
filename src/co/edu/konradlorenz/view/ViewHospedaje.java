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
import java.util.InputMismatchException;

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

public class ViewHospedaje extends JFrame {

	private JPanel contentPane;
	private JPanel jpnInfo;
	private RoundedPanel jpnBackGround;
	private RoundButton btnReservar;
	private JButton btnNosotros;
	private JButton btnContactanos;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private RoundedTextField txtNombreHospedaje;
	private RoundedPanel jpnFiltrosHospedajes;
	private RoundedPanel jpnFiltrosCiudades;
	private RoundedPanel jpnHospedajes;
	private RoundButtonCircle btnBuscarNombre;
	private RoundButtonCircle btnBuscarCiudad;
	private RoundedPanel jpnLupa;

	private JLabel lblHoteles;
	private RoundButtonCircle btnBuscarPais;
	private RoundedTextField txtCiudadHospedaje;
	private RoundedTextField txtPaisHospedaje;
	private JComboBox<String> cboTipo;
	private RoundButtonCircle btnBuscarPrecio;
	private JComboBox<String> cboEstrellas;
	private RoundedTextField txtPrecioMinimo;
	private RoundedTextField txtPrecioMaximo;
	private RoundButton btnCabanas;
	private RoundButton btnHoteles;
	private RoundButton btnGlamping;
	private RoundButton btnResorts;
	private RoundButton btnMoteles;
	private RoundButton btnCampings;
	private JScrollPane scrollPaneHospedajes;
	private RoundButtonCircle btnAll;
	private JLabel lblTodos;
	private RoundButton btnLogin;
	private RoundedPanel jpnFiltrosCiudades_1;
	private JPanel jpnUsuario;
	private JLabel lblNameUsuario;


	/**
	 * Create the frame.
	 */
	public ViewHospedaje() {
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

		btnReservar = new RoundButton("Registrarse");
		btnReservar.setText("Reservar");
		btnReservar.setBorderPainted(false);
		btnReservar.setBackground(new Color(255, 255, 255));
		btnReservar.setForeground(new Color(16, 6, 38));
		btnReservar.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));

		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ViewAutenticacion.class.getResource("/imagenes/flechas-a-la-derecha.png")));
		lblNewLabel_3.setBounds(440, 461, 244, 96);
		jpnInfo.add(lblNewLabel_3);
		btnReservar.setBounds(1512, 37, 207, 48);
		jpnInfo.add(btnReservar);

		JPanel jpnSuperiorCentro = new JPanel();
		jpnSuperiorCentro.setBackground(new Color(16, 6, 38));
		jpnSuperiorCentro.setBounds(419, 0, 584, 120);
		jpnInfo.add(jpnSuperiorCentro);
		jpnSuperiorCentro.setLayout(null);

		jpnFiltrosCiudades_1 = new RoundedPanel(20);
		jpnFiltrosCiudades_1.setBounds(17, 85, 140, 7);
		jpnSuperiorCentro.add(jpnFiltrosCiudades_1);
		jpnFiltrosCiudades_1.setLayout(null);
		jpnFiltrosCiudades_1.setBackground(Color.WHITE);

		btnContactanos = new JButton("Contáctanos");
		btnContactanos.setFocusable(false);
		btnContactanos.setBackground(new Color(16, 6, 38));
		btnContactanos.setForeground(new Color(255, 255, 255));
		btnContactanos.setBorderPainted(false);
		btnContactanos.setBounds(205, 47, 172, 37);
		btnContactanos.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 20));
		jpnSuperiorCentro.add(btnContactanos);

		btnNosotros = new JButton("Nosotros");
		btnNosotros.setFocusable(false);
		btnNosotros.setBackground(new Color(16, 6, 38));
		btnNosotros.setForeground(new Color(255, 255, 255));
		btnNosotros.setBorderPainted(false);
		btnNosotros.setBounds(411, 47, 172, 37);
		btnNosotros.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 20));
		jpnSuperiorCentro.add(btnNosotros);

		JLabel lblNewLabel_8 = new JLabel("Hospedajes");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBackground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(3, 47, 172, 37);
		jpnSuperiorCentro.add(lblNewLabel_8);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(1746, 0, 101, 120);
		jpnInfo.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(ViewAutenticacion.class.getResource("/imagenes/flechas-a-la-derecha.png")));

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

		btnLogin = new RoundButton("Iniciar Sesión");
		btnLogin.setBounds(137, 38, 207, 48);
		jpnUsuario.add(btnLogin);
		btnLogin.setText("Iniciar Sesión ");
		btnLogin.setForeground(new Color(16, 6, 38));
		btnLogin.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
		btnLogin.setBorderPainted(false);
		btnLogin.setBackground(Color.WHITE);

		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(ViewHospedaje.class.getResource("/imagenes/user-interface.png")));
		lblNewLabel_9.setBounds(52, 28, 64, 64);
		jpnUsuario.add(lblNewLabel_9);

		jpnBackGround = new RoundedPanel(50);
		jpnBackGround.setBackground(new Color(51, 26, 108));
		jpnBackGround.setBounds(55, 202, 1779, 812);

		contentPane.add(jpnBackGround);
		jpnBackGround.setLayout(null);

		btnAll = new RoundButtonCircle("");
		btnAll.setBounds(10, 56, 64, 64);
		jpnBackGround.add(btnAll);
		btnAll.setIcon(new ImageIcon(ViewHospedaje.class.getResource("/imagenes/all.png")));
		btnAll.setBackground(new Color(16, 6, 38));

		jpnLupa = new RoundedPanel(100);
		jpnLupa.setBackground(new Color(16, 6, 38));
		jpnLupa.setBounds(1688, 56, 60, 60);
		jpnBackGround.add(jpnLupa);
		Color colorBorde = new Color(255, 255, 255);
		jpnLupa.setBorder(new RoundedBorder(100, Color.WHITE));
		jpnLupa.setLayout(null);

		JLabel lblLupa = new JLabel("");

		lblLupa.setBounds(10, 11, 40, 38);

		try {
			BufferedImage originalImage = ImageIO.read(ViewAutenticacion.class.getResource("/imagenes/lupa.png"));

			Image resizedImage = originalImage.getScaledInstance(lblLupa.getWidth(), lblLupa.getHeight(),
					Image.SCALE_SMOOTH);
			lblLupa.setIcon(new ImageIcon(resizedImage));

		} catch (IOException e2) {
			e2.printStackTrace();
		}

		jpnLupa.add(lblLupa);
		jpnFiltrosHospedajes = new RoundedPanel(50);
		jpnFiltrosHospedajes.setBackground(new Color(179, 170, 255));
		jpnFiltrosHospedajes.setBounds(40, 37, 1681, 94);
		jpnBackGround.add(jpnFiltrosHospedajes);
		jpnFiltrosHospedajes.setLayout(null);

		btnBuscarNombre = new RoundButtonCircle("");
		btnBuscarNombre.setIcon(new ImageIcon(ViewHospedaje.class.getResource("/imagenes/lupa.png")));
		btnBuscarNombre.setBackground(new Color(16, 6, 38));
		btnBuscarNombre.setBounds(1440, 41, 36, 36);
		jpnFiltrosHospedajes.add(btnBuscarNombre);

		btnBuscarCiudad = new RoundButtonCircle("");
		btnBuscarCiudad.setIcon(new ImageIcon(ViewHospedaje.class.getResource("/imagenes/lupa.png")));
		btnBuscarCiudad.setBackground(new Color(16, 6, 38));
		btnBuscarCiudad.setBounds(506, 41, 36, 36);
		jpnFiltrosHospedajes.add(btnBuscarCiudad);

		JLabel lblBuscaPorCiudad = new JLabel("Busca por ciudad");
		lblBuscaPorCiudad.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscaPorCiudad.setForeground(new Color(0, 0, 0));
		lblBuscaPorCiudad.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 24));
		lblBuscaPorCiudad.setBounds(198, -10, 353, 48);
		jpnFiltrosHospedajes.add(lblBuscaPorCiudad);

		txtCiudadHospedaje = new RoundedTextField(50, 50);
		txtCiudadHospedaje.setHorizontalAlignment(SwingConstants.CENTER);
		txtCiudadHospedaje.setFont(new Font("Open Sans", Font.PLAIN, 16));
		txtCiudadHospedaje.setColumns(10);
		txtCiudadHospedaje.setBounds(198, 36, 353, 47);
		jpnFiltrosHospedajes.add(txtCiudadHospedaje);

		JLabel lblBuscaPorPais = new JLabel("Busca por país");
		lblBuscaPorPais.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscaPorPais.setForeground(Color.BLACK);
		lblBuscaPorPais.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 24));
		lblBuscaPorPais.setBounds(665, -10, 353, 48);
		jpnFiltrosHospedajes.add(lblBuscaPorPais);

		txtNombreHospedaje = new RoundedTextField(50, 50);
		txtNombreHospedaje.setBounds(1131, 36, 353, 47);
		jpnFiltrosHospedajes.add(txtNombreHospedaje);
		txtNombreHospedaje.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreHospedaje.setFont(new Font("Open Sans", Font.PLAIN, 16));
		txtNombreHospedaje.setColumns(10);

		btnBuscarPais = new RoundButtonCircle("");
		btnBuscarPais.setBounds(975, 41, 36, 36);
		jpnFiltrosHospedajes.add(btnBuscarPais);
		btnBuscarPais.setBackground(new Color(16, 6, 38));
		btnBuscarPais.setIcon(new ImageIcon(ViewHospedaje.class.getResource("/imagenes/lupa.png")));

		txtPaisHospedaje = new RoundedTextField(50, 50);
		txtPaisHospedaje.setHorizontalAlignment(SwingConstants.CENTER);
		txtPaisHospedaje.setFont(new Font("Open Sans", Font.PLAIN, 16));
		txtPaisHospedaje.setColumns(10);
		txtPaisHospedaje.setBounds(665, 36, 353, 47);
		jpnFiltrosHospedajes.add(txtPaisHospedaje);

		JLabel lblBuscaPorNombre = new JLabel("Busca por Nombre");
		lblBuscaPorNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscaPorNombre.setForeground(Color.BLACK);
		lblBuscaPorNombre.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 24));
		lblBuscaPorNombre.setBounds(1131, -10, 353, 48);
		jpnFiltrosHospedajes.add(lblBuscaPorNombre);

		lblTodos = new JLabel("Todos");
		lblTodos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTodos.setForeground(Color.BLACK);
		lblTodos.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 24));
		lblTodos.setBounds(12, 25, 142, 48);
		jpnFiltrosHospedajes.add(lblTodos);

		jpnFiltrosCiudades = new RoundedPanel(50);
		jpnFiltrosCiudades.setBackground(new Color(255, 255, 255));
		jpnFiltrosCiudades.setBounds(40, 156, 242, 413);
		jpnBackGround.add(jpnFiltrosCiudades);
		jpnFiltrosCiudades.setLayout(null);

		JLabel lblFiltros = new JLabel("Filtros");
		lblFiltros.setBounds(121, 27, 81, 33);
		lblFiltros.setHorizontalAlignment(SwingConstants.LEFT);
		lblFiltros.setForeground(Color.BLACK);
		lblFiltros.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 26));
		jpnFiltrosCiudades.add(lblFiltros);

		JLabel lblFiltro = new JLabel("");
		lblFiltro.setIcon(new ImageIcon(ViewHospedaje.class.getResource("/imagenes/filtrar.png")));
		lblFiltro.setBounds(47, 11, 64, 64);
		jpnFiltrosCiudades.add(lblFiltro);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipo.setForeground(Color.BLACK);
		lblTipo.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 20));
		lblTipo.setBounds(10, 95, 81, 33);
		jpnFiltrosCiudades.add(lblTipo);

		JLabel lblEstrellas = new JLabel("Estrellas");
		lblEstrellas.setHorizontalAlignment(SwingConstants.LEFT);
		lblEstrellas.setForeground(Color.BLACK);
		lblEstrellas.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 20));
		lblEstrellas.setBounds(10, 175, 125, 33);
		jpnFiltrosCiudades.add(lblEstrellas);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 20));
		lblPrecio.setBounds(10, 250, 125, 33);
		jpnFiltrosCiudades.add(lblPrecio);

		cboTipo = new JComboBox();

		cboTipo.setForeground(new Color(255, 255, 255));
		cboTipo.setFont(new Font("Open Sans", Font.BOLD, 20));
		cboTipo.setOpaque(false);
		cboTipo.setFocusable(false);
		cboTipo.setFocusTraversalKeysEnabled(false);
		cboTipo.setBackground(new Color(51, 26, 108));
		cboTipo.setModel(new DefaultComboBoxModel(new String[] { "Rural", "Urbano" }));
		cboTipo.setBounds(20, 133, 201, 31);

		jpnFiltrosCiudades.add(cboTipo);

		cboEstrellas = new JComboBox();
		cboEstrellas.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		cboEstrellas.setOpaque(false);
		cboEstrellas.setForeground(Color.WHITE);
		cboEstrellas.setFont(new Font("Open Sans", Font.BOLD, 20));
		cboEstrellas.setFocusable(false);
		cboEstrellas.setFocusTraversalKeysEnabled(false);
		cboEstrellas.setBackground(new Color(51, 26, 108));
		cboEstrellas.setBounds(20, 208, 201, 31);
		jpnFiltrosCiudades.add(cboEstrellas);

		btnBuscarPrecio = new RoundButtonCircle("");
		btnBuscarPrecio.setIcon(new ImageIcon(ViewHospedaje.class.getResource("/imagenes/dolar.png")));
		btnBuscarPrecio.setBackground(new Color(51, 26, 108));
		btnBuscarPrecio.setBounds(95, 368, 40, 40);
		jpnFiltrosCiudades.add(btnBuscarPrecio);

		JLabel lblMin = new JLabel("-min");
		lblMin.setHorizontalAlignment(SwingConstants.LEFT);
		lblMin.setForeground(Color.BLACK);
		lblMin.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 20));
		lblMin.setBounds(167, 285, 71, 33);
		jpnFiltrosCiudades.add(lblMin);

		JLabel lblmax = new JLabel("-max");
		lblmax.setHorizontalAlignment(SwingConstants.LEFT);
		lblmax.setForeground(Color.BLACK);
		lblmax.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 20));
		lblmax.setBounds(167, 328, 71, 33);
		jpnFiltrosCiudades.add(lblmax);

		txtPrecioMinimo = new RoundedTextField(20, 20);
		txtPrecioMinimo.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrecioMinimo.setFont(new Font("Open Sans", Font.PLAIN, 16));
		txtPrecioMinimo.setColumns(10);
		txtPrecioMinimo.setBounds(10, 287, 147, 33);
		jpnFiltrosCiudades.add(txtPrecioMinimo);

		txtPrecioMaximo = new RoundedTextField(20, 20);
		txtPrecioMaximo.setBounds(10, 329, 147, 33);
		jpnFiltrosCiudades.add(txtPrecioMaximo);
		txtPrecioMaximo.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrecioMaximo.setFont(new Font("Open Sans", Font.PLAIN, 16));
		txtPrecioMaximo.setColumns(10);
		// Main panel with rounded corners inside the scroll pane
		jpnHospedajes = new RoundedPanel(50);
		jpnHospedajes.setBackground(new Color(255, 255, 255));
		jpnHospedajes.setLayout(null);

		// Scroll pane containing the main panel
		scrollPaneHospedajes = new CustomScrollPane(jpnHospedajes, 50);
		;
		scrollPaneHospedajes.setBorder(null);
		scrollPaneHospedajes.setBounds(304, 156, 1432, 629); // Set bounds for the scroll pane
		scrollPaneHospedajes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPaneHospedajes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jpnBackGround.add(scrollPaneHospedajes);

		// Example card panel with rounded corners inside the main panel

		// Set preferred size for jpnHospedajes to enable scrolling
		jpnHospedajes.setPreferredSize(new Dimension(1432, 4000));

		JPanel jpnFiltro1 = new JPanel();

		jpnFiltro1.setBorder(new LineBorder(colorBorde));
		jpnFiltro1.setBackground(new Color(16, 6, 38));
		jpnFiltro1.setBounds(0, 120, 1904, 80);
		contentPane.add(jpnFiltro1);
		jpnFiltro1.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(1017, 14, 50, 48);
		jpnFiltro1.add(lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon(ViewHospedaje.class.getResource("/imagenes/cabana.png")));

		btnCabanas = new RoundButton("Iniciar Sesión");
		btnCabanas.setBounds(1012, 15, 172, 45);
		jpnFiltro1.add(btnCabanas);
		btnCabanas.setText("     CABAÑAS");
		btnCabanas.setForeground(new Color(16, 6, 38));
		btnCabanas.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		btnCabanas.setBorderPainted(false);
		btnCabanas.setBackground(Color.WHITE);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(747, 14, 50, 48);
		jpnFiltro1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(ViewHospedaje.class.getResource("/imagenes/motel.png")));

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(ViewHospedaje.class.getResource("/imagenes/camping.png")));
		lblNewLabel_7.setBounds(1529, 14, 50, 48);
		jpnFiltro1.add(lblNewLabel_7);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(ViewHospedaje.class.getResource("/imagenes/camping.png")));
		lblNewLabel_6.setBounds(1282, 14, 50, 48);
		jpnFiltro1.add(lblNewLabel_6);

		lblHoteles = new JLabel("");
		lblHoteles.setIcon(new ImageIcon(ViewHospedaje.class.getResource("/imagenes/hotelFiltro.png")));
		lblHoteles.setBounds(215, 14, 50, 48);
		jpnFiltro1.add(lblHoteles);

		JLabel lblLupa_1 = new JLabel("");
		lblLupa_1.setBounds(182, 34, 26, 25);
		jpnFiltro1.add(lblLupa_1);

		btnHoteles = new RoundButton("Iniciar Sesión");
		btnHoteles.setIcon(null);
		btnHoteles.setText("     HOTELES");
		btnHoteles.setForeground(new Color(16, 6, 38));
		btnHoteles.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		btnHoteles.setBorderPainted(false);
		btnHoteles.setBackground(Color.WHITE);
		btnHoteles.setBounds(206, 15, 172, 45);
		jpnFiltro1.add(btnHoteles);

		btnGlamping = new RoundButton("Iniciar Sesión");

		btnGlamping.setText("     GLAMPINGS");
		btnGlamping.setForeground(new Color(16, 6, 38));
		btnGlamping.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		btnGlamping.setBorderPainted(false);
		btnGlamping.setBackground(Color.WHITE);
		btnGlamping.setBounds(1527, 15, 172, 45);
		jpnFiltro1.add(btnGlamping);

		RoundedPanel jpnBackGroundButton = new RoundedPanel(50);

		jpnBackGroundButton.setLayout(null);
		jpnBackGroundButton.setBorder(new RoundedBorder(50, Color.WHITE));
		jpnBackGroundButton.setBackground(new Color(16, 6, 38));
		jpnBackGroundButton.setBounds(200, 10, 184, 56);
		jpnFiltro1.add(jpnBackGroundButton);

		RoundedPanel jpnBackGroundButton_1_2_2 = new RoundedPanel(50);
		jpnBackGroundButton_1_2_2.setLayout(null);
		jpnBackGroundButton_1_2_2.setBorder(new RoundedBorder(50, Color.WHITE));
		jpnBackGroundButton_1_2_2.setBackground(new Color(16, 6, 38));
		jpnBackGroundButton_1_2_2.setBounds(1521, 10, 184, 56);
		jpnFiltro1.add(jpnBackGroundButton_1_2_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(480, 14, 50, 48);
		jpnFiltro1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(ViewHospedaje.class.getResource("/imagenes/hotelFiltro.png")));

		btnResorts = new RoundButton("Iniciar Sesión");
		btnResorts.setBounds(475, 15, 172, 45);
		jpnFiltro1.add(btnResorts);
		btnResorts.setText("     RESORTS");
		btnResorts.setForeground(new Color(16, 6, 38));
		btnResorts.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		btnResorts.setBorderPainted(false);
		btnResorts.setBackground(Color.WHITE);

		RoundedPanel jpnBackGroundButton_1 = new RoundedPanel(50);
		jpnBackGroundButton_1.setBounds(469, 10, 184, 56);
		jpnFiltro1.add(jpnBackGroundButton_1);
		jpnBackGroundButton_1.setLayout(null);
		jpnBackGroundButton_1.setBorder(new RoundedBorder(50, Color.WHITE));
		jpnBackGroundButton_1.setBackground(new Color(16, 6, 38));

		btnMoteles = new RoundButton("Iniciar Sesión");
		btnMoteles.setBounds(742, 15, 172, 45);
		jpnFiltro1.add(btnMoteles);
		btnMoteles.setText("     MOTELES");
		btnMoteles.setForeground(new Color(16, 6, 38));
		btnMoteles.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		btnMoteles.setBorderPainted(false);
		btnMoteles.setBackground(Color.WHITE);

		btnCampings = new RoundButton("Iniciar Sesión");
		btnCampings.setBounds(1276, 15, 172, 45);
		jpnFiltro1.add(btnCampings);
		btnCampings.setText("     CAMPINGS");
		btnCampings.setForeground(new Color(16, 6, 38));
		btnCampings.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 18));
		btnCampings.setBorderPainted(false);
		btnCampings.setBackground(Color.WHITE);

		RoundedPanel jpnBackGroundButton_1_2_1 = new RoundedPanel(50);
		jpnBackGroundButton_1_2_1.setLayout(null);
		jpnBackGroundButton_1_2_1.setBorder(new RoundedBorder(50, Color.WHITE));
		jpnBackGroundButton_1_2_1.setBackground(new Color(16, 6, 38));
		jpnBackGroundButton_1_2_1.setBounds(1270, 10, 184, 56);
		jpnFiltro1.add(jpnBackGroundButton_1_2_1);

		RoundedPanel jpnBackGroundButton_1_1 = new RoundedPanel(50);
		jpnBackGroundButton_1_1.setLayout(null);
		jpnBackGroundButton_1_1.setBorder(new RoundedBorder(50, Color.WHITE));
		jpnBackGroundButton_1_1.setBackground(new Color(16, 6, 38));
		jpnBackGroundButton_1_1.setBounds(736, 10, 184, 56);
		jpnFiltro1.add(jpnBackGroundButton_1_1);

		RoundedPanel jpnBackGroundButton_1_2 = new RoundedPanel(50);
		jpnBackGroundButton_1_2.setLayout(null);
		jpnBackGroundButton_1_2.setBorder(new RoundedBorder(50, Color.WHITE));
		jpnBackGroundButton_1_2.setBackground(new Color(16, 6, 38));
		jpnBackGroundButton_1_2.setBounds(1006, 10, 184, 56);
		jpnFiltro1.add(jpnBackGroundButton_1_2);

		// Cargar y redimensionar la imagen
		try {
			BufferedImage originalImage = ImageIO.read(ViewAutenticacion.class.getResource("/imagenes/show.png"));

		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

	public RoundedPanel getJpnHospedajes() {
		return jpnHospedajes;
	}

	public void setJpnHospedajes(RoundedPanel jpnHospedajes) {
		this.jpnHospedajes = jpnHospedajes;
	}

	public RoundButtonCircle getBtnBuscarNombre() {
		return btnBuscarNombre;
	}

	public void setBtnBuscarNombre(RoundButtonCircle btnBuscarNombre) {
		this.btnBuscarNombre = btnBuscarNombre;
	}

	public RoundButtonCircle getBtnBuscarCiudad() {
		return btnBuscarCiudad;
	}

	public void setBtnBuscarCiudad(RoundButtonCircle btnBuscarCiudad) {
		this.btnBuscarCiudad = btnBuscarCiudad;
	}

	public RoundButtonCircle getBtnBuscarPais() {
		return btnBuscarPais;
	}

	public void setBtnBuscarPais(RoundButtonCircle btnBuscarPais) {
		this.btnBuscarPais = btnBuscarPais;
	}

	public JScrollPane getScrollPaneHospedajes() {
		return scrollPaneHospedajes;
	}

	public void setScrollPaneHospedajes(JScrollPane scrollPaneHospedajes) {
		this.scrollPaneHospedajes = scrollPaneHospedajes;
	}

	public RoundButtonCircle getBtnBuscarPrecio() {
		return btnBuscarPrecio;
	}

	public void setBtnBuscarPrecio(RoundButtonCircle btnBuscarPrecio) {
		this.btnBuscarPrecio = btnBuscarPrecio;
	}

	public RoundButton getBtnCabanas() {
		return btnCabanas;
	}

	public void setBtnCabanas(RoundButton btnCabanas) {
		this.btnCabanas = btnCabanas;
	}

	public RoundButton getBtnGlamping() {
		return btnGlamping;
	}

	public void setBtnGlamping(RoundButton btnGlamping) {
		this.btnGlamping = btnGlamping;
	}

	public RoundButton getBtnResorts() {
		return btnResorts;
	}

	public void setBtnResorts(RoundButton btnResorts) {
		this.btnResorts = btnResorts;
	}

	public RoundButton getBtnMoteles() {
		return btnMoteles;
	}

	public void setBtnMoteles(RoundButton btnMoteles) {
		this.btnMoteles = btnMoteles;
	}

	public RoundButton getBtnCampings() {
		return btnCampings;
	}

	public void setBtnCampings(RoundButton btnCampings) {
		this.btnCampings = btnCampings;
	}

	public RoundedTextField getTxtNombreHospedaje() {
		return txtNombreHospedaje;
	}

	public void setTxtNombreHospedaje(RoundedTextField txtNombreHospedaje) {
		this.txtNombreHospedaje = txtNombreHospedaje;
	}

	public RoundedTextField getTxtCiudadHospedaje() {
		return txtCiudadHospedaje;
	}

	public void setTxtCiudadHospedaje(RoundedTextField txtCiudadHospedaje) {
		this.txtCiudadHospedaje = txtCiudadHospedaje;
	}

	public RoundedTextField getTxtPaisHospedaje() {
		return txtPaisHospedaje;
	}

	public void setTxtPaisHospedaje(RoundedTextField txtPaisHospedaje) {
		this.txtPaisHospedaje = txtPaisHospedaje;
	}

	public RoundedTextField getTxtPrecioMinimo() {
		return txtPrecioMinimo;
	}

	public void setTxtPrecioMinimo(RoundedTextField txtPrecioMinimo) {
		this.txtPrecioMinimo = txtPrecioMinimo;
	}

	public RoundedTextField getTxtPrecioMaximo() {
		return txtPrecioMaximo;
	}

	public void setTxtPrecioMaximo(RoundedTextField txtPrecioMaximo) {
		this.txtPrecioMaximo = txtPrecioMaximo;
	}

	public RoundButton getBtnHoteles() {
		return btnHoteles;
	}

	public void setBtnHoteles(RoundButton btnHoteles) {
		this.btnHoteles = btnHoteles;
	}

	public JComboBox<String> getCboTipo() {
		return cboTipo;
	}

	public void setCboTipo(JComboBox<String> cboTipo) {
		this.cboTipo = cboTipo;
	}

	public JComboBox<String> getCboEstrellas() {
		return cboEstrellas;
	}

	public void setCboEstrellas(JComboBox<String> cboEstrellas) {
		this.cboEstrellas = cboEstrellas;
	}

	public RoundButtonCircle getBtnAll() {
		return btnAll;
	}

	public void setBtnAll(RoundButtonCircle btnAll) {
		this.btnAll = btnAll;
	}

	public RoundButton getBtnReservar() {
		return btnReservar;
	}

	public void setBtnReservar(RoundButton btnReservar) {
		this.btnReservar = btnReservar;
	}

	public JButton getBtnNosotros() {
		return btnNosotros;
	}

	public void setBtnNosotros(JButton btnNosotros) {
		this.btnNosotros = btnNosotros;
	}

	public JButton getBtnContactanos() {
		return btnContactanos;
	}

	public void setBtnContactanos(JButton btnContactanos) {
		this.btnContactanos = btnContactanos;
	}

	public RoundButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(RoundButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JPanel getJpnUsuario() {
		return jpnUsuario;
	}

	public void setJpnUsuario(JPanel jpnUsuario) {
		this.jpnUsuario = jpnUsuario;
	}

	

	public RoundedPanel mostrarPanelHospedaje(String tH, String nombre, String ubicacionCiudad, String ubicacionPais,
			int numeroEstrellas, String descripcion, String tipo, double precioPorPersona, String imagen) {
		RoundedPanel jpnCardHospedaje = new RoundedPanel(50);

		jpnCardHospedaje.setBackground(new Color(230, 230, 230));
		jpnCardHospedaje.setLayout(null);

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

	public void mostrarNameUsuario(String name) {
		lblNameUsuario = new JLabel(name);
		lblNameUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameUsuario.setForeground(Color.WHITE);
		lblNameUsuario.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 26));
		lblNameUsuario.setBackground(Color.WHITE);
		lblNameUsuario.setBounds(0, 0, 505, 120);
		jpnUsuario.add(lblNameUsuario);

		

	}

	public int pedirPrecioMinimo() {
		String txtMinimo = "";
		int numeroMinimo = 0;
		boolean numeroMinimoValido = false;

		try {
			txtMinimo = txtPrecioMinimo.getText();
			if (txtMinimo.isEmpty()) {
				numeroMinimoValido = false;

				throw new NumberFormatException("El campo de  precio minimo no puede estar vacío.");

			} else {
				numeroMinimo = Integer.parseInt(txtMinimo);
				numeroMinimoValido = true;
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Ingrese un precio minimo valido, Solo numeros", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return numeroMinimo;
	}

	public int pedirPrecioMaximo() {
		String txtMaximo = "";
		int numeroMaximo = 0;
		boolean numeroMaximoValido = false;

		try {
			txtMaximo = txtPrecioMinimo.getText();
			if (txtMaximo.isEmpty()) {
				numeroMaximoValido = false;
				throw new NumberFormatException("El campo de  precio maximo no puede estar vacío.");
			} else {
				numeroMaximo = Integer.parseInt(txtMaximo);
				numeroMaximoValido = true;
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Ingrese un precio maximo valido, Solo numeros", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return numeroMaximo;
	}

	public String pedirCiudad() {

		String ciudad = "";
		boolean ciudadValida = false;

		try {

			ciudad = txtCiudadHospedaje.getText();

			if (ciudad.isEmpty()) {
				throw new Exception("El campo de pais no puede estar vacío.");

			}
			if (ciudad.matches("[a-zA-ZñÑ ]+")) {
				ciudadValida = true;

			} else {
				throw new Exception("Ingrese una ciudad válida (solo letras).");

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}

		return ciudad;
	}

	public String pedirPais() {

		String pais = "";
		boolean paisValido = false;

		try {

			pais = txtPaisHospedaje.getText();

			if (pais.isEmpty()) {
				throw new Exception("El campo de pais no puede estar vacío.");

			}
			if (pais.matches("[a-zA-ZñÑ ]+")) {
				paisValido = true;

			} else {
				throw new Exception("Ingrese un  pais válido (solo letras).");

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}

		return pais;
	}

	public String pedirNombreHospedaje() {

		String nombre = "";
		boolean nombreValido = false;

		try {

			nombre = txtNombreHospedaje.getText();

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
