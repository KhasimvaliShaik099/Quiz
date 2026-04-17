package com.quiz.repository;

import com.quiz.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {


    List<QuestionEntity> findByCategory(String category);

    @Query(value = "SELECT * FROM question q where q.category = :category ORDER BY RAND()", nativeQuery = true)
    List<QuestionEntity> findRandamQuestionByCategory(String category);
}
