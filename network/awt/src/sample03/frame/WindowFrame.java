package sample03.frame;

import sample03.panel.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowFrame extends Frame implements WindowListener, MouseListener {

    private WindowMenuPanel windowMenuPanel;

    public WindowFrame() {
        setLayout(new BorderLayout(50, 50));

        this.windowMenuPanel = new WindowMenuPanel();
        add(windowMenuPanel, BorderLayout.NORTH);

        ContentPanel contentPanel = new ContentPanel();
        contentPanel.add(new CoffeeMenuPanel(), BorderLayout.NORTH);
        contentPanel.add(new CoffeeOptionPanel(), BorderLayout.CENTER);
        contentPanel.add(new CoffeeOrderPanel(), BorderLayout.SOUTH);

        contentPanel.setSize(400, 200);
        add(contentPanel);

        setSize(640, 480);
        setLocation(0, 0);
        setVisible(true);

        addMouseListener(this);
        addWindowListener(this);

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

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouse clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mouse pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouse released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouse entered");
        windowMenuPanel.setMPosLabel(e.getX(), e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouse exited");
    }
}
