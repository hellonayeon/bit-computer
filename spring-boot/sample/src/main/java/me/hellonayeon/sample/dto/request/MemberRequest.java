package me.hellonayeon.sample.dto.request;

public class MemberRequest {
    private String id;
    private String pwd;
    private String name;
    private String email;
    private Integer auth;

    public MemberRequest(String id, String pwd, String name, String email, Integer auth) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.email = email;
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "MemberRequest{" +
            "id='" + id + '\'' +
            ", pwd='" + pwd + '\'' +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", auth=" + auth +
            '}';
    }
}
