package model;

public class Motel extends Hospedaje {
	private String tematica;
	private boolean jacuzzi;
	private String servicios;

	public Motel() {
	}

	public Motel(String tematica, boolean jacuzzi, String servicios) {
		this.tematica = tematica;
		this.jacuzzi = jacuzzi;
		this.servicios = servicios;
	}



	
	public Motel(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, int maximoDePisos,
			String descripcion, String tipo, String tematica, boolean jacuzzi, String servicios) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, maximoDePisos, descripcion, tipo);
		this.tematica = tematica;
		this.jacuzzi = jacuzzi;
		this.servicios = servicios;
	}

	public Motel(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, String descripcion,
			String tipo) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo);
		
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

	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

	@Override
	public String toString() {
		return "Motel [tematica=" + tematica + ", jacuzzi=" + jacuzzi + ", servicios=" + servicios + "]";
	}

}
