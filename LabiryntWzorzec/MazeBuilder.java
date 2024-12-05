public interface MazeBuilder {
    
    void buildMaze(); // dodaje pusty labirynt
    void buildRoom(int roomNr, int x, int y); // buduje pokój ze ścianami
    void buldDoor(int roomOne, int roomTwo); // tworzy drzwi pomiędzy istniejącymi pokojami

    Maze getMaze(); // zwraca utworzyony labirynt
}

