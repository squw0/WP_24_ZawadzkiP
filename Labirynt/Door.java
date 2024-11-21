import java.awt.Graphics;
import java.awt.Image;


public class Door extends MapSite {

    
    private boolean isOpen = true;
    
    public Door (Room room1, Room room2){
        super(-1,-1); // współrzędne nie są określone
        this.roomOne = room1;
        this.roomTwo = room2;
        this.isOpen = isOpen;
    }

    
    // jakby sie cos zepsuło
    //     if (x1==x2) { // pokoje leza w pionie, sciana z drzwiami jest pozioma
    //         if(y1 > y2)
    //             g.drawLine(x1,y1,x1 + MapSite.lenght / 2 - doorLength / 2 ,y1);
    //         else
    //             g.drawLine(x1,y2,x1 + MapSite.lenght / 2 - doorLength / 2 ,y2);
    //     }else { // pokoje leza w poziomie scaina z drzwiami jest pionowa
    //         if (x1 > x2)
    //             g.drawLine(x1,y1,x1,y1 + MapSite.lenght / 2 - doorLength / 2);
    //         else
    //             g.drawLine(x2,y1,x2,y1 + MapSite.lenght / 2 - doorLength / 2);
    //         }
    // }

    @Override
    public void draw(Image image) {
        int x1 = roomOne.getX();
        int y1 = roomOne.getY();
        int x2 = roomTwo.getX();
        int y2 = roomTwo.getY();
        Graphics g = image.getGraphics();
        int doorLength = MapSite.lenght / 3;
    
        // if (x1 == x2) {
        //     // pokoje leza w pionie, sciana z drzwiami jest pozioma
        //     int y = Math.min(y1, y2);  
        //     int startX = x1; // poczatek sciany
        //     int endX = startX + MapSite.lenght; // koniec sciany
    
        //     g.drawLine(startX, y, startX + (MapSite.lenght - doorLength) / 2, y); // początek sciany poziom - drzwi
        //     g.drawLine(endX - (MapSite.lenght - doorLength) / 2, y, endX, y); // drzwi - koniec sciany poziom
    
        // } else {  
        //     // pokoje leza w poziomie scaina z drzwiami jest pionowa
        //     int x = Math.min(x1, x2) + MapSite.lenght;  // łączenie albo stykanie pokoi 
        //     int startY = y1;
        //     int endY = startY + MapSite.lenght;
    
        //     g.drawLine(x, startY, x, startY + (MapSite.lenght - doorLength) / 2); // początek sciany pion - drzwi
        //     g.drawLine(x, endY - (MapSite.lenght - doorLength) / 2, x, endY); //  drzwi - koniec sciany pion
        // }

        if (x1 == x2) {
            // Pokoje leżą w pionie (pozioma ściana z drzwiami)
            int y = Math.max(y1, y2);  // y to wspólna współrzędna ściany (dolna krawędź górnego pokoju)
            int startX = x1;           // Początek ściany poziomej
            int endX = startX + MapSite.lenght; // Koniec ściany poziomej
        
            // Rysujemy dwie części ściany, pomijając drzwi na środku
            g.drawLine(startX, y, startX + (MapSite.lenght - doorLength) / 2, y); // Lewa część ściany
            g.drawLine(endX - (MapSite.lenght - doorLength) / 2, y, endX, y);     // Prawa część ściany
        } else {  
            // Pokoje leżą w poziomie (pionowa ściana z drzwiami)
            int x = Math.max(x1, x2);  // x to wspólna współrzędna ściany (prawa krawędź lewego pokoju)
            int startY = y1;           // Początek ściany pionowej
            int endY = startY + MapSite.lenght; // Koniec ściany pionowej
        
            // Rysujemy dwie części ściany, pomijając drzwi na środku
            g.drawLine(x, startY, x, startY + (MapSite.lenght - doorLength) / 2); // Górna część ściany
            g.drawLine(x, endY - (MapSite.lenght - doorLength) / 2, x, endY);     // Dolna część ściany
        }
    }

    private Room roomOne;
    private Room roomTwo;
}

    

