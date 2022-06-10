package BaseballTeam.util.io;

import BaseballTeam.domain.Human;

import java.util.List;

public class Printer {
    public static void printMenu() {
        System.out.println("[야구 팀 선수 관리]");
        System.out.println("(1) 선수 추가");
        System.out.println("(2) 선수 삭제");
        System.out.println("(3) 선수 검색"); // 이름
        System.out.println("(4) 선수 수정");
        System.out.println("(5) 선수 출력");
        System.out.println("(0) 종료");
    }

    // dao 에서 받은 리스트 출력
    public static void printList(List<Human> list) {
        list.forEach(System.out::println);
    }

    public static void printHuman(Human human) {
        System.out.println(human);
    }
}
