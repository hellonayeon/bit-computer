package addressBook;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressListBook {
    private Scanner sc = new Scanner(System.in);
    private File file = new File("./address.txt");

    private List<Person> people;

    public AddressListBook() {
        people = new ArrayList<>();
    }

    public void run() throws IOException {
        int sel;
        while (true) {
            System.out.println("[주소록 프로그램]");
            System.out.println("(1) 추가");
            System.out.println("(2) 삭제");
            System.out.println("(3) 검색");
            System.out.println("(4) 수정");
            System.out.println("(5) 모든 데이터 출력");
            System.out.println("(6) 데이터 저장");
            System.out.println("(0) 종료");
            System.out.println();

            System.out.print("메뉴 선택: ");
            sel = Integer.parseInt(sc.next());

            if (sel == 0) {
                break;
            }

            load();
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
                    printAll();
                    break;
                case 6:
                    save();
                    break;
            }
        }
        save();
    }

    private void insert() {
        System.out.println("[입력] 이름,나이,전화번호,주소,메모 ");
        String personInfo = sc.next();
        people.add(new Person(personInfo));
    }

    private void delete() {
        System.out.print("[삭제] 삭제할 위치: ");
        int index = sc.nextInt();
        people.remove(index);
    }

    private void search() {
        System.out.print("[검색] 이름: ");
        String name = sc.next();

        List<Person> sPeople = people.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
        print(sPeople);
    }

    private void update() {
        System.out.print("[수정] 수정할 위치: ");
        int index = sc.nextInt();

        System.out.println("[수정] 이름,나이,전화번호,주소,메모 ");
        String personInfo = sc.next();
        people.set(index, new Person(personInfo));
    }

    private void load() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String info;
        while ((info = br.readLine()) != null) {
            people.add(new Person(info));
        }
    }

    private void save() throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        for (Person p : people) {
            if (p == null) {
                break;
            }
            pw.println(p.getName() + "," + p.getAge() + "," + p.getPhone() + "," + p.getAddress() + "," + p.getMemo());
        }
        pw.close();
    }

    private void printAll() {
        for (Person p : this.people) {
            if (p == null) {
                break;
            }
            System.out.println(p);
        }
    }

    private void print(List<Person> people) {
        for (Person p : people) {
            System.out.println(p);
        }

    }
}
