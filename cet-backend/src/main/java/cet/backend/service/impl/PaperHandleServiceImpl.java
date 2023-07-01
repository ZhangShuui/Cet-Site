package cet.backend.service.impl;

import cet.backend.entity.ExamRelated.choiceQuestion;
import cet.backend.mapper.PaperMapper;
import cet.backend.service.PaperHandleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PaperHandleServiceImpl implements PaperHandleService {

    @Resource
    PaperMapper paperMapper;

    private ArrayList<String> choices = new ArrayList<>();

    @Override
    public int createPaper(String choiceQ1, String choiceW1, String choiceQ2,
                           String choiceW2, String choiceQ3, String choiceW3, String choiceQ4,
                           String choiceW4, String choiceQ5, String choiceW5, String readingQ1,
                           String readingQ2, String choiceQ6, String choiceW6, String choiceQ7,
                           String choiceW7, String choiceQ8, String choiceW8, String choiceQ9,
                           String choiceW9, String choiceQ10, String choiceW10, String translationQ, String writingQ) {
        int res = paperMapper.createPaper(choiceQ1, choiceW1, choiceQ2, choiceW2, choiceQ3, choiceW3, choiceQ4,
                choiceW4, choiceQ5, choiceW5, readingQ1, readingQ2, choiceQ6, choiceW6, choiceQ7, choiceW7, choiceQ8, choiceW8,
                choiceQ9, choiceW9, choiceQ10, choiceW10, translationQ, writingQ);
        return res;
    }

    @Override
    public int addChoice(String combineChoice){
        choices.add(combineChoice);
        return choices.size();
    }

    @Override
    public ArrayList<String> getChoices(){
        return choices;
    }

    @Override
    public void clearChoices(){
        choices.clear();
    }

    @Override
    public int getChoicesSize() {
        return choices.size();
    }

    @Override
    public List<Integer> getPaperIdList() {
        return paperMapper.getPaperIdList();
    }

    @Override
    public boolean deletePaperInfo(int test_id) {
        return paperMapper.deletePaperInfo(test_id)>0;
    }
}
