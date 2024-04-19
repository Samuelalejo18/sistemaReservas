package co.edu.konradLorenz.controller;

import java.util.ArrayList;

import co.edu.konradLorenz.model.Cabana;
import co.edu.konradLorenz.model.Camping;
import co.edu.konradLorenz.model.Glamping;
import co.edu.konradLorenz.model.Habitacion;
import co.edu.konradLorenz.model.Hospedaje;
import co.edu.konradLorenz.model.Hotel;
import co.edu.konradLorenz.model.Motel;

import co.edu.konradLorenz.model.Resort;
import co.edu.konradLorenz.view.ViewHospedaje;

public class ControllerHospedajes {
	ArrayList<Hospedaje> hospedajes = new ArrayList<>();
	ViewHospedaje viewHospedaje = new ViewHospedaje();

	public ControllerHospedajes() {
	}

	public void buscarPorNombre(String nombre) {

		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getNombre().equals(nombre)) {
				// viewHospedaje.mostrarFiltros(hospedaje);
				viewHospedaje.mostrarTitulo();
				ViewHospedaje.imprimirTabla(hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo());
			}
		}

	}

	public void filtrarPorUbicacionCiudad(String ubicacionCiudad) {
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getUbicacionCiudad() == ubicacionCiudad) {
				viewHospedaje.mostrarTitulo();
				ViewHospedaje.imprimirTabla(hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo());
			}
		}

	}

	public void hospedajesDisponibles() {

		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			ViewHospedaje.imprimirTabla(hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
					hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
					hospedaje.getTipo());
		}
	}

	public void filtrarPorUbicacionPais(String ubicacionPais) {
		viewHospedaje.mostrarTitulo();
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getUbicacionPais() == ubicacionPais) {

				ViewHospedaje.imprimirTabla(hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo());
			}
		}

	}

	public void filtrarPorNumeroDeEstrellas(int numeroDeEstrellas) {

		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getNumeroEstrellas() == numeroDeEstrellas) {
				viewHospedaje.mostrarTitulo();
				ViewHospedaje.imprimirTabla(hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
						hospedaje.getUbicacionPais(), hospedaje.getNumeroEstrellas(), hospedaje.getDescripcion(),
						hospedaje.getTipo());
			}
		}

	}

	public void filtrarTipoHospedaje(String tipo) {
		for (Hospedaje hospedaje : hospedajes) {
			if (hospedaje.getTipo() == tipo) {
				viewHospedaje.mostrarTitulo();
				ViewHospedaje.imprimirTabla(hospedaje.getNombre(), hospedaje.getUbicacionCiudad(),
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
		hospedajes.add(new Cabana("Cabana las mercedes", "Villeta", "Colombia", 5, "Cabaña bonita", "Cabaña rural",
				"Luces bonitas amarillas", false, "Baño frente a la cascada"));
		hospedajes.add(new Cabana("Cabana de Montaña", "Monterrey", "Mexico", 5,
				"Una acogedora cabaña en medio de las montañas", "Rural", "Rústica", true, "Senderismo"));
		hospedajes.add(new Cabana("Cabana de Playa", "Cancun", "Mexico", 4,
				"Un refugio junto al mar con vista panorámica", "Rural", "Tropical", false, "Surf"));
		hospedajes.add(new Cabana("Cabana en el Bosque", "Toronto", "Canada", 3,
				"Un retiro tranquilo rodeado de árboles centenarios", "Rural", "Vintage", true, "Observación de aves"));
		hospedajes.add(new Cabana("Cabana junto al Lago", "Medellin", "Colombia", 5,
				"Una cabaña con acceso directo al lago cristalino", "Rural", "Moderna", false, "Pesca"));
		hospedajes.add(new Cabana("Cabana de Aventura", "La vega", "Colombia", 4,
				"Una cabaña para los amantes de la adrenalina", "Rural", "Minimalista", true, "Escalada"));
		hospedajes.add(new Cabana("Cabana Histórica", "Villeta", "Colombia", 3,
				"Una cabaña con siglos de historia en su interior", "Rural", "Antigua", false, "Visitas guiadas"));
		hospedajes.add(new Cabana("Cabana de Campo", "Capitanejo", "Colombia", 5,
				"Un refugio campestre con todas las comodidades", "Rural", "Rural", true, "Equitación"));
		hospedajes.add(new Cabana("Cabana Ecológica", "Anapoima", "Colombia", 4,
				"Una cabaña diseñada para minimizar su impacto ambiental", "Rural", "Sostenible", false, "Reciclaje"));
		hospedajes.add(new Cabana("Cabana Romántica", "Neusa", "Colombia", 3,
				"Un rincón íntimo para parejas en busca de tranquilidad", "Rural", "Acogedora", true, "Masajes"));
		hospedajes.add(new Cabana("Cabana de Lujo", "Anapoima", "Colombia", 5,
				"Una experiencia exclusiva con servicio de primera clase", "Rural", "Elegante", false,
				"Gastronomía gourmet"));

		/* Camping */
		hospedajes.add(new Camping("Camping de Montaña", "Ciudad del cabo", "Sudafrica", 5,
				"Un camping rodeado de montañas", "Rural", "Área de fogatas", "Senderismo"));
		hospedajes.add(new Camping("Camping junto al Río", "Banff", "Canada", 4, "Un camping con vista al río", "Rural",
				"Zona de barbacoa", "Pesca"));
		hospedajes.add(new Camping("Camping en el Bosque", "Berguen", "Noruega", 3, "Un camping entre árboles", "Rural",
				"Piscina natural", "Observación de aves"));
		hospedajes.add(new Camping("Camping en la Playa", "Interlaken", "Suiza", 5, "Un camping cerca del mar", "Rural",
				"Zona de descanso", "Surf"));
		hospedajes.add(new Camping("Camping Familiar", "Moab", "Estados Unidos", 4, "Un camping ideal para familias",
				"Rural", "Parque infantil", "Excursiones"));
		hospedajes.add(new Camping("Camping de Aventura", "San Carlos De bariloche", "Argentina", 3,
				"Un camping para los amantes de la adrenalina", "Rural", "Pared de escalada", "Rafting"));
		hospedajes.add(new Camping("Camping Eco-Friendly", "Cairns", "Australia", 5,
				"Un camping comprometido con el medio ambiente", "Rural", "Reciclaje", "Observación de estrellas"));
		hospedajes.add(new Camping("Camping de Relax", "Queenstown", "Nueva Zelanda", 4,
				"Un camping para desconectar y relajarse", "Rural", "Área de meditación", "Yoga"));
		hospedajes.add(new Camping("Camping de Aventura Extrema", "Salzburgo", "Australia", 3,
				"Un camping para los más intrépidos", "Rural", "Tirolesa", "Escalada"));
		hospedajes.add(new Camping("Camping Romántico", "Glencoe", "Escocia", 5,
				"Un camping para parejas en busca de romance", "Rural", "Área de picnic", "Paseos nocturnos"));
		hospedajes.add(new Camping("Camping las maravillas", "Anapoima", "Colombia", 3,
				"Camping con excelente ubicacion", "rural", "Cercano a parrillas comunitarias", "Yoga"));

		/* Glampings */
		hospedajes.add(new Glamping("Glamping donde Julian", "Guatape", "Colombia", 5,
				"Glamping perfecto para ir con tu pareja", "rural", "Vistas con mucha fauan", "Comida",
				"Todo es reciclable"));
		hospedajes.add(new Glamping("Glamping de Montaña", "Monteverde", "CostaRica", 5,
				"Una experiencia de lujo en la naturaleza", "Rural", "Observación de estrellas", "Servicio de masajes",
				"Paneles solares"));
		hospedajes.add(new Glamping("Glamping Ecológico", "El Chalten ", "Argentina", 4,
				"Un glamping comprometido con el medio ambiente", "Rural", "Senderismo guiado", "Cocina gourmet",
				"Reciclaje"));
		hospedajes.add(new Glamping("Glamping Romántico", "Sapa", "Vietnam", 4, "Un refugio íntimo para parejas",
				"Rural", "Paseos a caballo", "Baño de burbujas", "Energía renovable"));
		hospedajes.add(new Glamping("Glamping de Aventura", "Yosemite Valley", "Estados Unidos", 3,
				"Una experiencia única para los aventureros", "Rural", "Rutas en quad", "Barbacoa privada",
				"Gestión de residuos"));
		hospedajes
				.add(new Glamping("Glamping Familiar", "Lofoten", "Noruega", 4, "Un glamping para disfrutar en familia",
						"Rural", "Visita a granja local", "Actividades para niños", "Reutilización de agua"));

		/* Hotel */
		

		/* hotel 1 */
		
		/* Moteles */
		Motel motel1 = new Motel("Motel Íntimo", "Las Vegas", "Estados Unidos", 3, 2,
				"Un motel para momentos especiales", "Urbano", "Romántica", true, "Servicio a la habitación");
		Motel motel2 = new Motel("Motel Temático", "Cancun", "Mexico", 3, 2,
				"Cada habitación con una temática diferente", "Urbano", "Fantasía", true, "Desayuno incluido");
		Motel motel3 = new Motel("Motel de Lujo", "Bangkok", "Tailandia", 4, 3, "Con instalaciones de primer nivel",
				"Urbano", "Elegante", true, "Spa privado");
		Motel motel4 = new Motel("Motel Clásico", "Berlin", "Alemania", 3, 2, "Con un estilo retro y acogedor",
				"Urbano", "Clásica", false, "Bar en la habitación");

		hospedajes.add(motel1);
		hospedajes.add(motel2);
		hospedajes.add(motel3);
		hospedajes.add(motel4);

		/* Resort */
		Resort resort1 = new Resort("Resort de Lujo", "Punta Cana", "Republica Dominicana", 5, 10,
				"Un resort de lujo en el centro de la ciudad", "Urbano", "Spa de clase mundial",
				"Piscina en la azotea");
		Resort resort2 = new Resort("Resort Familiar", "Maldivas", "Maldivas", 4, 8,
				"Perfecto para vacaciones en familia", "Urbano", "Club infantil", "Parque acuático");
		Resort resort3 = new Resort("Resort Wellness", "Santorini", "Grecia", 5, 12,
				"Para quienes buscan bienestar y relajación", "Urbano", "Yoga y meditación",
				"Circuitos de hidroterapia");
		Resort resort4 = new Resort("Resort de Negocios", "Bali", "Indonesia", 4, 6,
				"Ideal para viajes de trabajo y eventos corporativos", "Urbano", "Salas de reuniones equipadas",
				"Centro de convenciones");
		hospedajes.add(resort1);
		hospedajes.add(resort2);
		hospedajes.add(resort3);
		hospedajes.add(resort4);

	}
}
