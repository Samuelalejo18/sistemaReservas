package co.edu.konradlorenz.model;


public class Motel extends Hospedaje  {
	private String tematica;
	private boolean jacuzzi;
	private String servicio;

	public Motel() {
	}

	public Motel(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, 
			String descripcion, String tipo,double precioAdicionalPorTipoHabitacion, String tematica, boolean jacuzzi, String servicio) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioAdicionalPorTipoHabitacion);
		this.tematica = tematica;
		this.jacuzzi = jacuzzi;
		this.servicio = servicio;
		sumaPorHabitacion();
	}


	public Motel(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, String descripcion,
			String tipo, double precioAdicionalPorTipoHabitacion) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioAdicionalPorTipoHabitacion);

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
