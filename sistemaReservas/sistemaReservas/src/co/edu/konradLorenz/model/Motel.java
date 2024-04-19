package co.edu.konradLorenz.model;

public class Motel extends Hospedaje {
	private String tematica;
	private boolean jacuzzi;
	private String servicio;

	public Motel() {
	}

	public Motel(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, int maximoDePisos,
			String descripcion, String tipo, String tematica, boolean jacuzzi, String servicio) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo);
		this.tematica = tematica;
		this.jacuzzi = jacuzzi;
		this.servicio = servicio;
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
				System.out.println("Tipo de habitación no válido");
				break;
		}
		return precioTotal;
		
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
