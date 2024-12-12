
import java.awt.Graphics;
import java.awt.Image;

public class Wall extends MapSite {
    private Directions direction;

    public Wall(Directions direction) {
        super(-1, -1);
        this.direction = direction;
    }

    @Override
    public void draw(Image image) {
        Graphics g = image.getGraphics();
        int x = getX();
        int y = getY();

        if (direction == Directions.NORTH || direction == Directions.SOUTH) {
            int yLine = (direction == Directions.NORTH) ? y : y + MapSite.lenght;
            g.drawLine(x, yLine, x + MapSite.lenght, yLine);
        } else {
            int xLine = (direction == Directions.WEST) ? x : x + MapSite.lenght;
            g.drawLine(xLine, y, xLine, y + MapSite.lenght);
        }
    }
}
