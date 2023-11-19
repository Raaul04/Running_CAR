package VideoJuego;

import java.awt.*;

public class Obstaculos {
    private int x, y, width, height;

    public Obstaculos(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}

