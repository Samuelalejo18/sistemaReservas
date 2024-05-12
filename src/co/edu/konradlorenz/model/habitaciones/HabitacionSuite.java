package co.edu.konradlorenz.model.habitaciones;



public class HabitacionSuite extends Habitacion {

    private String serviciosDeLujoIncluidos;

    public HabitacionSuite() {
        super();
    }

    public HabitacionSuite(int capacidad, boolean disponible, double precioAdicionalPorTipoHabitacion,
            String serviciosDeLujoIncluidos) {
        super(capacidad, disponible, precioAdicionalPorTipoHabitacion);
        this.serviciosDeLujoIncluidos = serviciosDeLujoIncluidos;
    }

    public HabitacionSuite(int capacidad, boolean disponible, double precioAdicionalPorTipoHabitacion) {
        super(capacidad, disponible, precioAdicionalPorTipoHabitacion);

    }

    public String getServiciosDeLujoIncluidos() {
        return serviciosDeLujoIncluidos;
    }

    public void setServiciosDeLujoIncluidos(String serviciosDeLujoIncluidos) {
        this.serviciosDeLujoIncluidos = serviciosDeLujoIncluidos;
    }

    @Override
    public String toString() {
        return "HabitacionSuite [serviciosDeLujoIncluidos=" + serviciosDeLujoIncluidos + "]";
    }



    
}