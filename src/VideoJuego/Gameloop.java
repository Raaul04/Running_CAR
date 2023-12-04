package VideoJuego;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * La clase Gameloop representa el bucle principal del juego.
 */
public class Gameloop extends Thread {
    private final int FPS = 60; // Cantidad de fotogramas por segundo a la que queremos que funcione el juego.
    private  Juego juego;
    private boolean haTerminado = true;
    private int velocidadMoto=4;
    private int velocidad_cocheObstaculo=3;

    /**
     * Constructor de la clase Gameloop.
     *
     * @param juego Instancia de la clase Juego.
     */
    public Gameloop(Juego juego) {
        this.juego = juego;
    }

    /**
     * Inicia el bucle principal del juego.
     */
    @Override
    public void run() {
        try {
            Thread.sleep(1500); // Pausa de 1 segundo antes de comenzar el juego
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Bucle principal de actualización del juego
        double dibujarIntervalo = 1000000000.0 / FPS;
        double siguienteDibujo = System.nanoTime() + dibujarIntervalo;
        Random random = new Random();

        JPanel moto = juego.getMotoPanel();
        JPanel obstaculo = juego.getObstaculoPanel();

        int obstaculoY = juego.getyObstaculo();
        int obstaculoX = juego.getxObstaculo();
        int motoX = juego.getMotoX();
        int motoY= juego.getMotoY();

        // Asegurar que la posición inicial de la moto no coincida con la del obstáculo
        while (Math.abs(motoX - obstaculoX) < 150) {
            motoX = random.nextInt(401) + 120;
        }

        moto.setLocation(motoX, motoY);
        obstaculo.setLocation(obstaculoX, obstaculoY);

        long ultimoTiempo = System.nanoTime();
        long tiempoTranscurrido;

        while (haTerminado) {
            try {
                // Calcular el tiempo de espera para mantener el FPS
                double tiempoEspera = siguienteDibujo - System.nanoTime();
                tiempoEspera = tiempoEspera / 1000000;

                // Ajustar la velocidad de los elementos del juego
                obstaculo.setLocation(obstaculo.getX(), obstaculo.getY() + velocidad_cocheObstaculo);
                moto.setLocation(moto.getX(), moto.getY() + velocidadMoto);

                // Pausa para mantener el FPS
                Thread.sleep((long) tiempoEspera);
                siguienteDibujo += dibujarIntervalo;

                // Verificar si el obstaculo ha alcanzado la parte inferior
                if (obstaculo.getY() >= 470) {
                    // Generar una nueva posicion aleatoria para el obstaculo
                    obstaculoY = 0;
                    obstaculoX = random.nextInt(401) + 120;
                    obstaculo.setLocation(obstaculoX, obstaculoY);
                }

                // Verificar si la moto ha alcanzado la parte inferior
                if (moto.getY() >= 470) {
                    // Generar una nueva posicion aleatoria para la moto
                    motoX = random.nextInt(401) + 120;

                    // Asegurar que la nueva posicion de la moto no coincida con la del obstaculo
                    while (Math.abs(motoX - obstaculoX) < 150) {
                        motoX = random.nextInt(401) + 120;
                    }
                    moto.setLocation(motoX, motoY);
                }

                // Verificar colisiones y actualizar la puntuacion
                if (colision()) {
                    terminarJuego();
                } else {
                    juego.maximaPuntuacion();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Aumentar la puntuacion cada 1.3 segundos
            tiempoTranscurrido = System.nanoTime() - ultimoTiempo;
            if (tiempoTranscurrido >= 1_300_000_000) {
                juego.aumentarPuntos(10);
                ultimoTiempo = System.nanoTime();
            }
        }
    }

    /**
     * Verifica las colisiones entre el automovil del jugador y otros elementos del juego.
     *
     * @return true si hay una colision, false en caso contrario.
     */

    public boolean colision() {
        Rectangle carBounds = juego.getCarPanel().getBounds();
        Rectangle obstaculoBounds = juego.getObstaculoPanel().getBounds();
        Rectangle motoBounds = juego.getMotoPanel().getBounds();

        // Verificar colision con el obstáculo
        if (carBounds.intersects(obstaculoBounds)) {
            return true;
        }

        // Verificar colision con la moto
        if (carBounds.intersects(motoBounds)) {
            return true;
        }

        return false;
    }

    /**
     * Muestra un mensaje de fin de juego debido a una colision.
     * Finaliza el juego después de mostrar el mensaje.
     */
    public void terminarJuego() {
        JOptionPane.showMessageDialog(null, "Game Over. ¡Chocaste!", "NIVEL 1", JOptionPane.INFORMATION_MESSAGE);
        haTerminado = false;
        System.exit(0);
    }
}