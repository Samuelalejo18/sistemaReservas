package co.edu.konradlorenz.model;



public abstract class Hospedaje {
	protected String nombre;
	protected String ubicacionCiudad;
	protected String ubicacionPais;
	protected int numeroEstrellas;
	protected String descripcion;
	protected String tipo;
	

	public Hospedaje() {

	}

	public Hospedaje(String nombre, String ubicacionCiudad, String ubicacionPais, int numeroEstrellas,
	 String descripcion, String tipo) {
		this.nombre = nombre;
		this.ubicacionCiudad = ubicacionCiudad;
		this.ubicacionPais = ubicacionPais;
		this.numeroEstrellas = numeroEstrellas;
		this.descripcion = descripcion;
		this.tipo = tipo;

	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacionCiudad() {
		return ubicacionCiudad;
	}

	public void setUbicacionCiudad(String ubicacionCiudad) {
		this.ubicacionCiudad = ubicacionCiudad;
	}

	public String getUbicacionPais() {
		return ubicacionPais;
	}

	public void setUbicacionPais(String ubicacionPais) {
		this.ubicacionPais = ubicacionPais;
	}

	public int getNumeroEstrellas() {
		return numeroEstrellas;
	}

	public void setNumeroEstrellas(int numeroEstrellas) {
		this.numeroEstrellas = numeroEstrellas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "Hospedaje [nombre=" + nombre + ", ubicacionCiudad=" + ubicacionCiudad + ", ubicacionPais="
				+ ubicacionPais + ", numeroEstrellas=" + numeroEstrellas +
				", descripcion=" + descripcion + ", tipo=" + tipo + "]";
	}

	public abstract  double calcularPrecioPorNoche(String tipoHabitacion);

}
