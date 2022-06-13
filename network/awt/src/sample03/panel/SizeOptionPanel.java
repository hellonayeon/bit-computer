package sample03.panel;

import javax.swing.*;
import java.awt.*;

public class SizeOptionPanel extends OptionPanel {

    public SizeOptionPanel() {
        add(new Label("크기"));

        ButtonGroup sizeGroup = new ButtonGroup();
        JRadioButton sBtn1 = new JRadioButton("Short");
        JRadioButton sBtn2 = new JRadioButton("Tall");
        JRadioButton sBtn3 = new JRadioButton("Grande");

        sizeGroup.add(sBtn1);
        sizeGroup.add(sBtn2);
        sizeGroup.add(sBtn3);

        add(sBtn1);
        add(sBtn2);
        add(sBtn3);
    }

}
