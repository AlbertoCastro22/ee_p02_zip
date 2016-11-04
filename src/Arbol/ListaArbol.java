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
import tabla.*;
import Caracteres.*;

public class ListaArbol {

    private NodoListaArbol inicio;

    /**
     * setter y getter
     */
    public NodoListaArbol getInicio() {
        return inicio;
    }

    public void setInicio(NodoListaArbol inicio) {
        this.inicio = inicio;
    }

    /**
     * constructor vacio pero se inicializa el nodo de la lista
     */
    public ListaArbol() {
        inicio = null;
    }

    /**
     * metodo para agregar datos a la lista de forma ordenada
     */
    public void agregarOrdenados(Arbol arbol) {
        NodoListaArbol nuevo = new NodoListaArbol(arbol);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            NodoListaArbol aux = inicio;
            NodoListaArbol aux2 = null;
            while (aux != null && (aux.getArbol().getRaiz().getFrecuencia() < nuevo.getArbol().getRaiz().getFrecuencia())) {
                aux2 = aux;
                aux = aux.getSiguiente();
            }
            if (aux2 == null) {
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
            } else if (aux == null) {
                aux2.setSiguiente(nuevo);
            } else {
                aux2.setSiguiente(nuevo);
                nuevo.setSiguiente(aux);
            }
        }
    }

    /**
     * metodo en la cual se le pasara la lista del arbol
     */
    public void listaArbol(Lista l) {
        if (l.getInicio() != null) {
            String caracter = "";
            Integer frecuencia = 0;
            while (l.getInicio() != null) {
                caracter = l.getInicio().getDato() + "";
                frecuencia = l.contarIguales(l.getInicio().getDato());
                this.agregarOrdenados(new Arbol(caracter, frecuencia));
                frecuencia = 0;
                caracter = "";
            }

        }
    }

    /**
     * metodo que retorna en nulo el inicio de nuestra lista
     */
    public NodoArbol sacarInicio() {
        if (this.inicio != null) {
            NodoListaArbol aux = inicio;
            inicio = aux.getSiguiente();
            aux.setSiguiente(null);
            return aux.getArbol().getRaiz();
        }
        return null;
    }

    /**
     * metodo en el cual se obtiene el arbol de las frecuencias de cada letra
     */
    public void obtenerArbol() {
        NodoArbol uno = null;
        NodoArbol dos = null;
        while (this.inicio.getSiguiente() != null) {
            uno = this.sacarInicio();
            dos = this.sacarInicio();
            Arbol nuevo = new Arbol(null, uno.getFrecuencia() + dos.getFrecuencia());
            nuevo.AgregarHojas(uno, dos);
            this.agregarOrdenados(nuevo);
        }
    }

    /**
     * metodo que retorna la lista de valores binarios de cada letra, es decir
     * el recorrido de cada caracter
     */
    public ListaTabla obtenerHojas(String ubicacion, ListaTabla tabla, NodoArbol raiz) {
        if (raiz.getDato() == null) {
            tabla = obtenerHojas(ubicacion + "0", tabla, raiz.getIzq());
            tabla = obtenerHojas(ubicacion + "1", tabla, raiz.getDer());
        } else {
            tabla.agregar(raiz.getDato(), ubicacion);
        }
        return tabla;
    }
}