package co.edu.konradlorenz.model;

public class HabitacionDoble extends Habitacion {

    private String tipoCama;

    public HabitacionDoble() {
        super();
    }

    public HabitacionDoble(int capacidad, boolean disponible, double precioPorPersona, String tipoCama) {
        super(capacidad, disponible, precioPorPersona);
        this.tipoCama = tipoCama;
    }

    public HabitacionDoble(int capacidad, boolean disponible, double precioPorPersona) {
        super(capacidad, disponible, precioPorPersona);
    
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
