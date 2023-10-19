import javax.swing.JFrame;

public class Ventana extends JFrame {
    private JFrame ventana;

    public Ventana(Panel panel){
        ventana=new JFrame();
        ventana.setSize(400,400);
        ventana.add(panel);
        ventana.setVisible(true);
    }
}