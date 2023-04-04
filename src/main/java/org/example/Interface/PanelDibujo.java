package org.example.Interface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Logica.Controlador;
import org.example.Objeto.Rectangulo;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class PanelDibujo extends JPanel implements PropertyChangeListener {
    private static Logger logger = LogManager.getRootLogger();

    private Rectangulo[] listaElementos=new Rectangulo[100];
    Controlador control;
    public PanelDibujo(){
        setBackground(Color.YELLOW);
        control=new Controlador(listaElementos);
        control.addObserver(this);
    }
protected void paintComponent(Graphics g){
        super.paintComponent(g);
    for (int i = 0; i < listaElementos.length; i++) {
        if(listaElementos[i]!=null) {
            g.fillRect(i * 10, 0, listaElementos[i].getAncho(), listaElementos[i].getAlto());
        }
    }
}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    this.repaint();
    }
    public void vaciarLista(){
        control.vaciarLista();
    }
    public void ordenarRect(){
        control.ordenarRect();
        logger.info("Se ordeno la lista de elementos");
    }
    public void eliminarRect(){
        control.eliminarRect();

    }
    public void agregarRect(){
        JTextField textField = new JTextField();
        Object[] message = {
                "Ingrese el alto:", textField
        };
        int option = JOptionPane.showOptionDialog(null, message, "Ingresar",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                new String[]{"Ingresar", "Cancelar"}, "default");
        if (option == JOptionPane.OK_OPTION) {
            int value;
            try {
                value = Integer.parseInt(textField.getText());
                control.agregarRect(value);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número entero válido");
                logger.info("Se ingreso un caracter invalido al metodo agregar");
            }
     }
    }
    public void llenarLista(){
        control.llenarLista();
        logger.info("Se lleno la lista de rectangulos");
    }
}
