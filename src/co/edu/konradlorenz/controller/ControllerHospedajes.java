package co.edu.konradlorenz.controller;

import java.util.ArrayList;
import co.edu.konradlorenz.model.Cabana;
import co.edu.konradlorenz.model.Camping;
import co.edu.konradlorenz.model.Glamping;
import co.edu.konradlorenz.model.HabitacionBase;
import co.edu.konradlorenz.model.HabitacionDoble;
import co.edu.konradlorenz.model.HabitacionPresidencial;
import co.edu.konradlorenz.model.HabitacionSuite;
import co.edu.konradlorenz.model.Hospedaje;
import co.edu.konradlorenz.model.Hotel;
import co.edu.konradlorenz.model.Motel;
import co.edu.konradlorenz.model.Reserva;
import co.edu.konradlorenz.model.Resort;
import co.edu.konradlorenz.view.ViewHospedaje;
import co.edu.konradlorenz.view.ViewReserva;

public class ControllerHospedajes {
	Reserva reserva = new Reserva();
	static ArrayList<Hospedaje> hospedajes = new ArrayList<>();

	public static ArrayList<Hospedaje> getHospedajes() {
		return hospedajes;
	}

	ViewReserva viewReserva = new ViewReserva();
	ViewHospedaje viewHospedaje = new ViewHospedaje();

	public String hallarTipoHospedaje(Hospedaje hospedaje) {
		String tipoHospedaje = "no existe";
		if (hospedaje instanceof Hotel) {
			tipoHospedaje = "Hotel";
		} else if (hospedaje instanceof Cabana) {
			tipoHospedaje = "Cabaña";
		} else if (hospedaje instanceof Camping) {
			tipoHospedaje = "Camping";
		} else if (hospedaje instanceof Glamping) {
			tipoHospedaje = "Glamping";
		} else if (hospedaje instanceof Motel) {
			tipoHospedaje = "Motel";
		} else if (hospedaje instanceof Resort) {
			tipoHospedaje = "Resort";
		}
		return tipoHospedaje;
	}

