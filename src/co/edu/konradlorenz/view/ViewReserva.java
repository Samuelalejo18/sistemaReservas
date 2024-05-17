package co.edu.konradlorenz.view;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ViewReserva {
    static Scanner sc = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public void mostrarGraciasReserva() {
        System.out.println("Gracias por hacer la reserva con nostros");
    }

    public String pedirNombreHospedajeAreservar() {
        System.out.println("Ingrese el nombre del hospedaje a reservar :");
        String nombreHospedaje = "";
        boolean nombreHospedajeValido = false;

        while (!nombreHospedajeValido) {
            try {
                nombreHospedaje = sc.next();

                if (nombreHospedaje.matches("[a-zA-Z ]+")) {
                    nombreHospedajeValido = true;
                } else {
                    System.out.println("Ingrese un nombre del Hospedaje válido (solo letras).");
                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error. Inténtelo de nuevo.");
                sc.nextLine();
            }
        }

        return nombreHospedaje;
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
        int numeroReserva = 0;
        boolean opcionValida = false;
        while (!opcionValida) {
            try {

                System.out.println("Ingrese el numero de la habitacion que desea reservar :  ");
                numeroReserva = sc.nextInt();
                opcionValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese dato valido");
                sc.nextLine();
            }
        }

        return numeroReserva;

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
        int numeroNoches = 0;
        boolean numeroNochesValido = false;

        while (!numeroNochesValido) {
            try {
                numeroNoches = sc.nextInt();
                if (numeroNoches > 0) {
                    numeroNochesValido = true;
                } else {
                    System.out.println("Ingrese un número de noches válido (mayor que 0).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un dato valido");
                sc.next();
            }
        }
        return numeroNoches;
    }

    public static int ingresarNumeroPersonas() {
        System.out.print("Ingrese el número de personas: ");
        int numeroPersonas = 0;
        boolean numeroPersonasValido = false;

        while (!numeroPersonasValido) {
            try {
                numeroPersonas = sc.nextInt();
                if (numeroPersonas > 0) {
                    numeroPersonasValido = true;
                } else {
                    System.out.println("Ingrese un número de personas válido (mayor que 0).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un dato valido");
                sc.next();
            }
        }
        return numeroPersonas;
    }

    public static String realizarpago() {
        System.out.println("¿Desea realizar el pago? (si/no)");
        String respuestaPago = "";
        boolean respuestaValida = false;

        while (!respuestaValida) {
            try {
                respuestaPago = sc.next().toLowerCase();
                if (respuestaPago.equals("si") || respuestaPago.equals("no")) {
                    respuestaValida = true;
                } else {
                    System.out.println("Ingrese una respuesta válida (si/no).");
                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error. Inténtelo de nuevo.");
                sc.nextLine();
            }
        }
        return respuestaPago;
    }

    public void imprimirTablaReserva(String nombre, String apellido, int id, String email, long numeroTelefono,
            Date fechaEntrada, Date fechaSalida, String tipoHospedaje, String nombreHospedaje, String ciudad,
            String pais,
            String tipoHabitacion,
            int numeroHabitacion,
            int cantidadPersonas,
            int numeroNoches,
            double precioPorPersona, double precioAdicionalPorTipoHabitacion, double subtotal, double precioTotal) {

        System.out.println("|-----------------------------------------------------------------------|");
        System.out.format("%-40s  %-29s %-1s  %n", "| Nombre:           ", nombre, "|");
        System.out.format("%-40s  %-29s %-1s %n", "| Apellido:           ", apellido, "|");
        System.out.format("%-40s  %-29d %-1s %n", "| Cedula:           ", id, "|");
        System.out.format("%-40s  %-29s %-1s %n", "| email:           ", email, "|");
        System.out.format("%-40s  %-29d %-1s %n", "| numero telefono:           ", numeroTelefono, "|");
        System.out.format("%-40s  %-29s %-1s %n", "| nombre hospedaje:           ", nombreHospedaje, "|");
        System.out.format("%-40s  %-29s %-1s %n", "| Tipo hospedaje:           ", tipoHospedaje, "|");
        System.out.format("%-40s  %-29s %-1s %n", "| ciudad:           ", ciudad, "|");
        System.out.format("%-40s  %-29s %-1s %n", "| Pais:           ", pais, "|");
        System.out.format("%-40s  %-29d %-1s %n", "| Fecha entrada:           ", fechaEntrada, "|");
        System.out.format("%-40s  %-29d %-1s %n", "| Fecha salida:           ", fechaSalida, "|");
        System.out.format("%-40s  %-29s %-1s %n", "| Tipo de habitacion :           ", tipoHabitacion, "|");
        System.out.format("%-40s  %-29s %-1s %n", "| Numero de habitacion:           ", numeroHabitacion, "|");
        System.out.format("%-40s  %-29d %-1s %n", "| Cantidad de Personas:           ", cantidadPersonas, "|");
        System.out.format("%-40s  %-29d %-1s %n", "| Numero de Noches:           ", numeroNoches, "|");
        System.out.format("%-40s  %-29f %-1s %n", "| Precio por persona:           ", precioPorPersona, "|");
        System.out.format("%-20s  %-19f %-1s %n", "| Precio adicional por tipo habitacion:           ",
                precioAdicionalPorTipoHabitacion, "|");
        System.out.format("%-40s  %-29f %-1s %n", "| Subtotal:           ", subtotal, "|");
        System.out.println("|-----------------------------------------------------------------------|");
        System.out.format("%-40s  %-29f %-1s%n", "| Precio Total:           ", precioTotal, "|");
        System.out.println("|-----------------------------------------------------------------------|");
    }

    public void mostrarPrecio(double precioTotal) {
        System.out.printf("Precio total de : %.2f%n", precioTotal);

    }

    public void mostrarPago(String pagoRealizado) {
        System.out.println(pagoRealizado);
    }

    public int pedirOpcion() {
        int opcion = 0;
        boolean opcionValida = false;
        while (!opcionValida) {
            try {
                System.out.println("Ingrese una opcion : ");
                opcion = sc.nextInt();
                opcionValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese dato valido");
                sc.nextLine();
            }
        }
        return opcion;
    }

    public String pedirTipoTarjeta() {
        System.out.println("Ingrese el tipo de tarjeta: ");
        String tipoTarjeta = "";
        boolean tipoTarjetaValida = false;
        while (!tipoTarjetaValida) {
            try {
                tipoTarjeta = sc.next();
                if (tipoTarjeta.matches("[a-zA-Z ]+")) {
                    tipoTarjetaValida = true;
                } else {
                    System.out.println("Ingrese un tipo de tarjeta válido (solo letras).");
                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error. Inténtelo de nuevo.");
                sc.nextLine();
            }
        }
        return tipoTarjeta;
    }

    public String pedirBanco() {
        System.out.println("Ingrese el banco: ");
        String banco = "";
        boolean bancoValido = false;
        while (!bancoValido) {
            try {
                banco = sc.next();
                if (banco.matches("[a-zA-Z ]+")) {
                    bancoValido = true;
                } else {
                    System.out.println("Ingrese un nombre de banco válido (solo letras).");
                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error. Inténtelo de nuevo.");
                sc.nextLine();
            }
        }
        return banco;
    }

    public String pedirNombreTitular() {
        System.out.println("Ingrese nombre del titular: ");
        String nombre = "";
        boolean nombreValido = false;
        while (!nombreValido) {
            try {
                nombre = sc.next();
                if (nombre.matches("[a-zA-Z ]+")) {
                    nombreValido = true;
                } else {
                    System.out.println("Ingrese un nombre válido (solo letras).");
                }
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error. Inténtelo de nuevo.");
                sc.nextLine();
            }
        }
        return nombre;
    }

    public short pedirCodigoDeseguridad() {
        short cs = 0;
        boolean codigoValido = false;
        while (!codigoValido) {
            try {
                System.out.println("Ingrese el código de seguridad: ");
                cs = sc.nextShort();
                codigoValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un código de seguridad válido.");
                sc.nextLine();
            }
        }
        return cs;
    }

    public long pedirNumeroDetarjeta() {
        long numero = 0;
        boolean numeroValido = false;
        while (!numeroValido) {
            try {
                System.out.println("Ingrese el número de la tarjeta: ");
                numero = sc.nextLong();
                numeroValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un número de tarjeta válido.");
                sc.nextLine();
            }
        }
        return numero;
    }

    public long pedirSaldo() {
        long saldo = 0;
        boolean saldoValido = false;
        while (!saldoValido) {
            try {
                System.out.println("Ingrese el saldo: ");
                saldo = sc.nextLong();
                saldoValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un saldo válido.");
                sc.nextLine();
            }
        }
        return saldo;
    }

    public double pedirItereses() {
        double intereses = 0.0;
        boolean interesesValidos = false;
        while (!interesesValidos) {
            try {
                System.out.println("Ingrese los intereses de la tarjeta: ");
                intereses = sc.nextDouble();
                interesesValidos = true;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un valor válido para los intereses.");
                sc.nextLine();
            }
        }
        return intereses;
    }

    public int pedirNumeroDeCuotas() {
        int cuotas = 0;
        boolean cuotasValidas = false;
        while (!cuotasValidas) {
            try {
                System.out.println("Ingrese el número de cuotas: ");
                cuotas = sc.nextInt();
                cuotasValidas = true;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un número de cuotas válido.");
                sc.nextLine();
            }
        }
        return cuotas;
    }

    public void mostrarCompraTarjeta(String valorCompra) {
        System.out.println(valorCompra);
    }
}