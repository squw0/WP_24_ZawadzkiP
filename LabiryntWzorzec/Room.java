import java.awt.Graphics;

public class Room extends MapSite {
    private int x, y, number;
    private MapSite[] sides;

    public Room(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
        sides = new MapSite[4];
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumber() {
        return number;
    }

    public void setSite(Directions direction, MapSite site) {
        sides[direction.ordinal()] = site;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(x, y, LENGTH, LENGTH);
        g.drawString(String.valueOf(number), x + LENGTH / 2, y + LENGTH / 2);
    }
}
