import java.awt.Image;

enum Directions {North, South, East, West};

public abstract class MapSite {
    private int x, y; // wspolrzedne elementu
    public static final int lenght = 50; // rozmiar sciany
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

    /**
     * Rysuje element labiryntu
     * 
     * @param image - obiekt na którym rysujemy
     */
    public void draw(Image image) {
    }
}