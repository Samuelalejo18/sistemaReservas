package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Piso;

public class ViewDatosCliente {
	Scanner sc = new Scanner(System.in);

	public int pedirOpcion() {

		int opcion = sc.nextInt();
		return opcion;
	}

	public void opcionesDisponibles() {
		System.out.println("Ingrese una opcion : ");
		System.out.println("1. Autenticarse ");
		System.out.println("2.Registrarse ");
		System.out.println("0.Salir del sistema de reservas");
	}

	public String pedirEmail() {
		System.out.println("Ingrese email del usuario: ");
		String email = sc.next();
		return email;
	}

	public String pedirContrasena() {
		System.out.println("Ingrese la contraña del usuario: ");
		String contrasena = sc.next();
		return contrasena;
	}

	public String pedirNombre() {
		System.out.println("Ingrese el nombre del usuario: ");
		String nombre = sc.next();
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
		String direccion = sc.nextLine();
		return direccion;
	}

	public void saliendoDelSistema() {
		System.out.println("Saliendo del sistema de reservas");
	}

	

}
