import java.util.ArrayList;
import java.util.List;

public class CalculatorModel {
    private int number1;
    private int number2;
    private char operator;
    private List<Observer> observers = new ArrayList<>();
    private String currentText = ""; 

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(currentText);
        }
    }

    public void setCurrentText(String text) {
        this.currentText = text;
        notifyObservers();
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public int calculateResult() {
        switch (operator) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '*':
                return number1 * number2;
            case '/':
                if (number2 != 0) {
                    return number1 / number2;
                } else {
                    throw new ArithmeticException("Nie można dzielić przez zero");
                }
            default:
                throw new IllegalArgumentException("Nieznany operator");
        }
    }

    public void reset() {
        number1 = 0;
        number2 = 0;
        operator = ' ';
        setCurrentText("");
    }

    public interface Observer {
        void update(String text);
    }
}