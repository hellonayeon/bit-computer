package BaseballTeam.dao;

import BaseballTeam.domain.HumanFactory;
import BaseballTeam.util.file.FileProcessor;
import BaseballTeam.domain.Batter;
import BaseballTeam.domain.Human;
import BaseballTeam.domain.Pitcher;
import BaseballTeam.util.io.Printer;
import BaseballTeam.util.io.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BaseballDao {

    public List<Human> player = new ArrayList<Human>();
    public int sequence; // file load 시 설정

    public BaseballDao() {

    }

    public void insert(String position) {
        Human human = HumanFactory.getHuman(position, sequence++);
        player.add(human);
    }

    public void delete(int no) {
        player.removeIf(h -> h.getNo() == no);
    }

    // Object 로 받으면 호출하는 쪽에서도 객체 타입에 따라 조건문 붙고,
    // 검색 함수 내부 구현에서도 타입에 따라 조건 분기가 나뉨
    // -> DAO 클래스에서 입력을 받지 않기 위해 검색 값 까지 매개변수로 받도록 구현
    public void search(int filter, Object value) {
        switch (filter) {
            case 0:
                Integer no = (Integer) value;

                Optional<Human> human = player.stream()
                        .filter(h -> h.getNo() == no).findFirst();

                human.ifPresent(Printer::printHuman);

                break;
            case 1:
                String name = (String) value;

                List<Human> sPlayer = player.stream()
                        .filter(h -> h.getName().equals(name))
                        .collect(Collectors.toList());

                Printer.printList(sPlayer);

                break;
        }
    }

    public void update(int no) {
        for (int idx = 0; idx < player.size(); idx++) {
            Human uHuman = player.get(idx);
            if (uHuman.getNo() == no) {
                if (uHuman instanceof Pitcher) {
                    player.set(idx, HumanFactory.getHuman("투수", no));
                } else if (uHuman instanceof Batter) {
                    player.set(idx, HumanFactory.getHuman("타자", no));
                }
                break;
            }
        }
    }

    public void printAll() {
        Printer.printList(player);
    }

    public void print(Human human) {
        Printer.printHuman(human);
    }

    public void load() throws IOException {
        this.sequence = FileProcessor.loadFile(player);
    }

    public void save() throws IOException {
        FileProcessor.saveFile(player);
    }
}
