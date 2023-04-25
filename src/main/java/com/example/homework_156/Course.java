package com.example.homework_156;

public class Course {
    private String cId;
    private String cName;
    private int cNum;
    private String cType;
    public Course(){};
    public Course(String id,String name,int num,String type)
    {
     cId=id;cName=name;cNum=num;cType=type;
    }
    public void setcId(String id){cId=id;}
    public String getcId(){return cId;}
    public void setcName(String name){cName=name;}
    public String getcName(){return cName;}
    public void setcNum(int num){cNum=num;}
    public int getcNum(){return cNum;}
    public void setcType(String type){cType=type;}
    public String getcType(){return cType;}
}
