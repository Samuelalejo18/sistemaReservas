package co.edu.konradlorenz.model;

public class Resort extends Hospedaje {

	private String actividadesExtra;
	private String espaciosExclusivos;

	public Resort(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, int maximoDePisos,
			String descripcion, String tipo, double precioPorPersona, String actividadesExtra,
			String espaciosExclusivos) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioPorPersona);
		this.actividadesExtra = actividadesExtra;
		this.espaciosExclusivos = espaciosExclusivos;
	}

	public Resort(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, int maximoDePisos,
			String descripcion, String tipo, double precioPorPersona) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioPorPersona);
	}

	public String getActividadesExtra() {
		return actividadesExtra;
	}

	public void setActividadesExtra(String actividadesExtra) {
		this.actividadesExtra = actividadesExtra;
	}

	public String getEspaciosExclusivos() {
		return espaciosExclusivos;
	}

	@Override
	public double calcularPrecioPorNoche(String tipoHabitacion) {

		double precioTotal = PreciosHotel.TARIFA_BASE;
		switch (tipoHabitacion.toLowerCase()) {
			case "suite":
				precioTotal += PreciosHotel.PRECIO_SUITE;
				break;
			case "presidencial":
				precioTotal += PreciosHotel.PRECIO_PRESIDENCIAL;
				break;
			case "dobles":
				precioTotal += PreciosHotel.PRECIO_DOBLES;
				break;
			case "sencilla":
				precioTotal += PreciosHotel.PRECIO_SENCILLA;
				break;
			default:

				return calcularPrecioPorNoche(tipoHabitacion);
		}
		return precioTotal;

	}

	public void setEspaciosExclusivos(String espaciosExclusivos) {
		this.espaciosExclusivos = espaciosExclusivos;
	}

}
