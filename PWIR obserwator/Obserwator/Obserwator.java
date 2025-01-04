import java.util.ArrayList;
import java.util.List;

// Interfejs Observer - definiuje metodę aktualizacji
interface Observer {
    void update(String message);
}

// Interfejs Subject - definiuje metody do zarządzania obserwatorami
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

// Klasa Product implementuje Subject
class Product implements Subject {
    private String name;
    private double price;
    private boolean available;
    private final List<Observer> observers;

    public Product(String name, double price, boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
        this.observers = new ArrayList<>();
    }

    // Dodawanie obserwatora (użytkownika)
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Usuwanie obserwatora
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Powiadamianie obserwatorów
    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    // Zmiana ceny produktu
    public void setPrice(double price) {
        this.price = price;
        notifyObservers("Cena produktu '" + name + "' zmieniła się na: " + price + " PLN");
    }

    // Zmiana dostępności produktu
    public void setAvailability(boolean available) {
        this.available = available;
        notifyObservers("Produkt '" + name + "' jest teraz " + (available ? "dostępny" : "niedostępny"));
    }
}

// Klasa User implementuje Observer
class User implements Observer {
    private final String email;

    public User(String email) {
        this.email = email;
    }

    // Reakcja na powiadomienie
    @Override
    public void update(String message) {
        System.out.println("Powiadomienie dla " + email + ": " + message);
    }
}

// Klasa Main - demonstracja działania
public class Obserwator {
    public static void main(String[] args) {
        // Tworzenie produktów
        Product laptop = new Product("Laptop", 3000.0, false);
        Product phone = new Product("Telefon", 1500.0, true);

        // Tworzenie użytkowników
        User user1 = new User("jan.kowalski@example.com");
        User user2 = new User("anna.nowak@example.com");

        // Subskrypcja produktów
        laptop.addObserver(user1);
        laptop.addObserver(user2);

        phone.addObserver(user1);

        // Symulacja zmian
        System.out.println("Symulacja zmian w sklepie:\n");
        laptop.setAvailability(true); // Powiadomienie o dostępności
        laptop.setPrice(2800.0);      // Powiadomienie o zmianie ceny
        phone.setPrice(1400.0);       // Powiadomienie o zmianie ceny
    }
}
