package co.edu.konradlorenz.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import co.edu.konradlorenz.model.cliente.Cliente;
import co.edu.konradlorenz.model.excepciones.HospedajeNoEncontradoException;
import co.edu.konradlorenz.model.habitaciones.HabitacionBase;
import co.edu.konradlorenz.model.habitaciones.HabitacionDoble;
import co.edu.konradlorenz.model.habitaciones.HabitacionPresidencial;
import co.edu.konradlorenz.model.habitaciones.HabitacionSuite;
import co.edu.konradlorenz.model.hospedajes.Cabana;
import co.edu.konradlorenz.model.hospedajes.Camping;
import co.edu.konradlorenz.model.hospedajes.Glamping;
import co.edu.konradlorenz.model.hospedajes.Hospedaje;
import co.edu.konradlorenz.model.hospedajes.Hotel;
import co.edu.konradlorenz.model.hospedajes.Motel;
import co.edu.konradlorenz.model.hospedajes.Resort;
import co.edu.konradlorenz.view.RoundButton;
import co.edu.konradlorenz.view.RoundButtonCircle;
import co.edu.konradlorenz.view.RoundedPanel;
import co.edu.konradlorenz.view.ViewHospedaje;

public class ControllerHospedajes implements ActionListener {

	JPanel jpnCardHospedaje;
	ViewHospedaje viewHospedaje;
	RoundButtonCircle btnBuscarNombre;
	RoundButtonCircle btnBuscarPais;
	RoundButtonCircle btnBuscarCiudad;
	RoundButton btnCabanas;
	RoundButton btnHoteles;
	RoundButton btnResorts;
	RoundButton btnMoteles;
	RoundButton btnCampings;
	RoundButton btnGlamping;
	RoundButtonCircle btnBuscarPrecio;
	JComboBox<String> cboTipo;
	JComboBox<String> cboEstrellas;
	RoundButtonCircle btnAll;
	RoundButton btnReservar;
	RoundButton btnLogin;
	ControllerAutenticacion controllerAutenticacion;
	Cliente usuarioAutenticado;
	JButton btnNosotros;
	JButton btnContactanos;
	ControllerReserva controllerReserva;

	public ControllerHospedajes() {
		registrarHospedajes();
		viewHospedaje = new ViewHospedaje();

		btnBuscarNombre = viewHospedaje.getBtnBuscarNombre();
		btnBuscarPais = viewHospedaje.getBtnBuscarPais();
		btnBuscarCiudad = viewHospedaje.getBtnBuscarCiudad();
		btnBuscarNombre.addActionListener(this);
		btnBuscarPais.addActionListener(this);
		btnBuscarCiudad.addActionListener(this);
		btnHoteles = viewHospedaje.getBtnHoteles();
		btnResorts = viewHospedaje.getBtnResorts();
		btnMoteles = viewHospedaje.getBtnMoteles();
		btnCabanas = viewHospedaje.getBtnCabanas();
		btnCampings = viewHospedaje.getBtnCampings();
		btnGlamping = viewHospedaje.getBtnGlamping();
		btnBuscarPrecio = viewHospedaje.getBtnBuscarPrecio();
		btnAll = viewHospedaje.getBtnAll();

		btnLogin = viewHospedaje.getBtnLogin();
		btnReservar = viewHospedaje.getBtnReservar();

		btnHoteles.addActionListener(this);
		btnResorts.addActionListener(this);
		btnMoteles.addActionListener(this);
		btnCabanas.addActionListener(this);
		btnCampings.addActionListener(this);
		btnGlamping.addActionListener(this);
		btnBuscarPrecio.addActionListener(this);
		btnAll.addActionListener(this);
		btnReservar.addActionListener(this);
		btnLogin.addActionListener(this);

		cboTipo = viewHospedaje.getCboTipo();
		cboEstrellas = viewHospedaje.getCboEstrellas();
		cboTipo.addActionListener(this);
		cboEstrellas.addActionListener(this);

		mostrarVentanaHospedaje(true);
		hospedajesDisponibles();
		Cliente usuarioAutenticado = ControllerAutenticacion.usuarioAutenticado;

		btnContactanos = viewHospedaje.getBtnContactanos();
		btnNosotros = viewHospedaje.getBtnNosotros();

		btnContactanos.addActionListener(this);
		btnNosotros.addActionListener(this);

		if (usuarioAutenticado != null) {
			viewHospedaje.getJpnUsuario().removeAll();
			viewHospedaje.mostrarNameUsuario(usuarioAutenticado.getNombre() + " " + usuarioAutenticado.getApellido());
		} else {
			usuarioAutenticado = null;
		}

	}

	static ArrayList<Hospedaje> hospedajes = new ArrayList<>();

	public static ArrayList<Hospedaje> getHospedajes() {
		return hospedajes;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			viewHospedaje.dispose();
			ControllerAutenticacion controllerAutenticacion = new ControllerAutenticacion();
			viewHospedaje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}

		if (e.getSource() == btnReservar) {
			Cliente usuarioAutenticado = ControllerAutenticacion.usuarioAutenticado;
			if (usuarioAutenticado != null) {
				viewHospedaje.dispose();
				ControllerReserva controllerReserva = new ControllerReserva();

				viewHospedaje.setVisible(false);
			} else {

				JOptionPane.showMessageDialog(viewHospedaje, "Autentificate para reservar", "Error",
						JOptionPane.ERROR_MESSAGE);

			}

		}

		if (e.getSource() == btnAll) {
			viewHospedaje.getJpnHospedajes().removeAll();
			hospedajesDisponibles();
		}

