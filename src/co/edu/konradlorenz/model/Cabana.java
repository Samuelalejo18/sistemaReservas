package co.edu.konradlorenz.model;

//cabaña
public class Cabana extends Hospedaje  implements PreciosCabana{

	private String decoracion;
	private boolean vistasExclusivas;
	private String actividadesExtra;

	public Cabana() {
		super();

	}

	public Cabana(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo, String decoracion, boolean vistasExclusivas, String actividadesExtra) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo);
		this.decoracion = decoracion;
		this.vistasExclusivas = vistasExclusivas;
		this.actividadesExtra = actividadesExtra;
	}
	@Override
	public double calcularPrecioPorNoche(String tipoHabitacion) {
		double precioTotal = TARIFA_BASE;
		switch (tipoHabitacion.toLowerCase()) {
			case "jacuzzi":
				precioTotal += PRECIO_JACUZZI;
				break;
			case "wifi":
				precioTotal += PRECIO_WIFI;
				break;
			case "dobles":
				precioTotal += PRECIO_DOBLES;
				break;
			case "sencilla":
				precioTotal += PRECIO_SENCILLA;
				break;
			default:
				System.out.println("Tipo de habitación no válido");
				break;
		}
		return precioTotal;

	}

	public Cabana(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, String descripcion,
			String tipo) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo);
		// TODO Auto-generated constructor stub
	}

	public String getDecoracion() {
		return decoracion;
	}

	public void setDecoracion(String decoracion) {
		this.decoracion = decoracion;
	}

	public boolean isVistasExclusivas() {
		return vistasExclusivas;
	}

	public void setVistasExclusivas(boolean vistasExclusivas) {
		this.vistasExclusivas = vistasExclusivas;
	}

	public String getActividadesExtra() {
		return actividadesExtra;
	}

	public void setActividadesExtra(String actividadesExtra) {
		this.actividadesExtra = actividadesExtra;
	}

	@Override
	public String toString() {
		return "Cabana [decoracion=" + decoracion + ", vistasExclusivas=" + vistasExclusivas + ", actividadesExtra="
				+ actividadesExtra + "]";
	}

}
