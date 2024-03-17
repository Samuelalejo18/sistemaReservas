package model;

public class Glamping extends Hospedaje {

	private String experienciasNaturales;
	private String servicios;
	private String sostenibilidad;

	public Glamping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Glamping(String experienciasNaturales, String servicios, String sostenibilidad) {
		this.experienciasNaturales = experienciasNaturales;
		this.servicios = servicios;
		this.sostenibilidad = sostenibilidad;
	}

	public Glamping(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo, String experienciasNaturales, String servicios, String sostenibilidad) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo);
		this.experienciasNaturales = experienciasNaturales;
		this.servicios = servicios;
		this.sostenibilidad = sostenibilidad;
		
	}

	public Glamping(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo);
		// TODO Auto-generated constructor stub
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
