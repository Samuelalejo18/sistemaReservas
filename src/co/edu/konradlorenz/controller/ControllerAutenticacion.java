package co.edu.konradlorenz.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import co.edu.konradlorenz.model.Archivo;
import co.edu.konradlorenz.model.cliente.AuthCliente;
import co.edu.konradlorenz.model.cliente.Cliente;
import co.edu.konradlorenz.model.excepciones.AuntenticacionFallidaException;
import co.edu.konradlorenz.model.excepciones.CapacidadInsuficienteException;
import co.edu.konradlorenz.model.excepciones.HabitacionNoEncontradaException;
import co.edu.konradlorenz.model.excepciones.HospedajeNoEncontradoException;
import co.edu.konradlorenz.model.excepciones.RegistroFallidoException;
import co.edu.konradlorenz.model.habitaciones.Habitacion;
import co.edu.konradlorenz.model.hospedajes.Hospedaje;
import co.edu.konradlorenz.model.reserva.Reserva;
import co.edu.konradlorenz.view.ViewAutenticacion;

import co.edu.konradlorenz.view.ViewRegistro;
import co.edu.konradlorenz.view.ViewReservaPrueba;

public class ControllerAutenticacion implements ActionListener {

	AuthCliente metodosCliente = new AuthCliente();

	static Cliente usuarioAutenticado;
	ArrayList<Habitacion> habitaciones;
	Hospedaje hospedajeAReservar;
	Habitacion habitacionReservada;

	JButton btnLoginAutenticacion;
	JButton btnLoginRegistro;
	ViewAutenticacion viewAutenticacion;
	ViewRegistro viewRegistro;

	JButton btnRegisterRegistro;
	JButton btnRegisterLogin;
	ControllerHospedajes controlHospedajes;
	JButton btnHospedajesLogin;
	JButton btnNosotrosLogin;
	JButton btnContactanosLogin;

	public ControllerAutenticacion() {
		viewAutenticacion = new ViewAutenticacion();
		viewRegistro = new ViewRegistro();
		btnLoginAutenticacion = viewAutenticacion.getBtnLogin();
		btnLoginAutenticacion.addActionListener(this);
		mostrarVentanaAutenticacion(true);

		btnLoginRegistro = viewAutenticacion.getBtnRegistrar();
		btnLoginRegistro.addActionListener(this);

		btnRegisterRegistro = viewRegistro.getBtnRegister();
		btnRegisterRegistro.addActionListener(this);
		btnRegisterLogin = viewRegistro.getBtnLogin();
		btnRegisterLogin.addActionListener(this);

		btnHospedajesLogin= viewAutenticacion.getBtnHospedajes();
		btnContactanosLogin = viewAutenticacion.getBtnContactanos();
		btnNosotrosLogin = viewAutenticacion.getBtnNosotros();
		btnHospedajesLogin.addActionListener(this);
		btnContactanosLogin.addActionListener(this);
		btnNosotrosLogin.addActionListener(this);
	}

