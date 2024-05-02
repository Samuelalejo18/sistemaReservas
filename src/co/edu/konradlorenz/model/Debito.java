package co.edu.konradlorenz.model;

import java.util.Date;

public class Debito extends Tarjeta {
    private long saldo;

    public Debito() {
        super();
    }

    public Debito(String tipoDetarjeta, String banco, short codigoSeguridad, String nombreTitular, long numeroDetarjeta,
            Date fechaExpiracion, long saldo) {
        super(tipoDetarjeta, banco, codigoSeguridad, nombreTitular, numeroDetarjeta, fechaExpiracion);
        this.saldo = saldo;
    }

    public Debito(String tipoDetarjeta, String banco, short codigoSeguridad, String nombreTitular, long numeroDetarjeta,
            Date fechaExpiracion) {
        super(tipoDetarjeta, banco, codigoSeguridad, nombreTitular, numeroDetarjeta, fechaExpiracion);
    }

    @Override
    public String Pagar(double precioTotal) {
        String compra = "";
        if (this.saldo > precioTotal) {
            compra = "Saldo y compra aprobada, por un total de :  " + precioTotal;
        } else {
            compra = pagoRechazado();
        }
        return compra;
    }

    @Override
    public String pagoRechazado() {
        return " pago cancelado, saldo insuficiente";

    }
}
