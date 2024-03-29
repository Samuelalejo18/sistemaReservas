package model;

import java.util.ArrayList;

public class Hospedaje {
	protected String nombre;
	protected String ubicacionCiudad;
	protected String ubicacionPais;
	protected int numeroEstrellas;
	protected int maximoDePisos;
	protected String descripcion;
	protected String tipo;
	private ArrayList<Piso> pisos;
	

	public Hospedaje() {

	}

	public Hospedaje(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			int maximoDePisos, String descripcion, String tipo) {
		this.nombre = nombre;
		this.ubicacionCiudad = ubicacionCiudad;
		this.ubicacionPais = ubicacionPais;
		this.numeroEstrellas = numeroEstrellas;
		this.maximoDePisos = maximoDePisos;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.pisos = new ArrayList<>();
	}

	public void agregarPiso(Piso piso) {
		if (pisos.size() <= getMaximoDePisos()) {
			pisos.add(piso);

		}
	}

	public Hospedaje(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
			String descripcion, String tipo) {
		this.nombre = nombre;
		this.ubicacionCiudad = ubicacionCiudad;
		this.ubicacionPais = ubicacionPais;
		this.numeroEstrellas = numeroEstrellas;
		this.descripcion = descripcion;
		this.tipo = tipo;
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

	public int getMaximoDePisos() {
		return maximoDePisos;
	}

	public void setMaximoDePisos(int maximoDePisos) {
		this.maximoDePisos = maximoDePisos;
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

	public ArrayList<Piso> getPisos() {
		return pisos;
	}

	public void setPisos(ArrayList<Piso> pisos) {
		this.pisos = pisos;
	}

	@Override
	public String toString() {
		return "Hospedaje [nombre=" + nombre + ", ubicacionCiudad=" + ubicacionCiudad + ", ubicacionPais="
				+ ubicacionPais + ", numeroEstrellas=" + numeroEstrellas + ", maximoDePisos=" + maximoDePisos
				+ ", descripcion=" + descripcion + ", tipo=" + tipo + ", pisos=" + pisos + "]";
	}
	
	public double calcularPrecioPorNoche(String tipoHabitacion) {
        
        return 0.0; 
    }

}
