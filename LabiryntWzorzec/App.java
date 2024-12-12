
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private MyJPanel panel;
    private Image image;

    public App() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyJPanel();
        JButton button = new JButton("Draw");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (image == null) {
                    image = panel.getImage();
                }
                buildMaze();
            }
        });

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(button, BorderLayout.NORTH);
    }

    public void buildMaze() {
        int x = 100;
        int y = 100;
        buildMazeBuilder(x, y);
    }

    public void buildMazeBuilder(int x, int y) {
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        concreteBuilder.buildMaze();

        concreteBuilder.buildRoom(1, x, y);
        concreteBuilder.buildRoom(2, x, y - MapSite.lenght);
        concreteBuilder.buildDoor(1, 2);

        concreteBuilder.buildRoom(3, x, y + MapSite.lenght);
        concreteBuilder.buildDoor(1, 3);

        concreteBuilder.buildRoom(4, x + MapSite.lenght, y);
        concreteBuilder.buildDoor(1, 4);

        concreteBuilder.buildRoom(5, x + (MapSite.lenght * 2), y);
        concreteBuilder.buildDoor(4, 5);

        concreteBuilder.buildRoom(6, x + (MapSite.lenght * 2), y - MapSite.lenght);
        concreteBuilder.buildDoor(5, 6);

        concreteBuilder.buildRoom(7, x + (MapSite.lenght * 2), y + MapSite.lenght);
        concreteBuilder.buildDoor(5, 7);

        concreteBuilder.buildRoom(8, x + (MapSite.lenght * 3), y);
        concreteBuilder.buildDoor(5, 8);

        Maze maze = concreteBuilder.getMaze();
        maze.drawMaze(image);
        panel.repaint();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            App app = new App();
            app.setVisible(true);
        });
    }
}
