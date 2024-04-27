package co.edu.konradlorenz.view;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ViewReserva {
    static Scanner sc = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public void mostrarGraciasReserva() {
        System.out.println("Gracias por hacer la reserva con nostros");
    }

    public String pedirNombreHospedajeAreservar() {
        System.out.println("Ingrese el hospedaje a reservar: ");
        sc.nextLine();
        String nombre = sc.nextLine();
        return nombre;
    }

    public void hospedajeNoEncontrado() {
        System.out.println("El hospedaje no se encontro");

    }

    public void mostrarTitulo() {

        System.out.format("%-20s %-20s %-20s %-20s %-20s %-40s %-20s %n",
                "Tipo hospedaje", "nombre", "ubicacion Ciudad", "ubicacion Pais",
                "numero Estrellas", "descripcion", "tipo");

    }

    public void imprimirTabla(String tH, String nombre, String ubicacionCiudad, String ubicacionPais,
            int numeroEstrellas,
            String descripcion, String tipo) {

        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%-20s %-20s %-20s %-20s %-10d %30s %20s %n", tH, nombre, ubicacionCiudad, ubicacionPais,
                numeroEstrellas,
                descripcion, tipo);

        System.out.println("\n");
    }

    public void mostrarHabitacionesDisponibles() {
        System.out.println("Habitaciones disponibles: ");
    }

    public void mostrarTituloHabitacion() {

        System.out.format("%-20s %-20s %-20s %-20s %-30s %n",
                "Tipo Habitacion", " capacidad", "disponibilidad", "numero Habitacion",
                " precio adicional por tipo habitacion");

    }

    public void imprimirTablaHabitacion(String tH, int capacidad, boolean disponibilidad, int numeroHabitacion,
            double precioAdicionalPorTipoHabitacion) {
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%-20s %-20d %-20s %-20d %-30f  %n", tH, capacidad, disponibilidad, numeroHabitacion,
                precioAdicionalPorTipoHabitacion);
        System.out.println("\n");
    }

    public int pedirNumeroHabitacionReservar() {
        System.out.println("Ingrese el numero de la habitacion que desea reservar :  ");
        int numeroReserva = sc.nextInt();
        return numeroReserva;
    }

    public void mostrarHabitacionNoDisponible() {
        System.out.println("Habitacion no disponible");
    }

    public void mostrarHabitacionNoEncontrada() {
        System.out.println("La habitacion no existe");
    }

    public static Date ingresarFechaEntrada() {

        System.out.print("Ingrese la fecha de entrada (dd/MM/yyyy): ");
        String fechaStr = sc.nextLine();
        try {
            return (Date) dateFormat.parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Por favor, ingrese la fecha en el formato dd/MM/yyyy.");
            return ingresarFechaEntrada();
        }
    }

    public Date ingresarFechaSalida() {

        System.out.print("Ingrese la fecha de salida (dd/MM/yyyy): ");
        String fechaStr = sc.nextLine();
        try {
            return (Date) dateFormat.parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Por favor, ingrese la fecha en el formato dd/MM/yyyy.");
            return ingresarFechaSalida();
        }
    }

    public static int ingresarNumeroNoches() {

        System.out.print("Ingrese el número de noches: ");
        int numeroNoches = sc.nextInt();
        return numeroNoches;
    }

    public static int ingresarNumeroPersonas() {

        System.out.print("Ingrese el número de personas: ");
        int numeroPersonas = sc.nextInt();
        return numeroPersonas;

    }

    public static String realizarpago() {
        System.out.println("¿Desea realizar el pago? (si/no)");
        String respuestaUsuario = sc.next();
        return respuestaUsuario;
    }

    public void imprimirTablaReserva(String nombre, String apellido, int id, String email, long numeroTelefono,
            Date fechaEntrada, Date fechaSalida, String tipoHospedaje, String nombreHotel, String ciudad, String pais,
            String tipoHabitacion,
            int numeroHabitacion,
            int cantidadPersonas,
            int numeroNoches,
            double precioPorPersona, double precioAdicionalPorTipoHabitacion, double precioTotal) {

        System.out.println("|-----------------------------------------------------------------------|");
        System.out.format("%-40s  %-29s %-1s  %n", "| Nombre:           ", nombre, "|");
        System.out.format("%-40s  %-29s %-1s %n", "| Apellido:           ", apellido, "|");
        System.out.format("%-40s  %-29d %-1s %n", "| Cedula:           ", id, "|");
        System.out.format("%-40s  %-29s %-1s %n", "| email:           ", email, "|");
        System.out.format("%-40s  %-29d %-1s %n", "| numero telefono:           ", numeroTelefono, "|");
        System.out.format("%-40s  %-29d %-1s %n", "| Fecha entrada:           ", fechaEntrada, "|");
        System.out.format("%-40s  %-29d %-1s %n", "| Fecha salida:           ", fechaSalida, "|");
        System.out.format("%-40s  %-29s %-1s %n", "| Tipo hospedaje:           ", tipoHospedaje, "|");
        System.out.format("%-40s  %-29s %-1s %n", "| nombre hospedaje:           ", nombreHotel, "|");
        System.out.format("%-40s  %-29s %-1s %n", "| pais:           ", pais, "|");
        System.out.format("%-40s  %-29s %-1s %n", "| ciudad:           ", ciudad, "|");
        System.out.format("%-40s  %-29s %-1s %n", "| Tipo de habitacion :           ", tipoHabitacion, "|");
        System.out.format("%-40s  %-29s %-1s %n", "| numero de habitacion:           ", numeroHabitacion, "|");
        System.out.format("%-40s  %-29d %-1s%n", "| cantidad de Personas:           ", cantidadPersonas, "|");
        System.out.format("%-40s  %-29d %-1s %n", "| numero de Noches:           ", numeroNoches, "|");
        System.out.format("%-40s  %-29f %-1s %n", "| precio por persona:           ", precioPorPersona, "|");
        System.out.format("%-20s  %-19f %-1s %n", "| precio adicional por tipo habitacion:           ",
                precioAdicionalPorTipoHabitacion, "|");
        System.out.println("|-----------------------------------------------------------------------|");
        System.out.format("%-40s  %-29f %-1s%n", "| precio Total:           ", precioTotal, "|");
        System.out.println("|-----------------------------------------------------------------------|");
    }

    public void mostrarPrecio(double precioTotal) {
        System.out.printf("Precio total de : %.2f%n", precioTotal);

    }

    public void mostrarPago(String pagoRealizado) {
        System.out.println(pagoRealizado);
    }
}