package co.edu.konradlorenz.controller;

import java.util.ArrayList;

import co.edu.konradlorenz.model.Habitacion;
import co.edu.konradlorenz.model.Hospedaje;
import co.edu.konradlorenz.model.Reserva;
import co.edu.konradlorenz.view.ViewHospedaje;
import co.edu.konradlorenz.view.ViewReserva;

public class ControllerReserva {
    Reserva reserva = new Reserva();
    ViewReserva viewReserva = new ViewReserva();
    ViewHospedaje viewHospedaje = new ViewHospedaje();

    public void casosReserva() {
        viewReserva.graciasReserva();
        Hospedaje hospedajeReservado = reserva.reservarHospedaje(viewReserva.pedirNombreHospedajeAreservar());
        if (hospedajeReservado == null) {
            viewReserva.hospedajeNoEncontrado();
        }

        viewHospedaje.mostrarTitulo();
        ViewHospedaje.imprimirTabla("", hospedajeReservado.getNombre(), hospedajeReservado.getUbicacionCiudad(),
                hospedajeReservado.getUbicacionPais(), hospedajeReservado.getNumeroEstrellas(),
                hospedajeReservado.getDescripcion(), hospedajeReservado.getTipo());

        ArrayList<Habitacion> habitacionesAReservar = hospedajeReservado.getHabitaciones();

        for (Habitacion habitacion : habitacionesAReservar) {

        }

        /*
         * if (hospedajeReservado == null) {
         * viewReserva.hospedajeNoEncontrado();
         * } else {
         * 
         * 
         * }
         */
    }
}