
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App extends JFrame {
    private MyJPanel panel;
    private Image image;
    private ConcreteBuilder cb;

    public App() {
        setSize(350, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyJPanel();
        JButton button = new JButton("Draw");
        JButton buttonBomb = new JButton("Bomb Room");
        JButton buttonBlowWall = new JButton("Blow Wall");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (image == null) {
                    image = panel.getImage();
                }
                buildMaze();
            }
        });

        buttonBomb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (image != null && cb != null) {
                    addBombsToMaze(cb.getMaze());
                }
            }
        });

        buttonBlowWall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (image != null && cb != null) {
                    blowUpWall(cb.getMaze());
                }
            }
        });

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        JPanel menuPanel = new JPanel(new GridLayout(1, 3));
        menuPanel.add(button);
        menuPanel.add(buttonBomb);
        menuPanel.add(buttonBlowWall);
        add(menuPanel, "North");
    }

    public void buildMaze() {
        MazeFactory factory = new BombedMazeFactory(); // Użycie fabryki z wysadzalnymi ścianami
        cb = new ConcreteBuilder(factory);
        int x = 50;
        int y = 100;
        buildMazeBuilder(x, y);
    }

    public void buildMazeBuilder(int x, int y) {
        cb.buildMaze();

        cb.buildRoom(1, x, y);
        cb.buildRoom(2, x, y + MapSite.lenght);
        cb.buildDoor(1, 2);

        cb.buildRoom(3, x, y - MapSite.lenght);
        cb.buildDoor(1, 3);

        cb.buildRoom(4, x + MapSite.lenght, y);
        cb.buildDoor(1, 4);

        cb.buildRoom(5, x + (MapSite.lenght * 2), y);
        cb.buildDoor(4, 5);

        cb.buildRoom(6, x + (MapSite.lenght * 2), y - MapSite.lenght);
        cb.buildDoor(5, 6);

        cb.buildRoom(7, x + (MapSite.lenght * 2), y + MapSite.lenght);
        cb.buildDoor(5, 7);

        cb.buildRoom(8, x + (MapSite.lenght * 3), y);
        cb.buildDoor(5, 8);

        Maze maze = cb.getMaze();
        maze.drawMaze(image);
        panel.repaint();
    }

    public void addBombsToMaze(Maze maze) {
        java.util.Random random = new java.util.Random();
        for (int i = 1; i <= 8; i++) {
            Room room = maze.getRoomNr(i);
            if (room != null) {
                room.setBomb(random.nextBoolean());
            }
        }
        maze.drawMaze(image);
        panel.repaint();
    }

    public void blowUpWall(Maze maze) {
        for (Room room : maze.getRooms()) { // Zakładam, że metoda getRooms() zwraca listę pokoi
            for (Directions dir : Directions.values()) {
                MapSite site = room.getSite(dir);
                if (site instanceof BombedWall) {
                    ((BombedWall) site).blowUp();
                }
            }
        }
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
