package Arbol;

public class Arbol {

    private NodoArbol raiz;

    /**
     * setter y getter
     */
    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public Arbol() {
        raiz = null;
    }

    /**
     * constructor ak que se le pasa la cadena y la suma de los caracteres
     */
    public Arbol(String s, Integer suma) {
        raiz = new NodoArbol(s, suma);
    }

    /**
     * metodo para agregar hijos o ramas al arbol binario
     */
    public void AgregarHojas(NodoArbol izq, NodoArbol der) {
        raiz.setIzq(izq);
        raiz.setDer(der);
    }
}
