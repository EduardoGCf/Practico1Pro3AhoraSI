package org.example.Logica;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Objeto.Rectangulo;

import javax.swing.*;

public class Controlador {
    private static Logger logger = LogManager.getRootLogger();
    private Rectangulo[] listaElementos;
    private PropertyChangeSupport observado;
    public void addObserver(PropertyChangeListener o){
        observado.addPropertyChangeListener(o);
    }
    public Controlador(Rectangulo[] listaElementos) {
        this.listaElementos = listaElementos;
        observado=new PropertyChangeSupport(this);

    }

    public void vaciarLista() {
        for (int i = 0; i < this.listaElementos.length; i++) {
            listaElementos[i]=null;
        }
        observado.firePropertyChange("Se vacio",0,1);
        logger.info("Se vacio la lista");

    }

    public void agregarRect(int alturaRect){
        if(alturaRect>400){
            logger.error("Se sobrepaso el limite de altura:"+alturaRect);
            JOptionPane.showMessageDialog(null, "Se sobrepaso el limite de altura");
            return;}
        Rectangulo prueba=new Rectangulo(alturaRect);
        for (int i = 0; i < listaElementos.length; i++) {
            if (listaElementos[i]==null){
                listaElementos[i]=prueba;
                observado.firePropertyChange("AgregarRect",0,1);
                System.out.println(Arrays.toString(listaElementos));
                return;
            }
        }

    }
    public void eliminarRect(){
        for (int i = listaElementos.length-1; i > 0; i--) {
            if (listaElementos[i]!=null){
                listaElementos[i]=null;
                observado.firePropertyChange("Eliminar",0,1);
                logger.info("Se elimino un elemento de la lista:"+listaElementos[i]);
                return;
            }
        }
    }

    public void ordenarRect(){
    int n = listaElementos.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if(listaElementos[j]!=null&&listaElementos[j+1]!=null){
            if (listaElementos[j].getAlto() > listaElementos[j + 1].getAlto()) {
                Rectangulo temp = listaElementos[j];
                listaElementos[j] = listaElementos[j + 1];
                listaElementos[j + 1] = temp;
            }}
        }
    }
    observado.firePropertyChange("ordenarRect",0,1);

}
    public void llenarLista() {
        for (int i = 0; i < this.listaElementos.length; i++) {
            Rectangulo au=new Rectangulo((int) (Math.random()*500));
            listaElementos[i]=au;
        }
        observado.firePropertyChange("Llenar lista",0,1);
    }
}

