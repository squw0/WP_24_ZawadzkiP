
import java.awt.Graphics;
import java.awt.Image;

public class Wall extends MapSite {
    private Directions direction;

    public Wall(Directions d) {
        super(-1, -1); 
        direction = d;
    }

    @Override
    public void draw(Image image) {
        Graphics g = image.getGraphics();
        int x = getX();
        int y = getY();
        int length = MapSite.lenght;


        if (direction == Directions.NORTH) {
            g.drawLine(x, y, x + length, y); 
        } else if (direction == Directions.SOUTH) {
            g.drawLine(x, y + length, x + length, y + length); 
        } else if (direction == Directions.EAST) {
            g.drawLine(x + length, y, x + length, y + length); 
        } else if (direction == Directions.WEST) {
            g.drawLine(x, y, x, y + length); 
        }
    }

    public Directions getDirection() {
        return direction;
    }
}
