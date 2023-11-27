package VideoJuego;

import java.util.Random;

/**
 * LanzaObstaculo.

 */
public class LanzarObstaculo implements Runnable{

    /**
     * Atributo de la clase Obstaculo.
     */
    private Obstaculo obstaculo;

    /**
     * Atributo de la clase Random.
     */
    private Random random = new Random();

    /**
     * Constructor.
     *
     * @param obstaculo que se va a lanzar.
     */
    public LanzarObstaculo(Obstaculo obstaculo){

        this.obstaculo = obstaculo;
    }

    /**
     * Mueve el obstaculo y si llega al final suma los puntos y vuelve a sacar otro obstaculo.
     *
     */
    @Override
    public void run() {

        while(true){
            if(obstaculo.y>=645||obstaculo.x<120||obstaculo.x>520){

                obstaculo.y = 0;
                obstaculo.x = random.nextInt(401)+120;//Ajusta el rango segun los limites izquierdo y derechos
                obstaculo.getGame().sumaPuntos(obstaculo.getPuntos());
            }else{
                obstaculo.y += obstaculo.getVelocidad() + (obstaculo.getGame().getNivel() * 5);
            }

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