		if (e.getSource() == btnBuscarNombre) {
			try {

				viewHospedaje.getJpnHospedajes().removeAll();
				buscarPorNombre(viewHospedaje.pedirNombreHospedaje());
			} catch (HospedajeNoEncontradoException e1) {
				JOptionPane.showMessageDialog(viewHospedaje, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}

		if (e.getSource() == btnBuscarPais) {
			try {
				viewHospedaje.getJpnHospedajes().removeAll();
				filtrarPorPais(viewHospedaje.pedirPais());
			} catch (HospedajeNoEncontradoException e1) {
				JOptionPane.showMessageDialog(viewHospedaje, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}

		if (e.getSource() == btnBuscarCiudad) {
			try {
				viewHospedaje.getJpnHospedajes().removeAll();
				filtrarCiudad(viewHospedaje.pedirCiudad());
			} catch (HospedajeNoEncontradoException e1) {
				JOptionPane.showMessageDialog(viewHospedaje, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}

		if (e.getSource() == btnHoteles) {
			viewHospedaje.getJpnHospedajes().removeAll();

			filtrarHoteles();
		}

		if (e.getSource() == btnMoteles) {
			viewHospedaje.getJpnHospedajes().removeAll();
			filtrarMoteles();
		}

		if (e.getSource() == btnResorts) {
			viewHospedaje.getJpnHospedajes().removeAll();
			filtralResorts();
		}

		if (e.getSource() == btnCabanas) {
			viewHospedaje.getJpnHospedajes().removeAll();
			filtrarCabanas();
		}

		if (e.getSource() == btnCampings) {
			viewHospedaje.getJpnHospedajes().removeAll();
			filtrarCampings();
		}

		if (e.getSource() == btnGlamping) {
			viewHospedaje.getJpnHospedajes().removeAll();
			filtrarGlampings();
		}

		if (e.getSource() == btnBuscarPrecio) {

			try {
				viewHospedaje.getJpnHospedajes().removeAll();
				filtrarPorPrecio(viewHospedaje.pedirPrecioMinimo(), viewHospedaje.pedirPrecioMaximo());
			} catch (HospedajeNoEncontradoException e1) {
				JOptionPane.showMessageDialog(viewHospedaje, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}

		}

		if (e.getSource() == cboTipo) {
			try {
				viewHospedaje.getJpnHospedajes().removeAll();
				String opcionTipo = (String) cboTipo.getSelectedItem();
				filtrarTipo(opcionTipo);
			} catch (HospedajeNoEncontradoException e1) {
				JOptionPane.showMessageDialog(viewHospedaje, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}

		if (e.getSource() == cboEstrellas) {
			int opcionEstrellas = (int) cboEstrellas.getSelectedIndex() + 1;

			try {
				viewHospedaje.getJpnHospedajes().removeAll();
				filtrarPorNumeroDeEstrellas(opcionEstrellas);
			} catch (HospedajeNoEncontradoException e1) {
				JOptionPane.showMessageDialog(viewHospedaje, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}

		if (e.getSource() == btnContactanos) {
			viewHospedaje.dispose();
			ControllerContactanos controllerContactanos = new ControllerContactanos();
			viewHospedaje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}

	}

	public void mostrarVentanaHospedaje(boolean visible) {
		viewHospedaje.setVisible(true);
		viewHospedaje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public String hallarTipoHospedaje(Hospedaje hospedaje) {
		String tipoHospedaje = "no existe";
		if (hospedaje instanceof Hotel) {
			tipoHospedaje = "Hotel";
		} else if (hospedaje instanceof Cabana) {
			tipoHospedaje = "Cabaña";
		} else if (hospedaje instanceof Camping) {
			tipoHospedaje = "Camping";
		} else if (hospedaje instanceof Glamping) {
			tipoHospedaje = "Glamping";
		} else if (hospedaje instanceof Motel) {
			tipoHospedaje = "Motel";
		} else if (hospedaje instanceof Resort) {
			tipoHospedaje = "Resort";
		}
		return tipoHospedaje;
	}

	public void hospedajesDisponibles() {
		int x = 70;
		int y = 40;
		try {
			for (Hospedaje hospedaje : hospedajes) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				RoundedPanel card = viewHospedaje.mostrarPanelHospedaje(tipoHospedaje, hospedaje.getNombre(),
						hospedaje.getUbicacionCiudad(), hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(),
						hospedaje.getDescripcion(), hospedaje.getTipo(), hospedaje.getPrecioPorPersona(),
						hospedaje.getUrl());
				card.setBounds(x, y, 280, 325);
				viewHospedaje.getJpnHospedajes().add(card);
				x += 335;

				if (x >= 1362) {
					x = 70;
					y += 360;

				}

			}

			viewHospedaje.getJpnHospedajes().setPreferredSize(new Dimension(1432, y + 20));

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscarPorNombre(String nombre) throws HospedajeNoEncontradoException {
		boolean encontradoNombre = false;
		int x = 70;
		int y = 40;

		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getNombre().equalsIgnoreCase(nombre)) {
				encontradoNombre = true;
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				RoundedPanel card = viewHospedaje.mostrarPanelHospedaje(tipoHospedaje, hospedaje.getNombre(),
						hospedaje.getUbicacionCiudad(), hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(),
						hospedaje.getDescripcion(), hospedaje.getTipo(), hospedaje.getPrecioPorPersona(),
						hospedaje.getUrl());
				card.setBounds(x, y, 280, 325);
				viewHospedaje.getJpnHospedajes().add(card);

			}
		}
		viewHospedaje.getJpnHospedajes().setPreferredSize(new Dimension(1432, y + 20));

		if (!encontradoNombre) {
			throw new HospedajeNoEncontradoException("Su busqueda no fue reconocida");
		}

	}

	public void filtrarCiudad(String ubicacionCiudad) throws HospedajeNoEncontradoException {
		boolean encontradoCiudad = false;
		int x = 70;
		int y = 40;

		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getUbicacionCiudad().equalsIgnoreCase(ubicacionCiudad)) {
				encontradoCiudad = true;
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				RoundedPanel card = viewHospedaje.mostrarPanelHospedaje(tipoHospedaje, hospedaje.getNombre(),
						hospedaje.getUbicacionCiudad(), hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(),
						hospedaje.getDescripcion(), hospedaje.getTipo(), hospedaje.getPrecioPorPersona(),
						hospedaje.getUrl());
				card.setBounds(x, y, 280, 325);
				viewHospedaje.getJpnHospedajes().add(card);
				x += 335;

				if (x >= 1362) {
					x = 70;
					y += 360;

				}
			}
		}
		viewHospedaje.getJpnHospedajes().setPreferredSize(new Dimension(1432, y + 500));

		if (!encontradoCiudad) {
			throw new HospedajeNoEncontradoException("Su busqueda no fue reconocida");
		}
	}

	public void filtrarPorPais(String ubicacionPais) throws HospedajeNoEncontradoException {
		boolean encontrado = false;
		int x = 70;
		int y = 40;
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getUbicacionPais().equalsIgnoreCase(ubicacionPais)) {
				encontrado = true;
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				RoundedPanel card = viewHospedaje.mostrarPanelHospedaje(tipoHospedaje, hospedaje.getNombre(),
						hospedaje.getUbicacionCiudad(), hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(),
						hospedaje.getDescripcion(), hospedaje.getTipo(), hospedaje.getPrecioPorPersona(),
						hospedaje.getUrl());
				card.setBounds(x, y, 280, 325);
				viewHospedaje.getJpnHospedajes().add(card);
				x += 335;

				if (x >= 1362) {
					x = 70;
					y += 360;

				}
				encontrado = true;

			}

		}

		if (!encontrado) {
			throw new HospedajeNoEncontradoException("Su busqueda no fue reconocida");
		}
		viewHospedaje.getJpnHospedajes().setPreferredSize(new Dimension(1432, y + 500));
	}

	public void filtrarPorNumeroDeEstrellas(int numeroDeEstrellas) throws HospedajeNoEncontradoException {
		boolean encontradoEstrellas = false;
		int x = 70;
		int y = 40;

		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getNumeroEstrellas() == numeroDeEstrellas) {
				encontradoEstrellas = true;
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				RoundedPanel card = viewHospedaje.mostrarPanelHospedaje(tipoHospedaje, hospedaje.getNombre(),
						hospedaje.getUbicacionCiudad(), hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(),
						hospedaje.getDescripcion(), hospedaje.getTipo(), hospedaje.getPrecioPorPersona(),
						hospedaje.getUrl());
				card.setBounds(x, y, 280, 325);
				viewHospedaje.getJpnHospedajes().add(card);
				x += 335;

				if (x >= 1362) {
					x = 70;
					y += 360;

				}

			}
		}
		viewHospedaje.getJpnHospedajes().setPreferredSize(new Dimension(1432, y + 500));
		if (!encontradoEstrellas) {
			throw new HospedajeNoEncontradoException("Su busqueda no fue reconocida");
		}

	}

	// Tipo urbano o rural

	public void filtrarTipo(String tipo) throws HospedajeNoEncontradoException {
		boolean encontradoTipo = false;
		int x = 70;
		int y = 40;
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getTipo().equalsIgnoreCase(tipo)) {
				encontradoTipo = true;
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				RoundedPanel card = viewHospedaje.mostrarPanelHospedaje(tipoHospedaje, hospedaje.getNombre(),
						hospedaje.getUbicacionCiudad(), hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(),
						hospedaje.getDescripcion(), hospedaje.getTipo(), hospedaje.getPrecioPorPersona(),
						hospedaje.getUrl());
				card.setBounds(x, y, 280, 325);
				viewHospedaje.getJpnHospedajes().add(card);
				x += 335;

				if (x >= 1362) {
					x = 70;
					y += 360;

				}

			}
		}
		viewHospedaje.getJpnHospedajes().setPreferredSize(new Dimension(1432, y + 500));
		if (!encontradoTipo) {
			throw new HospedajeNoEncontradoException("Su busqueda no fue reconocida");
		}
	}

	// Tipo urbano o rural

	public void filtrarHoteles() {

		int x = 70;
		int y = 40;
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Hotel) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				RoundedPanel card = viewHospedaje.mostrarPanelHospedaje(tipoHospedaje, hospedaje.getNombre(),
						hospedaje.getUbicacionCiudad(), hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(),
						hospedaje.getDescripcion(), hospedaje.getTipo(), hospedaje.getPrecioPorPersona(),
						hospedaje.getUrl());
				card.setBounds(x, y, 280, 325);
				viewHospedaje.getJpnHospedajes().add(card);
				x += 335;

				if (x >= 1362) {
					x = 70;
					y += 360;

				}

			}
		}
		viewHospedaje.getJpnHospedajes().setPreferredSize(new Dimension(1432, y + 500));

	}

	public void filtrarMoteles() {
		int x = 70;
		int y = 40;
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Motel) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				RoundedPanel card = viewHospedaje.mostrarPanelHospedaje(tipoHospedaje, hospedaje.getNombre(),
						hospedaje.getUbicacionCiudad(), hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(),
						hospedaje.getDescripcion(), hospedaje.getTipo(), hospedaje.getPrecioPorPersona(),
						hospedaje.getUrl());
				card.setBounds(x, y, 280, 325);
				viewHospedaje.getJpnHospedajes().add(card);
				x += 335;

				if (x >= 1362) {
					x = 70;
					y += 360;

				}

			}
		}
		viewHospedaje.getJpnHospedajes().setPreferredSize(new Dimension(1432, y + 500));
	}

	public void filtralResorts() {
		int x = 70;
		int y = 40;
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Resort) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				RoundedPanel card = viewHospedaje.mostrarPanelHospedaje(tipoHospedaje, hospedaje.getNombre(),
						hospedaje.getUbicacionCiudad(), hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(),
						hospedaje.getDescripcion(), hospedaje.getTipo(), hospedaje.getPrecioPorPersona(),
						hospedaje.getUrl());
				card.setBounds(x, y, 280, 325);
				viewHospedaje.getJpnHospedajes().add(card);
				x += 335;

				if (x >= 1362) {
					x = 70;
					y += 360;

				}

			}
		}
		viewHospedaje.getJpnHospedajes().setPreferredSize(new Dimension(1432, y + 500));
	}

	public void filtrarCampings() {
		int x = 70;
		int y = 40;
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Camping) {

				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				RoundedPanel card = viewHospedaje.mostrarPanelHospedaje(tipoHospedaje, hospedaje.getNombre(),
						hospedaje.getUbicacionCiudad(), hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(),
						hospedaje.getDescripcion(), hospedaje.getTipo(), hospedaje.getPrecioPorPersona(),
						hospedaje.getUrl());
				card.setBounds(x, y, 280, 325);
				viewHospedaje.getJpnHospedajes().add(card);
				x += 335;

				if (x >= 1362) {
					x = 70;
					y += 360;

				}
			}
		}
		viewHospedaje.getJpnHospedajes().setPreferredSize(new Dimension(1432, y + 500));
	}

	public void filtrarGlampings() {
		int x = 70;
		int y = 40;
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Glamping) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				RoundedPanel card = viewHospedaje.mostrarPanelHospedaje(tipoHospedaje, hospedaje.getNombre(),
						hospedaje.getUbicacionCiudad(), hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(),
						hospedaje.getDescripcion(), hospedaje.getTipo(), hospedaje.getPrecioPorPersona(),
						hospedaje.getUrl());
				card.setBounds(x, y, 280, 325);
				viewHospedaje.getJpnHospedajes().add(card);
				x += 335;

				if (x >= 1362) {
					x = 70;
					y += 360;

				}

			}
		}
		viewHospedaje.getJpnHospedajes().setPreferredSize(new Dimension(1432, y + 500));
	}

	public void filtrarCabanas() {
		int x = 70;
		int y = 40;
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Cabana) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				RoundedPanel card = viewHospedaje.mostrarPanelHospedaje(tipoHospedaje, hospedaje.getNombre(),
						hospedaje.getUbicacionCiudad(), hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(),
						hospedaje.getDescripcion(), hospedaje.getTipo(), hospedaje.getPrecioPorPersona(),
						hospedaje.getUrl());
				card.setBounds(x, y, 280, 325);
				viewHospedaje.getJpnHospedajes().add(card);
				x += 335;

				if (x >= 1362) {
					x = 70;
					y += 360;

				}

			}
		}
		viewHospedaje.getJpnHospedajes().setPreferredSize(new Dimension(1432, y + 500));
	}

	public void filtrarPorPrecio(int min, int max) throws HospedajeNoEncontradoException {
		boolean encontradoPrecio = false;
		// PENDIENTEEETEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
		int x = 70;
		int y = 40;
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getPrecioPorPersona() > min && hospedaje.getPrecioPorPersona() <= max) {

				encontradoPrecio = true;
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				RoundedPanel card = viewHospedaje.mostrarPanelHospedaje(tipoHospedaje, hospedaje.getNombre(),
						hospedaje.getUbicacionCiudad(), hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(),
						hospedaje.getDescripcion(), hospedaje.getTipo(), hospedaje.getPrecioPorPersona(),
						hospedaje.getUrl());
				card.setBounds(x, y, 280, 325);
				viewHospedaje.getJpnHospedajes().add(card);

				x += 335;

				if (x >= 1362) {
					x = 70;
					y += 360;

				}
			}
		}
		viewHospedaje.getJpnHospedajes().setPreferredSize(new Dimension(1432, y + 500));
		if (!encontradoPrecio) {
			throw new HospedajeNoEncontradoException("Su busqueda no fue reconocida");
		}

	}

	public void registrarHospedajes() {

		/* Cabañas */
		Cabana cabana1 = new Cabana("Cabaña las mercedes", "Villeta", "Colombia", 2, "Cabaña bonita", "Cabaña rural",
				230000, "/imagenes2/Cabana-1.png", "Luces bonitas amarillas", true, "Baño frente a la cascada");
		hospedajes.add(cabana1);
		HabitacionDoble habitacionDoble1 = new HabitacionDoble(2, true, 50000,
				"1 Cama Doble, Baño amplio, Jacuzzi Privado");

		cabana1.agregarHabitacion(habitacionDoble1);

		Cabana cabana2 = new Cabana("Cabaña de Montaña", "Monterrey", "Mexico", 6,
				"Una acogedora cabaña en medio de las montañas", "Rural", 330000, "/imagenes2/Cabana-2.png", "Rústica",
				true, "Senderismo");
		hospedajes.add(cabana2);
		HabitacionDoble habitacionDoble2n = new HabitacionDoble(2, true, 60000,
				"1 Cama Doble + 2 Camarote + Ropero + Baño Privado");
		HabitacionDoble habitacionDoble2 = new HabitacionDoble(4, true, 60000,
				"Cama King + 2 Camarote + Ropero + Baño Privado");
		cabana2.agregarHabitacion(habitacionDoble2n);
		cabana2.agregarHabitacion(habitacionDoble2);

		Cabana cabana3 = new Cabana("Cabaña de Playa", "Cancun", "Mexico", 4,
				"Un refugio junto al mar con vista panorámica", "Rural", 120000, "/imagenes2/Cabana-3.png", "Tropical",
				true, "Surf");
		hospedajes.add(cabana3);
		HabitacionSuite habitacionSuitecabana = new HabitacionSuite(2, false, 700000,
				"Aire acondicionado, Playa privada, Balcón privado, Suites");
		cabana3.agregarHabitacion(habitacionSuitecabana);

		Cabana cabana4 = new Cabana("Cabaña en el Bosque", "Toronto", "Canada", 3,
				"Un retiro tranquilo rodeado de árboles centenarios", "Rural", 80000, "/imagenes2/Cabana-4.png",
				"Vintage", true, "Observación de aves");
		hospedajes.add(cabana4);
		HabitacionBase habitacionBase4 = new HabitacionBase(2, true, 0, "Wifi, TV");
		HabitacionDoble habitacionDoble4 = new HabitacionDoble(4, true, 40000, "Queen");

		cabana4.agregarHabitacion(habitacionBase4);
		cabana4.agregarHabitacion(habitacionDoble4);

		Cabana cabana5 = new Cabana("Cabaña junto al Lago", "Medellin", "Colombia", 5,
				"Una cabaña con acceso directo al lago cristalino", "Rural", 220000, "/imagenes2/Cabana-5.png",
				"Moderna", false, "Pesca");
		hospedajes.add(cabana5);

		HabitacionDoble habitacionDoble5 = new HabitacionDoble(2, false, 80000, "King");

		cabana5.agregarHabitacion(habitacionDoble5);

		Cabana cabana6 = new Cabana("Cabaña de Aventura", "La vega", "Colombia", 4,
				"Una cabaña para los amantes de la adrenalina", "Rural", 170000, "/imagenes2/Cabana-6.png",
				"Minimalista", true, "Escalada");
		hospedajes.add(cabana6);

		HabitacionBase habitacionBase6 = new HabitacionBase(2, true, 0, "Wifi, TV, Baño privado");
		HabitacionBase habitacionBase6n = new HabitacionBase(2, true, 55000, "Matrimonial");

		cabana6.agregarHabitacion(habitacionBase6);
		cabana6.agregarHabitacion(habitacionBase6n);

		Cabana cabana7 = new Cabana("Cabaña Histórica", "Villeta", "Colombia", 3,
				"Una cabaña con siglos de historia en su interior", "Rural", 60000, "/imagenes2/Cabana-7.png",
				"Antigua", false, "Visitas guiadas");
		hospedajes.add(cabana7);

		HabitacionBase habitacionBase7 = new HabitacionBase(4, true, 0, "Wifi, TV, Cocina");
		HabitacionDoble habitacionDoble7 = new HabitacionDoble(2, true, 30000, "Queen");
		cabana7.agregarHabitacion(habitacionBase7);
		cabana7.agregarHabitacion(habitacionDoble7);

		Cabana cabana8 = new Cabana("Cabana de Campo", "Capitanejo", "Colombia", 5,
				"Un refugio campestre con todas las comodidades", "Rural", 300000, "/imagenes2/Cabana-8.png", "", false,
				"");

		hospedajes.add(cabana8);
		HabitacionBase habitacionBase8 = new HabitacionBase(4, true, 0, "Wifi, TV, Aire acondicionado");
		HabitacionDoble habitacionDoble8 = new HabitacionDoble(2, true, 45000, "King");
		cabana8.agregarHabitacion(habitacionBase8);
		cabana8.agregarHabitacion(habitacionDoble8);

		Cabana cabana9 = new Cabana("Cabana Ecológica", "Anapoima", "Colombia", 4,
				"Una cabaña diseñada para minimizar su impacto ambiental", "Rural", 210000, "/imagenes2/Cabana-9.png",
				"Sostenible", false, "Reciclaje");
		hospedajes.add(cabana9);

		HabitacionBase habitacionBase9 = new HabitacionBase(1, true, 0, "Wifi, TV, Caja fuerte");
		HabitacionDoble habitacionDoble9 = new HabitacionDoble(3, true, 40000, "Matrimonial");
		cabana9.agregarHabitacion(habitacionBase9);
		cabana9.agregarHabitacion(habitacionDoble9);

		Cabana cabana10 = new Cabana("Cabana Romántica", "Neusa", "Colombia", 3,
				"Un rincón íntimo para parejas en busca de tranquilidad", "Rural", 150000, "/imagenes2/Cabana-10.png",
				"Acogedora", true, "Masajes");
		hospedajes.add(cabana10);
		HabitacionDoble habitacionDoble10 = new HabitacionDoble(4, true, 35000, "Queen");

		cabana10.agregarHabitacion(habitacionDoble10);

		Cabana cabana11 = new Cabana("Cabana de Lujo", "Anapoima", "Colombia", 5,
				"Una experiencia exclusiva con servicio de primera clase", "Rural", 400000, "/imagenes2/Cabana-11.png",
				"Elegante", false, "Gastronomía gourmet");
		hospedajes.add(cabana11);

		HabitacionBase habitacionBase11 = new HabitacionBase(2, true, 0, "Wifi, TV, Jacuzzi");
		HabitacionDoble habitacionDoble11 = new HabitacionDoble(2, false, 90000, "King");
		cabana11.agregarHabitacion(habitacionBase11);
		cabana11.agregarHabitacion(habitacionDoble11);

		/* Camping */
		Camping camping1 = new Camping("Camping de Montaña", "Ciudad del cabo", "Sudafrica", 5,
				"Un camping rodeado de montañas", "Rural", 420000, "/imagenes2/Camping-1.png", "Área de fogatas",
				"Senderismo");

		hospedajes.add(camping1);
		HabitacionBase habitacion12 = new HabitacionBase(1, true, 0, "Con vistas a  la montana");
		HabitacionDoble habitacionDoble12 = new HabitacionDoble(4, true, 80000, "Queen");
		camping1.agregarHabitacion(habitacion12);
		camping1.agregarHabitacion(habitacionDoble12);

		Camping camping2 = new Camping("Camping junto al Río", "Banff", "Canada", 4, "Un camping con vista al río",
				"Rural", 320000, "/imagenes2/Camping-2.png", "Zona de barbacoa", "Pesca");
		hospedajes.add(camping2);
		HabitacionBase habitacion13 = new HabitacionBase(2, true, 0, "Con escritorio");
		HabitacionDoble habitacionDoble13 = new HabitacionDoble(3, true, 60000, "King");
		camping1.agregarHabitacion(habitacion13);
		camping1.agregarHabitacion(habitacionDoble13);

		Camping camping3 = new Camping("Camping en el Bosque", "Berguen", "Noruega", 3, "Un camping entre árboles",
				"Rural", 170000, "/imagenes2/Camping-3.png", "Piscina natural", "Observación de aves");
		hospedajes.add(camping3);
		HabitacionBase habitacion14 = new HabitacionBase(2, false, 0, "Con armario empotrado");
		HabitacionDoble habitacionDoble14 = new HabitacionDoble(4, false, 40000, "Matrimonial");
		camping3.agregarHabitacion(habitacion14);
		camping3.agregarHabitacion(habitacionDoble14);

		Camping camping4 = new Camping("Camping en la Playa", "Interlaken", "Suiza", 5, "Un camping cerca del mar",
				"Rural", 720000, "/imagenes2/Camping-4.png", "Zona de descanso", "Surf");
		hospedajes.add(camping4);
		HabitacionBase habitacion15 = new HabitacionBase(2, true, 0, "Con cama Queen Size");
		HabitacionDoble habitacionDoble15 = new HabitacionDoble(5, true, 70000, "Doble");
		camping4.agregarHabitacion(habitacion15);
		camping4.agregarHabitacion(habitacionDoble15);

		Camping camping5 = new Camping("Camping Familiar", "Moab", "Estados Unidos", 4,
				"Un camping ideal para familias", "Rural", 230000, "/imagenes2/Camping-5.png", "Parque infantil",
				"Excursiones");

		hospedajes.add(camping5);
		HabitacionBase habitacion16 = new HabitacionBase(2, false, 0, "Con balcón privado");
		HabitacionDoble habitacionDoble16 = new HabitacionDoble(3, false, 45000, "Individual");
		camping5.agregarHabitacion(habitacion16);
		camping5.agregarHabitacion(habitacionDoble16);

		Camping camping6 = new Camping("Camping de Aventura", "San Carlos De bariloche", "Argentina", 3,
				"Un camping para los amantes de la adrenalina", "Rural", 130000, "/imagenes2/Camping-6.png",
				"Pared de escalada", "Rafting");
		hospedajes.add(camping6);
		HabitacionBase habitacion17 = new HabitacionBase(1, true, 0, "Con servicio de habitaciones 24 horas");
		HabitacionDoble habitacionDoble17 = new HabitacionDoble(4, true, 35000, "Estándar");
		camping6.agregarHabitacion(habitacion17);
		camping6.agregarHabitacion(habitacionDoble17);

		Camping camping7 = new Camping("Camping Eco-Friendly", "Cairns", "Australia", 5,
				"Un camping comprometido con el medio ambiente", "Rural", 370000, "/imagenes2/Camping-7.png",
				"Reciclaje", "Observación de estrellas");
		hospedajes.add(camping7);
		HabitacionBase habitacion18 = new HabitacionBase(1, true, 0, "Con cafetera");
		HabitacionDoble habitacionDoble18 = new HabitacionDoble(2, true, 65000, "Deluxe");
		camping7.agregarHabitacion(habitacion18);
		camping7.agregarHabitacion(habitacionDoble18);

		Camping camping8 = new Camping("Camping de Relax", "Queenstown", "Nueva Zelanda", 4,
				"Un camping para desconectar y relajarse", "Rural", 340000, "/imagenes2/Camping-8.png",
				"Área de meditación", "Yoga");
		hospedajes.add(camping8);
		HabitacionBase habitacion19 = new HabitacionBase(2, true, 0, "Con bañera de hidromasaje");
		HabitacionDoble habitacionDoble19 = new HabitacionDoble(4, false, 45000, "Junior");
		camping8.agregarHabitacion(habitacion19);
		camping8.agregarHabitacion(habitacionDoble19);

		Camping camping9 = new Camping("Camping de Aventura Extrema", "Salzburgo", "Australia", 3,
				"Un camping para los más intrépidos", "Rural", 250000, "/imagenes2/Camping-9.png", "Tirolesa",
				"Escalada");
		hospedajes.add(camping9);
		HabitacionBase habitacion20 = new HabitacionBase(2, false, 0, "Con acceso a la piscina");
		HabitacionDoble habitacionDoble20 = new HabitacionDoble(4, true, 40000, "Presidencial");
		camping9.agregarHabitacion(habitacion20);
		camping9.agregarHabitacion(habitacionDoble20);

		Camping camping10 = new Camping("Camping Romántico", "Glencoe", "Escocia", 5,
				"Un camping para parejas en busca de romance", "Rural", 1000000, "/imagenes2/Camping-10.png",
				"Área de picnic", "Paseos nocturnos");
		hospedajes.add(camping10);
		HabitacionDoble habitacionDoble21 = new HabitacionDoble(4, true, 90000, "Ejecutiva");
		camping10.agregarHabitacion(habitacionDoble21);

		Camping camping11 = new Camping("Camping las maravillas", "Anapoima", "Colombia", 3,
				"Camping con excelente ubicacion", "rural", 180000, "/imagenes2/Camping-11.png",
				"Cercano a parrillas comunitarias", "Yoga");

		hospedajes.add(camping11);
		HabitacionBase habitacion22 = new HabitacionBase(2, true, 0, "Con vistas al río");
		HabitacionDoble habitacionDoble22 = new HabitacionDoble(4, true, 40000, "Familiar");

		camping11.agregarHabitacion(habitacion22);
		camping11.agregarHabitacion(habitacionDoble22);

		/* Glampings */

		Glamping glamping1 = new Glamping("Glamping donde Julian", "Guatape", "Colombia", 5,
				"Glamping perfecto para ir con tu pareja", "rural", 450000, "/imagenes2/Glamping-1.png",
				"Vistas con mucha fauna", "Comida", "Todo es reciclable");
		hospedajes.add(glamping1);
		HabitacionBase habitacionBase23 = new HabitacionBase(3, true, 0, "Con vistas al jardín");
		HabitacionDoble habitacionDoble23 = new HabitacionDoble(2, true, 48000, "Queen");

		glamping1.agregarHabitacion(habitacionBase23);
		glamping1.agregarHabitacion(habitacionDoble23);

		Glamping glamping2 = new Glamping("Glamping de Montaña", "Monteverde", "Costa Rica", 5,
				"Una experiencia de lujo en la naturaleza", "Rural", 320000, "/imagenes2/Glamping-2.png",
				"Observación de estrellas", "Servicio de masajes", "Paneles solares");
		hospedajes.add(glamping2);

		HabitacionDoble habitacionDoble24 = new HabitacionDoble(2, true, 20.0, "King");

		Glamping glamping3 = new Glamping("Glamping Ecológico", "El Chalten", "Argentina", 4,
				"Un glamping comprometido con el medio ambiente", "Rural", 230000, "/imagenes2/Glamping-3.png",
				"Senderismo guiado", "Cocina gourmet", "Reciclaje");
		hospedajes.add(glamping3);

		HabitacionBase habitacionBase25 = new HabitacionBase(4, false, 0, "Con aire acondicionado");
		HabitacionDoble habitacionDoble25 = new HabitacionDoble(2, false, 30.0, "Matrimonial");

		Glamping glamping4 = new Glamping("Glamping Romántico", "Vietnam", "Vietnam", 4,
				"Un refugio íntimo para parejas", "Rural", 375000, "/imagenes2/Glamping-4.png", "Paseos a caballo",
				"Baño de burbujas", "Energía renovable");
		hospedajes.add(glamping4);
		HabitacionBase habitacionBase26 = new HabitacionBase(3, true, 0, "Con televisor de pantalla plana");
		HabitacionDoble habitacionDoble26 = new HabitacionDoble(2, true, 22.0, "Doble");

		Glamping glamping5 = new Glamping("Glamping de Aventura", "Yosemite Valley", "Estados Unidos", 3,
				"Una experiencia única para los aventureros", "Rural", 275000, "/imagenes2/Glamping-5.png",
				"Rutas en quad", "Barbacoa privada", "Gestión de residuos");
		hospedajes.add(glamping5);
		HabitacionBase habitacionBase27 = new HabitacionBase(2, true, 0, "Con minibar");
		HabitacionDoble habitacionDoble27 = new HabitacionDoble(2, false, 18.0, "Individual");

		Glamping glamping6 = new Glamping("Glamping Familiar", "Lofoten", "Noruega", 4,
				"Un glamping para disfrutar en familia", "Rural", 1200000, "/imagenes2/Glamping-6.png",
				"Visita a granja local", "Actividades para niños", "Reutilización de agua");
		hospedajes.add(glamping6);

		HabitacionBase habitacionBase28 = new HabitacionBase(4, false, 0, "Con acceso para discapacitados");
		HabitacionDoble habitacionDoble28 = new HabitacionDoble(2, true, 35.0, "Suite");

		glamping3.agregarHabitacion(habitacionBase25);
		glamping4.agregarHabitacion(habitacionBase26);
		glamping5.agregarHabitacion(habitacionBase27);
		glamping6.agregarHabitacion(habitacionBase28);

		glamping2.agregarHabitacion(habitacionDoble24);
		glamping3.agregarHabitacion(habitacionDoble25);
		glamping4.agregarHabitacion(habitacionDoble26);
		glamping5.agregarHabitacion(habitacionDoble27);
		glamping6.agregarHabitacion(habitacionDoble28);

		/* Hotel */

		Hotel hotel1 = new Hotel("Hotel de Lujo", "Paris", "Francia", 5,
				"Una experiencia de alojamiento de primer nivel", "Urbano", 2500000, "/imagenes2/Hotel-1.png", true,
				true);

		hospedajes.add(hotel1);
		HabitacionBase habitacionBase29 = new HabitacionBase(2, true, 0, "Con vistas al jardín");
		HabitacionBase habitacionBase30 = new HabitacionBase(2, true, 0, "Con baño privado");
		HabitacionBase habitacionBase31 = new HabitacionBase(1, false, 0, "Con aire acondicionado");
		HabitacionBase habitacionBase32 = new HabitacionBase(2, true, 0, "Con televisor de pantalla plana");
		HabitacionBase habitacionBase33 = new HabitacionBase(1, true, 0, "Con minibar");

		HabitacionDoble habitacionDoble29 = new HabitacionDoble(4, true, 150000, "Queen");
		HabitacionDoble habitacionDoble30 = new HabitacionDoble(5, true, 160000, "King");
		HabitacionDoble habitacionDoble31 = new HabitacionDoble(3, false, 140000, "Matrimonial");
		HabitacionDoble habitacionDoble32 = new HabitacionDoble(4, true, 150000, "Doble");
		HabitacionDoble habitacionDoble33 = new HabitacionDoble(4, false, 150000, "Individual");

		HabitacionPresidencial habitacionPresidencial1 = new HabitacionPresidencial(5, true, 350000,
				"Mayordomo personal");
		HabitacionPresidencial habitacionPresidencial2 = new HabitacionPresidencial(6, true, 350000, "Piscina privada");
		HabitacionPresidencial habitacionPresidencial3 = new HabitacionPresidencial(4, false, 350000, "Cocina gourmet");
		HabitacionPresidencial habitacionPresidencial4 = new HabitacionPresidencial(6, true, 350000,
				"Terraza panorámica");
		HabitacionPresidencial habitacionPresidencial5 = new HabitacionPresidencial(2, false, 350000, "Jacuzzi");

		HabitacionSuite habitacionSuite1 = new HabitacionSuite(4, true, 250000, "Spa privado");
		HabitacionSuite habitacionSuite2 = new HabitacionSuite(3, true, 250000, "Barra de bar");
		HabitacionSuite habitacionSuite3 = new HabitacionSuite(2, false, 250000, "Sala de cine");
		HabitacionSuite habitacionSuite4 = new HabitacionSuite(4, true, 250000, "Piscina privado");

		hotel1.agregarHabitacion(habitacionBase29);
		hotel1.agregarHabitacion(habitacionBase30);
		hotel1.agregarHabitacion(habitacionBase31);
		hotel1.agregarHabitacion(habitacionBase32);
		hotel1.agregarHabitacion(habitacionBase33);

		hotel1.agregarHabitacion(habitacionDoble29);
		hotel1.agregarHabitacion(habitacionDoble30);
		hotel1.agregarHabitacion(habitacionDoble31);
		hotel1.agregarHabitacion(habitacionDoble32);
		hotel1.agregarHabitacion(habitacionDoble33);

		hotel1.agregarHabitacion(habitacionPresidencial1);
		hotel1.agregarHabitacion(habitacionPresidencial2);
		hotel1.agregarHabitacion(habitacionPresidencial3);
		hotel1.agregarHabitacion(habitacionPresidencial4);
		hotel1.agregarHabitacion(habitacionPresidencial5);

		hotel1.agregarHabitacion(habitacionSuite1);
		hotel1.agregarHabitacion(habitacionSuite2);
		hotel1.agregarHabitacion(habitacionSuite3);
		hotel1.agregarHabitacion(habitacionSuite4);

		Hotel hotel2 = new Hotel("Hotel Maximmo", "Melgar", "Colombia", 3, "Hotel hermoso", "urbano", 150000,
				"/imagenes2/Hotel-2.png", true, true);
		hospedajes.add(hotel2);

		HabitacionBase habitacionBase34 = new HabitacionBase(2, true, 0, "Con vistas al jardín");
		HabitacionBase habitacionBase35 = new HabitacionBase(2, true, 0, "Con baño privado");
		HabitacionBase habitacionBase36 = new HabitacionBase(1, false, 0, "Con aire acondicionado");
		HabitacionBase habitacionBase37 = new HabitacionBase(2, true, 0, "Con televisor de pantalla plana");
		HabitacionBase habitacionBase38 = new HabitacionBase(1, true, 0, "Con minibar");

		HabitacionDoble habitacionDoble34 = new HabitacionDoble(4, true, 40000, "Queen");
		HabitacionDoble habitacionDoble35 = new HabitacionDoble(5, true, 40000, "King");
		HabitacionDoble habitacionDoble36 = new HabitacionDoble(3, false, 40000, "Matrimonial");
		HabitacionDoble habitacionDoble37 = new HabitacionDoble(4, true, 40000, "Doble");
		HabitacionDoble habitacionDoble38 = new HabitacionDoble(4, false, 40000, "Individual");
		HabitacionPresidencial habitacionPresidencial6 = new HabitacionPresidencial(4, true, 500000, "Piscina privada");
		HabitacionPresidencial habitacionPresidencial7 = new HabitacionPresidencial(3, false, 90000,
				"Servicio a habitacion");
		HabitacionPresidencial habitacionPresidencial8 = new HabitacionPresidencial(5, true, 700000, "Spa privado");
		HabitacionPresidencial habitacionPresidencial9 = new HabitacionPresidencial(3, true, 30000,
				"Chromecast en la habitación");

		HabitacionPresidencial habitacionPresidencial10 = new HabitacionPresidencial(2, true, 30000, "Terraza moderna");

		HabitacionSuite habitacionSuite6 = new HabitacionSuite(2, true, 1000000, "Casino Privado");
		HabitacionSuite habitacionSuite7 = new HabitacionSuite(3, false, 5000000, "Campo de tiro");
		HabitacionSuite habitacionSuite8 = new HabitacionSuite(4, true, 250000, "Golf");
		HabitacionSuite habitacionSuite9 = new HabitacionSuite(2, true, 1000000, "Instalaciones para reuniones");
		HabitacionSuite habitacionSuite10 = new HabitacionSuite(2, true, 800000, "Lavanderia");

		hotel2.agregarHabitacion(habitacionBase34);
		hotel2.agregarHabitacion(habitacionBase35);
		hotel2.agregarHabitacion(habitacionBase36);
		hotel2.agregarHabitacion(habitacionBase37);
		hotel2.agregarHabitacion(habitacionBase38);

		hotel2.agregarHabitacion(habitacionDoble34);
		hotel2.agregarHabitacion(habitacionDoble35);
		hotel2.agregarHabitacion(habitacionDoble36);
		hotel2.agregarHabitacion(habitacionDoble37);
		hotel2.agregarHabitacion(habitacionDoble38);

		hotel2.agregarHabitacion(habitacionPresidencial6);
		hotel2.agregarHabitacion(habitacionPresidencial7);
		hotel2.agregarHabitacion(habitacionPresidencial8);
		hotel2.agregarHabitacion(habitacionPresidencial9);
		hotel2.agregarHabitacion(habitacionPresidencial10);

		hotel2.agregarHabitacion(habitacionSuite6);
		hotel2.agregarHabitacion(habitacionSuite7);
		hotel2.agregarHabitacion(habitacionSuite8);
		hotel2.agregarHabitacion(habitacionSuite9);
		hotel2.agregarHabitacion(habitacionSuite10);

		Hotel hotel3 = new Hotel("Hotel Ejecutivo", "Dubai", "Emiratos Arabes", 4,
				"Diseñado para satisfacer las necesidades de viajeros de negocios", "Urbano", 1500000,
				"/imagenes2/Hotel-3.png", true, true);
		hospedajes.add(hotel3);

		HabitacionBase habitacionBase39 = new HabitacionBase(2, true, 0, "Con vistas al mar");
		HabitacionBase habitacionBase40 = new HabitacionBase(2, true, 0, "Con terraza privada");
		HabitacionBase habitacionBase41 = new HabitacionBase(1, false, 0, "Con jacuzzi");
		HabitacionBase habitacionBase42 = new HabitacionBase(2, true, 0, "Con caja fuerte");
		HabitacionBase habitacionBase43 = new HabitacionBase(1, true, 0, "Con jacuzzi");

		HabitacionDoble habitacionDoble39 = new HabitacionDoble(4, true, 250000, "Queen");
		HabitacionDoble habitacionDoble40 = new HabitacionDoble(5, true, 260000, "King");
		HabitacionDoble habitacionDoble41 = new HabitacionDoble(3, false, 240000, "Matrimonial");
		HabitacionDoble habitacionDoble42 = new HabitacionDoble(4, true, 250000, "Doble");
		HabitacionDoble habitacionDoble43 = new HabitacionDoble(4, false, 250000, "Individual");

		HabitacionPresidencial habitacionPresidencial11 = new HabitacionPresidencial(2, true, 65000, "Llave digital");
		HabitacionPresidencial habitacionPresidencial12 = new HabitacionPresidencial(2, false, 250000,
				"Terraza panoramica");
		HabitacionSuite habitacionSuite11 = new HabitacionSuite(2, true, 2340000, "King");
		HabitacionSuite habitacionSuite12 = new HabitacionSuite(3, false, 4560000, "Chimenea moderna");

		hotel3.agregarHabitacion(habitacionBase39);
		hotel3.agregarHabitacion(habitacionBase40);
		hotel3.agregarHabitacion(habitacionBase41);
		hotel3.agregarHabitacion(habitacionBase42);
		hotel3.agregarHabitacion(habitacionBase43);

		hotel3.agregarHabitacion(habitacionDoble39);
		hotel3.agregarHabitacion(habitacionDoble40);
		hotel3.agregarHabitacion(habitacionDoble41);
		hotel3.agregarHabitacion(habitacionDoble42);
		hotel3.agregarHabitacion(habitacionDoble43);
		hotel3.agregarHabitacion(habitacionPresidencial11);
		hotel3.agregarHabitacion(habitacionPresidencial12);
		hotel3.agregarHabitacion(habitacionSuite11);
		hotel3.agregarHabitacion(habitacionSuite12);

		/* Moteles */
		Motel motel1 = new Motel("Motel Íntimo", "Las Vegas", "Estados Unidos", 3, "Un motel para momentos especiales",
				"Urbano", 200000, "/imagenes2/Motel-1.png", "Romántica", true, "Servicio a la habitación");

		HabitacionBase habitacionBaseMotel = new HabitacionBase(2, true, 500000, "Cama 4k");

		motel1.agregarHabitacion(habitacionBaseMotel);
		Motel motel2 = new Motel("Motel Temático", "Cancun", "Mexico", 3, "Cada habitación con una temática diferente",
				"Urbano", 5000000, "/imagenes2/Motel-2.png", "Fantassía", true, "Desayuno incluido");

		HabitacionSuite habitacionSuiteMotel = new HabitacionSuite(2, true, 100000, "null");

		motel2.agregarHabitacion(habitacionSuiteMotel);

		Motel motel3 = new Motel("Motel de Lujo", "Bangkok", "Tailandia", 4, "Con instalaciones de primer nivel",
				"Urbano", 230000, "/imagenes2/Motel-3.png", "Elegante", true, "Spa privado");

		HabitacionDoble habitacionDobleMotel = new HabitacionDoble(2, true, 90000, "null");

		motel3.agregarHabitacion(habitacionDobleMotel);

		Motel motel4 = new Motel("Motel Clásico", "Berlin", "Alemania", 3, "Con un estilo retro y acogedor", "Urbano",
				240000, "/imagenes2/Motel-4.png", "Clásica", false, "Bar en la habitación");

		HabitacionPresidencial habitacionPresidencialMotel = new HabitacionPresidencial(2, true, 50000, "null");

		motel4.agregarHabitacion(habitacionPresidencialMotel);

		hospedajes.add(motel1);
		hospedajes.add(motel2);
		hospedajes.add(motel3);
		hospedajes.add(motel4);

		/* Resort */
		Resort resort1 = new Resort("Resort de Lujo", "Punta Cana", "Republica Dominicana", 5,
				"Un resort de lujo en el centro de la ciudad", "Urbano", 4200000, "/imagenes2/Resort-1.png",
				"Spa de clase mundial", "Piscina en la azotea");

		HabitacionBase habitacionBaseresort1 = new HabitacionBase(2, true, 750000, "Con vistas al mar");
		HabitacionDoble habitacionDobleResort1 = new HabitacionDoble(4, true, 1200000, "Queen");
		HabitacionPresidencial habitacionPresidencialResort1 = new HabitacionPresidencial(2, true, 2000000,
				"Con terraza privada");
		HabitacionSuite habitacionSuiteResort1 = new HabitacionSuite(2, true, 3000000, "Con jacuzzi");

		Resort resort2 = new Resort("Resort Familiar", "Maldivas", "Maldivas", 4, "Perfecto para vacaciones en familia",
				"Urbano", 3800000, "/imagenes2/Resort-2.png", "Club infantil", "Parque acuático");

		Resort resort3 = new Resort("Resort Wellness", "Santorini", "Grecia", 5,
				"Para quienes buscan bienestar y relajación", "Urbano", 5400000, "/imagenes2/Resort-3.png",
				"Yoga y meditación", "Circuitos de hidroterapia");

		hospedajes.add(resort1);
		hospedajes.add(resort2);
		hospedajes.add(resort3);

		// Habitaciones para Resort de Lujo
		resort1.agregarHabitacion(habitacionBaseresort1);
		resort1.agregarHabitacion(habitacionDobleResort1);
		resort1.agregarHabitacion(habitacionPresidencialResort1);
		resort1.agregarHabitacion(habitacionDobleResort1);
		resort1.agregarHabitacion(habitacionSuiteResort1);

		// Habitaciones para Resort Familiar
		HabitacionBase habitacionBaseResort2 = new HabitacionBase(4, true, 850000, "Con vista al mar");
		resort2.agregarHabitacion(habitacionBaseResort2);
		HabitacionDoble habitacionDobleResort2 = new HabitacionDoble(2, true, 500000, "Doble");
		resort2.agregarHabitacion(habitacionDobleResort2);
		HabitacionPresidencial habitacionPresidencialResort2 = new HabitacionPresidencial(4, true, 1500000,
				"Con balcón");
		resort2.agregarHabitacion(habitacionPresidencialResort2);
		HabitacionSuite habitacionSuiteResort2 = new HabitacionSuite(3, true, 2000000, "Con chimenea");
		resort2.agregarHabitacion(habitacionSuiteResort2);

		// Habitaciones para Resort Wellness

		HabitacionBase habitacionBaseResort3 = new HabitacionBase(2, true, 800000, "Con vista al jardín");
		resort3.agregarHabitacion(habitacionBaseResort3);
		HabitacionDoble habitacionDobleResort3 = new HabitacionDoble(2, true, 700000, "King");
		resort3.agregarHabitacion(habitacionDobleResort3);
		HabitacionPresidencial habitacionPresidencialResort3 = new HabitacionPresidencial(2, true, 1800000,
				"Con terraza panorámica");
		resort3.agregarHabitacion(habitacionPresidencialResort3);

		HabitacionSuite habitacionSuiteResort3 = new HabitacionSuite(1, true, 2500000, "Con spa privado");
		resort3.agregarHabitacion(habitacionSuiteResort3);

	}

}
