package com.main.quizz.controller;

import java.util.List;

import com.main.quizz.entity.Question;
import com.main.quizz.entity.Survey;
import com.main.quizz.service.SurveyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/surveys")
public class SurveyController {

    @Autowired
    SurveyService surveyService;

    // CREATE

    // done
    @PostMapping("")
    public ResponseEntity<?> addSurvey(@RequestBody Survey survey) {
        surveyService.addSurvey(survey);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // done
    @PostMapping("/{surveyId}/questions")
    public ResponseEntity<?> addQuestion(@PathVariable int surveyId, @RequestBody Question question) {
        boolean isUpdated = surveyService.addQuestion(surveyId, question);

        if (!isUpdated)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // READ

    // done
    @GetMapping("")
    public List<Survey> getSurveys() {
        return surveyService.getSurveys();
    }

    // done
    @GetMapping("/{surveyId}")
    public Survey getSurvey(@PathVariable int surveyId) {
        return surveyService.getSurvey(surveyId);
    }

    // done
    @GetMapping("/{surveyId}/questions")
    public List<Question> getQuestions(@PathVariable int surveyId) {
        return surveyService.getQuestions(surveyId);
    }

    // done
    @GetMapping("/{surveyId}/questions/{questionId}")
    public Question getQuestion(@PathVariable int surveyId, @PathVariable int questionId) {
        return surveyService.getQuestion(surveyId, questionId);
    }

    // UPDATE

    // done
    @PutMapping("/{surveyId}")
    public ResponseEntity<?> updateSurvey(@PathVariable int surveyId, @RequestBody Survey surveyUpdate) {
        boolean isUpdated = surveyService.updateSurvey(surveyId, surveyUpdate);

        if (isUpdated) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // done
    @PutMapping("/{surveyId}/questions/{questionId}")
    public ResponseEntity<?> updateQuestion(@PathVariable int surveyId, @PathVariable int questionId,
            @RequestBody Question question) {

        boolean isUpdated = surveyService.updateQuestion(surveyId, questionId, question);

        if (isUpdated) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE

    // done
    @DeleteMapping("/{surveyId}")
    public ResponseEntity<?> deleteSurvey(@PathVariable int surveyId) {

        boolean isDeleted = surveyService.deleteSurvey(surveyId);

        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // done
    @DeleteMapping("/{surveyId}/questions")
    public ResponseEntity<?> deleteQuestions(@PathVariable int surveyId) {

        boolean isDeleted = surveyService.deleteQuestions(surveyId);

        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // done
    @DeleteMapping("/{surveyId}/questions/{questionId}")
    public ResponseEntity<?> deleteQuestion(@PathVariable int surveyId, @PathVariable int questionId) {

        boolean isDeleted = surveyService.deleteQuestion(surveyId, questionId);

        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
