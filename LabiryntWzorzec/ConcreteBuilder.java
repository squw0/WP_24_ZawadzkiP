import java.awt.Image; // Dodany import

public class ConcreteBuilder implements MazeBuilder {
    private Maze maze;

    public ConcreteBuilder() {
        maze = new Maze();
    }

    @Override
    public void buildMaze() {
        maze = new Maze();
    }

    @Override
    public void buildRoom(int roomNr, int x, int y) {
        Room room = new Room(x, y, roomNr);

        // Tworzenie ścian dla pokoju
        room.setSite(Directions.NORTH, new Wall(Directions.NORTH));
        room.setSite(Directions.EAST, new Wall(Directions.EAST));
        room.setSite(Directions.SOUTH, new Wall(Directions.SOUTH));
        room.setSite(Directions.WEST, new Wall(Directions.WEST));

        maze.addRoom(room);
    }
    
    @Override
    public void buldDoor(int roomOneId, int roomTwoId) {
        Room roomOne = maze.getRoomNr(roomOneId);
        Room roomTwo = maze.getRoomNr(roomTwoId);
    
        if (roomOne != null && roomTwo != null) {
            Door door = new Door(roomOne, roomTwo);
    
            // Znalezienie wspólnej ściany między dwoma pokojami
            Directions direction = commonWall(roomOne, roomTwo);
    
            // Ustawienie drzwi w obu pokojach na wspólnej ścianie
            roomOne.setSite(direction, door);
            roomTwo.setSite(opposite(direction), door);
        }
    }
    
    

    private Directions commonWall(Room roomOne, Room roomTwo) {
        if (roomOne.getX() == roomTwo.getX()) {
            if (roomOne.getY() < roomTwo.getY()) {
                return Directions.SOUTH;
            } else {
                return Directions.NORTH;
            }
        } else if (roomOne.getY() == roomTwo.getY()) {
            if (roomOne.getX() < roomTwo.getX()) {
                return Directions.EAST;
            } else {
                return Directions.WEST;
            }
        }
        throw new IllegalArgumentException("Rooms are not adjacent.");
    }

    private Directions opposite(Directions direction) {
        switch (direction) {
            case NORTH: return Directions.SOUTH;
            case SOUTH: return Directions.NORTH;
            case EAST: return Directions.WEST;
            case WEST: return Directions.EAST;
            default: throw new IllegalArgumentException("Invalid direction");
        }
    }

    @Override
    public Maze getMaze() {
        return maze;
    }

    public void drawMaze(Image image) {
        if (maze != null) {
            maze.drawMaze(image); // Rysowanie wszystkich pokoi i elementów labiryntu na obrazie
        }
    }
}
