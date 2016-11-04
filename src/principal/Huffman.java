/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author Usersone
 * aqui abajo importamos los paquetes o implementos que se necesitaran
 */
import java.io.*;
import javax.swing.JOptionPane;
import tabla.*;
import tabla.Nodo;
import Arbol.ListaArbol;
import Caracteres.Lista;
import Strings.*;

public class Huffman {

    /**
     * metodo para comprimir el mensaje a binario
     */
    public void Comprimir(ListaStrings l, String ruta) throws IOException {
        Lista cadena = new Lista();
        Strings.Nodo aux = l.getInicio();
        while (aux != null) {
            cadena.lista(aux.getDato());
            aux = aux.getSiguiente();
        }
        ListaArbol lista = new ListaArbol();
        lista.listaArbol(cadena);
        lista.obtenerArbol();
        ListaTabla tabla = new ListaTabla();
        tabla = lista.obtenerHojas("", tabla, lista.getInicio().getArbol().getRaiz());
        String direcciones = tabla.unirTodo(l);
        //String codificado2 = escribir(direcciones, tabla, ruta);
        //
        String codificado = this.escribirArchivo(direcciones, tabla, ruta);
        JOptionPane.showMessageDialog(null, "Archivo comprimido en la ruta " + ruta);
        String[] array = {direcciones, codificado};
        //String[] array2 = {direcciones, codificado2};

    }

    /**
     * metodo para descomprimir el archivo y se retorna el mensaje original
     */
    public void Descomprimir(String ruta) throws IOException {
        File doc = new File(ruta);
        FileReader fr = new FileReader(doc);
        BufferedReader lector = new BufferedReader(fr);
        String apoyo2 = lector.readLine();
        Integer falta = Integer.parseInt(lector.readLine());
        String apoyo = "";
        String mensaje = "";
        byte bit2;
        for (int i = 0; i < apoyo2.length(); i++) {
            bit2 = (byte) apoyo2.charAt(i);
            apoyo = Integer.toBinaryString(bit2 & 0xFF);
            if (apoyo.length() < 8) {
                apoyo = acompletar(apoyo);
                if (i == (apoyo2.length() - 1)) {
                    apoyo = remover(apoyo, falta);
                }
            }
            mensaje += apoyo;
        }
        ListaTabla tabla = new ListaTabla();
        apoyo = lector.readLine();
        while (apoyo != null) {
            tabla.agregar(apoyo.charAt(0) + "", remover(apoyo, 1));
            apoyo = lector.readLine();
        }
        JOptionPane.showMessageDialog(null, "Archivo descomprimido en la ruta " + ruta);
        apoyo = "";
        String original = "";
        apoyo2 = "";
        for (int i = 0; i < mensaje.length(); i++) {
            apoyo = apoyo + mensaje.charAt(i);
            apoyo2 = tabla.LetraDe(apoyo);
            if (apoyo2 != null) {
                original = original + apoyo2;
                apoyo = "";
                apoyo2 = "";
            }
        }
        lector.close();
        FileWriter fw = new FileWriter(ruta);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(original);
        bw.close();
    }

    /**
     * metodo para rellenar y poderlo convertir a binaio
     */
    private String acompletar(String cadena) {
        String nueva = "";
        for (int i = 0; i < 8 - cadena.length(); i++) {
            nueva += "0";
        }
        nueva += cadena;
        return nueva;
    }

    /**
     * metodo para remover cada caracter en cada posicion del arbol
     */
    private String remover(String cad, Integer n) {
        String nueva = "";
        for (int i = n; i < cad.length(); i++) {
            nueva += cad.charAt(i);
        }
        return nueva;
    }

    /**
     * metodo para escribir el archivo a binario es el que se utiliza
     */
    private String escribirArchivo(String mensaje, ListaTabla tabla, String nombre) throws IOException {
        /**
         * creamos un nuevo archivo y le ponemos un nombre X
         */
        File f = new File(nombre);
        FileWriter w = new FileWriter(f);
        /**
         * leemos el archivo comprimido
         */
        BufferedWriter bw = new BufferedWriter(w);
        PrintWriter escritor = new PrintWriter(bw);
        String bits = "";
        String codificado = "";
        int falta = 0;
        byte binario;
        char car;
        /**
         * for para pasar el numero binario a letras
         */
        for (int i = 0; i < mensaje.length(); i++) {
            if (bits.length() == 8) {
                binario = (byte) Short.parseShort(bits, 2);
                car = (char) (binario & 0xFF);
                codificado += car;
                bits = "";
                i--;
            } else {
                bits += mensaje.charAt(i);
            }
        }

        if (bits.length() != 0) {
            binario = (byte) Short.parseShort(bits, 2);
            car = (char) (binario & 0xFF);
            codificado += car;
            falta = 8 - bits.length();
        }
        /**
         * en esta lnea se guarda el mensaje Codificado
         */
        escritor.write(codificado + "\n");

        escritor.write(falta + "\n");
        Nodo aux = tabla.getInicio();
        /**
         * en esta linea se imprime la tabla de caracteres en binario que sera
         * la ruta en el arbol
         */
        while (aux != null) {
            escritor.write(aux.getDato() + aux.getUbicacion() + "\n");
            aux = aux.getSiguiente();
        }
        escritor.close();
        bw.close();
        return codificado;
    }
}