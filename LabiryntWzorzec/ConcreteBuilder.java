
public class ConcreteBuilder implements MazeBuilder {
    private Maze maze;
    private MazeFactory factory;

    public ConcreteBuilder(MazeFactory factory) {
        this.factory = factory;
        maze = MazeSingleton.getInstance();
    }

    @Override
    public void buildMaze() {
        maze = MazeSingleton.getInstance();
    }

    @Override
    public void buildRoom(int roomNr, int x, int y) {
        Room room = factory.createRoom(roomNr, x, y);
        room.setSite(Directions.NORTH, factory.createWall(Directions.NORTH));
        room.setSite(Directions.SOUTH, factory.createWall(Directions.SOUTH));
        room.setSite(Directions.WEST, factory.createWall(Directions.WEST));
        room.setSite(Directions.EAST, factory.createWall(Directions.EAST));
        maze.addRoom(room);
    }

    @Override
    public void buildDoor(int roomOneNr, int roomTwoNr) {
        Room roomOne = maze.getRoomNr(roomOneNr);
        Room roomTwo = maze.getRoomNr(roomTwoNr);

        if (roomOne != null && roomTwo != null) {
            Directions commonWallDirection = commonWall(roomOne, roomTwo);
            Door door = factory.createDoor(roomOne, roomTwo);
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