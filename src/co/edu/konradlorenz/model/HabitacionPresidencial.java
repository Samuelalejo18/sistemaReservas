package co.edu.konradlorenz.model;

public class HabitacionPresidencial extends Habitacion {

    private String serviciosExclusivos;

    public HabitacionPresidencial() {
        super();
    }


    public HabitacionPresidencial(int capacidad, boolean disponible, double precioPorPersona,
            String serviciosExclusivos) {
        super(capacidad, disponible, precioPorPersona);
        this.serviciosExclusivos = serviciosExclusivos;
    }

    public HabitacionPresidencial(int capacidad, boolean disponible, double precioPorPersona) {
        super(capacidad, disponible, precioPorPersona);
   
    }



    public String getServiciosExclusivos() {
        return serviciosExclusivos;
    }

    public void setServiciosExclusivos(String serviciosExclusivos) {
        this.serviciosExclusivos = serviciosExclusivos;
    }


    @Override
    public String toString() {
        return "HabitacionPresidencial [serviciosExclusivos=" + serviciosExclusivos + "]";
    }

  


    
}
