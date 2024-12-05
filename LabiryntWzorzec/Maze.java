import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    private List<Room> rooms;

    public Maze() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoomNr(int number) {
        return rooms.stream().filter(r -> r.getNumber() == number).findFirst().orElse(null);
    }

    public void draw(Graphics g) {
        for (Room room : rooms) {
            room.draw(g);
        }
    }
}
