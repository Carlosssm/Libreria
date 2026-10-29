/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Carlosssm
 * 29/10/2026
 * 
 */
public class DBManager {

    public static final String tablaLibros = "Libros";
    private static String datosConexion = "jdbc:mysql://localhost:3306/";
    private static String dbName = "dblibreria";
    private static String user = "root";
    private static String password = "";
    private static Connection con;

    public DBManager() {
        try {
            con = DriverManager.getConnection(datosConexion, user, password);
            createBBDD();
        } catch (SQLException ex) {
            System.getLogger(DBManager.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public static void createBBDD() {
        String query = "CREATE DATABASE IF NOT EXISTS " + dbName + ";";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);

            con = DriverManager.getConnection(datosConexion + dbName, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void createTableLibros() {

        String query = "CREATE TABLE IF NOT EXISTS " + tablaLibros + " ("
                + "titulo VARCHAR(100) PRIMARY KEY, "
                + "precio DOUBLE NOT NULL, "
                + "cantidadEnInventario INT NOT NULL, "
                + "autor VARCHAR(100) NOT NULL"
                + ");";

        try (Statement stmt = con.createStatement()) {

            stmt.executeUpdate(query);
            System.out.println("Tabla Libros creada correctamente.");

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    public static Connection getConnection() {
        return con;
    }

}
