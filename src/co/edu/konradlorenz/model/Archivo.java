package co.edu.konradlorenz.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Archivo {
    public void guardarArchivo(ArrayList<Cliente> clientes) {

        try {
            BufferedWriter escritor = new BufferedWriter(new FileWriter(
                    "D:\\Universidad\\3.Tercer semestre\\tecnicas de programacion 2\\sistemaReservas\\Clientes.txt",
                    true));
            for (Cliente cliente : clientes) {
                escritor.write(cliente.getNombre() + "\t" + cliente.getApellido() + "\t" + cliente.getId() + "\t"
                        + cliente.getEmail()
                        + "\t" + cliente.getContrasena() + "\t" + cliente.getNumeroTelefono() + "\t"
                        + cliente.getDireccion());

                escritor.newLine();

            }

            escritor.close();
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo" + e.getMessage());
        }
    }
}
