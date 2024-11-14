import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;


public class App extends JFrame {

    private MyJPanel panel;
    private Image image;

    public App() {
        setSize(200, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyJPanel();
        JButton button = new JButton("Draw");
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                buildMaze();

            }

        });

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER); // panel w centralnej czesci
        add(button, "North");
    }

    public void buildMaze() {
        image = panel.getImage();
    
        int x = 50;
        int y = 100;
        int nr = 1;
    
        // pokój nr 1
        Room room1 = new Room(x, y, nr++);
        Wall wall1 = new Wall(50, 100, Directions.NORTH);
        room1.setSite(Directions.NORTH, wall1);
    
        Wall wall2 = new Wall(50, 100, Directions.SOUTH);
        room1.setSite(Directions.SOUTH, wall2);
    
        Wall wall3 = new Wall(50, 100, Directions.WEST);
        room1.setSite(Directions.WEST, wall3);

        // zamiast sciany są drzwi 
        // Wall wall4 = new Wall(50, 100, Directions.EAST);
        // room1.setSite(Directions.EAST, wall4);

    
        // pokój nr 2
        x = x + MapSite.lenght;
        Room room2 = new Room(x, y, nr++);
        Wall wall21 = new Wall(50, 100, Directions.NORTH);
        room2.setSite(Directions.NORTH, wall21);
    
        Wall wall22 = new Wall(50, 100, Directions.SOUTH);
        room2.setSite(Directions.SOUTH, wall22);

        // zamiast sciany są drzwi 
        // Wall wall23 = new Wall(50, 100, Directions.WEST);
        // room2.setSite(Directions.WEST, wall23);

        Wall wall24 = new Wall(50, 100, Directions.EAST);
        room2.setSite(Directions.EAST, wall24);
    
        Door door = new Door(room1, room2);
        room1.setSite(Directions.EAST, door);  
        room2.setSite(Directions.WEST, door);  
    
        room1.draw(image);
        room2.draw(image);
    
        panel.repaint(); // Odswieżenie panela po ustawieniu pokoju
    }
    

    public static void main(String[] args) {
            java.awt.EventQueue.invokeLater(new Runnable(){
                public void run(){
                    new App().setVisible(true);
            }
        });
    }
}
