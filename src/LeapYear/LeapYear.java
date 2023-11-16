package LeapYear;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYear extends JFrame {
    private JButton btnCheckYear;
    private JTextField tfYear;
    private JPanel jpanel;

    public LeapYear() {
        tfYear = new JTextField(10);
        btnCheckYear = new JButton("Check");

        jpanel = new JPanel();
        //jpanel.setLayout(new FlowLayout());
        jpanel.add(new JLabel("Input Year:"));
        jpanel.add(tfYear);
        jpanel.add(btnCheckYear);

        //setLayout(new FlowLayout());

        add(jpanel);

        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkLeapYear();
            }
        });
    }

    private void checkLeapYear() {
        String yearStr = tfYear.getText();

        try {
            int year = Integer.parseInt(yearStr);

            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                JOptionPane.showMessageDialog(LeapYear.this, "Leap year");
            } else {
                JOptionPane.showMessageDialog(LeapYear.this, "Not a leap year");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(LeapYear.this, "Invalid input. Please enter a valid year.");
        }
    }

    public static void main(String[] args) {
        LeapYear app = new LeapYear();

        app.setSize(800, 600);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("Leap Year Checker");
    }
}
