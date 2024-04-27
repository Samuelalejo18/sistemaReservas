package co.edu.konradlorenz.model;

import java.util.Date;

public abstract class MetodoPago {
    
    protected String tipoDetarjeta;
    protected byte codigoSeguridad;
    protected String nombreTitular;
    protected long numeroDetarjeta;
    protected Date fechaExpiracion;
    
    
    public MetodoPago(){
        
    }
    
    public MetodoPago(String tipoDetarjeta, byte codigoSeguridad, String nombreTitular, long numeroDetarjeta,
            Date fechaExpiracion) {
        this.tipoDetarjeta = tipoDetarjeta;
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

    @Override
    public String toString() {
        return "MetodoPago [tipoDetarjeta=" + tipoDetarjeta + ", codigoSeguridad=" + codigoSeguridad
                + ", nombreTitular=" + nombreTitular + ", numeroDetarjeta=" + numeroDetarjeta + ", fechaExpiracion="
                + fechaExpiracion + "]";
    }
    
    

    
    
}
