import java.awt.Graphics;
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

    public List<Room> getRooms() {
        return rooms;
    }

    public void drawMaze(Image image) {
        Graphics g = image.getGraphics();
        for (Room room : rooms) {
            room.draw(image);
        }
    }
}
