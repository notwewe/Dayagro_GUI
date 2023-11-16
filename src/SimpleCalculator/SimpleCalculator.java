package SimpleCalculator;

import LeapYear.LeapYear;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JComboBox<String> cbOperations;
    private JButton btnCompute;
    private JPanel jpanel;
    private JLabel lblResult;

    public SimpleCalculator() {
        tfNumber1 = new JTextField(10);
        tfNumber2 = new JTextField(10);
        cbOperations = new JComboBox<>(new String[]{"+", "-", "*", "/"});
        btnCompute = new JButton("Compute");

        lblResult = new JLabel("Result: ");

        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        add(new JLabel("Number 1:"));
        add(tfNumber1);
        add(new JLabel("Number 2:"));
        add(tfNumber2);
        add(new JLabel());
        add(cbOperations);
        add(btnCompute);
        add(lblResult);

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computeResult();
            }
        });
    }

    private void computeResult() {
        try {
            double number1 = Double.parseDouble(tfNumber1.getText());
            double number2 = Double.parseDouble(tfNumber2.getText());

            String operator = (String) cbOperations.getSelectedItem();
            double result = 0;

            switch (operator) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero!");
                        return;
                    }
                    break;
            }

            System.out.println("/n");
            lblResult.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {

        SimpleCalculator app = new SimpleCalculator();

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setTitle("Simple Calculator");
        app.setSize(400, 200);
        app.setVisible(true);
    }
}

