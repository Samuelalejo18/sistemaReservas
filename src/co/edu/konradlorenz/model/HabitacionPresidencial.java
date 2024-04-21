package co.edu.konradlorenz.model;

public class HabitacionPresidencial extends Habitacion {
    private double precioPresidencial;
    private String serviciosExclusivos;

    public HabitacionPresidencial() {
        super();
    }

    public HabitacionPresidencial(int capacidad, boolean disponible) {
        super(capacidad, disponible);
    }

    public HabitacionPresidencial(int capacidad, boolean disponible, double precioPresidencial,
            String serviciosExclusivos) {
        super(capacidad, disponible);
        this.precioPresidencial = precioPresidencial;
        this.serviciosExclusivos = serviciosExclusivos;
    }

    public double getPrecioPresidencial() {
        return precioPresidencial;
    }

    public void setPrecioPresidencial(double precioPresidencial) {
        this.precioPresidencial = precioPresidencial;
    }

    public String getServiciosExclusivos() {
        return serviciosExclusivos;
    }

    public void setServiciosExclusivos(String serviciosExclusivos) {
        this.serviciosExclusivos = serviciosExclusivos;
    }

    @Override
    public String toString() {
        return "HabitacionPresidencial [precioPresidencial=" + precioPresidencial + ", serviciosExclusivos="
                + serviciosExclusivos + "]";
    }


    
}
