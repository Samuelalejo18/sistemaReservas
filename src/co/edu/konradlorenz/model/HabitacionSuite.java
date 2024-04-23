package co.edu.konradlorenz.model;

public class HabitacionSuite extends Habitacion {

    private String serviciosDeLujoIncluidos;

    public HabitacionSuite() {
        super();
    }

    public HabitacionSuite(int capacidad, boolean disponible, double precioPorPersona,
            String serviciosDeLujoIncluidos) {
        super(capacidad, disponible, precioPorPersona);
        this.serviciosDeLujoIncluidos = serviciosDeLujoIncluidos;
    }

    public HabitacionSuite(int capacidad, boolean disponible, double precioPorPersona) {
        super(capacidad, disponible, precioPorPersona);

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