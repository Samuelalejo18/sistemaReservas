package co.edu.konradlorenz.controller;

import java.sql.Date;
import java.util.ArrayList;

import co.edu.konradlorenz.model.Archivo;
import co.edu.konradlorenz.model.cliente.AuthCliente;
import co.edu.konradlorenz.model.cliente.Cliente;
import co.edu.konradlorenz.model.excepciones.AuntenticacionFallidaExcepcion;
import co.edu.konradlorenz.model.excepciones.CapacidadInsuficienteExcepcion;
import co.edu.konradlorenz.model.excepciones.HabitacionNoEncontradaExcepcion;
import co.edu.konradlorenz.model.excepciones.HospedajeNoEncontradoExcepcion;
import co.edu.konradlorenz.model.excepciones.RegistroFallidoExcepcion;
import co.edu.konradlorenz.model.habitaciones.Habitacion;
import co.edu.konradlorenz.model.hospedajes.Hospedaje;
import co.edu.konradlorenz.model.reserva.Reserva;
import co.edu.konradlorenz.view.ViewDatosCliente;
import co.edu.konradlorenz.view.ViewReserva;

public class Controller {
	ViewDatosCliente viewDatosCliente = new ViewDatosCliente();
	AuthCliente metodosCliente = new AuthCliente();
	ControllerHospedajes controllerHospedajes = new ControllerHospedajes();
	ControllerReserva controllerReserva = new ControllerReserva();
	ViewReserva viewReserva = new ViewReserva();
	Cliente usuarioAutenticado;
	ArrayList<Habitacion> habitaciones;
	Hospedaje hospedajeAReservar;
	Habitacion habitacionReservada;
	Archivo archivo = new Archivo();

	public void funcionar() {
		controllerHospedajes.registrarHospedajes();
		archivo.guardarArchivo(metodosCliente.getClientes());
		int opcion = -1;
		while (opcion != 0) {
			viewDatosCliente.opcionesDisponibles();
			opcion = viewDatosCliente.pedirOpcion();
			switch (opcion) {
				case 1:
					try {
						metodosCliente.registrarClientePrueba();
						usuarioAutenticado = AuthCliente.autenticarse(viewDatosCliente.pedirEmail(),
								viewDatosCliente.pedirContrasena());
						opcionesReserva();
					} catch (AuntenticacionFallidaExcepcion e) {
						viewDatosCliente.mostrarMensaje(e.getMessage());
						e.printStackTrace();
					}
					break;

				case 2:
					try {
						Cliente cliente = new Cliente(viewDatosCliente.pedirNombre(), viewDatosCliente.pedirApellido(),
								viewDatosCliente.pedirId(), viewDatosCliente.pedirEmail(),
								viewDatosCliente.pedirContrasena(),
								viewDatosCliente.pedirNumeroTelefono(), viewDatosCliente.pedirDireccion());
						viewDatosCliente.registroExitoso(cliente.getNombre());
						AuthCliente.registrar(cliente);
					} catch (RegistroFallidoExcepcion e) {
						viewDatosCliente.mostrarMensaje(e.getMessage());
						e.printStackTrace();
					}

					break;
				case 0:
					viewDatosCliente.saliendoDelSistema();
					break;
				default:
					viewDatosCliente.opcionInvalida();
			}
		}
	}

	public void opcionesReserva() {
		int opcion = -1;
		while (opcion != 0) {
			viewDatosCliente.opcionesDeHospedaje();
			opcion = viewDatosCliente.pedirOpcion();
			switch (opcion) {
				case 1:
					controllerHospedajes.hospedajesDisponibles();
					break;
				case 2:
					try {
						controllerHospedajes.buscarPorNombre(viewDatosCliente.pedirNombreHospedaje());

					} catch (HospedajeNoEncontradoExcepcion e) {
						viewDatosCliente.mostrarMensaje(e.getMessage());
						e.printStackTrace();
					}
					break;
				case 3:
					try {
						controllerHospedajes.filtrarCiudad(viewDatosCliente.pedirCiudad());
					} catch (HospedajeNoEncontradoExcepcion e) {
						viewDatosCliente.mostrarMensaje(e.getMessage());
						e.printStackTrace();
					}
					break;
				case 4:
					try {

						controllerHospedajes.filtrarPorPais(viewDatosCliente.pedirPais());

					} catch (HospedajeNoEncontradoExcepcion e) {
						viewDatosCliente.mostrarMensaje(e.getMessage());
						e.printStackTrace();
					}
					break;
				case 5:
					try {
						controllerHospedajes.filtrarPorNumeroDeEstrellas(viewDatosCliente.pedirNumeroEstrellas());
					} catch (HospedajeNoEncontradoExcepcion e) {
						viewDatosCliente.mostrarMensaje(e.getMessage());
						e.printStackTrace();
					}
					break;
				case 6:
					try {

						controllerHospedajes.filtrarTipo(viewDatosCliente.pedirTipoHospedaje());
					} catch (HospedajeNoEncontradoExcepcion e) {
						viewDatosCliente.mostrarMensaje(e.getMessage());
						e.printStackTrace();
					}
					break;
				case 7:
					controllerHospedajes.filtrarPorPrecio(viewDatosCliente.pedirPrecioMinimo(),
							viewDatosCliente.pedirPrecioMaximo());
					break;
				case 8:
					controllerHospedajes.filtrarHoteles();
					break;
				case 9:
					controllerHospedajes.filtrarMoteles();
					break;
				case 10:
					controllerHospedajes.filtralResorts();
					break;
				case 11:
					controllerHospedajes.filtralCampings();
					break;
				case 12:
					controllerHospedajes.filtralGlampings();
					break;
				case 13:
					controllerHospedajes.filtralCabanas();
					break;
				case 14:

					viewReserva.mostrarGraciasReserva();
					try {
						realizarReserva();

					} catch (HabitacionNoEncontradaExcepcion e) {
						viewDatosCliente.mostrarMensaje(e.getMessage());
						e.printStackTrace();
					} catch (CapacidadInsuficienteExcepcion e) {
						viewDatosCliente.mostrarMensaje(e.getMessage());
						e.printStackTrace();
					}
					break;
				case 0:
					viewDatosCliente.saliendoDelSistema();
					break;
				default:
					viewDatosCliente.opcionInvalida();

			}
		}
	}

