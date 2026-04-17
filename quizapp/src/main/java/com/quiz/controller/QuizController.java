package com.quiz.controller;


import com.quiz.model.Question;
import com.quiz.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {


    private final QuizService quizService;

    public QuizController(QuizService quizService){
        this.quizService = quizService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("/get/{Id}")
    public ResponseEntity<List<Question>> getQuestions(@PathVariable Long Id){
        return new ResponseEntity<>(quizService.getQuizQuestions(Id), HttpStatus.OK);
    }
}
