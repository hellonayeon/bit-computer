package view;

import net.WriteClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.Socket;

/* 채팅 폼 */
public class ClientFrame extends JFrame implements WindowListener, ActionListener {

    public Socket socket;
    WriteClass wc;

    public JTextField textF = new JTextField(20);
    public JTextArea textA = new JTextArea();

    JButton btnTransfer = new JButton("전송");
    JButton btnExit = new JButton("종료");

    JPanel panel = new JPanel();

    public boolean isFirst = true; // 첫 번째 전송

    public ClientFrame(Socket socket) {
        super("채팅");

        this.socket = socket;

        wc = new WriteClass(socket, this);

        new IdFrame(this, wc);

        JScrollPane scrPane = new JScrollPane(textA);
        scrPane.setPreferredSize(new Dimension(200, 120));

        add("Center", scrPane);

        panel.add(textF);
        panel.add(btnTransfer);
        panel.add(btnExit);

        add("South", panel);

        btnTransfer.addActionListener(this);
        btnExit.addActionListener(this);

        setBounds(200, 200, 450, 600);

        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == btnTransfer || obj == textF) {

            if (textF.getText().trim().equals("")) {
                return;
            }

            String id = IdFrame.tf.getText();
            textA.append("[" + id + "]" + textF.getText() + "\n");

            // server 전송
            wc.sendMessage();
            textF.setText("");
        }
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
