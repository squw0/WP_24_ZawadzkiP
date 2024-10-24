import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import javax.swing.JTextField;
//import javax.swing.plaf.ActionMapUIResource;
//import javax.script.ScriptEngineManager;
//import javax.script.ScriptEngine;
//import javax.script.ScriptException;


public class L01_Kalkulator extends JFrame{
    private JButton button_1 = new JButton("1");
    private JButton button_2 = new JButton("2");
    private JButton button_3 = new JButton("3");
    private JButton button_4 = new JButton("4");
    private JButton button_5 = new JButton("5");
    private JButton button_6 = new JButton("6");
    private JButton button_7 = new JButton("7");
    private JButton button_8 = new JButton("8");
    private JButton button_9 = new JButton("9");
    private JButton button_0 = new JButton("0");
    private JButton button_C = new JButton("C");
    private JButton buttonMinus = new JButton("-");
    private JButton buttonPlus = new JButton("+");
    private JButton buttonDivide = new JButton("/");
    private JButton buttonMultiply = new JButton("*");
    private JButton buttonEquals = new JButton("=");
    private JButton button_BACKSPACE = new JButton("<-");
    private JTextField textScreen;
    private int Cyfra1, Cyfra2;


    public L01_Kalkulator(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout()); // tworzymy głowny panel
        textScreen = new JTextField(); // okno jako obiekt
        mainPanel.add("North", textScreen); // dodanie komponentu do panela na górze


        JPanel buttonPanel = new JPanel(new GridLayout(6,4));
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole

        button_0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + "0");
            }
        });

        button_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + "1");
            }
        });
       
        button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + "2");
            }
        });
       
        button_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + "3");
            }
        });
       
        button_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + "4");
            }
        });
       
        button_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + "5");
            }
        });
       
        button_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + "6");
            }
        });
       
        button_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + "7");
            }
        });
       
        button_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + "8");
            }
        });
       
        button_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + "9");
            }
        });
       
        //
        //
        //
       
        button_C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText("");
                Cyfra1 = 0;
                Cyfra2 = 0;
            }
        });

        button_BACKSPACE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = textScreen.getText();
                if (currentText.length() > 0) {
                    textScreen.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });
       
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cyfra1 = Integer.parseInt(textScreen.getText());
                textScreen.setText(textScreen.getText() + "-");
            }
        });
       
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cyfra1 = Integer.parseInt(textScreen.getText());
                textScreen.setText(textScreen.getText() + "+");
            }
        });
       
        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + "/");
            }
        });
       
        buttonMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + "*");
            }
        });
       
        buttonEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String screenText = textScreen.getText(); 
                int operatorIndex = -1;
                if (screenText.contains("+")) {
                    operatorIndex = screenText.indexOf("+");
                } else if (screenText.contains("-")) {
                    operatorIndex = screenText.indexOf("-");
                } else if (screenText.contains("*")) {
                    operatorIndex = screenText.indexOf("*");
                } else if (screenText.contains("/")) {
                    operatorIndex = screenText.indexOf("/");
                }
                if (operatorIndex == -1) {
                    textScreen.setText("brak operatora!!!!!");
                    return;
                }
                try {
                    Cyfra1 = Integer.parseInt(screenText.substring(0, operatorIndex).trim());
                    Cyfra2 = Integer.parseInt(screenText.substring(operatorIndex + 1).trim());
                } catch (NumberFormatException ex) {
                    textScreen.setText("nieprawidłowe dane");
                    return;
                }
                char operator = screenText.charAt(operatorIndex);
                int result;
                switch (operator) {
                    case '+':
                        result = Cyfra1 + Cyfra2;
                        textScreen.setText(Integer.toString(result));
                        break;
                    case '-':
                        result = Cyfra1 - Cyfra2;
                        textScreen.setText(Integer.toString(result));
                        break;
                    case '*':
                        result = Cyfra1 * Cyfra2;
                        textScreen.setText(Integer.toString(result));
                        break;
                    case '/':
                        if (Cyfra2 != 0) {
                            result = Cyfra1 / Cyfra2;
                            textScreen.setText(Integer.toString(result));
                        } else {
                            textScreen.setText("nie można dzielić przez zero");
                        }
                        break;
                    default:
                        textScreen.setText("nieznany operator");
                        break;
                }
            }
        });
        
       
        
        buttonPanel.add(button_7);
        buttonPanel.add(button_8);
        buttonPanel.add(button_9);
        buttonPanel.add(buttonMinus);
        buttonPanel.add(button_4);
        buttonPanel.add(button_5);
        buttonPanel.add(button_6);
        buttonPanel.add(buttonPlus);
        buttonPanel.add(button_1);
        buttonPanel.add(button_2);
        buttonPanel.add(button_3);
        buttonPanel.add(buttonMultiply);
        buttonPanel.add(button_C);
        buttonPanel.add(button_0);
        buttonPanel.add(button_BACKSPACE);
        buttonPanel.add(buttonDivide);
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole
        buttonPanel.add(buttonEquals);


        mainPanel.add("Center", buttonPanel); // panel z przyciskami

        setContentPane(mainPanel); // ustawia nam okienko aplikacji
        pack(); // dostosowuje rozmiar okienka aplikacji
        setVisible(true); // wyświetla okienko aplikacji na ekranie
    }
   
    public static void main(String[] args) {
        L01_Kalkulator app = new L01_Kalkulator();
    }

}