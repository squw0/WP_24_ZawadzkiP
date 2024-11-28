public class ConcreteBuilder implements MazeBuilder{
    
    public Maze maze;

    public ConcreteBuilder(){
        maze = new Maze();
    }

    @Override
    public void buildMaze() {
        maze = new Maze();
    }

    @Override
    public void buildRoom(int roomNr, int x, int y) {
        Room r = new Room(x, y, roomNr);
        r.setSite(Directions.North, new Wall(Directions.North));
        r.setSite(Directions.EAST, new Wall(Directions.EAST));
        r.setSite(Directions.SOUTH, new Wall(Directions.SOUTH));
        r.setSite(Directions.WEST, new Wall(Directions.WEST));
        maze.addRoom(r);

    }

    @Override
    public void buldDoor(int nrOne, int nrTwo) {
        Room roomOne = maze.getRoomNr(nrOne);
        Room roomTwo = maze.getRoomNr(nrTwo);

        Door door = new Door(roomOne, roomTwo);
        roomOne.setSite(commonWall(roomOne,roomTwo), door);
        roomTwo.setSite(null, door);
    }

    private Directions commonWall(Room roomOne, Room roomTwo, Door door) {
        if(roomOne.getX() == roomTwo.getX()){
            if(roomOne.getY() < roomTwo.getY()){
                return Directions.SOUTH;
            }
            else{
                return Directions.NORTH;
            }
        }
        else if(roomOne.getY() == roomTwo.getY()){
            if(roomOne.getX() < roomTwo.getX()){
                return Directions.EAST;
            }
            else{
                return Directions.WEST;
            }
        }        
    }

    // @Override
    // private Directions commonWall(Room roomOne, Room roomTwo, Door door) {
    //     return null;
    // }

    @Override
    public Maze getMaze() {
        return maze;
    }
}
