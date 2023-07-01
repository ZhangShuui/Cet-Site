package cet.backend.service;

import cet.backend.entity.ExamRelated.AnswerInfo;
import cet.backend.entity.ExamRelated.ExamInfo;
import cet.backend.entity.ExamRelated.PaperInfo;

public interface PaperHandleService {
    int createPaper(int test_id, String choiceQ1, String choiceW1, String choiceQ2,
                    String choiceW2, String choiceQ3, String choiceW3, String choiceQ4,
                    String choiceW4, String choiceQ5, String choiceW5, String readingQ1,
                    String readingQ2, String choiceQ6, String choiceW6, String choiceQ7,
                    String choiceW7, String choiceQ8, String choiceW8, String choiceQ9,
                    String choiceW9, String choiceQ10, String choiceW10, String translationQ, String writingQ);
}
