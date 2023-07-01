package cet.backend.service.impl;

import cet.backend.mapper.PaperMapper;
import cet.backend.service.PaperHandleService;
import jakarta.annotation.Resource;


public class PaperHandleServicelmpl implements PaperHandleService {

    @Resource
    PaperMapper paperMapper;

    @Override
    public int createPaper(int test_id, String choiceQ1, String choiceW1, String choiceQ2,
                         String choiceW2, String choiceQ3, String choiceW3, String choiceQ4,
                         String choiceW4, String choiceQ5, String choiceW5, String choiceQ6,
                         String choiceW6, String choiceQ7, String choiceW7, String choiceQ8,
                         String choiceW8, String choiceQ9, String choiceW9, String choiceQ10,
                         String choiceW10, String translationQ, String writingQ) {
        int res = paperMapper.createPaper(test_id, choiceQ1, choiceW1, choiceQ2, choiceW2, choiceQ3, choiceW3, choiceQ4,
                choiceW4, choiceQ5, choiceW5, choiceQ6, choiceW6, choiceQ7, choiceW7, choiceQ8, choiceW8, choiceQ9,
                choiceW9, choiceQ10, choiceW10, translationQ, writingQ);
        return res;
    }

}
