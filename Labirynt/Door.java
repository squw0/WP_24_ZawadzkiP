import java.awt.Graphics;
import java.awt.Image;
import javax.lang.model.util.ElementScanner14;

public class Door extends MapSite {

    
    private boolean isOpen = true;
    
    public Door (Room room1, Room room2){
        super(-1,-1); // współrzędne nie są określone
        this.roomOne = roomOne;
        this.roomTwo = roomTwo;
        this.isOpen = isOpen;
    }
    


    @Override
    public void draw(Image image){
        int x1 = roomOne.getX();
        int y1 = roomOne.getY();
        int x2 = roomTwo.getX();
        int y2 = roomTwo.getY();
        Graphics g = image.getGraphics();
        if (x1==x2) { // pokoje leza w pionie, sciana z drzwiami jest pozioma
            if(y1 > y2)
                g.drawLine(x1,y1,x1 + MapSite.lenght,y1);
            else
                g.drawLine(x1,y2,x1 + MapSite.lenght,y2);
        }
            // setX(x1);
            // if (y1 > y2)
            //     setY(y1);
            // else 
            //     setY(y2);
        else { // pokoje leza w poziomie scaina z drzwiami jest pionowa
            if (x1 > x1)
                g.drawLine(x1,y1,x1,y1 + MapSite.lenght);
            else
                g.drawLine(x2,y1,x2,y1 + MapSite.lenght);
            }
    }


    private Room roomOne;
    private Room roomTwo;
}

    

