/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import controlador.TiendaDeLibros;
import model.Libro;
/**
 *
 * @author Carlosssm
 * 29/10/2026
 * 
 */
public class persistencia {
    
    public static void guardar(HashMap<String, Libro> inventarioLibros) throws IOException {
        
        File document = new File("libros.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(document));

        for (String isbn : inventarioLibros.keySet()) {

            Libro libro = inventarioLibros.get(isbn);

            // Aquí convertimos los autores a un solo String separado por comas
            String autoresTexto = "";
            for (int i = 0; i < libro.getAutores().size(); i++) {
                autoresTexto += libro.getAutores().get(i);
                if (i < libro.getAutores().size() - 1) {
                    autoresTexto += ",";
                }
            }

            bw.write(isbn + ";" + libro.getTitulo() + ";" + autoresTexto + ";" + libro.getPrecio() + ";" + libro.getCantidadEnInventario());
            bw.newLine();
        }

        bw.close();
    }
    
    public static void actualizar(HashMap<String, Libro> inventarioLibros) throws IOException {
    
    File document = new File("libros.txt");
    BufferedWriter bw = new BufferedWriter(new FileWriter(document));

    for (String isbn : inventarioLibros.keySet()) {

        Libro libro = inventarioLibros.get(isbn);

        String autoresTexto = "";
        for (int i = 0; i < libro.getAutores().size(); i++) {
            autoresTexto += libro.getAutores().get(i);
            if (i < libro.getAutores().size() - 1) {
                autoresTexto += ",";
            }
        }

        bw.write(isbn + ";" 
                + libro.getTitulo() + ";" 
                + autoresTexto + ";" 
                + libro.getPrecio() + ";" 
                + libro.getCantidadEnInventario());

        bw.newLine();
    }

    bw.close();
}
    
    public static void eliminar(HashMap<String, Libro> inventarioLibros) throws IOException {
    guardar(inventarioLibros);
}

    
}
