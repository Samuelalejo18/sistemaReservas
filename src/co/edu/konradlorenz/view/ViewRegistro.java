package co.edu.konradlorenz.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class ViewRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel jpnInfo;
	private RoundedPanel jpnRegistro;
	private RoundedPanel jpnFormulario;
	private JButton btnRegister;
	private JLabel lblCuentaNueva;
	private JTextField txtApellido;
	private JLabel lblCreaTuCuenta;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JPanel jpnBuscaComparaReserva;
	private JLabel lblNewLabel;
	private RoundButton btnLogin;
	private JTextField txtNombre;
	private JLabel lblId;
	private JTextField txtId;
	private JLabel lblCorreo;
	private JLabel lblContrasena;
	private JPasswordField passwordField;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JLabel lblNumeroDeTelefono;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JLabel lblNewLabel_1;
	private JPanel jpnSuperiorCentro;
	private JButton btnContactanos;
	private JButton btnNosotros;
	private JButton btnHospedajes;

	/**
	 * Launch the application.
	 */

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ViewRegistro frame = new
	 * ViewRegistro(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public ViewRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(16, 6, 38));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setSize(1280, 800);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jpnInfo = new JPanel();
		jpnInfo.setBackground(new Color(16, 6, 38));
		jpnInfo.setBounds(0, 0, 1904, 120);
		contentPane.add(jpnInfo);
		jpnInfo.setLayout(null);

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
		btnLogin.setBounds(902, 41, 207, 48);
		jpnInfo.add(btnLogin);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setIcon(
				new ImageIcon(ViewRegistro.class.getResource("/imagenes/Captura de pantalla 2024-05-21 003128.png")));
		lblNewLabel_2.setBounds(94, 30, 293, 61);
		jpnInfo.add(lblNewLabel_2);
		this.setResizable(false);
		jpnRegistro = new RoundedPanel(50);
		jpnRegistro.setBackground(new Color(51, 26, 108));
		jpnRegistro.setBounds(99, 118, 1065, 611);

		contentPane.add(jpnRegistro);
		jpnRegistro.setLayout(null);

		jpnFormulario = new RoundedPanel(50);
		jpnFormulario.setBounds(334, 26, 402, 563);
		jpnFormulario.setBackground(new Color(255, 255, 255));
		jpnRegistro.add(jpnFormulario);
		jpnFormulario.setLayout(null);

		JLabel lblEye = new JLabel("");
		lblEye.setBounds(123, 486, 33, 23); // Establecer el tamaño y la posición del JLabel

		// Cargar y redimensionar la imagen
		try {
			BufferedImage originalImage = ImageIO.read(ViewAutenticacion.class.getResource("/imagenes/show.png"));

			Image resizedImage = originalImage.getScaledInstance(lblEye.getWidth(), lblEye.getHeight(),
					Image.SCALE_SMOOTH);
			lblEye.setIcon(new ImageIcon(resizedImage));

		} catch (IOException e2) {
			e2.printStackTrace();
		}

		JButton toggleButton = new JButton("Mostrar");

		toggleButton.setBackground(new Color(255, 255, 255));
		toggleButton.setBounds(155, 486, 90, 23);
		jpnFormulario.add(toggleButton);

		toggleButton.setBorderPainted(false);

		toggleButton.addActionListener(new ActionListener() {
			private boolean isPasswordVisible = false;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isPasswordVisible) {
					passwordField.setEchoChar('•'); // Ocultar contraseña
					toggleButton.setText("Mostrar");
					try {
						BufferedImage originalImage = ImageIO
								.read(ViewAutenticacion.class.getResource("/imagenes/show.png"));
						Image resizedImage = originalImage.getScaledInstance(lblEye.getWidth(), lblEye.getHeight(),
								Image.SCALE_SMOOTH);
						lblEye.setIcon(new ImageIcon(resizedImage));
					} catch (IOException e2) {
						e2.printStackTrace();
					}

				} else {
					passwordField.setEchoChar((char) 0); // Mostrar contraseña
					toggleButton.setText("Ocultar");
					try {
						BufferedImage originalImage = ImageIO
								.read(ViewAutenticacion.class.getResource("/imagenes/hide.png"));
						Image resizedImage = originalImage.getScaledInstance(lblEye.getWidth(), lblEye.getHeight(),
								Image.SCALE_SMOOTH);
						lblEye.setIcon(new ImageIcon(resizedImage));
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				}
				isPasswordVisible = !isPasswordVisible;
			}
		});

		jpnFormulario.add(lblEye);

		lblCuentaNueva = new JLabel("Cuenta Nueva");
		lblCuentaNueva.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 40));
		lblCuentaNueva.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuentaNueva.setBounds(0, 11, 402, 63);
		jpnFormulario.add(lblCuentaNueva);

		txtApellido = new JTextField();
		txtApellido.setBounds(51, 174, 297, 34);
		jpnFormulario.add(txtApellido);
		txtApellido.setColumns(10);

		lblCreaTuCuenta = new JLabel("Crea tu cuenta para acceder");
		lblCreaTuCuenta.setFont(new Font("Open Sans", Font.PLAIN, 11));
		lblCreaTuCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreaTuCuenta.setBounds(0, 85, 402, 14);
		jpnFormulario.add(lblCreaTuCuenta);

		lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setBounds(51, 110, 297, 14);
		jpnFormulario.add(lblNombre);

		lblApellido = new JLabel("APELLIDO");
		lblApellido.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblApellido.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellido.setBounds(51, 160, 297, 14);
		jpnFormulario.add(lblApellido);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(51, 123, 297, 34);
		jpnFormulario.add(txtNombre);

		lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblId.setBounds(51, 211, 297, 14);
		jpnFormulario.add(lblId);

		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(51, 226, 297, 34);
		jpnFormulario.add(txtId);

		lblCorreo = new JLabel("CORREO");
		lblCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCorreo.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblCorreo.setBounds(51, 263, 297, 14);
		jpnFormulario.add(lblCorreo);

		lblContrasena = new JLabel("CONTRASEÑA");
		lblContrasena.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasena.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblContrasena.setBounds(51, 315, 297, 14);
		jpnFormulario.add(lblContrasena);

		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(51, 278, 297, 34);
		jpnFormulario.add(txtCorreo);

		passwordField = new JPasswordField();
		passwordField.setBounds(51, 330, 297, 32);
		jpnFormulario.add(passwordField);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(51, 383, 297, 34);
		jpnFormulario.add(txtTelefono);

		lblNumeroDeTelefono = new JLabel("NÚMERO DE TELÉFONO");
		lblNumeroDeTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroDeTelefono.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblNumeroDeTelefono.setBounds(51, 368, 297, 14);
		jpnFormulario.add(lblNumeroDeTelefono);

		lblDireccion = new JLabel("DIRECCIÓN");
		lblDireccion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDireccion.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblDireccion.setBounds(51, 421, 297, 14);
		jpnFormulario.add(lblDireccion);

		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(51, 441, 297, 34);
		jpnFormulario.add(txtDireccion);

		btnRegister = new JButton("Registrarse");
		btnRegister.setBounds(119, 512, 150, 40);
		jpnFormulario.add(btnRegister);
		btnRegister.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 12));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegister.setBackground(new Color(16, 6, 38));
		btnRegister.setForeground(new Color(255, 255, 255));

		jpnBuscaComparaReserva = new RoundedPanel(20);
		jpnBuscaComparaReserva.setBounds(799, 557, 244, 32);
		jpnBuscaComparaReserva.setBackground(new Color(179, 170, 255));
		jpnRegistro.add(jpnBuscaComparaReserva);
		jpnBuscaComparaReserva.setLayout(null);

		lblNewLabel = new JLabel("#BuscaComparaReserva");
		lblNewLabel.setBounds(0, 0, 244, 32);
		jpnBuscaComparaReserva.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 14));

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ViewRegistro.class.getResource("/imagenes/flechas-a-la-derecha.png")));
		lblNewLabel_1.setBounds(1119, 0, 94, 120);
		jpnInfo.add(lblNewLabel_1);
		
		jpnSuperiorCentro = new JPanel();
		jpnSuperiorCentro.setLayout(null);
		jpnSuperiorCentro.setBackground(new Color(16, 6, 38));
		jpnSuperiorCentro.setBounds(308, 0, 584, 120);
		jpnInfo.add(jpnSuperiorCentro);
		
		btnContactanos = new JButton("Contáctanos");
		btnContactanos.setForeground(Color.WHITE);
		btnContactanos.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 20));
		btnContactanos.setFocusable(false);
		btnContactanos.setBorderPainted(false);
		btnContactanos.setBackground(new Color(16, 6, 38));
		btnContactanos.setBounds(205, 47, 172, 37);
		jpnSuperiorCentro.add(btnContactanos);
		
		btnNosotros = new JButton("Nosotros");
		btnNosotros.setForeground(Color.WHITE);
		btnNosotros.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 20));
		btnNosotros.setFocusable(false);
		btnNosotros.setBorderPainted(false);
		btnNosotros.setBackground(new Color(16, 6, 38));
		btnNosotros.setBounds(411, 47, 172, 37);
		jpnSuperiorCentro.add(btnNosotros);
		
		btnHospedajes = new JButton("Hospedajes");
		btnHospedajes.setForeground(Color.WHITE);
		btnHospedajes.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 20));
		btnHospedajes.setFocusable(false);
		btnHospedajes.setBorderPainted(false);
		btnHospedajes.setBackground(new Color(16, 6, 38));
		btnHospedajes.setBounds(0, 47, 172, 37);
		jpnSuperiorCentro.add(btnHospedajes);

		// Cargar y redimensionar la imagen
		try {
			BufferedImage originalImage = ImageIO.read(ViewAutenticacion.class.getResource("/imagenes/show.png"));

		} catch (IOException e2) {
			e2.printStackTrace();
		}

		/*
		 * this.btnLogin.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { ViewRegistro.this.dispose();
		 * ViewAutenticacion viewAutenticacion= new ViewAutenticacion();
		 * viewAutenticacion.setVisible(true);
		 * viewAutenticacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); } });
		 */
	}

	public JButton getBtnRegister() {
		return btnRegister;
	}

	public void setBtnRegister(JButton btnRegister) {
		this.btnRegister = btnRegister;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public RoundButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(RoundButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtId) {
		this.txtId = txtId;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(JTextField txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	
	
	public JButton getBtnContactanos() {
		return btnContactanos;
	}

	public void setBtnContactanos(JButton btnContactanos) {
		this.btnContactanos = btnContactanos;
	}

	public JButton getBtnNosotros() {
		return btnNosotros;
	}

	public void setBtnNosotros(JButton btnNosotros) {
		this.btnNosotros = btnNosotros;
	}

	public JButton getBtnHospedajes() {
		return btnHospedajes;
	}

	public void setBtnHospedajes(JButton btnHospedajes) {
		this.btnHospedajes = btnHospedajes;
	}

	public String pedirNombre() {
		String nombre = "";
		boolean nombreValido = false;

		try {
			nombre = txtNombre.getText();

			if (nombre.isEmpty()) {

				throw new Exception(" El campo de nombre no puede estar vacio");

			}

			if (nombre.matches("[a-zA-ZñÑ ]+")) {
				nombreValido = true;
			} else {
				throw new Exception("Ingrese un nombre válido (solo letras).");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}

		return nombre;
	}

	public String pedirApellido() {

		String apellido = "";
		boolean apellidoValido = false;

		try {

			apellido = txtApellido.getText();
			if (apellido.isEmpty()) {

				throw new Exception(" El campo de nombre no puede estar vacio");

			}

			if (apellido.matches("[a-zA-ZñÑ ]+")) {
				apellidoValido = true;

			} else {
				throw new Exception("Ingrese un nombre válido (solo letras).");

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}

		return apellido;
	}

	public String pedirEmail() {
		boolean emailValido = false;

		String email = "";

		try {

			email = txtCorreo.getText();

			// Expresión regular para validar el formato de correo electrónico
			String regex = "^[a-zA-Z0-9_+&*-ñÑ]+(?:\\.[a-zA-Z0-9_+&*-ñÑ]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-ZñÑ]{2,7}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(email);
			if (email.isEmpty()) {
				throw new Exception("El campo de email no puede estar vacío.");

			}

			// Verificar si el email coincide con el formato esperado
			if (matcher.matches()) {
				emailValido = true;
			} else {
				emailValido = false;
				throw new Exception("El correo electrónico no tiene un formato válido.");

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}

		return email;
	}

	public int pedirId() {
		String idTxt = "";
		int id = 0;
		boolean idValido = false;

		try {

			idTxt = txtId.getText();
			if (idTxt.isEmpty()) {
				idValido = false;
				throw new NumberFormatException("El campo de id no puede estar vacío.");
			} else {
				id = Integer.parseInt(idTxt);
				idValido = true;

			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Ingrese un id valido, Solo numeros", "Error",
					JOptionPane.ERROR_MESSAGE);

		}

		return id;

	}

	public long pedirNumeroTelefono() {
		String txtNumeroTelefono = "";

		long numeroTelefono = 0;

		boolean numeroTelefonoValido = false;

		try {
			txtNumeroTelefono = txtTelefono.getText();
			if (txtNumeroTelefono.isEmpty()) {
				throw new NumberFormatException("El campo de telefono no puede estar vacío.");
			} else {
				numeroTelefono = Long.parseLong(txtNumeroTelefono);
				numeroTelefonoValido = true;

			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Ingrese un telefono valido, Solo numeros", "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return numeroTelefono;
	}

	public String pedirDireccion() {
		String direccion = txtDireccion.getText();
		try {
			if (direccion.isEmpty()) {
				throw new Exception("El campo de direccion no puede estar vacío.");

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		return direccion;
	}

	public String pedirContrasena() {
		char[] passwordChars = passwordField.getPassword();
		String contrasena = new String(passwordChars);

		try {
			if (contrasena.isEmpty()) {
				java.util.Arrays.fill(passwordChars, ' ');
				throw new Exception("El campo de contraseña no puede estar vacío.");

			}
			java.util.Arrays.fill(passwordChars, ' ');
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		return contrasena;
	}

}
