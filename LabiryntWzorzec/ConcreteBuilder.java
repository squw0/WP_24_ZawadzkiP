
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
        room.setSite(Directions.SOUTH, new Wall(Directions.SOUTH));
        room.setSite(Directions.WEST, new Wall(Directions.WEST));
        room.setSite(Directions.EAST, new Wall(Directions.EAST));

        maze.addRoom(room);
    }

    @Override
    public void buildDoor(int roomOneNr, int roomTwoNr) {
        Room roomOne = maze.getRoomNr(roomOneNr);
        Room roomTwo = maze.getRoomNr(roomTwoNr);

        if (roomOne != null && roomTwo != null) {
            Directions commonWallDirection = commonWall(roomOne, roomTwo);
            Door door = new Door(roomOne, roomTwo); 
            roomOne.setSite(commonWallDirection, door);
            roomTwo.setSite(commonWall(roomTwo, roomOne), door);
        }
    }

    @Override
    public Maze getMaze() {
        return maze;
    }

    private Directions commonWall(Room roomOne, Room roomTwo) {
        if (roomOne.getX() == roomTwo.getX()) {
            return (roomOne.getY() < roomTwo.getY()) ? Directions.SOUTH : Directions.NORTH;
        } else {
            return (roomOne.getX() < roomTwo.getX()) ? Directions.EAST : Directions.WEST;
        }
    }
}
