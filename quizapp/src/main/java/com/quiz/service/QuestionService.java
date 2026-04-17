package com.quiz.service;

import com.quiz.entity.QuestionEntity;
import com.quiz.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

   private final QuestionRepository questionRepository;

   public QuestionService(QuestionRepository questionRepository) {
       this.questionRepository = questionRepository;
   }


   public List<QuestionEntity> getAllQuestions(){
       return questionRepository.findAll();
   }

   public List<QuestionEntity> getQuestionByCategory(String category){
       return questionRepository.findByCategory(category);
   }

   public String addQuestion(QuestionEntity questionEntity){
        questionRepository.save(questionEntity);
       return "Success";
   }

}
