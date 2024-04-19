package co.edu.konradlorenz.model;

public class Cliente {
	private String nombre;
	private String apellido;
	private int id;
	private String email;
	// contraseña
	private String contrasena;
	private int numeroTelefono;
	private String direccion;

	public Cliente() {
	}

	public Cliente(String nombre, String apellido, int id, String email, String contrasena, int numeroTelefono,
			String direccion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
		this.email = email;
		// contraseña
		this.contrasena = contrasena;
		this.numeroTelefono = numeroTelefono;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// contraseña
	public String getContrasena() {
		return contrasena;
	}

	// contraseña
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public int getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", id=" + id + ", email=" + email
				+ ", contrasena=" + contrasena + ", numeroTelefono=" + numeroTelefono + "]";
	}

}
