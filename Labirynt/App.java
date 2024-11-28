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

    // public void buildMazeBuilder(int x, int y){
        

        //DOKONCZ 


        
    // }

    public void buildMaze() {
        image = panel.getImage();
    
        int x = 50;
        int y = 100;
        int nr = 1;
    
        // pokój nr 1
        Room room1 = new Room(x, y, nr++);
        Wall wall1 = new Wall(50, 100, Directions.NORTH);
        room1.setSite(Directions.NORTH, wall1);
    
        // Wall wall2 = new Wall(50, 100, Directions.SOUTH);
        // room1.setSite(Directions.SOUTH, wall2);
    
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
    
        // Wall wall22 = new Wall(50, 100, Directions.SOUTH);
        // room2.setSite(Directions.SOUTH, wall22);

        // zamiast sciany są drzwi 
        // Wall wall23 = new Wall(50, 100, Directions.WEST);
        // room2.setSite(Directions.WEST, wall23);

        Wall wall24 = new Wall(50, 100, Directions.EAST);
        room2.setSite(Directions.EAST, wall24);
    

        // pokój nr 3
        y += MapSite.lenght;
        x -= MapSite.lenght;
        Room room3 = new Room(x, y, nr++);
        // Wall wall31 = new Wall(50, 100, Directions.NORTH);
        // room3.setSite(Directions.NORTH, wall31);
    
        Wall wall32 = new Wall(50, 100, Directions.SOUTH);
        room3.setSite(Directions.SOUTH, wall32);
    
        Wall wall33 = new Wall(50, 100, Directions.WEST);
        room3.setSite(Directions.WEST, wall33);

        // // zamiast sciany są drzwi 
        // Wall wall34 = new Wall(50, 100, Directions.EAST);
        // room3.setSite(Directions.EAST, wall34);

    
        // pokój nr 4
        x += MapSite.lenght;
        Room room4 = new Room(x, y, nr++);
        // Wall wall41 = new Wall(50, 100, Directions.NORTH);
        // room4.setSite(Directions.NORTH, wall41);
    
        Wall wall42 = new Wall(50, 100, Directions.SOUTH);
        room4.setSite(Directions.SOUTH, wall42);
    
        // Wall wall43 = new Wall(50, 100, Directions.WEST);
        // room4.setSite(Directions.WEST, wall43);

        Wall wall44 = new Wall(50, 100, Directions.EAST);
        room4.setSite(Directions.EAST, wall44);


        // pokój nr 5
        x += MapSite.lenght;
        Room room5 = new Room(x, y, nr++);
        Wall wall51 = new Wall(50, 100, Directions.NORTH);
        room5.setSite(Directions.NORTH, wall51);
    
        Wall wall52 = new Wall(50, 100, Directions.SOUTH);
        room5.setSite(Directions.SOUTH, wall52);
    
        Wall wall53 = new Wall(50, 100, Directions.WEST);
        room5.setSite(Directions.WEST, wall53);

        Wall wall54 = new Wall(50, 100, Directions.EAST);
        room5.setSite(Directions.EAST, wall54);


        // pokój nr 6
        y -= MapSite.lenght;
        Room room6 = new Room(x, y, nr++);
        Wall wall61 = new Wall(50, 100, Directions.NORTH);
        room6.setSite(Directions.NORTH, wall61);
    
        Wall wall62 = new Wall(50, 100, Directions.SOUTH);
        room6.setSite(Directions.SOUTH, wall62);
    
        Wall wall63 = new Wall(50, 100, Directions.WEST);
        room6.setSite(Directions.WEST, wall63);

        Wall wall64 = new Wall(50, 100, Directions.EAST);
        room6.setSite(Directions.EAST, wall64);


        // pokój nr 7
        y -= MapSite.lenght;
        Room room7 = new Room(x, y, nr++);
        Wall wall71 = new Wall(50, 100, Directions.NORTH);
        room7.setSite(Directions.NORTH, wall71);
    
        Wall wall72 = new Wall(50, 100, Directions.SOUTH);
        room7.setSite(Directions.SOUTH, wall72);
    
        Wall wall73 = new Wall(50, 100, Directions.WEST);
        room7.setSite(Directions.WEST, wall73);

        Wall wall74 = new Wall(50, 100, Directions.EAST);
        room7.setSite(Directions.EAST, wall74);


        // pokój nr 8
        x -= MapSite.lenght;
        Room room8 = new Room(x, y, nr++);
        Wall wall81 = new Wall(50, 100, Directions.NORTH);
        room8.setSite(Directions.NORTH, wall81);
    
        Wall wall82 = new Wall(50, 100, Directions.SOUTH);
        room8.setSite(Directions.SOUTH, wall82);
    
        Wall wall83 = new Wall(50, 100, Directions.WEST);
        room8.setSite(Directions.WEST, wall83);

        Wall wall84 = new Wall(50, 100, Directions.EAST);
        room8.setSite(Directions.EAST, wall84);


        // pokój nr 9
        x -= MapSite.lenght;
        Room room9 = new Room(x, y, nr++);
        Wall wall91 = new Wall(50, 100, Directions.NORTH);
        room9.setSite(Directions.NORTH, wall91);
    
        Wall wall92 = new Wall(50, 100, Directions.SOUTH);
        room9.setSite(Directions.SOUTH, wall92);
    
        Wall wall93 = new Wall(50, 100, Directions.WEST);
        room9.setSite(Directions.WEST, wall93);

        Wall wall94 = new Wall(50, 100, Directions.EAST);
        room9.setSite(Directions.EAST, wall94);

    
        // drzwi pion 1 - 2 
        Door door = new Door(room1, room2);
        room1.setSite(Directions.EAST, door);  
        room2.setSite(Directions.WEST, door); 


        // drzwi pion 3 - 4 
        Door door1 = new Door(room3, room4);
        room3.setSite(Directions.EAST, door1);  
        room4.setSite(Directions.WEST, door1);


        // drzwi poziom 1 - 3 
        Door door3 = new Door(room1, room3);
        room1.setSite(Directions.SOUTH, door3);  
        room3.setSite(Directions.NORTH, door3);


        // drzwi poziom 2 - 4
        Door door4 = new Door(room2, room4);
        room2.setSite(Directions.SOUTH, door4);  
        room4.setSite(Directions.NORTH, door4);  


        // rysowanie pokoi
        room1.draw(image);
        room2.draw(image);
        room3.draw(image);
        room4.draw(image);
        room5.draw(image);
        room6.draw(image);
        room7.draw(image);
        room8.draw(image);
        room9.draw(image);
    
        // Odswieżenie panela po ustawieniu pokoju
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
