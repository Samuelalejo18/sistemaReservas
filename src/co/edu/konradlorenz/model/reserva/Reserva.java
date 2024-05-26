package co.edu.konradlorenz.model.reserva;



import java.util.Date;

import co.edu.konradlorenz.model.cliente.Cliente;
import co.edu.konradlorenz.model.habitaciones.Habitacion;
import co.edu.konradlorenz.model.hospedajes.Hospedaje;

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
	public double subtotal() {
		double precioPorPersona = hospedajeReservado.getPrecioPorPersona()
				+ habitacionReservada.getPrecioAdicionalPorTipoHabitacion();
		return precioPorPersona;
	}

	@Override
	public double calcularPrecioTotal(int numeroPersonas, int numeroNoches) {
		double subTotal = subtotal();
		double precio = 0;
		if (numeroPersonas > 2) {
			precio = subTotal * numeroPersonas * numeroNoches;
			precioTotal = precio + (precio * IMPUESTO);
		} else if (numeroPersonas >= 1 && numeroPersonas <= 2) {
			precio = subTotal * numeroNoches;
			precioTotal = precio + (precio * IMPUESTO);
		}

		return precioTotal;

	}

	@Override
	public String realizarPago(String respuestaUsuario, double precioTotal) {
		String pagoRealizado = "";
		boolean aceptar = respuestaUsuario.equals("si") || respuestaUsuario.equals("s");

		if (aceptar) {
			pagoRealizado = " Pago realizado por un total de : "
					+ precioTotal;
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
