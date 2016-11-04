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
public class NodoArbol {

    private String dato;
    private Integer frecuencia;
    private NodoArbol izq;
    private NodoArbol der;

    /**
     * setters y getters
     */
    public Integer getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public NodoArbol getIzq() {
        return izq;
    }

    public void setIzq(NodoArbol izq) {
        this.izq = izq;
    }

    public NodoArbol getDer() {
        return der;
    }

    public void setDer(NodoArbol der) {
        this.der = der;
    }

    /**
     * constructor al que se le pasa un string como parametro. que será el dato
     */
    public NodoArbol(String d) {
        dato = d;
        frecuencia = 1;
        izq = null;
        der = null;
    }

    /**
     * segundo constructor al que se le pasan dos parametros y se inicialzan las
     * variables...
     */
    public NodoArbol(String d, Integer n) {
        dato = d;
        frecuencia = n;
        izq = null;
        der = null;
    }
}