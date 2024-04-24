package co.edu.konradlorenz.model;

public class Camping extends Hospedaje {
	private String zonasComunes;
	private String actividadesAlAireLibre;

	public Camping() {
		super();

	}

	public Camping(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo, double precioPorPersona, String zonasComunes,
			String actividadesAlAireLibre) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioPorPersona);
		this.zonasComunes = zonasComunes;
		this.actividadesAlAireLibre = actividadesAlAireLibre;
		sumaPorHabitacion();
	}

	public Camping(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, String descripcion,
			String tipo, double precioPorPersona) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioPorPersona);

	}

	public String getZonasComunes() {
		return zonasComunes;
	}

	public void setZonasComunes(String zonasComunes) {
		this.zonasComunes = zonasComunes;
	}

	public String getActividadesAlAireLibre() {
		return actividadesAlAireLibre;
	}

	public void setActividadesAlAireLibre(String actividadesAlAireLibre) {
		this.actividadesAlAireLibre = actividadesAlAireLibre;
	}

	public double calcularPrecioPorNoche(String tipoHabitacion) {

		return 0;

	}

	@Override
	public String toString() {
		return "Camping [zonasComunes=" + zonasComunes + ", actividadesAlAireLibre=" + actividadesAlAireLibre + "]";
	}

	

}
