
import java.awt.Graphics;
import java.awt.Image;


public class Door extends MapSite {

    
    private boolean isOpen = true;
    
    public Door (Room room1, Room room2){
        super(-1,-1); // współrzędne nie są określone
        this.roomOne = room1;
        this.roomTwo = room2;
        this.isOpen = isOpen;
    }
    
    @Override
    public void draw(Image image) {
        Graphics g = image.getGraphics();
    
        int x1 = roomOne.getX();
        int y1 = roomOne.getY();
        int x2 = roomTwo.getX();
        int y2 = roomTwo.getY();
    
        // Rysowanie drzwi między pokojami
        if (x1 == x2) {
            // Drzwi poziome
            int doorX = x1 + MapSite.lenght / 2;
            int doorYStart = Math.min(y1, y2) + MapSite.lenght;
            int doorYEnd = doorYStart - MapSite.lenght / 3;
            g.drawLine(doorX, doorYStart, doorX, doorYEnd);
        } else {
            // Drzwi pionowe
            int doorY = y1 + MapSite.lenght / 2;
            int doorXStart = Math.min(x1, x2) + MapSite.lenght;
            int doorXEnd = doorXStart - MapSite.lenght / 3;
            g.drawLine(doorXStart, doorY, doorXEnd, doorY);
        }
    }
    
    
    

    private Room roomOne;
    private Room roomTwo;
}

    

