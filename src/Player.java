package Juego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {
    public static int x = 10, y = 10;
    private boolean[] keys = new boolean[256]; //debido a que hay 256 teclas y cada numero es una de ellas
    public static boolean LEFT, RIGHT; //declaramos los controles que usaremos en el juego para moverse de un lado a otro
    private int velocidad = 5;

    public Player() {
        LEFT = false;
        RIGHT = false;
    }

    public void update() {
        if (LEFT && x > 0) {
            x -= velocidad;
        }
        if (RIGHT && x < 750) {
            x += velocidad;
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            LEFT = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            RIGHT = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            LEFT = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            RIGHT = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}