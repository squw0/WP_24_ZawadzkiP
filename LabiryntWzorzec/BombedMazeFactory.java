public class BombedMazeFactory implements MazeFactory {
    @Override
    public Room createRoom(int roomNr, int x, int y) {
        return new Room(x, y, roomNr);
    }

    @Override
    public Door createDoor(Room roomOne, Room roomTwo) {
        return new Door(roomOne, roomTwo);
    }

    @Override
    public Wall createWall(Directions direction) {
        return new BombedWall(direction);
    }
}