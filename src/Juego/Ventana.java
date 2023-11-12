package Juego;

import javax.swing.*;

public class Ventana extends JFrame {
    private Juego juego;
    private Coche_Player coche; //referencia al Coche_Player

    public Ventana(Panel panel) {
        setSize(400, 400); // Tamaño de la ventana de juego
        add(panel);
        coche = new Coche_Player(this); //  la ventana como parámetro al constructor del Coche_Player
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // la ventana se cierre correctamente
        setVisible(true);
    }
}
