package view.panel;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    JButton lobbyBtn = new JButton("로비");

    JButton chatListBtn = new JButton("채팅 목록");

    public MenuPanel(JFrame frame) {
        setLayout(null);

        lobbyBtn.setBounds(10, 10, 100, 35);
        add(lobbyBtn);

        chatListBtn.setBounds(110, 10, 100, 35);
        add(chatListBtn);

        frame.add(this);

        setBackground(Color.GRAY);
        setBounds(410, 460, 400, 50);
        setVisible(true);
    }


}
