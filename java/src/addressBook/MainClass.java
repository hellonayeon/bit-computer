package addressBook;

import java.io.*;
import java.util.Scanner;

public class MainClass {

    static File file = new File("./address.txt");
    static Scanner sc = new Scanner(System.in);

    static final int COL_SIZE = 5;
    static final String[] COL_TAG = { "이름", "나이", "전화번호", "주소", "메모" };

    static String[][] address; // 주소록 데이터
    static int rowSize; // 주소록 개수

    public static void main(String[] args) throws IOException {
        /**
         *
         * 주소록
         *
         * column: 이름, 나이, 전화번호, 주소, 메모
         *
         * 2차원 배열: row = 100"
         *
         * 프로그램 시작 시 데이터 파일에서 불러오기 (address.txt) -> 2차원 배열
         *
         * Menu
         * 1. 추가
         * 2. 삭제
         * 3. 검색 (이름, 전화번호) (검색의 종류 늘려보기)
         * 4. 수정 -> 데이터 목록을 보여주고 레코드 선택하도록? 레코드 선택, 열(내용) 선택
         * 5. 모든 데이터 출력
         * 6. 데이터 저장
         * 7. 종료
         *
         */

        read();

        int sel;
        while (true) {
            printMenu();

            System.out.print("메뉴 선택: ");
            sel = Integer.parseInt(sc.nextLine());

            switch (sel) {
                case 0:
                    System.out.println("주소록 프로그램을 종료합니다.");
                    return;
                case 1:
                    add();
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
                    printAddress();
                    break;
                case 6:
                    write();
                    break;
            }
        }

    }

    private static void printMenu() {
        System.out.println("[주소록 프로그램]");
        System.out.println("(1) 추가");
        System.out.println("(2) 삭제");
        System.out.println("(3) 검색");
        System.out.println("(4) 수정");
        System.out.println("(5) 모든 데이터 출력");
        System.out.println("(6) 데이터 저장");
        System.out.println("(0) 종료");
    }

    private static void read() throws IOException {
        sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new FileReader(file));
        rowSize = 0;
        while ((br.readLine()) != null) {
            rowSize++;
        }

        address = new String[rowSize][COL_SIZE];

        int row = 0;
        String contents = "";
        br = new BufferedReader(new FileReader(file));
        while ((contents = br.readLine()) != null) {
            String[] elems = contents.split(", ");

            for (int i=0; i<elems.length; i++) { // arraycopy
                address[row][i] = elems[i];
            }
            row++;
        }
        br.close();
    }

    private static void printAddress() {
        System.out.println("[주소 목록]");

        for (int i = 0; i< rowSize; i++) {
            System.out.print((i+1) + ". ");
            for (int j=0; j<COL_SIZE; j++) {
                System.out.print(address[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void add() {
        String[] col = new String[COL_SIZE];

        for (int i=0; i<COL_SIZE; i++) {
            System.out.print(COL_TAG[i] + ": ");
            col[i] = sc.nextLine();
        }

        String[][] newAddress = new String[rowSize + 1][COL_SIZE];
        System.arraycopy(address, 0 ,newAddress, 0, rowSize);
        newAddress[rowSize] = col;

        rowSize++;
        resizeAddress(newAddress);
    }

    private static void delete() {
        printAddress();

        int num;
        while (true) {
            System.out.print("삭제할 주소 번호 입력 (취소 = 0): ");
            num = Integer.parseInt(sc.nextLine());

            if (num < 0 || num > rowSize) {
                System.out.println(num + "번에 해당되는 주소가 없습니다. 주소 번호는 0부터 " + rowSize + "까지 입니다.");
                continue;
            }

            if (num == 0) {
                System.out.println("메뉴로 돌아갑니다.");
                return;
            }

            break;
        }

        String[][] newAddress = new String[rowSize-1][COL_SIZE];
        for (int i=0, idx = 0; i<rowSize; i++) {
            if (i == num-1) {
                continue;
            }
            newAddress[idx++] = address[i].clone();
        }

        rowSize--;
        resizeAddress(newAddress);
    }

    private static void search() {
        int filter;
        while (true) {
            System.out.print("검색 필터 이름(1) 전화번호(2) 종료(0): ");

            filter = Integer.parseInt(sc.nextLine());

            if (filter == 0) {
                System.out.println("메뉴로 돌아갑니다.");
                return;
            }

            if (filter >= 1 && filter <= 2) {
                break;
            }
        }

        int col = 0;
        switch(filter) {
            case 1:
                col = 0;
                break;
            case 2:
                col = 2;
                break;
        }

        String search;
        System.out.print("검색할 " + COL_TAG[col] + " 입력: ");
        search = sc.nextLine();

        String res = "";
        for (int i=0; i<rowSize; i++) {
            if (search.equals(address[i][col])) {
                res += String.join("\t", address[i]) + "\n";
            }
        }

        System.out.println(COL_TAG[col] + " = " + search + " 으로 검색한 결과");
        System.out.println(res);
    }

    private static void update() {
        printAddress();

        int num = 0;
        while (true) {
            System.out.print("수정할 주소 번호 입력 (취소 = 0): ");
            num = Integer.parseInt(sc.nextLine());

            if (num < 0 || num > rowSize) {
                System.out.println(num + "번에 해당되는 주소가 없습니다. 주소 번호는 0부터 " + rowSize + "까지 입니다.");
                continue;
            }

            if (num == 0) {
                System.out.println("메뉴로 돌아갑니다.");
                return;
            }

            break;
        }

        System.out.print("수정할 내용 입력 이름(1) 나이(2) 전화번호(3) 주소(4) 메모(5): ");
        int col = Integer.parseInt(sc.nextLine());

        System.out.print(COL_TAG[col-1] + " 변경: ");
        address[num-1][col-1] = sc.nextLine();

        printAddress();
    }

    private static void write() throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

        for (int i=0; i<rowSize; i++) {
            for (int j=0; j<COL_SIZE-1; j++) {
                pw.print(address[i][j]);
                pw.print(", ");
            }
            pw.print(address[i][COL_SIZE-1]);
            pw.println();
        }

        pw.close();
    }

    private static void resizeAddress(String[][] newAddress) {
        address = new String[rowSize][COL_SIZE];

        for (int i=0; i<rowSize; i++) {
            address[i] = newAddress[i].clone();
        }
    }
}
