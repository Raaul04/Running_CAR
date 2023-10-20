package Usuario;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

public class Player implements KeyListener {
    public static int x = 10, y = 10;
    private boolean[] keys = new boolean[256]; //debido a que hay 256 teclas y cada numero es una de ellas
    public static boolean LEFT, RIGHT; //declaramos los controles que usaremos en el juego para moverse de un lado a otro

    public Player() {
        LEFT = false;
        RIGHT = false;
    }


    public void update() {
        LEFT = keys[KeyEvent.VK_LEFT];
        RIGHT = keys[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        if (e.getKeyCode() == 37) {
            if (x > 0) {
                x = x - 20;
            }
        }
        if (e.getKeyCode() == 39) {
            if (x > 0) {
                x = x - 20;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    public Ellipse2D getBoundsCoche() {
        return new Ellipse2D.Double(x + 10, y + 30, 80, 50);
    }

}


/**public boolean llegaFinal(){
 Rectangle cuadrado= new Rectangle(320, 820, 110, 110);
 Area cuadrado =new Area(cuadrado);
 return cuadradoArea.contains(getBoundsCoche().getcoche());
 }
 }*/



