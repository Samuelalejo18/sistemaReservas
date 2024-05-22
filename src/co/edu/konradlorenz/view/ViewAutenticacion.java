package co.edu.konradlorenz.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class ViewAutenticacion extends JFrame {


	private JPanel contentPane;
	private JPanel jpnInfo;
	private RoundedPanel jpnLogin;
	private RoundedPanel jpnFormulario;
	private JButton btnLogin;
	private JLabel lblIniciarSesion;
	private JTextField txtCorreo;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	private JLabel lblCorreo;
	private JLabel lblC;
	private JPanel jpnBuscaComparaReserva;
	private JLabel lblNewLabel;
	private RoundButton btnRegistrar;
	private JButton btnReservar;
	private JButton btnNosotros;
	private JButton btnContactanos;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { ViewAutenticacion frame = new
	 * ViewAutenticacion(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public ViewAutenticacion() {
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

		btnRegistrar = new RoundButton("Registrarse");
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setBackground(new Color(255, 255, 255));
		btnRegistrar.setForeground(new Color(16, 6, 38));
		btnRegistrar.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 21));
		
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ViewAutenticacion.class.getResource("/imagenes/flechas-a-la-derecha.png")));
		lblNewLabel_3.setBounds(440, 461, 244, 96);
		jpnInfo.add(lblNewLabel_3);
		btnRegistrar.setBounds(903, 38, 207, 48);
		jpnInfo.add(btnRegistrar);
		
		JPanel jpnSuperiorCentro = new JPanel();
		jpnSuperiorCentro.setBackground(new Color(16, 6, 38));
		jpnSuperiorCentro.setBounds(430, 0, 408, 120);
		jpnInfo.add(jpnSuperiorCentro);
		jpnSuperiorCentro.setLayout(null);
		
		btnReservar = new JButton("Reservar");
		btnReservar.setFocusPainted(false);
		btnReservar.setBackground(new Color(16, 6, 38));
		btnReservar.setBorderPainted(false);
		btnReservar.setForeground(new Color(255, 255, 255));
		btnReservar.setBounds(25, 64, 105, 23);
		btnReservar.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 14));
		jpnSuperiorCentro.add(btnReservar);
		
		btnContactanos = new JButton("Contáctanos");
		btnContactanos.setBackground(new Color(16, 6, 38));
		btnContactanos.setForeground(new Color(255, 255, 255));
		btnContactanos.setBorderPainted(false);
		btnContactanos.setBounds(140, 64, 128, 23);
		btnContactanos.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 14));
		jpnSuperiorCentro.add(btnContactanos);
		
		btnNosotros = new JButton("Nosotros");
		btnNosotros.setBackground(new Color(16, 6, 38));
		btnNosotros.setForeground(new Color(255, 255, 255));
		btnNosotros.setBorderPainted(false);
		btnNosotros.setBounds(278, 64, 105, 23);
		btnNosotros.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 14));
		jpnSuperiorCentro.add(btnNosotros);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(1120, 0, 101, 120);
		jpnInfo.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(ViewAutenticacion.class.getResource("/imagenes/flechas-a-la-derecha.png")));
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ViewAutenticacion.class.getResource("/imagenes/Captura de pantalla 2024-05-21 003128.png")));
		lblNewLabel_4.setBounds(100, 0, 331, 120);
		jpnInfo.add(lblNewLabel_4);
		
		
		

		jpnLogin = new RoundedPanel(50) ;
		jpnLogin.setBackground(new Color(51, 26, 108));
		jpnLogin.setBounds(99, 118, 1065, 613);

		contentPane.add(jpnLogin);
		jpnLogin.setLayout(null);

		jpnFormulario =  new RoundedPanel(50) ;
		jpnFormulario.setBounds(333, 116, 402, 396);
		jpnFormulario.setBackground(new Color(255, 255, 255));
		jpnLogin.add(jpnFormulario);

		btnLogin = new JButton("Iniciar Sesión");
		btnLogin.setBounds(124, 326, 150, 40);
		btnLogin.setFont(new Font("Raleway ExtraBold", Font.PLAIN, 12));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jpnFormulario.setLayout(null);
		btnLogin.setBackground(new Color(16, 6, 38));
		btnLogin.setForeground(new Color(255, 255, 255));
		jpnFormulario.add(btnLogin);

		lblIniciarSesion = new JLabel("Iniciar Sesión");
		lblIniciarSesion.setBounds(0, 11, 402, 63);
		lblIniciarSesion.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 40));
		lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		jpnFormulario.add(lblIniciarSesion);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(54, 153, 297, 34);
		jpnFormulario.add(txtCorreo);
		txtCorreo.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(54, 244, 297, 34);
		jpnFormulario.add(passwordField);
		   
		   
		   jpnFormulario.setComponentZOrder(passwordField, 1); // Poner passwordField detrás
		lblNewLabel_1 = new JLabel("Iniciar Sesión para continuar");
		lblNewLabel_1.setBounds(0, 85, 402, 14);
		lblNewLabel_1.setFont(new Font("Open Sans", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		jpnFormulario.add(lblNewLabel_1);

		lblCorreo = new JLabel("CORREO");
		lblCorreo.setBounds(54, 128, 297, 14);
		lblCorreo.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		jpnFormulario.add(lblCorreo);

		lblC = new JLabel("CONTRASEÑA");
		lblC.setBounds(54, 224, 297, 14);
		lblC.setFont(new Font("Open Sans", Font.BOLD, 11));
		lblC.setHorizontalAlignment(SwingConstants.LEFT);
		jpnFormulario.add(lblC);
		
		   // Crear el JLabel
        JLabel lblEye = new JLabel("");
        lblEye.setBounds(124, 289, 33, 23); // Establecer el tamaño y la posición del JLabel

        // Cargar y redimensionar la imagen
        try {
            BufferedImage originalImage = ImageIO.read(ViewAutenticacion.class.getResource("/imagenes/show.png"));
            
            Image resizedImage = originalImage.getScaledInstance(lblEye.getWidth(), lblEye.getHeight(), Image.SCALE_SMOOTH);
            lblEye.setIcon(new ImageIcon(resizedImage));
           
        } catch (IOException e2) {
            e2.printStackTrace();
        }

       
        jpnFormulario.add(lblEye);
        
     


        JButton toggleButton = new JButton("Mostrar");
        
        		toggleButton.setBackground(new Color(255, 255, 255));
        		toggleButton.setBounds(158, 289, 90, 23);
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
        		                BufferedImage originalImage = ImageIO.read(ViewAutenticacion.class.getResource("/imagenes/show.png"));
        		                Image resizedImage = originalImage.getScaledInstance(lblEye.getWidth(), lblEye.getHeight(), Image.SCALE_SMOOTH);
        		                lblEye.setIcon(new ImageIcon(resizedImage));
        		            } catch (IOException e2) {
        		                e2.printStackTrace();
        		            }

        		        } else {
        		            passwordField.setEchoChar((char) 0); // Mostrar contraseña
        		            toggleButton.setText("Ocultar");
        		            try {
        		                BufferedImage originalImage = ImageIO.read(ViewAutenticacion.class.getResource("/imagenes/hide.png"));
        		                Image resizedImage = originalImage.getScaledInstance(lblEye.getWidth(), lblEye.getHeight(), Image.SCALE_SMOOTH);
        		                lblEye.setIcon(new ImageIcon(resizedImage));
        		            } catch (IOException e2) {
        		                e2.printStackTrace();
        		            }
        		        }
        		        isPasswordVisible = !isPasswordVisible;
        		    }
        		});
		
				lblNewLabel = new JLabel("#BuscaComparaReserva");
				lblNewLabel.setBounds(788, 554, 244, 32);
				jpnLogin.add(lblNewLabel);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Open Sans SemiBold", Font.PLAIN, 14));
				jpnBuscaComparaReserva = new RoundedPanel(20);
				jpnBuscaComparaReserva.setBounds(788, 554, 244, 32);
				jpnBuscaComparaReserva.setBackground(new Color(179, 170, 255));
				jpnLogin.add(jpnBuscaComparaReserva);
				jpnBuscaComparaReserva.setLayout(null);
		
		/*
		this.btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ViewAutenticacion.this.dispose();
            	ViewRegistro viewRegistro= new ViewRegistro();
            	viewRegistro.setVisible(true);
            	viewRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        */
	}
		
	

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}

	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public RoundButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(RoundButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	public String pedirEmail() {
		boolean emailValido = false;

		String email = "";

		try {

			email = txtCorreo.getText();

			// Expresión regular para validar el formato de correo electrónico
			String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(email);

			// Verificar si el email coincide con el formato esperado
			if (matcher.matches()) {
				emailValido = true;
			} else if(email.isEmpty()) {
				JOptionPane.showMessageDialog(this, "El campo de email no puede estar vacío.", "Error",
	                    JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "El correo electrónico no tiene un formato válido.", "Error",
						JOptionPane.ERROR_MESSAGE);

				emailValido = false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();

		}

		return email;
	}
	public String pedirContrasena() {
	    char[] passwordChars = passwordField.getPassword();
	    String contrasena = new String(passwordChars);

	    if (contrasena.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "El campo de contraseña no puede estar vacío.", "Error",
	                JOptionPane.ERROR_MESSAGE);
	    
	        java.util.Arrays.fill(passwordChars, ' ');
	        
	    }

	  
	    java.util.Arrays.fill(passwordChars, ' ');

	    return contrasena;
	}
}