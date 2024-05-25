package co.edu.konradlorenz.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.edu.konradlorenz.model.cliente.Cliente;
import co.edu.konradlorenz.model.excepciones.HabitacionNoEncontradaException;
import co.edu.konradlorenz.model.excepciones.HospedajeNoEncontradoException;
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

	public ControllerReserva() {
		viewReserva = new ViewReserva();
		btnBuscarNombre = viewReserva.getBtnBuscarNombre();
		cboNumeroHabitacion = viewReserva.getCboNumeroHabitacion();

		cboNumeroHabitacion.addActionListener(this);
		btnBuscarNombre.addActionListener(this);
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
					habitacionAReservar = habitacionAreservar(opcionNumeroHabitacion, hospedajeAReservar.getHabitaciones());
				} catch (HabitacionNoEncontradaException e1) {
					JOptionPane.showMessageDialog(viewReserva, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(viewReserva, "Primero busca el hospedaje a reservar", "Error", JOptionPane.ERROR_MESSAGE);
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
			RoundedPanel card = viewReserva.mostrarPanelHabitacionesDisponibles(tipoHabitacion,
					habitacion.getCapacidad(), habitacion.isDisponible(), habitacion.getNumeroHabitacion(),
					habitacion.getPrecioAdicionalPorTipoHabitacion(), "/imagenes/cabana.png");
			card.setBounds(x, y, 269, 336);
			viewReserva.getJpnHabitaciones().add(card);
			x += 320;

			if (x >= 1250) {
				x = 21;
				y += 380;

			}

			// viewReservaPrueba.imprimirTablaHabitacion(tipoHabitacion,
			// habitacion.getCapacidad(),
			// habitacion.isDisponible(), habitacion.getNumeroHabitacion(),
			// habitacion.getPrecioAdicionalPorTipoHabitacion());
		}

	}

	public Habitacion habitacionAreservar(int numeroDeLaHabitacionAReservar, ArrayList<Habitacion> habitacionesAreservar) throws HabitacionNoEncontradaException {
		boolean habitacionEncontrada = false;

		for (Habitacion habitacion : habitacionesAreservar) {
			if (habitacion.getNumeroHabitacion() == numeroDeLaHabitacionAReservar) {
				habitacionAReservar = habitacion;
				habitacionEncontrada = true;
				String tipoHabitacion = hallarTipoHabitacion(habitacion);
				RoundedPanel card = viewReserva.mostrarPanelHabitacionAreservar(tipoHabitacion,
						habitacion.getCapacidad(), habitacion.isDisponible(), habitacion.getNumeroHabitacion(),
						habitacion.getPrecioAdicionalPorTipoHabitacion(), "/imagenes/cabana.png");
				viewReserva.getJpnHabitacionAreservar().add(card);
				
			}

		}

		if (!habitacionEncontrada) {
			throw new HabitacionNoEncontradaException("La habitacion no existe");
		}
		return habitacionAReservar;

	}

	public void metodosDepago(Cliente clienteAutenticado, ArrayList<Tarjeta> tarjetas, double precioTotal) {
		System.out.println("Metodos de pago");

		int opcion = -1;
		while (opcion != 0) {
			System.out.println(" 1.Tarjeta de credito");
			System.out.println("2.Tarjeta Debito");
			// opcion = viewReservaPrueba.pedirOpcion();
			switch (opcion) {
			case 1:
				opcionesCredito(clienteAutenticado, tarjetas, precioTotal);
				opcion = 0;
				break;
			case 2:
				break;
			default:
				break;
			}

		}
	}

	public void opcionesCredito(Cliente clienteAutenticado, ArrayList<Tarjeta> tarjetas, double precioTotal) {
		System.out.println("Metodos de pago");

		int opcion = -1;
		while (opcion != 0) {
			System.out.println(" 1.Aregar Tareta");
			System.out.println("2.Tarjetas ya registradas");
			// opcion = viewReservaPrueba.pedirOpcion();
			switch (opcion) {
			case 1:
				// Credito tarjetaCredito = new Credito(viewReservaPrueba.pedirTipoTarjeta(),
				// viewReservaPrueba.pedirBanco(),
				// viewReservaPrueba.pedirCodigoDeseguridad(),
				// viewReservaPrueba.pedirNombreTitular(),
				// viewReservaPrueba.pedirNumeroDetarjeta(), null,
				// viewReservaPrueba.pedirSaldo(),
				// viewReservaPrueba.pedirItereses());
				// clienteAutenticado.agregarTarjeta(tarjetaCredito);
				// int numeroCuotas = viewReservaPrueba.pedirNumeroDeCuotas();
				// tarjetaCredito.calcularCredito(precioTotal, numeroCuotas);
				// tarjetaCredito.setCuotas(numeroCuotas);
				// try {

				// viewReservaPrueba.mostrarCompraTarjeta(tarjetaCredito.Pagar(precioTotal));
				// } catch (SaldoInsuficienteException e) {
				// viewReservaPrueba.mostrarMensaje(e.getMessage());
				// e.printStackTrace();
				// }
				opcion = 0;
				break;
			case 2:
				if (tarjetas.isEmpty()) {

					System.out.println("No hay ninguna tarjeta registrada");
				}
				break;
			default:
				break;
			}

		}

	}

}