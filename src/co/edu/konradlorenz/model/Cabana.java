package co.edu.konradlorenz.model;

//cabaña
public class Cabana extends Hospedaje {

	private String decoracion;
	private boolean vistasExclusivas;
	private String actividadesExtra;

	public Cabana() {
		super();

	}

	public Cabana(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo,double precioAdicionalPorTipoHabitacion, String decoracion, boolean vistasExclusivas, String actividadesExtra) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioAdicionalPorTipoHabitacion);
		this.decoracion = decoracion;
		this.vistasExclusivas = vistasExclusivas;
		this.actividadesExtra = actividadesExtra;
		sumaPorHabitacion();
	}
	
	public Cabana(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, String descripcion,
	String tipo, double precioAdicionalPorTipoHabitacion) {
		super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioAdicionalPorTipoHabitacion);
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
