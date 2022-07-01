package human;

public class HumanTwo {

    private int number;
    private String name;

    public HumanTwo() {

    }

    public HumanTwo(int number, String name) {
        this.number = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return "human.HumanTwo{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }
}
