/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciolistas;

/**
 *
 * @author SCIS2-13
 */
public class Nodos {
    String pagina;
    Nodos siguiente;

    public Nodos(String pagina) {
        this.pagina = pagina;
        this.siguiente = null;
    }
}