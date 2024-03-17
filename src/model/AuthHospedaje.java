package model;

import java.util.ArrayList;

public class AuthHospedaje {
	private ArrayList<Hospedaje> hospedajes = new ArrayList<>();

	public AuthHospedaje() {

	}

	public ArrayList<Hospedaje> getHospedajes() {
		return hospedajes;
	}

	public void setHospedajes(ArrayList<Hospedaje> hospedajes) {
		this.hospedajes = hospedajes;
	}

	public String buscarPorNombre(String nombre) {

		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getNombre() == nombre) {
				return hospedaje.getNombre();
			} else {
				return " El hospedaje no existe";
			}
		}
		return "";
	}

	public void filtrarPorUbicacionCiudad(String ubicacionCiudad) {
		for (Hospedaje hospedaje : hospedajes) {

		}
	}


	public void filtrarPorUbicacionPais(String ubicacionPais) {
		for (Hospedaje hospedaje : hospedajes) {

		}
	}

	
	
	public void filtrarPorNumeroDeEstrellas(int numeroDeEstrellas) {
		for (Hospedaje hospedaje : hospedajes) {

		}

	}
	public void filtrarTipoHospedaje() {

	}
}
