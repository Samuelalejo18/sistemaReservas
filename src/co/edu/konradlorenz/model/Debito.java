package co.edu.konradlorenz.model;

import java.util.Date;

public class Debito extends MetodoPago {

    private long saldoAhorros;
    private long saldoCorriente;


    public Debito() {
    super();
    }


    public Debito(String tipoDetarjeta, byte codigoSeguridad, String nombreTitular, long numeroDetarjeta,
            Date fechaExpiracion, long saldoAhorros, long saldoCorriente) {
        super(tipoDetarjeta, codigoSeguridad, nombreTitular, numeroDetarjeta, fechaExpiracion);
        this.saldoAhorros = saldoAhorros;
        this.saldoCorriente = saldoCorriente;
    }


    public Debito(String tipoDetarjeta, byte codigoSeguridad, String nombreTitular, long numeroDetarjeta,
    Date fechaExpiracion) {
        super(tipoDetarjeta, codigoSeguridad, nombreTitular, numeroDetarjeta, fechaExpiracion);
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




    


}
