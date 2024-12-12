
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Maze {
    private List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Room getRoomNr(int number) {
        for (Room room : rooms) {
            if (room.getRoomNr() == number) {
                return room;
            }
        }
        return null;
    }

    public void drawMaze(Image image) {
        for (Room room : rooms) {
            room.draw(image);
        }
    }
}