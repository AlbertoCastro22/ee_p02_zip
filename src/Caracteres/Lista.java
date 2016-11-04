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
public class Lista {

    private Nodo inicio;

    /**
     * constructor de la clase en el cual se inicializa el nodo en null
     */
    public Lista() {
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
     * metodo para agregar un nodo al inicio, en el cual se le pasara un dato de
     * tipo char
     */
    public void agregar(char valor) {
        Nodo nuevo = new Nodo(valor);
        if (this.getInicio() == null) {
            this.setInicio(nuevo);
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
    }

    /**
     * metodo para agregar atras o de, pasandole coo parametro un char
     */
    public void agregarAtras(char valor) {
        Nodo nuevo = new Nodo(valor);
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
     * metodo que retorna un Integer en el cual va a ser nuestro contador de
     * letras(caracteres)
     */
    public Integer contarIguales(char d) {
        Nodo aux = inicio;
        Integer contador = 0;
        Integer contador2 = 0;
        while (aux != null) {
            contador2++;
            if (aux.getDato() == d) {
                contador++;
                aux = aux.getSiguiente();
                this.eliminaPosicion(contador2);
                contador2--;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    /**
     * metodo para eliminar la posicion de un dato
     */
    public void eliminaPosicion(int posicion) {
        if (inicio != null) {
            if (posicion > 0) {
                Nodo ant = null;
                Nodo aux = inicio;
                int cont = 1;
                while ((aux != null) && (cont != posicion)) {
                    cont++;
                    ant = aux;
                    aux = aux.getSiguiente();
                }

                if (ant == null) {
                    inicio = inicio.getSiguiente();
                    aux.setSiguiente(null);
                    aux = null;
                } else {
                    ant.setSiguiente(aux.getSiguiente());
                    aux.setSiguiente(null);
                    aux = null;
                }

            }
        }
    }

    /**
     * metodo en el cual se agregara a la lista un caracter
     */
    public void lista(String mensaje) {
        for (int i = 0; i < mensaje.length(); i++) {
            this.agregarAtras(mensaje.charAt(i));
        }
    }
}