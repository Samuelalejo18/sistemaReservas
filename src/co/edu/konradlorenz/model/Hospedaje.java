package co.edu.konradlorenz.model;

import java.util.ArrayList;

public abstract class Hospedaje {
	protected String nombre;
	protected String ubicacionCiudad;
	protected String ubicacionPais;
	protected int numeroEstrellas;
	protected String descripcion;
	protected String tipo;
	protected double precioPorPersona;
	private ArrayList<Habitacion> habitaciones;

	public Hospedaje() {

	}

	public Hospedaje(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo, double precioPorPersona) {
		this.nombre = nombre;
		this.ubicacionCiudad = ubicacionCiudad;
		this.ubicacionPais = ubicacionPais;
		this.numeroEstrellas = numeroEstrellas;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.precioPorPersona = precioPorPersona;
		habitaciones = new ArrayList<>();
		sumaPorHabitacion();
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

	// Calcular precio por persona de acuerdo a la habitacion, dependiendo el tipo
	// de habitacion el precio por persona aumenta
	public double sumaPorHabitacion() {
		double sumaPorHabitacion = 0;
		for (Habitacion habitacion : habitaciones) {
			if (habitacion instanceof HabitacionBase) {
				sumaPorHabitacion = habitacion.getPrecioAdicionalPorTipoHabitacion();
			} else if (habitacion instanceof HabitacionDoble) {
				sumaPorHabitacion = precioPorPersona + habitacion.getPrecioAdicionalPorTipoHabitacion();
			} else if (habitacion instanceof HabitacionPresidencial) {
				sumaPorHabitacion = precioPorPersona + habitacion.getPrecioAdicionalPorTipoHabitacion();
			} else if (habitacion instanceof HabitacionPresidencial) {
				sumaPorHabitacion = precioPorPersona + habitacion.getPrecioAdicionalPorTipoHabitacion();
			} else if (habitacion instanceof HabitacionPresidencial) {
				sumaPorHabitacion = precioPorPersona + habitacion.getPrecioAdicionalPorTipoHabitacion();
			}
		}

		return sumaPorHabitacion;
	}

	@Override
	public String toString() {
		return "Hospedaje [nombre=" + nombre + ", ubicacionCiudad=" + ubicacionCiudad + ", ubicacionPais="
				+ ubicacionPais + ", numeroEstrellas=" + numeroEstrellas + ", descripcion=" + descripcion + ", tipo="
				+ tipo + ", precioPorPersona=" + precioPorPersona + ", habitaciones=" + habitaciones + "]";
	}

}
