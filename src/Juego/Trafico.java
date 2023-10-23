package Juego;

public class Trafico {
    public static int xRoca1 = 600, yRoca1 = 700;
    public static int xRoca2 = 700, yRoca2 = 100;
    public static int xRoca3 = -20, yRoca3 = 600;
    public static int xRoca4 = 300, yRoca4 = -20;

    public static int puntos = 0;
    public Juego game;
    public static int nivel = 1;
    int incremento = 2;

    //Area r1,r2,r3,r4,vehiculoArea;

    int inicioY = 0;
    int inicioX = 0;
    int finY = 900;
    int finX = 700;

    public Trafico(Juego game2) {
        this.game = game2;
    }


    public int obtenerPuntos() {
        return puntos;
    }
}
/**public boolean choque(){
 AreaPersonaje=newArea(game.vehiculo.getBoundsVehiculo());
 areaPersonaje.intersect(getBoundsTrafic());
 return !areaPersonaje.isEmpty();
 }
 }*/