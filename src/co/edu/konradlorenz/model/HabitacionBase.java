package co.edu.konradlorenz.model;

public class HabitacionBase extends Habitacion {
  
    private String comidadesBasicas;

    public HabitacionBase() {
        super();
    }

  

    public HabitacionBase(int capacidad, boolean disponible,  double precioPorPersona, String comidadesBasicas) {
        super(capacidad, disponible,  precioPorPersona);
        this.comidadesBasicas = comidadesBasicas;
    }

    public HabitacionBase(int capacidad, boolean disponible, double precioPorPersona) {
        super(capacidad, disponible, precioPorPersona);
      
    }



    public String getComidadesBasicas() {
        return comidadesBasicas;
    }



    public void setComidadesBasicas(String comidadesBasicas) {
        this.comidadesBasicas = comidadesBasicas;
    }



    @Override
    public String toString() {
        return "HabitacionBase [comidadesBasicas=" + comidadesBasicas + "]";
    }



}
