
public enum Directions {
    NORTH, EAST, SOUTH, WEST;

    public Directions opposite() {
        switch (this) {
            case NORTH: return SOUTH;
            case EAST: return WEST;
            case SOUTH: return NORTH;
            case WEST: return EAST;
            default: throw new IllegalArgumentException();
        }
    }
}