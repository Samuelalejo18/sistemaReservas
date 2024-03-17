package model;

import java.util.ArrayList;

public class Piso {
	private int numeroPiso;
	private static int contadorPiso;
	private int maximoDeHabitaciones;
	private ArrayList<Habitacion> habitaciones;
	
	public Piso() {

	}

	public Piso(int maximoDeHabitaciones) {

		this.numeroPiso = Piso.contadorPiso++;
		this.maximoDeHabitaciones = maximoDeHabitaciones;
		this.habitaciones = new ArrayList<>();
		Habitacion.setContadorHabitacion(0);
	}

	public int getNumeroPiso() {
		return numeroPiso;
	}

	public void setNumeroPiso(int numeroPiso) {
		this.numeroPiso = numeroPiso;
	}

	public static int getContadorPiso() {
		return contadorPiso;
	}

	public static void setContadorPiso(int contadorPiso) {
		Piso.contadorPiso = contadorPiso;
	}

	public int getMaximoDeHabitaciones() {
		return maximoDeHabitaciones;
	}

	public void setMaximoDeHabitaciones(int maximoDeHabitaciones) {
		this.maximoDeHabitaciones = maximoDeHabitaciones;
	}

	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	// agregar Habitacion y maximo de habitaciones en un piso
	public String agregarHabitacion(Habitacion habitacion) {
		if (habitaciones.size() <= getMaximoDeHabitaciones()) {
			habitaciones.add(habitacion);
			return "";
		} else {
			return " Habitacion no disponible";
		}
	}

	public String HabitacionesDisponibles(int numeroHabitacion) {
		for (Habitacion habitacion : habitaciones) {
			if (habitacion.getNumeroHabitacion() == numeroHabitacion) {
				if (habitacion.isDisponible()) {
					return habitacion.getNumeroHabitacion() + "esta disponible";

				} else {
					return habitacion.getNumeroHabitacion() + " no esta disponible";
				}
			} else {
				return "la habitacion no existe";
			}
		}
		return " ";
	}

	@Override
	public String toString() {
		return "Piso [numeroPiso=" + numeroPiso + ", maximoDeHabitaciones=" + maximoDeHabitaciones + ", habitaciones="
				+ habitaciones + "]";
	}

}
