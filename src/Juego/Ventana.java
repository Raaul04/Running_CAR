package Juego;
import Usuario.Player;

import javax.swing.JFrame;

public class Ventana extends JFrame {
    private JFrame ventana;
    private Juego juego;
    private Player player;
    public Ventana(Panel panel){
        ventana=new JFrame();
        ventana.setSize(400,400); //tamanio de la ventana de juego
        ventana.add(panel);
        ventana.setVisible(true);
        player=new Player();

    }

}

