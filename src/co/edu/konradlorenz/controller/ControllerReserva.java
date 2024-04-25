package co.edu.konradlorenz.controller;

import co.edu.konradlorenz.model.Hospedaje;
import co.edu.konradlorenz.model.Reserva;
import co.edu.konradlorenz.view.ViewHospedaje;
import co.edu.konradlorenz.view.ViewReserva;

public class ControllerReserva {
    Reserva reserva = new Reserva();
    ViewReserva viewReserva = new ViewReserva();
    ViewHospedaje viewHospedaje = new ViewHospedaje();

    public void casosReserva() {

        String nombreHospedaje = viewReserva.pedirNombreHospedajeAreservar();
        // Llama al método para reservar el hospedaje con el nombre proporcionado
        Hospedaje hospedajeReservado = reserva.reservarHospedaje(nombreHospedaje);

        System.out.println(hospedajeReservado);

        /*
         * viewHospedaje.mostrarTitulo();
         * ViewHospedaje.imprimirTabla("", hospedajeReservado.getNombre(),
         * hospedajeReservado.getUbicacionCiudad(),
         * hospedajeReservado.getUbicacionPais(),
         * hospedajeReservado.getNumeroEstrellas(),
         * hospedajeReservado.getDescripcion(), hospedajeReservado.getTipo());
         */

        // ArrayList<Habitacion> habitacionesAReservar =
        // hospedajeReservado.getHabitaciones();

        // for (Habitacion habitacion : habitacionesAReservar) {

        // }

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