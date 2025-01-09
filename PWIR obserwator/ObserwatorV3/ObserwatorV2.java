import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

// Interfejs Observer
interface Observer {
    void update(String color);
}

// Interfejs Subject
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String color);
}

// Klasa Label implementująca Subject
class ColorChangingLabel extends JLabel implements Subject {
    private final List<Observer> observers;

    public ColorChangingLabel(String text) {
        super(text, SwingConstants.CENTER);
        this.observers = new ArrayList<>();
        setOpaque(true);
        setBackground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 18));
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String color) {
        for (Observer observer : observers) {
            observer.update(color);
        }
    }

    // Metoda do zmiany koloru i powiadomienia obserwatorów
    public void changeColor(Color color) {
        setBackground(color);
        String colorName = getColorName(color);
        notifyObservers(colorName);
    }

    // Zamiana koloru na nazwę
    private String getColorName(Color color) {
        if (Color.RED.equals(color)) return "Czerwony";
        if (Color.GREEN.equals(color)) return "Zielony";
        if (Color.BLUE.equals(color)) return "Niebieski";
        return "Inny";
    }
}

// Klasa ConsoleObserver implementująca Observer
class ConsoleObserver implements Observer {
    @Override
    public void update(String color) {
        System.out.println("Kolor etykiety został zmieniony na: " + color);
    }
}

// Klasa Main tworząca GUI i uruchamiająca aplikację
public class ObserwatorV2 {
    public static void main(String[] args) {
        // Tworzenie okna
        JFrame frame = new JFrame("Zmiana Koloru Etykiety");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        // Tworzenie etykiety
        ColorChangingLabel label = new ColorChangingLabel("Kliknij, aby zmienić kolor");
        frame.add(label, BorderLayout.CENTER);

        // Tworzenie obserwatora konsoli
        ConsoleObserver consoleObserver = new ConsoleObserver();
        label.addObserver(consoleObserver);

        // Tworzenie panelu z przyciskami
        JPanel buttonPanel = new JPanel();
        JButton redButton = new JButton("Czerwony");
        JButton greenButton = new JButton("Zielony");
        JButton blueButton = new JButton("Niebieski");

        // Dodawanie akcji do przycisków
        redButton.addActionListener(e -> label.changeColor(Color.RED));
        greenButton.addActionListener(e -> label.changeColor(Color.GREEN));
        blueButton.addActionListener(e -> label.changeColor(Color.BLUE));

        // Dodawanie przycisków do panelu
        buttonPanel.add(redButton);
        buttonPanel.add(greenButton);
        buttonPanel.add(blueButton);

        // Dodanie panelu z przyciskami do okna
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Wyświetlanie okna
        frame.setVisible(true);
    }
}


// redButton.addActionListener(e -> label.changeColor(Color.RED));

// public void update(String color) {
//     System.out.println("Kolor etykiety został zmieniony na: " + color);
// }
