package com.example.health.bean;

public class user {
    private int id;// 自增主键
    private String username;// 用户名
    private String password;// 密码
    private String email;// 邮箱
    private String role;// 角色
    private boolean state; // 状态

    public user() {
    }

    public user(int id, String username, String password, String email, String role, boolean state) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.state = state;
    }

    public String getusername() {
        return username;
    }

    public String getpassword() {
        return password;
    }

    public String getemail() {
        return email;
    }

    public String getrole() {
        return role;
    }

    public Boolean getstate() {
        return state;
    }

    public void setid(int id) {
        this.id = id;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public void setrole(String role) {
        this.role = role;
    }

    public void setstate(Boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", email='"
                + email + '\'' + ", role='" + role + '\'' + ", state=" + state + '}';
    }
}
