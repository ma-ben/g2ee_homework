package com.example.homework_156;

public class CoursePage {
    String type;
    Course course;
    public CoursePage(String type, Course course) {
        this.type = type;
        this.course = course;
    }
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
    public Course getCourse() {return course;}
    public void setCourse(Course course) {this.course = course;}
}
