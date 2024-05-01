package co.edu.konradlorenz.model;

import java.util.Date;

class CuentaAhorros extends Debito {
    private long saldoMinimoRequerido;

    public CuentaAhorros() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CuentaAhorros(String tipoDetarjeta, String banco, byte codigoSeguridad, String nombreTitular,
            long numeroDetarjeta, Date fechaExpiracion, long saldo) {
        super(tipoDetarjeta, banco, codigoSeguridad, nombreTitular, numeroDetarjeta, fechaExpiracion, saldo);
        // TODO Auto-generated constructor stub
    }

    public CuentaAhorros(String tipoDetarjeta, String banco, byte codigoSeguridad, String nombreTitular,
            long numeroDetarjeta, Date fechaExpiracion) {
        super(tipoDetarjeta, banco, codigoSeguridad, nombreTitular, numeroDetarjeta, fechaExpiracion);
        // TODO Auto-generated constructor stub
    }

    public CuentaAhorros(String tipoDetarjeta, String banco, byte codigoSeguridad, String nombreTitular,
            long numeroDetarjeta, Date fechaExpiracion, long saldo, long saldoMinimoRequerido) {
        super(tipoDetarjeta, banco, codigoSeguridad, nombreTitular, numeroDetarjeta, fechaExpiracion, saldo);
        this.saldoMinimoRequerido = saldoMinimoRequerido;
    }

    public long getSaldoMinimoRequerido() {
        return saldoMinimoRequerido;
    }

    public CuentaAhorros(long saldoMinimoRequerido) {
        super();
        this.saldoMinimoRequerido = saldoMinimoRequerido;
    }

    @Override
    public String toString() {
        return "CuentaAhorros [saldoMinimoRequerido=" + saldoMinimoRequerido + "]";
    }

}