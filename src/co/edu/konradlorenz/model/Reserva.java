package co.edu.konradlorenz.model;

import java.sql.Date;

public class Reserva implements Pago {
	private Cliente cliente;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Hospedaje hospedajeReservado;
	private int cantidadDePersonas;
	private double precioTotal;
	private int numeroNoches;

	
	public Reserva(Cliente cliente, Date fechaEntrada, Date fechaSalida, Hospedaje hospedajeReservado,
			int cantidadDePersonas, double precioTotal, int numeroNoches) {
		this.cliente = cliente;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.hospedajeReservado = hospedajeReservado;
		this.cantidadDePersonas = cantidadDePersonas;
		this.precioTotal = precioTotal;
	
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

	@Override
	public double calcularPrecioTotal(int numeroPersonas, int numeroNoches) {
		double precioPorPersona = hospedajeReservado.sumaPorHabitacion();
		double precio = 0;
		if (numeroPersonas > 2) {
			precio = precioPorPersona * numeroPersonas * numeroNoches;
			precioTotal =precio + (precio* IMPUESTO);
		} else if (numeroPersonas >= 1 && numeroPersonas <= 2) {
			precio = precioPorPersona * numeroNoches;
			precioTotal = precio + (precio* IMPUESTO);
		}

		return precioTotal;

	}

	@Override
	public String realizarPago(boolean aceptar) {
		String pagoRealizado = "";
		if (aceptar) {
			pagoRealizado = " Pago realizado por un total de : " + calcularPrecioTotal(cantidadDePersonas, numeroNoches);
		} else {
			cancelarPago();
		}
		return pagoRealizado;
	}

	@Override
	public String cancelarPago() {
		return " Pago Canselado";
	}

	@Override
	public String toString() {
		return "Reserva [cliente=" + cliente + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida
				+ ", hospedajeReservado=" + hospedajeReservado + ", cantidadDePersonas=" + cantidadDePersonas
				+ ", precioTotal=" + precioTotal  + ", numeroNoches="
				+ numeroNoches + "]";
	}



	
	/*
	 * public double CalcularPrecio(String tipoDeHabitacion) {
	 * 
	 * if (hospedajeReservado instanceof Motel) {
	 * Motel motel = (Motel) hospedajeReservado;
	 * double precioMotel = motel.calcularPrecioPorNoche( tipoDeHabitacion) *
	 * getCantidadDePersonas();
	 * return precioMotel;
	 * } else if (hospedajeReservado instanceof Hotel) {
	 * Hotel hotel = (Hotel) hospedajeReservado;
	 * double precioHotel = hotel.calcularPrecioPorNoche( tipoDeHabitacion) *
	 * getCantidadDePersonas();
	 * return precioHotel;
	 * } else if (hospedajeReservado instanceof Cabana) {
	 * Cabana cabana = (Cabana) hospedajeReservado;
	 * double PrecioCabana = cabana.calcularPrecioPorNoche( tipoDeHabitacion) *
	 * getCantidadDePersonas();
	 * return PrecioCabana;
	 * } else if (hospedajeReservado instanceof Resort) {
	 * Resort resort = (Resort) hospedajeReservado;
	 * double precioResort = resort.calcularPrecioPorNoche(tipoDeHabitacion) *
	 * getCantidadDePersonas();
	 * return precioResort;
	 * } else if (hospedajeReservado instanceof Camping) {
	 * Camping camping = (Camping) hospedajeReservado;
	 * double precioCamping = camping.calcularPrecioPorNoche( tipoDeHabitacion) *
	 * getCantidadDePersonas();
	 * return precioCamping;
	 * } else if (hospedajeReservado instanceof Glamping) {
	 * Glamping glamping = (Glamping) hospedajeReservado;
	 * double precioGlamping = glamping.calcularPrecioPorNoche( tipoDeHabitacion) *
	 * getCantidadDePersonas();
	 * return precioGlamping;
	 * }
	 * return 0.0;
	 * 
	 * }
	 */
}
