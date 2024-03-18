package controller;

import model.AuthCliente;
import model.Cliente;
import view.ViewDatosCliente;

public class Controller {
	ViewDatosCliente viewDatosCliente = new ViewDatosCliente();
	AuthCliente metodosCliente = new AuthCliente();
	ControllerHospedajes controllerHospedajes = new ControllerHospedajes();

	public Controller() {
	}

	public void funcionar() {
		controllerHospedajes.registrarHospedajes();
		int opcion = -1;
		while (opcion != 0) {
			viewDatosCliente.opcionesDisponibles();
			opcion = viewDatosCliente.pedirOpcion();
			switch (opcion) {
				case 1:

					//metodosCliente.registrarClientePrueba();
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

					controllerHospedajes.filtrarPorUbicacionCiudad(viewDatosCliente.pedirCiudad());
					break;
				case 4:

					controllerHospedajes.filtrarPorUbicacionPais(viewDatosCliente.pedirPais());
					break;
				case 5:
					controllerHospedajes.filtrarPorNumeroDeEstrellas(viewDatosCliente.pedirNumeroEstrellas());
					break;
				case 6:
					controllerHospedajes.filtrarTipoHospedaje(viewDatosCliente.pedirTipoHospedaje());
					break;
				case 7:
					controllerHospedajes.filtrarPorPrecio(viewDatosCliente.pedirPrecioMinimo(),
							viewDatosCliente.pedirPrecioMaximo());
					break;
				case 8:
				viewDatosCliente.nombreHospedajeReservar();

				case 0:
					viewDatosCliente.saliendoDelSistema();
					break;
				default:
					viewDatosCliente.opcionInvalida();

			}
		}
	}

}
