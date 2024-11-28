import java.awt.Image;

public class Room extends MapSite {

    public Room(int x, int y, int nr){
        super(x, y);
        this.nr = nr;
    }

    // public getRoomNr(int nr){

    // }

    public void setSite(Directions d, MapSite mapsite){
        switch (d){
            case NORTH, WEST:
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
    public int getRoomNr() {
        return 0;
    }
}
