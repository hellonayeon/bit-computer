package me.hellonayeon.dto;

public class Human {

    private String name;

    private String phone;

    private String email;

    private String birth;

    public Human() {}

    public Human(String name, String phone, String email, String birth) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return "Human{" +
            "name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            ", birth='" + birth + '\'' +
            '}';
    }
}
