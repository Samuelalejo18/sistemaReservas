package co.edu.konradlorenz.model;

import java.util.Date;



public abstract class Tarjeta {

    protected String tipoDetarjeta;// Mastercard, visa, american express, dinners
    protected String banco;
    protected byte codigoSeguridad;
    protected String nombreTitular;
    protected long numeroDetarjeta;
    protected Date fechaExpiracion;

    public Tarjeta() {

    }

    public Tarjeta(String tipoDetarjeta, String banco, byte codigoSeguridad, String nombreTitular,
            long numeroDetarjeta, Date fechaExpiracion) {
        this.tipoDetarjeta = tipoDetarjeta;
        this.banco = banco;
        this.codigoSeguridad = codigoSeguridad;
        this.nombreTitular = nombreTitular;
        this.numeroDetarjeta = numeroDetarjeta;
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getTipoDetarjeta() {
        return tipoDetarjeta;
    }

    public void setTipoDetarjeta(String tipoDetarjeta) {
        this.tipoDetarjeta = tipoDetarjeta;
    }

    public byte getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(byte codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public long getNumeroDetarjeta() {
        return numeroDetarjeta;
    }

    public void setNumeroDetarjeta(long numeroDetarjeta) {
        this.numeroDetarjeta = numeroDetarjeta;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public abstract  String Pagar(double precioTotal);
    public abstract String pagoRechazado();

    @Override
    public String toString() {
        return "Tarjeta [tipoDetarjeta=" + tipoDetarjeta + ", codigoSeguridad=" + codigoSeguridad
                + ", nombreTitular=" + nombreTitular + ", numeroDetarjeta=" + numeroDetarjeta + ", fechaExpiracion="
                + fechaExpiracion + "]";
    }

}
