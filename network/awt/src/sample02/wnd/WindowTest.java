package sample02.wnd;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener {

    public WindowTest() {

//        setLayout(new FlowLayout());
//        setLayout(new GridLayout(3, 1));
        setLayout(null);

        Label label = new Label();
        label.setText("레이블입니다.");
        label.setBackground(Color.red);
        add(label);

        Button btn = new Button();
        btn.setBounds(100, 100, 150, 30);
        btn.setLabel("버튼");
        add(btn);

        TextField textField = new TextField();
        btn.setBounds(100, 200, 200, 100);
        add(textField);

        setSize(460, 480);
        setBackground(Color.gray);
        setLocation(0, 0);
        setVisible(true);

        addWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
