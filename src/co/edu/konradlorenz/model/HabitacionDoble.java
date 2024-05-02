package co.edu.konradlorenz.model;

public class HabitacionDoble extends Habitacion {

    private String tipoCama;

    public HabitacionDoble() {
        super();
    }

    public HabitacionDoble(int capacidad, boolean disponible, double precioAdicionalPorTipoHabitacion, String tipoCama) {
        super(capacidad, disponible, precioAdicionalPorTipoHabitacion);
        this.tipoCama = tipoCama;
    }

    public HabitacionDoble(int capacidad, boolean disponible, double precioAdicionalPorTipoHabitacion) {
        super(capacidad, disponible, precioAdicionalPorTipoHabitacion);
    
    }

    public String getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(String tipoCama) {
        this.tipoCama = tipoCama;
    }

    @Override
    public String toString() {
        return "HabitacionDoble [tipoCama=" + tipoCama + "]";
    }

    
}
