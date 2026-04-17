package com.quiz.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    private Long id;
    private String question_title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
