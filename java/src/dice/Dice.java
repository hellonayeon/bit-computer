package dice;

public class Dice {
    private int number;

    public void setNumber() {
        number = (int)((Math.random()*6) + 1);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
