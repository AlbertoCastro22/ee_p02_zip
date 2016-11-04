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
public class Nodo {

    private String Dato;
    private String ubicacion;
    private Nodo Siguiente;

    /**
     * setters y getters
     */
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDato() {
        return Dato;
    }

    public void setDato(String dato) {
        Dato = dato;
    }

    public Nodo getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        Siguiente = siguiente;
    }

    /**
     * constructor en el cual se le pasa la cadena y la ubicacion de cada caracter
     */
    public Nodo(String valor, String ub) {
        this.setDato(valor);
        this.setSiguiente(null);
        this.setUbicacion(ub);
    }
}