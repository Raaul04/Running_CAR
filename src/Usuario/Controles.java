package Usuario;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Controles implements KeyListener {
    private boolean[] keys = new boolean[256]; //debido a que hay 256 teclas y cada numero es una de ellas
    public static boolean LEFT, RIGHT; //declaramos los controles que usaremos en el juego para moverse de un lado a otro
    public Controles(){
        LEFT=false;
        RIGHT=false;
    }

    public void upate(){
        LEFT = keys[KeyEvent.VK_LEFT];
        RIGHT = keys[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }
}