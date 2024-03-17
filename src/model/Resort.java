package model;

public class Resort  extends Hospedaje{

    private String actividadesExtra;
    private String espaciosExclusivos;
    public Resort(String actividadesExtra, String espaciosExclusivos) {
        this.actividadesExtra = actividadesExtra;
        this.espaciosExclusivos = espaciosExclusivos;
    }
    public Resort(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas, int maximoDePisos,
            String descripcion, String tipo, String actividadesExtra, String espaciosExclusivos) {
        super(nombre, ubicacionCiudad, ubicacionPais, numeroEstrellas, maximoDePisos, descripcion, tipo);
        this.actividadesExtra = actividadesExtra;
        this.espaciosExclusivos = espaciosExclusivos;
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
