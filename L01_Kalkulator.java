import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.script.ScriptEngineManager;
import javax.swing.plaf.ActionMapUIResource;
import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


import java.awt.BorderLayout;

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


    public L01_Kalkulator(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout()); // tworzymy głowny panel
        textScreen = new JTextField();
        mainPanel.add("North", textScreen); // dodanie komponentu do panela


        JPanel buttonPanel = new JPanel(new GridLayout(6,4));
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole

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
       
        button_0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + "0");
            }
        });
       
        button_C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText("");
            }
        });
       
        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textScreen.setText(textScreen.getText() + "-");
            }
        });
       
        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
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
                // pierwsza liczba kończy się znakiem /+* itd druga liczba kończy się =
                System.out.println("wynik poprawny!!!");
            }
        });
       
        // buttonEquals.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         String expression = textScreen.getText();
        //         try {
        //             ScriptEngineManager manager = new ScriptEngineManager();
        //             ScriptEngine engine = manager.getEngineByName("JavaScript");
        //             Object result = engine.eval(expression);
        //             textScreen.setText(result.toString());
        //         } catch (Exception ex) {
        //             textScreen.setText("Błąd");
        //         }
        //     }
        // });
       

        button_BACKSPACE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = textScreen.getText();
                if (currentText.length() > 0) {
                    textScreen.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });
       



        buttonPanel.add(button_C);
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
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole
        buttonPanel.add(button_0);
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole
        buttonPanel.add(buttonDivide);
        buttonPanel.add(button_BACKSPACE);
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole
        buttonPanel.add(new JLabel()); // wstawiamy etykietę czyli puste pole
        buttonPanel.add(buttonEquals);


        mainPanel.add("Center", buttonPanel);

        setContentPane(mainPanel); // ustawia nam okienko aplikacji
        pack(); // dostosowuje rozmiar okienka aplikacji
        setVisible(true); // wyświetla okienko aplikacji na ekranie
    }
   
    public static void main(String[] args) {
        L01_Kalkulator app = new L01_Kalkulator();
    }

}