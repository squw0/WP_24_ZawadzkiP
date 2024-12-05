import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;

public class MyJPanel extends JPanel {
    private Image image;
    private Maze maze;

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image == null) {
            image = createImage(getWidth(), getHeight());
        }

        Graphics gImage = image.getGraphics();
        gImage.setColor(Color.WHITE);
        gImage.fillRect(0, 0, getWidth(), getHeight());

        if (maze != null) {
            maze.draw(gImage);
        }

        g.drawImage(image, 0, 0, this);
    }
}
