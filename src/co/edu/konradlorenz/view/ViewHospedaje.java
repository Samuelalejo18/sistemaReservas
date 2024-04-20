package co.edu.konradlorenz.view;

public class ViewHospedaje {

	public ViewHospedaje() {

	}

	public void mostrarTitulo() {

		System.out.format("%-20s %-20s %-20s %-20s %-20s %-40s %-20s %n",
                  "Tipo Hospedaje", "nombre", "ubicacion Ciudad", "ubicacion Pais",
                  "numero Estrellas", "descripcion", "tipo");


	}

	public static void imprimirTabla(String tH,String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo) {

		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.format("%-20s %-20s %-20s %-20s %-10d %30s %20s %n", tH, nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas,
				descripcion, tipo);


		System.out.println("\n");
	}
	

	public static void filtroFallido () {
		System.out.println("No se encontro ningun resultado");
	}
}
