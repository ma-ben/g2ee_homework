package com.example.homework_156;

public class hitCourse {
    String uId;
    String uName;
    String cId;
    String cName;
    int score;
    public hitCourse(String uId, String uName, String cId, String cName, int score) {
        this.uId = uId;
        this.uName = uName;
        this.cId = cId;
        this.cName = cName;
        this.score = score;
    }
    public String getuId() {return uId;}
    public void setuId(String uId) {this.uId = uId;}
    public String getcId() {return cId;}
    public void setcId(String cId) {this.cId = cId;}
    public int getScore() {return score;}
    public void setScore(int score) {this.score = score;}
    public String getuName() {return uName;}
    public void setuName(String uName) {this.uName = uName;}
    public String getcName() {return cName;}
    public void setcName(String cName) {this.cName = cName;}
}
