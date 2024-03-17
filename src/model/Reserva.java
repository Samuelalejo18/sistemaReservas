package model;

import java.sql.Date;

public class Reserva {
	private Cliente cliente;
	private Date fechaEntrada;
	private Date fechaSalida;
	private Hospedaje hospedajeReservado;
	private int cantidadDePersonas;
	private double precioTotal;

	public Reserva(Cliente cliente, Date fechaEntrada, Date fechaSalida, Hospedaje hospedajeReservado,
			int cantidadDePersonas, double precioTotal) {
		this.cliente = cliente;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.hospedajeReservado = hospedajeReservado;
		this.cantidadDePersonas = cantidadDePersonas;
		this.precioTotal = precioTotal;
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

	@Override
	public String toString() {
		return "Reserva [cliente=" + cliente + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida
				+ ", hospedajeReservado=" + hospedajeReservado + ", cantidadDePersonas=" + cantidadDePersonas
				+ ", precioTotal=" + precioTotal + "]";
	}

}
