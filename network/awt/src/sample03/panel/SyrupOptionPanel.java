package sample03.panel;

import java.awt.*;

public class SyrupOptionPanel extends OptionPanel {

    public SyrupOptionPanel() {
        add(new Label("시럽"));

        CheckboxGroup syrupGroup = new CheckboxGroup();
        add(new Checkbox("바닐라", syrupGroup, false));
        add(new Checkbox("캐러맬", syrupGroup, false));
        add(new Checkbox("헤이즐럿", syrupGroup, false));

    }

}
