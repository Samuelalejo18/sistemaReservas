package co.edu.konradlorenz.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewDatosCliente {
	Scanner sc = new Scanner(System.in);

	public ViewDatosCliente() {
	}

	public int pedirOpcion() {
		int opcion = 0;
		boolean opcionValida = false;
		while (!opcionValida) {
			try {
				System.out.println("Ingrese una opcion : ");
				opcion = sc.nextInt();
				opcionValida = true;
			} catch (InputMismatchException e) {
				System.out.println("Ingrese unn dato valido(solo numeros)");
				sc.nextLine();
			}
		}
		return opcion;
	}

	public void opcionesDisponibles() {
		System.out.println("Bienvenidos al sistema de reservas");
		System.out.println("1. Autenticarse ");
		System.out.println("2.Registrarse ");
		System.out.println("0.Salir del sistema de reservas");
		System.out.println("\n");
	}

	public String pedirNombre() {
		System.out.println("Ingrese el nombre del usuario :");
		String nombre = "";
		boolean nombreValido = false;

		while (!nombreValido) {
			try {
				nombre = sc.next();

				if (nombre.matches("[a-zA-Z ]+")) {
					nombreValido = true;
				} else {
					System.out.println("Ingrese un nombre válido (solo letras).");
				}
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error. Inténtelo de nuevo.");
				sc.nextLine();
			}
		}

		return nombre;
	}

	public String pedirApellido() {

		System.out.println("Ingrese el apellido :");
		String apellido = "";
		boolean apellidoValido = false;

		while (!apellidoValido) {
			try {

				apellido = sc.next();
				if (apellido.matches("[a-zA-Z ]+")) {
					apellidoValido = true;

				} else {
					System.out.println("Ingrese un apellido válido (solo letras y espacios).");
					System.out.println("Ingrese el apellido :");
				}
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error. Inténtelo de nuevo.");

				sc.nextLine();
			}
		}
		return apellido;
	}

	public String pedirEmail() {
		boolean emailValido = false;
		String email = "";

		while (!emailValido) {
			try {
				System.out.println("Ingrese el email:");
				email = sc.next();

				// Expresión regular para validar el formato de correo electrónico
				String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(email);

				// Verificar si el email coincide con el formato esperado
				if (matcher.matches()) {
					emailValido = true;
				} else {
					System.out.println("Ingrese un email válido.");
				}
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error. Inténtelo de nuevo.");
				sc.nextLine(); // Limpiar el búfer del scanner
			}
		}

		return email;
	}

	public String pedirContrasena() {

		System.out.println("Ingrese la contraseña del usuario: ");
		String contrasena = sc.next();
		return contrasena;
	}

	public int pedirId() {
		int id = 0;
		System.out.println("Ingrese el ID del usuario:");
		boolean idValido = false;

		while (!idValido) {
			try {
				id = sc.nextInt();
				idValido = true;
			} catch (InputMismatchException e) {
				System.out.println("Ingrese un número válido.");
				sc.nextLine();
			}
		}
		return id;

	}

	public long pedirNumeroTelefono() {
		long numeroTelefono = 0;

		boolean numeroTelefonoValido = false;
		System.out.println("Ingrese el número de teléfono del usuario:");

		while (!numeroTelefonoValido) {
			try {

				numeroTelefono = sc.nextLong();
				numeroTelefonoValido = true;
			} catch (InputMismatchException e) {
				System.out.println("Ingrese un número válido.");
				sc.nextLine();
			}
		}

		return numeroTelefono;
	}

	public String pedirDireccion() {

		System.out.println("Ingrese la dirección del usuario:");
		String direccion = sc.nextLine();
		return direccion;
	}

	public void saliendoDelSistema() {
		System.out.println("\n");
		System.out.println("Saliendo del sistema de reservas");
	}

	public void opcionInvalida() {
		System.out.println("opcion invalida");
	}

	public void opcionesDeHospedaje() {
		System.out.println("\n");
		System.out.println("Ingrese una opcion");
		System.out.println("1.Mostrar hospedajes disponibles : ");
		System.out.println("2.Buscar por nombre: ");
		System.out.println("3.Filtrar por ciudad: ");
		System.out.println("4.Filtrar por pais: ");
		System.out.println("5. Filtrar por numero de estrellas: ");
		System.out.println("6.Filtrar por tipo(rural/urbano): ");
		System.out.println("7.Filtrar por precio: ");
		System.out.println("8.Filtrar por hoteles: ");
		System.out.println("9.Filtrar por moteles: ");
		System.out.println("10.Filtrar por resorts: ");
		System.out.println("11.Filtrar por campings: ");
		System.out.println("12.Filtrar por  glampings: ");
		System.out.println("13.Filtrar por cabañas: ");
		System.out.println("14.Reservar: ");
		System.out.println("0. Salir del sistema de reservas");
		System.out.println("\n");

	}

	public int pedirPrecioMinimo() {
		int numeroMinimo = 0;
		boolean numeroMinimoValido = false;

		System.out.println("Ingrese el precio mínimo:");

		while (!numeroMinimoValido) {
			try {
				numeroMinimo = sc.nextInt();
				numeroMinimoValido = true;
			} catch (InputMismatchException e) {
				System.out.println("Ingrese un número válido.");
				sc.nextLine();
			}
		}

		return numeroMinimo;
	}

	public int pedirPrecioMaximo() {
		int numeroMaximo = 0;
		boolean numeroMaximoValido = false;

		System.out.println("Ingrese el precio máximo:");

		while (!numeroMaximoValido) {
			try {
				numeroMaximo = sc.nextInt();
				numeroMaximoValido = true;
			} catch (InputMismatchException e) {
				System.out.println("Ingrese un número válido.");
				sc.nextLine();
			}
		}

		return numeroMaximo;
	}

	public void autenticacionExitosa() {
		System.out.println("Autenticación exitosa ");
		System.out.println("\n");
	}

	
	public void registroExitoso(String nombre) {
		System.out.println("Registro exitoso para el usuario  " + nombre);
		System.out.println("\n");
	}


	public String pedirCiudad() {
		String nombreCiudad = "";
		boolean ciudadValida = false;

		System.out.println("Ingrese nombre de la ciudad:");

		while (!ciudadValida) {
			try {
				nombreCiudad = sc.next();

				if (nombreCiudad.matches("[a-zA-Z ]+")) {
					ciudadValida = true;
				} else {
					System.out.println("Ingrese un nombre de ciudad válido (solo letras).");
				}
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error. Inténtelo de nuevo.");
				sc.nextLine();
			}
		}

		return nombreCiudad;
	}

	public String pedirPais() {
		String nombrePais = "";
		boolean paisValido = false;

		System.out.println("Ingrese nombre del país:");

		while (!paisValido) {
			try {
				nombrePais = sc.next();

				if (nombrePais.matches("[a-zA-Z ]+")) {
					paisValido = true;
				} else {
					System.out.println("Ingrese un nombre de país válido (solo letras).");
				}
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error. Inténtelo de nuevo.");
				sc.nextLine();
			}
		}

		return nombrePais;
	}

	public int pedirNumeroEstrellas() {
		int numeroEstrellas = 0;
		boolean entradaValida = false;

		System.out.println("Ingrese el número de estrellas:");

		while (!entradaValida) {
			try {
				numeroEstrellas = sc.nextInt();

				if (numeroEstrellas >= 1 && numeroEstrellas <= 5) {
					entradaValida = true;
				} else {
					System.out.println("Ingrese un número de estrellas válido (entre 1 y 5).");
				}
			} catch (InputMismatchException e) {
				System.out.println("Ingrese un número entero válido.");
				sc.nextLine();
			}
		}

		return numeroEstrellas;
	}

	public String pedirTipoHospedaje() {
		String tipoHospedaje = "";
		boolean tipoValido = false;

		System.out.println("Ingrese el tipo de hospedaje (urbano/rural):");

		while (!tipoValido) {
			try {
				tipoHospedaje = sc.next();

				if (tipoHospedaje.equalsIgnoreCase("urbano") || tipoHospedaje.equalsIgnoreCase("rural")) {
					tipoValido = true;
				} else {
					System.out.println("Ingrese un tipo de hospedaje válido (urbano/rural).");
				}
			} catch (Exception e) {
				System.out.println("Ha ocurrido un error. Inténtelo de nuevo.");
				sc.nextLine();
			}
		}

		return tipoHospedaje;
	}

	public String pedirNombreHospedaje() {

		sc.nextLine();
		System.out.println("Ingrese el hospedaje a reservar: ");
		String nombre = sc.nextLine();
		return nombre;

		/*
		 * String nombreHospedaje = "";
		 * boolean nombreHospedajeValido = false;
		 * 
		 * while (!nombreHospedajeValido) {
		 * try {
		 * nombreHospedaje = sc.next();
		 * 
		 * if (nombreHospedaje.matches("[a-zA-Z ]+")) {
		 * nombreHospedajeValido = true;
		 * } else {
		 * System.out.println("Ingrese un nombre del Hospedaje válido (solo letras).");
		 * }
		 * } catch (Exception e) {
		 * System.out.println("Ha ocurrido un error. Inténtelo de nuevo.");
		 * sc.nextLine();
		 * }
		 * }
		 */

	}

	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

}
