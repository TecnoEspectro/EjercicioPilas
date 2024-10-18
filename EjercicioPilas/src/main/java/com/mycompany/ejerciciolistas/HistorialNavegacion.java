/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejerciciolistas;

/**
 *
 * @author SCIS2-13
 */
import java.util.Stack;

public class HistorialNavegacion {
    private Nodos cabeza; // Cabeza de la lista enlazada
    private Nodos actual; // Página actual
    private Stack<Nodos> pilaAtras; // Pila para ir atrás
    private Stack<Nodos> pilaAdelante; // Pila para ir adelante

    public HistorialNavegacion() {
        this.cabeza = null;
        this.actual = null;
        this.pilaAtras = new Stack<>();
        this.pilaAdelante = new Stack<>();
    }

    public void visitarPagina(String pagina) {
        Nodos nuevoNodo = new Nodos(pagina);

        if (actual != null) {
            pilaAtras.push(actual);
        }

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        }

        actual = nuevoNodo;
        pilaAdelante.clear(); // Limpiar la pila de adelante al visitar una nueva página
    }

    public String irAtras() {
        if (!pilaAtras.isEmpty()) {
            pilaAdelante.push(actual);
            actual = pilaAtras.pop();
            return "Volver a la página: " + actual.pagina;
        } else {
            return "No hay páginas atrás.";
        }
    }

    public String irAdelante() {
        if (!pilaAdelante.isEmpty()) {
            pilaAtras.push(actual);
            actual = pilaAdelante.pop();
            return "Avanzar a la página: " + actual.pagina;
        } else {
            return "No hay páginas adelante.";
        }
    }

    public String mostrarPaginaActual() {
        if (actual != null) {
            return "Página actual: " + actual.pagina;
        } else {
            return "No estás en ninguna página.";
        }
    }

    public String mostrarHistorial() {
        StringBuilder historial = new StringBuilder("Historial de navegación:\n");
        Nodos temp = cabeza;
        while (temp != null) {
            historial.append("- ").append(temp.pagina).append("\n");
            temp = temp.siguiente;
        }
        return historial.toString();
    }
}