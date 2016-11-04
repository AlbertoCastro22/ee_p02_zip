/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Caracteres;

/**
 *
 * @author Usersone
 */
public class Nodo {

    private char Dato;
    private Nodo Siguiente;

    /**
     * setter y getter
     */
    public char getDato() {
        return Dato;
    }

    public void setDato(char dato) {
        Dato = dato;
    }

    public Nodo getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        Siguiente = siguiente;
    }

    /**
     * constructor en el cual se le pasa un caracter
     */
    public Nodo(char valor) {
        this.setDato(valor);
        this.setSiguiente(null);
    }
}