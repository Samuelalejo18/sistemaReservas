package co.edu.konradlorenz.model;

import java.sql.Date;


public class Reserva implements Pago {
	private Cliente cliente;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Hospedaje hospedajeReservado;
	private Habitacion habitacionReservada;
	private int cantidadDePersonas;
	private double precioTotal;
	private int numeroNoches;
	public Reserva() {
	}

	public Reserva(Cliente cliente, Date fechaEntrada, Date fechaSalida, Hospedaje hospedajeReservado,
			Habitacion habitacionReservada, int cantidadDePersonas, int numeroNoches) {
		this.cliente = cliente;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.hospedajeReservado = hospedajeReservado;
		this.habitacionReservada = habitacionReservada;
		this.cantidadDePersonas = cantidadDePersonas;
		
		this.numeroNoches = numeroNoches;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Hospedaje getHospedajeReservado() {
		return hospedajeReservado;
	}

	public void setHospedajeReservado(Hospedaje hospedajeReservado) {
		this.hospedajeReservado = hospedajeReservado;
	}

	public int getCantidadDePersonas() {
		return cantidadDePersonas;
	}

	public void setCantidadDePersonas(int cantidadDePersonas) {
		this.cantidadDePersonas = cantidadDePersonas;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getNumeroNoches() {
		return numeroNoches;
	}

	public void setNumeroNoches(int numeroNoches) {
		this.numeroNoches = numeroNoches;
	}

	public Habitacion getHabitacionReservada() {
		return habitacionReservada;
	}

	public void setHabitacionReservada(Habitacion habitacionReservada) {
		this.habitacionReservada = habitacionReservada;
	}




	@Override
	public double calcularPrecioTotal(int numeroPersonas, int numeroNoches) {
		double precioPorPersona = hospedajeReservado.sumaPorHabitacion();
		double precio = 0;
		if (numeroPersonas > 2) {
			precio = precioPorPersona * numeroPersonas * numeroNoches;
			precioTotal = precio + (precio * IMPUESTO);
		} else if (numeroPersonas >= 1 && numeroPersonas <= 2) {
			precio = precioPorPersona * numeroNoches;
			precioTotal = precio + (precio * IMPUESTO);
		}

		return precioTotal;

	}

	@Override
	public String realizarPago(boolean aceptar) {
		String pagoRealizado = "";
		if (aceptar) {
			pagoRealizado = " Pago realizado por un total de : "
					+ calcularPrecioTotal(cantidadDePersonas, numeroNoches);
		} else {
			cancelarPago();
		}
		return pagoRealizado;
	}

	@Override
	public String cancelarPago() {
		return " Pago Cancelado";
	}

	


	@Override
	public String toString() {
		return "Reserva [cliente=" + cliente + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida
				+ ", hospedajeReservado=" + hospedajeReservado + ", cantidadDePersonas=" + cantidadDePersonas
				+ ", precioTotal=" + precioTotal + ", numeroNoches="
				+ numeroNoches + "]";
	}

}
