package co.edu.konradlorenz.model.hospedajes;

import java.util.ArrayList;

import co.edu.konradlorenz.model.habitaciones.Habitacion;

public class Hospedaje {
	protected String nombre;
	protected String ubicacionCiudad;
	protected String ubicacionPais;
	protected int numeroEstrellas;
	protected String descripcion;
	protected String tipo;
	protected double precioPorPersona;
	private String url;
	private ArrayList<Habitacion> habitaciones;

	public Hospedaje() {

	}

	public Hospedaje(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo, double precioPorPersona, String url) {
		this.nombre = nombre;
		this.ubicacionCiudad = ubicacionCiudad;
		this.ubicacionPais = ubicacionPais;
		this.numeroEstrellas = numeroEstrellas;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.precioPorPersona = precioPorPersona;
		this.url = url;
		habitaciones = new ArrayList<>();
	
		Habitacion.setContadorHabitacion(0);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacionCiudad() {
		return ubicacionCiudad;
	}

	public void setUbicacionCiudad(String ubicacionCiudad) {
		this.ubicacionCiudad = ubicacionCiudad;
	}

	public String getUbicacionPais() {
		return ubicacionPais;
	}

	public void setUbicacionPais(String ubicacionPais) {
		this.ubicacionPais = ubicacionPais;
	}

	public int getNumeroEstrellas() {
		return numeroEstrellas;
	}

	public void setNumeroEstrellas(int numeroEstrellas) {
		this.numeroEstrellas = numeroEstrellas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecioPorPersona() {
		return precioPorPersona;
	}

	public void setPrecioPorPersona(double precioPorPersona) {
		this.precioPorPersona = precioPorPersona;
	}

	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public void agregarHabitacion(Habitacion habitacion) {
		habitaciones.add(habitacion);

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	@Override
	public String toString() {
		return "Hospedaje [nombre=" + nombre + ", ubicacionCiudad=" + ubicacionCiudad + ", ubicacionPais="
				+ ubicacionPais + ", numeroEstrellas=" + numeroEstrellas + ", descripcion=" + descripcion + ", tipo="
				+ tipo + ", precioPorPersona=" + precioPorPersona + ", habitaciones=" + habitaciones + "]";
	}


}
