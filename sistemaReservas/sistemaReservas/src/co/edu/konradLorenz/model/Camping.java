package co.edu.konradLorenz.model;

public class Camping extends Hospedaje {
	private String zonasComunes;
	private String actividadesAlAireLibre;

	public Camping() {
		super();

	}

	public Camping(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo, String zonasComunes, String actividadesAlAireLibre) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo);
		this.zonasComunes = zonasComunes;
		this.actividadesAlAireLibre = actividadesAlAireLibre;
	}

	public double calcularPrecioPorNoche(String tipoHabitacion) {

		double precioTotal = PreciosCamping.TARIFA_BASE;
		switch (tipoHabitacion.toLowerCase()) {
			case "bungalows":
				precioTotal += PreciosCamping.PRECIO_BUNGALOWS;
				break;
			case "mobile home":
				precioTotal += PreciosCamping.PRECIO_MOBILEHOME;
				break;
			case "pod":
				precioTotal += PreciosCamping.PRECIO_POD;
				break;
			case "casa en el arbol":
				precioTotal += PreciosCamping.PRECIO_CASA_EN_EL_ÁRBOL;
				break;
			default:
				System.out.println("Tipo de habitación no válido");
				break;
		}
		return precioTotal;

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
