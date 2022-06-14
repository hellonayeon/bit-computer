package domain;

import java.net.Socket;
import java.util.Date;

public class User {

    private String id; // 아이디: 사용자 식별자

    private String name; // 이름: 채팅방에서 사용되는 이름

    private Date createdAt; // 로그인 시점

    private Socket socket; // 현재 입장한 채팅방의 소켓

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.createdAt = new Date();
    }
}
