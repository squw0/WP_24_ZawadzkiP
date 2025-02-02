public interface MazeBuilder {
    void buildMaze();
    void buildRoom(int roomNr, int x, int y);
    void buildDoor(int roomOne, int roomTwo);
    Maze getMaze();
}
