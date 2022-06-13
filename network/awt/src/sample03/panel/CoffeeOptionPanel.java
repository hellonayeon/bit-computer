package sample03.panel;

import java.awt.*;

public class CoffeeOptionPanel extends Panel {

    public CoffeeOptionPanel() {
        setLayout(new FlowLayout());

        add(new SizeOptionPanel());
        add(new SyrupOptionPanel());
        add(new EtcOptionPanel());
    }

}
