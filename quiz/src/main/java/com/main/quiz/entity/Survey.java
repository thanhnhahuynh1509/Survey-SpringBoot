package com.main.quizz.entity;

import java.util.List;

public class Survey {

    private int id;
    private String title;
    private String desc;
    private List<Question> questions;

    public Survey() {
    }

    public Survey(int id, String title, String desc, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}
