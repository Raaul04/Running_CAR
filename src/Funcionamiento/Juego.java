package Funcionamiento;
import Usuario.Player;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Juego extends JPanel {
    Player player;
    public static boolean haChocado=false;
    Trafico vehiculos=new Trafico();
    Player coche=new Player();

    public Juego(){
        JFrame miVentana = new JFrame("Running Car");
        Juego game = new Juego();
        miVentana.add(game);
        miVentana.setSize(500,900);
        miVentana.setVisible(true);
        miVentana.setResizable(false);
        miVentana.setLocationRelativeTo(null);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /** while(true){
         if(haChocado){
         int reinicia=JOptionPane.showConfirmDialog(null,"has perdido" +
         "quieres reiniciar?", JOptionPane.YES_NO_OPTION);
         if(reinicia==0){
         reiniciaValores();
         }else if(reinicia==1){
         System.exit(0);
         }
         }
         }*/
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                coche.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        setFocusable(true);
    }

}