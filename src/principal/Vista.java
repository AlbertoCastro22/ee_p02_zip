/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

/**
 *
 * @author Usersone
 * zona en donde se importa todas las librerias necesarias
 */
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;
import Strings.*;
import java.awt.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Vista {

    private JFrame principal;
    private JButton comprimir = new JButton("Comprimir");
    private JButton descomprimir = new JButton("Descomprimir");
    private JButton exa = new JButton("Examinar");
    private JButton exa2 = new JButton("Examinar");
    private JRadioButton r1 = new JRadioButton("Comprimir");
    private JRadioButton r2 = new JRadioButton("Descomprimir");
    private JPanel panel;
    private JPanel p1;
    private File[] archivos;
    private File[] archivos2;
    private Thread[] hilos;
    private Thread[] hilos2;

    private Huffman huffman = new Huffman();

    /**
     * este sera nuestro panel, en donde se encontrara cada ventana
     * Asignamos el titulo de nuestra ventana
     * estableceremos la posicion,la altura y la anchura de nuestra ventana
     * 
     */
    public Vista() {
        principal = new JFrame("Compresion y descompresion de archivos");
        principal.setLayout(new GridLayout(2, 2));
        principal.setSize(300, 200);
        principal.setLocation(500, 100);
        principal.setVisible(true);
        principal.setDefaultCloseOperation(principal.EXIT_ON_CLOSE);
        panel = new JPanel(new FlowLayout());
        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        Examinar ex = new Examinar();
        Comprimir com = new Comprimir();
        Descomprimir des = new Descomprimir();
        Examinar2 ex2 = new Examinar2();
        Fomulario form = new Fomulario();
        r1.addActionListener(form);
        r2.addActionListener(form);
        descomprimir.addActionListener(des);
        exa.addActionListener(ex);
        comprimir.addActionListener(com);
        exa2.addActionListener(ex2);
        panel.add(r1);
        panel.add(r2);
        principal.add(panel);
        panel.updateUI();
    }
    
    
    
    /**Este metodo sirve para que se pueda ejecutar los paneles en el JFrame creando arreglos de estos mismos*/
    private class Fomulario implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == r1) {
                if (panel.getComponentCount() > 2) {
                    panel.remove(p1);
                }
                p1 = new JPanel(new FlowLayout());
                p1.add(exa);
                p1.add(comprimir);
                panel.add(p1);
                panel.updateUI();
                principal.add(panel);
            } else if (e.getSource() == r2) {
                if (panel.getComponentCount() > 2) {
                    panel.remove(p1);
                }
                p1 = new JPanel(new FlowLayout());
                p1.add(exa2);
                p1.add(descomprimir);
                panel.add(p1);
                panel.updateUI();
                principal.add(panel);
            }

        }

    }

    /**
     * boton para examinar la biblioteca y poder seleccionar un archivo y
     * comprimirlo
     */
    private class Examinar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser selector = new JFileChooser();
            selector.setMultiSelectionEnabled(true);
            FileNameExtensionFilter file = new FileNameExtensionFilter("txt", "txt");
            selector.setFileFilter(file);
            int r = selector.showOpenDialog(null);
            if (r == JFileChooser.APPROVE_OPTION) {
                archivos = selector.getSelectedFiles();
            }
        }

    }

    /**
     * boton para examinar la biblioteca y poder seleccionar un archivo y
     * descomprimirlo
     */
    private class Examinar2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser selector = new JFileChooser();
            selector.setMultiSelectionEnabled(true);
            FileNameExtensionFilter file = new FileNameExtensionFilter("txt", "txt");
            selector.setFileFilter(file);
            int r = selector.showOpenDialog(null);
            if (r == JFileChooser.APPROVE_OPTION) {
                archivos2 = selector.getSelectedFiles();
            }
        }

    }

    /**
     * boton para entrar a seleccionar el archivo al momento de la compresion
     */
    private class Comprimir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (archivos != null) {
                hilos = new Thread[archivos.length];
                for (int i = 0; i < archivos.length; i++) {
                    hilos[i] = new Thread(new Comprime(archivos[i].getAbsolutePath()));
                    hilos[i].start();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No tiene archivos seleccionados");
            }
        }
    }

    /**
     * boton para entrar a seleccionar el archivo al momento de la descompresion
     */
    private class Descomprimir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (archivos2 != null) {
                hilos2 = new Thread[archivos2.length];
                for (int i = 0; i < hilos2.length; i++) {
                    hilos2[i] = new Thread(new Descomprime(archivos2[i].getAbsolutePath()));
                    hilos2[i].start();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No tiene archivos seleccionados");
            }
        }
    }

    /**
     * es en donde se seleccionara el archivo en la ruta X y luego se ejecuta el
     * metodo run
     */
    private class Comprime implements Runnable {

        @SuppressWarnings("FieldMayBeFinal")
        private String ruta;

        public Comprime(String ruta) {
            this.ruta = ruta;
        }

        /**
         * metodo run para que se ejecute la compresion del archivo al darle
         * click en comprimir
         */
        @Override
        public void run() {
            FileReader ar = null;
            try {
                ar = new FileReader(ruta);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedReader entrada = new BufferedReader(ar);
            ListaStrings l = new ListaStrings();
            @SuppressWarnings("UnusedAssignment")
            String cadena = "";
            try {

                while ((cadena = entrada.readLine()) != null) {
                    l.insertarFinal(cadena);
                }
            } catch (IOException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                huffman.Comprimir(l, ruta);

            } catch (IOException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            archivos = null;
        }
    }

    /**
     * es en donde se seleccionara el archivo en la ruta X
     */
    private class Descomprime implements Runnable {

        @SuppressWarnings("FieldMayBeFinal")
        private String ruta;

        public Descomprime(String ruta) {
            this.ruta = ruta;
        }

        /**
         * metodo run para que se ejecute la compresion del archivo al darle
         * click en descomprimir
         */
        @Override
        public void run() {
            try {
                huffman.Descomprimir(ruta);
            } catch (IOException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}