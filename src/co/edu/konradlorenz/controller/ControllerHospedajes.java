package co.edu.konradlorenz.controller;

import java.util.ArrayList;

import co.edu.konradlorenz.model.Cabana;
import co.edu.konradlorenz.model.Camping;
import co.edu.konradlorenz.model.Glamping;
import co.edu.konradlorenz.model.HabitacionBase;
import co.edu.konradlorenz.model.HabitacionDoble;
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
		HabitacionBase habitacionBase2 = new HabitacionBase(2, true, "Wifi, TV, Minibar");
		HabitacionDoble habitacionDoble2 = new HabitacionDoble(4, true, 60000, "King");
		cabana2.agregarHabitacion(habitacionBase2);
		cabana2.agregarHabitacion(habitacionDoble2);

		Cabana cabana3 = new Cabana("Cabana de Playa", "Cancun", "Mexico", 4,
				"Un refugio junto al mar con vista panorámica", "Rural", 120000, "Tropical", false, "Surf");
		hospedajes.add(cabana3);
		HabitacionBase habitacionBase3 = new HabitacionBase(1, false, "Wifi, TV, Balcón");
		HabitacionDoble habitacionDoble3 = new HabitacionDoble(2, false, 700000, "Matrimonial");
		cabana3.agregarHabitacion(habitacionBase3);
		cabana3.agregarHabitacion(habitacionDoble3);

		Cabana cabana4 = new Cabana("Cabana en el Bosque", "Toronto", "Canada", 3,
				"Un retiro tranquilo rodeado de árboles centenarios", "Rural", 80000, "Vintage", true,
				"Observación de aves");
		hospedajes.add(cabana4);
		HabitacionBase habitacionBase4 = new HabitacionBase(2, true, "Wifi, TV");
		HabitacionDoble habitacionDoble4 = new HabitacionDoble(4, true, 40000, "Queen");

		cabana4.agregarHabitacion(habitacionBase4);
		cabana4.agregarHabitacion(habitacionDoble4);

		Cabana cabana5 = new Cabana("Cabana junto al Lago", "Medellin", "Colombia", 5,
				"Una cabaña con acceso directo al lago cristalino", "Rural", 220000, "Moderna", false, "Pesca");
		hospedajes.add(cabana5);

		HabitacionBase habitacionBase5 = new HabitacionBase(2, false, "Wifi, TV, Escritorio");
		HabitacionDoble habitacionDoble5 = new HabitacionDoble(3, false, 80000, "King");
		cabana5.agregarHabitacion(habitacionBase5);
		cabana5.agregarHabitacion(habitacionDoble5);

		Cabana cabana6 = new Cabana("Cabana de Aventura", "La vega", "Colombia", 4,
				"Una cabaña para los amantes de la adrenalina", "Rural", 170000, "Minimalista", true, "Escalada");
		hospedajes.add(cabana6);

		HabitacionBase habitacionBase6 = new HabitacionBase(2, true, "Wifi, TV, Baño privado");
		HabitacionDoble habitacionDoble6 = new HabitacionDoble(2, true, 55000, "Matrimonial");

		cabana6.agregarHabitacion(habitacionBase6);
		cabana6.agregarHabitacion(habitacionDoble6);

		Cabana cabana7 = new Cabana("Cabana Histórica", "Villeta", "Colombia", 3,
				"Una cabaña con siglos de historia en su interior", "Rural", 60000, "Antigua", false,
				"Visitas guiadas");
		hospedajes.add(cabana7);

		HabitacionBase habitacionBase7 = new HabitacionBase(4, true, "Wifi, TV, Cocina");
		HabitacionDoble habitacionDoble7 = new HabitacionDoble(2, true, 30000, "Queen");
		cabana7.agregarHabitacion(habitacionBase7 );
		cabana7.agregarHabitacion(habitacionDoble7);

		Cabana cabana8 = new Cabana("Cabana de Campo", "Capitanejo", "Colombia", 5,
				"Un refugio campestre con todas las comodidades", "Rural", 230000);
		hospedajes.add(cabana8);
		HabitacionBase habitacionBase8 = new HabitacionBase(2, false, "Wifi, TV, Aire acondicionado");
		HabitacionDoble habitacionDoble8 = new HabitacionDoble(2, false, 28.0, "King");

		Cabana cabana9 = new Cabana("Cabana Ecológica", "Anapoima", "Colombia", 4,
				"Una cabaña diseñada para minimizar su impacto ambiental", "Rural", 420000, "Sostenible", false,
				"Reciclaje");
		hospedajes.add(cabana9);

		HabitacionBase habitacionBase9 = new HabitacionBase(3, true, "Wifi, TV, Caja fuerte");
		HabitacionDoble habitacionDoble9 = new HabitacionDoble(2, true, 25.0, "Matrimonial");

		Cabana cabana10 = new Cabana("Cabana Romántica", "Neusa", "Colombia", 3,
				"Un rincón íntimo para parejas en busca de tranquilidad", "Rural", 320000, "Acogedora", true,
				"Masajes");
		hospedajes.add(cabana10);
		HabitacionBase habitacionBase10 = new HabitacionBase(2, true, "Wifi, TV, Jacuzzi");
		HabitacionDoble habitacionDoble10 = new HabitacionDoble(2, true, 40.0, "Queen");

		Cabana cabana11 = new Cabana("Cabana de Lujo", "Anapoima", "Colombia", 5,
				"Una experiencia exclusiva con servicio de primera clase", "Rural", 230000, "Elegante", false,
				"Gastronomía gourmet");
		hospedajes.add(cabana11);

		HabitacionBase habitacionBase11 = new HabitacionBase(2, true, "Wifi, TV, Jacuzzi");
		HabitacionDoble habitacionDoble11 = new HabitacionDoble(2, false, 30.0, "King");

		/* Camping */
		Camping camping1 = new Camping("Camping de Montaña", "Ciudad del cabo", "Sudafrica", 5,
				"Un camping rodeado de montañas",
				"Rural", 420000, "Área de fogatas", "Senderismo");

		Camping camping2 = new Camping("Camping junto al Río", "Banff", "Canada", 4, "Un camping con vista al río",
				"Rural", 320000, "Zona de barbacoa", "Pesca");

		Camping camping3 = new Camping("Camping en el Bosque", "Berguen", "Noruega", 3, "Un camping entre árboles",
				"Rural",
				170000, "Piscina natural", "Observación de aves");

		Camping camping4 = new Camping("Camping en la Playa", "Interlaken", "Suiza", 5, "Un camping cerca del mar",
				"Rural",
				720000, "Zona de descanso", "Surf");

		Camping camping5 = new Camping("Camping Familiar", "Moab", "Estados Unidos", 4,
				"Un camping ideal para familias", "Rural",
				230000, "Parque infantil", "Excursiones");

		Camping camping6 = new Camping("Camping de Aventura", "San Carlos De bariloche", "Argentina", 3,
				"Un camping para los amantes de la adrenalina", "Rural", 130000, "Pared de escalada", "Rafting");

		Camping camping7 = new Camping("Camping Eco-Friendly", "Cairns", "Australia", 5,
				"Un camping comprometido con el medio ambiente", "Rural", 370000, "Reciclaje",
				"Observación de estrellas");

		Camping camping8 = new Camping("Camping de Relax", "Queenstown", "Nueva Zelanda", 4,
				"Un camping para desconectar y relajarse", "Rural", 340000, "Área de meditación", "Yoga");

		Camping camping9 = new Camping("Camping de Aventura Extrema", "Salzburgo", "Australia", 3,
				"Un camping para los más intrépidos", "Rural", 250000, "Tirolesa", "Escalada");

		Camping camping10 = new Camping("Camping Romántico", "Glencoe", "Escocia", 5,
				"Un camping para parejas en busca de romance", "Rural", 1000000, "Área de picnic", "Paseos nocturnos");

		Camping camping11 = new Camping("Camping las maravillas", "Anapoima", "Colombia", 3,
				"Camping con excelente ubicacion", "rural", 420000, "Cercano a parrillas comunitarias", "Yoga");

		hospedajes.add(camping1);
		hospedajes.add(camping2);
		hospedajes.add(camping3);
		hospedajes.add(camping4);
		hospedajes.add(camping5);
		hospedajes.add(camping6);
		hospedajes.add(camping7);
		hospedajes.add(camping8);
		hospedajes.add(camping9);
		hospedajes.add(camping10);
		hospedajes.add(camping11);

		/* Glampings */

		Glamping glamping1 = new Glamping("Glamping donde Julian", "Guatape", "Colombia", 5,
				"Glamping perfecto para ir con tu pareja", "rural", 420000, "Vistas con mucha fauna", "Comida",
				"Todo es reciclable");

		Glamping glamping2 = new Glamping("Glamping de Montaña", "Monteverde", "Costa Rica", 5,
				"Una experiencia de lujo en la naturaleza",
				"Rural", 320000, "Observación de estrellas", "Servicio de masajes", "Paneles solares");

		Glamping glamping3 = new Glamping("Glamping Ecológico", "El Chalten", "Argentina", 4,
				"Un glamping comprometido con el medio ambiente", "Rural", 230000, "Senderismo guiado",
				"Cocina gourmet", "Reciclaje");

		Glamping glamping4 = new Glamping("Glamping Romántico", "Vietnam", "Vietnam", 4,
				"Un refugio íntimo para parejas",
				"Rural", 375000, "Paseos a caballo", "Baño de burbujas", "Energía renovable");

		Glamping glamping5 = new Glamping("Glamping de Aventura", "Yosemite Valley", "Estados Unidos", 3,
				"Una experiencia única para los aventureros", "Rural", 275000, "Rutas en quad", "Barbacoa privada",
				"Gestión de residuos");

		Glamping glamping6 = new Glamping("Glamping Familiar", "Lofoten", "Noruega", 4,
				"Un glamping para disfrutar en familia",
				"Rural", 1200000, "Visita a granja local", "Actividades para niños", "Reutilización de agua");

		hospedajes.add(glamping1);

		hospedajes.add(glamping2);

		hospedajes.add(glamping3);

		hospedajes.add(glamping4);

		hospedajes.add(glamping5);

		hospedajes.add(glamping6);

		/* Hotel */
		Hotel hotel1 = new Hotel("Hotel Maximmo", "Melgar", "Colombia", 3, "Hotel hermoso", "urbano", 150000, true,
				true);

		Hotel hotel2 = new Hotel("Hotel de Lujo", "Paris", "Francia", 5,
				"Una experiencia de alojamiento de primer nivel", "Urbano", 550000, true, true);

		Hotel hotel3 = new Hotel("Hotel Ejecutivo", "Dubai", "Emiratos Arabes", 4,
				"Diseñado para satisfacer las necesidades de viajeros de negocios", "Urbano", 820000, true, true);

		Hotel hotel4 = new Hotel("Hotel Boutique", "Sidney", "Australia", 4,
				"Un hotel exclusivo con atención personalizada", "Urbano", 450000, true, false);
		hospedajes.add(hotel1);
		hospedajes.add(hotel2);
		hospedajes.add(hotel3);
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
