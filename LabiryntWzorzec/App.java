import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class App extends JFrame {

    private MyJPanel panel;

    public App() {
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyJPanel();
        JButton button = new JButton("Draw");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buildMazeBuilder(5, 5); // Przykład: 5x5 labirynt
            }
        });

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(button, BorderLayout.NORTH);
    }

    public void buildMazeBuilder(int width, int height) {
        ConcreteBuilder builder = new ConcreteBuilder();
        builder.buildMaze();

        int roomNumber = 1;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int posX = x * MapSite.LENGTH;
                int posY = y * MapSite.LENGTH;

                builder.buildRoom(roomNumber++, posX, posY);

                if (x > 0) {
                    builder.buildDoor(roomNumber - 1, roomNumber - 2);
                }
                if (y > 0) {
                    builder.buildDoor(roomNumber - 1, roomNumber - width - 1);
                }
            }
        }

        Maze maze = builder.getMaze();

        if (panel != null) {
            panel.setMaze(maze);
            panel.repaint();
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new App().setVisible(true));
    }
}
