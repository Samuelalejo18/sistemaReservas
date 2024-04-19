package co.edu.konradlorenz.model;

public class Glamping extends Hospedaje {

	private String experienciasNaturales;
	private String servicios;
	private String sostenibilidad;

	public Glamping() {
		super();
		
	}

	public Glamping(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo, String experienciasNaturales, String servicios, String sostenibilidad) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo);
		this.experienciasNaturales = experienciasNaturales;
		this.servicios = servicios;
		this.sostenibilidad = sostenibilidad;

	}
	@Override
	public double calcularPrecioPorNoche(String tipoHabitacion) {

		double precioTotal = PreciosGlamping.TARIFA_BASE;
		switch (tipoHabitacion.toLowerCase()) {
			case "suite":
				precioTotal += PreciosGlamping.PRECIO_YUTAS;
				break;
			case "presidencial":
				precioTotal += PreciosGlamping.PRECIO_TIPI;
				break;
			case "dobles":
				precioTotal += PreciosGlamping.PRECIO_CUBOS;
				break;
			case "sencilla":
				precioTotal += PreciosGlamping.PRECIO_DOMOS;
				break;
			default:
				System.out.println("Tipo de habitación no válido");
				return calcularPrecioPorNoche(tipoHabitacion);
		}
		return precioTotal;

	}

	public Glamping(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo);

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
