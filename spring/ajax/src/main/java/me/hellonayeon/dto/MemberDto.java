package me.hellonayeon.dto;

public class MemberDto {

    private int number;

    private String name;

    public MemberDto() {}

    public MemberDto(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
            "number=" + number +
            ", name='" + name + '\'' +
            '}';
    }
}
