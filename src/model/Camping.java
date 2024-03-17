package model;

public class Camping extends Hospedaje {
	private String zonasComunes;
	private String actividadesAlAireLibre;

	public Camping() {
		super();

	}

	public Camping(String zonasComunes, String actividadesAlAireLibre) {
		this.zonasComunes = zonasComunes;
		this.actividadesAlAireLibre = actividadesAlAireLibre;
	}

	public Camping(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo, String zonasComunes, String actividadesAlAireLibre) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo);
		this.zonasComunes = zonasComunes;
		this.actividadesAlAireLibre = actividadesAlAireLibre;
	}

	public Camping(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, String descripcion,
			String tipo) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo);

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

	@Override
	public String toString() {
		return "Camping [zonasComunes=" + zonasComunes + ", actividadesAlAireLibre=" + actividadesAlAireLibre + "]";
	}

}
