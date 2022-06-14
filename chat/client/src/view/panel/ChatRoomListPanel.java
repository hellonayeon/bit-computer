package view.panel;

import javax.swing.*;
import java.awt.*;

public class ChatRoomListPanel extends JPanel {

    public ChatRoomListPanel(JFrame frame) {
        setLayout(null);

        // 채팅 메시지 영역 (스크롤)
        JPanel labelPanel = new JPanel();
        labelPanel.setSize(400, 250);
        labelPanel.setBackground(Color.MAGENTA);
        labelPanel.setLayout(new GridLayout(30, 1));
        for (int i=0; i<30; i++) {
            labelPanel.add(new JLabel("Hell" + i));
        }

        JScrollPane scrPane = new JScrollPane(labelPanel);
        scrPane.setBounds(0, 0, 400, 250);
        scrPane.setBackground(Color.MAGENTA);
        add(scrPane);

        frame.add(this);

        setBackground(Color.BLUE);
        setBounds(410, 210, 400, 250);
    }
}
