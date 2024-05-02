package co.edu.konradlorenz.model;

import java.util.Date;

/**
 * CuentaCorriente
 */
public class CuentaCorriente extends Debito {

    private double comisionSobregiro;

    public CuentaCorriente() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CuentaCorriente(String tipoDetarjeta, String banco,short codigoSeguridad, String nombreTitular,
            long numeroDetarjeta, Date fechaExpiracion, long saldo) {
        super(tipoDetarjeta, banco, codigoSeguridad, nombreTitular, numeroDetarjeta, fechaExpiracion, saldo);
        // TODO Auto-generated constructor stub
    }

    public CuentaCorriente(String tipoDetarjeta, String banco,short codigoSeguridad, String nombreTitular,
            long numeroDetarjeta, Date fechaExpiracion) {
        super(tipoDetarjeta, banco, codigoSeguridad, nombreTitular, numeroDetarjeta, fechaExpiracion);
        // TODO Auto-generated constructor stub
    }

    public CuentaCorriente(String tipoDetarjeta, String banco,short codigoSeguridad, String nombreTitular,
            long numeroDetarjeta, Date fechaExpiracion, long saldo, double comisionSobregiro) {
        super(tipoDetarjeta, banco, codigoSeguridad, nombreTitular, numeroDetarjeta, fechaExpiracion, saldo);
        this.comisionSobregiro = comisionSobregiro;
    }

    public double getComisionSobregiro() {
        return comisionSobregiro;
    }

    public void setComisionSobregiro(double comisionSobregiro) {
        this.comisionSobregiro = comisionSobregiro;
    }

    @Override
    public String toString() {
        return "CuentaCorriente [comisionSobregiro=" + comisionSobregiro + "]";
    }

}