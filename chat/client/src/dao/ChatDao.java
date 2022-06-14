package dao;

import domain.ChatRoom;
import domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatDao {

    private User me;

    private List<User> users = new ArrayList<>(); // 현재 접속 중인 모든 사용자 리스트

    private List<User> lobbyUsers = new ArrayList<>();// 로비에 접속중인 사용자 리스트

    private Map<String, List<ChatRoom>> chatMap = new HashMap<>(); // 채팅방 목록 [key] 채팅방 이름, [value] 채팅방 객체 리스트 (채팅방 이름 중복 가능)

    public void setMe(User user) {
        this.me = user;
    }

    public void addUsers(User user) {
        users.add(user);
    }

    public void addLobbyUsers(User user) {
        lobbyUsers.add(user);
    }

}
