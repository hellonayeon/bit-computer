package sample03.panel;

import sample03.sist.form.CoffeeOrder;

import javax.swing.*;
import java.awt.*;

public class CoffeeOrderPanel extends Panel {

    public CoffeeOrderPanel() {
        setLayout(new FlowLayout());

        TextField coffeeCntTextField = new TextField("0");
        coffeeCntTextField.setColumns(3);

        Label coffeeCupsLabel = new Label("잔");
        JButton orderBtn = new JButton("주문하기");

        add(coffeeCntTextField);
        add(coffeeCupsLabel);
        add(orderBtn);
    }

}
