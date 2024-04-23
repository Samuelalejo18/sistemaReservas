package co.edu.konradlorenz.controller;

import java.util.ArrayList;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.model.Camping;
import co.edu.konradlorenz.model.Glamping;
import co.edu.konradlorenz.model.HabitacionBase;
import co.edu.konradlorenz.model.Hospedaje;
import co.edu.konradlorenz.model.Hotel;
import co.edu.konradlorenz.model.Motel;
import co.edu.konradlorenz.model.Resort;
import co.edu.konradlorenz.view.ViewHospedaje;

public class ControllerHospedajes {
	ArrayList<Hospedaje> hospedajes = new ArrayList<>();
	ViewHospedaje viewHospedaje = new ViewHospedaje();

	public ControllerHospedajes() {
	}

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
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getNombre().equalsIgnoreCase(nombre)) {
				// viewHospedaje.mostrarFiltros(hospedaje);
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				encontradoNombre = true;
				viewHospedaje.mostrarTitulo();
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo());
			}
		}
		if (!encontradoNombre) {
			ViewHospedaje.filtroFallido();
		}

	}

	public void filtrarCiudad(String ubicacionCiudad) {
		boolean encontradoCiudad = false;
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getUbicacionCiudad().equalsIgnoreCase(ubicacionCiudad)) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				encontradoCiudad = true;
				viewHospedaje.mostrarTitulo();
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo());
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
					hospedaje.getTipo());
		}
	}

	public void filtrarPorPais(String ubicacionPais) {
		boolean encontrado = false;
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getUbicacionPais().equalsIgnoreCase(ubicacionPais)) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				encontrado = true;
				viewHospedaje.mostrarTitulo();
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo());
			}
		}

		if (!encontrado) {
			ViewHospedaje.filtroFallido();
		}

	}

	public void filtrarPorNumeroDeEstrellas(int numeroDeEstrellas) {
		boolean encontradoEstrellas = false;
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getNumeroEstrellas() == numeroDeEstrellas) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				viewHospedaje.mostrarTitulo();
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo());
			}
		}

		if (!encontradoEstrellas) {
			ViewHospedaje.filtroFallido();
		}

	}

	// Tipo urbano o rural

	public void filtrarTipo(String tipo) {
		boolean encontradoTipo = false;
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getTipo().equalsIgnoreCase(tipo)) {
				encontradoTipo = true;
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				viewHospedaje.mostrarTitulo();
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo());

			}
		}
		if (!encontradoTipo) {
			ViewHospedaje.filtroFallido();
		}
	}

	// Tipo urbano o rural

	public void filtrarHoteles() {

		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Hotel) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				viewHospedaje.mostrarTitulo();
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo());

			}
		}

	}

	public void filtrarMoteles() {
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Motel) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				viewHospedaje.mostrarTitulo();
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo());

			}
		}
	}

	public void filtralResorts() {
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Resort) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				viewHospedaje.mostrarTitulo();
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo());

			}
		}
	}

	public void filtralCampings() {
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Camping) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				viewHospedaje.mostrarTitulo();
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo());

			}
		}
	}

	public void filtralGlampings() {
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Glamping) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				viewHospedaje.mostrarTitulo();
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo());

			}
		}
	}

	public void filtralCabanas() {
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje instanceof Cabana) {
				String tipoHospedaje = hallarTipoHospedaje(hospedaje);
				viewHospedaje.mostrarTitulo();
				ViewHospedaje.imprimirTabla(tipoHospedaje, hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo());

			}
		}
	}

	public void filtrarPorPrecio(int min, int max) {
		for (Hospedaje hospedaje : hospedajes) {

		}
	}

	public void registrarHospedajes() {

		/* Cabañas */
		Cabana cabana1 = new Cabana("Cabana las mercedes", "Villeta", "Colombia", 5, "Cabaña bonita", "Cabaña rural",
				230000, "Luces bonitas amarillas", false, "Baño frente a la cascada");
		hospedajes.add(cabana1);
		HabitacionBase habitacionBase1 = new HabitacionBase(2, true, "Wifi, TV, aire acondicionado");
		HabitacionDoble habitacionDoble1 = new HabitacionDoble(4, true, 50000, "Queen");


		cabana1.agregarHabitacion(habitacionBase1);
		cabana1.agregarHabitacion(habitacionDoble1);
		Cabana cabana2 = new Cabana("Cabana de Montaña", "Monterrey", "Mexico", 5,
				"Una acogedora cabaña en medio de las montañas", "Rural", 330000, "Rústica", true, "Senderismo");
		hospedajes.add(cabana2);

		Cabana cabana3 = new Cabana("Cabana de Playa", "Cancun", "Mexico", 4,
				"Un refugio junto al mar con vista panorámica", "Rural", 120000, "Tropical", false, "Surf");
		hospedajes.add(cabana3);

		Cabana cabana4 = new Cabana("Cabana en el Bosque", "Toronto", "Canada", 3,
				"Un retiro tranquilo rodeado de árboles centenarios", "Rural", 80000, "Vintage", true,
				"Observación de aves");
		hospedajes.add(cabana4);

		Cabana cabana5 = new Cabana("Cabana junto al Lago", "Medellin", "Colombia", 5,
				"Una cabaña con acceso directo al lago cristalino", "Rural", 220000, "Moderna", false, "Pesca");
		hospedajes.add(cabana5);

		Cabana cabana6 = new Cabana("Cabana de Aventura", "La vega", "Colombia", 4,
				"Una cabaña para los amantes de la adrenalina", "Rural", 170000, "Minimalista", true, "Escalada");
		hospedajes.add(cabana6);

		Cabana cabana7 = new Cabana("Cabana Histórica", "Villeta", "Colombia", 3,
				"Una cabaña con siglos de historia en su interior", "Rural", 60000, "Antigua", false,
				"Visitas guiadas");
		hospedajes.add(cabana7);

		Cabana cabana8 = new Cabana("Cabana de Campo", "Capitanejo", "Colombia", 5,
				"Un refugio campestre con todas las comodidades", "Rural", 230000);
		hospedajes.add(cabana8);

		Cabana cabana9 = new Cabana("Cabana Ecológica", "Anapoima", "Colombia", 4,
				"Una cabaña diseñada para minimizar su impacto ambiental", "Rural", 420000, "Sostenible", false,
				"Reciclaje");
		hospedajes.add(cabana9);

		Cabana cabana10 = new Cabana("Cabana Romántica", "Neusa", "Colombia", 3,
				"Un rincón íntimo para parejas en busca de tranquilidad", "Rural", 320000, "Acogedora", true,
				"Masajes");
		hospedajes.add(cabana10);

		Cabana cabana11 = new Cabana("Cabana de Lujo", "Anapoima", "Colombia", 5,
				"Una experiencia exclusiva con servicio de primera clase", "Rural", 230000, "Elegante", false,
				"Gastronomía gourmet");
		hospedajes.add(cabana11);

		/* Camping */
		hospedajes.add(
				new Camping("Camping de Montaña", "Ciudad del cabo", "Sudafrica", 5, "Un camping rodeado de montañas",
						"Rural", 420000, "Área de fogatas", "Senderismo"));
		hospedajes.add(new Camping("Camping junto al Río", "Banff", "Canada", 4, "Un camping con vista al río",
				"Rural", 320000, "Zona de barbacoa", "Pesca"));
		hospedajes.add(new Camping("Camping en el Bosque", "Berguen", "Noruega", 3, "Un camping entre árboles", "Rural",
				170000,
				"Piscina natural", "Observación de aves"));
		hospedajes.add(new Camping("Camping en la Playa", "Interlaken", "Suiza", 5, "Un camping cerca del mar", "Rural",
				720000,
				"Zona de descanso", "Surf"));
		hospedajes.add(
				new Camping("Camping Familiar", "Moab", "Estados Unidos", 4, "Un camping ideal para familias", "Rural",
						230000,
						"Parque infantil", "Excursiones"));
		hospedajes.add(new Camping("Camping de Aventura", "San Carlos De bariloche", "Argentina", 3,
				"Un camping para los amantes de la adrenalina", "Rural", 130000, "Pared de escalada", "Rafting"));
		hospedajes.add(new Camping("Camping Eco-Friendly", "Cairns", "Australia", 5,
				"Un camping comprometido con el medio ambiente", "Rural", 370000, "Reciclaje",
				"Observación de estrellas"));
		hospedajes.add(new Camping("Camping de Relax", "Queenstown", "Nueva Zelanda", 4,
				"Un camping para desconectar y relajarse",
				"Rural", 340000, "Área de meditación", "Yoga"));
		hospedajes.add(new Camping("Camping de Aventura Extrema", "Salzburgo", "Australia", 3,
				"Un camping para los más intrépidos", "Rural", 250000, "Tirolesa", "Escalada"));
		hospedajes.add(new Camping("Camping Romántico", "Glencoe", "Escocia", 5,
				"Un camping para parejas en busca de romance", "Rural", 1000000, "Área de picnic", "Paseos nocturnos"));
		hospedajes.add(new Camping("Camping las maravillas", "Anapoima", "Colombia", 3,
				"Camping con excelente ubicacion", "rural", 420000, "Cercano a parrillas comunitarias", "Yoga"));

		/* Glampings */
		hospedajes.add(new Glamping("Glamping donde Julian", "Guatape", "Colombia", 5,
				"Glamping perfecto para ir con tu pareja", "rural", 420000, "Vistas con mucha fauan", "Comida",
				"Todo es reciclable"));
		hospedajes.add(
				new Glamping("Glamping de Montaña", "Monteverde", "CostaRica", 5,
						"Una experiencia de lujo en la naturaleza",
						"Rural", 320000, "Observación de estrellas", "Servicio de masajes", "Paneles solares"));
		hospedajes.add(new Glamping("Glamping Ecológico", "El Chalten ", "Argentina", 4,
				"Un glamping comprometido con el medio ambiente", "Rural", 230000, "Senderismo guiado",
				"Cocina gourmet",
				"Reciclaje"));
		hospedajes.add(new Glamping("Glamping Romántico", "Vietnam", "Vietnam", 4, "Un refugio íntimo para parejas",
				"Rural", 375000, "Paseos a caballo", "Baño de burbujas", "Energía renovable"));
		hospedajes.add(new Glamping("Glamping de Aventura", "Yosemite Valley", "Estados Unidos", 3,
				"Una experiencia única para los aventureros", "Rural", 275000, "Rutas en quad", "Barbacoa privada",
				"Gestión de residuos"));
		hospedajes
				.add(new Glamping("Glamping Familiar", "Lofoten", "Noruega", 4, "Un glamping para disfrutar en familia",
						"Rural", 1200000, "Visita a granja local", "Actividades para niños", "Reutilización de agua"));

		/* Hotel */
		hospedajes.add(
				new Hotel("Hotel Maximmo", "Melgar", "Colombia", 3, "Hotel hermoso", "urbano", 150000, true, true));
		hospedajes.add(new Hotel("Hotel de Lujo", "Paris", "Francia", 5,
				"Una experiencia de alojamiento de primer nivel", "Urbano", 550000, true, true));
		hospedajes.add(new Hotel("Hotel Ejecutivo", "Dubai", "Emiratos Arabes", 4,
				"Diseñado para satisfacer las necesidades de viajeros de negocios", "Urbano", 820000, true, true));
		hospedajes.add(new Hotel("Hotel Boutique", "Sidney", "Australia", 4,
				"Un hotel exclusivo con atención personalizada", "Urbano", 450000, true, false));

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
