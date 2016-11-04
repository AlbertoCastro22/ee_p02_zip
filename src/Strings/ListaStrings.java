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
public class ListaStrings {

    private Nodo inicio;

    /**
     * constructor enl cual se inicializa el nodo en nulo
     */
    public ListaStrings() {
        inicio = null;
    }

    /**
     * setter y getter
     */
    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    /**
     * metodo para agregar al inicio un dato
     */
    public void insertarInicio(String dato) {
        Nodo nuevo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
    }

    /**
     * metodo para agregar al final de la lista
     */
    public void insertarFinal(String dato) {
        Nodo nuevo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }

            aux.setSiguiente(nuevo);
        }
    }

    /**
     * metodo para reccorer la lista
     */
    public void recorrer() {
        Nodo aux = inicio;
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }

    /**
     * metodo para elimar el inicio de l lista
     */
    public void eliminarInicio() {
        if (inicio != null && inicio.getSiguiente() != null) {
            Nodo aux = inicio;
            aux = aux.getSiguiente();
            inicio = aux;
        } else {
            inicio = null;
        }
    }

    /**
     * metodo para eliminar el final de la lista
     */
    public void eleminarFinal() {
        if (inicio != null) {
            Nodo aux = inicio;
            Nodo ant = null;
            while (aux.getSiguiente() != null) {
                ant = aux;
                aux = aux.getSiguiente();
            }
            if (ant == null) {
                inicio = null;
            } else {
                ant.setSiguiente(null);
            }
        }
    }

    /**
     * metodo para eliminar un dato de la lista
     */
    public void eliminarElemento(String dato) {
        if (inicio != null) {
            Nodo aux = inicio;
            Nodo ant = null;
            while (aux != null && aux.getDato() != dato) {
                ant = aux;
                aux = aux.getSiguiente();
            }
            if (aux != null) {
                if (ant == null) {
                    inicio = inicio.getSiguiente();
                    aux.setSiguiente(null);
                } else {
                    ant.setSiguiente(aux.getSiguiente());
                    aux.setSiguiente(null);
                }
            }
        }
    }
}