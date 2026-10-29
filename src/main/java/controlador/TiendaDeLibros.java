/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import model.Libro;
import vista.PantallaPrincipal;
import persistencia.persistencia;
import vista.ActualizarLibro1;
import vista.ActualizarLibro2;
import persistencia.MetodosBBDD;

/**
 *
 * @author Carlosssm
 * 29/10/2026
 * 
 */
public class TiendaDeLibros {

    /**
     * @param args the command line arguments
     */
    public static HashMap<String, Libro> inventarioLibros = new HashMap<String, Libro>();

    public static void agregarLibro(String titulo, double precio, int cantidadEnInventario, String autor, String isbn) throws IOException {

        Iterator it = inventarioLibros.keySet().iterator();
        boolean existe = false;

        while (it.hasNext()) {
            String key = (String) it.next();
            if (key.hashCode() == isbn.hashCode()) {
                System.out.println("El libro ya existe");
                existe = true;
                break;
            }
        }
        
        // hashCode (sobrescrito) = compara el contenido del objeto
        // hashCode (no sobrescrito) = compara el objeto

        if (existe == false) {

            Libro libro = new Libro(titulo, precio, cantidadEnInventario, autor);
            Libro brilo = new Libro(titulo, precio, cantidadEnInventario, autor);
            
            // brilo.equals (o hashcode lol) libro?
            inventarioLibros.put(isbn, libro);

            MetodosBBDD metodos = new MetodosBBDD();

            metodos.insertarLibro(libro);

        }

    }

    public Libro actualizarLibro1(String nombre) {

        for (Libro libro : inventarioLibros.values()) {

            if (libro.getTitulo().equalsIgnoreCase(nombre)) {
                return libro;
            }
        }

        return null;
    }

    public void actualizarLibro2(Libro libro, double precio, int cantidadEnInventario) {

        libro.setPrecio(precio);
        libro.setCantidadEnInventario(cantidadEnInventario);

        try {
            persistencia.actualizar(inventarioLibros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarLibro(String nombre) {

        TiendaDeLibros tienda = new TiendaDeLibros();
        Libro libroEncontrado = tienda.actualizarLibro1(nombre);

        if (libroEncontrado != null) {

            String isbnAEliminar = null;

            for (String key : inventarioLibros.keySet()) {

                if (inventarioLibros.get(key).equals(libroEncontrado)) {
                    isbnAEliminar = key;
                    break;
                }
            }

            if (isbnAEliminar != null) {

                inventarioLibros.remove(isbnAEliminar);

                try {
                    persistencia.eliminar(inventarioLibros);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("El libro ha sido eliminado correctamente");
            }

        } else {
            System.out.println("El libro no existe");
        }
    }

    public static void agregarLibroBBDD() {

    }

}
