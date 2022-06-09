package addressBook;

public class Person {
    private String name;
    private int age;
    private String phone;
    private String address;
    private String memo;

    public Person(String input) {
        String[] strs = input.split(",");
        name = strs[0];
        age = Integer.parseInt(strs[1]);
        phone = strs[2];
        address = strs[3];
        memo = strs[4];
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getMemo() {
        return memo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
