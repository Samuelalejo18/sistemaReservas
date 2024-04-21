package co.edu.konradlorenz.model;

public interface Pago {
    // Impuesto por reservar dentro de la aplicacion
    public static final double IMPUESTO = 0.10;

    double calcularPrecioTotal(int numeroPersonas, int numeroNoches);

    public void realizarPago();

    public void cancelarPago();
}
