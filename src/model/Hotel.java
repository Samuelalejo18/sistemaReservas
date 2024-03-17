package model;

public class Hotel extends Hospedaje {

    private boolean piscinas;
    private boolean gimnasio;

    public Hotel() {
        super();
    }

    public Hotel(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, int maximoDePisos,
            String descripcion, String tipo, Boolean piscinas, boolean gimnasio) {
        super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, maximoDePisos, descripcion, tipo);
        this.piscinas = piscinas;
        this.gimnasio = gimnasio;
    }
    
    public double calcularPrecioPorNoche(String tipoHabitacion) {

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
                break;
        }
        return precioTotal;
    }

    public boolean isPiscinas() {
        return piscinas;
    }

    public void setPiscinas(boolean piscinas) {
        this.piscinas = piscinas;
    }

    public boolean isGimnasio() {
        return gimnasio;
    }

    public void setGimnasio(boolean gimnasio) {
        this.gimnasio = gimnasio;
    }

}
