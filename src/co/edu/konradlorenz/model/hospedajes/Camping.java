package co.edu.konradlorenz.model.hospedajes;

public class Camping extends Hospedaje {
	private String zonasComunes;
	private String actividadesAlAireLibre;

	public Camping() {
		super();

	}

	public Camping(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo, double precioPorPersona, String url,  String zonasComunes,
			String actividadesAlAireLibre) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioPorPersona, url);
		this.zonasComunes = zonasComunes;
		this.actividadesAlAireLibre = actividadesAlAireLibre;
		
	}

	public Camping(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, String descripcion,
			String tipo, double precioPorPersona, String url) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioPorPersona, url);

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
