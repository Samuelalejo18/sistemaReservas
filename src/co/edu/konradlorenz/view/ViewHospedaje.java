package co.edu.konradlorenz.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import java.awt.GridLayout;
import java.awt.Image;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ViewHospedaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel jpnInfo;
	private RoundedPanel jpnBackGround;
	private RoundButton btnRegistrar;
	private JButton btnReservar;
	private JButton btnNosotros;
	private JButton btnContactanos;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private RoundedTextField txtNombreHospedaje;
	private RoundedPanel jpnFiltrosHospedajes;
	private RoundedPanel jpnFiltrosCiudades;
	private RoundedPanel jpnHospedajes;
	private RoundedPanel jpnLupa ;
	private JLabel lblNewLabel;
	private JButton btnLogin;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewHospedaje frame = new ViewHospedaje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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

		btnRegistrar = new RoundButton("Registrarse");
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setBackground(new Color(255, 255, 255));
		btnRegistrar.setForeground(new Color(16, 6, 38));
		btnRegistrar.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));

		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnLogin = new RoundButton("Iniciar Sesión");
		btnLogin.setText("Iniciar Sesión ");
		btnLogin.setBorderPainted(false);
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setForeground(new Color(16, 6, 38));
		btnLogin.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(1274, 37, 207, 48);
		jpnInfo.add(btnLogin);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ViewAutenticacion.class.getResource("/imagenes/flechas-a-la-derecha.png")));
		lblNewLabel_3.setBounds(440, 461, 244, 96);
		jpnInfo.add(lblNewLabel_3);
		btnRegistrar.setBounds(1512, 37, 207, 48);
		jpnInfo.add(btnRegistrar);

		JPanel jpnSuperiorCentro = new JPanel();
		jpnSuperiorCentro.setBackground(new Color(16, 6, 38));
		jpnSuperiorCentro.setBounds(777, 0, 451, 120);
		jpnInfo.add(jpnSuperiorCentro);
		jpnSuperiorCentro.setLayout(null);

		btnReservar = new JButton("Reservar");
		btnReservar.setFocusPainted(false);
		btnReservar.setBackground(new Color(16, 6, 38));
		btnReservar.setBorderPainted(false);
		btnReservar.setForeground(new Color(255, 255, 255));
		btnReservar.setBounds(25, 64, 105, 23);
		btnReservar.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 16));
		jpnSuperiorCentro.add(btnReservar);

		btnContactanos = new JButton("Contáctanos");
		btnContactanos.setBackground(new Color(16, 6, 38));
		btnContactanos.setForeground(new Color(255, 255, 255));
		btnContactanos.setBorderPainted(false);
		btnContactanos.setBounds(140, 64, 144, 23);
		btnContactanos.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 16));
		jpnSuperiorCentro.add(btnContactanos);

		btnNosotros = new JButton("Nosotros");
		btnNosotros.setBackground(new Color(16, 6, 38));
		btnNosotros.setForeground(new Color(255, 255, 255));
		btnNosotros.setBorderPainted(false);
		btnNosotros.setBounds(294, 64, 105, 23);
		btnNosotros.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 16));
		jpnSuperiorCentro.add(btnNosotros);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(1746, 0, 101, 120);
		jpnInfo.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(ViewAutenticacion.class.getResource("/imagenes/flechas-a-la-derecha.png")));

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(
				new ImageIcon(ViewHospedaje.class.getResource("/imagenes/Captura de pantalla 2024-05-21 003128.png")));
		lblNewLabel_4.setBounds(58, 0, 719, 120);
		jpnInfo.add(lblNewLabel_4);

		jpnBackGround = new RoundedPanel(50);
		jpnBackGround.setBackground(new Color(51, 26, 108));
		jpnBackGround.setBounds(55, 202, 1779, 812);

		contentPane.add(jpnBackGround);
		jpnBackGround.setLayout(null);
		
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
	            
	            Image resizedImage = originalImage.getScaledInstance(lblLupa.getWidth(), lblLupa.getHeight(), Image.SCALE_SMOOTH);
	            lblLupa.setIcon(new ImageIcon(resizedImage));
	           
	        } catch (IOException e2) {
	            e2.printStackTrace();
	        }
		
		
		jpnLupa.add(lblLupa);
		jpnFiltrosHospedajes = new RoundedPanel(50);
		jpnFiltrosHospedajes.setBackground(new Color(179, 170, 255));
		jpnFiltrosHospedajes.setBounds(40, 37, 1681, 94);
		jpnBackGround.add(jpnFiltrosHospedajes);

		jpnFiltrosCiudades = new RoundedPanel(50);
		jpnFiltrosCiudades.setBackground(new Color(255, 255, 255));
		jpnFiltrosCiudades.setBounds(40, 156, 242, 413);
		jpnBackGround.add(jpnFiltrosCiudades);

		JPanel jpnHospedajes = new RoundedPanel(50);
		jpnHospedajes.setBackground(new Color(255, 255, 255));
		jpnHospedajes.setBounds(304, 156, 1432, 629);
		jpnBackGround.add(jpnHospedajes);

		JPanel jpnFiltro1 = new JPanel();
		  
		  jpnFiltro1.setBorder( new LineBorder(colorBorde));
		jpnFiltro1.setBackground(new Color(16, 6, 38));
		jpnFiltro1.setBounds(0, 120, 1904, 80);
		contentPane.add(jpnFiltro1);
		jpnFiltro1.setLayout(null);
		
		RoundedPanel jpnLupa2 = new RoundedPanel(100);
		jpnLupa2.setLayout(null);
		jpnLupa2.setBorder(new RoundedBorder(100, Color.WHITE));
		jpnLupa2.setBackground(new Color(16, 6, 38));
		jpnLupa2.setBounds(420, 15, 38, 39);
		jpnFiltro1.add(jpnLupa2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ViewHospedaje.class.getResource("/imagenes/lupa2.png")));
		lblNewLabel.setBounds(10, 0, 38, 39);
		jpnLupa2.add(lblNewLabel);

		txtNombreHospedaje = new RoundedTextField(50,50);
		txtNombreHospedaje.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreHospedaje.setFont(new Font("Open Sans", Font.PLAIN, 16));
		txtNombreHospedaje.setBounds(121, 11, 353, 47);
		jpnFiltro1.add(txtNombreHospedaje);
		txtNombreHospedaje.setColumns(10);
		
		JButton btnFiltroHoteles = new JButton("Hoteles");
		btnFiltroHoteles.setBounds(674, 23, 89, 23);
		jpnFiltro1.add(btnFiltroHoteles);
		
		JButton btnFiltroMotel = new JButton("Resorts");
		btnFiltroMotel.setBounds(810, 23, 89, 23);
		jpnFiltro1.add(btnFiltroMotel);
		
		JButton btnFiltroResorts = new JButton("Resorts");
		btnFiltroResorts.setBounds(951, 23, 89, 23);
		jpnFiltro1.add(btnFiltroResorts);
		
		JLabel lblLupa_1 = new JLabel("");
		lblLupa_1.setBounds(182, 34, 26, 25);
		jpnFiltro1.add(lblLupa_1);

		// Cargar y redimensionar la imagen
		try {
			BufferedImage originalImage = ImageIO.read(ViewAutenticacion.class.getResource("/imagenes/show.png"));

		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
}
