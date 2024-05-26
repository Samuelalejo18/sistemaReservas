package co.edu.konradlorenz.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import co.edu.konradlorenz.model.cliente.Cliente;
import co.edu.konradlorenz.model.excepciones.CapacidadInsuficienteException;
import co.edu.konradlorenz.model.excepciones.HabitacionNoDisponibleException;
import co.edu.konradlorenz.model.excepciones.HabitacionNoEncontradaException;
import co.edu.konradlorenz.model.excepciones.HospedajeNoEncontradoException;
import co.edu.konradlorenz.model.excepciones.ReservaNoCreadaException;
import co.edu.konradlorenz.model.habitaciones.Habitacion;
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
import co.edu.konradlorenz.model.metodosDePago.Tarjeta;
import co.edu.konradlorenz.model.reserva.Reserva;
import co.edu.konradlorenz.view.RoundButton;
import co.edu.konradlorenz.view.RoundButtonCircle;
import co.edu.konradlorenz.view.RoundedPanel;
import co.edu.konradlorenz.view.ViewReserva;

public class ControllerReserva implements ActionListener {
	Reserva reserva = new Reserva();
	// ViewReservaPrueba viewReservaPrueba = new ViewReservaPrueba();
	ArrayList<Habitacion> habitaciones;
	ArrayList<Hospedaje> hospedajes = ControllerHospedajes.getHospedajes();
	ViewReserva viewReserva;
	Hospedaje hospedajeAReservar;
	Habitacion habitacionAReservar;
	RoundButtonCircle btnBuscarNombre;
	JComboBox<String> cboNumeroHabitacion;
	JComboBox<String> cboNumeroPersonas;
	JComboBox<String> cboNumeroNoches;
	int numeroDePersonas = 0;
	int numeroDeNoches = 0;
	JDateChooser dataChooserIngreso;
	RoundButton btnFecha;
	Date fechaDeIngreso;
	Date fechaSalida;
	RoundButton btnPagar;

	RoundButton btnCrearReserva;
	RoundButton rndbtnHospedajes;

	public ControllerReserva() {
		viewReserva = new ViewReserva();
		btnBuscarNombre = viewReserva.getBtnBuscarNombre();
		cboNumeroHabitacion = viewReserva.getCboNumeroHabitacion();
		cboNumeroPersonas = viewReserva.getCboNumeroPersonas();
		cboNumeroNoches = viewReserva.getCboNumeroNoches();
		dataChooserIngreso = viewReserva.getDataChooserIngreso();
		btnFecha = viewReserva.getBtnFecha();
		rndbtnHospedajes = viewReserva.getRndbtnHospedajes();
		btnCrearReserva = viewReserva.getBtnCrearReserva();
		btnCrearReserva.addActionListener(this);
		cboNumeroHabitacion.addActionListener(this);
		cboNumeroPersonas.addActionListener(this);
		cboNumeroNoches.addActionListener(this);
		btnBuscarNombre.addActionListener(this);
		btnFecha.addActionListener(this);
		rndbtnHospedajes.addActionListener(this);
		mostrarVentanaReserva(true);
	}

