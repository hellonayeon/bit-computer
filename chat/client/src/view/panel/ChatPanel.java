package view.panel;

import javax.swing.*;
import java.awt.*;

public class ChatPanel extends JPanel {

    JTextArea chatTextA = new JTextArea();

    JTextField msgTextF = new JTextField();

    JButton sendBtn = new JButton("전송");


    public ChatPanel(JFrame frame) {
        setLayout(null);

        // 채팅 메시지 영역 (스크롤)
        JScrollPane scrPane = new JScrollPane(chatTextA);
        scrPane.setBounds(10, 0, 380, 450);
        add(scrPane);

        // 메시지 입력 및 전송 영역

        msgTextF.setBounds(10, 460, 250, 35);
        add(msgTextF);

        sendBtn.setBounds(270, 460, 120, 35);
        sendBtn.setBackground(Color.GREEN);
        add(sendBtn);

        frame.add(this);

        setBackground(Color.RED);
        setBounds(10, 10, 400, 500);
    }

}