	public void buscarPorNombre(String nombre) {
		boolean encontradoNombre = false;
		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getNombre().equalsIgnoreCase(nombre)) {
				// viewHospedaje.mostrarFiltros(hospedaje);
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				encontradoNombre = true;
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo(),hospedaje.getPrecioPorPersona());
			}
		}
		if (!encontradoNombre) {
			ViewHospedaje.filtroFallido();
		}

	}

	public void filtrarCiudad(String ubicacionCiudad) {
		boolean encontradoCiudad = false;
		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getUbicacionCiudad().equalsIgnoreCase(ubicacionCiudad)) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				encontradoCiudad = true;
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo(),hospedaje.getPrecioPorPersona());
			}
		}

		if (!encontradoCiudad) {
			ViewHospedaje.filtroFallido();
		}
	}

	public void hospedajesDisponibles() {
		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			String tipoHospedaje = hallarTipoHospedaje(hospedaje);
			ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
					hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
					hospedaje.getTipo(),hospedaje.getPrecioPorPersona());
		}
	}

	public void filtrarPorPais(String ubicacionPais) {
		boolean encontrado = false;
		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getUbicacionPais().equalsIgnoreCase(ubicacionPais)) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				encontrado = true;
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo(),hospedaje.getPrecioPorPersona());
			}
		}

		if (!encontrado) {
			ViewHospedaje.filtroFallido();
		}

	}

	public void filtrarPorNumeroDeEstrellas(int numeroDeEstrellas) {
		boolean encontradoEstrellas = false;
		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getNumeroEstrellas() == numeroDeEstrellas) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo(),hospedaje.getPrecioPorPersona());
			}
		}

		if (!encontradoEstrellas) {
			ViewHospedaje.filtroFallido();
		}

	}

	// Tipo urbano o rural

	public void filtrarTipo(String tipo) {
		boolean encontradoTipo = false;
		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getTipo().equalsIgnoreCase(tipo)) {
				encontradoTipo = true;
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo(),hospedaje.getPrecioPorPersona());

			}
		}
		if (!encontradoTipo) {
			ViewHospedaje.filtroFallido();
		}
	}

	// Tipo urbano o rural

	public void filtrarHoteles() {

		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Hotel) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo(),hospedaje.getPrecioPorPersona());

			}
		}

	}

	public void filtrarMoteles() {
		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Motel) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo(),hospedaje.getPrecioPorPersona());

			}
		}
	}

	public void filtralResorts() {
		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Resort) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo(),hospedaje.getPrecioPorPersona());

			}
		}
	}

	public void filtralCampings() {
		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Camping) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo(),hospedaje.getPrecioPorPersona());

			}
		}
	}

	public void filtralGlampings() {
		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Glamping) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo(),hospedaje.getPrecioPorPersona());

			}
		}
	}

	public void filtralCabanas() {
		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Cabana) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo(),hospedaje.getPrecioPorPersona());

			}
		}
	}

	public void filtrarPorPrecio(int min, int max) {
		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getPrecioPorPersona() >= min && hospedaje.getPrecioPorPersona() <= max) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo(),hospedaje.getPrecioPorPersona());
			}
		}
	}

	public void registrarHospedajes() {

		/* Cabañas */
		Cabana cabana1 = new Cabana("Cabana las mercedes", "Villeta", "Colombia", 5, "Cabaña bonita", "Cabaña rural",
				230000, "Luces bonitas amarillas", false, "Baño frente a la cascada");
		hospedajes.add(cabana1);
		HabitacionBase habitacionBase1 = new HabitacionBase(2, true, 0, "Wifi, TV, aire acondicionado");
		HabitacionDoble habitacionDoble1 = new HabitacionDoble(4, true, 50000, "Queen");
		cabana1.agregarHabitacion(habitacionBase1);
		cabana1.agregarHabitacion(habitacionDoble1);

		Cabana cabana2 = new Cabana("Cabana de Montaña", "Monterrey", "Mexico", 5,
				"Una acogedora cabaña en medio de las montañas", "Rural", 330000, "Rústica", true, "Senderismo");
		hospedajes.add(cabana2);
		HabitacionBase habitacionBase2 = new HabitacionBase(2, true, 0, "Wifi, TV, Minibar");
		HabitacionDoble habitacionDoble2 = new HabitacionDoble(4, true, 60000, "King");
		cabana2.agregarHabitacion(habitacionBase2);
		cabana2.agregarHabitacion(habitacionDoble2);

		Cabana cabana3 = new Cabana("Cabana de Playa", "Cancun", "Mexico", 4,
				"Un refugio junto al mar con vista panorámica", "Rural", 120000, "Tropical", false, "Surf");
		hospedajes.add(cabana3);
		HabitacionBase habitacionBase3 = new HabitacionBase(1, false, 0, "Wifi, TV, Balcón");
		HabitacionDoble habitacionDoble3 = new HabitacionDoble(2, false, 700000, "Matrimonial");
		cabana3.agregarHabitacion(habitacionBase3);
		cabana3.agregarHabitacion(habitacionDoble3);

		Cabana cabana4 = new Cabana("Cabana en el Bosque", "Toronto", "Canada", 3,
				"Un retiro tranquilo rodeado de árboles centenarios", "Rural", 80000, "Vintage", true,
				"Observación de aves");
		hospedajes.add(cabana4);
		HabitacionBase habitacionBase4 = new HabitacionBase(2, true, 0, "Wifi, TV");
		HabitacionDoble habitacionDoble4 = new HabitacionDoble(4, true, 40000, "Queen");

		cabana4.agregarHabitacion(habitacionBase4);
		cabana4.agregarHabitacion(habitacionDoble4);

		Cabana cabana5 = new Cabana("Cabana junto al Lago", "Medellin", "Colombia", 5,
				"Una cabaña con acceso directo al lago cristalino", "Rural", 220000, "Moderna", false, "Pesca");
		hospedajes.add(cabana5);

		HabitacionBase habitacionBase5 = new HabitacionBase(2, false, 0, "Wifi, TV, Escritorio");
		HabitacionDoble habitacionDoble5 = new HabitacionDoble(3, false, 80000, "King");
		cabana5.agregarHabitacion(habitacionBase5);
		cabana5.agregarHabitacion(habitacionDoble5);

		Cabana cabana6 = new Cabana("Cabana de Aventura", "La vega", "Colombia", 4,
				"Una cabaña para los amantes de la adrenalina", "Rural", 170000, "Minimalista", true, "Escalada");
		hospedajes.add(cabana6);

		HabitacionBase habitacionBase6 = new HabitacionBase(2, true, 0, "Wifi, TV, Baño privado");
		HabitacionDoble habitacionDoble6 = new HabitacionDoble(2, true, 55000, "Matrimonial");

		cabana6.agregarHabitacion(habitacionBase6);
		cabana6.agregarHabitacion(habitacionDoble6);

		Cabana cabana7 = new Cabana("Cabana Histórica", "Villeta", "Colombia", 3,
				"Una cabaña con siglos de historia en su interior", "Rural", 60000, "Antigua", false,
				"Visitas guiadas");
		hospedajes.add(cabana7);

		HabitacionBase habitacionBase7 = new HabitacionBase(4, true, 0, "Wifi, TV, Cocina");
		HabitacionDoble habitacionDoble7 = new HabitacionDoble(2, true, 30000, "Queen");
		cabana7.agregarHabitacion(habitacionBase7);
		cabana7.agregarHabitacion(habitacionDoble7);

		Cabana cabana8 = new Cabana("Cabana de Campo", "Capitanejo", "Colombia", 5,
				"Un refugio campestre con todas las comodidades", "Rural", 300000);
		hospedajes.add(cabana8);
		HabitacionBase habitacionBase8 = new HabitacionBase(2, false, 0, "Wifi, TV, Aire acondicionado");
		HabitacionDoble habitacionDoble8 = new HabitacionDoble(4, false, 45000, "King");
		cabana8.agregarHabitacion(habitacionBase8);
		cabana8.agregarHabitacion(habitacionDoble8);

		Cabana cabana9 = new Cabana("Cabana Ecológica", "Anapoima", "Colombia", 4,
				"Una cabaña diseñada para minimizar su impacto ambiental", "Rural", 210000, "Sostenible", false,
				"Reciclaje");
		hospedajes.add(cabana9);

		HabitacionBase habitacionBase9 = new HabitacionBase(1, true, 0, "Wifi, TV, Caja fuerte");
		HabitacionDoble habitacionDoble9 = new HabitacionDoble(3, true, 40000, "Matrimonial");
		cabana9.agregarHabitacion(habitacionBase9);
		cabana9.agregarHabitacion(habitacionDoble9);

		Cabana cabana10 = new Cabana("Cabana Romántica", "Neusa", "Colombia", 3,
				"Un rincón íntimo para parejas en busca de tranquilidad", "Rural", 150000, "Acogedora", true,
				"Masajes");
		hospedajes.add(cabana10);
		HabitacionBase habitacionBase10 = new HabitacionBase(2, true, 0, "Wifi, TV, Jacuzzi");
		HabitacionDoble habitacionDoble10 = new HabitacionDoble(4, true, 35000, "Queen");

		cabana10.agregarHabitacion(habitacionDoble10);
		cabana10.agregarHabitacion(habitacionBase10);

		Cabana cabana11 = new Cabana("Cabana de Lujo", "Anapoima", "Colombia", 5,
				"Una experiencia exclusiva con servicio de primera clase", "Rural", 400000, "Elegante", false,
				"Gastronomía gourmet");
		hospedajes.add(cabana11);

		HabitacionBase habitacionBase11 = new HabitacionBase(2, true, 0, "Wifi, TV, Jacuzzi");
		HabitacionDoble habitacionDoble11 = new HabitacionDoble(2, false, 90000, "King");
		cabana11.agregarHabitacion(habitacionBase11);
		cabana11.agregarHabitacion(habitacionDoble11);

		/* Camping */
		Camping camping1 = new Camping("Camping de Montaña", "Ciudad del cabo", "Sudafrica", 5,
				"Un camping rodeado de montañas",
				"Rural", 420000, "Área de fogatas", "Senderismo");

		hospedajes.add(camping1);
		HabitacionBase habitacion12 = new HabitacionBase(1, true, 0, "Con vistas a  la montana");
		HabitacionDoble habitacionDoble12 = new HabitacionDoble(4, true, 80000, "Queen");
		camping1.agregarHabitacion(habitacion12);
		camping1.agregarHabitacion(habitacionDoble12);

		Camping camping2 = new Camping("Camping junto al Río", "Banff", "Canada", 4, "Un camping con vista al río",
				"Rural", 320000, "Zona de barbacoa", "Pesca");
		hospedajes.add(camping2);
		HabitacionBase habitacion13 = new HabitacionBase(2, true, 0, "Con escritorio");
		HabitacionDoble habitacionDoble13 = new HabitacionDoble(3, true, 60000, "King");
		camping1.agregarHabitacion(habitacion13);
		camping1.agregarHabitacion(habitacionDoble13);
		Camping camping3 = new Camping("Camping en el Bosque", "Berguen", "Noruega", 3, "Un camping entre árboles",
				"Rural",
				170000, "Piscina natural", "Observación de aves");
		hospedajes.add(camping3);
		HabitacionBase habitacion14 = new HabitacionBase(2, false, 0, "Con armario empotrado");
		HabitacionDoble habitacionDoble14 = new HabitacionDoble(4, false, 40000, "Matrimonial");
		camping3.agregarHabitacion(habitacion14);
		camping3.agregarHabitacion(habitacionDoble14);
		Camping camping4 = new Camping("Camping en la Playa", "Interlaken", "Suiza", 5, "Un camping cerca del mar",
				"Rural",
				720000, "Zona de descanso", "Surf");
		hospedajes.add(camping4);
		HabitacionBase habitacion15 = new HabitacionBase(2, true, 0, "Con cama Queen Size");
		HabitacionDoble habitacionDoble15 = new HabitacionDoble(5, true, 70000, "Doble");
		camping4.agregarHabitacion(habitacion15);
		camping4.agregarHabitacion(habitacionDoble15);

		Camping camping5 = new Camping("Camping Familiar", "Moab", "Estados Unidos", 4,
				"Un camping ideal para familias", "Rural",
				230000, "Parque infantil", "Excursiones");

		hospedajes.add(camping5);
		HabitacionBase habitacion16 = new HabitacionBase(2, false, 0, "Con balcón privado");
		HabitacionDoble habitacionDoble16 = new HabitacionDoble(3, false, 45000, "Individual");
		camping5.agregarHabitacion(habitacion16);
		camping5.agregarHabitacion(habitacionDoble16);

		Camping camping6 = new Camping("Camping de Aventura", "San Carlos De bariloche", "Argentina", 3,
				"Un camping para los amantes de la adrenalina", "Rural", 130000, "Pared de escalada", "Rafting");
		hospedajes.add(camping6);
		HabitacionBase habitacion17 = new HabitacionBase(1, true, 0, "Con servicio de habitaciones 24 horas");
		HabitacionDoble habitacionDoble17 = new HabitacionDoble(4, true, 35000, "Estándar");
		camping6.agregarHabitacion(habitacion17);
		camping6.agregarHabitacion(habitacionDoble17);
		Camping camping7 = new Camping("Camping Eco-Friendly", "Cairns", "Australia", 5,
				"Un camping comprometido con el medio ambiente", "Rural", 370000, "Reciclaje",
				"Observación de estrellas");
		hospedajes.add(camping7);
		HabitacionBase habitacion18 = new HabitacionBase(1, true, 0, "Con cafetera");
		HabitacionDoble habitacionDoble18 = new HabitacionDoble(2, true, 65000, "Deluxe");
		camping7.agregarHabitacion(habitacion18);
		camping7.agregarHabitacion(habitacionDoble18);

		Camping camping8 = new Camping("Camping de Relax", "Queenstown", "Nueva Zelanda", 4,
				"Un camping para desconectar y relajarse", "Rural", 340000, "Área de meditación", "Yoga");
		hospedajes.add(camping8);
		HabitacionBase habitacion19 = new HabitacionBase(2, true, 0, "Con bañera de hidromasaje");
		HabitacionDoble habitacionDoble19 = new HabitacionDoble(4, false, 45000, "Junior");
		camping8.agregarHabitacion(habitacion19);
		camping8.agregarHabitacion(habitacionDoble19);

		Camping camping9 = new Camping("Camping de Aventura Extrema", "Salzburgo", "Australia", 3,
				"Un camping para los más intrépidos", "Rural", 250000, "Tirolesa", "Escalada");
		hospedajes.add(camping9);
		HabitacionBase habitacion20 = new HabitacionBase(2, false, 0, "Con acceso a la piscina");
		HabitacionDoble habitacionDoble20 = new HabitacionDoble(4, true, 40000, "Presidencial");
		camping9.agregarHabitacion(habitacion20);
		camping9.agregarHabitacion(habitacionDoble20);

		Camping camping10 = new Camping("Camping Romántico", "Glencoe", "Escocia", 5,
				"Un camping para parejas en busca de romance", "Rural", 1000000, "Área de picnic", "Paseos nocturnos");

		hospedajes.add(camping10);

		HabitacionBase habitacion21 = new HabitacionBase(2, true, 0, "Con sauna privada");
		HabitacionDoble habitacionDoble21 = new HabitacionDoble(4, true, 90000, "Ejecutiva");
		camping10.agregarHabitacion(habitacion21);
		camping10.agregarHabitacion(habitacionDoble21);

		Camping camping11 = new Camping("Camping las maravillas", "Anapoima", "Colombia", 3,
				"Camping con excelente ubicacion", "rural", 180000, "Cercano a parrillas comunitarias", "Yoga");

		hospedajes.add(camping11);
		HabitacionBase habitacion22 = new HabitacionBase(2, true, 0, "Con vistas al río");
		HabitacionDoble habitacionDoble22 = new HabitacionDoble(4, true, 40000, "Familiar");

		camping11.agregarHabitacion(habitacion22);
		camping11.agregarHabitacion(habitacionDoble22);

		/* Glampings */

		Glamping glamping1 = new Glamping("Glamping donde Julian", "Guatape", "Colombia", 5,
				"Glamping perfecto para ir con tu pareja", "rural", 450000, "Vistas con mucha fauna", "Comida",
				"Todo es reciclable");
		hospedajes.add(glamping1);
		HabitacionBase habitacionBase23 = new HabitacionBase(3, true, 0, "Con vistas al jardín");
		HabitacionDoble habitacionDoble23 = new HabitacionDoble(2, true, 48000, "Queen");

		glamping1.agregarHabitacion(habitacionBase23);
		glamping1.agregarHabitacion(habitacionDoble23);

		Glamping glamping2 = new Glamping("Glamping de Montaña", "Monteverde", "Costa Rica", 5,
				"Una experiencia de lujo en la naturaleza",
				"Rural", 320000, "Observación de estrellas", "Servicio de masajes", "Paneles solares");
		hospedajes.add(glamping2);

		HabitacionBase habitacionBase24 = new HabitacionBase(2, true, 0, "Con baño privado");
		HabitacionDoble habitacionDoble24 = new HabitacionDoble(2, true, 20.0, "King");

		Glamping glamping3 = new Glamping("Glamping Ecológico", "El Chalten", "Argentina", 4,
				"Un glamping comprometido con el medio ambiente", "Rural", 230000, "Senderismo guiado",
				"Cocina gourmet", "Reciclaje");
		hospedajes.add(glamping3);

		HabitacionBase habitacionBase25 = new HabitacionBase(4, false, 0, "Con aire acondicionado");
		HabitacionDoble habitacionDoble25 = new HabitacionDoble(2, false, 30.0, "Matrimonial");

		Glamping glamping4 = new Glamping("Glamping Romántico", "Vietnam", "Vietnam", 4,
				"Un refugio íntimo para parejas",
				"Rural", 375000, "Paseos a caballo", "Baño de burbujas", "Energía renovable");
		hospedajes.add(glamping4);
		HabitacionBase habitacionBase26 = new HabitacionBase(3, true, 0, "Con televisor de pantalla plana");
		HabitacionDoble habitacionDoble26 = new HabitacionDoble(2, true, 22.0, "Doble");

		Glamping glamping5 = new Glamping("Glamping de Aventura", "Yosemite Valley", "Estados Unidos", 3,
				"Una experiencia única para los aventureros", "Rural", 275000, "Rutas en quad", "Barbacoa privada",
				"Gestión de residuos");
		hospedajes.add(glamping5);
		HabitacionBase habitacionBase27 = new HabitacionBase(2, true, 0, "Con minibar");
		HabitacionDoble habitacionDoble27 = new HabitacionDoble(2, false, 18.0, "Individual");

		Glamping glamping6 = new Glamping("Glamping Familiar", "Lofoten", "Noruega", 4,
				"Un glamping para disfrutar en familia",
				"Rural", 1200000, "Visita a granja local", "Actividades para niños", "Reutilización de agua");
		hospedajes.add(glamping6);

		HabitacionBase habitacionBase28 = new HabitacionBase(4, false, 0, "Con acceso para discapacitados");
		HabitacionDoble habitacionDoble28 = new HabitacionDoble(2, true, 35.0, "Suite");

		glamping2.agregarHabitacion(habitacionBase24);
		glamping3.agregarHabitacion(habitacionBase25);
		glamping4.agregarHabitacion(habitacionBase26);
		glamping5.agregarHabitacion(habitacionBase27);
		glamping6.agregarHabitacion(habitacionBase28);

		glamping2.agregarHabitacion(habitacionDoble24);
		glamping3.agregarHabitacion(habitacionDoble25);
		glamping4.agregarHabitacion(habitacionDoble26);
		glamping5.agregarHabitacion(habitacionDoble27);
		glamping6.agregarHabitacion(habitacionDoble28);

		/* Hotel */

		Hotel hotel1 = new Hotel("Hotel de Lujo", "Paris", "Francia", 5,
				"Una experiencia de alojamiento de primer nivel", "Urbano", 2500000, true, true);
		hospedajes.add(hotel1);
		HabitacionBase habitacionBase29 = new HabitacionBase(2, true, 0, "Con vistas al jardín");
		HabitacionBase habitacionBase30 = new HabitacionBase(2, true, 0, "Con baño privado");
		HabitacionBase habitacionBase31 = new HabitacionBase(1, false, 0, "Con aire acondicionado");
		HabitacionBase habitacionBase32 = new HabitacionBase(2, true, 0, "Con televisor de pantalla plana");
		HabitacionBase habitacionBase33 = new HabitacionBase(1, true, 0, "Con minibar");

		HabitacionDoble habitacionDoble29 = new HabitacionDoble(4, true, 150000, "Queen");
		HabitacionDoble habitacionDoble30 = new HabitacionDoble(5, true, 160000, "King");
		HabitacionDoble habitacionDoble31 = new HabitacionDoble(3, false, 140000, "Matrimonial");
		HabitacionDoble habitacionDoble32 = new HabitacionDoble(4, true, 150000, "Doble");
		HabitacionDoble habitacionDoble33 = new HabitacionDoble(4, false, 150000, "Individual");

		HabitacionPresidencial habitacionPresidencial1 = new HabitacionPresidencial(5, true, 350000,
				"Mayordomo personal");
		HabitacionPresidencial habitacionPresidencial2 = new HabitacionPresidencial(6, true, 350000, "Piscina privada");
		HabitacionPresidencial habitacionPresidencial3 = new HabitacionPresidencial(4, false, 350000, "Cocina gourmet");
		HabitacionPresidencial habitacionPresidencial4 = new HabitacionPresidencial(6, true, 350000,
				"Terraza panorámica");
		HabitacionPresidencial habitacionPresidencial5 = new HabitacionPresidencial(2, false, 350000, "Jacuzzi");

		HabitacionSuite habitacionSuite1 = new HabitacionSuite(4, true, 250000, "Spa privado");
		HabitacionSuite habitacionSuite2 = new HabitacionSuite(3, true, 250000, "Barra de bar");
		HabitacionSuite habitacionSuite3 = new HabitacionSuite(2, false, 250000, "Sala de cine");
		HabitacionSuite habitacionSuite4 = new HabitacionSuite(4, true, 250000, "Gimnasio privado");
		HabitacionSuite habitacionSuite5 = new HabitacionSuite(5, false, 250000, "Servicio de mayordomo");

		hotel1.agregarHabitacion(habitacionBase29);
		hotel1.agregarHabitacion(habitacionBase30);
		hotel1.agregarHabitacion(habitacionBase31);
		hotel1.agregarHabitacion(habitacionBase32);
		hotel1.agregarHabitacion(habitacionBase33);

		hotel1.agregarHabitacion(habitacionDoble29);
		hotel1.agregarHabitacion(habitacionDoble30);
		hotel1.agregarHabitacion(habitacionDoble31);
		hotel1.agregarHabitacion(habitacionDoble32);
		hotel1.agregarHabitacion(habitacionDoble33);

		hotel1.agregarHabitacion(habitacionPresidencial1);
		hotel1.agregarHabitacion(habitacionPresidencial2);
		hotel1.agregarHabitacion(habitacionPresidencial3);
		hotel1.agregarHabitacion(habitacionPresidencial4);
		hotel1.agregarHabitacion(habitacionPresidencial5);

		hotel1.agregarHabitacion(habitacionSuite1);
		hotel1.agregarHabitacion(habitacionSuite2);
		hotel1.agregarHabitacion(habitacionSuite3);
		hotel1.agregarHabitacion(habitacionSuite4);
		hotel1.agregarHabitacion(habitacionSuite5);

		Hotel hotel2 = new Hotel("Hotel Maximmo", "Melgar", "Colombia", 3, "Hotel hermoso", "urbano", 150000, true,
				true);
		hospedajes.add(hotel2);

		HabitacionBase habitacionBase34 = new HabitacionBase(2, true, 0, "Con vistas al jardín");
		HabitacionBase habitacionBase35 = new HabitacionBase(2, true, 0, "Con baño privado");
		HabitacionBase habitacionBase36 = new HabitacionBase(1, false, 0, "Con aire acondicionado");
		HabitacionBase habitacionBase37 = new HabitacionBase(2, true, 0, "Con televisor de pantalla plana");
		HabitacionBase habitacionBase38 = new HabitacionBase(1, true, 0, "Con minibar");

		HabitacionDoble habitacionDoble34 = new HabitacionDoble(4, true, 40000, "Queen");
		HabitacionDoble habitacionDoble35 = new HabitacionDoble(5, true, 40000, "King");
		HabitacionDoble habitacionDoble36 = new HabitacionDoble(3, false, 40000, "Matrimonial");
		HabitacionDoble habitacionDoble37 = new HabitacionDoble(4, true, 40000, "Doble");
		HabitacionDoble habitacionDoble38 = new HabitacionDoble(4, false, 40000, "Individual");

		hotel2.agregarHabitacion(habitacionBase34);
		hotel2.agregarHabitacion(habitacionBase35);
		hotel2.agregarHabitacion(habitacionBase36);
		hotel2.agregarHabitacion(habitacionBase37);
		hotel2.agregarHabitacion(habitacionBase38);

		hotel2.agregarHabitacion(habitacionDoble34);
		hotel2.agregarHabitacion(habitacionDoble35);
		hotel2.agregarHabitacion(habitacionDoble36);
		hotel2.agregarHabitacion(habitacionDoble37);
		hotel2.agregarHabitacion(habitacionDoble38);

		Hotel hotel3 = new Hotel("Hotel Ejecutivo", "Dubai", "Emiratos Arabes", 4,
				"Diseñado para satisfacer las necesidades de viajeros de negocios", "Urbano", 1500000, true, true);
		hospedajes.add(hotel3);

		HabitacionBase habitacionBase39 = new HabitacionBase(2, true, 0, "Con vistas al mar");
		HabitacionBase habitacionBase40 = new HabitacionBase(2, true, 0, "Con terraza privada");
		HabitacionBase habitacionBase41 = new HabitacionBase(1, false, 0, "Con jacuzzi");
		HabitacionBase habitacionBase42 = new HabitacionBase(2, true, 0, "Con caja fuerte");
		HabitacionBase habitacionBase43 = new HabitacionBase(1, true, 0, "Con jacuzzi");

		HabitacionDoble habitacionDoble39 = new HabitacionDoble(4, true, 250000, "Queen");
		HabitacionDoble habitacionDoble40 = new HabitacionDoble(5, true, 260000, "King");
		HabitacionDoble habitacionDoble41 = new HabitacionDoble(3, false, 240000, "Matrimonial");
		HabitacionDoble habitacionDoble42 = new HabitacionDoble(4, true, 250000, "Doble");
		HabitacionDoble habitacionDoble43 = new HabitacionDoble(4, false, 250000, "Individual");

		hotel3.agregarHabitacion(habitacionBase39);
		hotel3.agregarHabitacion(habitacionBase40);
		hotel3.agregarHabitacion(habitacionBase41);
		hotel3.agregarHabitacion(habitacionBase42);
		hotel3.agregarHabitacion(habitacionBase43);

		hotel3.agregarHabitacion(habitacionDoble39);
		hotel3.agregarHabitacion(habitacionDoble40);
		hotel3.agregarHabitacion(habitacionDoble41);
		hotel3.agregarHabitacion(habitacionDoble42);
		hotel3.agregarHabitacion(habitacionDoble43);

		Hotel hotel4 = new Hotel("Hotel Boutique", "Sidney", "Australia", 4,
				"Un hotel exclusivo con atención personalizada", "Urbano", 450000, true, false);
		hospedajes.add(hotel4);

		/* Moteles */
		Motel motel1 = new Motel("Motel Íntimo", "Las Vegas", "Estados Unidos", 3,
				"Un motel para momentos especiales",
				"Urbano", 200000, "Romántica", true, "Servicio a la habitación");
		Motel motel2 = new Motel("Motel Temático", "Cancun", "Mexico", 3,
				"Cada habitación con una temática diferente", "Urbano", 5000000, "Fantassía", true,
				"Desayuno incluido");
		Motel motel3 = new Motel("Motel de Lujo", "Bangkok", "Tailandia", 4, "Con instalaciones de primer nivel",
				"Urbano", 230000, "Elegante", true, "Spa privado");
		Motel motel4 = new Motel("Motel Clásico", "Berlin", "Alemania", 3, "Con un estilo retro y acogedor",
				"Urbano", 240000,
				"Clásica", false, "Bar en la habitación");

		hospedajes.add(motel1);
		hospedajes.add(motel2);
		hospedajes.add(motel3);
		hospedajes.add(motel4);

		/* Resort */
		Resort resort1 = new Resort("Resort de Lujo", "Punta Cana", "Republica Dominicana", 5,
				"Un resort de lujo en el centro de la ciudad",
				"Urbano", 420000, "Spa de clase mundial", "Piscina en la azotea");
		Resort resort2 = new Resort("Resort Familiar", "Maldivas", "Maldivas", 4,
				"Perfecto para vacaciones en familia",
				"Urbano", 380000, "Club infantil", "Parque acuático");
		Resort resort3 = new Resort("Resort Wellness", "Santorini", "Grecia", 5,
				"Para quienes buscan bienestar y relajación",
				"Urbano", 540000, "Yoga y meditación", "Circuitos de hidroterapia");
		Resort resort4 = new Resort("Resort de Negocios", "Bali", "Indonesia", 4,
				"Ideal para viajes de trabajo y eventos corporativos", "Urbano", 920000, "Salas de reuniones equipadas",
				"Centro de convenciones");
		hospedajes.add(resort1);
		hospedajes.add(resort2);
		hospedajes.add(resort3);
		hospedajes.add(resort4);

	}
}
