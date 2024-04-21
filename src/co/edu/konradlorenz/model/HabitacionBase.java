package co.edu.konradlorenz.model;

public class HabitacionBase extends Habitacion {
    private double precioSencilla;

    public HabitacionBase() {
        super();
    }

    public HabitacionBase(int capacidad, boolean disponible, double precioSencilla) {
        super(capacidad, disponible);
        this.precioSencilla = precioSencilla;
    }

    public HabitacionBase(int capacidad, boolean disponible) {
        super(capacidad, disponible);

    }

    public double getPrecioSencilla() {
        return precioSencilla;
    }

    public void setPrecioSencilla(double precioSencilla) {
        this.precioSencilla = precioSencilla;
    }

    @Override
    public String toString() {
        return "HabitacionBase [precioSencilla=" + precioSencilla + "]";
    }

}
