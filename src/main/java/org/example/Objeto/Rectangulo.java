package org.example.Objeto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Rectangulo {
    private static Logger logger = LogManager.getRootLogger();
    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }
    private int alto,ancho;

    public Rectangulo(int alto) {
        this.alto = alto;
        this.ancho = 5;
        logger.info("Se creo un rectangulo de tamanio"+alto);
    }

    @Override
    public String toString() {
        return "Rectangulo{" + "alto=" + alto + ", ancho=" + ancho + '}';
    }
}
