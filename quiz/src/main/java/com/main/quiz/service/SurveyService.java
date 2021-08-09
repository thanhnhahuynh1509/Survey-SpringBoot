package com.main.quizz.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.main.quizz.entity.Question;
import com.main.quizz.entity.Survey;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {

    private static List<Survey> surveys = new ArrayList<>();

    static {
        Question question1 = new Question(1, "RickRoll đạt 1 tỷ lượt xem vào ngày nào?", "29/7/2021",
                Arrays.asList("29/7/2021", "30/7/2021", "31/7/2021", "1/8/2021"));
        Question question2 = new Question(2, "RickRoll được trình bày bởi ai?", "Rick Astley",
                Arrays.asList("Justin Bieber", "Shawn Mendes", "Rick Astley", "Lionel Messi"));
        Question question3 = new Question(3, "Meme là gì?", "Tất cả đáp án trên", Arrays.asList("Ảnh chế",
                "Dùng hình ảnh, videoo đề mô tả một vấn đề trên xã hội", "Là meme", "Tất cả đáp án trên"));
        Question question4 = new Question(4, "Hello every...", "nyan", Arrays.asList("one", "nyan", "body", "thing"));

        List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3, question4));

        Survey survey = new Survey(1, "Khảo sát con dân ngành meme học",
                "Dành cho những người có chứng chỉ đại học meme", questions);

        surveys.add(survey);
    }

    // Get

    public List<Survey> getSurveys() {
        return surveys;
    }

    public Survey getSurvey(int surveyId) {
        for (Survey survey : surveys)
            if (survey.getId() == surveyId)
                return survey;
        return null;
    }

    public List<Question> getQuestions(int surveyId) {
        Survey survey = getSurvey(surveyId);

        if (survey == null) {
            return null;
        }

        return survey.getQuestions();
    }

    public Question getQuestion(int surveyId, int questionId) {
        List<Question> questions = getQuestions(surveyId);

        if (questions == null)
            return null;

        for (Question question : questions)
            if (question.getId() == questionId)
                return question;

        return null;
    }

    // Add

    public void addSurvey(Survey survey) {
        surveys.add(survey);
    }

    public boolean addQuestion(int surveyId, Question question) {
        Survey survey = getSurvey(surveyId);

        if (survey == null)
            return false;

        survey.getQuestions().add(question);

        return true;
    }

    // Delete

    public boolean deleteSurvey(int surveyId) {
        Survey survey = getSurvey(surveyId);

        if (survey == null)
            return false;

        surveys.remove(survey);

        return true;
    }

    public boolean deleteQuestions(int surveyId) {
        Survey survey = getSurvey(surveyId);

        if (survey == null)
            return false;

        survey.setQuestions(new ArrayList<>());
        return true;
    }

    public boolean deleteQuestion(int surveyId, int questionId) {
        List<Question> questions = this.getQuestions(surveyId);
        Question question = this.getQuestion(surveyId, questionId);

        if (question == null || questions == null)
            return false;

        questions.remove(question);

        return true;
    }

    // Update

    public boolean updateSurvey(int surveyId, Survey surveyUpdate) {

        int surveysSize = surveys.size();

        for (int i = 0; i < surveysSize; i++) {
            if (surveys.get(i).getId() == surveyId) {
                surveys.set(i, surveyUpdate);
                return true;
            }
        }

        return false;
    }

    public boolean updateQuestion(int surveyId, int questionId, Question question) {
        List<Question> questions = getQuestions(surveyId);
        int questionsSize = questions.size();

        for (int i = 0; i < questionsSize; i++) {
            if (questions.get(i).getId() == questionId) {
                questions.set(i, question);
                return true;
            }
        }
        return false;
    }

}
