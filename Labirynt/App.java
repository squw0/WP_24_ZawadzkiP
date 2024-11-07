import javax.swing.JFrame;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.BorderLayout;


public class App extends JFrame {
    private MyJPanel panel;
    private Image image;

    public App() {
        JPanel panelRooth = new JPanel(new BorderLayout());
        setSize(200, 300);


        panel = new MyJPanel();
        panel.repaint();
        panelRooth.add("Center", panel);
        setContentPane(panelRooth); // ustawiamy jako panel główny aplikacji

        image = panel.getImage();

        buildMaze();
    }

    public void buildMaze(){
        Wall wall = new Wall(50, 100, Directions.NORTH);
        wall.draw(image);
        panel.repaint(); // odrysowanie panela, nie używamy metody paint
    }

    public static void main(String[] args) {
            java.awt.EventQueue.invokeLater(new Runnable(){
                public void run(){
                    new App().setVisible(true);
            }
        });
    }
}
