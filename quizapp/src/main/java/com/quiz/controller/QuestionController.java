package com.quiz.controller;

import com.quiz.entity.QuestionEntity;
import com.quiz.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

   private final QuestionService questionService;

   public QuestionController(QuestionService questionService){
       this.questionService = questionService;
   }

    @GetMapping("/allQuestions")
    public ResponseEntity<List<QuestionEntity>> getAllQuestions(){
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<QuestionEntity>> getQuestionByCategrory(@PathVariable String category){
       return new ResponseEntity<>(questionService.getQuestionByCategory(category), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionEntity questionEntity){
       return new ResponseEntity<>(questionService.addQuestion(questionEntity),HttpStatus.CREATED);
    }
}
