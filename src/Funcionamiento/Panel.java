package Funcionamiento;
import javax.swing.JPanel;
import java.awt.Graphics;


public class Panel extends JPanel {
    private JPanel panel;

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        g.fillRect(100,100,10,10);
    }
}
