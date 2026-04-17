package com.quiz.service;

import com.quiz.entity.QuestionEntity;
import com.quiz.entity.QuizEntity;
import com.quiz.model.Question;
import com.quiz.repository.QuestionRepository;
import com.quiz.repository.QuizRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public QuizService(QuizRepository quizRepository, QuestionRepository questionRepository){
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<QuestionEntity> questionsList = questionRepository.findRandamQuestionByCategory(category);

        QuizEntity quizEntity = new QuizEntity();
        quizEntity.setTitle(title);
        quizEntity.setQuestionEntityList(questionsList);

        quizRepository.save(quizEntity);

        return new ResponseEntity<>("SUCESS", HttpStatus.CREATED);

    }

    public List<Question> getQuizQuestions(Long Id){
        Optional<QuizEntity> quiz =  quizRepository.findById(Id);
        List<QuestionEntity> allQuestions = quiz.get().getQuestionEntityList();
        List<Question> questionsForUser = new ArrayList<>();

        for(QuestionEntity q : allQuestions){
            Question questionUser = new Question(q.getId(), q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(questionUser);
        }
        return questionsForUser;
    }
}
