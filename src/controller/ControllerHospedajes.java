package controller;

import java.util.ArrayList;

import model.Cabana;
import model.Camping;
import model.Glamping;
import model.Habitacion;
import model.Hospedaje;
import model.Hotel;
import model.Motel;
import model.Piso;
import model.Resort;
import view.ViewHospedaje;

public class ControllerHospedajes {
	ArrayList<Hospedaje> hospedajes = new ArrayList<>();
	ViewHospedaje viewHospedaje = new ViewHospedaje();

	public ControllerHospedajes() {
	}

	public void setViewHospedaje(ViewHospedaje viewHospedaje) {
		this.viewHospedaje = viewHospedaje;
	}

	public void buscarPorNombre(String nombre) {
		registrarHospedajes();
		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getNombre().equals(nombre)) {
				ViewHospedaje.imprimirTabla(hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo());
			}
		}
	}

	public ArrayList<Hospedaje> filtrarPorUbicacionCiudad(String ubicacionCiudad) {
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getUbicacionCiudad() == ubicacionCiudad) {
				return hospedajes;
			} else {
				return null;
			}
		}
		return hospedajes;

	}

	public void hospedajesDisponibles() {
		registrarHospedajes();
		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			ViewHospedaje.imprimirTabla(hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
					hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
					hospedaje.getTipo());
		}
	}

	public ArrayList<Hospedaje> filtrarPorUbicacionPais(String ubicacionPais) {
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getUbicacionPais() == ubicacionPais) {
				return hospedajes;
			} else {
				return null;
			}
		}
		return hospedajes;
	}

	public ArrayList<Hospedaje> filtrarPorNumeroDeEstrellas(int numeroDeEstrellas) {
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getNumeroEstrellas() == numeroDeEstrellas) {
				return hospedajes;
			} else {
				return null;
			}
		}
		return hospedajes;

	}

	public ArrayList<Hospedaje> filtrarTipoHospedaje(String tipo) {
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getTipo() == tipo) {
				return hospedajes;
			} else {
				return null;
			}
		}
		return hospedajes;
	}

	public void registrarHospedajes() {

		/* Cabañas */
		hospedajes.add(new Cabana("Cabaña las mercedes", "Villeta", "Colombia", 5, "Cabaña bonita", "Cabaña rural",
				"Luces bonitas amarillas", false, "Baño frente a la cascada"));
		hospedajes.add(new Cabana("Cabana de Montaña", "Ciudad1", "Pais1", 5,
				"Una acogedora cabaña en medio de las montañas", "Rural", "Rústica", true, "Senderismo"));
		hospedajes.add(new Cabana("Cabana de Playa", "Ciudad2", "Pais2", 4,
				"Un refugio junto al mar con vista panorámica", "Rural", "Tropical", false, "Surf"));
		hospedajes.add(new Cabana("Cabana en el Bosque", "Ciudad3", "Pais3", 3,
				"Un retiro tranquilo rodeado de árboles centenarios", "Rural", "Vintage", true, "Observación de aves"));
		hospedajes.add(new Cabana("Cabana junto al Lago", "Ciudad4", "Pais4", 5,
				"Una cabaña con acceso directo al lago cristalino", "Rural", "Moderna", false, "Pesca"));
		hospedajes.add(new Cabana("Cabana de Aventura", "Ciudad5", "Pais5", 4,
				"Una cabaña para los amantes de la adrenalina", "Rural", "Minimalista", true, "Escalada"));
		hospedajes.add(new Cabana("Cabana Histórica", "Ciudad6", "Pais6", 3,
				"Una cabaña con siglos de historia en su interior", "Rural", "Antigua", false, "Visitas guiadas"));
		hospedajes.add(new Cabana("Cabana de Campo", "Ciudad7", "Pais7", 5,
				"Un refugio campestre con todas las comodidades", "Rural", "Rural", true, "Equitación"));
		hospedajes.add(new Cabana("Cabana Ecológica", "Ciudad8", "Pais8", 4,
				"Una cabaña diseñada para minimizar su impacto ambiental", "Rural", "Sostenible", false, "Reciclaje"));
		hospedajes.add(new Cabana("Cabana Romántica", "Ciudad9", "Pais9", 3,
				"Un rincón íntimo para parejas en busca de tranquilidad", "Rural", "Acogedora", true, "Masajes"));
		hospedajes.add(new Cabana("Cabana de Lujo", "Ciudad10", "Pais10", 5,
				"Una experiencia exclusiva con servicio de primera clase", "Rural", "Elegante", false,
				"Gastronomía gourmet"));

		/* Camping */
		hospedajes.add(new Camping("Camping de Montaña", "Ciudad1", "Pais1", 5, "Un camping rodeado de montañas",
				"Rural", "Área de fogatas", "Senderismo"));
		hospedajes.add(new Camping("Camping junto al Río", "Ciudad2", "Pais2", 4, "Un camping con vista al río",
				"Rural", "Zona de barbacoa", "Pesca"));
		hospedajes.add(new Camping("Camping en el Bosque", "Ciudad3", "Pais3", 3, "Un camping entre árboles", "Rural",
				"Piscina natural", "Observación de aves"));
		hospedajes.add(new Camping("Camping en la Playa", "Ciudad4", "Pais4", 5, "Un camping cerca del mar", "Rural",
				"Zona de descanso", "Surf"));
		hospedajes.add(new Camping("Camping Familiar", "Ciudad5", "Pais5", 4, "Un camping ideal para familias", "Rural",
				"Parque infantil", "Excursiones"));
		hospedajes.add(new Camping("Camping de Aventura", "Ciudad6", "Pais6", 3,
				"Un camping para los amantes de la adrenalina", "Rural", "Pared de escalada", "Rafting"));
		hospedajes.add(new Camping("Camping Eco-Friendly", "Ciudad7", "Pais7", 5,
				"Un camping comprometido con el medio ambiente", "Rural", "Reciclaje", "Observación de estrellas"));
		hospedajes.add(new Camping("Camping de Relax", "Ciudad8", "Pais8", 4, "Un camping para desconectar y relajarse",
				"Rural", "Área de meditación", "Yoga"));
		hospedajes.add(new Camping("Camping de Aventura Extrema", "Ciudad9", "Pais9", 3,
				"Un camping para los más intrépidos", "Rural", "Tirolesa", "Escalada"));
		hospedajes.add(new Camping("Camping Romántico", "Ciudad10", "Pais10", 5,
				"Un camping para parejas en busca de romance", "Rural", "Área de picnic", "Paseos nocturnos"));
		hospedajes.add(new Camping("Camping las maravillas", "Anapoima", "Colombia", 3,
				"Camping con excelente ubicacion", "rural", "Cercano a parrillas comunitarias", "Yoga"));

		/* Glampings */
		hospedajes.add(new Glamping("Glamping donde Julian", "Guatape", "Colombia", 5,
				"Glamping perfecto para ir con tu pareja", "rural", "Vistas con mucha fauan", "Comida",
				"Todo es reciclable"));
		hospedajes.add(
				new Glamping("Glamping de Montaña", "Ciudad6", "Pais6", 5, "Una experiencia de lujo en la naturaleza",
						"Rural", "Observación de estrellas", "Servicio de masajes", "Paneles solares"));
		hospedajes.add(new Glamping("Glamping Ecológico", "Ciudad7", "Pais7", 4,
				"Un glamping comprometido con el medio ambiente", "Rural", "Senderismo guiado", "Cocina gourmet",
				"Reciclaje"));
		hospedajes.add(new Glamping("Glamping Romántico", "Ciudad8", "Pais8", 4, "Un refugio íntimo para parejas",
				"Rural", "Paseos a caballo", "Baño de burbujas", "Energía renovable"));
		hospedajes.add(new Glamping("Glamping de Aventura", "Ciudad9", "Pais9", 3,
				"Una experiencia única para los aventureros", "Rural", "Rutas en quad", "Barbacoa privada",
				"Gestión de residuos"));
		hospedajes
				.add(new Glamping("Glamping Familiar", "Ciudad10", "Pais10", 4, "Un glamping para disfrutar en familia",
						"Rural", "Visita a granja local", "Actividades para niños", "Reutilización de agua"));

		/* Hotel */
		Hotel hotel1 = new Hotel("Hotel Maximmo", "Melgar", "Colombia", 3, 3, "Hotel hermoso", "urbano", true, true);
		Hotel hotel2 = new Hotel("Hotel Central", "Ciudad1", "Pais1", 5, 4, "El hotel más céntrico de la ciudad",
				"Urbano", true, true);
		Hotel hotel3 = new Hotel("Hotel de Lujo", "Ciudad2", "Pais2", 5, 2,
				"Una experiencia de alojamiento de primer nivel", "Urbano", true, true);
		Hotel hotel4 = new Hotel("Hotel Ejecutivo", "Ciudad3", "Pais3", 4, 5,
				"Diseñado para satisfacer las necesidades de viajeros de negocios", "Urbano", true, true);
		Hotel hotel5 = new Hotel("Hotel Boutique", "Ciudad4", "Pais4", 4, 6,
				"Un hotel exclusivo con atención personalizada", "Urbano", true, false);

		/* hotel 1 */
		hospedajes.add(hotel1);
		Piso piso1 = new Piso(5);
		Piso piso2 = new Piso(5);
		Piso piso3 = new Piso(6);
		hotel1.agregarPiso(piso1);
		piso1.agregarHabitacion(new Habitacion("Doble", 2, true, 100.0));
		piso1.agregarHabitacion(new Habitacion("Doble", 2, true, 100.0));
		piso1.agregarHabitacion(new Habitacion("Individual", 1, true, 80.0));
		piso1.agregarHabitacion(new Habitacion("Suite", 4, true, 200.0));
		piso1.agregarHabitacion(new Habitacion("Familiar", 6, true, 250.0));

		hotel1.agregarPiso(piso2);
		piso2.agregarHabitacion(new Habitacion("Doble", 2, true, 120.0));
		piso2.agregarHabitacion(new Habitacion("Doble", 2, true, 120.0));
		piso2.agregarHabitacion(new Habitacion("Individual", 1, true, 100.0));
		piso2.agregarHabitacion(new Habitacion("Suite", 4, true, 240.0));
		piso2.agregarHabitacion(new Habitacion("Familiar", 6, true, 280.0));

		hotel1.agregarPiso(piso3);
		piso3.agregarHabitacion(new Habitacion("Doble", 2, true, 130.0));
		piso3.agregarHabitacion(new Habitacion("Doble", 2, true, 130.0));
		piso3.agregarHabitacion(new Habitacion("Individual", 1, true, 110.0));
		piso3.agregarHabitacion(new Habitacion("Suite", 4, true, 260.0));
		piso3.agregarHabitacion(new Habitacion("Familiar", 6, true, 300.0));


		/*Hotel 2 */
		hospedajes.add(hotel2);
		Piso piso1Hotel2 = new Piso(3);
		Piso piso2Hotel2 = new Piso(2);
		Piso piso3Hotel2 = new Piso(2);
		Piso piso4Hotel2 = new Piso(1);
		hotel2.agregarPiso(piso1Hotel2);
		piso1Hotel2.agregarHabitacion(new Habitacion("Doble", 2, true, 100.0));
		piso1Hotel2.agregarHabitacion(new Habitacion("Doble", 2, true, 100.0));
		piso1Hotel2.agregarHabitacion(new Habitacion("Individual", 1, true, 80.0));
		
		hotel2.agregarPiso(piso2Hotel2);
		piso2Hotel2.agregarHabitacion(new Habitacion("Doble", 2, true, 120.0));
		piso2Hotel2.agregarHabitacion(new Habitacion("Doble", 2, true, 120.0));
		

		hotel2.agregarPiso(piso3Hotel2);
		piso3Hotel2.agregarHabitacion(new Habitacion("Doble", 2, true, 130.0));
		piso3Hotel2.agregarHabitacion(new Habitacion("Doble", 2, true, 130.0));
		
		hotel2.agregarPiso(piso4Hotel2);
		piso4Hotel2.agregarHabitacion(new Habitacion("Suite", 4, true, 200.0));
		

		hospedajes.add(hotel3);
		hospedajes.add(hotel4);
		hospedajes.add(hotel5);

		/* Moteles */
		Motel motel1 = new Motel("Motel Íntimo", "Ciudad1", "Pais1", 3, 2, "Un motel para momentos especiales",
				"Urbano", "Romántica", true, "Servicio a la habitación");
		Motel motel2 = new Motel("Motel Temático", "Ciudad2", "Pais2", 3, 2,
				"Cada habitación con una temática diferente", "Urbano", "Fantasía", true, "Desayuno incluido");
		Motel motel3 = new Motel("Motel de Lujo", "Ciudad3", "Pais3", 4, 3, "Con instalaciones de primer nivel",
				"Urbano", "Elegante", true, "Spa privado");
		Motel motel4 = new Motel("Motel Clásico", "Ciudad4", "Pais4", 3, 2, "Con un estilo retro y acogedor", "Urbano",
				"Clásica", false, "Bar en la habitación");
		

		hospedajes.add(motel1);
		hospedajes.add(motel2);
		hospedajes.add(motel3);
		hospedajes.add(motel4);


		/* Resort */
		Resort resort1 = new Resort("Resort de Lujo", "Ciudad1", "Pais1", 5, 10,
				"Un resort de lujo en el centro de la ciudad",
				"Urbano", "Spa de clase mundial", "Piscina en la azotea");
		Resort resort2 = new Resort("Resort Familiar", "Ciudad2", "Pais2", 4, 8, "Perfecto para vacaciones en familia",
				"Urbano", "Club infantil", "Parque acuático");
		Resort resort3 = new Resort("Resort Wellness", "Ciudad3", "Pais3", 5, 12,
				"Para quienes buscan bienestar y relajación",
				"Urbano", "Yoga y meditación", "Circuitos de hidroterapia");
		Resort resort4 = new Resort("Resort de Negocios", "Ciudad4", "Pais4", 4, 6,
				"Ideal para viajes de trabajo y eventos corporativos", "Urbano", "Salas de reuniones equipadas",
				"Centro de convenciones");
	

		hospedajes.add(resort1);
		hospedajes.add(resort2);
		hospedajes.add(resort3);
		hospedajes.add(resort4);
	
	}
}
