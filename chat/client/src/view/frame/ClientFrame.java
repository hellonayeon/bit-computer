package view.frame;

import view.panel.ChatPanel;
import view.panel.ChatRoomListPanel;
import view.panel.MenuPanel;
import view.panel.UserListPanel;

import javax.swing.*;

public class ClientFrame extends JFrame {

    ChatPanel chatPanel;

    ChatRoomListPanel chatRoomListPanel;

    MenuPanel menuPanel;

    UserListPanel userListPanel;

    public ClientFrame() {
        setLayout(null);
        setSize(830, 550);

        chatPanel = new ChatPanel(this);
        userListPanel = new UserListPanel(this);
        chatRoomListPanel = new ChatRoomListPanel(this);
        menuPanel = new MenuPanel(this);

        setVisible(true);


    }

}
