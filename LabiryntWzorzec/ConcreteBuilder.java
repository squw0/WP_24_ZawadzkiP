
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
        room.setSite(Directions.NORTH, new Wall(Directions.NORTH));
        room.setSite(Directions.EAST, new Wall(Directions.EAST));
        room.setSite(Directions.SOUTH, new Wall(Directions.SOUTH));
        room.setSite(Directions.WEST, new Wall(Directions.WEST));
        maze.addRoom(room);
    }

    @Override
    public void buildDoor(int roomOneNr, int roomTwoNr) {
        Room roomOne = maze.getRoomNr(roomOneNr);
        Room roomTwo = maze.getRoomNr(roomTwoNr);

        if (roomOne != null && roomTwo != null) {
            Directions direction = commonWall(roomOne, roomTwo);
            Door door = new Door(roomOne, roomTwo);

            roomOne.setSite(direction, door);
            roomTwo.setSite(direction.opposite(), door);
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
        throw new IllegalArgumentException("zwariowałeś?");
    }

    @Override
    public Maze getMaze() {
        return maze;
    }
}
