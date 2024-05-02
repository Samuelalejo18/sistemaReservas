package co.edu.konradlorenz.controller;

import java.util.ArrayList;

import co.edu.konradlorenz.model.Cabana;
import co.edu.konradlorenz.model.Camping;
import co.edu.konradlorenz.model.Cliente;
import co.edu.konradlorenz.model.Credito;
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
import co.edu.konradlorenz.model.Tarjeta;
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

    public void habitacionesDisponibles(ArrayList<Habitacion> habitaciones) {
        viewReserva.mostrarHabitacionesDisponibles();
        viewReserva.mostrarTituloHabitacion();
        for (Habitacion habitacion : habitaciones) {
            String tipoHabitacion = hallarTipoHabitacion(habitacion);
            viewReserva.imprimirTablaHabitacion(tipoHabitacion, habitacion.getCapacidad(),
                    habitacion.isDisponible(), habitacion.getNumeroHabitacion(),
                    habitacion.getPrecioAdicionalPorTipoHabitacion());
        }

    }

    public void metodosDepago(Cliente clienteAutenticado, ArrayList<Tarjeta> tarjetas, double precioTotal) {
        System.out.println("Metodos de pago");

        int opcion = -1;
        while (opcion != 0) {
            System.out.println(" 1.Tarjeta de credito");
            System.out.println("2.Tarjeta Debito");
            opcion = viewReserva.pedirOpcion();
            switch (opcion) {
                case 1:
                    opcionesCredito(clienteAutenticado, tarjetas, precioTotal);
                    opcion = 0;
                    break;
                case 2:
                    break;
                default:
                    break;
            }

        }
    }

    public void opcionesCredito(Cliente clienteAutenticado, ArrayList<Tarjeta> tarjetas, double precioTotal) {
        System.out.println("Metodos de pago");

        int opcion = -1;
        while (opcion != 0) {
            System.out.println(" 1.Aregar Tareta");
            System.out.println("2.Tarjetas ya registradas");
            opcion = viewReserva.pedirOpcion();
            switch (opcion) {
                case 1:
                    Credito tarjetaCredito = new Credito(viewReserva.pedirTipoTarjeta(), viewReserva.pedirBanco(),
                            viewReserva.pedirCodigoDeseguridad(), viewReserva.pedirNombreTitular(),
                            viewReserva.pedirNumeroDetarjeta(), null, viewReserva.pedirSaldo(),
                            viewReserva.pedirItereses());
                    clienteAutenticado.agregarTarjeta(tarjetaCredito);
                    int numeroCuotas = viewReserva.pedirNumeroDeCuotas();
                    tarjetaCredito.calcularCredito(precioTotal, numeroCuotas);
                    tarjetaCredito.setCuotas(numeroCuotas);
                    viewReserva.mostrarCompraTarjeta(tarjetaCredito.Pagar(precioTotal));
                    opcion = 0;
                    break;
                case 2:
                    if (tarjetas.isEmpty()) {

                        System.out.println("No hay ninguna tarjeta registrada");
                    }
                    break;
                default:
                    break;
            }

        }

    }

}