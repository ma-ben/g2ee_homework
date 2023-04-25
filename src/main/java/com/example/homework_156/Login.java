package com.example.homework_156;

public class Login {

    private String uid;
    private String username;
    private String password;
    private String school;
    private String dept;
    public Login(){}
    public Login(String id, String username, String password, String school, String dept) {
        this.uid=id;
        this.username = username;
        this.password = password;
        this.school = school;
        this.dept = dept;
    }

    public String getUid() {return uid;}

    public void setUid(String uid) {this.uid = uid;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getSchool() {return school;}

    public void setSchool(String school) {this.school = school;}

    public String getDept() {return dept;}

    public void setDept(String dept) {this.dept = dept;}
}
