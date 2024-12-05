import java.awt.Graphics;

public class Door extends MapSite {
    private Room roomOne, roomTwo;

    public Door(Room roomOne, Room roomTwo) {
        this.roomOne = roomOne;
        this.roomTwo = roomTwo;
    }

    @Override
    public void draw(Graphics g) {
        // Implementacja do narysowania drzwi
    }
}
