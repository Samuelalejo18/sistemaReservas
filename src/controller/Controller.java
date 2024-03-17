package controller;

import model.*;
import view.ViewDatosCliente;

public class Controller {
	ViewDatosCliente viewDatosCliente = new ViewDatosCliente();
	AuthCliente metodosCliente = new AuthCliente();

	public void funcionar() {
		int opcion = -1;
		while (opcion != 0) {
			viewDatosCliente.opcionesDisponibles();
			opcion = viewDatosCliente.pedirOpcion();
			switch (opcion) {
			case 1:
				viewDatosCliente.pedirEmail();
				viewDatosCliente.pedirContrasena();
				metodosCliente.registrarClientePrueba();
				AuthCliente.autenticarse(viewDatosCliente.pedirEmail(), viewDatosCliente.pedirContrasena());
				break;
			case 2:
				viewDatosCliente.pedirNombre();
				viewDatosCliente.pedirApellido();
				viewDatosCliente.pedirId();
				viewDatosCliente.pedirNumeroTelefono();
				viewDatosCliente.pedirDireccion();
				viewDatosCliente.pedirEmail();
				viewDatosCliente.pedirContrasena();
				Cliente cliente = new Cliente(viewDatosCliente.pedirNombre(), viewDatosCliente.pedirApellido(),
						viewDatosCliente.pedirId(), viewDatosCliente.pedirEmail(), viewDatosCliente.pedirContrasena(),
						viewDatosCliente.pedirNumeroTelefono(), viewDatosCliente.pedirDireccion());
				AuthCliente.registrar(cliente);
				break;
			case 0:
				viewDatosCliente.saliendoDelSistema();
				break;
			}
		}
	}
}
