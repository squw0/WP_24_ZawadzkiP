
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class BombedWall extends Wall {
    private boolean isBlownUp = false;

    public BombedWall(Directions direction) {
        super(direction);
    }

    public void blowUp() {
        isBlownUp = true;
    }

    @Override
    public void draw(Image image) {
        Graphics g = image.getGraphics();
        int x = getX();
        int y = getY();
        int length = MapSite.lenght;

        if (isBlownUp) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLACK);
        }

        if (getDirection() == Directions.NORTH) {
            g.drawLine(x, y, x + length, y);
        } else if (getDirection() == Directions.SOUTH) {
            g.drawLine(x, y + length, x + length, y + length);
        } else if (getDirection() == Directions.EAST) {
            g.drawLine(x + length, y, x + length, y + length);
        } else if (getDirection() == Directions.WEST) {
            g.drawLine(x, y, x, y + length);
        }
    }
}