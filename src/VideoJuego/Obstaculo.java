package VideoJuego;

import java.awt.*;

public abstract class Obstaculo{

    public Juego game;

    public Coche_Player vehiculo;

    /**
     * Posiciones x e y del obstaculo.
     */
    public int x = 260, y = 100;

    /**
     * Ancho y largo del obctaculo.
     */
    public int width = 30, height = 30;

    /**
     * Limites para que no se salga de la carretera.
     */
    public static int limIzq = 120, limDer = 520;

    /**
     * Puntos del obstaculo.
     */
    public int puntos = 0;

    /**
     * Velocidad del obstaculo.
     */
    public int velocidadVertical =10 ;

    /**
     * Constructor.
     * @param game clase principal del Juego.
     */
    public Obstaculo(Juego game){

        this.game = game;
    }

    /**
     * Devuelve la clase principal del juego.
     * @return game clase principal del juego.
     */
    public Juego getGame(){
        return game;
    }

    /**
     * Devuelve los puntos del obstaculo.
     * @return puntos del obstaculo
     */
    public int getPuntos(){

        return puntos;
    }
    /**
     * Establece los puntos de cada obstaculo.
     * @param puntos de cada obstaculo.
     */
    public void setPuntos(int puntos){

        this.puntos = puntos;
    }

    /**
     * Devuelve la velocidad del obstaculo.
     * @return velocidad del obstaculo
     */
    public int getVelocidad() {

        return velocidadVertical;
    }

    /**
     * Establece la velocidad de cada obstaculo.
     * @param velocidadVertical de cada obstaculo.
     */
    public void setVelocidad(int velocidadVertical){

        this.velocidadVertical = velocidadVertical;
    }

    /**
     * Dibuja el obstaulo.
     * @param g grafico.
     */
    public abstract void paint(Graphics g);


    /**
     * Contola si el obstaculo choca con el vehiculo.
     * @return false.
     */
    public boolean choque(){

        vehiculo.vidas--;
        if(vehiculo.vidas == 0){
            System.out.println("Has perdido");
        }
        return false;
    }

    /**
     * Devuelve la posicion en X del obstaculo.
     */
    public int getX() {

        return x;
    }

    /**
     * Devuelve la posicion en Y del obstaculo.
     */
    public int getY() {

        return y;
    }

    /**
     * Devuelve la anchura del obstaculo.
     */

    public int getWidth() {

        return width;
    }

    /**
     * Devuelve la altura del obstaculo.
     */
    public int getHeight() {

        return height;
    }
}

