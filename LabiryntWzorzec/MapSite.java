
import java.awt.Image;

public abstract class MapSite {
    private int x, y;
    public final static int lenght = 50;

    public MapSite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int setX(int a) {
        return x = a;
    }

    public int setY(int b) {
        return y = b;
    }

    public void draw(Image image) {}
}