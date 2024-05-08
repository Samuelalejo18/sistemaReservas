package co.edu.konradlorenz.model.hospedajes;

import co.edu.konradlorenz.model.Hospedaje;

public class Resort extends Hospedaje {

	private String actividadesExtra;
	private String espaciosExclusivos;

	public Resort(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo, double precioPorPersona, String actividadesExtra,
			String espaciosExclusivos) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo,
				precioPorPersona);
		this.actividadesExtra = actividadesExtra;
		this.espaciosExclusivos = espaciosExclusivos;
		
	}

	public Resort(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, 
			String descripcion, String tipo, double precioPorPersona) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo,
				precioPorPersona);
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
