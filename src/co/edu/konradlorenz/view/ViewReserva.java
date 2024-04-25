package co.edu.konradlorenz.view;

import java.util.Scanner;

public class ViewReserva {
    Scanner sc = new Scanner(System.in);

    public void graciasReserva() {
        System.out.println("Gracias por hacer la reserva con nostros");
    }

    public String pedirNombreHospedajeAreservar() {
        System.out.println("Ingrese el hospedaje a reservar: ");
        String nombreHospedajeAreservar = sc.next();
        return nombreHospedajeAreservar;
    }

    public int pedirNumeroPersonas() {
        System.out.println("Ingrese el numero de Personas que se hospedan : ");
        int numeroPersonas = sc.nextInt();
        return numeroPersonas;
    }

    public int pedirNumeroDeNoches() {
        System.out.println("Ingrese el numero de nochas que sea quedarse : ");
        int numeroNoches = sc.nextInt();
        return numeroNoches;
    }

    public void hospedajeNoEncontrado() {
        System.out.println("El hospedaje no se encontro");

    }

    public void mostrarTitulo() {

        System.out.format("%-20s %-20s %-20s %-20s %-20s %-40s %-20s %n",
                "Tipo Habitacion", "nombre", "ubicacion Ciudad", "ubicacion Pais",
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

}
