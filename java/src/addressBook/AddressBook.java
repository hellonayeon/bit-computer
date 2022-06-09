package addressBook;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

// 요구사항이 명확하지 않을때는 간단하게 프로그래밍
// 배열을 무조건 요소 개수에 맞추려 하지 말고 넉넉하게 잡아두고 프로그래밍하면 생각하기 수월
public class AddressBook {
    private Scanner sc = new Scanner(System.in);
    private File file = new File("./address.txt");

    private Person[] people;
    private int personCnt;

    public AddressBook() {
        people = new Person[100];
        personCnt = 0;
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
        people[personCnt++] = new Person(personInfo);
    }

    private void delete() {
        System.out.print("[삭제] 삭제할 위치: ");
        int index = sc.nextInt();

        for (int i=index; i<personCnt-1; i++) {
            people[i] = people[i+1];
        }
        people[--personCnt] = null;
    }

    private void search() {
        System.out.print("[검색] 이름: ");
        String name = sc.next();

        Person[] sPeople = Arrays.stream(people).filter(p -> p.getName().equals(name)).toArray(Person[]::new);
        print(sPeople);
    }

    private void update() {
        System.out.print("[수정] 수정할 위치: ");
        int index = sc.nextInt();

        System.out.println("[수정] 이름,나이,전화번호,주소,메모 ");
        String personInfo = sc.next();
        people[index] = new Person(personInfo);
    }

    private void load() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String info;
        while ((info = br.readLine()) != null) {
            people[personCnt++] = new Person(info);
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

    private void print(Person[] people) {
        for (Person p : people) {
            System.out.println(p);
        }

    }
}
