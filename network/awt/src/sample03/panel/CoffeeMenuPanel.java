package sample03.panel;

import java.awt.*;

public class CoffeeMenuPanel extends Panel {

    public CoffeeMenuPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER));

        Choice coffeeChoice = new Choice();
        coffeeChoice.add("카라멜 마끼아또");
        coffeeChoice.add("바닐라 라떼");
        coffeeChoice.add("아메리카노");
        coffeeChoice.add("콜드브루");
        coffeeChoice.add("라떼");

        coffeeChoice.setSize(600, 200); // not working
        add(coffeeChoice);
    }

}
