package sample03.panel;

import javax.swing.*;
import java.awt.*;

public class EtcOptionPanel extends OptionPanel {

    public EtcOptionPanel() {
        add(new Label("기타"));

        add(new JCheckBox("샷 추가", false));
        add(new Checkbox("휘핑 크림", false));
    }

}
