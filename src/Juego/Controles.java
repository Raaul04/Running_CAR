package Juego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * La clase Controles gestiona la interaccion del usuario con el teclado para controlar el movimiento en un juego.
 *
 */
public class Controles implements  KeyListener  {


        private boolean[] keys = new boolean[256]; // Debido a que hay 256 teclas y cada número es una de ellas
        public static boolean LEFT, RIGHT; // Declaramos los controles que se usarán en el juego para moverse de un lado a otro

        /**
         * Constructor para crear una nueva instancia de Controles y configurar los controles iniciales.
         */
    public Controles() {
            LEFT = false;
            RIGHT = false;
        }

        /**
         * Actualiza el estado de los controles LEFT y RIGHT basados en las teclas presionadas.
         */
        public void update () {
            LEFT = keys[KeyEvent.VK_LEFT];
            RIGHT = keys[KeyEvent.VK_RIGHT];
        }

        @Override
        public void keyPressed (KeyEvent e){
            keys[e.getKeyCode()] = true;
        }

        @Override
        public void keyReleased (KeyEvent e){
            keys[e.getKeyCode()] = false;
        }

        @Override
        public void keyTyped (KeyEvent e){
        }
    }
