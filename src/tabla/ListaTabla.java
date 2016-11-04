/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabla;

/**
 *
 * @author Usersone
 */
import Strings.ListaStrings;

public class ListaTabla {

    private Nodo inicio;

    /**
     * constructor vacio en el cual se inicializa nuestro nodo
     */
    public ListaTabla() {
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
     * metodo para agregar datos a la tabla(lista)
     */
    public void agregar(String valor, String ubicacion) {
        Nodo nuevo = new Nodo(valor, ubicacion);
        if (this.getInicio() == null) {
            this.setInicio(nuevo);
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
    }

    /**
     * metodo para sacar el inicio de la lista
     */
    public Nodo sacarInicio() {
        if (this.inicio != null) {
            Nodo aux = inicio;
            inicio = aux.getSiguiente();
            aux.setSiguiente(null);
            return aux;
        }
        return null;
    }

    /**
     * metodo que retornara la lista de cada caracter
     */
    public String unirTodo(ListaStrings mensaje) {
        String todo = "";
        Strings.Nodo aux = mensaje.getInicio();
        while (aux != null) {
            for (int i = 0; i < aux.getDato().length(); i++) {
                todo = todo + ubicacionDe(aux.getDato().charAt(i) + "");
            }

            aux = aux.getSiguiente();
        }
        return todo;
    }

    /**
     * metodo que retornara la ubicacion de cada caracter
     */
    private String ubicacionDe(String dato) {
        Nodo aux = inicio;
        while (aux != null && !(aux.getDato().equals(dato))) {
            aux = aux.getSiguiente();
        }
        return aux.getUbicacion();
    }

    /**
     * metodo para ver la ubicacion de cada letra
     */
    public String LetraDe(String ubicacion) {
        String letra = null;
        Nodo aux = inicio;
        while (aux != null && !(aux.getUbicacion().equals(ubicacion))) {
            aux = aux.getSiguiente();
        }
        if (aux != null) {
            letra = aux.getDato();
        }
        return letra;
    }
}