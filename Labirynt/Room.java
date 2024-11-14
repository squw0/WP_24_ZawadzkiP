import java.awt.Image;
import javax.lang.model.util.ElementScanner14;

public class Room extends MapSite {
    //private final int siteNr=4; // ilosc elementow składowych pokoi
    //private MapSite[] sites = new MapSite[4];
    //private int roomNumber;

    public Room(int x, int y, int nr){
        super(x, y);
        //roomNumber = roomNr;
        this.nr = nr;
    }


    public void setSite(Directions d, MapSite mapsite){
        switch (d){
            case North, WEST:
                if (mapsite instanceof Wall) {
                    mapsite.setX(getX());
                    mapsite.setY(getY());
                }
                if (d==d.NORTH)
                    sites[0] = mapsite;
                else
                    sites[3] = mapsite;
                break;
                case SOUTH:
                if (mapsite instanceof Wall) {
                    mapsite.setX(getX());
                    mapsite.setY(getY() + lenght);
                    sites[2] = mapsite;
                }
                break;
                case EAST:
                if (mapsite instanceof Wall) {
                    mapsite.setX(getX() + lenght);
                    mapsite.setY(getY());
                    sites[1] = mapsite;
                }
                break;

            default: //WEST

                break;
        }
    }

    @Override
    public void draw(Image image) {
        for (MapSite mapsite : sites){
            if (mapsite != null)
            mapsite.draw(image);
        }
    }
    private int nr; // numer pokoju
    private MapSite[] sites = new MapSite[4];
}
