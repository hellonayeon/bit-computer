package service;

import dao.ChatDao;
import domain.User;

public class ChatService {

    private ChatDao chatDao = new ChatDao();

    public void login(User user) {
        chatDao.setMe(user);
        chatDao.addUsers(user);
        chatDao.addLobbyUsers(user);

        System.out.println("로그인");
    }



}
