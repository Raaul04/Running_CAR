public class Juego {
    private Ventana ventana;
    private Panel panel;

    public Juego(){
        panel=new Panel();
        ventana=new Ventana(panel);
        panel.requestFocus();
    }
}