package work03;

import java.util.Scanner;

public class MainClass {

    static final String[] TAG = { "학생 이름", "번호", "국어", "영어", "수학" };

    public static void main(String[] args) {
        /*
         * 학생 성적관리
         *
         * >> 학생 수
         * 2차원 배열 할당
         *
         * 입력
         * 학생 이름, 번호, 국어, 영어, 수학
         *
         * 국어의 최고 점수는 몇점? 누구?
         * 영어의 최하 점수는 몇점? 누구?
         *
         * 각 학생들의 총점, 평균
         *
         *
         * */

        Scanner sc = new Scanner(System.in);

        System.out.print("학생 수: ");
        int sLen = sc.nextInt();
        String[][] student = new String[sLen][5];

        for (int i=0; i<sLen; i++) {
            System.out.println((i+1) + "번째 학생");
            for (int j=0; j<5; j++) {
                System.out.print(TAG[j] + ": ");
                student[i][j] = sc.next();
            }
        }

        // 국어 최고점, 영어 최저점
        int korHighest = Integer.parseInt(student[0][2]);
        int engLowest = Integer.parseInt(student[0][3]);
        int kIdx = 0, eIdx = 0;

        for (int i=1; i<sLen; i++) {
            int korScore = Integer.parseInt(student[i][2]);
            int engScore = Integer.parseInt(student[i][3]);

            if (korScore > korHighest) {
                korHighest = korScore;
                kIdx = i;
            }

            if (engScore < engLowest) {
                engLowest = engScore;
                eIdx = i;
            }
        }

        System.out.println(student[kIdx][0] + "의 국어 점수가 " + student[kIdx][2] + "점 으로 최고점입니다.");
        System.out.println(student[eIdx][0] + "의 영어 점수가 " + student[eIdx][3] + "점 으로 최저점입니다.");

        // 총점, 평균
        for (int i=0; i<sLen; i++) {
            String[] s = student[i];
            int totalScore = Integer.parseInt(s[2]) + Integer.parseInt(s[3]) + Integer.parseInt(s[4]);
            double avg = totalScore / 3.0;

            System.out.println(s[0] + "학생 총점 = " + totalScore + "  평균 = " + String.format("%.2f", avg));
        }
    }
}
