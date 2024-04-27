package co.edu.konradlorenz.model;

import java.util.Date;

public class TarjetaDebito extends MetodoPago {
    private long saldoAhorros;
    private long saldoCorriente;

    public TarjetaDebito() {
        super();
    }

    public TarjetaDebito(String tipoDetarjeta, String banco, byte codigoSeguridad, String nombreTitular,
            long numeroDetarjeta, Date fechaExpiracion, long saldoAhorros, long saldoCorriente) {
        super(tipoDetarjeta, banco, codigoSeguridad, nombreTitular, numeroDetarjeta, fechaExpiracion);

        this.saldoCorriente = saldoCorriente;
    }

    public TarjetaDebito(String tipoDetarjeta, String banco, byte codigoSeguridad, String nombreTitular,
            long numeroDetarjeta, Date fechaExpiracion, long saldoAhorros) {
        super(tipoDetarjeta, banco, codigoSeguridad, nombreTitular, numeroDetarjeta, fechaExpiracion);
        this.saldoAhorros = saldoAhorros;

    }

    public TarjetaDebito(String tipoDetarjeta, String banco, byte codigoSeguridad, String nombreTitular,
            long numeroDetarjeta, Date fechaExpiracion) {
        super(tipoDetarjeta, banco, codigoSeguridad, nombreTitular, numeroDetarjeta, fechaExpiracion);

    }

    public long getSaldoAhorros() {
        return saldoAhorros;
    }

    public void setSaldoAhorros(long saldoAhorros) {
        this.saldoAhorros = saldoAhorros;
    }

    public long getSaldoCorriente() {
        return saldoCorriente;
    }

    public void setSaldoCorriente(long saldoCorriente) {
        this.saldoCorriente = saldoCorriente;
    }

    @Override
    public String toString() {
        return "TarjetaDebito [saldoAhorros=" + saldoAhorros + ", saldoCorriente=" + saldoCorriente + "]";
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
