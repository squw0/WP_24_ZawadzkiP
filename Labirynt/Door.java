
public class Door extends MapSite {

    private Room room1;
    private Room room2;
    private boolean isOpen = true;
    
    public Door (Room room1, Room room2){
        super(-1,-1); // współrzędne nie są określone
        this.room1 = room1;
        this.room2 = room2;
        this.isOpen = isOpen;
    }
    public void draw(Image image){
        
    }


    
}
