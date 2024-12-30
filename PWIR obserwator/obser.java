import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

// Interfejs Obserwator
interface Obserwator {
    void aktualizuj(double nowaCena);
}

// Klasa Produkt (Obiekt Obserwowany)
import java.util.ArrayList;
import java.util.List;

class Produkt {
    private String nazwa;
    private double cena;
    private List<Obserwator> obserwatorzy;

    public Produkt(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.obserwatorzy = new ArrayList<>();
    }

    public void dodajObserwatora(Obserwator obserwator) {
        obserwatorzy.add(obserwator);
    }

    public void usunObserwatora(Obserwator obserwator) {
        obserwatorzy.remove(obserwator);
    }

    public void ustawCene(double nowaCena) {
        this.cena = nowaCena;
        powiadomObserwatorow();
    }

    private void powiadomObserwatorow() {
        for (Obserwator obserwator : obserwatorzy) {
            obserwator.aktualizuj(cena);
        }
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }
}

// Klasa Klient (Obserwator) z funkcją wysyłania e-maili
class Klient implements Obserwator {
    private String imie;
    private String email;

    public Klient(String imie, String email) {
        this.imie = imie;
        this.email = email;
    }

    @Override
    public void aktualizuj(double nowaCena) {
        System.out.println(imie + ", nowa cena produktu wynosi: " + nowaCena + " zł");
        wyslijEmail(nowaCena);
    }

    private void wyslijEmail(double nowaCena) {
        // Dane serwera SMTP
        String host = "smtp.gmail.com";
        String from = "twojemail@gmail.com"; // Wpisz swój e-mail
        String password = "twoje_haslo_aplikacji"; // Wygeneruj hasło aplikacji w Gmailu

        // Konfiguracja właściwości
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Tworzenie sesji
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            // Tworzenie wiadomości e-mail
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Zmiana ceny produktu");
            message.setText("Nowa cena produktu wynosi: " + nowaCena + " zł.");

            // Wysyłanie wiadomości
            Transport.send(message);
            System.out.println("Wiadomość e-mail wysłana do " + imie + " (" + email + ").");
        } catch (MessagingException mex) {
            System.out.println("Błąd wysyłania e-maila: " + mex.getMessage());
        }
    }
}

// Klasa główna z przykładami użycia
public class obser {
    public static void main(String[] args) {
        // Tworzymy produkt
        Produkt telefon = new Produkt("Smartfon", 2000);

        // Tworzymy klientów z adresami e-mail
        Klient klient1 = new Klient("Anna", "anna@example.com");
        Klient klient2 = new Klient("Marek", "marek@example.com");

        // Klienci subskrybują produkt
        telefon.dodajObserwatora(klient1);
        telefon.dodajObserwatora(klient2);

        // Zmieniamy cenę produktu
        System.out.println("Zmiana ceny produktu na 1800 zł...");
        telefon.ustawCene(1800);

        // Usuwamy jednego klienta i zmieniamy cenę ponownie
        telefon.usunObserwatora(klient1);
        System.out.println("\nZmiana ceny produktu na 1500 zł...");
        telefon.ustawCene(1500);
    }
}
