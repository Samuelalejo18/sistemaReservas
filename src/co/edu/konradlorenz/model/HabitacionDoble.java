package co.edu.konradlorenz.model;

public class HabitacionDoble extends Habitacion {
    private double precioDobles;
    private String tipoCama;

    public HabitacionDoble() {
        super();
    }

    public HabitacionDoble(int capacidad, boolean disponible, double precioDobles,
            String tipoCama) {
        super(capacidad, disponible);
        this.precioDobles = precioDobles;
        this.tipoCama = tipoCama;
    }

    public HabitacionDoble(int capacidad, boolean disponible) {
        super(capacidad, disponible);

    }

    public double getPrecioDobles() {
        return precioDobles;
    }

    public void setPrecioDobles(double precioDobles) {
        this.precioDobles = precioDobles;
    }

    public String getTipoCama() {
        return tipoCama;
    }

    public void setTipoCama(String tipoCama) {
        this.tipoCama = tipoCama;
    }

}