	public void realizarReserva() throws HabitacionNoEncontradaExcepcion, CapacidadInsuficienteExcepcion {
		try {
			hospedajeAReservar = controllerReserva
					.reservarHospedaje(viewDatosCliente.pedirNombreHospedaje());

			habitaciones = hospedajeAReservar.getHabitaciones();

			controllerReserva.habitacionesDisponibles(habitaciones);

			int numeroHabitacionReservar = viewReserva.pedirNumeroHabitacionReservar();
			boolean habitacionEncontrada = false;
			boolean habitacionDisponible = false;
			for (Habitacion habitacion : habitaciones) {
				if (habitacion.getNumeroHabitacion() == numeroHabitacionReservar) {

					if (habitacion.isDisponible()) {

						habitacionReservada = habitacion;
						habitacionEncontrada = true;
						String tipoHabitacion = controllerReserva.hallarTipoHabitacion(habitacion);
						viewReserva.imprimirTablaHabitacion(tipoHabitacion, habitacion.getCapacidad(),
								habitacion.isDisponible(), habitacion.getNumeroHabitacion(),
								habitacion.getPrecioAdicionalPorTipoHabitacion());
						habitacionDisponible = true;
						break;
					} else {
						habitacionReservada = habitacion;
						habitacionEncontrada = true;
						habitacionDisponible = false;

						break;
					}
				}
			}

			if (!habitacionEncontrada) {
				throw new HabitacionNoEncontradaExcepcion("La habitacion no existe");
			}

			if (habitacionDisponible) {
				Date fechaEntrada = null/* ViewReserva.ingresarFechaEntrada() */;
				Date fechaSalida = null /* viewReserva.ingresarFechaSalida() */;

				int numeroPersonas = ViewReserva.ingresarNumeroPersonas();
				if (habitacionReservada.getCapacidad() >= numeroPersonas) {
					int numeroNoches = ViewReserva.ingresarNumeroNoches();
					Reserva reserva = new Reserva(usuarioAutenticado, fechaEntrada, fechaSalida,
							hospedajeAReservar,
							habitacionReservada, numeroPersonas, numeroNoches);

					double precioTotal = reserva.calcularPrecioTotal(numeroPersonas, numeroNoches);

					viewReserva.mostrarPrecio(precioTotal);

					controllerReserva.metodosDepago(usuarioAutenticado, usuarioAutenticado.getTarjetas(),
							precioTotal);

					String aceptarPago = ViewReserva.realizarpago();

					viewReserva.mostrarPago(reserva.realizarPago(aceptarPago, precioTotal));

					String nombreClaseHabitacon = habitacionReservada.getClass().getSimpleName();

					String tipoHabitacion = nombreClaseHabitacon.substring("Habitacion".length());

					String tipoHospedaje = controllerReserva.hallarTipoHospedaje(hospedajeAReservar);

					viewReserva.imprimirTablaReserva(usuarioAutenticado.getNombre(),
							usuarioAutenticado.getApellido(), usuarioAutenticado.getId(),
							usuarioAutenticado.getEmail(), usuarioAutenticado.getNumeroTelefono(),
							fechaEntrada,
							fechaSalida, tipoHospedaje, hospedajeAReservar.getNombre(),
							hospedajeAReservar.getUbicacionCiudad(), hospedajeAReservar.getUbicacionPais(),
							tipoHabitacion, habitacionReservada.getNumeroHabitacion(), numeroPersonas,
							numeroNoches, hospedajeAReservar.getPrecioPorPersona(),
							habitacionReservada.getPrecioAdicionalPorTipoHabitacion(),
							reserva.subtotal(), precioTotal);

				} else {
				
					throw new CapacidadInsuficienteExcepcion("Capacidad insuficiente");
				}

			}

		} catch (HospedajeNoEncontradoExcepcion e) {
			viewDatosCliente.mostrarMensaje(e.getMessage());
			e.printStackTrace();
		}
	}

}
