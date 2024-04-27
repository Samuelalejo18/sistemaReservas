package co.edu.konradlorenz.model;

import java.util.Date;

public class TarjetaCredito extends MetodoPago {

    private long saldoCredito;
    private int cuotas;
    private double intereses;

    public TarjetaCredito() {
        super();
    }

    public TarjetaCredito(String tipoDetarjeta, String banco, byte codigoSeguridad, String nombreTitular,
            long numeroDetarjeta, Date fechaExpiracion, long saldoCredito, double intereses) {
        super(tipoDetarjeta, banco, codigoSeguridad, nombreTitular, numeroDetarjeta, fechaExpiracion);
        this.saldoCredito = saldoCredito;

        this.intereses = intereses;
    }

    public TarjetaCredito(String tipoDetarjeta, String banco, byte codigoSeguridad, String nombreTitular,
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
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public double getIntereses() {
        return intereses;
    }

    public void setIntereses(double intereses) {
        this.intereses = intereses;
    }

    @Override
    public String toString() {
        return "TarjetaCredito [saldoCredito=" + saldoCredito + ", cuotas=" + cuotas + ", intereses=" + intereses
                + "]";
    }

    @Override
    public void Pagar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Pagar'");
    }

    @Override
    public void pagoRechazado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pagoRechazado'");
    }

}
