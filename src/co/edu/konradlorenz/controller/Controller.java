package co.edu.konradlorenz.controller;

import co.edu.konradlorenz.model.AuthCliente;
import co.edu.konradlorenz.model.Cliente;
import co.edu.konradlorenz.view.ViewDatosCliente;

public class Controller {
	ViewDatosCliente viewDatosCliente = new ViewDatosCliente();
	AuthCliente metodosCliente = new AuthCliente();
	ControllerHospedajes controllerHospedajes = new ControllerHospedajes();
	ControllerReserva controllerReserva = new ControllerReserva();

	public void funcionar() {
		controllerHospedajes.registrarHospedajes();
		int opcion = -1;
		while (opcion != 0) {
			viewDatosCliente.opcionesDisponibles();
			opcion = viewDatosCliente.pedirOpcion();
			switch (opcion) {
				case 1:

					metodosCliente.registrarClientePrueba();
					Cliente usuarioAutenticado = AuthCliente.autenticarse(viewDatosCliente.pedirEmail(),
							viewDatosCliente.pedirContrasena());
					if (usuarioAutenticado != null) {
						viewDatosCliente.autenticacionExitosa();
						opcionesReserva();

					} else {
						viewDatosCliente.autenticacionFallida();
					}
					break;

				case 2:

					Cliente cliente = new Cliente(viewDatosCliente.pedirNombre(), viewDatosCliente.pedirApellido(),
							viewDatosCliente.pedirId(), viewDatosCliente.pedirEmail(),
							viewDatosCliente.pedirContrasena(),
							viewDatosCliente.pedirNumeroTelefono(), viewDatosCliente.pedirDireccion());
					if (!AuthCliente.registrar(cliente)) {
						viewDatosCliente.registroFallido(cliente.getNombre());

					} else {
						viewDatosCliente.registroExitoso(cliente.getNombre());
						AuthCliente.registrar(cliente);

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

					controllerHospedajes.buscarPorNombre(viewDatosCliente.pedirNombreHospedaje());
					break;
				case 3:

					controllerHospedajes.filtrarCiudad(viewDatosCliente.pedirCiudad());
					break;
				case 4:

					controllerHospedajes.filtrarPorPais(viewDatosCliente.pedirPais());
					break;
				case 5:
					controllerHospedajes.filtrarPorNumeroDeEstrellas(viewDatosCliente.pedirNumeroEstrellas());
					break;
				case 6:
					controllerHospedajes.filtrarTipo(viewDatosCliente.pedirTipoHospedaje());
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
					// Hospedaje hospedajeAreservar =
					// reservarHospedaje(viewR.pedirNombreHospedajeAreservar());
					controllerReserva.casosReserva();
					break;
				case 0:
					viewDatosCliente.saliendoDelSistema();
					break;
				default:
					viewDatosCliente.opcionInvalida();

			}
		}
	}

	/*
	 * public Hospedaje reservarHospedaje(String nombre) {
	 * Hospedaje hospedajeAReservar = null;
	 * boolean encontradoNombre = false;
	 * for (Hospedaje hospedaje : hospedajes) {
	 * if (hospedaje.getNombre() == nombre) {
	 * hospedajeAReservar = hospedaje;
	 * encontradoNombre = true;
	 * }
	 * }
	 * if (!encontradoNombre) {
	 * 
	 * }
	 * 
	 * return hospedajeAReservar;
	 * 
	 * }
	 * public Habitacion habitacionAreservar(Habitacion tipohHabitacion) {
	 * for (Habitacion habitacion : habitacionesAReservar) {
	 * }
	 * 
	 * return null;
	 * }
	 */

}
