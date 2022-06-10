package BaseballTeam.util.io;

import java.util.Scanner;

public class Reader {

    private static Scanner sc = new Scanner(System.in);

    // 입력받은 값 검증
    // 바로 리턴 X
    public static int readMenu() {
        System.out.print("메뉴 선택: ");
        return sc.nextInt();
    }

    public static String readPosition() {
        System.out.print("[선수 추가] 포지션 입력(투수/타자): ");
        return sc.next();
    }

    public static int readDeleteNo() {
        System.out.print("[선수 삭제] 번호: ");
        return sc.nextInt();
    }

    public static int readSearchFilter() {
        System.out.print("[선수 검색] 필터(번호 = 0, 이름 = 1): ");
        return sc.nextInt();
    }

    public static int readSearchNo() {
        System.out.print("번호 입력: ");
        return sc.nextInt();
    }

    public static String readSearchName() {
        System.out.print("이름 입력: ");
        return sc.next();
    }

    public static int readUpdateNo() {
        System.out.print("[선수 수정] 번호: ");
        return sc.nextInt();
    }
}
