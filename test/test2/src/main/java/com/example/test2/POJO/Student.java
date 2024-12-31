package com.example.test2.POJO;

import java.util.Date;

public class Student {
    private int stuno;
    private String stuname;
    private Date birthday;
    private String gender;
    private int score;

    public Student(){

    }
    public Student(int i, String alice, Date date, String 女, int i1) {
    }


    // Getters and setters

    public int getStuno() {
        return stuno;
    }

    public void setStuno(int stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
