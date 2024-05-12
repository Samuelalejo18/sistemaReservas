package co.edu.konradlorenz.model.cliente;

import java.util.ArrayList;

import co.edu.konradlorenz.model.metodosDePago.Tarjeta;

public class Cliente {
	private String nombre;
	private String apellido;
	private int id;
	private String email;
	private String contrasena;
	private Long numeroTelefono;
	private String direccion;
	private ArrayList<Tarjeta> tarjetas;
	
	

	public Cliente(String nombre, String apellido, int id, String email, String contrasena, Long numeroTelefono,
			String direccion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = id;
		this.email = email;
		this.contrasena = contrasena;
		this.numeroTelefono = numeroTelefono;
		this.direccion = direccion;
		tarjetas= new ArrayList<>();
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

	public Long getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(Long numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public ArrayList<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(ArrayList<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	public void agregarTarjeta(Tarjeta  Tarjeta) {
		tarjetas.add(Tarjeta);

	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", id=" + id + ", email=" + email
				+ ", contrasena=" + contrasena + ", numeroTelefono=" + numeroTelefono + ", direccion=" + direccion
				+ ", tarjetas=" + tarjetas + "]";
	}
	


	



}
