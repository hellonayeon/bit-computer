package Calendar;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class CalendarPrinter {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("시작 년월 입력: ");
        int[] start = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.print("종료 년월 입력: ");
        int[] end = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int year = start[0];
        int month = start[1];

        String[] calendar = new String[35];
        while (year != end[0] + 1 && month != end[1] + 1) {
            setCalendar(calendar, year, month);
            printCalendar(calendar);

            month++;
            if (month > 11) {
                year++;
                month = 0;
            }
        }
    }

    private static void setCalendar(String[] calendar, int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);

        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int date = cal.get(Calendar.DAY_OF_WEEK) - 1; // 1 ~ 7
        System.out.println(days);

        int idx = 0;
        for (; idx<date; idx++) {
            calendar[idx] = "*";
        }

        int cnt = 1;
        while (days-- > 0) {
            calendar[idx++] = Integer.toString(cnt++);
        }

        for (; idx<35; idx++) {
            calendar[idx] = "*";
        }
    }

    private static void printCalendar(String[] calendar) {
        System.out.print("일\t월\t화\t수\t목\t금\t토\t");
        for (int i=0; i<35; i++) {
            if (i % 7 == 0) {
                System.out.println();
            }
            System.out.print(calendar[i] + "\t");
        }
        System.out.println("\n");
    }
}
