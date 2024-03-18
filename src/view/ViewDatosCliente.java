package view;

import java.util.Scanner;

public class ViewDatosCliente {
	Scanner sc = new Scanner(System.in);

	public ViewDatosCliente() {
	}

	public int pedirOpcion() {

		int opcion = sc.nextInt();
		return opcion;
	}

	public void opcionesDisponibles() {
		System.out.println("Ingrese una opcion : ");
		System.out.println("1. Autenticarse ");
		System.out.println("2.Registrarse ");
		System.out.println("0.Salir del sistema de reservas");
		System.out.println("\n");
	}

	public void opcionesDeHospedaje() {
		System.out.println("\n");
		System.out.println("Ingrese una opcion");
		System.out.println("1.Mostrar hospedajes disponibles : ");
		System.out.println("2.Buscar por nombre: ");
		System.out.println("3.Filtrar por ciudad: ");
		System.out.println("4.Filtrar por pais: ");
		System.out.println("5. Filtrar por numero de estrellas: ");
		System.out.println("6.Filtrar por tipo(rural/urbano): ");
		System.out.println("7.Filtrar por precio: ");
		System.out.println("8.Reservar: ");
		System.out.println("0. Salir del sistema de reservas");
		System.out.println("\n");

	}

	public String pedirEmail() {
		System.out.println("\n");
		System.out.println("Ingrese email del usuario: ");
		String email = sc.next();
		return email;

	}

	public String pedirContrasena() {
		System.out.println("\n");
		System.out.println("Ingrese la contraña del usuario: ");
		String contrasena = sc.next();
		return contrasena;
	}

	public String pedirNombre() {
		System.out.println("\n");
		System.out.println("Ingrese el nombre del usuario: ");
		String nombre = sc.nextLine();
		return nombre;
	}

	public String pedirApellido() {
		System.out.println("Ingrese el apellido del usuario:");
		String apellido = sc.next();
		return apellido;
	}

	public int pedirId() {
		System.out.println("Ingrese el ID del usuario:");
		int id = sc.nextInt();
		return id;
	}

	public int pedirNumeroTelefono() {
		System.out.println("Ingrese el número de teléfono del usuario:");
		int numeroTelefono = sc.nextInt();
		return numeroTelefono;
	}

	public String pedirDireccion() {
		System.out.println("Ingrese la dirección del usuario:");
		sc.nextLine();
		String direccion = sc.next();
		return direccion;
	}

	public void saliendoDelSistema() {
		System.out.println("\n");
		System.out.println("Saliendo del sistema de reservas");
	}

	public void opcionInvalida() {
		System.out.println("opcion invalida");
	}

	public int pedirPrecioMinimo() {
		System.out.println("Ingrese el precio minimo: ");
		int numeroMinimo = sc.nextInt();
		return numeroMinimo;
	}

	public int pedirPrecioMaximo() {
		System.out.println("Ingrese el precio maximo: ");
		int numeroMaximo = sc.nextInt();
		return numeroMaximo;
	}

	public void autenticacionExitosa() {
		System.out.println("Autenticación exitosa ");
		System.out.println("\n");
	}

	public void autenticacionFallida() {
		System.out.println("Autenticación fallida. Verifique su email y contraseña.");
		System.out.println("\n");
	}

	public void registroExitoso(String nombre) {
		System.out.println("Registro exitoso para el usuario  " + nombre);
		System.out.println("\n");
	}

	public void registroFallido(String nombre) {
		System.out.println("Registro fallido, para   " + nombre);
		System.out.println("\n");
	}

	public String pedirCiudad() {

		System.out.println("Ingrese nombre de la ciudad: ");
		sc.nextLine();
		String nombreCiudad = sc.next();
		return nombreCiudad;
	}

	public String pedirPais() {
		System.out.println("Ingrese nombre del pais: ");

		String nombrePais = sc.next();
		return nombrePais;

	}

	public int pedirNumeroEstrellas() {
		System.out.println("Ingrese numero de estrellas : ");
		int numeroEstrellas = sc.nextInt();
		return numeroEstrellas;

	}

	public String pedirTipoHospedaje() {
		System.out.println("Ingrese el tipo de hospedaje(urbano/rural): ");

		String tipoHospedaje = sc.next();
		return tipoHospedaje;
	}

	public String pedirNombreHospedaje() {
		System.out.println("Ingrese el nombre del hospedaje:  ");
		sc.nextLine();
		String nombre = sc.nextLine();
		return nombre;
	}

	public String pedirTipoHabitacion() {
		System.out.println("Ingrese el tipo de habitacion:  ");
		sc.nextLine();
		String tipo = sc.nextLine();
		return tipo;
	}

	public void mostrarPrecio() {

	}

	public String nombreHospedajeReservar() {
		return "";
	}
}
