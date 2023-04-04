package org.example.Interface;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    private static Logger logger = LogManager.getRootLogger();
    PanelDibujo cuadro;
public Ventana(){
    this.setTitle("Principal");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(1020, 500);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    this.setResizable(true);
    agregarmenu();

    cuadro=new PanelDibujo();
    add(cuadro);

}
    public void agregarmenu(){
        JMenuBar JMBbarra=new JMenuBar();
        JMenu JMarchivo=new JMenu("Archivo");
        JMenu JMarreglo=new JMenu("arreglo");
        JMenuItem JMIreset=new JMenuItem("Reset");
        JMenuItem JMIsalir=new JMenuItem("salir");
        JMenuItem JMIagregar=new JMenuItem("Agregar");
        JMenuItem JMIeliminar=new JMenuItem("Eliminar");
        JMenuItem JMIazar=new JMenuItem("Azar");
        JMenuItem JMIordenar=new JMenuItem("Ordenar");
        JMBbarra.add(JMarchivo);
        JMBbarra.add(JMarreglo);
        JMarchivo.add(JMIreset);
        JMarchivo.add(JMIsalir);
        JMarreglo.add(JMIagregar);
        JMarreglo.add(JMIeliminar);
        JMarreglo.add(JMIazar);
        JMarreglo.add(JMIordenar);
        setJMenuBar(JMBbarra);


        JMIagregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cuadro.agregarRect();
            }
        });

        JMIsalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JMIreset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cuadro.vaciarLista();
            }
        });
        JMIeliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cuadro.eliminarRect();
            }
        });
        JMIazar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cuadro.llenarLista();
            }
        });
        JMIordenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cuadro.ordenarRect();
            }
        });
}}