	public void mostrarVentanaRegistro(boolean visible) {
		viewRegistro.setVisible(true);
		viewRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void mostrarVentanaAutenticacion(boolean visible) {
		viewAutenticacion.setVisible(true);
		viewAutenticacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnLoginAutenticacion) {
			try {
				metodosCliente.registrarClientePrueba();
				usuarioAutenticado = AuthCliente.autenticarse(viewAutenticacion.pedirEmail(),
						viewAutenticacion.pedirContrasena());
				JOptionPane.showMessageDialog(viewAutenticacion,
						"Autenticacion exitosa para " + usuarioAutenticado.getNombre(), "Éxito",
						JOptionPane.INFORMATION_MESSAGE);
				viewAutenticacion.dispose();
				controlHospedajes = new ControllerHospedajes();

			} catch (AuntenticacionFallidaException excepcion) {
				JOptionPane.showMessageDialog(viewAutenticacion, excepcion.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				excepcion.printStackTrace();
			}
		}

		if (e.getSource() == btnLoginRegistro) {
			viewAutenticacion.dispose();
			mostrarVentanaRegistro(true);
			viewAutenticacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		if (e.getSource() == btnRegisterLogin) {
			viewRegistro.dispose();
			viewAutenticacion.setVisible(true);
			viewRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		if (e.getSource() == btnRegisterRegistro) {
			try {
				Cliente cliente = new Cliente(viewRegistro.pedirNombre(), viewRegistro.pedirApellido(),
						viewRegistro.pedirId(), viewRegistro.pedirEmail(), viewRegistro.pedirContrasena(),
						viewRegistro.pedirNumeroTelefono(), viewRegistro.pedirDireccion());
				JOptionPane.showMessageDialog(viewRegistro, "Registro exitoso para el usuario " + cliente.getNombre(),
						"Éxito", JOptionPane.INFORMATION_MESSAGE);
				AuthCliente.registrar(cliente);
			} catch (RegistroFallidoException e2) {
				JOptionPane.showMessageDialog(viewRegistro, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e2.printStackTrace();
			}
		}
		
		if(e.getSource()==btnHospedajesLogin) {
			viewAutenticacion.dispose();
			controlHospedajes = new ControllerHospedajes();
			viewAutenticacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		if(e.getSource()==btnContactanosLogin) {
			viewAutenticacion.dispose();
			viewAutenticacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		if(e.getSource()== btnNosotrosLogin) {
			viewAutenticacion.dispose();
			viewAutenticacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		

	}

	/*
	 * public void funcionar() {
	 * 
	 * 
	 * int opcion = -1; while (opcion != 0) {
	 * viewDatosCliente.opcionesDisponibles(); opcion =
	 * viewDatosCliente.pedirOpcion(); switch (opcion) { case 1: try {
	 * metodosCliente.registrarClientePrueba(); usuarioAutenticado =
	 * AuthCliente.autenticarse(viewDatosCliente.pedirEmail(),
	 * viewDatosCliente.pedirContrasena()); opcionesReserva(); } catch
	 * (AuntenticacionFallidaException e) {
	 * viewDatosCliente.mostrarMensaje(e.getMessage()); e.printStackTrace(); }
	 * break;
	 * 
	 * case 2: try { Cliente cliente = new Cliente(viewDatosCliente.pedirNombre(),
	 * viewDatosCliente.pedirApellido(), viewDatosCliente.pedirId(),
	 * viewDatosCliente.pedirEmail(), viewDatosCliente.pedirContrasena(),
	 * viewDatosCliente.pedirNumeroTelefono(), viewDatosCliente.pedirDireccion());
	 * viewDatosCliente.registroExitoso(cliente.getNombre());
	 * AuthCliente.registrar(cliente); } catch (RegistroFallidoException e) {
	 * viewDatosCliente.mostrarMensaje(e.getMessage()); e.printStackTrace(); }
	 * 
	 * break; case 0: viewDatosCliente.saliendoDelSistema(); break; default:
	 * viewDatosCliente.opcionInvalida(); } } }
	 * 
	 * public void opcionesReserva() { int opcion = -1; while (opcion != 0) {
	 * viewDatosCliente.opcionesDeHospedaje(); opcion =
	 * viewDatosCliente.pedirOpcion(); switch (opcion) { case 1:
	 * controllerHospedajes.hospedajesDisponibles(); break; case 2: try {
	 * controllerHospedajes.buscarPorNombre(viewDatosCliente.pedirNombreHospedaje())
	 * ;
	 * 
	 * } catch (HospedajeNoEncontradoException e) {
	 * viewDatosCliente.mostrarMensaje(e.getMessage()); e.printStackTrace(); }
	 * break; case 3: try {
	 * controllerHospedajes.filtrarCiudad(viewDatosCliente.pedirCiudad()); } catch
	 * (HospedajeNoEncontradoException e) {
	 * viewDatosCliente.mostrarMensaje(e.getMessage()); e.printStackTrace(); }
	 * break; case 4: try {
	 * 
	 * controllerHospedajes.filtrarPorPais(viewDatosCliente.pedirPais());
	 * 
	 * } catch (HospedajeNoEncontradoException e) {
	 * viewDatosCliente.mostrarMensaje(e.getMessage()); e.printStackTrace(); }
	 * break; case 5: try {
	 * controllerHospedajes.filtrarPorNumeroDeEstrellas(viewDatosCliente.
	 * pedirNumeroEstrellas()); } catch (HospedajeNoEncontradoException e) {
	 * viewDatosCliente.mostrarMensaje(e.getMessage()); e.printStackTrace(); }
	 * break; case 6: try {
	 * 
	 * controllerHospedajes.filtrarTipo(viewDatosCliente.pedirTipoHospedaje()); }
	 * catch (HospedajeNoEncontradoException e) {
	 * viewDatosCliente.mostrarMensaje(e.getMessage()); e.printStackTrace(); }
	 * break; case 7:
	 * controllerHospedajes.filtrarPorPrecio(viewDatosCliente.pedirPrecioMinimo(),
	 * viewDatosCliente.pedirPrecioMaximo()); break; case 8:
	 * controllerHospedajes.filtrarHoteles(); break; case 9:
	 * controllerHospedajes.filtrarMoteles(); break; case 10:
	 * controllerHospedajes.filtralResorts(); break; case 11:
	 * controllerHospedajes.filtralCampings(); break; case 12:
	 * controllerHospedajes.filtralGlampings(); break; case 13:
	 * controllerHospedajes.filtralCabanas(); break; case 14:
	 * 
	 * viewReserva.mostrarGraciasReserva(); try { realizarReserva();
	 * 
	 * } catch (HabitacionNoEncontradaException e) {
	 * viewDatosCliente.mostrarMensaje(e.getMessage()); e.printStackTrace(); } catch
	 * (CapacidadInsuficienteException e) {
	 * viewDatosCliente.mostrarMensaje(e.getMessage()); e.printStackTrace(); }
	 * break; case 0: viewDatosCliente.saliendoDelSistema(); break; default:
	 * viewDatosCliente.opcionInvalida();
	 * 
	 * } } }
	 * 
	 * public void realizarReserva() throws HabitacionNoEncontradaException,
	 * CapacidadInsuficienteException { try { hospedajeAReservar =
	 * controllerReserva.reservarHospedaje(viewDatosCliente.pedirNombreHospedaje());
	 * 
	 * habitaciones = hospedajeAReservar.getHabitaciones();
	 * 
	 * controllerReserva.habitacionesDisponibles(habitaciones);
	 * 
	 * int numeroHabitacionReservar = viewReserva.pedirNumeroHabitacionReservar();
	 * boolean habitacionEncontrada = false; boolean habitacionDisponible = false;
	 * for (Habitacion habitacion : habitaciones) { if
	 * (habitacion.getNumeroHabitacion() == numeroHabitacionReservar) {
	 * 
	 * if (habitacion.isDisponible()) {
	 * 
	 * habitacionReservada = habitacion; habitacionEncontrada = true; String
	 * tipoHabitacion = controllerReserva.hallarTipoHabitacion(habitacion);
	 * viewReserva.imprimirTablaHabitacion(tipoHabitacion,
	 * habitacion.getCapacidad(), habitacion.isDisponible(),
	 * habitacion.getNumeroHabitacion(),
	 * habitacion.getPrecioAdicionalPorTipoHabitacion()); habitacionDisponible =
	 * true; break; } else { habitacionReservada = habitacion; habitacionEncontrada
	 * = true; habitacionDisponible = false;
	 * 
	 * break; } } }
	 * 
	 * if (!habitacionEncontrada) { throw new
	 * HabitacionNoEncontradaException("La habitacion no existe"); }
	 *//*
		 * if (habitacionDisponible) { Date fechaEntrada = null/*
		 * ViewReserva.ingresarFechaEntrada()
		 */;
	// Date fechaSalida = null /* viewReserva.ingresarFechaSalida() */;
	/*
	 * int numeroPersonas = ViewReserva.ingresarNumeroPersonas(); if
	 * (habitacionReservada.getCapacidad() >= numeroPersonas) { int numeroNoches =
	 * ViewReserva.ingresarNumeroNoches(); Reserva reserva = new
	 * Reserva(usuarioAutenticado, fechaEntrada, fechaSalida, hospedajeAReservar,
	 * habitacionReservada, numeroPersonas, numeroNoches);
	 * 
	 * double precioTotal = reserva.calcularPrecioTotal(numeroPersonas,
	 * numeroNoches);
	 * 
	 * viewReserva.mostrarPrecio(precioTotal);
	 * 
	 * controllerReserva.metodosDepago(usuarioAutenticado,
	 * usuarioAutenticado.getTarjetas(), precioTotal);
	 * 
	 * String aceptarPago = ViewReserva.realizarpago();
	 * 
	 * viewReserva.mostrarPago(reserva.realizarPago(aceptarPago, precioTotal));
	 * 
	 * String nombreClaseHabitacon = habitacionReservada.getClass().getSimpleName();
	 * 
	 * String tipoHabitacion =
	 * nombreClaseHabitacon.substring("Habitacion".length());
	 * 
	 * String tipoHospedaje =
	 * controllerReserva.hallarTipoHospedaje(hospedajeAReservar);
	 * 
	 * viewReserva.imprimirTablaReserva(usuarioAutenticado.getNombre(),
	 * usuarioAutenticado.getApellido(), usuarioAutenticado.getId(),
	 * usuarioAutenticado.getEmail(), usuarioAutenticado.getNumeroTelefono(),
	 * fechaEntrada, fechaSalida, tipoHospedaje, hospedajeAReservar.getNombre(),
	 * hospedajeAReservar.getUbicacionCiudad(),
	 * hospedajeAReservar.getUbicacionPais(), tipoHabitacion,
	 * habitacionReservada.getNumeroHabitacion(), numeroPersonas, numeroNoches,
	 * hospedajeAReservar.getPrecioPorPersona(),
	 * habitacionReservada.getPrecioAdicionalPorTipoHabitacion(),
	 * reserva.subtotal(), precioTotal);
	 * 
	 * } else {
	 * 
	 * throw new CapacidadInsuficienteException("Capacidad insuficiente"); }
	 * 
	 * }
	 * 
	 * } catch (HospedajeNoEncontradoException e) {
	 * viewDatosCliente.mostrarMensaje(e.getMessage()); e.printStackTrace(); } }
	 */
}
