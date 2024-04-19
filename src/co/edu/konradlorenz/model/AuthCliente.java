package co.edu.konradlorenz.model;

import java.util.ArrayList;

public class AuthCliente {

	public AuthCliente() {

	}

	private static ArrayList<Cliente> clientes = new ArrayList<>();
	private static Cliente usuarioAutenticado;

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
		Cliente clientePrueba = new Cliente("Samuel", "Monsalve", 1014180725, "s", "l",
				321456879, "mi casa");
		clientes.add(clientePrueba);
	}

	public static boolean registrar(Cliente cliente) {
		boolean existeUsuario = false;
		boolean existeUsuario2 = false;

		for (Cliente cliente1 : clientes) {
			if (cliente1.getEmail().equals(cliente.getEmail())) {
				existeUsuario = true;
			}
			if (cliente1.getId() == (cliente.getId())) {
				existeUsuario2 = true;

			}
		}
		if (!existeUsuario && !existeUsuario2) {
			clientes.add(cliente);
		} else {
			return false;
		}
		return false;

	}

	public static Cliente autenticarse(String usuarioEmail, String contrasena) {
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
				return null;
			}
		} else {
			return null;
		}
		
	}


	@Override
	public String toString() {
		return "Auth [clientes=" + clientes + "]";
	}

}
