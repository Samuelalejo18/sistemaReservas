package co.edu.konradlorenz.model.habitaciones;



public class HabitacionPresidencial extends Habitacion {

    private String serviciosExclusivos;

    public HabitacionPresidencial() {
        super();
    }


    public HabitacionPresidencial(int capacidad, boolean disponible, double precioAdicionalPorTipoHabitacion,
            String serviciosExclusivos) {
        super(capacidad, disponible, precioAdicionalPorTipoHabitacion);
        this.serviciosExclusivos = serviciosExclusivos;
    }

    public HabitacionPresidencial(int capacidad, boolean disponible, double precioAdicionalPorTipoHabitacion) {
        super(capacidad, disponible, precioAdicionalPorTipoHabitacion);
   
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
