package co.edu.konradlorenz.model.hospedajes;

public class Resort extends Hospedaje {

	private String actividadesExtra;
	private String espaciosExclusivos;

	public Resort(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo, double precioPorPersona,String url, String actividadesExtra,
			String espaciosExclusivos) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo,
				precioPorPersona, url);
		this.actividadesExtra = actividadesExtra;
		this.espaciosExclusivos = espaciosExclusivos;
		
	}

	public Resort(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, 
			String descripcion, String tipo, double precioPorPersona, String url) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo,
				precioPorPersona, url);
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
