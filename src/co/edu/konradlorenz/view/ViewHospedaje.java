package co.edu.konradlorenz.view;

import java.util.Scanner;

public class ViewHospedaje {
	static Scanner sc = new Scanner(System.in);

	public ViewHospedaje() {

	}

	public void mostrarTitulo() {

		System.out.format("%-20s %-20s %-20s %-20s %-20s %-40s %-20s %-20s %n",
				"Tipo Hospedaje", "nombre", "ubicacion Ciudad", "ubicacion Pais",
				"numero Estrellas", "descripcion", "tipo", "Precio por persona");

	}

	public static void imprimirTabla(String tH, String nombre, String ubicacionCiudad, String ubicacionPais,
			int numeroEstrellas,
			String descripcion, String tipo, double precioPorPersona) {

		System.out.println(
				"-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.format("%-20s %-20s %-20s %-20s %-10d %-30s %-20s %20f %n", tH, nombre, ubicacionCiudad,
				ubicacionPais,
				numeroEstrellas,
				descripcion, tipo, precioPorPersona);

		System.out.println("\n");
	}

	public static void filtroFallido() {
		System.out.println("No se encontro ningun resultado");
	}

}
