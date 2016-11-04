/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Strings;

/**
 *
 * @author Usersone
 */
public class Nodo {

    private String dato;
    private Nodo siguiente;

    /**
     * este sera nuestro constructor en el cual le pasaremos como parametro un
     * string que sera nuestro dato de la lista
     */
    public Nodo(String dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    /**
     * setters y getters
     */
    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}