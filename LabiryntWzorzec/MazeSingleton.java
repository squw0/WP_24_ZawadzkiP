public class MazeSingleton {
    private static Maze instance;

    private MazeSingleton() {} // Prywatny konstruktor

    public static Maze getInstance() {
        if (instance == null) {
            instance = new Maze();
        }
        return instance;
    }
}
