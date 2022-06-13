package sample03.wnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// WindowListener: 윈도우용
// ActionListener: 버튼용
public class WindowTest extends Frame implements WindowListener, ActionListener {

    Label label;
    Button button1, button2;
    TextField textField = new TextField();

    public WindowTest() {
        setLayout(null);

        label = new Label("button event");
        label.setBounds(10, 60, 620, 30);
        label.setBackground(new Color(0, 255, 0));
        add(label);

        button1 = new Button("button one");
        button1.setBounds(50, 120, 100, 50);
        button1.addActionListener(this);
        add(button1);

        button2 = new Button("button two");
        button2.setBounds(200, 120, 100, 50);
        button2.addActionListener(this);
        add(button2);

        textField.setBounds(50, 240, 100, 50);
        add(textField);

        setSize(640, 480);
        setLocation(0, 0);
        setVisible(true);

        addWindowListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("button click !");

        Button btn = (Button) e.getSource();
        String btnName = btn.getLabel();

        if (btnName.equals("button one")) {
//            JOptionPane.showMessageDialog(null, "button 1 click !");
            textField.setText("button 1 click !");
        }
        else if (btnName.equals("button two")) {
//            JOptionPane.showMessageDialog(null, "button 2 click !");
            textField.setText("button 2 click");
        }
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
    public void windowDeactivated(WindowEvent e) {
        System.out.println("window deactivated");
    }
}
