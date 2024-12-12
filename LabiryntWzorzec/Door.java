
import java.awt.Graphics;
import java.awt.Image;

public class Door extends MapSite {
    private Room roomOne;
    private Room roomTwo;

    public Door(Room roomOne, Room roomTwo) {
        super(-1, -1);
        this.roomOne = roomOne;
        this.roomTwo = roomTwo;
    }

    @Override
    public void draw(Image image) {
        Graphics g = image.getGraphics();
        int doorLength = MapSite.lenght / 3;

        if (roomOne.getX() == roomTwo.getX()) {
            int x = roomOne.getX();
            int y = Math.max(roomOne.getY(), roomTwo.getY());
            g.drawLine(x, y, x + (MapSite.lenght - doorLength) / 2, y);
            g.drawLine(x + MapSite.lenght - (MapSite.lenght - doorLength) / 2, y, x + MapSite.lenght, y);
        } else {
            int y = roomOne.getY();
            int x = Math.max(roomOne.getX(), roomTwo.getX());
            g.drawLine(x, y, x, y + (MapSite.lenght - doorLength) / 2);
            g.drawLine(x, y + MapSite.lenght - (MapSite.lenght - doorLength) / 2, x, y + MapSite.lenght);
        }
    }
}
