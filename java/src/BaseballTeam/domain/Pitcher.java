package BaseballTeam.domain;

import java.util.Arrays;

public class Pitcher extends Human {
    private int win;
    private int loss;
    private double era;

    public Pitcher(int no, String name, int age, double height,
                   int win, int loss) {
        super(no, name, age, height);
        this.win = win;
        this.loss = loss;

        calcEra();
    }

    public Pitcher(String[] split) {
        super(Arrays.copyOfRange(split, 0, 4));

        this.win = Integer.parseInt(split[4]);
        this.loss = Integer.parseInt(split[5]);
        this.era = Double.parseDouble(split[6]);
    }

    public void calcEra() {
        era = (double)(loss*9)/(win + loss);
    }

    public int getWin() {
        return win;
    }

    public int getLoss() {
        return loss;
    }

    public double getEra() {
        return era;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Pitcher{" +
                    "win=" + win +
                    ", loss=" + loss +
                    ", era=" + era +
                '}';
    }
}
