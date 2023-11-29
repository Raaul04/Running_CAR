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
     * Limites para que no se salga de la carretera.
     */
    public static int limIzq = 120, limDer = 520;

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
            return true;
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

}

