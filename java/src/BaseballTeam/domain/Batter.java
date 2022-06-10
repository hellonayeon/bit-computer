package BaseballTeam.domain;

import java.util.Arrays;

public class Batter extends Human {
    private int atBats;
    private int hits;
    private double batAvg;


    public Batter(int no, String name, int age, double height,
                    int atBats, int hits) {
        super(no, name, age, height);
        this.atBats = atBats;
        this.hits = hits;

        calcBatAvg();
    }

    public Batter(String[] split) {
        super(Arrays.copyOfRange(split, 0, 4));

        this.atBats = Integer.parseInt(split[4]);
        this.hits = Integer.parseInt(split[5]);
        this.batAvg = Double.parseDouble(split[6]);
    }

    public void calcBatAvg() {
        batAvg = (double)hits/atBats;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Batter{" +
                    "atBats=" + atBats +
                    ", hits=" + hits +
                    ", batAvg=" + batAvg +
                "} ";
    }

    @Override
    public String toStringData() {
        return super.toStringData() + "," + atBats + "," + hits + "," + batAvg;
    }
}
