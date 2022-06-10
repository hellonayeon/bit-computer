package BaseballTeam.dao;

import BaseballTeam.domain.HumanFactory;
import BaseballTeam.util.FileProcessor;
import BaseballTeam.domain.Batter;
import BaseballTeam.domain.Human;
import BaseballTeam.domain.Pitcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BaseballPlayerManager {

    private Scanner sc = new Scanner(System.in);
    private FileProcessor fp = new FileProcessor();

    private List<Human> player = new ArrayList<Human>();
    private int sequence; // file load 시 설정

    public BaseballPlayerManager() {

    }

    public void run() throws IOException {
        load();
        while (true) {
            System.out.println("[야구 팀 선수 관리]");
            System.out.println("(1) 선수 추가");
            System.out.println("(2) 선수 삭제");
            System.out.println("(3) 선수 검색"); // 이름
            System.out.println("(4) 선수 수정");
            System.out.println("(5) 선수 출력");
            System.out.println("(0) 종료");

            System.out.print("메뉴 선택: ");
            int sel = sc.nextInt();

            if (sel == 0) {
                break;
            }

            switch (sel) {
                case 1:
                    insert();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    print();
                    break;
            }
        }
        save();
    }

    private void insert() {
        System.out.print("[선수 추가] 포지션 입력(투수/타자): ");
        String position = sc.next();

        Human human = HumanFactory.getHuman(position, sequence++);
        player.add(human);
    }

    private void delete() {
        System.out.print("[선수 삭제] 번호: ");
        int no = sc.nextInt();

        player.removeIf(h -> h.getNo() == no);
    }

    private void search() {
        System.out.print("검색 옵션(번호 = 0, 이름 = 1): ");
        int sel = sc.nextInt();

        switch (sel) {
            case 0:
                System.out.print("번호 입력: ");
                int no = sc.nextInt();

                Optional<Human> human = player.stream()
                        .filter(h -> h.getNo() == no).findFirst();

                if (human.isPresent()) {
                    System.out.println(human);
                }

                break;
            case 1:
                System.out.print("이름 입력: ");
                String name = sc.next();

                List<Human> sPlayer = player.stream()
                        .filter(h -> h.getName().equals(name))
                        .collect(Collectors.toList());

                sPlayer.forEach(System.out::println);

                break;
        }
    }

    private void update() {
        System.out.print("[선수 수정] 번호: ");
        int no = sc.nextInt();

        for (int idx=0; idx< player.size(); idx++){
            Human uHuman = player.get(idx);
            if (uHuman.getNo() == no) {
                if (uHuman instanceof Pitcher) {
                    player.set(idx, HumanFactory.getHuman("투수", no));
                }
                else if (uHuman instanceof Batter) {
                    player.set(idx, HumanFactory.getHuman("타자", no));
                }
            }
        }


    }

    private void print() {
        this.player.forEach(System.out::println);
    }

    private void load() throws IOException {
        int lastNo = fp.loadFile(player);
        this.sequence = lastNo;
    }

    private void save() throws IOException {
        fp.saveFile(player);
    }
}
