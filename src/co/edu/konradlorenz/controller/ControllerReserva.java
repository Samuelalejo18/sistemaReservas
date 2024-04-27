package co.edu.konradlorenz.controller;

import java.util.ArrayList;

import co.edu.konradlorenz.model.Cabana;
import co.edu.konradlorenz.model.Camping;
import co.edu.konradlorenz.model.Glamping;
import co.edu.konradlorenz.model.Habitacion;
import co.edu.konradlorenz.model.HabitacionBase;
import co.edu.konradlorenz.model.HabitacionDoble;
import co.edu.konradlorenz.model.HabitacionPresidencial;
import co.edu.konradlorenz.model.HabitacionSuite;
import co.edu.konradlorenz.model.Hospedaje;
import co.edu.konradlorenz.model.Hotel;
import co.edu.konradlorenz.model.Motel;
import co.edu.konradlorenz.model.Reserva;
import co.edu.konradlorenz.model.Resort;
import co.edu.konradlorenz.view.ViewReserva;

public class ControllerReserva {
    Reserva reserva = new Reserva();
    ViewReserva viewReserva = new ViewReserva();

    ArrayList<Hospedaje> hospedajes = ControllerHospedajes.getHospedajes();

    public Hospedaje reservarHospedaje(String nombre) {
        Hospedaje hospedajeAReservar = null;

        for (Hospedaje hospedaje : hospedajes) {
            if (hospedaje.getNombre().equalsIgnoreCase(nombre)) {

                hospedajeAReservar = hospedaje;
                String tipoHospedaje = hallarTipoHospedaje(hospedaje);
                viewReserva.mostrarTitulo();
                viewReserva.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
                        hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
                        hospedaje.getTipo());

            }
        }

        return hospedajeAReservar;
    }

    public String hallarTipoHabitacion(Habitacion habitacion) {
        String tipoHabitacion = "no existe";
        if (habitacion instanceof HabitacionBase) {
            tipoHabitacion = "Habitacion Base";
        } else if (habitacion instanceof HabitacionDoble) {
            tipoHabitacion = "Habitacion Doble";
        } else if (habitacion instanceof HabitacionPresidencial) {
            tipoHabitacion = "Habitacion Presidencial";
        } else if (habitacion instanceof HabitacionSuite) {
            tipoHabitacion = "Habitacion Suite";
        }
        return tipoHabitacion;
    }

    public String hallarTipoHospedaje(Hospedaje hospedaje) {
        String tipoHospedaje = "no existe";
        if (hospedaje instanceof Hotel) {
            tipoHospedaje = "Hotel";
        } else if (hospedaje instanceof Cabana) {
            tipoHospedaje = "Cabaña";
        } else if (hospedaje instanceof Camping) {
            tipoHospedaje = "Camping";
        } else if (hospedaje instanceof Glamping) {
            tipoHospedaje = "Glamping";
        } else if (hospedaje instanceof Motel) {
            tipoHospedaje = "Motel";
        } else if (hospedaje instanceof Resort) {
            tipoHospedaje = "Resort";
        }
        return tipoHospedaje;
    }


   

}