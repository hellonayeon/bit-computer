package ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MyDataOperator {

    Scanner sc;
    List<MyData> objList;
    int size = 0;

    public MyDataOperator() {
        sc = new Scanner(System.in);
        objList = new ArrayList<MyData>();
        size = 0;
    }

    public void execute() {
        create();
        insert();
        search();
        update();
        delete();
    }

    private void create() {
        System.out.print("데이터 개수: ");
        size = sc.nextInt();
        for (int i=0; i<size; i++) {
            System.out.print("숫자: ");
            int number = sc.nextInt();

            System.out.print("이름: ");
            String name = sc.next();

            objList.add(new MyData(number, name));
        }
    }

    private void insert() {
        System.out.print("추가할 위치: ");
        int index = sc.nextInt();

        System.out.print("숫자: ");
        int number = sc.nextInt();

        System.out.print("이름: ");
        String name = sc.next();

        objList.add(index, new MyData(number, name));
    }

    private void search() {
        System.out.print("검색할 이름: ");
        String sname = sc.next();

        List<MyData> sObjList = objList.stream().filter(d -> d.getName().equals(sname)).collect(Collectors.toList());
        for (MyData data : sObjList) {
            System.out.println(data);
        }
    }

    private void update() {
        System.out.print("수정할 위치: ");
        int index = sc.nextInt();

        MyData uData = objList.get(index);
        System.out.print("숫자: ");
        int unumber = sc.nextInt();

        System.out.print("이름: ");
        String uname = sc.next();

        uData.setNumber(unumber);
        uData.setName(uname);
    }

    private void delete() {
        System.out.print("삭제할 위치: ");
        int index = sc.nextInt();
        objList.remove(index);
    }
}
