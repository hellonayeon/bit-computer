package BaseballTeam.domain;

public class Human {
    private int no;
    private String name;
    private int age;
    private double height;

    public Human(int no, String name, int age, double height) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public Human(String[] split) {
        this.no = Integer.parseInt(split[0]);
        this.name = split[1];
        this.age = Integer.parseInt(split[2]);
        this.height = Double.parseDouble(split[3]);
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }

    public String toStringData() {
        return no + "," + name + "," + age + "," + height;
    }
}
