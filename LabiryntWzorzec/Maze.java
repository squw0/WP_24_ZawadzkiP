
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

    public void drawMaze(Image image) {
        Graphics g = image.getGraphics();
        for (Room room : rooms) {
            room.draw(image); // Rysowanie pokoju, drzwi i ścian
            if (room.hasBomb()) {
                int x = room.getX() + MapSite.lenght / 2 - 5;
                int y = room.getY() + MapSite.lenght / 2 + 5;
                g.drawString("$", x, y); // Rysowanie bomby w środku pokoju
            }
        }
    }
}    