/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import model.Libro;

/**
 *
 * @author Carlosssm
 * 29/10/2026
 * 
 */


public class MetodosBBDD {

    public static void insertarLibro(Libro libro) {

       String titulo = libro.getTitulo();
       double precio = libro.getPrecio();
       int cantidadInventario = libro.getCantidadEnInventario();
       String autor = libro.getAutor();
       
       String query = "INSERT INTO Libros "
       + "(titulo, precio, cantidadEnInventario, autor) "
       + "VALUES ('" + titulo + "', " + precio + ", " + cantidadInventario + ", '" + autor + "')";
       
      
    }
}