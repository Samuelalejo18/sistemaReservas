package co.edu.konradlorenz.model;

public class Resort extends Hospedaje {

	private String actividadesExtra;
	private String espaciosExclusivos;

	public Resort(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, int maximoDePisos,
			String descripcion, String tipo, double precioAdicionalPorTipoHabitacion, String actividadesExtra,
			String espaciosExclusivos) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioAdicionalPorTipoHabitacion);
		this.actividadesExtra = actividadesExtra;
		this.espaciosExclusivos = espaciosExclusivos;
		sumaPorHabitacion();
	}

	public Resort(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, int maximoDePisos,
			String descripcion, String tipo, double precioAdicionalPorTipoHabitacion) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioAdicionalPorTipoHabitacion);
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



	public void setEspaciosExclusivos(String espaciosExclusivos) {
		this.espaciosExclusivos = espaciosExclusivos;
	}

}
