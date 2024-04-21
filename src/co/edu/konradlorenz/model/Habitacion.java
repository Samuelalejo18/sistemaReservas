package co.edu.konradlorenz.model;

public class Habitacion {

	private int capacidad;
	private boolean disponible;
	private int numeroHabitacion;
	private static int contadorHabitacion;

	public Habitacion() {
	}

	public Habitacion(int capacidad, boolean disponible) {

		this.capacidad = capacidad;
		this.disponible = disponible;
		this.numeroHabitacion = Habitacion.contadorHabitacion++;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public static int getContadorHabitacion() {
		return contadorHabitacion;
	}

	public static void setContadorHabitacion(int contadorHabitacion) {
		Habitacion.contadorHabitacion = contadorHabitacion;
	}

	@Override
	public String toString() {
		return "Habitacion [, capacidad=" + capacidad + ", disponible=" + disponible
				+ ", numeroHabitacion=" + numeroHabitacion + "]";
	}

}
