package FoodOrdering;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrdering extends JFrame {
    private JCheckBox pizzaCheckBox;
    private JCheckBox burgerCheckBox;
    private JCheckBox friesCheckBox;
    private JCheckBox softDrinksCheckBox;
    private JCheckBox teaCheckBox;
    private JCheckBox sundaeCheckBox;
    private JRadioButton noneRadioButton;
    private JRadioButton a5OffRadioButton;
    private JRadioButton a10OffRadioButton;
    private JRadioButton a15OffRadioButton;
    private JButton orderButton;

    public FoodOrdering() {

        pizzaCheckBox = new JCheckBox("Pizza - Php 100");
        burgerCheckBox = new JCheckBox("Burger - Php 80");
        friesCheckBox = new JCheckBox("Fries - Php 65");
        softDrinksCheckBox = new JCheckBox("Soft Drinks - Php 55");
        teaCheckBox = new JCheckBox("Tea - Php 50");
        sundaeCheckBox = new JCheckBox("Sundae - Php 40");

        noneRadioButton = new JRadioButton("None");
        a5OffRadioButton = new JRadioButton("5% Off");
        a10OffRadioButton = new JRadioButton("10% Off");
        a15OffRadioButton = new JRadioButton("15% Off");

        orderButton = new JButton("Order");

        ButtonGroup discountGroup = new ButtonGroup();
        discountGroup.add(noneRadioButton);
        discountGroup.add(a5OffRadioButton);
        discountGroup.add(a10OffRadioButton);
        discountGroup.add(a15OffRadioButton);

        setLayout(new GridLayout(16, 1));

        add(new JLabel("Select Food Items:"));
        add(pizzaCheckBox);
        add(burgerCheckBox);
        add(friesCheckBox);
        add(softDrinksCheckBox);
        add(teaCheckBox);
        add(sundaeCheckBox);

        add(new JLabel("Select Discount:"));
        add(noneRadioButton);
        add(a5OffRadioButton);
        add(a10OffRadioButton);
        add(a15OffRadioButton);

        add(orderButton);

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computeTotalPrice();
            }
        });
    }

    private void computeTotalPrice() {
        double totalPrice = 0.0;

        // Check selected food items and calculate total price
        if (pizzaCheckBox.isSelected()) totalPrice += 100.0;
        if (burgerCheckBox.isSelected()) totalPrice += 80.0;
        if (friesCheckBox.isSelected()) totalPrice += 65.0;
        if (softDrinksCheckBox.isSelected()) totalPrice += 55.0;
        if (teaCheckBox.isSelected()) totalPrice += 50.0;
        if (sundaeCheckBox.isSelected()) totalPrice += 40.0;


        if (a5OffRadioButton.isSelected()) {
            totalPrice *= 0.95;
        } else if (a10OffRadioButton.isSelected()) {
            totalPrice *= 0.90;
        } else if (a15OffRadioButton.isSelected()) {
            totalPrice *= 0.85;
        }

        JOptionPane.showMessageDialog(this, "The total price is Php " + String.format("%.2f", totalPrice));
    }

    public static void main(String[] args) {

        FoodOrdering app = new FoodOrdering();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(500, 600);
        app.setTitle("Food Ordering System");
        app.setVisible(true);
    }
}
