package co.edu.konradLorenz.model;

public class Resort extends Hospedaje {

    private String actividadesExtra;
    private String espaciosExclusivos;

    public Resort(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, int maximoDePisos,
            String descripcion, String tipo, String actividadesExtra, String espaciosExclusivos) {
        super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo);
        this.actividadesExtra = actividadesExtra;
        this.espaciosExclusivos = espaciosExclusivos;
    }

    @Override
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
                return calcularPrecioPorNoche(tipoHabitacion);
            }
        return precioTotal;

    }

    public Resort(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, int maximoDePisos,
            String descripcion, String tipo) {
        super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, descripcion, tipo);
    }

    public String getActividadesExtra() {
        return actividadesExtra;
    }

    public void setActividadesExtra(String actividadesExtra) {
        this.actividadesExtra = actividadesExtra;
    }

    public String getEspaciosExclusivos() {
        return espaciosExclusivos;
    }

    public void setEspaciosExclusivos(String espaciosExclusivos) {
        this.espaciosExclusivos = espaciosExclusivos;
    }

}
