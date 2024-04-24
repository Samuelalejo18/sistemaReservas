package co.edu.konradlorenz.model;

public class Glamping extends Hospedaje {

	private String experienciasNaturales;
	private String servicios;
	private String sostenibilidad;

	public Glamping() {
		super();
		
	}

	public Glamping(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo, double precioPorPersona,String experienciasNaturales, String servicios, String sostenibilidad) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioPorPersona);
		this.experienciasNaturales = experienciasNaturales;
		this.servicios = servicios;
		this.sostenibilidad = sostenibilidad;
		sumaPorHabitacion();
	}
	

	public Glamping(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo, double precioPorPersona) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioPorPersona);

	}

	public String getExperienciasNaturales() {
		return experienciasNaturales;
	}

	public void setExperienciasNaturales(String experienciasNaturales) {
		this.experienciasNaturales = experienciasNaturales;
	}

	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

	public String getSostenibilidad() {
		return sostenibilidad;
	}

	public void setSostenibilidad(String sostenibilidad) {
		this.sostenibilidad = sostenibilidad;
	}

	@Override
	public String toString() {
		return "Glamping [experienciasNaturales=" + experienciasNaturales + ", servicios=" + servicios
				+ ", sostenibilidad=" + sostenibilidad + "]";
	}

}
