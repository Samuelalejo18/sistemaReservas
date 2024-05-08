package co.edu.konradlorenz.model.hospedajes;

import co.edu.konradlorenz.model.Hospedaje;

public class Motel extends Hospedaje  {
	private String tematica;
	private boolean jacuzzi;
	private String servicio;

	public Motel() {
	}

	public Motel(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, 
			String descripcion, String tipo,double precioPorPersona, String tematica, boolean jacuzzi, String servicio) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioPorPersona);
		this.tematica = tematica;
		this.jacuzzi = jacuzzi;
		this.servicio = servicio;
		
	}


	public Motel(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, String descripcion,
			String tipo, double precioPorPersona) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioPorPersona);

	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public boolean isJacuzzi() {
		return jacuzzi;
	}

	public void setJacuzzi(boolean jacuzzi) {
		this.jacuzzi = jacuzzi;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "Motel [tematica=" + tematica + ", jacuzzi=" + jacuzzi + ", servicio=" + servicio + "]";
	}

}
