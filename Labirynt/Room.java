public class Room extends MapSite {
    private final int siteNr=4; // ilosc elementow składowych pokoi
    private MapSite sides = new MapSite[siteNr];
    private int roomNumber;

    public Room(int x, int y, int roomNr){
        super(x, y);
        roomNumber = roomNr;
    }


    public void setSite(Directions directions, MapSite mapsite){
        switch (directions){
            case NORTH:
                sides[0] = mapSite;
        }
    }
}
