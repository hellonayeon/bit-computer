package sample03.frame;

import java.awt.*;
import java.awt.event.*;

public class WindowFrame extends Frame implements WindowListener {

    private Label mouseMovePosLabel;

    public WindowFrame() {
        setLayout(null);
        setSize(640, 480);
        setVisible(true);

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                mouseMovePosLabel.setText("x: " + e.getX() + " y: " + e.getY());
            }
        });

        addWindowMenu();
        addCoffeeMenu();
        addSizeOptionCheckbox();
        addSyrupOptionCheckbox();
        addEtcOptionCheckbox();
        addOrderMenu();

        addWindowListener(this);
    }

    private void addWindowMenu() {
        mouseMovePosLabel = new Label("x: 0 y: 0");
        mouseMovePosLabel.setBounds(20, 50, 150, 20);
        add(mouseMovePosLabel);

        Button windowMenuBtn = new Button("Show Menu");
        windowMenuBtn.setBounds(470, 50, 150, 20);
        add(windowMenuBtn);
    }

    private void addCoffeeMenu() {
        Choice coffeeChoice = new Choice();
        coffeeChoice.add("Caramel Macchiato");
        coffeeChoice.add("Americano");
        coffeeChoice.add("Cappuccino");
        coffeeChoice.add("Latte");
        coffeeChoice.add("Vanilla latte");
        coffeeChoice.setBounds(120, 150,400, 20);
        add(coffeeChoice);
    }

    private void addSizeOptionCheckbox() {
        Label sizeLabel = new Label("Size");
        sizeLabel.setBounds(100, 190, 100, 20);
        add(sizeLabel);

        CheckboxGroup sizeGroup = new CheckboxGroup();

        Checkbox shortSize = new Checkbox("Short", sizeGroup, true);
        Checkbox tallSize = new Checkbox("Tall", sizeGroup, false);
        Checkbox grandeSize = new Checkbox("Grande", sizeGroup, false);

        shortSize.setBounds(90, 220, 100, 20);
        tallSize.setBounds(90, 250, 100, 20);
        grandeSize.setBounds(90, 280, 100, 20);

        add(shortSize);
        add(tallSize);
        add(grandeSize);

    }

    private void addSyrupOptionCheckbox() {
        Label syrupLabel = new Label("Syrup");
        syrupLabel.setBounds(240, 190, 100, 20);
        add(syrupLabel);

        CheckboxGroup syrupGroup = new CheckboxGroup();
        Checkbox vanillaSyrup = new Checkbox("Vanilla", syrupGroup, true);
        Checkbox hazelnutSyrup = new Checkbox("Hazelnut", syrupGroup, false);
        Checkbox caramelSyrup = new Checkbox("Caramel", syrupGroup, false);

        vanillaSyrup.setBounds(230, 220, 100, 20);
        hazelnutSyrup.setBounds(230, 250, 100, 20);
        caramelSyrup.setBounds(230, 280, 100, 20);

        add(vanillaSyrup);
        add(hazelnutSyrup);
        add(caramelSyrup);
    }

    private void addEtcOptionCheckbox() {
        Label etcLabel = new Label("Etc");
        etcLabel.setBounds(400, 190, 100, 20);
        add(etcLabel);

        Checkbox whippedCream = new Checkbox("Whipped Cream");
        Checkbox espressoShort = new Checkbox("Espresso Short");

        whippedCream.setBounds(390, 220, 150, 20);
        espressoShort.setBounds(390, 250, 150, 20);

        add(whippedCream);
        add(espressoShort);
    }

    private void addOrderMenu() {
        TextField coffeeCupsField = new TextField("0");
        coffeeCupsField.setBounds(190, 400, 50, 20);
        add(coffeeCupsField);

        Label cupsLabel = new Label("Cups");
        cupsLabel.setBounds(250, 400, 50, 20);
        add(cupsLabel);

        Button orderBtn = new Button("Order");
        orderBtn.setBounds(320, 400, 50, 20);
        add(orderBtn);
    }


    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("window opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("window closing");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("window closed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("window iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("window de iconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("window activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) { System.out.println("window deactivated"); }
}
