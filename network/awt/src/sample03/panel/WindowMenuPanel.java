package sample03.panel;

import java.awt.*;

public class WindowMenuPanel extends Panel {

    private Label mPosLabel;
    private Button menuBtn;

    public WindowMenuPanel() {
        setLayout(new BorderLayout(20, 20));

        mPosLabel = new Label("x: 0 y: 0");
        add(mPosLabel, BorderLayout.WEST);

        menuBtn = new Button("메뉴 보기");
        add(menuBtn, BorderLayout.EAST);
    }

    public void setMPosLabel(int x, int y) {
        mPosLabel.setText("x: " + x + " y: " + y);
    }

}
