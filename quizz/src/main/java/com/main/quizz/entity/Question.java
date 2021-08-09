package com.main.quizz.entity;

import java.util.List;

public class Question {

    private int id;
    private String title;
    private String correctAnswer;
    private List<String> options;

    public Question() {
    }

    public Question(int id, String title, String correctAnswer, List<String> options) {
        this.id = id;
        this.title = title;
        this.correctAnswer = correctAnswer;
        this.options = options;
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

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

}
