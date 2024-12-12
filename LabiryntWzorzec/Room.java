
import java.awt.Image;

public class Room extends MapSite {
    private MapSite[] sides = new MapSite[4];
    private int number;

    public Room(int x, int y, int number) {
        super(x, y);
        this.number = number;
    }

    public int getRoomNr() {
        return number;
    }

    public void setSite(Directions direction, MapSite site) {
        sides[direction.ordinal()] = site;
        if (site instanceof Wall) {
            site.setX(getX());
            site.setY(getY());
        }
    }

    @Override
    public void draw(Image image) {
        for (MapSite side : sides) {
            if (side != null) {
                side.draw(image);
            }
        }
    }
}
