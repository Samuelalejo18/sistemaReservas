package co.edu.konradlorenz.model.cliente;

import java.util.ArrayList;

import co.edu.konradlorenz.model.excepciones.AuntenticacionFallidaException;
import co.edu.konradlorenz.model.excepciones.RegistroFallidoException;

public class AuthCliente {

	private static ArrayList<Cliente> clientes = new ArrayList<>();
	private static Cliente usuarioAutenticado;

	public AuthCliente() {

	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		AuthCliente.clientes = clientes;
	}

	public static Cliente getUsuarioAutenticado() {
		return usuarioAutenticado;
	}

	public static void setUsuarioAutenticado(Cliente usuarioAutenticado) {
		AuthCliente.usuarioAutenticado = usuarioAutenticado;
	}

	public void registrarClientePrueba() {

		// Usuarios admin
		// La letra L al final del numero especifica que es Long
		Cliente clienteAdmin = new Cliente("Julian", "Homez", 289, "julian@gmail.com", "j", 3161925274L, "Calle 5");
		clientes.add(clienteAdmin);
	}

	public static boolean registrar(Cliente cliente) throws RegistroFallidoException {
		boolean existeUsuario = false;
		boolean existeUsuario2 = false;

		for (Cliente cliente1 : clientes) {
			if (cliente1.getEmail().equals(cliente.getEmail())) {
				throw new RegistroFallidoException(" El email ya existe");
			}
			if (cliente1.getId() == (cliente.getId())) {
				throw new RegistroFallidoException(" El id ya existe");

			}
		}
		if (existeUsuario && existeUsuario2) {
			throw new RegistroFallidoException(" El usuario ya existe");
		} else {
			clientes.add(cliente);
			return true;
		}

	}

	public static Cliente autenticarse(String usuarioEmail, String contrasena) throws AuntenticacionFallidaException {
		Cliente usuarioEncontrado = null;
		for (Cliente cliente : clientes) {
			if (cliente.getEmail().equals(usuarioEmail)) {
				usuarioEncontrado = cliente;
				break;
			}
		}

		if (usuarioEncontrado != null) {
			if (usuarioEncontrado.getContrasena().equals(contrasena)) {
				usuarioAutenticado = usuarioEncontrado;
				return usuarioAutenticado;
			} else {
				throw new AuntenticacionFallidaException(" ViewAutenticacion fallida");
			}
		} else {
			throw new AuntenticacionFallidaException(" El usuario no existe");
		}
	}

	@Override
	public String toString() {
		return "Auth [clientes=" + clientes + "]";
	}

}
