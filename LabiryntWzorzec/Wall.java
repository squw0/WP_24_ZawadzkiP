import java.awt.Graphics;
import java.awt.Image;

public class Wall extends MapSite {
    private Directions direction;

    public Wall(int x, int y, Directions d) {
        super(x, y);
        direction = d;
    }

    public Wall(Directions d) {
        super(-1,-1);
        direction = d;
        
    }
    
    @Override
    public void draw(Image image) {
        int x = getX();
        int y = getY();
    
        Graphics g = image.getGraphics(); // Pobranie kontekstu grafiki
    
        switch (direction) {
            case NORTH:
            case SOUTH:
                g.drawLine(x, y, x + MapSite.lenght, y); // Rysowanie ściany poziomej
                break;
            case EAST:
            case WEST:
                g.drawLine(x, y, x, y + MapSite.lenght); // Rysowanie ściany pionowej
                break;
        }
    }
    

}