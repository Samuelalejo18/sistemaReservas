package co.edu.konradlorenz.model;

public class Habitacion {
	private String tipo;
	private int capacidad;
	private boolean disponible;
	private double precioPorNoche;
	private int numeroHabitacion;
	private static int contadorHabitacion;

	public Habitacion() {
	}

	public Habitacion(String tipo, int capacidad, boolean disponible, double precioPorNoche) {

		this.tipo = tipo;
		this.capacidad = capacidad;
		this.disponible = disponible;
		this.precioPorNoche = precioPorNoche;
		this.numeroHabitacion = Habitacion.contadorHabitacion++;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public double getPrecioPorNoche() {
		return precioPorNoche;
	}

	public void setPrecioPorNoche(double precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
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
		return "Habitacion [tipo=" + tipo + ", capacidad=" + capacidad + ", disponible=" + disponible
				+ ", precioPorNoche=" + precioPorNoche + ", numeroHabitacion=" + numeroHabitacion + "]";
	}

}
