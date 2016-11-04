/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arbol;

/**
 *
 * @author Usersone
 */
public class NodoListaArbol {

    private Arbol arbol;
    private NodoListaArbol Siguiente;

    /**
     * setters y getters
     */
    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    public NodoListaArbol getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoListaArbol siguiente) {
        Siguiente = siguiente;
    }

    /**
     * constructor
     */
    public NodoListaArbol(Arbol valor) {
        this.setArbol(valor);
        this.setSiguiente(null);
    }
}
