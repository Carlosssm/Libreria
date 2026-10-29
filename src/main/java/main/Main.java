/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controlador.TiendaDeLibros;
import persistencia.DBManager;
import vista.PantallaPrincipal;

/**
 *
 * @author Carlosssm
 * 29/10/2026
 * 
 */
public class Main {

    public static void main(String[] args) {

        DBManager dbManager = new DBManager();

        dbManager.createBBDD();

        TiendaDeLibros tdl = new TiendaDeLibros();
        PantallaPrincipal pp = new PantallaPrincipal(tdl);
        pp.setVisible(true);

    }
}
