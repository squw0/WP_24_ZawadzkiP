import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Image;  // Dodaj ten import na początku pliku
import java.awt.Graphics;  // Jeśli jeszcze nie jest zaimportowany, potrzebny do rysowania



public class App extends JFrame {

    private MyJPanel panel;
    private Image image;

    public App() {
        setSize(300, 300);
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

    public void buildMazeBuilder(int x, int y) {
        ConcreteBuilder cb = new ConcreteBuilder();
        cb.buildMaze();
    
        // Tworzenie dwóch pokoi obok siebie
        cb.buildRoom(1, x, y); // Pokój 1
        cb.buildRoom(2, x + MapSite.lenght, y); // Pokój 2 obok pokoju 1 po prawej
    
        // Dodanie drzwi między pokojem 1 a pokojem 2
        cb.buldDoor(1, 2); // Drzwi pomiędzy dwoma pokojami
    
        // Rysowanie labiryntu
        Image image = panel.getImage();
        if (image == null) {
            image = panel.createImage(panel.getWidth(), panel.getHeight());
            panel.setImage(image); // Ustawienie obrazu w panelu
        }
    
        cb.drawMaze(image); // Rysowanie całego labiryntu
        panel.repaint(); // Odświeżenie panelu
    }
    
    
  
    public void buildMaze() {
        int startX = 50;
        int startY = 50;
        buildMazeBuilder(startX, startY); // Wywołanie budowy labiryntu
    
        // Odswieżenie panelu, aby pokazać zmiany
        panel.repaint();
    }


    public static void main(String[] args) {
            java.awt.EventQueue.invokeLater(new Runnable(){
                public void run(){
                    new App().setVisible(true);
            }
        });
    }
}