	public void mostrarVentanaReserva(boolean visible) {
		viewReserva.setVisible(true);
		viewReserva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarNombre) {
			viewReserva.getJpnHabitaciones().removeAll();
			viewReserva.getJpnHospedajeAReservar().removeAll();
			;
			try {

				hospedajeAReservar = reservarHospedaje(viewReserva.pedirNombreHospedaje());
				habitacionesDisponibles(hospedajeAReservar.getHabitaciones());

			} catch (HospedajeNoEncontradoException e1) {
				JOptionPane.showMessageDialog(viewReserva, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}

		if (e.getSource() == cboNumeroHabitacion) {
			viewReserva.getJpnHabitacionAreservar().removeAll();
			if (hospedajeAReservar != null) {
				try {
					int opcionNumeroHabitacion = (int) cboNumeroHabitacion.getSelectedIndex() + 1;
					habitacionAReservar = habitacionAreservar(opcionNumeroHabitacion,
							hospedajeAReservar.getHabitaciones());
					JOptionPane.showMessageDialog(viewReserva,
							"numero de la habitacion a reservar " + opcionNumeroHabitacion, "Información",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (HabitacionNoEncontradaException e1) {
					habitacionAReservar = null;
					JOptionPane.showMessageDialog(viewReserva, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (HabitacionNoDisponibleException e2) {
					habitacionAReservar = null;
					JOptionPane.showMessageDialog(viewReserva, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(viewReserva, "Primero busca el hospedaje a reservar", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}

		if (e.getSource() == cboNumeroNoches) {

			if ((hospedajeAReservar == null && habitacionAReservar == null)) {
				habitacionAReservar = null;
				numeroDeNoches = 0;
				JOptionPane.showMessageDialog(viewReserva, "Primero busca el hospedaje a reservar y/o la habitación",
						"Error", JOptionPane.ERROR_MESSAGE);
			} else if ((hospedajeAReservar == null || habitacionAReservar == null)) {
				habitacionAReservar = null;
				numeroDeNoches = 0;
				JOptionPane.showMessageDialog(viewReserva, "Primero busca el hospedaje a reservar y/o la habitación",
						"Error", JOptionPane.ERROR_MESSAGE);
			} else {
				int opcionNumeroDeNoches = (int) cboNumeroNoches.getSelectedIndex() + 1;
				numeroDeNoches = opcionNumeroDeNoches;
				JOptionPane.showMessageDialog(viewReserva, "Numero de noches a reservar " + numeroDeNoches,
						"Información", JOptionPane.INFORMATION_MESSAGE);

			}

		}

		if (e.getSource() == cboNumeroPersonas) {
			if ((hospedajeAReservar == null && habitacionAReservar == null)) {
				habitacionAReservar = null;
				JOptionPane.showMessageDialog(viewReserva, "Primero busca el hospedaje a reservar y/o la habitación",
						"Error", JOptionPane.ERROR_MESSAGE);
			} else if ((hospedajeAReservar == null || habitacionAReservar == null)) {

				JOptionPane.showMessageDialog(viewReserva, "Primero busca el hospedaje a reservar y/o la habitación",
						"Error", JOptionPane.ERROR_MESSAGE);
			} else {
				int opcionNumeroDePersonas = (int) cboNumeroPersonas.getSelectedIndex() + 1;
				try {
					verificarCapacidad(habitacionAReservar, opcionNumeroDePersonas);
					JOptionPane.showMessageDialog(viewReserva, "Numero de personas " + numeroDePersonas, "Información",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (CapacidadInsuficienteException e1) {

					JOptionPane.showMessageDialog(viewReserva, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		}

		if (e.getSource() == btnFecha) {
			/*
			 * if ((hospedajeAReservar == null && habitacionAReservar == null)) {
			 * JOptionPane.showMessageDialog(viewReserva,
			 * "Primero busca el hospedaje a reservar y/o la habitación", "Error",
			 * JOptionPane.ERROR_MESSAGE); } else if ((hospedajeAReservar == null ||
			 * habitacionAReservar == null)) { JOptionPane.showMessageDialog(viewReserva,
			 * "Primero busca el hospedaje a reservar y/o la habitación", "Error",
			 * JOptionPane.ERROR_MESSAGE); } else {
			 */
			fechaDeIngreso = dataChooserIngreso.getDate();

			if (fechaDeIngreso != null && numeroDeNoches > 0) {
				JOptionPane.showMessageDialog(viewReserva, "Fecha de ingreso : " + fechaDeIngreso, "Información",
						JOptionPane.INFORMATION_MESSAGE);

				// Sumar noches a la fecha seleccionada
				int nightsToAdd = numeroDeNoches; // por ejemplo, sumar 3 noches
				Calendar cal = Calendar.getInstance();
				cal.setTime(fechaDeIngreso);
				cal.add(Calendar.DATE, nightsToAdd);
				fechaSalida = cal.getTime();

				JOptionPane
						.showMessageDialog(viewReserva,
								"Numero de noches :  " + nightsToAdd + " fecha de ingreso:  " + fechaDeIngreso
										+ ", fecha de salida: " + fechaSalida,
								"Información", JOptionPane.INFORMATION_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(viewReserva, "fecha no selecionada ", "Error", JOptionPane.ERROR_MESSAGE);

			}
			// }

		}

		if (e.getSource() == btnCrearReserva) {
			Cliente usuarioAutenticado = ControllerAutenticacion.usuarioAutenticado;
			try {
				crearReserva(usuarioAutenticado, fechaDeIngreso, fechaSalida, hospedajeAReservar, habitacionAReservar,
						numeroDePersonas, numeroDeNoches);
			} catch (ReservaNoCreadaException e1) {

				JOptionPane.showMessageDialog(viewReserva, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}

	}

	public Hospedaje reservarHospedaje(String nombre) throws HospedajeNoEncontradoException {

		boolean encontradoNombre = false;
		int x = 25;
		int y = 50;
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getNombre().equalsIgnoreCase(nombre)) {
				encontradoNombre = true;
				hospedajeAReservar = hospedaje;
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				
				RoundedPanel card = viewReserva.mostrarPanelHospedaje(tipoHospedaje, hospedaje.getNombre(),
						hospedaje.getUbicacionCiudad(), hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(),
						hospedaje.getDescripcion(), hospedaje.getTipo(), hospedaje.getPrecioPorPersona(),
						hospedaje.getUrl());
				card.setBounds(x, y, 280, 325);
				viewReserva.getJpnHospedajeAReservar().add(card);

			}
		}

		if (!encontradoNombre) {
			throw new HospedajeNoEncontradoException("Hospedaje no encontrado");
		}

		return hospedajeAReservar;
	}

	public String hallarTipoHabitacion(Habitacion habitacion) {
		String tipoHabitacion = "no existe";
		if (habitacion instanceof HabitacionBase) {
			tipoHabitacion = "Habitacion Base";
		} else if (habitacion instanceof HabitacionDoble) {
			tipoHabitacion = "Habitacion Doble";
		} else if (habitacion instanceof HabitacionPresidencial) {
			tipoHabitacion = "Habitacion Presidencial";
		} else if (habitacion instanceof HabitacionSuite) {
			tipoHabitacion = "Habitacion Suite";
		}
		return tipoHabitacion;
	}
	public String hallarTipoHablitacionUrl (Habitacion habitacion){

		String tipoUrl = "";
		if (habitacion instanceof HabitacionBase) {
			tipoUrl = "/imagenes/base.png";
		} else if (habitacion instanceof HabitacionDoble) {
			tipoUrl = "/imagenes/doble.png";
		} else if (habitacion instanceof HabitacionPresidencial) {
			tipoUrl = "/imagenes/precidencial.png";
		} else if (habitacion instanceof HabitacionSuite) {
			tipoUrl = "/imagenes/suite.png";
		}
		return tipoUrl;
		
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

	public void habitacionesDisponibles(ArrayList<Habitacion> habitaciones) {
		// viewReservaPrueba.mostrarHabitacionesDisponibles();
		// viewReservaPrueba.mostrarTituloHabitacion();
		int x = 21;
		int y = 47;
		for (Habitacion habitacion : habitaciones) {
			String tipoHabitacion = hallarTipoHabitacion(habitacion);
			String url= hallarTipoHablitacionUrl(habitacion);
			RoundedPanel card = viewReserva.mostrarPanelHabitacionesDisponibles(tipoHabitacion,
					habitacion.getCapacidad(), habitacion.isDisponible(), habitacion.getNumeroHabitacion(),
					habitacion.getPrecioAdicionalPorTipoHabitacion(), url);
			card.setBounds(x, y, 269, 336);
			viewReserva.getJpnHabitaciones().add(card);
			x += 320;

			if (x >= 600) {
				x = 21;
				y += 380;

			}

			// viewReservaPrueba.imprimirTablaHabitacion(tipoHabitacion,
			// habitacion.getCapacidad(),
			// habitacion.isDisponible(), habitacion.getNumeroHabitacion(),
			// habitacion.getPrecioAdicionalPorTipoHabitacion());
		}

	}

	public Habitacion habitacionAreservar(int numeroDeLaHabitacionAReservar,
			ArrayList<Habitacion> habitacionesAreservar)
			throws HabitacionNoEncontradaException, HabitacionNoDisponibleException {
		boolean habitacionEncontrada = false;
		boolean habitacionEstaDiponible = false;

		for (Habitacion habitacion : habitacionesAreservar) {
			if (habitacion.getNumeroHabitacion() == numeroDeLaHabitacionAReservar) {
				habitacionAReservar = habitacion;
				habitacionEncontrada = true;
				String url= hallarTipoHablitacionUrl(habitacion);
				String tipoHabitacion = hallarTipoHabitacion(habitacion);
				RoundedPanel card = viewReserva.mostrarPanelHabitacionAreservar(tipoHabitacion,
						habitacion.getCapacidad(), habitacion.isDisponible(), habitacion.getNumeroHabitacion(),
						habitacion.getPrecioAdicionalPorTipoHabitacion(), url);
				viewReserva.getJpnHabitacionAreservar().add(card);

				if (habitacion.isDisponible()) {
					habitacionEstaDiponible = true;
				}
			}

		}
		if (!habitacionEstaDiponible) {
			throw new HabitacionNoDisponibleException("La habitacion no esta disponible");
		}

		if (!habitacionEncontrada) {
			throw new HabitacionNoEncontradaException("La habitacion no existe");
		}
		return habitacionAReservar;

	}

	public void verificarCapacidad(Habitacion habitacion, int numeroDePersonasAReservar)
			throws CapacidadInsuficienteException {
		if (habitacion.getCapacidad() >= numeroDePersonasAReservar) {
			numeroDePersonas = numeroDePersonasAReservar;
		} else {
			numeroDePersonas = 0;
			throw new CapacidadInsuficienteException(" Capacidad insuficiente");
		}

	}

	public void crearReserva(Cliente cliente, Date fechaEntrada, Date fechaSalida, Hospedaje hospedajeReservado,
			Habitacion habitacionReservada, int cantidadDePersonas, int numeroNoches) throws ReservaNoCreadaException {
		if (cliente == null) {
			throw new ReservaNoCreadaException(" el cliente no esta auntenticado");
		} else if (hospedajeReservado == null) {
			throw new ReservaNoCreadaException(" EL hospedaje no ha sido agregado");
		} else if (habitacionReservada == null) {
			throw new ReservaNoCreadaException(" La habitacion no ha sido agregado");
		} else if (cantidadDePersonas == 0) {
			throw new ReservaNoCreadaException(" La cantidad de personas  no ha sido agregada");
		} else if (numeroNoches == 0) {
			throw new ReservaNoCreadaException(" La cantidad de noches no ha sido agregada");
		} else if (fechaSalida == null) {
			throw new ReservaNoCreadaException(" La fecha de salida no ha sido agregada");
		} else if (fechaEntrada == null) {
			throw new ReservaNoCreadaException(" La fecha de ingreso no ha sido agregada");
		} else {
			Reserva reserva = new Reserva(cliente, fechaEntrada, fechaSalida, hospedajeReservado, habitacionReservada,
					cantidadDePersonas, numeroNoches);

			String tipoHospedaje = hallarTipoHospedaje(hospedajeReservado);
			String tipoHabitacion = hallarTipoHabitacion(habitacionReservada);
			double precioTotal = reserva.calcularPrecioTotal(cantidadDePersonas, numeroNoches);

			RoundedPanel jpnReserva = viewReserva.crearReserva(cliente.getNombre(), cliente.getApellido(),
					cliente.getId(), cliente.getEmail(), cliente.getNumeroTelefono(), fechaEntrada, fechaSalida,
					tipoHospedaje, hospedajeAReservar.getNombre(), hospedajeAReservar.getUbicacionCiudad(),
					hospedajeAReservar.getUbicacionPais(), tipoHabitacion, habitacionReservada.getNumeroHabitacion(),
					cantidadDePersonas, numeroNoches, hospedajeAReservar.getPrecioPorPersona(),
					habitacionReservada.getPrecioAdicionalPorTipoHabitacion(), reserva.subtotal(), precioTotal);
			viewReserva.getJpnReservaDeFondo().add(jpnReserva);

			/*
			 * else if (fechaEntrada == null) { throw new
			 * ReservaNoCreadaException(" La fecha de entrada no ha sido agregada"); } else
			 * if (fechaSalida == null) { throw new
			 * ReservaNoCreadaException(" La fecha de salida no ha sido agregada"); }
			 */
		}

	}

}