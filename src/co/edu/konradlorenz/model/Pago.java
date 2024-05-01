package co.edu.konradlorenz.model;

public interface Pago {
    // Impuesto por reservar dentro de la aplicacion
    public static final double IMPUESTO = 0.05;

    public double subtotal();

    double calcularPrecioTotal(int numeroPersonas, int numeroNoches);

    public String realizarPago(String respuestaUsuario, double precioTotal);

    public String cancelarPago();

}
