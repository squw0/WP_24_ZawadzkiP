import java.awt.Graphics;

public class Wall extends MapSite {
    private Directions direction;

    public Wall(Directions direction) {
        this.direction = direction;
    }

    @Override
    public void draw(Graphics g) {
        // Implementacja do narysowania ściany
    }
}
