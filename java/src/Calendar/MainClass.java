package Calendar;

import java.util.Calendar;

public class MainClass {
    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);

        System.out.println(year + "/" + month + "/" + day);

        String ampm = cal.get(Calendar.AM_PM) == 0 ? "오전" : "오후";
        System.out.println(ampm);

        cal.set(Calendar.YEAR, 2022);
        cal.set(Calendar.MONTH, 8 - 1);
        cal.set(Calendar.DATE, 15);

        // 요일
        int weekday = cal.get(Calendar.DAY_OF_WEEK); // 1(일) ~ 7(토)

        switch (weekday) {
            case 1:
                System.out.println("월");
                break;
            case 2:
                System.out.println("화");
                break;
            case 3:
                System.out.println("수");
                break;
            case 4:
                System.out.println("목");
                break;
            case 5:
                System.out.println("금");
                break;
            case 6:
                System.out.println("토");
                break;
            case 7:
                System.out.println("일");
                break;
        }

        // 오늘
        cal.set(Calendar.YEAR, 2022);
        cal.set(Calendar.MONTH, 6 - 1);
        cal.set(Calendar.DATE, 8);

        int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
