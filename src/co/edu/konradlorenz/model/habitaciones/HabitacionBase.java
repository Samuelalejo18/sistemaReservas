package co.edu.konradlorenz.model.habitaciones;

import co.edu.konradlorenz.model.Habitacion;

public class HabitacionBase extends Habitacion {

    private String caracteristicas;

    public HabitacionBase() {
        super();
    }

    public HabitacionBase(int capacidad, boolean disponible, double precioAdicionalPorTipoHabitacion,
            String caracteristicas) {
        super(capacidad, disponible, precioAdicionalPorTipoHabitacion);
        this.caracteristicas = caracteristicas;
    }

    public HabitacionBase(int capacidad, boolean disponible, double precioAdicionalPorTipoHabitacion) {
        super(capacidad, disponible, precioAdicionalPorTipoHabitacion);

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