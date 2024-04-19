package co.edu.konradlorenz.view;

public class ViewHospedaje {

	public ViewHospedaje() {

	}

	public void mostrarTitulo() {

		System.out.format("%20s %20s %20s %20s %20s %20s %20s %n","Tipo Hospedaje" ,"nombre", " ubicacion Ciudad", "ubicacion Pais",
				"numero Estrellas", "descripcion", "tipo");

	}

	public static void imprimirTabla(String tH,String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo) {

		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.format("%20s %20s %20s %20s %20d %20s %2s %n",tH, nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas,
				descripcion, tipo);
		System.out.println("\n");
	}
	/*
	 * public void filtrofallido(){
	 * System.out.println("no se encontro el hospedaje indicado, intente nuevamente"
	 * );
	 * }
	 */
}
