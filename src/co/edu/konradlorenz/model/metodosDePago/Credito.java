package co.edu.konradlorenz.model.metodosDePago;

import java.util.Date;

import co.edu.konradlorenz.model.excepciones.SaldoInsuficienteException;

public class Credito extends Tarjeta {

    private long saldoCredito;
    private int cuota;
    private double interes;

    public Credito() {
        super();
    }
    
    public Credito(String tipoDetarjeta, String banco, short codigoSeguridad, String nombreTitular,
            long numeroDetarjeta, Date fechaExpiracion, long saldoCredito, double intereses) {
        super(tipoDetarjeta, banco, codigoSeguridad, nombreTitular, numeroDetarjeta, fechaExpiracion);
        this.saldoCredito = saldoCredito;
        this.cuota = cuota;
        this.interes = intereses;
    }

    public Credito(String tipoDetarjeta, String banco, short codigoSeguridad, String nombreTitular,
            long numeroDetarjeta, Date fechaExpiracion) {
        super(tipoDetarjeta, banco, codigoSeguridad, nombreTitular, numeroDetarjeta, fechaExpiracion);

    }

    public long getSaldoCredito() {
        return saldoCredito;
    }

    public void setSaldoCredito(long saldoCredito) {
        this.saldoCredito = saldoCredito;
    }

    public int getCuotas() {
        return cuota;
    }

    public void setCuotas(int cuotas) {
        this.cuota = cuotas;
    }

    public double getIntereses() {
        return interes;
    }

    public void setIntereses(double intereses) {
        this.interes = intereses;
    }

    
    public double calcularCredito(double precioTotal, int cuota) {
        double cuotas = precioTotal / cuota;

        // multiplicar cada cuota resultante por interes y sumarlo a la cuota inicial, y
        // multiplicar al numero de cuptas
        double intereces = ((cuotas * this.interes) + cuotas) * cuota;

        double precioTotalConIntereses = intereces + precioTotal;

        return precioTotalConIntereses;

    }

    @Override
    public String Pagar(double precioTotal) throws SaldoInsuficienteException {
        String credito = "";
        if (saldoCredito > precioTotal) {
            credito = " credito aprobado por un total de :  " + calcularCredito(precioTotal, this.cuota);
        } else {
            credito = pagoRechazado();
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        return credito;
    }

    @Override
    public String pagoRechazado() {
        return " pago cancelado, saldo insuficiente";

    }
    @Override
    public String toString() {
        return "Credito [saldoCredito=" + saldoCredito + ", cuota=" + cuota + ", interes=" + interes
                + "]";
    }
}