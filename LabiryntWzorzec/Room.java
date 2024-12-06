import java.awt.Graphics;
import java.awt.Image;

public class Room extends MapSite {

    public Room(int x, int y, int nr){
        super(x, y);
        this.nr = nr;
    }

    public void setSite(Directions direction, MapSite site) {
        switch (direction) {
            case NORTH:
                sites[0] = site;
                break;
            case EAST:
                sites[1] = site;
                break;
            case SOUTH:
                sites[2] = site;
                break;
            case WEST:
                sites[3] = site;
                break;
        }
    }
    

    @Override
    public void draw(Image image) {
        Graphics g = image.getGraphics();
        g.drawRect(getX(), getY(), MapSite.lenght, MapSite.lenght); // Rysowanie pokoju jako prostokąt
    
        // Rysowanie każdej ściany/drzwi na danej stronie
        for (MapSite site : sites) {
            if (site != null) {
                site.draw(image); // Wywołanie rysowania dla ścian i drzwi
            }
        }
    }
    
    
    
    
    private int nr; // numer pokoju
    private MapSite[] sites = new MapSite[4];
    public int getRoomNr() {
        return 0;
    }
}