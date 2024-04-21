package co.edu.konradlorenz.model;



public class Hotel extends Hospedaje {

    private boolean piscina;
    private boolean gimnasio;

    public Hotel() {
        super();
    }

    public Hotel(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
            String descripcion, String tipo,double precioPorPersona, Boolean piscina, boolean gimnasio) {
        super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioPorPersona );
        this.piscina = piscina;
        this.gimnasio = gimnasio;
    }

    public Hotel(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
            String descripcion, String tipo, double precioPorPersona) {
        super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo, precioPorPersona);

    }
    
   @Override
    public double calcularPrecioPorNoche(String tipoHabitacion) {
        return numeroEstrellas;
/* 
        double precioTotal = PreciosHotel.TARIFA_BASE;
        switch (tipoHabitacion.toLowerCase()) {
            case "suite":
                precioTotal += PreciosHotel.PRECIO_SUITE;
                break;
            case "presidencial":
                precioTotal += PreciosHotel.PRECIO_PRESIDENCIAL;
                break;
            case "dobles":
                precioTotal += PreciosHotel.PRECIO_DOBLES;
                break;
            case "sencilla":
                precioTotal += PreciosHotel.PRECIO_SENCILLA;
                break;
            default:
                System.out.println("Tipo de habitación no válido");
                return calcularPrecioPorNoche(tipoHabitacion);
        }
        return precioTotal;
        */
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    public boolean isGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(boolean gimnasio) {
        this.gimnasio = gimnasio;
    }

    @Override
    public String toString() {
        return "Hotel [piscina=" + piscina + ", gimnasio=" + gimnasio + "]";
    }

}
