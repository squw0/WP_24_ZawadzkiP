
import java.awt.Graphics;
import java.awt.Image;

public class Room extends MapSite {
    private MapSite[] sides = new MapSite[4];
    private int number;
    private boolean hasBomb = false;

    public Room(int x, int y, int number) {
        super(x, y);
        this.number = number;
    }

    public void setBomb(boolean hasBomb) {
        this.hasBomb = hasBomb;
    }

    public boolean hasBomb() {
        return hasBomb;
    }

    public void setSite(Directions direction, MapSite site) {
        sides[direction.ordinal()] = site;
        site.setX(getX());
        site.setY(getY());
    }

    public MapSite getSite(Directions direction) {
        return sides[direction.ordinal()];
    }

    public int getRoomNr() {
        return number;
    }

    @Override
    public void draw(Image image) {
        Graphics g = image.getGraphics();
        int x = getX();
        int y = getY();

        for (MapSite side : sides) {
            if (side != null) {
                side.draw(image);
            }
        }

        if (hasBomb) {
            g.drawString("$", x + MapSite.lenght / 2 - 5, y + MapSite.lenght / 2 + 5);
        }
    }
} 