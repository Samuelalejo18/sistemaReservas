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

	public void CalcularPrecio( ){
		
		if(hospedajeReservado instanceof Motel){
			Motel motel = (Motel) hospedajeReservado;
			double precioMotel = motel.calcularPrecioPorNoche("") * getCantidadDePersonas();
		}	else if (hospedajeReservado instanceof Hotel) {
			Hotel hotel = (Hotel) hospedajeReservado;
			double precioHotel = hotel.calcularPrecioPorNoche("") * getCantidadDePersonas();
		}	else if (hospedajeReservado instanceof Cabana){
			Cabana cabana = (Cabana) hospedajeReservado;
			double PrecioCabana = cabana.calcularPrecioPorNoche("") * getCantidadDePersonas();
		}	else if (hospedajeReservado instanceof Resort){
			Resort resort = (Resort) hospedajeReservado;
			double precioResort =  resort.calcularPrecioPorNoche("") * getCantidadDePersonas();
		}	else if (hospedajeReservado instanceof Camping){
			Camping camping = (Camping) hospedajeReservado;
			double precioCamping = camping.calcularPrecioPorNoche("") * getCantidadDePersonas();
		}	else if (hospedajeReservado instanceof Glamping){
			Glamping glamping = (Glamping) hospedajeReservado;
			double precioGlamping = glamping.calcularPrecioPorNoche("") * getCantidadDePersonas();
		}

		
		
		
		
	}

}
