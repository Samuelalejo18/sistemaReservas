package co.edu.konradlorenz.model;

public class HabitacionBase extends Habitacion {
  
    private String caracteristicas;

    public HabitacionBase() {
        super();
    }

  

    public HabitacionBase(int capacidad, boolean disponible, String caracteristicas) {
        super(capacidad, disponible);
        this.caracteristicas = caracteristicas;
    }

    public HabitacionBase(int capacidad, boolean disponible) {
        super(capacidad, disponible);
      
    }



    public String caracteristicas() {
        return caracteristicas;
    }



    public void setcaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }



    @Override
    public String toString() {
        return "HabitacionBase [caracteristicas=" + caracteristicas + "]";
    }



}
