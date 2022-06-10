package BaseballTeam.domain;

import BaseballTeam.domain.Batter;
import BaseballTeam.domain.Human;
import BaseballTeam.domain.Pitcher;

import java.util.Scanner;

public class HumanFactory {

    public static Human getHuman(String position, int no) {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름: ");
        String name = sc.next();

        System.out.print("나이: ");
        int age = sc.nextInt();

        System.out.print("키: ");
        double height = sc.nextDouble();

        if (position.equals("투수")) {
            System.out.print("승: ");
            int win = sc.nextInt();

            System.out.print("패: ");
            int loss = sc.nextInt();

            return new Pitcher(no, name, age, height, win, loss);
        }
        else if (position.equals("타자")) {
            System.out.print("타수: ");
            int atBats = sc.nextInt();

            System.out.print("안타수: ");
            int hits = sc.nextInt();

            return new Batter(no, name, age, height, atBats, hits);
        }

        return null;
    }

}
