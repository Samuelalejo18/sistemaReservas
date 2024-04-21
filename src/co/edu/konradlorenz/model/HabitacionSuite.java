package co.edu.konradlorenz.model;

public class HabitacionSuite extends Habitacion {
    private double precioSuite;
    private String serviciosDeLujoIncluidos;

    public HabitacionSuite() {
        super();
    }

    public HabitacionSuite(int capacidad, boolean disponible, double precioSuite, String serviciosDeLujoIncluidos) {
        super(capacidad, disponible);
        this.precioSuite = precioSuite;
        this.serviciosDeLujoIncluidos = serviciosDeLujoIncluidos;
    }

    public HabitacionSuite(int capacidad, boolean disponible) {
        super(capacidad, disponible);

    }

    public double getPrecioSuite() {
        return precioSuite;
    }

    public void setPrecioSuite(double precioSuite) {
        this.precioSuite = precioSuite;
    }

    public String getServiciosDeLujoIncluidos() {
        return serviciosDeLujoIncluidos;
    }

    public void setServiciosDeLujoIncluidos(String serviciosDeLujoIncluidos) {
        this.serviciosDeLujoIncluidos = serviciosDeLujoIncluidos;
    }

    @Override
    public String toString() {
        return "HabitacionSuite [precioSuite=" + precioSuite + ", serviciosDeLujoIncluidos=" + serviciosDeLujoIncluidos
                + "]";
    }

}