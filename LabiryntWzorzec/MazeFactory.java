public interface MazeFactory {
    Room createRoom(int roomNr, int x, int y);
    Door createDoor(Room roomOne, Room roomTwo);
    Wall createWall(Directions direction);
}
